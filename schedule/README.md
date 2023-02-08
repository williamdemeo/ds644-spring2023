# DS 644: Introduction to Big Data (§102, §104)

## Course Syllabus and Schedule

-----

### Course Description

This course provides an in-depth coverage of various topics in big data from data generation, storage, management, transfer, to analytics, with focus on the state-of-the-art technologies, tools, architectures, and systems that constitute big-data computing solutions in high-performance networks. Real-life big-data applications and workflows in various domains (particularly in the sciences) are introduced as use cases to illustrate the development, deployment, and execution of a wide spectrum of emerging big-data solutions.

The first 1/4 of the course is devoted to the foundations of functional programming.  This includes an introduction to the Scala language, functional and object oriented data types, Scala collections, pure functions, referential transparency, and anonymous, higher-order, and recursive functions.

The middle 1/2 of the course is devoted to learning Spark. Students will learn Spark's approach to distributed data parallelism in the context of prior technologies like Hadoop and MapReduce.  In particular, we focus on the impact that data movement has on the computational complexity of big data analysis jobs.

The final 1/4 of the course is devoted to cloud computing. In this part, students will learn how to deploy their Scala/Spark programs in the cloud on platforms such as AWS, Databricks, and Azure.

### Learning Objectives

Upon completion, students will know

*  how to write functional programs using pure functions and immutable data types;
*  how to analyze large datasets using modern tools;
*  the factors that are most important to the success of a big data architecture/stack;
*  how to use big data architectures such as Spark and its ecosystem
*  the fundamental concepts, strategies and pitfalls of processing data at scale.


### Schedule

**Part 1. Scala**

| Week  |  HW Due   |     Topics                                                                     |  Readings      |
|-------|-----------|------------------------------------------------------------------------------------|-----------------|
|    1  |           | Introduction to Big Data; programming paradigms; history and evolution of Big Data; functional programming |        |
|    2  |  HW 1: 2/7 |  Functional data types, lists, functions on lists, higher-order functions, map, filter, currying  |                |
|    3  | Project 0: 2/17  |  The substitution model, evaluation strategies (CBV, CBN), termination, tail recursion, higher-order list functions, flatMap |   |
|    4  |  HW 2: 2/21      |  Evaluation and operators; class hierarchies; polymorphism; pattern matching; other collections  |           |

**Part 2. Spark**

| Week  |  HW Due   |     Topics                                                                     |  Readings      |
|-------|-----------|------------------------------------------------------------------------------------|-----------------|
|    5  |  Project 1: 3/3        | Distributed data parallelism, latency, RDDs, RDD transformations and actions  |   LS Ch 1, 2         |
|    6  |           | Spark's Structured APIs, evaluation in Spark; cluster topology; reduction operations; pair RDDs; transformations and actions on pair RDDs | LS Ch 3 |
|    7  |           | Joins, shuffling, partitioning, optimizing with partitioners |  LS Ch 7
|    8  |           |  Wide vs narrow dependencies, structured vs unstructureddata, SparkSQL | LS Ch 4 |
|    9  |           |  DataFramesSpark SQL | LS Ch 5 |
|   10  |           | Datasets    | LS Ch 6 |


**Part 3. Cloud**

| Week  |  HW Due   |     Topics                                                                     |  Readings      |
|-------|-----------|------------------------------------------------------------------------------------|-----------------|
|    11  |           | Obtaining, cleaning, and storing Data, Kaggle  |  |
|    12  |           | AWS, Databricks, Azure  | |
|    13  |           | TBA                         |  |
|    14  |           | TBA                          | |






