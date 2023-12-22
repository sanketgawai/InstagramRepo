package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//form[@id='loginForm']//label//input")
	private WebElement userName;

	@FindBy(xpath="//input[@name='password']")
	private WebElement passWord;
	
	@FindBy(css="form#loginForm button div")
	private WebElement loginButton;
	
	@FindBy(xpath="//div[@class='_ab2z']")
	private WebElement errorMassage;
	
	public HomePage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	
	public void sendUserName()
	{
		act.moveToElement(userName).click().sendKeys("kaido@gmail.com").build().perform();
	}
	
	public void sendPassWord()
	{
		act.moveToElement(passWord).click().sendKeys("Empror").build().perform();
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
	
	public String getErrorMassage()
	{
		String massage =errorMassage.getText();
		return massage;
	}
}
