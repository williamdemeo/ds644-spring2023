# DS 644: Introduction to Big Data

## Project 1: Functional Sets and Object Oriented Sets

### Instructions

Attention: For grading purposes, you are allowed to submit a maximum of 5 times!

Once you have submitted your solution, you should see your grade and a feedback about your code on the Gradescope website within 10 minutes. If you want to improve your grade, just submit an improved solution. The best of all your first 5 submissions will count as the final grade.

You can still submit after the 5th time to get feedback on your improved solutions, however, these are for research purposes only, and will not be counted towards your final grade.

In this assignment, you will work with a functional and object oriented representations of sets based on the mathematical notion of characteristic functions. The goal is to gain practice with higher­order functions and object oriented programming in Scala.

### Part 1. Functional Sets

Download the [functional-sets.zip][] archive file and extract it somewhere on your machine. Write your solutions by completing the stubs (marked with the `???` symbol) in the `FunctionalSets.scala` file.

Write your own tests! For this assignment, we don't give you tests but instead the `FunctionalSetsSuite.scala` file contains hints on how to write your own tests for the assignment.

#### Representation

We will work with sets of integers. As an example to motivate our representation, how would you represent the set of all negative integers?

You cannot list them all… one way would be so say, "if you give me an integer, I can tell you whether it's in the set or not: for 3, I say 'no'; for ­1, I say 'yes'."

Mathematically, we call the function which takes an integer as argument and which returns a boolean, indicating whether the given integer belongs to a set, the **indicator function** (or "characteristic function") of that set.

For example, we can characterize the set of negative integers by the indicator function 

```scala
(x: Int) => x < 0
```

Therefore, we choose to represent a set by its indicator function and define a **type alias** for this representation, as follows:

```scala
type Set = Int => Boolean
```

Using this representation, we define a function that tests for the presence of a value in a set:

```scala
def contains(s: Set, elem: Int): Boolean = s(elem)
```

#### Basic Functions on Sets

Let's start by implementing basic functions on sets.

1.  Define a function that creates a singleton set from one integer value: 
    the set represents the set of that one given element. Its signature is as follows:

    ```scala
    def singletonSet(elem: Int): Set
    ```

    Now that we have a way to create singleton sets, we want to define a function that 
    allow us to build bigger sets from smaller ones.

2.  Define the functions `union`, `intersect`, and `diff`, which takes two sets, and return,
    respectively, their union, intersection and set-theoretic differences, `diff(s, t)`, which 
    returns a set containing the elements of `s` that are not in `t`.

    These functions have the following signatures:

    ```scala
    def union(s: Set, t: Set): Set
    ```

    ```scala
    def intersect(s: Set, t: Set): Set
    ```

    ```
    def diff(s: Set, t: Set): Set
    ```

3.  Define the function `filter` which selects only the elements of a set that are accepted
    by a given predicate `p`. The filtered elements are returned as a new set. The signature 
    of `filter` is

    ```scala
    def filter(s: Set, p: Int => Boolean): Set
    ```

#### Queries and Transformations on Sets

In this part, we are interested in functions used to make requests on elements of a set.
The first function tests whether a given predicate is true for all elements of the set. 
This `forall` function has the following signature:

```scala
def forall(s: Set, p: Int => Boolean): Boolean
```

Note that there is no direct way to find which elements are in a set. The `contains` function
only allows us to know whether a *given* element is included in the set. Thus, if we wish to
do something to all elements of a set, then we have to iterate over all integers, testing
each time whether it is included in the set, and if so, to do something with it.

Here, we must limit the search space so that our program can finish computing its result in finite time, so we consider only integers `x` in the range [-1000, 1000]; that is, with the property `­1000 <= x <= 1000`.

1.  Implement `forall` using linear recursion. For this, use a helper function nested in `forall`.
    Its structure is as follows (replace the `???`):

    ```scala
    def forall(s: Set, p: Int => Boolean): Boolean = {
      def iter(a: Int): Boolean = {
        if (???) ???
        else if (???) ???
        else iter(???)
      }
      iter(???)
    }
    ```

2.  Using `forall`, implement a function `exists` which tests whether a set contains at least
    one element for which a given predicate is true.

    Note that the functions `forall` and `exists` behave like the universal and existential
    quantifiers of first-order logic.

    Here is the signature of `exists`.

    ```scala
    def exists(s: Set, p: Int => Boolean): Boolean
    ```

3.  Finally, write a function `map` which takes a set, `X`, and a function `f`, and 
    transforms `X` into another set by applying `f` to each element of `X`.

    Here is the signature of `map`.

    ```scala
    def map(s: Set, f: Int => Int): Set
    ```


### Part 2. Object­Oriented Sets

Download the [oo-sets.zip][] archive file, unpack it somewhere on your computer and import the resulting project directory into VS Code.

#### Representation

In this second part of the project, we will work with an *object­oriented* representations of sets based on binary trees. Students will earn credit by completing the `src/main/scala/oo-sets/TweetSet.scala` file. This file defines an abstract class `TweetSet` with two concrete subclasses, `Empty` which represents an empty set, and

```scala
NonEmpty(elem: Tweet, left: TweetSet, right: TweetSet)
```

which represents a non­empty set as a binary tree rooted at `elem`.

