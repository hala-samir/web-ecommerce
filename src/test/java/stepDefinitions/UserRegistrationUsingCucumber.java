package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistration;
import tests.TestBase;

public class UserRegistrationUsingCucumber extends TestBase {
	HomePage homePageObj;
	UserRegistration registPageObj;	
	
	@Given("The user is in homepage")
	public void the_user_is_in_homepage() 
	{
		homePageObj= new HomePage(driver);
		homePageObj.openRegistrationPage();
	}
	@When("User clicks registartion link")
	public void user_clicks_registartion_link() 
	{  	
		Assert.assertTrue(driver.getCurrentUrl().contains("register"));   
	}
	
	@When("User enters correct data")
	public void he_enters_correct_data() 
	{
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration("ccc", "ddd", "teetts3@sss.cc", "123456789");	
	}
	
	@Then("User can registered successfully")
	public void user_can_registared_successfully() 
	{
		registPageObj=new UserRegistration(driver);
		registPageObj.Logout();
	}
}
