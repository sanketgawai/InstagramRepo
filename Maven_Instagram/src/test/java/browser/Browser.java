package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	static WebDriver driver;
	
//	public Browser(WebDriver driver2) {
//		this.driver= driver2;
//	}

	public static WebDriver openChromeBrowser() {
		System.setProperty("webdriver.chrome.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		return driver;
	}
	
	public static WebDriver openFirefoxBrowser() {
		System.setProperty("webdriver.gecko.driver","E:\\software testing\\selenium\\new browser chromium chrome driver\\chromedriver-win64\\geckodriver.exe");
		ChromeOptions co = new ChromeOptions();
		co.setBinary("E:\\software testing\\selenium\\new browser for testing chromium\\chrome-win64\\chrome.exe");
		co.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(co);
		return driver;
	}
}
