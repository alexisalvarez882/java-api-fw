# Readme

## Description:

This is a Java Maven project created for testing purposes. Here we have automated tests for the "GitHub" api.
The technologies used in this project are : 

* Jackson --> To map CSV to Object and also the JSONs Responses
* LOG4J --> For logs
* AssertJ --> For asserts
* RestAssured --> To call the Github Api

## Instructions: 

- 1 - Import Project as a Maven project in your IDE
- 2 - To open the report is necessary to install Allure in your O.S. If you are on Mac please install it running this command in your command line : brew install allure. If not please read the Allure documentation : https://www.swtestacademy.com/allure-testng/
- 3 - Run the file in resources com/celltrak/test/testng/execution.xml to run the tests. You can select a different tag if you want to run specific tests.
- 4 - Run "allure serve allure-results" in your command line to open the report.


## Structure: 

    .
    ├── main
    |    ├── java
    |        ├── com
    |            ├── celltrak
    |                ├── test
    |                       ├── api ---------------------------------------------> API DTOs to map from the API responses
    |                       ├── clients -----------------------------------------> RestClients
    |                       ├── configuration  ----------------------------------> Methods to run the tests.
    |                       ├── dto  --------------------------------------------> Object to map from CSV
    |                       ├── tests -------------------------------------------> Tests
    |                       ├── util  -------------------------------------------> Utils

## Technology decisions:

* Jackson was used for the purpose of mapping a CSV to an Object, because it's the library that I used to map JSONs to Object and was simpler for me to use it. I know that there are 
some other libraries for this and probably are simpler than this one.
* The dataproviders has just one register per file because if we hit to github several times an exception message is shown. The purpose of the CSV files is to run the same test multiple times with different information.


