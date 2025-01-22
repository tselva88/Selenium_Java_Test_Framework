# Selenium Java Automation Framework

## Overview

This is a Selenium Java-based automation framework designed to perform functional and REST API testing for a college system web application. It incorporates best practices, modularity, and reporting mechanisms to ensure effective test execution and result tracking.

## Key Features

* Functional Testing: Automates end-to-end functional tests using Selenium WebDriver.

* REST API Testing: Uses RestAssured for validating API responses.

* Data-Driven Testing: Fetches test data from Excel files.

* Reporting: Generates comprehensive test execution reports using ExtentReports.

* Browser Management: Supports Chrome, Firefox, and Edge browsers using SeleniumManager.

* Configuration Management: Centralized property configuration through config.properties.

* Error Handling: Takes screenshots on test failures and attaches them to reports.


## Prerequisites

* Java(JDK) 11 or higher.

* Apache Maven 3.x.

* IDE (Eclipse).

* GIT

## Project Structure
```
Selenium_Java_Test_Framework/
├── src/main/java/
│   ├── pages/                  # Page Object Model classes
│   │   └── HomePage.java
│   │   └── LoginPage.java
│   │   └── ProductsPage.java
│   └── utils/                  # Utility classes
│       ├── APIUtils.java	# REST API test methods
│       ├── BaseSetup.java	# Base Test setup
│       ├── CaptureScreen.java	# Screenshots capture methods
│       ├── ConfigReader.java	# Test Configuration manager
│       ├── ExcelUtils.java	# Excel data Management
│       ├── ExtentReport.java	# Extent test reports
│       ├── SeleniumDriver.java	# Selenium manager driver setup
├── src/test/java/
│   ├── data/                  	# Test data files
│   │   └── ReadData.java	# Data Provider methods
│   │   └── InputData.xlsx	# Excel data source
│   └── tests/               	# Test script classes
│       └── APITest.java
│       └── LoginTest.java
│       └── ProductsTest.java
├── target                     	# Maven test reports
├── test-output                 # Junit test reports
├── config.properties           # Application configuration
├── pom.xml                     # Maven dependencies
└── testng.xml                  # TestNG suite configuration
```

## Config.properties
```
browser=chrome
website=https://www.automationexercise.com
api_host=https://jsonplaceholder.typicode.com
implicit_wait=3
```
**Points to remember:**

`Browser`: It can be Chrome, Firefox, or Edge.

`Website`: When the site is changed, the page objects or methods need to be updated in the respective page classes, and the Login and Product functional tests also need to be aligned with the new site workflow or user and test data stored in the Input Data Excel file.

`API Host`: The APITest script and respective endpoint details in the Input Data Excel file need to be updated when the API host is changed.

## Maven Dependencies

Dependencies are managed in pom.xml. Key libraries include:

* Selenium WebDriver: org.seleniumhq.selenium:selenium-java

* TestNG: org.testng:testng

* RestAssured: io.rest-assured:rest-assured

* ExtentReports: com.aventstack:extentreports

* Apache POI: org.apache.poi:poi-ooxml

## Setup and Run the Project
**Using the Command Line:**
1. Clone the GitHub repository from the following URL: `https://github.com/tselva88/Selenium_Java_Test_Framework.git`
2. Navigate to the cloned repository folder and verify that the Maven **pom.xml** file is present in the root directory.
3. Open a command window with administrator rights.
4. Run the following command to install project dependencies: 
`mvn clean install`
5. Execute the tests using the following command:
`mvn test`

**Using Eclipse:**
1. Open Eclipse and navigate to File -> Import.
2. Clone the Maven project directly from GitHub, or Import an already cloned/downloaded project from your local drive.
3. To install dependencies and run tests, select Run -> Run As -> Maven Install.
4. Alternatively, execute tests directly from the **testng.xml** file, Run -> Run As -> TestNG Suite.

## Reports
The following reports are generated in the project root directory after test execution:

**Extent Report**

Path: `/target/Reports/ExtentReport.html`

Details: Captures individual test step results (pass/fail), includes screenshots for failures, categories, overall execution summary with charts, test timeline, and environment details.

**Surefire Reports**

Path: `/target/surefire-reports`

Details: Includes JUnit reports and HTML files summarizing test execution, with method-level pass/fail details, exceptions, or assertions for failures.

**Test-output Reports**

Path: `/test-output` (generated when tests are executed from testng.xml).

Details: Contains JUnit reports and HTML files summarizing test execution.