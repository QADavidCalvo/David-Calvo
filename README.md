## David Calvo: Home Challenge

-------------------------------------------------------------------------------------------------

### Exploratory tests

I decided to do an exploratory test of the Monefy app in a time frame of 1h doing some different exploratory charters and then reporting the results of that test.

Please check the detailed information here: [Exploratory_Test.md](../main/src/test/java/monefy/Exploratory_Test.md)


-------------------------------------------------------------------------------------------------

### End-to-End automated tests

#### Table of Contents
- [Description](#description)
- [Project structure](#project-structure)
- [Installation](#installation)
- [Running the tests](#running-the-tests)
- [Test results](#test-results)


##### Description

I have chosen to use Java for the end-to-end test code since it is an easy-to-understand language, and compatible both to automate Android, iOS or Web, executing the tests with Appium, an opensource framework which is fully usable in any test environment.

I haven't used SpringBoot since I didn't see it necessary to complicate the infrastructure for this small amount of tests, but it is recommended when the project has many dependencies between classes.

It is a maven project which easily manages the libraries and dependencies necessary to execute the tests both from the IDE and from the command line.

All the tests run under Java 15 and jUnit 5 with which it is possible to make multiple configurations in the scenarios.

The tests results are generated with Maven Surefire Report and used to generate an Allure report with more usable info (in a big project this reports can have screenshots, logs, tests suite information, etc.)


##### Project structure

```bash
├── David-Calvo
│   ├── src
│   │   ├── main
│   │   │   ├── java
│   │   │   │   ├── monefy
│   │   │   │   │   ├── constants
│   │   │   │   │   │   ├── AndroidScreensConstants
│   │   │   │   │   ├── driver
│   │   │   │   │   │   ├── DriverController
│   │   │   │   │   ├── pageObjects
│   │   │   │   │   │   ├── AmountKeyboardScreen
│   │   │   │   │   │   ├── CurrentBalanceScreen
│   │   │   │   │   │   ├── DrawerScreen
│   │   │   │   │   │   ├── ExpensesAndIncomesScreen
│   │   │   │   │   │   ├── NewTransferScreen
│   │   │   │   │   │   ├── OptionsScreen
│   │   │   │   │   │   ├── SummaryScreen
│   │   │   │   │   │   ├── ToolbarScreen
│   │   ├── test
│   │   │   ├── java
│   │   │   │   ├── monefy
│   │   │   │   │   ├── E2E_Test
├── pom.xml
└── README.md 
```


##### Installation

NOTE: the code installation examples are for Mac.
 
- Install IDE IntelliJ, Eclipse or other
- Install [JDK](https://www.oracle.com/java/technologies/javase-downloads.html) version 15
- Set Java paths using terminal, example:
    
        $ vim .bash_profile
    
        export JAVA_HOME=/Library/Java/JavaVirtualMachines/adoptopenjdk-15.jdk/Contents/Home
        export PATH="$JAVA_HOME/bin:$PATH"
        export ANDROID_HOME=/Users/{userName}/Library/Android/sdk
        export PATH=$ANDROID_HOME/tools:$PATH
        export PATH=$ANDROID_HOME/tools/bin:$PATH
        export PATH=$ANDROID_HOME/tools/proguard/bin:$PATH
        export PATH=$ANDROID_HOME/platform-tools:$PATH
        export PATH=$ANDROID_HOME/build-tools/28.0.3:$PATH
        
        $ source .bash_profile
        
- Install Homebrew from terminal with this command:
        
        $ ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
    
- Install Nodejs using this command:
       
        $ brew install node
        
- Install Appium

        $ npm install -g appium
        
 - Appium doctor
 
        $ npm install appium-doctor -g
        
 - Execute appium doctor to verify the installation is OK.
 
        $ appium-doctor
        
 -  Download and install [Appium Desktop](https://github.com/appium/appium-desktop/releases/) 
 

##### Running the tests

To launch tests in your local machine do these steps:
1. Connect a real device to the computer or launch an emulator. 
2. Install wallapop debug apk in your device
3. Start appium server using Appium Desktop or using the following command:
        $ appium --address 127.0.0.1 --port 4723 -l --session-override --command-timeout 7200 --default-capabilities '{"deviceName": "test"}'     
4. Access to the test file to launch (f.ex. "LoginWallapopUserTest.java") or a suite (f.ex. "SanityTest.java")
5a. To launch the tests with the IDE: select an indidivual test or the whole test class and run them as "JUnit Test"
5b. To launch the tests via command line: in a Terminal run the Maven command `mvn test -q -DexecutionType=serverside -f "{gitRepoFullPath}" -Dtest={TestClass}`
6. The tests will start on the device.
7. Wait until the tests have finished.
8. Check the results.


##### Test results

[Allure report]


-------------------------------------------------------------------------------------------------