The tweets are indexed by their text bodies: the bodies of all tweets on the left are lexicographically smaller than `elem` and all bodies of elements on the right are lexicographically greater.

Note also that these classes are immutable: the set­theoretic operations do not modify this but should return a new set.

Before tackling this part of the assignment, we suggest you first study the already implemented methods `contains` and `incl` for inspiration.

#### Filtering

Implement filtering on tweet sets. Complete the stubs for the methods `filter` and `filterAcc` by replacing the `???` symbols with your code.

`filter` takes two arguments: 1) a function and 2) a predicate which takes a tweet and returns a boolean.  `filter` returns the subset of all the tweets in the original set for which the predicate is true.

For example, the following call:

```scala
tweets.filter(tweet => tweet.retweets > 10)
```

applied to a set `tweets` consisting of two tweets, say, where the first tweet was not retweeted and the second tweet was retweeted 20 times, should return a set containing only the second tweet.

**Hint**. start by defining the helper method `filterAcc` which takes an accumulator set as a second argument. This accumulator accumulates the successive results of the filtering as you recurse through the dwindling collection of tweets.

```scala
/** This method takes a predicate and returns a subset of all the elements
* in the original set for which the predicate is true.
*/
def filter(p: Tweet => Boolean): TweetSet = {

  def filterAcc(acc: TweetSet): TweetSet = {
    ???
  }

  filterAcc(???)

}
```

The definition of `filter` in terms of `filterAcc` should then be straightforward.

#### Taking Unions

Implement `union` on tweet sets by replacing the `???` symbols in the stub for the method `union`.

The method `union` takes another set called `that`, and computes a new set which is the union of `this` and `that`, i.e. a set that contains exactly the elements that are either in the current object of the `TweetSet` class or in the other (`that`) object, or in both.

```scala
def union(that: TweetSet): TweetSet
```

Note that in this exercise it is your task to find out in which class(es) to define the union method (should it be abstract in `class TweetSet`?).

#### Sorting Tweets by Their Influence

The more often a tweet is "re-tweeted" (that is, repeated by a different user with or without additions), the more influential it is.

The goal of this part of the exercise is to add a method `descendingByRetweet` to `TweetSet` which
should produce a linear sequence of tweets (as an instance of `class TweetList`), ordered by their
number of retweets:

```scala
def descendingByRetweet: TweetList
```

This method reflects a common pattern when transforming data structures. While traversing one data
structure (in this case, a `TweetSet`), we're building a second data structure (here, an instance of `class TweetList`). The idea is to start with the empty list `Nil` (containing no tweets), and to find the tweet with the most retweets in the input `TweetSet`. This tweet is removed from the `TweetSet` (that is, we obtain a new `TweetSet` that has all the tweets of the original set except for the tweet that was "removed"; this immutable set operation, remove, is already implemented for you), and added to the result list by creating a new `Cons`. After that, the process repeats itself, but now we are searching through a `TweetSet` with one less tweet.

**Hint**. start by implementing the method `mostRetweeted` which returns the most popular tweet of a `TweetSet`.

#### Tying everything together

In the last step of this assignment your task is to detect influential tweets in a set of recent tweets.

We provide you with a `TweetSet` containing several hundred tweets from popular tech news sites in
the past few days, located in the `TweetReader` object (file `TweetReader.scala`).

`TweetReader.allTweets` returns an instance of `TweetSet` containing a set of all available tweets. Furthermore, you are given two lists of keywords. The first list corresponds to keywords associated with Google and Android smartphones, while the second list corresponds to keywords associated with Apple and iOS devices. Your objective is to detect which platform has generated more interest or activity in the past few days.

As a first step, use the functionality you implemented in the first parts of this assignment to create two different `TweetSets`, `googleTweets` and `appleTweets`. The first `TweetSet`, `googleTweets`, should contain all tweets that mention (in their "text") one of the keywords in the google list. The second `TweetSet`, `appleTweets`, should contain all tweets that mention one of the keyword in the apple list.

Their signature is as follows:

```scala
lazy val googleTweets: TweetSet
lazy val appleTweets: TweetSet
```

**Hint**. use the `exists` method of `List` and `contains` method of `class java.lang.String`.
From the union of those two `TweetSets`, produce trending, an instance of `class TweetList`
representing a sequence of tweets ordered by their number of retweets:

```scala
lazy val trending: TweetList
```

### Extra Hints

*  Be attentive in the lecture discussions about how to write anonymous functions in Scala.

*  Sets are represented as functions. Think about what it means for an element to belong to
   a set, in terms of function evaluation. For example, how do you represent a set that
   contains all numbers between 1 and 100?

*  Most of the solutions for this assignment can be written as one-liners. If you have more,
   you probably need to rethink your solution. In other words, this assignment probably requires
   more thinking (whiteboard, pen and paper) than coding.

*  If you are having some trouble with terminology, have a look at the [glossary][].


### How to Submit your Solutions

After you have tested your program and you are happy with the result, upload your modified versions of the following files to Gradescope for the assignment called "Project 1":

*  `FunctionalSets.scala`
*  `TweetSet.scala`
*  `TweetReader.scala`

[functional-sets.zip]: functional-sets.zip
[oo-sets.zip]: oo-sets.zip
[glossary]: http://docs.scala-lang.org/glossary/

