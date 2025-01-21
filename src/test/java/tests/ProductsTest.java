package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import data.ReadData;
import pages.HomePage;
import pages.ProductsPage;
import utils.BaseSetup;

public class ProductsTest extends BaseSetup {
    private HomePage homePage;
	private ProductsPage productsPage;
    
    @BeforeClass
    public void setupTest() {
        test = extent.createTest("Verify Products Search Functionality").assignCategory("Web_Test");
        homePage = new HomePage(driver);
        productsPage = new ProductsPage(driver);       
    }

    @Test()
    public void verifySite() {
    	Assert.assertTrue(homePage.isSitePresent(), "Site is not launched");
    	test.pass("Site launched successfully");
    	
    	Assert.assertEquals(driver.getTitle().trim(), homePage.pageTitle, "Home Page Title is incorrect");
    	test.pass("Home page title is verified");
    	
    	homePage.clickProductsMenu();
    	Assert.assertEquals(driver.getTitle().trim(), productsPage.pageTitle, "Products Page Title is incorrect");
    	test.pass("Prodcuts page title is verified");
    }
    
    @Test(dependsOnMethods = "verifySite", dataProvider = "productsData", dataProviderClass = ReadData.class)
    public void searchProducts(String product) {
    	productsPage.searchProduct(product);
        test.info("Searhing for the product: " + product);

        Assert.assertTrue(productsPage.isProductDisplayed(driver, product), "Product search is failed: "+product);
        test.pass("Product is available: " + product);
        
        productsPage.clickViewProduct();
        Assert.assertEquals(productsPage.getProductName(), product, "Product details are not correct");
        
        driver.navigate().back();
        test.info("Navigating back to Products Search page");
    }
    
}