package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchResultPage;

public class ProductsSearchTest extends TestBase {
	HomePage homeObj;
	ProductPage productPageObj;
	ProductSearchResultPage prodSearchResultPageObj;
	String productName = "Apple MacBook Pro 13-inch";
	String productPartialName = "Apple Mac";
	
	@Test(priority=1, alwaysRun = true) 
	public void userSearchForProductsUsingAutoSuggestion() 
	{
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver); 
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(productPageObj.productName.getText(), productName);
	}
	@Test(priority=2, alwaysRun = true)
//	@Test(dependsOnMethods = "userSearchForProductsUsingAutoSuggestion")
	public void userSearchesForProducts() 
	{
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver); 		
		homeObj.searchProduct(productName);
		Assert.assertEquals(prodSearchResultPageObj.productLink.getText(), productName);
	}


}
