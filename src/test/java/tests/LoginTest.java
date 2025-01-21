package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.ReadData;
import pages.HomePage;
import pages.LoginPage;
import utils.BaseSetup;

public class LoginTest extends BaseSetup {
    private HomePage homePage;
	private LoginPage loginPage;
    
    @BeforeClass
    public void setupTest() {
        test = extent.createTest("Verify Application Login Functionality").assignCategory("Web_Test");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);       
    }

    @Test()
    public void verifySite() {
    	Assert.assertTrue(homePage.isSitePresent(), "Site is not launched");
    	test.pass("Site launched successfully");
    	
    	Assert.assertEquals(driver.getTitle().trim(), homePage.pageTitle, "Home Page Title is incorrect");
    	test.pass("Home page title is verified");
    	
    	homePage.clickLoginMenu();
    	Assert.assertEquals(driver.getTitle().trim(), loginPage.pageTitle, "Login Page Title is incorrect");
    	test.pass("Login page title is verified");
    }
    
    @Test(dependsOnMethods = "verifySite", dataProvider = "loginData", dataProviderClass = ReadData.class)
    public void verifyUserLogin(String username, String email, String password) {
        loginPage.login(email, password);
        test.info("Attempting to login with email: " + email);

        Assert.assertTrue(loginPage.isUserLoggedIn(driver, username), "Login attempt failed for the username: "+username);
        test.pass("Login successful for username: " + username);
    }
    
    @Test(dependsOnMethods = "verifyUserLogin")
    public void userLogout() {
    	loginPage.logout();
    }
}