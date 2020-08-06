package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy (id="FullName") WebElement fullName;
	@FindBy (id="Email") WebElement email;
	@FindBy (id="Enquiry") WebElement enquiry;
	@FindBy (name = "send-email") WebElement submitBtn;
	public @FindBy (className = "result") WebElement successMsg;
	
	public void contactUs(String fname, String mail, String msg) 
	{
		setTxt(fullName,fname);
		setTxt(email,mail);
		setTxt(enquiry,msg);
		clickBtn(submitBtn);
	}
}