<!-- Learning Spark 2nd Ed. Ch 1   Introduction to Apache Spark: -->
<!-- A Unified Analytics Engine -->
<!-- https://spark.apache.org/docs/latest/cluster overview.html -->
<!-- Google File System: -->
<!-- https://static.googleusercontent.com/media/research.google.com/en/ -->
<!-- /archive/gfs sosp2003.pdf -->
<!-- Topics: -->
<!-- Lecture 2 -->
<!-- 09/08/21 -->
<!-- ● -->
<!-- ● -->
<!-- Distributed File Systems and File Formats -->
<!-- Distributed Databases: Hbase/Accumulo, Cassandra -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- bigtable: A Distributed Storage System for Structured Data: -->
<!-- https://research.google/pubs/pub27898/ -->
<!-- https://hadoop.apache.org/docs/current/hadoop project dist/hadoop  -->
<!-- hdfs/HdfsDesign.html -->
<!-- Topics: -->
<!-- Lecture 3 -->
<!-- 09/15/21 -->
<!-- ● -->
<!-- ● -->
<!-- Map Reduce Design Patterns -->
<!-- Introduction to Cloud Computing -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- MapReduce: Simplified Data Processing on Large Clusters: -->
<!-- https://static.googleusercontent.com/media/research.google.com/en//ar -->
<!-- chive/mapreduce osdi04.pdf -->
<!-- https://en.wikipedia.org/wiki/MapReduceTopics: -->
<!-- Lecture 4 -->
<!-- 09/22/21 -->
<!-- ● -->
<!-- ● -->
<!-- Introduction to Apache Spark -->
<!-- Spark Resilient Distributed Dataset (RDD) -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 2   Downloading Apache Spark and -->
<!-- Getting Started -->
<!-- https://spark.apache.org/docs/latest/rdd programming guide.html -->
<!-- Topics: -->
<!-- Lecture 5 -->
<!-- 09/29/21 -->
<!-- ● -->
<!-- Spark Structured API Part 1 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 3   Apache Spark's Structured APIs -->
<!-- Learning Spark 2nd Ed. Ch 4   Spark SQL and DataFrames: -->
<!-- Introduction to Built in Data Sources -->
<!-- https://spark.apache.org/docs/latest/sql programming guide.html -->
<!-- Topics -->
<!-- Lecture 6 -->
<!-- 10/06/21 -->
<!-- ● -->
<!-- Spark Structured API Part 2 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 5   Spark SQL and DataFrames: -->
<!-- Interacting with External Data Sources -->
<!-- Learning Spark 2nd Ed. Ch 6   Spark SQL and Datasets -->
<!-- https://spark.apache.org/docs/latest/sql programming guide.html -->
<!-- * Virtual ClassTopics: -->
<!-- Lecture 7 -->
<!-- 10/13/21 -->
<!-- ● -->
<!-- Structured Streaming Part 1 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 8   Structured Streaming -->
<!-- https://spark.apache.org/docs/latest/structured streaming programm -->
<!-- ing guide.html -->
<!-- Topics: -->
<!-- Lecture 8 -->
<!-- 10/20/21 -->
<!-- ● -->
<!-- Structured Streaming Part 2 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 8   Structured Streaming -->
<!-- https://spark.apache.org/docs/latest/structured streaming programm -->
<!-- ing guide.html -->
<!-- Topics -->
<!-- Lecture 8 -->
<!-- 10/27/21 -->
<!-- ● -->
<!-- Advanced Analytics Part 1 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 10   Machine Learning with MLlib -->
<!-- http://spark.apache.org/docs/latest/ml guide.html -->
<!-- https://www.mlflow.org/docs/latest/index.htmlTopics -->
<!-- 11/03/21 -->
<!-- ● -->
<!-- Advanced Analytics Part 2 -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 11   Managing, Deploying, and Scaling -->
<!-- Machine Learning Pipelines with Apache Spark -->
<!-- http://spark.apache.org/docs/latest/ml guide.html -->
<!-- https://www.mlflow.org/docs/latest/index.html -->
<!-- Topics: -->
<!-- Lecture 9 -->
<!-- 11/10/21 -->
<!-- ● -->
<!-- Graph Processing -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- https://spark.apache.org/docs/latest/graphx programming guide.html -->
<!-- https://graphframes.github.io/graphframes/docs/_site/user guide.html -->
<!-- Topics: -->
<!-- Lecture 10 -->
<!-- 11/17/21 -->
<!-- ● -->
<!-- Delta Lake/Lake House -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 09   Building Reliable Data Lakes -->
<!-- with Apache Spark -->
<!-- https://docs.delta.io/latest/index.htmlTopics: -->
<!-- Lecture 11 -->
<!-- ● -->
<!-- 11/24/21 -->
<!-- Monitoring, Debugging, Performance Tuning -->
<!-- Readings: -->
<!-- ● -->
<!-- ● -->
<!-- Learning Spark 2nd Ed. Ch 7   Optimizing and Tuning Spark -->
<!-- Applications -->
<!-- https://spark.apache.org/docs/latest/sql performance tuning.html -->
<!-- NOTE: Virtual Class -->
<!-- Project Presentation 1 -->
<!-- Lecture 12 -->
<!-- Final Project Submission Due -->
<!-- 12/01/21 -->
<!-- Project Presentation 2 -->
<!-- Lecture 13 -->
<!-- 12/08/21 -->
<!-- Research Paper Submission Due (11:59:00 PM) -->
<!-- 12/22/21 -->
<!-- Materials -->
<!-- Required Reading: -->
<!-- Chambers, Bill, and Matei Zaharia. Spark: The Definitive Guide: Big Data Processing Made Simple. -->
<!-- O’Reilly Media, 2018. -->
<!-- Damji, Jules S., et al. Learning Spark: Lightning Fast Data Analytics 2nd Edition O’Reilly Media, -->
<!-- NOTE: Free download at: https://databricks.com/p/ebook/learning spark from oreilly, use your -->
<!-- UMBC email address.Grading Criteria -->
<!-- Course WorkGrade Weight -->
<!-- Homework25% -->
<!-- Participation/Attendance10% -->
<!-- Quizzes20% -->
<!-- Project25% -->
<!-- Technical Research Paper20% -->
<!-- Students are expected to participate in class and online discussions. You will get more out of the -->
<!-- class by contributing to it. -->
<!-- Post due homeworks: -->
<!-- ● -->
<!-- ● -->
<!-- 15% reduction each day after the submission -->
<!-- No grade will be given after 3 days of late submission -->
<!-- Final grade will computed as follows: -->
<!-- RangeLetter Grade -->
<!-- 100%   90%A -->
<!-- 89%   80%B -->
<!-- 79%   70%C -->
<!-- 69%   60%D -->
<!-- < 60%FPolicies -->
<!-- UMBC provides a range of writing assistance, which can be found in the following: -->
<!-- The Writing Center http://lrc.umbc.edu/tutor/writing center/ -->
<!-- Research Guides & Tutorials http://lib.guides.umbc.edu/tutorial -->
<!-- Failure to follow guidelines for each assignment, including the required format, style, length, -->
<!-- submission, etc., may result in at least one letter grade reduction on the paper depending on the -->
<!-- type and/or number of transgressions. -->
<!-- Late/Incomplete assignments will not be accepted unless an extension has been agreed to in -->
<!-- advance. Emergency situations will be handled on a case by case basis with appropriate justification -->
<!-- and/or documentation. -->
<!-- Incomplete grades will not be entertained unless extenuating circumstances warrant and your -->
<!-- request is made before the last week of class. -->
<!-- Academic Integrity -->
<!-- By enrolling in this course, each student assumes the responsibilities of an active participant in -->
<!-- UMBC’s scholarly community in which everyone’s academic work and behavior are held to the -->
<!-- highest standards of honesty. Cheating, fabrication, plagiarism, and helping others to commit these -->
<!-- acts are all forms of academic dishonesty, and they are wrong. Academic misconduct could result in -->
<!-- disciplinary action that may include, but is not limited to, failure, suspension or dismissal. -->
<!-- Refer to the UMBC policy at: -->
<!-- http://catalog.umbc.edu/content.php?catoid=14&navoid=718#academic integrity -->

























<!-- Introduction to Big Data Analytics and Hadoop Ecosystem (Pig, Hive, Spark) -->

<!-- Introduction to Databrick & Spark (Chapter 1 2) -->


<!-- Spark Streaming (Chapter 8) -->

<!-- Spark Data Lakes (Chapter 9) -->

<!-- Machine Learning with MLib (Chapter 10) -->

<!-- Spark MLib: Graph Analytics -->
<!-- Spark MLib: Deep Learning -->

