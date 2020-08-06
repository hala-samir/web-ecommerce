package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.EmailFriendPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductReviewPage;
import pages.ProductSearchResultPage;
import pages.UserRegistration;

public class ReviewProductTest extends TestBase {
	EmailFriendPage emailFriendPageObj;
	ProductPage productPageObj;
	HomePage homeObj;
	ProductSearchResultPage prodSearchResultPageObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	ProductReviewPage productReviewPageObj;
	
	String productName = "Apple MacBook Pro 13-inch";
	String productPartialName = "Apple Mac";
	String fname="Tester";
	String lname="Test";
	String email="tester@test107ml1.co0m";
	String friend_mail="friend1@gmail.com";
	String oldPass="123456789";
	String msg= "check this please!!";
	String review_title= "Good product!";
	String review_txt= "It can be better";
	
	
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
		productPageObj = new ProductPage(driver);
		
		homeObj.searchProductUsingAutoSuggestion(productPartialName);
		Assert.assertEquals(productPageObj.productName.getText(), productName);
	}
	
	@Test(dependsOnMethods="userSearchForProductsUsingAutoSuggestion",priority = 3)
	public void userCanSubmitProductReview() 
	{
		productReviewPageObj= new ProductReviewPage(driver);
		productPageObj.visitReviewProductPage();
		productReviewPageObj.addReview(review_title, review_txt);	
		Assert.assertTrue(productReviewPageObj.reviewSuccessMsg.getText().contains("Product review is successfully added"));		
	}
	@Test(dependsOnMethods = "userCanRegisterSuccessfully",priority = 4 )
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}
}
