package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistration extends PageBase {

	public UserRegistration(WebDriver driver) {
		super(driver);
	}
	@FindBy(id="gender-female")
	WebElement gender;
	
	@FindBy(id = "FirstName")
	WebElement firstname;
	
	@FindBy(id="LastName")
	WebElement lastName;
	
	@FindBy(id="Email")
	WebElement mail;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(id="ConfirmPassword")
	WebElement confirmPassword;
	
	@FindBy(id="register-button")
	WebElement registerBtn;
	
	@FindBy(css = "div.result")
	public WebElement successMsg;
	
	@FindBy(linkText = "Log out")
	public WebElement logout;
	
	@FindBy(className = "ico-account")
	public WebElement MyAccount;

	public void userRegisteration(String fname, String lname,String email, String pass ) 
	{
		clickBtn(gender);
		setTxt(firstname, fname);
		setTxt(lastName, lname);
		setTxt(mail, email);
		setTxt(password, pass);
		setTxt(confirmPassword, pass);
		clickBtn(registerBtn);
	}
	
	public void AccessMyAccount() 
	{
		MyAccount.click();	
	}
	
	public void Logout() 
	{
		logout.click();
	}
	

}
