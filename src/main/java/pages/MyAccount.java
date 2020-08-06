package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccount extends PageBase 
{

	public MyAccount(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Change password") WebElement ChangePasswordLink;
	@FindBy(id = "OldPassword") WebElement OldPassword;
	@FindBy(id = "NewPassword") WebElement NewPassword;
	@FindBy(id = "ConfirmNewPassword") WebElement ConfirmNewPassword;
	@FindBy(css = "input.button-1.change-password-button") WebElement SaveBtn;
	public @FindBy(css = "div.result")WebElement SuccessMsg;


	public void clickChangePassword()
	{
		clickBtn(ChangePasswordLink);
	}

	public void ChangePassword(String oldPass, String newPass)
	{
		setTxt(OldPassword, oldPass);
		setTxt(NewPassword, newPass);
		setTxt(ConfirmNewPassword, newPass);
		clickBtn(SaveBtn);
	}
}
