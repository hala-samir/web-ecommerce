package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchResultPage;

public class ChangeCurrencyTest extends TestBase {
	HomePage homeObj;
	ProductPage productPageObj;
	ProductSearchResultPage prodSearchResultPageObj;
	String productName= "Apple MacBook Pro 13-inch";
    String productPartialName= "Apple Mac";
   
	@Test(priority=1) 
	public void userCanChangeCurrency()
	{
		homeObj=new HomePage(driver);
		productPageObj= new ProductPage(driver);
		homeObj.changeCurrency();
	}
	
	@Test(priority=2) 
	public void userSearchForProductsUsingAutoSuggestion() 
	{
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver); 
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(productPageObj.productName.getText(), productName);
		Assert.assertTrue(productPageObj.productPrice.getText().contains("€"));
	}
	
	

}
