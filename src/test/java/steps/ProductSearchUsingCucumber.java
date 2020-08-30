package steps;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;
import pages.ProductSearchResultPage;
import tests.TestBase;

public class ProductSearchUsingCucumber extends TestBase {
	HomePage homeObj;
	ProductPage productPageObj;
	ProductSearchResultPage prodSearchResultPageObj;
	String productName = "Apple MacBook Pro 13-inch";

	@Given("The user accesses homepage")
	public void user_accesses_homepage() 
	{
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		Assert.assertTrue(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"));
	}

	@When("The user fills a search textfield with data {string}")
	public void the_user_fills_a_search_textfield_with_data(String productPartialName) 
	{
		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver); 

		homeObj.searchProductUsingAutoSuggestion(productPartialName);

	}
	@Then("The product page is displayed successfully")
	public void  product_page_is_displayed_successfully() {

		homeObj = new HomePage(driver);
		productPageObj = new ProductPage(driver);
		prodSearchResultPageObj = new ProductSearchResultPage(driver);
		Assert.assertEquals(prodSearchResultPageObj.productName.getText(), productName);

	}



}
