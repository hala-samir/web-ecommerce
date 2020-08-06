package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import pages.UserRegistration;

public class CompareProductsTest extends TestBase {
	ProductPage proPageObj;
	HomePage homeObj;
	ProductSearchResultPage prodSearchResultPageObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	CompareProductsPage compareProductsPageObj;


	String ProductName_1 = "Apple MacBook Pro 13-inch";
	String ProductName_2 = "Asus N551JK-XO076H Laptop";

	@Test(priority=1)
	public void userCanViewProductsComparison() throws InterruptedException 
	{
		homeObj= new HomePage(driver);
		proPageObj = new ProductPage(driver);
		compareProductsPageObj = new CompareProductsPage(driver);

		homeObj.searchProductUsingAutoSuggestion(ProductName_1);
		Assert.assertEquals(proPageObj.productName.getText(), ProductName_1);

		proPageObj.addProductToCompareList();
		Assert.assertTrue(proPageObj.compareProductSuccessMsg.getText().contains("The product has been added to your"));

		homeObj.searchProductUsingAutoSuggestion(ProductName_2);
		Assert.assertEquals(proPageObj.productName.getText(), ProductName_2);

		proPageObj.addProductToCompareList();
		Assert.assertTrue(proPageObj.compareProductSuccessMsg.getText().contains("The product has been added to your"));

		proPageObj.visitCompareProductPage();
		compareProductsPageObj.compareProducts();	
		Assert.assertTrue(compareProductsPageObj.prodOne.getText().contains(ProductName_1));	
		Assert.assertTrue(compareProductsPageObj.prodTwo.getText().contains(ProductName_2));
	}

	@Test(priority = 2)
	public void userCanClearProductsComparision() 
	{
		compareProductsPageObj=new CompareProductsPage(driver);
		compareProductsPageObj.clearCompareList();
		Assert.assertTrue(compareProductsPageObj.emptyMsg.getText().contains("You have no items to compare"));
	}


}
