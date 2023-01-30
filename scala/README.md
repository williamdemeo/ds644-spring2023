# DS 644: Introduction to Big Data (§102, §104)

## Scala Setup Instructions

1.  **Install the correct version of the Java Development Kit**.

    You must install the [Java Development Kit (JDK) version 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

    It is not enough to have the Java Runtime Enviroment (JRE) on your machine.

    It is not enough to have a newer version of the JDK on your machine.

    I recommend the following version of the JDK:

    + [The Oracle JDK 11](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

    However, to download the Oracle JDK you will have to provide Oracle with your email address.  If you are opposed to sharing your email address and/or if you prefer to avoid using proprietary (closed source) software, then you may try [OpenJDK]((https://adoptium.net/temurin/releases/?version=11) instead of the Oracle version.  [OpenJDK]((https://adoptium.net/temurin/releases/?version=11) is an open source version of the JDK.  (It should work just as well as the Oracle version, though I have not verified this yet.)

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

3.  Click on the calligraphic letter ℳ icon on the left-hand pane of VSCode.  Note that this icon will appear only if you successfully installed the VSCode Metals extension as described in Step 3 of the previous section above.

4.  Click on the blue "New Scala Project" button.  After a few seconds, you should see a list of project templates.  Select the first one `scala/hello-world.g8`, then click "ok" in the next dialog, and then leave "hello-world" in the next dialog box and hit Enter.

5.  You should see a dialog box on the bottom right that says "New sbt workspace detected. Would you like to import the build?"  Click "yes."

    If the dialog box disappears or you didn't see it before you are able to click "Yes," then you can click on the bell icon on the bottom right and you will see any alert messages that you missed.

    Alternatively, whenever you want to (re)import a build, you can click on the Metals ℳ icon on the left and then select "Import build" from the "Build Commands" menu.

6.  Open the `Main.scala` file by clicking the two-paper Explorer icon on the top left and then find the `src/main/scala/Main.scala` file in the Explorer view.  When it opens in the editor window, you should see a play button on the top right of the VSCode window.  If you click the play button, VSCode will build and run your program.


If any of these intructions are unclear, please post a message on Slack.

