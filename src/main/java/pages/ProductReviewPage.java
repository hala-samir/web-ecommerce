package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReviewPage extends PageBase{
	public ProductReviewPage(WebDriver driver) {
		super(driver);
	}
	@FindBy (id="AddProductReview_Title")WebElement reviewTitle;
	@FindBy (id = "AddProductReview_ReviewText")WebElement reviewTxt;
	@FindBy (id="addproductrating_3") WebElement rate;
	@FindBy (name = "add-review")WebElement submitBtn;
	public @FindBy (className = "result")WebElement reviewSuccessMsg;
	
	public void addReview(String review_title, String review_txt)
	{
		setTxt(reviewTitle, review_title);
		setTxt(reviewTxt, review_txt);
		clickBtn(rate);
		clickBtn(submitBtn);
	}

	

}
