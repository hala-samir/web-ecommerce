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
	@Test(priority=1) 
	public void contactUsTest() 
	{
		homeObj= new HomePage(driver);
		contactUspageObj= new ContactUsPage(driver);
		
		homeObj.openContactUsPage();
		contactUspageObj.contactUs(fname, mail, msg);
		Assert.assertTrue(contactUspageObj.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner.") );
	}
}
