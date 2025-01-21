package pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public String pageTitle = "Automation Exercise";

    @FindBy(xpath = "//img[@alt='Website for automation practice']")
    private WebElement siteImage;
    
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginMenu; 
    
    @FindBy(xpath = "//a[@href='/products']")
    private WebElement productsMenu; 
    
    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
    public boolean isSitePresent() {
    	try {
        	if(siteImage.isDisplayed())
        		return true;
    	} catch (NoSuchElementException ex) {
    		ex.printStackTrace();
    		return false;
    	}
    	return false;
    }

    public void clickLoginMenu() {
    	loginMenu.click();
    }
    
    public void clickProductsMenu() {
    	productsMenu.click();
    }
}
