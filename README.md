# getvehicledetail
Git Hub URL: https://github.com/ramesh240102/getvehicledetail.git

Summary Of Get Vehicle Information -:
-------------------------------------
The project is structured using Maven with utility, mainline classes and tests with two solution. Test can be executed using test TestNG 
and other option is using Cucumber.

Utilities - Driver class for handling the browser instances and File Reader which read value from a test file. 
Currently file name is hardcoed but it can be enhanced to pass in as parameter

Mainline program - Represents various functions within the webpage.

Tests - Test classes are written using testNG and Cucumber
This project was done using Eclipse.

Soultion 1 - Execution steps for TestNG:
-----------------------------------------
The test can be executed using TestNG plugin by right on GetVehicleInformationTest.java and run as TestNG.

Test Results can be verified in the Eclipse console / in testng result tab for TestNG.

Soultion 2 - Execution steps for Cucumber:
-------------------------------------------
The test can be executed using Cucumber & Junit plugin by right on TestRunner.java and run as JUnit.

Test Results can be verified in the Eclipse console / in JUnit tab for Cucumber tests.

@Note: This can be further enhanced using textng.xml and hooking to pom.xml. Then execute as Maven project. 
Due to time constraint, currently it can be executed directly from java file.
