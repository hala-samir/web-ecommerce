package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationUsingTDDExcelFileTest extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	@DataProvider(name="ExcelData")
	public Object [][] userRegistrationDataExcel() throws IOException
	{ExcelReader er=new ExcelReader();

	return er.getExcelData();
	}
	@Test(priority = 1, dataProvider = "ExcelData")
	public void userCanRegisterSuccessfully(String fname, String lname, String mail , String pass) 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, mail, pass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
		registPageObj.Logout();
		homeObj.openLoginPage();
		loginObj= new LoginPage(driver);
		loginObj.userLogin(mail,pass);
		Assert.assertTrue(registPageObj.logout.getText().contains("Log out"));
		registPageObj.Logout();
		Assert.assertTrue(homeObj.loginLink.getText().contains("Log in"));
	}

}
