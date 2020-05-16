package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility 
{
	public static void handleSleep(int milliseconds) 
	{
		try 
		{
			Thread.sleep(milliseconds);
		} 
		catch(InterruptedException e) 
		{	e.printStackTrace();	}
	}
	
	public static void waitForElementSelected(WebDriver driver, WebElement element, int time) 
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public static void waitForElementClicked(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void waitForElementDisplayed(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void waitForAlert(WebDriver driver, WebElement element, int time)
	{
		WebDriverWait wait = new WebDriverWait(driver,time);
		wait.until(ExpectedConditions.alertIsPresent());
	}
}
