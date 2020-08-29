package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.UserRegistration;
import tests.TestBase;


public class UserRegistrationUsingCucumber extends TestBase {
	HomePage homePageObj;
	UserRegistration registPageObj;	
	Faker fakeData= new Faker();
	
	@Given("^The user is in homepage$")
	public void the_user_is_in_homepage() 
	{
		homePageObj= new HomePage(driver);
		homePageObj.openRegistrationPage();
	}

	@When("User enters correct data hard coded")
	public void User_enters_correct_data_hard_coded() 
	{
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration("ccc", "ddd", "ttq026@svs.cc", "123456789");	
	}

	
	@When("User enters correct data using Faker")
	public void user_enters_correct_faker() 
	{
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fakeData.name().firstName(), fakeData.name().lastName(),fakeData.internet().emailAddress(), fakeData.number().digits(8));   
	}

	@When("User enters correct data {string}, {string}, {string}, {string}")
	public void user_enters_correct_data(String firstname,String lastname,String email,String password )
	{
		homePageObj= new HomePage(driver);
		registPageObj=new UserRegistration(driver);

		registPageObj.userRegisteration(firstname,lastname, email, password);   
	}
	
	@Then("^User can registered successfully$")
	public void user_can_registared_successfully() 
	{
		registPageObj=new UserRegistration(driver);
		registPageObj.Logout();
	}
}
