# TheScoreApp
**Appium Automation for TheScore Android App using Emulator**

Author-Ruchi Kapoor

Project Overview:
1. I have created Automation scripts to automate TheScore app using Android Emulator and Appium inspector(to inspect locators for Web Element)<br>
2. TestNg is being used to generate reports
3. My automation script will click on the Get Started button on TheScore App and select League(NHL) from the "Choose your League" page, further it will select team and in the end will show the Team stats successfully.<br><br>


Appium Automation Pre-requisites(Android):

1.Install Java jdk-11.0.11 and Eclipse IDE <br>
2.Install NodeJS<br>
3.Install Android studio<br>
4.Install Appium Server using npm (CLI) command npm install -g appium. <br>
5.Appium Server version "2.5.1" is used.<br>
6.Appium Inspectpor used to identify Web Element - https://inspector.appiumpro.com/ <br>
7.Appium Driver used - "uiautomator2@3.0.1" <br>
8.App .apk file is already present inside the resources folder of project, no need to update the location of apk file

To run the Project<br>
1.Select the testng xml -> Right click and select Run

Project Features:
1. No need to run the server, it will run programatically.<br>
2. All the dependencies are included in pom.xml file. No need to download external Jars.<br>
3.It will create TestNG report once project is run<br>

My TestNG report:<br>
![TestNG Report](https://github.com/ruchikapoor098/TheScoreApp/assets/78932265/d30861f0-00cc-47ff-a060-d5e70ca67368)




