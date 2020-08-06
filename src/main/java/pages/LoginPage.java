package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(id = "Email") WebElement emailField;
	@FindBy(id = "Password") WebElement passwordField;
	@FindBy(css = "input.button-1.login-button") WebElement LoginBtn;
	@FindBy(linkText = "Forgot password?") WebElement ForgotPasswordLnk;
	
	public void userLogin(String email, String pass ) 
	{
		setTxt(emailField, email);
		setTxt(passwordField, pass);
		clickBtn(LoginBtn);
	}


	

}
