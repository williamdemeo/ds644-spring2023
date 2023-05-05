# DS 644: Introduction to Big Data


## Spark Setup Instructions

### Preliminaries

If any of the intructions on this page are unclear, please post a message on [Slack][].

We use [VSCode][] in this class.  However, if you are already comfortable with the IntelliJ IDE and you wish to use it instead of VSCode,  then the steps you must follow to setup Spark may differ from the ones below.  If you need help configuring IntelliJ for use with Scala, please contact the instructor as soon as possible, preferably in the first week or two of the semester.

### How to set up Spark


Please follow the link below that mentions your operating system. (If you intend to use an operating system other than Linux, Mac, or Windows, please ask the instructor whether it is okay asap!)

*  [Linux and Mac](mac-linux) (**Linux**: the preferred OS for Big Data; **Mac**: nearly as good, but not free/open-source.)

*  [Windows](windows) (Avoid, if possible.)

(**Note**. It is the opinion of your instructor that the Windows OS is sometimes useful, when there are no alternatives to choose from, for doing things like browsing the web, watching Netflix or YouTube, sending emails or texts, playing computer games, or maybe uploading a tik-tok video.  However, most serious scientists---or at least most of those scientists who know what it means to compute---do not use Windows.  Having said that, students are allowed to use Windows to (try to) complete the work in this class, but it is not recommended as your instructor will be less able to help you if you encounter problems.  And if you use Windows, you *will* encounter problems.  Please see the [Windows page](windows) for more information about using Windows in this class.)


-----------------

## Getting Data

The Movie Lens datasets `ml-100k.zip` and `ml-1m.zip` (and many others) can be downloaded from the following url:

https://files.grouplens.org/datasets/movielens/

Another excellent source of datasets is [Kaggle](https://www.kaggle.com/datasets/).

For example, the [American time use survey data](https://www.kaggle.com/datasets/bls/american-time-use-survey) used in Project 2 is available on Kaggle.

------------------------

## SparkContext vs SparkSession

https://sparkbyexamples.com/spark/sparksession-vs-sparkcontext/

---------------------------

## Spark examples from ds644 lectures

We will be borrowing some examples from Frank Kane's excellent course [Apache Spark with Scala--Hands On with Big Data!][].

To try the examples on your machine, please follow [Frank Kane's instructions][].

--------------------------------

## Running your standalone Spark program in the cloud

See the [examples/movies](examples/movies) tutorial.

[AWS EMR]: https://aws.amazon.com/emr/

[Scala Build Tool]: https://www.scala-sbt.org/

[sbt]: https://www.scala-sbt.org/


[Slack]: https://join.slack.com/t/ds644-bigdata/shared_invite/zt-1mriemcs6-kWEkz0rGCBNutfP79UWkLQ
[VSCode]: https://code.visualstudio.com
[Apache Spark with Scala--Hands On with Big Data!]: https://www.udemy.com/course/apache-spark-with-scala-hands-on-with-big-data/
[Frank Kane's instructions]: https://www.sundog-education.com/spark-scala/
