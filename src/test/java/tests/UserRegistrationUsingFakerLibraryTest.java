package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationUsingFakerLibraryTest extends TestBase 
{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	Faker fakeData= new Faker();
	String mail= fakeData.internet().emailAddress();
	String oldPass= fakeData.number().digits(8).toString();

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fakeData.name().firstName(),fakeData.name().lastName(),mail , oldPass);
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
		loginObj.userLogin(mail,oldPass);
		Assert.assertTrue(registPageObj.logout.isDisplayed());
	}

}
