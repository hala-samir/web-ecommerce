package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchResultPage extends PageBase {

	public ProductSearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "product-title") 
	public WebElement productLink;
	@FindBy(className = "product-name") 
	public WebElement productName;
}
