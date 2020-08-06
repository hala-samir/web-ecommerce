package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase {

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	public @FindBy (css="strong.current-item") WebElement productNameBreadCrumb;
	public @FindBy (className = "product-name") WebElement productName;
	public @FindBy (className = "product-price") WebElement productPrice;
	public @FindBy (css =  "input.button-2.email-a-friend-button") WebElement emailAfriendBtn;
	@FindBy (linkText = "Add your review") WebElement addReview;	
	@FindBy (id="add-to-wishlist-button-4") WebElement addToWishlist;
	@FindBy(className = "close") WebElement closeSuccessMsg;
	public @FindBy (id = "bar-notification") WebElement notificationBar;
	@FindBy (css = "input.button-2.add-to-compare-list-button") WebElement addToCompareList;
	@FindBy (linkText = "product comparison") WebElement compareProductsPageLink;
	public@FindBy (css = "div.bar-notification.success") WebElement compareProductSuccessMsg;
	@FindBy (id="add-to-cart-button-4") WebElement addToShoppingCart;
	@FindBy (linkText = "shopping cart") WebElement shoppingCartPageLink;

	public void visitEmailFriendPage()
	{
		clickBtn(emailAfriendBtn);
	}
	
	public void visitReviewProductPage()
	{
		clickBtn(addReview);
	}
	
	public void addProductToWishList() throws InterruptedException
	{
		addToWishlist.click();
		Thread.sleep(3000);
	}
	
	public void addProductToCompareList() throws InterruptedException
	{
		clickBtn(addToCompareList);
		Thread.sleep(3000);
	}

	public void visitCompareProductPage() throws InterruptedException
	{
		clickBtn(compareProductsPageLink);
		Thread.sleep(3000);
	}

	public void addProductToShoppingCart() throws InterruptedException 
	{
		clickBtn(addToShoppingCart);
		Thread.sleep(3000);
	}

	public void visitShoppingCartPage()
	{
		clickBtn(shoppingCartPageLink);
	}
	
	public void closeSuccessMsg()
	{
		closeSuccessMsg.click();
	}
}
