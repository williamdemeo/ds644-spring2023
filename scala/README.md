# DS 644: Introduction to Big Data (§102, §104)

## Scala Setup Instructions

### Preliminaries

If any of the intructions on this page are unclear, please post a message on [Slack][].

We use [VSCode][] in this class.  However, if you are already comfortable with the IntelliJ IDE and you wish to use it instead of VSCode,  then the steps you must follow to setup Scala will be different from the ones below.  If you need help configuring IntelliJ for use with Scala, please contact the instructor as soon as possible, preferably in the first week or two of the semester.


### How to set up Scala

1.  **Install the correct version of the Java Development Kit**.

    You must install the [Java Development Kit (JDK) version 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

    It is not enough to have the Java Runtime Enviroment (JRE) on your machine.

    It is not enough to have a newer version of the JDK on your machine.

    I recommend the following version of the JDK:

    + [The Oracle JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

    However, to download the Oracle JDK you will have to provide Oracle with your email address.  If you are opposed to sharing your email address and/or if you prefer to avoid using proprietary (closed source) software, then you may try [OpenJDK](https://adoptium.net/temurin/releases/?version=11) instead of the Oracle version.  [OpenJDK](https://adoptium.net/temurin/releases/?version=11) is an open source version of the JDK.  (It should work just as well as the Oracle version, though I have not verified this yet.)

2.  **Install [VSCode](https://code.visualstudio.com/download)**.

    Just follow the [VSCode download link](https://code.visualstudio.com/download) and then follow the instructions for installing VSCode on your architecture.

3.  **Install the [VSCode Metals plugin for Scala](https://scalameta.org/metals/)**.

    To carry out this step, first start up VSCode and then click on the Extensions icon on the left-hand pane of the VSCode window.  It looks like a set of blocks, like the icon shown below.

    ![Extensions](../img/Extensions.png)

    In the "Search Extensions" box, type "Metals" and click on the entry for "Scala (Metals)" and then click the blue "Install" button.

## Your First Scala Project

1.  Start up VSCode and open a new window (`File` -> `New Window`).

2.  Create a new folder and open it in VSCode.  Use the `File` -> `Open Folder` menu item and then, in the dialog box that appears, click on the "Create new folder" icon and create a folder called "MyFirstScalaProject."

    (Alternatively, you could first create the "MyFirstScalaProject" folder in your file manager or command line and then open that folder with the VSCode `File` -> `Open Folder` menu option.)

3.  Click on the Metals icon in the left-hand pane of VSCode. It looks like this

    ![Metals](../img/Metals-icon.png)

    Note that this icon will only appear in VSCode if you successfully installed the Metals extension following the instructions in Step 3 of the previous section.

4.  Click on the blue "New Scala Project" button.  After a few seconds, you should see a list of project templates.  Select the first one `scala/hello-world.g8`, then click "ok" in the next dialog, and then leave "hello-world" in the next dialog box and hit Enter.

5.  You should see a dialog box on the bottom right that says "New sbt workspace detected. Would you like to import the build?"  Click "yes."

    If the dialog box disappears or you didn't see it before you are able to click "Yes," then you can click on the bell icon on the bottom right and you will see any alert messages that you missed.

    Alternatively, whenever you want to (re)import a build, you can click on the Metals icon on the left and then select "Import build" from the "Build Commands" menu.

6.  Open the `Main.scala` file by clicking the two-paper Explorer icon on the top left and then find the `src/main/scala/Main.scala` file in the Explorer view.  When it opens in the editor window, after VSCode/Metals successfully compiles the program, you will see the words "run|debug" above the `Main` class.  If you click the word "run", VSCode will run the program and print "Hello World!" in one of the consoles in the bottom pane of the VSCode window.


## Scala worksheets

A useful way to get started with and practice programming in Scala is to use a **worksheet**.

Once you have a Scala project loaded into VSCode, as described in the previous section, you can open a worksheet by right-clicking on the `src/main/scala` directory in the VSCode Explorer pane and selecting "New Scala File..."

In the dialog box that appears, select "Worksheet" and then type a name for the worksheet, e.g., "practice" and hit Enter.

You will see a new file (called, e.g., `practice.worksheet.sc`) open up in the VSCode editor window.  Type some Scala code in that editor window and then save the file.

If you have Scala set up correctly, then VSCode will evaluate the worksheet and the results will appear in comments to the right of the code.  If this doesn't work, it means either you have an error somewhere in your worksheet, or the Scala project was not set up correctly.

## Troubleshooting

If any of these intructions are unclear, please post a message on [Slack][].

As questions or problems arise, I will post notes about them and their solutions here and on [Slack][].


[Slack]: https://join.slack.com/t/ds644-bigdata/shared_invite/zt-1mriemcs6-kWEkz0rGCBNutfP79UWkLQ


[VSCode]: https://code.visualstudio.com
