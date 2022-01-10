# Sahithi-NHSBSA
To write a Wales Test Ticket

# PreRequisites
1. Java installed and JAVA_HOME env variable set.
2. Maven installed and MAVEN_HOME env variable set.
3. Add Maven installable directory to system path variable. ( to execute maven from any directory in CLI)

# Note
To execute the test cases for chrome update <your local root path> in line 34 of costsChecker.java  to us your local chrome.exe 

```
  System.setProperty("webdriver.chrome.driver", "<your local root path>//WalesTestTicket//chromedriver_win32//chromedriver.exe");
```  
# Instructions 
1. Open command prompt or preferred cli.
2. verify all the tools installed as in Prerequisites.
    - run java -version - To check java installed
    - run mvn -verion - To check maven installed
3. Go to WalesTestTicket project directory.
4. run mvn clean test command to execute the test cases
