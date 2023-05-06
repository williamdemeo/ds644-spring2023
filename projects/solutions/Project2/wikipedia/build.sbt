name := "wikipedia"

scalaVersion := "2.13.9"

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % "3.3.1",
  // "org.apache.spark" %% "spark-sql" % "3.3.1",
  // "junit" % "junit" % "4.10" % Test,
  //"org.scalatest" %% "scalatest" % "3.2.2" % Test,
  "org.scalameta" %% "munit" % "0.7.16" % Test
)
