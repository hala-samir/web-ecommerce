package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import data.LoadProperties;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class RegistrationTTDusingPropertiesTest extends TestBase {
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	String fname= LoadProperties.userData.getProperty("firstname");
	String lname= LoadProperties.userData.getProperty("lastname");
	String mail= LoadProperties.userData.getProperty("email");
	String pass= LoadProperties.userData.getProperty("password");

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, mail, pass);
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
		loginObj.userLogin(mail,pass);
		Assert.assertTrue(registPageObj.logout.isDisplayed());
	}

}
