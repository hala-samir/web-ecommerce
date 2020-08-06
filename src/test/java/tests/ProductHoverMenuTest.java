package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class ProductHoverMenuTest extends TestBase
{
	HomePage homePageObj;
	@Test
	public void userCanSelectSubcateorgyFromMainMenu()
	{
		homePageObj = new HomePage(driver);
		homePageObj.selectNotbooksFromMenu();
		Assert.assertTrue(driver.getTitle().contains("Notebooks"));

	}
}
