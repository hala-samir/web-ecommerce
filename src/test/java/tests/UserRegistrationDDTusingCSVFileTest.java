package tests;

import java.io.FileReader;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import pages.HomePage;
import pages.LoginPage;
import pages.UserRegistration;

public class UserRegistrationDDTusingCSVFileTest extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	CSVReader reader;

	@Test(priority = 1)
	public void userCanRegisterSuccessfully() throws CsvValidationException, IOException 
	{
		String csvFile = System.getProperty("user.dir")+ "\\src\\test\\java\\data\\UserRegistrationData1.csv";
		reader= new CSVReader(new FileReader(csvFile));
		String [] csvCell;
		while ((csvCell= reader.readNext())!= null) {
			String firstName =csvCell[0];
			String lastName =csvCell[1];
			String email = csvCell[2];
			String password = csvCell[3];
			
			homeObj=new HomePage(driver);
			homeObj.openRegistrationPage();

			registPageObj=new UserRegistration(driver);
			registPageObj.userRegisteration(firstName, lastName, email, password);		
			Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
			
			registPageObj.Logout();
			
			homeObj.openLoginPage();
			
			loginObj= new LoginPage(driver);
			loginObj.userLogin(email,password);
			Assert.assertTrue(registPageObj.logout.getText().contains("Log out"));
			
			registPageObj.Logout();
			Assert.assertTrue(homeObj.loginLink.getText().contains("Log in"));			
		}
		
	}




}
