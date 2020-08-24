package tests;

import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.exceptions.CsvValidationException;
import data.JSONDataReader;
import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationDDTusingJSONFileTest extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws CsvValidationException, IOException, ParseException 
	{
		JSONDataReader JsonReader= new JSONDataReader();
		JsonReader.JsonReader();
	
			homeObj=new HomePage(driver);
			homeObj.openRegistrationPage();

			registPageObj=new UserRegistration(driver);
			registPageObj.userRegisteration(JsonReader.firstName,JsonReader.lastName,JsonReader.email,JsonReader.password );		
			Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
			
			registPageObj.Logout();
			
			homeObj.openLoginPage();
			
			loginObj= new LoginPage(driver);
			loginObj.userLogin(JsonReader.email,JsonReader.password);
			Assert.assertTrue(registPageObj.logout.getText().contains("Log out"));
			
			registPageObj.Logout();
			Assert.assertTrue(homeObj.loginLink.getText().contains("Log in"));	
	}


}
