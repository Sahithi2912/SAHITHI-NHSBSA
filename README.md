# Sahithi-NHSBSA
To write a Wales Test Ticket

# PreRequisites
1. Java installed and JAVA_HOME env variable set.
2. Maven installed and MAVEN_HOME env variable set.
3. Add Maven installable directory to system path variable. ( to execute maven from any directory in CLI)

# Note
The default mozilla driver instalaltion is assumed ot be at "C:\\Program Files\\Mozilla Firefox\\firefox.exe". If your installation is at different location please change this path in below file line no 21 as needed. <br/>
_Sahithi-NHSBSA\WalesTestTicket\src\test\java\steps\costChecker.java_

# Instructions 
1. Open command prompt or preferred cli.
2. verify all the tools installed as in Prerequisites.
    - run ```java -version``` - To check java installed
    - run ```mvn -verion``` - To check maven installed
3. Go to WalesTestTicket project directory.
4. run ```mvn clean test``` command to execute the test cases
