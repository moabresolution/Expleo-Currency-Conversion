# ExpleoTest

Task
This is a sample acceptance test framework for http://www.xe.com/currncyconverter/ 

Acceptance Criteria
To test multiple conversion rates and iterate over 5 sets of sample data

Tools/Technology/Framework
The following need to be downloaded and installed 

Java:   https://www.java.com/en/download
Eclipse IDE:   https://www.eclipse.org/
Selenium WebDriver:    https://www.seleniumhq.org/
Maven Apache:   https://www.maven.apache.org/

Framework
•	JUnit
	https://junit.org/junit5/

Code style
	Standard

Writing the Test
There is after method to quit the instantiated webDriver instance
Browser driver is under the folder directory src/test/resources.
For loop is used to iterate the currency through the string of array list setup and assertion to compare the expected conversion to converted currency for every page of each currency before it navigates back.

Note: All these test steps can be converted to method and make them reusable in the future test cases. This will make the code tidier, cleaner and reduce the lines of code.

Running the Test
Right click on the project > Run As > JUnit Test
    
