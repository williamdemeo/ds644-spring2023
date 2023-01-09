# DS 644: Introduction to Big Data

## Tips and advice for setting up a Scala/Spark development environment

### Windows version

(If you're using Mac or Linux, you're in the wrong place; see the [advice for Mac and Linux users](../mac-linux).)

This section only applies to users of Windows.  You do not need to follow these directions to [install Spark on Linux or Mac](../mac-linux).

**Caveat**. It is the opinion of your instructor that Windows is woefully inadequate, and barely qualifies as an operating system.  Students are allowed to try to complete the work required in this class using a Windows machine, but it is not recommended because

1.  It will be much harder for your instructor or TA to help you if encounter problems, and

2.  If your goal is to pursue any serious scientific endeavor in the real world, it is unlikely that you will succeed by relying solely on a Windows machine.  Eventually, you will want, and possibly need, to use a Unix based operating system like Linux or Mac. 

If you're still not convinced, have a look at [this article][linux market share] about Linux's growing market share, or [this one][TuX uber alles] about how Linux is taking over the world!



### Put Linux on your Windows machine!

If you have a Windows machine and you want to try Linux, there are [many resources][dualboot] on the web that teach you, step-by-step, how to convert your machine into a "dual boot" system so that, each time you start your computer, you can choose whether to run Windows or Linux. For example, see [this guide][dualboot guide] or [Google search: "dual boot windows linux"][dualboot].



1.  **Install the Java Development Kit (JDK)** (if you haven't done so already)

    Any version between Java 8 through 14 should be fine.  (More recent version might not be compatible with Spark.)

    I recommend you install JDK 11, which can be downloaded from the Oracle website at the following URL:

    [https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)

    **Tip** Do NOT install the JDK in a directory with a space in the name (e.g., `Program Files`). Instead, when Java asks you where you would like to install, choose something like `C:\jdk11`.

2.  **Install an IDE** e.g. VS Code with the Metals extension or IntelliJ IDEA with the Scala plugin.

    **Tip** If you chose IntelliJ IDEA as your IDE, make sure the Scala plugin is installed by clicking on the `Configure` button on the bottom right of the main IDEA splash screen window.  If you don't see the splash screen window when you start IntelliJ IDEA, it's probably because you have some project windows open.  Close these windows and you should see the IntelliJ IDEA splash screen window.

    **Tip** If you chose IntelliJ IDEA as your IDE, setup the default JDK to use for your Scala projects.  Click on the `Configure` button on the bottom right of the IntelliJ IDEA splash screen and select "Structure for New Projects."  Select the JDK you installed in step 1.

3.  **Convince Windows that Hadoop is running**

    a.  Create a `C:\Hadoop\bin` directory.

    b.  Copy the file [winutils.exe][] into the `C:\Hadoop\bin` directory you just created.

    c.  Create a new environment variable (enter "environment variables" in the Windows search bar, click on "Add Environment Variables," and add a new system variable) named `HADOOP_HOME` with a value of `C:\Hadoop`.  Select the `PATH` environment variable, and `APPEND` a new entry, separated by a semi-colon, of `%HADOOP_HOME%\bin`. Restart IntelliJ to make sure the new environment variables are loaded.


[dualboot]: https://www.google.com/search?q=dual+boot+windows+linux
[dualboot guide]: https://www.freecodecamp.org/news/how-to-dual-boot-any-linux-distribution-with-windows/
[linux market share]: https://www.makeuseof.com/tag/linux-market-share/
[TuX uber alles]: https://www.makeuseof.com/tag/linux-taking-over-world/
[winutils.exe]: https://drive.google.com/file/d/1MhHVeK1dL7h-KCmoXz-798Bgz618_eAV/view?usp=sharing

