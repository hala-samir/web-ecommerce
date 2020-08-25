package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.*;
import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsTest extends TestBase {
	ContactUsPage contactUspageObj;
	HomePage homeObj;
	String fname = "tester";
	String mail = "tester@test.com";
	String msg = "I have a message";
	@Test
	@Severity(SeverityLevel.MINOR)
	@Description("Contact us testcase")

	public void contactUsTest() 
	{
		homeObj= new HomePage(driver);
		contactUspageObj= new ContactUsPage(driver);

		homeObj.openContactUsPage();
		contactUspageObj.contactUs(fname, mail, msg);
		Assert.assertTrue(contactUspageObj.successMsg.getText().contains("Your enquiry has been successfully sent to the store owner.") );
	}
}
