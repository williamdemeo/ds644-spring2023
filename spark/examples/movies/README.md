# examples/movies Spark tutorial 

From this tutorial you will learn how to package up a Spark program as a jar file and deploy it in the cloud on an AWS EMR Spark cluster.

**Contents**

- [Prerequisites](#prerequisites)
- [Motivation](#motivation)
- [Step 1: set up a simple Spark project](#step-1-set-up-a-simple-spark-project)
- [Step 2: build a jar file](#step-2-build-a-jar-file)
- [Step 3: test the program locally](#step-3-test-the-program-locally)
- [Step 4: deploy the program on an AWS cluster](#step-4-deploy-the-program-on-an-aws-cluster)

<!-- markdown-toc end -->

## Prerequisites

You will need...

-  [X] [Scala build tool (sbt)][sbt] ([download link][sbt-1.8.2.zip ]);
-  [X] [Spark 2.4.8][] ([download link][spark-2.4.8-bin-hadoop2.7.tgz]);
-  [X] [Open JDK 8][], ([download link][openjdk8]);
-  [X] a way to create directories and plain text files on your computer.

If for some reason the [Spark 2.4.8 download link][spark-2.4.8-bin-hadoop2.7.tgz] doesn't work, go to 
https://spark.apache.org/downloads.html, find the file `spark-2.4.8-bin-hadoop2.7.tgz` in the [Spark release archives][] and extract it.

```
mkdir -p ~/opt
# ............ download/extract sbt .................
mkdir -p ~/opt/SBT
cd ~/opt/SBT
wget https://github.com/sbt/sbt/releases/download/v1.8.2/sbt-1.8.2.zip 
unzip sbt-1.8.2.zip
# ............ download/extract spark .................
mkdir -p ~/opt/SPARK
cd ~/opt/SPARK
wget https://archive.apache.org/dist/spark/spark-2.4.8/spark-2.4.8-bin-hadoop2.7.tgz
tar xvzf spark-2.4.8-bin-hadoop2.7.tgz
```

**Note**. The commands below install [Open JDK 8][] on **Linux**.  Other operating systems (e.g., Mac, Windows) require a different 
jdk binary (e.g., [OpenJDK8U-jdk_x64_mac_hotspot_8u362b09.pkg][], [OpenJDK8U-jdk_x64_windows_hotspot_8u362b09.zip][]). For other installation candidates, visit [github.com/adoptium/../jdk8u362-b09][github.com/adoptium].

```
# ............ download/extract openjdk8 .................
mkdir -p ~/opt/JAVA
cd ~/opt/JAVA
wget https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u362-b09/OpenJDK8U-jdk_x64_linux_hotspot_8u362b09.tar.gz
tar xvzf OpenJDK8U-jdk_x64_linux_hotspot_8u362b09.tar.gz
```

Finally, we should set the environment variable `JAVA_HOME` to `~/opt/JAVA/jdk8u362-b09` and make sure `~/opt/JAVA/jdk8u362-b09/bin` is in our PATH.

```
export JAVA_HOME = $HOME/opt/JAVA/jdk8u362-b09
export PATH = $HOME/opt/JAVA/jdk8u362-b09/bin:$PATH
```


----------------------------------

## Motivation

After learning how to write Spark programs that run in the IDE, it is essential that we learn how to package up and deploy 
our programs so they run independently of an IDE, say, on an [Amazon Web Services (AWS) Elastic Map Reduce (EMR)][AWS EMR] 
cluster.

The steps described below demonstrate how to build a stand-alone Spark program on a Linux machine.
If you're not using Linux, it should be easy to infer the analogous steps for your architecture.

In the [next section](#step-1-set-up-a-simple-spark-project) we set up a small Spark project. 
[After that](#step-2-building-a-jar-file) we demonstrate how to create a jar file containing the main program of our example project. 
In the [last section](#step-3-test-the-spark-program-locally) we show how to deploy the example in the cloud by sending the jar 
file to an AWS instance and running it.


## Step 1: set up a simple Spark project

In this next section, we set up a small Spark project.

1. **Create a new project directory**.

   ```
   mkdir ~/movies
   ```
   
2. **Create a standard Scala/Spark project directory tree**. 

   ```
   cd ~/movies
   mkdir project
   mkdir src
   mkdir src/main
   mkdir src/main/scala
   ```

3. **Create the build.sbt file**.

   The file `~/movies/build.sbt` should contain

   ```
   name := "movies"

   version := "1.0.0"

   scalaVersion := "2.12.17"

   libraryDependencies ++= Seq(
     "org.apache.spark" %% "spark-core" % "2.4.8" % "provided"
   )
   ```

4. **Create the Main object**.

   The file `~/movies/src/main/scala/Main.scala` should contain

   ```        
   import org.apache.spark.SparkContext
   object Main {
     def main(args: Array[String]): Unit = {
       val sc = new SparkContext("local[*]", "RatingsCounter")
       val lines = sc.textFile("ml-1m/ratings.dat")
       val ratings = lines.map(x => x.split("::")(2))  // RDD[String] (just ratings column)
                          .countByValue()              // Map[String,Long]
                          .toSeq.sortBy(_._1)          // Seq[(String, Long)]
       ratings.foreach(println)
     }
   }
   ```

5. **Get the data**.

   Download the [ml-1m.zip][] dataset from the [movielens][] site and extract it into the main project directory.
   
   ```
   cd ~/movies
   wget https://files.grouplens.org/datasets/movielens/ml-1m.zip
   unzip ml-1m.zip
   rm ml-1m.zip
   ```



--------------------------------

## Step 2: build a jar file

 In this section, we create a jar file containing the main program of the example above. 

1. **Create the assembly.sbt file**.

   The file `~/movies/project/assembly.sbt` should contain

   ```scala
   addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.10")
   ```
   
2. **Assemble the jar**.

   Invoke the command `sbt assembly` from the main `~/movies` project directory.
   
   ```
   cd ~/movies
   ~/opt/SBT/sbt assembly
   ```

   This creates a file called `~/movies/target/scala-2.12/movies-assembly-1.0.0.jar`.
   
   Let's move the jar file up to the main project directory.

   ```shell
   mv movies/{target/scala-2.12/,}movies-assembly-1.0.0.jar
   ```

   The `movies-assembly-1.0.0.jar` file contains everything needed to run our Spark program at 
   the command line of a remote server, as we show in the coming sections.

--------------------------------

## Step 3: test the program locally

Here we assume you already downloaded and extracted Spark 2.4.8 (e.g., [spark-2.4.8-bin-hadoop2.7.tgz][]).

If you extracted the Spark tgz file in the `SPARK_HOME` directory (e.g., `SPARK_HOME = ~/spark-2.4.8-bin-hadoop2.7`), 
then you can test the jar file you built above as follows:
    
```
~/spark-2.4.8-bin-hadoop2.7/bin/spark-submit --executor-memory 1g movies-assembly-1.0.0.jar
```
    
If the job is successful, you should see lots of log messages, such as

something like the following in the terminal window:

```
23/04/05 02:37:34 WARN Utils: Your hostname, alonzo resolves to a loopback address: 127.0.0.2; using 192.168.1.200 instead (on interface wlp0s20f3)
23/04/05 02:37:34 WARN Utils: Set SPARK_LOCAL_IP if you need to bind to another address
23/04/05 02:37:34 WARN NativeCodeLoader: Unable to load native-hadoop library for your platform... using builtin-java classes where applicable
Using Spark's default log4j profile: org/apache/spark/log4j-defaults.properties
23/04/05 02:37:34 INFO SparkContext: Running Spark version 2.4.8
23/04/05 02:37:34 INFO SparkContext: Submitted application: RatingsCounter
23/04/05 02:37:34 INFO SecurityManager: Changing view acls to: williamdemeo
... <output abridged> ...
```

Then Spark will compute the number of 1, 2, 3, 4, and 5 star movie ratings, as pairs `(rating, number)`.following output.

```
(1,56174)
(2,107557)
(3,261197)
(4,348971)
(5,226310)
```

-------------------------------

## Step 4: deploy the program on an AWS cluster

In this section we show how to deploy the jar file we created above in the cloud by sending it to an AWS instance and running it.

### Sign up for an AWS account

https://docs.aws.amazon.com/emr/latest/ManagementGuide/emr-connect-ssh-prereqs.html


By default, Spark on an EMR cluster is configured to load data files from the
`/user/hadoop/` directory on the master cluster, so we need to create that directory
and place the `ratings.dat` file in there.

```
mkdir /user/hadoop
cp ratings.dat /usr/hadoop
```

<!-- ter (e.g., `hdfs://ip-172-31-27-212.us-west-1.compute.internal:8020/user/hadoop/`/user/hadoop/ -->

<!-- ssh -i ~/aws_id_rsa.pem hadoop@ec2-54-219-61-238.us-west-1.compute.amazonaws.com -->


```
$ ssh -i ~/.ssh/aws_id_rsa.pem hadoop@ec2-54-219-61-238.us-west-1.compute.amazonaws.com
Warning: Identity file /home/williamdemeo/aws_id_rsa.pem not accessible: No such file or directory.
The authenticity of host 'ec2-54-219-61-238.us-west-1.compute.amazonaws.com (54.219.61.238)' can't be established.
ED25519 key fingerprint is SHA256:crH3DmHJuyqTCh9DvCpMPiTCod6bv+V4CbFogOSKgs0.
This key is not known by any other names
Are you sure you want to continue connecting (yes/no/[fingerprint])? yes
Warning: Permanently added 'ec2-54-219-61-238.us-west-1.compute.amazonaws.com' (ED25519) to the list of known hosts.
Last login: Wed Dec 14 04:48:35 2022

       __|  __|_  )
       _|  (     /   Amazon Linux 2 AMI
      ___|\___|___|

https://aws.amazon.com/amazon-linux-2/
24 package(s) needed for security, out of 46 available
Run "sudo yum update" to apply all updates.

EEEEEEEEEEEEEEEEEEEE MMMMMMMM           MMMMMMMM RRRRRRRRRRRRRRR
E::::::::::::::::::E M:::::::M         M:::::::M R::::::::::::::R
EE:::::EEEEEEEEE:::E M::::::::M       M::::::::M R:::::RRRRRR:::::R
  E::::E       EEEEE M:::::::::M     M:::::::::M RR::::R      R::::R
  E::::E             M::::::M:::M   M:::M::::::M   R:::R      R::::R
  E:::::EEEEEEEEEE   M:::::M M:::M M:::M M:::::M   R:::RRRRRR:::::R
  E::::::::::::::E   M:::::M  M:::M:::M  M:::::M   R:::::::::::RR
  E:::::EEEEEEEEEE   M:::::M   M:::::M   M:::::M   R:::RRRRRR::::R
  E::::E             M:::::M    M:::M    M:::::M   R:::R      R::::R
  E::::E       EEEEE M:::::M     MMM     M:::::M   R:::R      R::::R
EE:::::EEEEEEEE::::E M:::::M             M:::::M   R:::R      R::::R
E::::::::::::::::::E M:::::M             M:::::M RR::::R      R::::R
EEEEEEEEEEEEEEEEEEEE MMMMMMM             MMMMMMM RRRRRRR      RRRRRR

[hadoop@ip-172-31-27-212 ~]$
```

--------------------------------


## Appendix: more details

### Why Spark version 2.4.8?

The `build.sbt` file described above prescribes **version 2.4.8** of Spark.
There is a good reason for this.  We happen to know that 2.4.8 is the version 
of Spark available on AWS.  So, the appropriate local environment for testing 
code that will be deployed on AWS should obviously have 
[Spark version 2.4.8][Spark 2.4.8].  You can download this version of Spark 
from [here][Spark 2.4.8].
    
(If the [Spark 2.4.8 download link][Spark 2.4.8] doesn't work for you, go to 
https://spark.apache.org/downloads.html and find the [Spark release archives][].)

### Where is the Spark project source code?

If you are too lazy to take the steps above to create the small example Spark project, you can download and unzip the [movies.zip](movies.zip) file. 

Then build the `movies-assembly-1.0.0.jar` file by opening a terminal, changing to the `movies` project directory, and invoking the command `sbt assembly`.

This creates a file called `movies-assembly-1.0.0.jar` inside the `target/scala-2.12` subdirectory 
of the main `movies` project directory.
    
### Where do I get the data?

The datafile needed for our small example is `u.Download the movielens 1m dataset ([ml-1m.zip](https://files.grouplens.org/datasets/movielens/ml-1m.zip))
    which our Spark program will analyze.  You can download [ml-1m.zip](https://files.grouplens.org/datasets/movielens/ml-1m.zip) from 
    [here](https://files.grouplens.org/datasets/movielens/ml-1m.zip).

    (If the movielens dataset link doesn't work for you, go to https://grouplens.org/datasets/movielens/ and find the ml-1m.zip 
    file on that page.)

    Unzip the ml-1m.zip file and put the `movies.dat` and `ratings.dat` files in the same directory as you put 
    the `MovieSimilarity-assembly-1.0.jar` file in step 1 above (e.g., the main project directory). (It doesn't really matter where you put
    the files, as long as all three of them are in the same directory.)

## Step 3: test the Spark program locally



[AWS EMR]: https://aws.amazon.com/emr/
[sbt]: https://www.scala-sbt.org/
[sbt-1.8.2.zip]: https://github.com/sbt/sbt/releases/download/v1.8.2/sbt-1.8.2.zip 
[sbt download page]: https://www.scala-sbt.org/download.html
[Slack]: https://join.slack.com/t/ds644-bigdata/shared_invite/zt-1mriemcs6-kWEkz0rGCBNutfP79UWkLQ
[VSCode]: https://code.visualstudio.com
[Apache Spark with Scala--Hands On with Big Data!]: https://www.udemy.com/course/apache-spark-with-scala-hands-on-with-big-data/
[Frank Kane's instructions]: https://www.sundog-education.com/spark-scala/
[Spark 2.4.8]: https://archive.apache.org/dist/spark/spark-2.4.8/
[spark-2.4.8-bin-hadoop2.7.tgz]: https://archive.apache.org/dist/spark/spark-2.4.8/spark-2.4.8-bin-hadoop2.7.tgz
[Spark release archives]: https://archive.apache.org/dist/spark/
[AWS: create a Spark cluster]: https://docs.aws.amazon.com/emr/latest/ReleaseGuide/emr-spark-launch.html
[movielens]: https://files.grouplens.org/datasets/movielens
[ml-1m.zip]: https://files.grouplens.org/datasets/movielens/ml-1m.zip
[nixos.wiki/Java]: https://nixos.wiki/wiki/Java
[openjdk8]: https://adoptium.net/temurin/releases/?version=8
[OpenJDK8U-jdk_x64_mac_hotspot_8u362b09.pkg]: https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u362-b09/OpenJDK8U-jdk_x64_mac_hotspot_8u362b09.pkg
[github.com/adoptium]: https://github.com/adoptium/temurin8-binaries/releases/tag/jdk8u362-b09
[OpenJDK8U-jdk_x64_windows_hotspot_8u362b09.zip]: https://github.com/adoptium/temurin8-binaries/releases/download/jdk8u362-b09/OpenJDK8U-jdk_x64_windows_hotspot_8u362b09.zip
[Open JDK 8]: https://openjdk.org/projects/jdk8/
