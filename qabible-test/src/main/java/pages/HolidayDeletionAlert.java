package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HolidayDeletionAlert 
{
	WebDriver driver;
	
	public HolidayDeletionAlert(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public HolidayDetails dismissAlertBoxForHolidayDeletion()
	{
		driver.switchTo().alert().dismiss();
		return new HolidayDetails(driver);
	}
	public Holiday acceptAlertBoxForHolidayDeletion()
	{
		driver.switchTo().alert().accept();
		return new Holiday(driver);
	}
}
