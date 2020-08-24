package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends PageBase {

	public ShoppingCartPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (name = "updatecart") WebElement updateCartBtn;
	@FindBy (name = "removefromcart") WebElement uncheckProductFromCart;
	public @FindBy (className = "product-subtotal") WebElement productTotal;
	@FindBy (className = "qty-input") WebElement quantity_txt;
	public @FindBy (className = "product-name") WebElement prodname;
	public @FindBy (className = "no-data") WebElement removeFromCartConfirmationMsg;
	@FindBy (id="termsofservice") WebElement termsofservice;
	@FindBy (name ="checkout") WebElement checkoutBtn;

	public  void removeProductFromShoppingCart() throws InterruptedException
	{
		clickBtn(uncheckProductFromCart);
		clickBtn(updateCartBtn);
		Thread.sleep(2000);
	}
	public void updateProductQuantityInCart(String quantity) 

	{
		clearTxt(quantity_txt);
		setTxt(quantity_txt, quantity);	
		clickBtn(updateCartBtn);
	}
	public void checkTermsofServicesCheckbox()
	{
		clickBtn(termsofservice);
	}
	
	public void clickCheckoutBtn() 
	{
		clickBtn(checkoutBtn);
	}
}
