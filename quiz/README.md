# DS 644: Introduction to Big Data

## Quiz: your first Spark program

**Goal**. Write a spark program that reads in the social network data from the file `fakefriends.csv` 
and computes the average number of friends *by age*.  The final result should be key-value pairs where
each key `k` is an integer, representing an age, and the value `v` paired with `k` is a double that
is the average number of friends people of age `k` have.

**Instructions**.

1.  Download and unzip **one** of the following zip files:

    -  [friends-friends.zip](friends-friends.zip)---expands to a directory called `friends` that contains the `build.sbt` file and the `src` directory. (This is the usual way we use zip files, as in all the projects.)

    -  [friends.zip](friends.zip)---expands to just the `build.sbt` file and the `src` directory (for users whose unzip program creates an extraneous `friends` directory and places the contents of `friends.zip` inside that directory; such a user would end up with a `friends/friends` directory if they used the `friends-friends.zip` file).

2.  Load the project into VSCode by selecting "Open Folder" from the VSCode menu and selecting the `friends` folder that you just unzipped.

    If you prefer IntelliJ, select "Open" from the File menu, navigate to the `friends` folder you just unzipped, and double-click the `build.sbt` file.
    You should be asked whether you want to "Open as a project." Select "Yes."

3.  Edit the main file `src/main/scala/friends/FriendsByAge.scala` and replace the `???` symbols with the appropriate Scala/Spark code.

4.  The `FriendsByAge` object has a `main` method, so you can run it.  Run the program by clicking on the `run` link just above the line `object FriendsByAge`, or by clicking the green play button (IntelliJ users, after clicking the play button, must selecting "Run FriendsByAge" from the resulting pop-up menu.)

    If you don't see a `run` link or a green play icon, then your program likely has errors.  Debug it until you see a `run` link or a green play icon.

5.  Once you can run your program without errors and the results look good, submit your `FriendsByAge.scala` file to Gradescope.


