# DS 644: Introduction to Big Data

## Quiz: your first Spark program

**Goal**. Write a spark program that reads in the social network data from the file `fakefriends.csv` 
and computes the average number of friends *by age*.  The final result should be key-value pairs where
each key `k` is an integer, representing an age, and the value `v` paired with `k` is a double that
is the average number of friends people of age `k` have.

**Instructions**.

1.  Download and unzip **one** of the following zip files:

    -  [friends-friends.zip](friends-friends.zip)---expands to a directory called `friends` that contains the `build.sbt` file and the `src` directory. (This is the usual way we use zip files, as in all the project.)

    -  [friends.zip](friends.zip)---expands to just the `build.sbt` file and the `src` directory (for users whose unzip program subversively creates an extraneous `friends` directory and places the contents of `friends.zip` inside that directory; such a user would end up with a `friends/friends` directory if they used the `friends-friends.zip` file).

2.  Open the `friends` folder in VSCode and replace each `???` in the `FriendsByAge.scala` file with the correct Scala/Spark code.

3.  The `FriendsByAge` object has a `main` method, so you can run it.  Run the program by clicking on the `run`  link just above the line `object FriendsByAge`.  (If you don't see a `run` link, it means your program has errors.)

4.  Once you can run your program without errors and the results look good to you, submit the `FriendsByAge.scala` file to Gradescope.


