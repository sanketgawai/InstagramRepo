package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class temp {

	//https://www.instagram.com/
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		driver.get("https://www.instagram.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		Actions act = new Actions(driver);
		
		WebElement userName = driver.findElement(By.xpath("//form[@id='loginForm']//label//input"));
		act.moveToElement(userName).click().sendKeys("kaido@gmail.com").build().perform();
		
													//<input aria-label="Password"(use like bellow @name for aria-label)
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		act.moveToElement(pass).click().sendKeys("Empror").build().perform();
		
		WebElement loginButton = driver.findElement(By.cssSelector("form#loginForm button div"));
		loginButton.click();
		
		WebElement errorMassage = driver.findElement(By.xpath("//div[@class='_ab2z']"));
		System.out.println(errorMassage.getText());
		
		String actualresult =errorMassage.getText();
		String expectedresult = "Sorry, your password was incorrect. Please double-check your password.";
		Assert.assertEquals(actualresult, expectedresult);
		
		if(errorMassage.getText().equalsIgnoreCase(expectedresult)) 
		{
			System.out.println("passed");
		}
		else
		{
			System.out.println("failed");
		}
		
	}
	
}
