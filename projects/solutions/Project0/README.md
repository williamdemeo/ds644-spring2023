# DS 644: Introduction to Big Data

## Project 0: Scala setup and basic recursion

### Instructions

If you have not yet setup Scala with JDK 11 and VSCode, follow the instructions on our [Scala setup](../../scala) page.

Once you have submitted your solution on Gradescope, you should see your grade and a feedback about your code within 5 minutes. If you want to improve your grade, you may submit an improved solution. (If you have trouble resubmitting, please send a direct message to your instructor on [Slack][].)  **The best of your first 5 submissions will count as the final grade.**

You can still submit after the 5th time to get feedback on your improved solutions, however, these are for research purposes only and will not be counted towards your final grade.

### Mechanics

1.  Download the [recursion.zip][] archive file and extract it somewhere on your machine.

    **Hint**. (especially for Windows users) make sure your extraction utility program doesn't create an extra "recursion" directory when you unpack the `recursion.zip` file.  Some extractors will leave you with a directory structure like this:

    ```
    ./recursion/recursion/build.sbt
    ./recursion/recursion/src
    ./recursion/recursion/src/main
    .etc...
    ```

    whereas what we want is just this:

    ```
    ./recursion/build.sbt
    ./recursion/src
    ./recursion/src/main
    .etc...
    ```

    That is, you want just ONE subdirectory called "recursion", not two!

2.  Open VSCode and load the resulting project folder, called `recursion`, by selecting `File --> Open Folder`. The file explorer should open and you should locate the `recursion` folder you expanded in Step 1 above.  *Highlight the name of the folder and click the "Open" button.*

    **Hint**. Do not double click the `recursion` folder, as this will likely open that folder and you may end up loading a subdirectory of `recursion` into VSCode.

Complete the project by replacing the `???` symbols in the file `recursion/src/main/scala/recursion/Main.scala` with your own code that solves the given problems.

### Exercise 1: Parentheses Balancing

Write a recursive function that verifies the balancing of parentheses in a string, which we represent as a `List[Char]` (not a `String`). For example, the function should return true for the following strings:

```
(if (zero? x) max (/ 1 x))
```

```
I told him (that it's not (yet) done). (But he wasn't listening)
```

The function should return false for the following strings:

```
:­)
```

```
())(
```

The last example shows that it's not enough to verify that a string contains the same number of opening and closing parentheses.

Do this exercise by implementing the `balance` function in `Main.scala`. 
Its signature is as follows:

```scala
def balance(s: String): Boolean
```

#### Hints for Exercise 2

1.  Inside the definition of `balance`, define a recursive "helper" function which will do all the work. Call your helper function at the end of the definition of `balance`.

2.  Use the `toList` method of the `String` class to convert `s` to `List[Char]` type (syntax: `s.toList`).

3.  Use the following methods of the `List[Char]` class:
    * `s.isEmpty: Boolean` returns whether the list `s` is empty.
    * `s.head: Char` returns the first element of the list `s`.
    * `s.tail: List[Char]` returns the "tail" of the list `s` (i.e., all but the first element).

#### Test your code!

The file `src/test/scala/recursion/BalanceSuite.scala` contains code that runs some simple tests of your `balance` function.
Run these tests before submitting your `Main.scala` file to Gradescope.  To achieve more confidence in your solution, you may wish
to add some tests of your own to the `BalanceSuite.scala` file.


----------------------------------

### Exercise 2: Counting Change

Write a recursive function that counts how many different ways you can make change for an amount,
given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.

Do this exercise by implementing the `countChange` function in `Main.scala`. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:

```scala
def countChange(money: Int, coins: List[Int]): Int
```

You can make use of functions `isEmpty`, `head` and `tail` on the list of integers `coins`.

#### Hints for Exercise 2

Define a helper function inside the definition of `countChange`. Let's call it `countChangeAux` (`Aux` for "auxiliary"). 

The beginning of your function should look as follows (where `moneyLeft` is the balance at some stage in the algorithm, after we've used some coins and deducted them from money, and `coinsLeft` are what coins are left in the list):

  ```scala
  def countChange(money: Int, coins: List[Int]): Int = {

    def  countChangeAux(moneyLeft: Int, coinsLeft: List[Int]): Int = {

      ???  // (put your code here)

    }

    countChangeAux(money, coins)
  }
  ```

Just like the examples we did in class, the helper function does all the work, so we simply return the `countChangeAux(money, coins)` at the bottom of `countChange`.

To define `countChangeAux`, think of the two "degenerate" cases.

1.  How many ways can you give change if `moneyLeft == 0`?  Lets agree that there is exactly one way to do so (namely, give no change---exactly the right amount!).

2.  How many ways can you give change if `moneyLeft > 0`, and you have no coins (i.e., `coinsLeft.isEmpty`)?

The first two lines of `countChangeAux` will handle these cases, using `if (moneyLeft == 0) return ???` and `if (coinsLeft.isEmpty) return ???` (replace the `???`, of course).

Once you've handled the two degenerate cases, it's time to get recursive!

Assume we are not in the degenerate cases, so `moneyLeft > 0` and `coinsLeft` is nonempty.

Consider the coin denomination at the head of the `coinsLeft` list. Call this `d = coinsLeft.head`.

Now, split the number of ways to make change for `moneyLeft`, using `coinsLeft`, into two groups:

1. the ways to make change which use `d` and
2. the ways to make change without `d`, using only coins in `coinsLeft.tail`.

Finally, think about how to calculate the number of ways in group 1, using a recursive call to `countChangeAux`, and the number of ways in group 2, also using a recursive call, and return the sum of these.

*Final hint*. Remember that each `d` can be used more than once!

If you get stuck or have any questions, post on [Slack][].

#### Test your code!

The file `src/test/scala/recursion/CountChangeSuite.scala` contains code that runs some simple tests of your `countChange` function.
Run these tests before submitting your `Main.scala` file to Gradescope.  To achieve more confidence in your solution, you may wish
to add some tests of your own to the `CountChangeSuite.scala` file (though this is not required and your tests will not be graded---you will only submit the `Main.scala` file to Gradescope).


### How to Submit your Solutions

After you have tested your program and you are happy with the result, upload **only** your modified `Main.scala` file to Gradescope for the assignment called "Project 0".

Use the Gradescope link for the section in which you are registered:

+ [§ 102 (Monday) Gradescope][]   -- **Entry Code**. 57268Y
+ [§ 104 (Wednesday) Gradescope][] -- **Entry Code**. ZZKG7Z

*Do not upload any other files for this assignment!  Only upload your modified `Main.scala` file.*

[recursion.zip]: recursion.zip
[§ 102 (Monday) Gradescope]: https://www.gradescope.com/courses/485519
[§ 104 (Wednesday) Gradescope]: https://www.gradescope.com/courses/485522
[Slack]: https://join.slack.com/t/ds644-bigdata/shared_invite/zt-1mriemcs6-kWEkz0rGCBNutfP79UWkLQ
