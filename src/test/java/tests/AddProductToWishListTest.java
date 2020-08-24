package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import pages.UserRegistration;

public class AddProductToWishListTest extends TestBase{
	ProductPage proPageObj;
	HomePage homeObj;
	ProductSearchResultPage prodSearchResultPageObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	
	String productName = "Apple MacBook Pro 13-inch";
	String productPartialName = "Apple Mac";
	String fname="Tester";
	String lname="Test";
	String email="tester@mmo3.co0m";
	String friend_mail="friend1@gmail.com";
	String oldPass="123456789";
	
	
	@Test(priority=1, alwaysRun = true)
	public void userCanRegisterSuccessfully() 
	{	homeObj=new HomePage(driver);
		registPageObj=new UserRegistration(driver);
		
		homeObj.openRegistrationPage();
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}

////	@Test(dependsOnMethods="userCanRegisterSuccessfully")
	@Test(priority=2, alwaysRun = true)
	public void userSearchForProductsUsingAutoSuggestion() 
	{
		proPageObj = new ProductPage(driver);
		
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(proPageObj.productName.getText(), productName);
	}
	//@Test(dependsOnMethods="userSearchForProductsUsingAutoSuggestion")
	@Test(priority=3, alwaysRun = true)
	public void userCanAddProductToWishList() throws InterruptedException
	{
		proPageObj= new ProductPage(driver);
		proPageObj.addProductToWishList();
		Assert.assertTrue(proPageObj.notificationBar.getText().contains("The product has been added to your"));
		proPageObj.closeSuccessMsg();	
	}
	//@Test(dependsOnMethods = "userCanRegisterSuccessfully", priority= 4 )
	@Test(priority=4, alwaysRun = true)
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}

}
