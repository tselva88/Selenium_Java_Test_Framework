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

* Java Development Kit (JDK) 11 or higher.

* Apache Maven 3.x.

* IDE (IntelliJ IDEA, Eclipse, etc.).


## Setup Instructions

Clone the repository:

git clone <repository-url>
cd CollegeSystemAutomation

Install dependencies using Maven:

mvn clean install


To execute functional tests using TestNG:

mvn test


## Reporting

Test execution generates reports in the test-output/, target/ directories:

Extent Report: target/Reports/ExtentReport.html



## Maven Dependencies

Dependencies are managed in pom.xml. Key libraries include:

* Selenium WebDriver: org.seleniumhq.selenium:selenium-java

* TestNG: org.testng:testng

* RestAssured: io.rest-assured:rest-assured

* ExtentReports: com.aventstack:extentreports

* Apache POI: org.apache.poi:poi-ooxml
