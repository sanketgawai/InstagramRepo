package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.TestResult;

import PomClasses.HomePage;
import browser.Browser;


public class Testt {
	WebDriver driver;
	HomePage homePage;
	@BeforeTest
	public void openBrowser()
	{
		System.out.println("kaido");
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
//	@Parameters("browser")//***ye browser parameter ka name hai
//	@BeforeTest
//	public void openBrowser(String browserName) { 
//		//***browser ki value is String browserName mi ayegi
//		
//		//Browser browser = new Browser(driver);
//		if(browserName.equals("Chrome")) {
//			driver =	Browser.openChromeBrowser();
//		}
//		//if(browserName.equals("Firefox")) {
//		//	driver =	Browser.openFirefoxBrowser();
//		//}
//	}
	
	@BeforeClass
	public void objectOfClass()
	{
		homePage = new HomePage(driver);
	}
	
	@BeforeMethod
	public void openApplication()
	{
		driver.get("https://www.instagram.com/");
	}
	
	@Test
	public void checkErrorMassage()
	{
		homePage.sendUserName();
		homePage.sendPassWord();
		homePage.clickOnLoginButton();
		
		String actualResult = homePage.getErrorMassage();
		String expectedResult = "Sorry, your password was incorrect. Please double-check your password.";
		//Sorry, your password was incorrect. Please double-check your password.
		Assert.assertEquals(actualResult, expectedResult);//assertion are notworking
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println("true"+" "+"->"+" "+"we got message");
		}
		else
		{
			System.out.println("false"+" "+"->"+" "+"we don't got message");
		}
		
	}
	
	@Test
	public void makeErrorMassageFailWithWrongExpResult()
	{
		homePage.sendUserName();
		homePage.sendPassWord();
		homePage.clickOnLoginButton();
		
		String actualResult = homePage.getErrorMassage();
		String expectedResult = "Sorr, your password was incorrect. Please double-check your password.";
		//Sorry, your password was incorrect. Please double-check your password.
		Assert.assertEquals(actualResult, expectedResult);
		if(actualResult.equalsIgnoreCase(expectedResult))
		{
			System.out.println("true"+" "+"->"+" "+"we got message");
		}
		else
		{
			System.out.println("false"+" "+"->"+" "+"we don't got message");
		}
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		System.out.println("After method");
//		if(TestResult.FAILURE == result.getStatus())
//		{
//			Utility.captureScreenShot(driver, TestID);
//		}
//		ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
//		driver.switchTo().window(addr.get(0));
	}
	
	@AfterClass
	public void clearPomObjects () {
		
		homePage = null;
	}
	
	@AfterTest	
	public void afterTest () 
	{
		System.out.println("After Test");
		driver.quit();
		driver = null;
		System.gc(); 
	}
		
	
}
