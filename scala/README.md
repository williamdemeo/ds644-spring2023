# DS 644: Introduction to Big Data (§102, §104)

## Scala Setup Instructions

### Preliminaries

If any of the intructions on this page are unclear, please post a message on [Slack][].

We use [VSCode][] in this class.  However, if you are already comfortable with the IntelliJ IDE and you wish to use it instead of VSCode,  then the steps you must follow to setup Scala will be different from the ones below.  If you need help configuring IntelliJ for use with Scala, please contact the instructor as soon as possible, preferably in the first week or two of the semester.

---------------------

### How to set up Scala

1.  **Install the correct version of the Java Development Kit**.

    You must install the [Java Development Kit (JDK) version 11][]

    It is not enough to have the Java Runtime Enviroment (JRE) on your machine.

    It is not enough to have a newer version of the JDK on your machine.

    I recommend the following version of the JDK:

    + [Oracle JDK 11][]

    However, to download the [Oracle JDK][] you will have to provide Oracle with your email address.  If you are opposed to sharing your email address and/or if you prefer to avoid using proprietary (closed source) software, then you may try [OpenJDK][] instead of the Oracle version.  [OpenJDK][] is an open source version of the JDK.  (It should work just as well as the Oracle version, though I have not verified this yet.)

2.  **Install [VSCode][]**.

    Use the [VSCode download link][VSCode download] and then follow the instructions for installing VSCode on your architecture.

3.  **Install the [VSCode Metals plugin for Scala][]**.

    To carry out this step, first start up VSCode and then click on the Extensions icon on the left-hand pane of the VSCode window.  It looks like a set of blocks, like the icon shown below.

    ![Extensions](../.img/Extensions.png)

    In the "Search Extensions" box, type "Metals" and click on the entry for "Scala (Metals)" and then click the blue "Install" button.

