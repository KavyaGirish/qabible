package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pages.Homepage;
import utilities.PageUtility;

public class Login 
{
	WebDriver driver;
	
	@FindBy(name="LoginForm[username]")
	WebElement username;
	@FindBy(name="LoginForm[password]")
	WebElement password;
	@FindBy(name="login-button")
	WebElement login;
	@FindBy(xpath="//*[@id=\"login-form\"]/div[1]/p")
	WebElement errorMessage;
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public Homepage login(String user, String pass)	
	{
		username.sendKeys(user);
		password.sendKeys(pass);
		login.click();
		return new Homepage(driver);
	}
	public String getErrorMessage()
	{
		PageUtility.waitForElement(driver, errorMessage, 5);
		return errorMessage.getText();
	}
	public void clearTextFields()
	{
		username.clear();
		password.clear();
	}
}
