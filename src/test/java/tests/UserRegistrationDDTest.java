package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationDDTest extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;

	@DataProvider(name="regisrationData")
	public static Object [][]registartionData()
	{
		return new Object[][] {
			{"Hala", "Samir","email16@emaill.com","123456789"},
			{"Manal", "Samir","email12@emaill.com","123456789"}
		};
	}

	@Test(priority = 1, dataProvider = "regisrationData")
	public void userCanRegisterSuccessfully(String fname,String lname,String email,String Pass) 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, email, Pass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
		registPageObj.Logout();
		homeObj.openLoginPage();
		loginObj= new LoginPage(driver);
		loginObj.userLogin(email,Pass);
		Assert.assertTrue(registPageObj.logout.getText().contains("Log out"));
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.getText().contains("Log in"));
	}




}
