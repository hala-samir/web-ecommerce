package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailFriendPage extends PageBase {
	public EmailFriendPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id = "FriendEmail")WebElement friendEmail;
	@FindBy (id = "YourEmailAddress")WebElement yourEmail;
	@FindBy (id = "PersonalMessage")WebElement message;
	@FindBy (name = "send-email")WebElement sendBtn;
	public @FindBy (className = "page-title")WebElement emailFriendPageTitle;
	public @FindBy (className = "result") WebElement confirmationMsg;
	
	public void emailFriend(String friend_mail, String msg) 
	{
		setTxt(friendEmail,friend_mail);
		setTxt(message,msg);
		clickBtn(sendBtn);
	} 


}
