package tests;


import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import helpers.Helper;
import io.cucumber.testng.AbstractTestNGCucumberTests;


public class TestBase extends AbstractTestNGCucumberTests
{
	public static WebDriver driver;
	public static String downloadPath=System.getProperty("user.dir")+"/downloads";


	public static FirefoxOptions firefoxOption() 
	{
		FirefoxOptions option= new FirefoxOptions();
		option.addPreference("browser.download.folderList", 2);
		option.addPreference("browser.download.dir", downloadPath);
		option.addPreference("browser.helperApps.neverAsk.SaveToDisk", "application/pdf,application/octet-stream");
		option.addPreference("browser.download.manager.showWhenStarting",false);
		option.addPreference("pdfjs.disabled", true);
		return option;
	}
	public static ChromeOptions chromeOption() 
	{
		ChromeOptions options = new ChromeOptions();

		HashMap<String, Object> chromePrefs= new HashMap<String, Object>();
		chromePrefs.put("profile.default.content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadPath);
		options.setExperimentalOption("prefs",chromePrefs);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		return options;
	}
	@BeforeSuite
	@Parameters("browser")
	public void StartDriver(@Optional("chrome")String browserName)
	{
		if (browserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"/drivers/geckodriver.exe");

			driver=new FirefoxDriver(firefoxOption());	
			//driver= new FirefoxDriver();
			System.out.println("yalahwiiiiiiii2");

		}
		else if(browserName.equalsIgnoreCase("headless")) 
		{
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, System.getProperty("user.dir")+"/drivers/phantomjs.exe");

			driver = new PhantomJSDriver(caps);
			String [] phantomJsArgs = {"--web-security=no", "--ignore-ssl-errors=yes"};
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver=new PhantomJSDriver(caps);
			System.out.println("yalahwiiiiiiii");

		}
		else if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers2/chromedriver.exe");
			driver=new ChromeDriver(chromeOption());
			//	driver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("chromeHeadless"))
		{
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir")+"/drivers2/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			driver= new ChromeDriver(options);			
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
