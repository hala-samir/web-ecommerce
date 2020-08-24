package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationTest extends TestBase 
{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	String fname="Tester";
	String lname="Test";
	String email="tester@grg80.com";
	String oldPass="123456789";

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}
	
	@Test(priority=2) 
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}
	
	@Test(priority=3) 
	public void userCanLogin() 
	{
		homeObj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin(email,oldPass);
		Assert.assertTrue(registPageObj.logout.isDisplayed());
	}
	
}
