package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import pages.UserRegistration;

public class EmailFriendTest extends TestBase{
	EmailFriendPage emailFriendPageObj;
	ProductPage productPageObj;
	HomePage homeObj;
	ProductSearchResultPage prodSearchResultPageObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	
	String productName = "Apple MacBook Pro 13-inch";
	String productPartialName = "Apple Mac";
	String fname="Tester";
	String lname="Test";
	String email="tester@test2212.co0m";
	String friend_mail="friend1@gmail.com";
	String oldPass="123456789";
	String msg= "check this please!!";
	
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
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver); 
		
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(productPageObj.productName.getText(), productName);
	}

	@Test(dependsOnMethods = "userSearchForProductsUsingAutoSuggestion",priority=3)
	public void emailFriend()
	{
		homeObj = new HomePage(driver);
		productPageObj=new ProductPage(driver);
		emailFriendPageObj= new EmailFriendPage(driver);

		productPageObj.visitEmailFriendPage();
		Assert.assertTrue(emailFriendPageObj.emailFriendPageTitle.getText().contains("Email a friend"));
		emailFriendPageObj.emailFriend(friend_mail, msg);
		Assert.assertTrue(emailFriendPageObj.confirmationMsg.getText().contains("Your message has been sent"));
	}
	@Test(dependsOnMethods = "userCanRegisterSuccessfully", priority = 4 )
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}


}
