package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class BaseSetup {
    protected WebDriver driver;
    protected static ExtentReports extent;
    protected ExtentTest test;

    @BeforeSuite
    public void setupExtentReports() {
        extent = ExtentReport.createInstance("target/Reports/ExtentReport.html");
    }

    @BeforeTest
    public void setupDriver() {
        String browser = ConfigReader.getProperty("browser");
        String website = ConfigReader.getProperty("website");
        int implicitWait = Integer.parseInt(ConfigReader.getProperty("implicit_wait"));

        driver = SeleniumDriver.createDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(implicitWait));
        driver.manage().window().maximize();
        driver.get(website);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test Failed: " + result.getThrowable());
            
            // Take a screenshot on failure
            String screenshotPath = CaptureScreen.takeScreenshot(driver, result.getName());
            if (screenshotPath != null) {
                test.addScreenCaptureFromPath(screenshotPath, "Failure Screenshot");
            }            
        } else if (result.getStatus() == ITestResult.SUCCESS) {
//            test.log(Status.PASS, "Test Passed");
        } else {
            test.log(Status.SKIP, "Test Skipped: " + result.getThrowable());
        }
    }
    
    
    
    @AfterTest
    public void quitDriver() {
        if (driver != null) {
            driver.quit();
        }	
    }

    @AfterSuite
    public void closeExtentReports() {
        if (extent != null) {
            extent.flush();
        }
    }
}
