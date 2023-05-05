// The simplest possible sbt build file is just one line:

scalaVersion := "2.13.8"

// That is, to create a valid sbt build, all you've got to do is define the
// version of Scala you'd like your project to use.
//
// ============================================================================
//
// Lines like the above defining `scalaVersion` are called "settings". Settings
// are key/value pairs. In the case of `scalaVersion`, the key is "scalaVersion"
// and the value is "2.13.8"
//
// It's possible to define many kinds of settings, such as:

name := "funsets"       // the name of the project
organization := "edu.njit"   // our team or company
version := "0.0.1"       // current version of the project

// It's not necessary to define these three settings, unless we intend
// to publish our code or the compiled binary executable of our project
// somewhere, like Sonatype, for others to use.
//
// This sets it up so all tests that end in "Tester" will be run when you run sbt test
// and all tests that end in "Grader" will run when you run stb Grader / test
lazy val scalatest = "org.scalatest" %% "scalatest" % "3.2.15"

// https://mvnrepository.com/artifact/junit/junit
// For running the gradescope tests
lazy val junit = "junit" % "junit" % "4.12"

// https://mvnrepository.com/artifact/net.fornwall.jelf/jelf
// For understanding elfs and directly running binary files
lazy val jelf = "net.fornwall.jelf" % "jelf" % "0.4.1"


lazy val Grader = config("grader") extend(Test)

lazy val depProject = RootProject(uri("git://github.com/ucsb-gradescope-tools/jh61b.git"))

// Library dependencies
lazy val myProject = Project("funsets", file("."))
    .dependsOn(depProject)
    .settings(
        libraryDependencies += scalatest % Test,
        libraryDependencies += scalatest % Grader
    )

/* lazy val root = (project in file("."))
  .configs(TestAll).configs(Grader).configs(Lab1)
  .dependsOn(depProject)
  .settings(
    inConfig(Grader)(Defaults.testTasks),
    inConfig(TestAll)(Defaults.testTasks),
    inConfig(Lab1)(Defaults.testTasks),
    libraryDependencies += scalatest % Test,
    libraryDependencies += scalatest % TestAll,
    libraryDependencies += scalatest % Grader,
    libraryDependencies += scalatest % Lab1
    )
 *//*     ,
    testOptions in TestAll := Seq(Tests.Filter(allFilter)),
    // CHANGE THE LINE BELOW FOR EACH LAB!!!! Use the matching filter
    testOptions in Test := Seq(Tests.Filter(allFilter)),
    testOptions in Grader := Seq(Tests.Filter(graderFilter)),
    testOptions in Lab1 := Seq(Tests.Filter(lab1Filter))
  )
 */