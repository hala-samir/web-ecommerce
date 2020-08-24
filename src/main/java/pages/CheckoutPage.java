package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CheckoutPage extends PageBase {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id="BillingNewAddress_FirstName")WebElement fName;
	@FindBy (id="BillingNewAddress_LastName")WebElement lName;
	@FindBy (id="BillingNewAddress_Email") WebElement email;

	@FindBy (id = "BillingNewAddress_CountryId") WebElement countryDDL;
	@FindBy(id = "BillingNewAddress_City") WebElement city;
	@FindBy (id= "BillingNewAddress_Address1") WebElement address1;
	@FindBy (id="BillingNewAddress_ZipPostalCode")WebElement zip;
	@FindBy (id = "BillingNewAddress_PhoneNumber")WebElement phone;
	@FindBy(css="input.button-1.new-address-next-step-button")WebElement continueBtn;

	@FindBy (id="shippingoption_1")WebElement shippingOption;
	@FindBy(css = "input.button-1.shipping-method-next-step-button") WebElement continueBtn2;
	@FindBy(css = "input.button-1.payment-method-next-step-button")WebElement continueBtn3;
	@FindBy(css = "input.button-1.payment-info-next-step-button")WebElement continueBtn4;

	@FindBy(className = "product-name")WebElement productName;
	@FindBy(css= "input.button-1.confirm-order-next-step-button")WebElement confirmBtn;

	@FindBy (className = "title")WebElement successMsg;
	@FindBy (css="input.button-1.order-completed-continue-button")WebElement continueBtn5;
	@FindBy (linkText = "Click here for order details.")WebElement orderDetailsLnk;
	public void visitOrderDetailsPage() throws InterruptedException 
	{
		clickBtn(orderDetailsLnk);
		Thread.sleep(2000);
	}
	public void registeredUserCanCheckoutProduct(String country,String cityName,String address,
			String postalCode, String phone_num ) throws InterruptedException 
	{
		select = new Select(countryDDL);
		select.selectByVisibleText(country);
		setTxt(city, cityName);
		setTxt(address1, address);
		setTxt(zip, postalCode);
		setTxt(phone, phone_num);
		clickBtn(continueBtn);
		Thread.sleep(1000);

		clickBtn(shippingOption);
		clickBtn(continueBtn2);
		Thread.sleep(1000);

		clickBtn(continueBtn3);
		Thread.sleep(1000);

		clickBtn(continueBtn4);
		Thread.sleep(1000);
		
		Assert.assertTrue(productName.isDisplayed());
		clickBtn(confirmBtn);
		Thread.sleep(1000);
		
		Assert.assertTrue(successMsg.isDisplayed());
	}

}
