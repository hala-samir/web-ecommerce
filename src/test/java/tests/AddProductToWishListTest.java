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
	String email="tester@test1082.co0m";
	String friend_mail="friend1@gmail.com";
	String oldPass="123456789";
	
	
	@Test(priority=1)
	public void userCanRegisterSuccessfully() 
	{	homeObj=new HomePage(driver);
		registPageObj=new UserRegistration(driver);
		
		homeObj.openRegistrationPage();
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}

	@Test(dependsOnMethods="userCanRegisterSuccessfully",priority=2)
	public void userSearchForProductsUsingAutoSuggestion() 
	{
		proPageObj = new ProductPage(driver);
		
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(proPageObj.productName.getText(), productName);
	}
	@Test(priority=3)
	public void userCanAddProductToWishList() throws InterruptedException
	{
		proPageObj= new ProductPage(driver);
		proPageObj.addProductToWishList();
		Assert.assertTrue(proPageObj.notificationBar.getText().contains("The product has been added to your"));
		proPageObj.closeSuccessMsg();	
	}
	@Test(dependsOnMethods = "userCanRegisterSuccessfully", priority= 4 )
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}

}
