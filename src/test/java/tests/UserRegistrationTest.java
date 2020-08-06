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
	String email="tester@test21.com";
	String oldPass="123456789";

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}
	
	@Test(dependsOnMethods = "userCanRegisterSuccessfully" )
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}
	
	@Test(dependsOnMethods = "Logout")
	public void userCanLogin() 
	{
		homeObj.openLoginPage();
		loginObj=new LoginPage(driver);
		loginObj.userLogin(email,oldPass);
		Assert.assertTrue(registPageObj.logout.isDisplayed());
	}
	
}
