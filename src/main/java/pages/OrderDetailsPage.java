package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderDetailsPage extends PageBase {

	public OrderDetailsPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Print") WebElement printOrderDetailsLnk;
	@FindBy(linkText = "PDF Invoice") WebElement pdfOrderDetailsLnk;
	
	public void printOrderDetails() throws InterruptedException 
	{
		clickBtn(printOrderDetailsLnk);	
		Thread.sleep(1000);
	}
	
	public void showPDFOrderDetails() throws InterruptedException
	{
		clickBtn(pdfOrderDetailsLnk);
		Thread.sleep(1000);
	}
	

}
