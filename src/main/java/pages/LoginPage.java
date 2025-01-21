package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public String pageTitle = "Automation Exercise - Signup / Login";
	
    @FindBy(name = "email")
    private WebElement usernameField;

    @FindBy(name = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[text()='Login']")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='/logout']")
    private WebElement logoutButton; 
    
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void login(String email, String password) {
        usernameField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }
    
    public boolean isUserLoggedIn(WebDriver driver, String username) {
    	List<WebElement> loggedInUser = driver.findElements(By.xpath("//b[text()='"+username+"']"));
    	if(!loggedInUser.isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
    public void logout() {
    	logoutButton.click();
    }
    
}