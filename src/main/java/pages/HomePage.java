package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {

	public HomePage(WebDriver driver) {
		super(driver);
		js= (JavascriptExecutor) driver;
		action= new Actions(driver);
	} 

	@FindBy(linkText = "Register")WebElement registerLink;
	public @FindBy(linkText = "Log in")WebElement loginLink;
	public @FindBy(id = "small-searchterms")WebElement searchField;
	public @FindBy(className = "search-box-button")WebElement searchBtn;	
	public @FindBy (id= "ui-id-1")  List<WebElement> productList;
	@FindBy(linkText = "Contact us") WebElement contactUsLink;
	@FindBy(id = "customerCurrency") WebElement currencyDDL;
	@FindBy (linkText = "Computers") WebElement computerMenu;
	@FindBy (linkText = "Notebooks") WebElement notbooksItem;
	


	public void openRegistrationPage()
	{
		clickBtn(registerLink);
	}

	public void openLoginPage()
	{
		clickBtn(loginLink);
	}
	public void searchProduct(String productName)
	{
		setTxt(searchField, productName);
		clickBtn(searchBtn);		
	}
	public void searchProductUsingAutoSuggestion(String productName)
	{
		setTxt(searchField, productName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		productList.get(0).click();				
	}
	public void openContactUsPage()
	{
		scrollDown();	
		contactUsLink.click();
	}
	public void changeCurrency() 
	{
		select = new Select(currencyDDL);
		select.selectByVisibleText("Euro");
	}
	public void selectNotbooksFromMenu()
	{
		 action.moveToElement(computerMenu).build().perform();
		 action.moveToElement(notbooksItem).click().build().perform();
	}


}
