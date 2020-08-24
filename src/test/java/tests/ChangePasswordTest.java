package tests;

//import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.UserRegistration;

public class ChangePasswordTest extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	MyAccount myAccObj;
	String fname="Tester";
	String lname="Test";
	String email="tester@ssdc6.com";
	String oldPass="123456789";
	String newPass="12345678";

	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}

//	@Test(dependsOnMethods="userCanRegisterSuccessfully")
	@Test(priority=2, alwaysRun = true)
	public void RegisteredUserChangesPassword() 
	{	
		myAccObj=new MyAccount(driver);
		registPageObj.AccessMyAccount();
		myAccObj.clickChangePassword();
		myAccObj.ChangePassword(oldPass, newPass);
		Assert.assertTrue(myAccObj.SuccessMsg.getText().contains("Password was changed"));
	}
	
	//@Test(dependsOnMethods="RegisteredUserChangesPassword")
	@Test(priority=3, alwaysRun = true)
	public void Logout() 
	{
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.isDisplayed());
	}
	
	//@Test(dependsOnMethods="Logout")
	@Test(priority=4)
	public void loginWithNewPass()
	{ 
		homeObj=new HomePage(driver);
		homeObj.openLoginPage();
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		loginObj = new LoginPage(driver);
	//	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;

		loginObj.userLogin(email, newPass);
		Assert.assertTrue(registPageObj.logout.isDisplayed());
	}
}
