package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CompareProductsPage;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import pages.ShoppingCartPage;
import pages.UserRegistration;

public class ShoppingCartTest extends TestBase {
	ProductPage prodPageObj;
	HomePage homeObj;
	ProductSearchResultPage prodSearchResultPageObj;
	UserRegistration registPageObj;
	LoginPage loginObj;
	ShoppingCartPage shoppingCartPageObj;
	CompareProductsPage compareProductsPageObj;

	String quantity = "3";
	String ProductName_1 = "Apple MacBook Pro 13-inch";
	
	@Test(priority=1, alwaysRun = true)
	public void userCanAddtoShoppingCart() throws InterruptedException
	{
		homeObj= new HomePage(driver);
		prodPageObj = new ProductPage(driver);
		shoppingCartPageObj= new ShoppingCartPage(driver);
		compareProductsPageObj = new CompareProductsPage(driver);

		homeObj.searchProductUsingAutoSuggestion(ProductName_1);
		Assert.assertEquals(prodPageObj.productName.getText(), ProductName_1);

		prodPageObj.addProductToShoppingCart();
		Assert.assertTrue(prodPageObj.notificationBar.getText().contains("The product has been added to your shopping cart"));
		prodPageObj.visitShoppingCartPage();
		Assert.assertTrue(shoppingCartPageObj.prodname.getText().contains(ProductName_1));

	}
	//@Test(dependsOnMethods = "userCanAddtoShoppingCart")
	@Test(priority=2, alwaysRun = true) 
	public void userCanChnageQuantityOfShoppingCart() throws InterruptedException
	{
		homeObj= new HomePage(driver);
		shoppingCartPageObj= new ShoppingCartPage(driver);
		shoppingCartPageObj.updateProductQuantityInCart(quantity);
		Assert.assertTrue(shoppingCartPageObj.productTotal.getText().contains("5,400.00"));		
	}
	
	//@Test( dependsOnMethods = "userCanChnageQuantityOfShoppingCart")
	@Test(priority=3, alwaysRun = true) 
	public void userCanRemoveFromShoppingCart() throws InterruptedException
	{
		homeObj= new HomePage(driver);
		shoppingCartPageObj= new ShoppingCartPage(driver);
		shoppingCartPageObj.removeProductFromShoppingCart();
		shoppingCartPageObj.removeFromCartConfirmationMsg.getText().contains("Your Shopping Cart is empty");
	}

}
