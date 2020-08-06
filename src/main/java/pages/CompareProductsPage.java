package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompareProductsPage extends PageBase{

	public CompareProductsPage(WebDriver driver) {
		super(driver);		
	}

	@FindBy(className = "clear-list") WebElement clearListBtn;
	@FindBy(className = "compare-products-table") WebElement compareTable;
	public @FindBy(tagName = "tr") List<WebElement> allRows;
	public @FindBy(tagName = "td") List<WebElement> allCols;
	public @FindBy (className = "no-data") WebElement emptyMsg;
	public @FindBy (linkText = "Apple MacBook Pro 13-inch")WebElement prodOne;
	public @FindBy (linkText = "Asus N551JK-XO076H Laptop")WebElement prodTwo;

	
	public void clearCompareList() 
	{
		clickBtn(clearListBtn);
	}
	
	public void compareProducts() 
	{
		System.out.println(allRows.size());
		for(WebElement row : allRows) {
			System.out.println(row.getText()+ "\t");
			for(WebElement column: allCols) {
				System.out.println(column.getText()+"\t");
			}
		}
	}

}
