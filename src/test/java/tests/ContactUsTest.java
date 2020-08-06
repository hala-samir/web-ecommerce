package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	ContactUsPage contactUspageObj;
	HomePage homeObj;
	String fname = "tester";
	String mail = "tester@test.com";
	String msg = "I have a message";
	@Test
	public void contactUsTest() 
	{
		homeObj= new HomePage(driver);
		homeObj.openContactUsPage();
		contactUspageObj= new ContactUsPage(driver);
		contactUspageObj.contactUs(fname, mail, msg);
		Assert.assertEquals(contactUspageObj.successMsg.getText(), "Your enquiry has been successfully sent to the store owner.");
	}
}
