package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckoutPage;
import pages.CompareProductsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccount;
import pages.OrderDetailsPage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import pages.ShoppingCartPage;
import pages.UserRegistration;

public class RegisteredUserCanCheckoutProduct extends TestBase{
	HomePage homeObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	MyAccount myAccObj;
	ProductPage prodPageObj;
	ProductSearchResultPage prodSearchResultPageObj;
	ShoppingCartPage shoppingCartPageObj;
	CompareProductsPage compareProductsPageObj;
	CheckoutPage checkoutPageObj;
	OrderDetailsPage orderDetailsPageobj;

	String ProductName_1 = "Apple MacBook Pro 13-inch";
	String productPartialName = "Apple Mac";
	String fname="Tester";
	String lname="Test";
	String email="tester@fef3.com";
	String oldPass="123456789";
	String newPass="12345678";
	String country="Egypt";
	String  cityName= "Alex";
	String address="test";
	String postalCode="123456";
	String phone_num= "1234567890";


	@Test(priority = 1, alwaysRun = true)
	public void userCanRegisterSuccessfully() 
	{	
		homeObj=new HomePage(driver);
		homeObj.openRegistrationPage();
		registPageObj=new UserRegistration(driver);
		registPageObj.userRegisteration(fname, lname, email, oldPass);
		Assert.assertTrue(registPageObj.successMsg.getText().contains("Your registration completed"));
	}

//	@Test( dependsOnMethods = "userCanRegisterSuccessfully")
	@Test(priority=2, alwaysRun = true) 
	public void userCanAddtoShoppingCart() throws InterruptedException
	{
		prodPageObj = new ProductPage(driver);
		homeObj= new HomePage(driver);
		shoppingCartPageObj= new ShoppingCartPage(driver);
		compareProductsPageObj = new CompareProductsPage(driver);

		homeObj.searchProductUsingAutoSuggestion(ProductName_1);
		Assert.assertEquals(prodPageObj.productName.getText(), ProductName_1);

		prodPageObj.addProductToShoppingCart();
		Assert.assertTrue(prodPageObj.notificationBar.getText().contains("The product has been added to your shopping cart"));
		prodPageObj.visitShoppingCartPage();
		Assert.assertTrue(shoppingCartPageObj.prodname.getText().contains(ProductName_1));
		shoppingCartPageObj.checkTermsofServicesCheckbox();
		shoppingCartPageObj.clickCheckoutBtn();
	}
	
	//@Test( dependsOnMethods = "userCanAddtoShoppingCart")
	@Test(priority=3, alwaysRun = true) 
	public void userCanCheckoutProduct() throws InterruptedException
	{
		prodPageObj = new ProductPage(driver);
		homeObj= new HomePage(driver);
		orderDetailsPageobj = new OrderDetailsPage(driver);
		shoppingCartPageObj= new ShoppingCartPage(driver);
		compareProductsPageObj = new CompareProductsPage(driver);
		checkoutPageObj= new CheckoutPage(driver);
		
		checkoutPageObj.registeredUserCanCheckoutProduct(country, cityName, address, postalCode, phone_num);
		checkoutPageObj.visitOrderDetailsPage();
		orderDetailsPageobj.printOrderDetails();
		orderDetailsPageobj.showPDFOrderDetails();
	}
	
	//@Test(dependsOnMethods = "userCanCheckoutProduct" )
	@Test(priority=4, alwaysRun = true) 
	public void Logout() throws InterruptedException 
	{
		homeObj=new HomePage(driver);
		registPageObj.Logout();
		Thread.sleep(1000);		
		Assert.assertTrue(homeObj.loginLink.isDisplayed());		
	}

}
