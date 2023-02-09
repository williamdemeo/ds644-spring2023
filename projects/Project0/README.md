# DS 644: Introduction to Big Data

## Project 0: Scala setup and basic recursion

### Instructions

Attention: For grading purposes, you are allowed to submit a maximum of 5 times!

Once you have submitted your solution, you should see your grade and a feedback about your code on the Gradescope website within 10 minutes. If you want to improve your grade, just submit an improved solution. The best of all your first 5 submissions will count as the final grade.

You can still submit after the 5th time to get feedbacks on your improved solutions, however, these are for research purposes only, and will not be counted towards your final grade.

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
def balance(chars: List[Char]): Boolean
```

There are three methods on `List[Char]` that are useful for this exercise:

1.  `chars.isEmpty: Boolean` returns whether a list is empty
2.  `chars.head: Char` returns the first element of the list
3.  `chars.tail: List[Char]` returns the list without the first element

**Hint**. You can define an inner function if you need to pass extra parameters to your function.

**Testing**. You can use the `toList` method to convert from a `String` to a `List[Char]`: e.g., 

```scala
"(just an) example".toList
```

### Exercise 2: Counting Change

Write a recursive function that counts how many different ways you can make change for an amount,
given a list of coin denominations. For example, there are 3 ways to give change for 4 if you have coins with denomiation 1 and 2: 1+1+1+1, 1+1+2, 2+2.

Do this exercise by implementing the `countChange` function in `Main.scala`. This function takes an amount to change, and a list of unique denominations for the coins. Its signature is as follows:

```scala
def countChange(money: Int, coins: List[Int]): Int
```

You can make use of functions `isEmpty`, `head` and `tail` on the list of integers `coins`.

**Hint**. Think of the degenerate cases. How many ways can you give change for 0 CHF? How many ways can you give change for >0 CHF, if you have no coins?


### How to Submit your Solutions

After you have tested your program and you are happy with the result, upload **only** your modified `Main.scala` file to Gradescope for the assignment called "Project 0".

*Do not upload any other files for this assignment!  Only upload your modified `Main.scala` file.*

[recursion.zip]: recursion.zip