If you get errors, please consult the [Metals documentation][] webpage or the [Troubleshooting](#troubleshooting) section below.

---------------------

## Your First Scala Project

1.  Start up VSCode and open a new window (`File` -> `New Window`).

2.  Create a new folder and open it in VSCode.  Use the `File` -> `Open Folder` menu item and then, in the dialog box that appears, click on the "Create new folder" icon and create a folder called "MyFirstScalaProject."

    (Alternatively, you could first create the "MyFirstScalaProject" folder in your file manager or command line and then open that folder with the VSCode `File` -> `Open Folder` menu option.)

3.  Click on the [Metals][] icon in the left-hand pane of VSCode. It looks like this

    ![Metals](../.img/Metals-icon.png)

    Note that this icon will only appear in VSCode if you successfully installed the [Metals][] extension following the instructions in Step 3 of the previous section.

4.  Click on the blue "New Scala Project" button.  After a few seconds, you should see a list of project templates.  Select the first one `scala/hello-world.g8`, then click "ok" in the next dialog, and then leave "hello-world" in the next dialog box and hit Enter.

5.  You should see a dialog box on the bottom right that says "New sbt workspace detected. Would you like to import the build?"  Click "yes."

    If the dialog box disappears or you didn't see it before you are able to click "Yes," then you can click on the bell icon on the bottom right and you will see any alert messages that you missed.

    Alternatively, whenever you want to (re)import a build, you can click on the Metals icon on the left and then select "Import build" from the "Build Commands" menu.

6.  Open the `Main.scala` file by clicking the two-paper Explorer icon on the top left and then find the `src/main/scala/Main.scala` file in the Explorer view.  When it opens in the editor window, after VSCode/Metals successfully compiles the program, you will see the words "run|debug" above the `Main` class.  If you click the word "run", VSCode will run the program and print "Hello World!" in one of the consoles in the bottom pane of the VSCode window.

---------------------

## Scala worksheets

A useful way to get started with and practice programming in Scala is to use a **worksheet**.

Once you have a Scala project loaded into VSCode, as described in the previous section, you can open a worksheet by right-clicking on the `src/main/scala` directory in the VSCode Explorer pane and selecting "New Scala File..."

In the dialog box that appears, select "Worksheet" and then type a name for the worksheet, e.g., "practice" and hit Enter.

You will see a new file (called, e.g., `practice.worksheet.sc`) open up in the VSCode editor window.  Type some Scala code in that editor window and then save the file.

If you have Scala set up correctly, then VSCode will evaluate the worksheet and the results will appear in comments to the right of the code.  If this doesn't work, it means either you have an error somewhere in your worksheet, or the Scala project was not set up correctly.

--------------------------

## Running a Scala program in a terminal window...

Once you very that your Scala program runs in the IDE, you can run it from the command line with the [sbt](https://www.scala-sbt.org/) or [scala](https://www.scala-lang.org/download/2.13.10.html).


### ...using the sbt cli

1.  [Download and install sbt](https://www.scala-sbt.org/download.html).

2.  Open a terminal window and change to your project directory. For example,

    ```
    cd ~/git/hub/teaching/ds644-spring2023/scala/examples/hello-world
    ```

3.  Launch sbt from within the main project directory by typing `sbt` at the command line.

4.  At the `sbt` command prompt, type `run` and hit enter.


### ...using the scala cli

1.  [Download and install Scala 2.13](https://www.scala-lang.org/download/2.13.10.html).

2.  Open a terminal window and type `scala <path to your project>/src/main/scala/Main.scala` and hit enter.


---------------------

## Troubleshooting

If any of these intructions are unclear, please post a message on [Slack][].

As questions or problems arise, I will post notes about them and their solutions here and on [Slack][].

If you are having trouble getting the example "hello world" Scala program to load, compile, and run in VSCode, even after you have followed all of the instructions above, please consult the [Metals documentation][] or try one of the solutions below.

### Problem: pop-up message "unable to find build target"

If you get a message that says something like "Metals is unable to find a build target" or "no build target found," try one of the following possible solutions.

#### Possible Fix 1. Configure the path to JAVA HOME

Verify that VSCode and Metals are using a compatible version of the [JDK][].

Specifically, make sure that Metals is not trying to use the latest version of the JDK (version 17 or higher) since (as of this writing) they are are not compatible with Scala and Spark.

This section will help you make sure that VSCode/Metals is using [JDK 11][]

Download and unpack the version of the [Java Development Kit (JDK) version 11][] that matches for your platform.  Make a note of the directory in which you unpacked it.

*  **Important Notes for Windows Users**.  
   Do not unpack/install the JDK under `C:\Program Files\`.  Instead, put it under `C:\` because the whitespace character in the directory name `Program Files` may cause problems.

*  **Important Notes for Mac Users**.
   +  If you have a newer Mac with the M1 CPU, then you need to download the [ARM 64 version of JDK 11][].
   +  If you have an older Mac with an Intel CPU, then you need the [x64 version of JDK 11][].

   I recommend using the `*.tar.gz` download as opposed to the `*.dmg` installer because installation of the `*.tar.gz` file requires that you manually unpack it in a directory of your choice, so you will know in exactly which directory the JDK resides.  If instead you use the `*.dmg` installer, it's harder to know where the JDK ends up.

Now, in VSCode, click on the [blocks icon][] on the left and in the Extensions search box, type "Metals."  Next to the name "Scala (Metals)," you will see a cog icon.  Click the cog icon and choose "Extension Settings."  In the search box, type "Java" and you will see the box where you can specify the path to the JDK that Metals uses.  

**Extra Hint**. The directory containing the JDK that Metals needs to know about is the one that contains the following subdirectories:

```
bin  conf  include  jmods  legal  lib
```

Use the your file manager or the terminal to look inside the directory that you supplied to Metals and make sure it contains the directories listed above.


#### Possible Fix 2. Try a different (older) version of Metals

It's possible that an older version of [Metals][] will work better on your machine.  To try a different version of Metals, do the following.

1.  Open a terminal window and delete the `.vscode` and `.sbt` subdirectories of your home directory.

    +  On a Mac, [open a new terminal window (cli)][] and type `rm -rf .vscode .sbt`.
    +  On a Windows PC, [open a new CMD terminal window][] and type `rmdir /s .vscode .sbt`.
       (**Warning**. I haven't tested this command since I don't have access to a windows machine.)

2.  Open VSCode and click on the [blocks icon][] on the left of the VSCode window and, in the Extensions search box, type "Metals."  When the "Scala (Metals)" extension shows up in the window to the right, click on the down-arrow in on the (Un)Install button and choose "Install a Another Version..." then choose an older version to install, say, from 6 months ago.

#### Possible Fix 3. Install a different version of VSCode

This is probably most relevant for Mac users.  It's possible that the "universal" Mac version of VSCode is not as universal as it hopes to be.

1.  Uninstall VSCode and remove the hidden configuration subdirectories that VSCode put in your home directory (see Step 1 in [Possible Fix 2](#possible-fix-2-try-a-different-older-version-of-metals) above).

2.  Go to the [VSCode download][] page and select an alternative version, e.g.,
    * [VSCode for Mac Apple M1 chip][]
    * [VSCode for Mac Intel chip][]



#### Possible Fix 4. As a last resort, use a different IDE

If you have carefully followed all of the commands above and you still can't get the "Hello World" program to compile and run, then you might consider abandoning VSCode in favor of [IntelliJ IDEA][], which is a more mature IDE and might be more stable on your machine.

Go to the [IDEA download page][] and download/unpack/install the Community Edition of IDEA.

To configure IDEA for use with Scala, launch the IDEA application and you should be given the option to install the Scala plugin.  If not, then after IDEA starts, find/select the menu item "Plugins" and then enter "Scala" in the search box.  Select the "Scala" plugin and click "Install."

If you have decided to abandon VSCode and you need help configuring IntelliJ IDEA, please post a message on Slack.

----

### Links mentioned on this page

* [ARM 64 version of JDK 11][]
* [IDEA download page][]
* [IntelliJ IDEA][]
* [Java Development Kit (JDK) version 11][]
* [JDK][]
* [JDK 11][]
* [Metals documentation][]
* [open a new CMD terminal window][]
* [open a new terminal window (cli)][]
* [OpenJDK][]
* [Oracle JDK 11][]
* [Slack][]
* [VSCode][]
* [VSCode download][]
* [VSCode Metals plugin for Scala][]
* [VSCode for Mac Apple M1 chip][]
* [VSCode for Mac Intel chip][]
* [x64 version of JDK 11][]

[ARM 64 version of JDK 11]: https://www.oracle.com/java/technologies/downloads/#license-lightbox
[IDEA download page]: https://www.jetbrains.com/idea/download/
[IntelliJ IDEA]: https://www.jetbrains.com/idea/
[Java Development Kit (JDK) version 11]: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
[JDK]: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
[JDK 11]: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
[Metals]: https://scalameta.org/metals
[Metals documentation]: https://scalameta.org/metals/docs/editors/vscode
[open a new terminal window (cli)]: https://support.apple.com/guide/terminal/open-or-quit-terminal-apd5265185d-f365-44cb-8b09-71a064a42125/mac
[open a new CMD terminal window]: https://www.lifewire.com/how-to-open-command-prompt-2618089
[OpenJDK]: https://adoptium.net/temurin/releases/?version=11
[Oracle JDK]: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
[Oracle JDK 11]: https://www.oracle.com/java/technologies/javase-jdk11-downloads.html
[Slack]: https://join.slack.com/t/ds644-bigdata/shared_invite/zt-1mriemcs6-kWEkz0rGCBNutfP79UWkLQ
[VSCode]: https://code.visualstudio.com
[VSCode download]: https://code.visualstudio.com/download
[VSCode Metals plugin for Scala]: https://scalameta.org/metals/
[VSCode for Mac Apple M1 chip]: https://code.visualstudio.com/docs/?dv=darwinarm64
[VSCode for Mac Intel chip]: https://code.visualstudio.com/docs/?dv=darwinx64
[x64 version of JDK 11]: https://www.oracle.com/java/technologies/downloads/#license-lightbox

[blocks icon]: https://github.com/williamdemeo/ds644-spring2023/blob/main/.img/Extensions.png
