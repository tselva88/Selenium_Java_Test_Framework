package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {
	
	public String pageTitle = "Automation Exercise - All Products";
	
    @FindBy(id = "search_product")
    private WebElement searchbox;
    
    @FindBy(id = "submit_search")
    private WebElement searchbutton;
    
    @FindBy(xpath = "//a[text()='View Product']")
    private WebElement viewProduct;
    
    @FindBy(xpath = "//div[@class='product-information']/h2")
    private WebElement ProductName;

    public ProductsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String product) {
    	searchbox.clear();
    	searchbox.sendKeys(product);
    	searchbutton.click();
    }
    
    public boolean isProductDisplayed(WebDriver driver, String product) {
    	List<WebElement> loggedInUser = driver.findElements(By.xpath("  //div[@class='single-products']//p[text()='"+product+"']"));
    	if(!loggedInUser.isEmpty()) {
    		return true;
    	}
    	return false;
    }
    
    public void clickViewProduct() {
    	viewProduct.click();
    }
    
    public String getProductName() {
    	return ProductName.getText().trim();
    }
}
