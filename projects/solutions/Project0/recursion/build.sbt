///////////////////////////////////////////////////////
//  Revised build.sbt file for Project 0: recursion  //
//  Last updated Sat Feb 11 03:13:10 AM EST 2023     //
///////////////////////////////////////////////////////

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

name := "recursion"      // the name of the project
organization := "njit"   // our team or company
version := "0.0.1"       // current version of the project

// It's not necessary to define these three settings, unless we intend
// to publish our code or the compiled binary executable of our project
// somewhere, like Sonatype, for others to use.
//
// Want to use a published library in your project?
// You can define other libraries as dependencies in your build like this:

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.15" % Test

// Here, `libraryDependencies` is a set of libraries on which our project depends.
// By using `+=`, we're adding the scalatest library to the set of dependencies
// that sbt will go and fetch when it starts up.
//
// As a result, in any Scala file in our project, we can import classes,
// objects, etc., from the scalatest library with a regular import.
// (For examples, see the `*Suite.scala` files in the test directory.)
//
// TIP: To find the appopriate syntax required to add a dependency to our
// project (like "org.scalatest" %% "scalatest" % "3.2.15" in the example above)
// the following resources are helpful:
//
// +  Scaladex: https://index.scala-lang.org/scala
// +  MVN: https://mvnrepository.com/
// +  The SBT Reference Manual: https://www.scala-sbt.org/1.x/docs/
//
// For example, the line we use to add scalatest to our list of dependencies is found at
// https://www.scalatest.org/install and
// https://mvnrepository.com/artifact/org.scalatest/scalatest_3/3.2.15
// The mvnrepository page is found by entering "scalatest" in the search box at
// https://mvnrepository.com/
// then selecting the link 3.2.15, and then selecting the "sbt" tab.
// After we find the library we want, we just copy/paste the dependency 
// information into our build file.
//
// IMPORTANT NOTE: while build files look _kind of_ like regular Scala, it's
// important to note that syntax in *.sbt files doesn't always behave like
// regular Scala. For example, notice in this build file that it's not required
// to put our settings into an enclosing object or class. Always remember that
// sbt is a bit different, semantically, than vanilla Scala.
//
// ============================================================================
//
// Most moderately interesting Scala projects don't make use of the very simple
// build file style (called "bare style") used in this build.sbt file.
// Instead they use so-called "multi-project" builds, which makes it possible
// to have different folders that sbt can be configured differently for.
// That is, we may wish to have different dependencies or different testing
// frameworks defined for different parts of our codebase. Multi-project builds
// make this possible.
//
// Here's a quick glimpse of what a multi-project build looks like for this
// build, with only one "subproject" defined, called `root`:
//
// lazy val root = (project in file(".")).
//   settings(
//     inThisBuild(List(
//       organization := "njit",
//       scalaVersion := "2.13.8"
//     )),
//     name := "recursion"
//   )
//
// To learn more about multi-project builds, see the official sbt
// documentation at http://www.scala-sbt.org/documentation.html
