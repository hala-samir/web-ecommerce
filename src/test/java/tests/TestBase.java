package tests;

import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helpers.Helper;

public class TestBase
{
	public static WebDriver driver;
	@BeforeSuite
	@Parameters("browser")
	public void StartDriver(@Optional("chrome")String browserName)
	{
		if (browserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");
			driver=new FirefoxDriver();				
		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("ie"))
		{
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"/drivers/IEDriverServer.exe");
			driver=new InternetExplorerDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.navigate().to("https://demo.nopcommerce.com/");
	}

	@AfterSuite
	public void stopDriver() 
	{
		driver.quit();
	}
	@AfterMethod 
	public void screenshotOnFailure(ITestResult result) 
	{
		if(result.getStatus() == ITestResult.FAILURE) {
			System.out.println("FAILED");
			System.out.println("Taking screenshot....");
			Helper.takeScreenshot(driver, result.getName());
		}
	}


}
