package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class HolidayDetails 
{
	WebDriver driver;

	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a[1]")
	WebElement updateButton;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a[2]")
	WebElement deleteButton;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[1]/td")
	WebElement holidayDate;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[2]/td")
	WebElement holidayTitle;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[3]/td")
	WebElement branch;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[4]/td")
	WebElement holidayDescription;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[5]/td")
	WebElement holidayStatus;
	
	
	public HolidayDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getDate()
	{
		return holidayDate.getText();
	}
	public String getTitle()
	{
		return holidayTitle.getText();
	}
	public String getBranch()
	{
		return branch.getText();
	}
	public String getDescription()
	{
		return holidayDescription.getText();
	}
	public String getStatus()
	{
		return holidayStatus.getText();
	}
	public UpdateHolidayDetails clickUpdate()
	{
		PageUtility.waitForElement(driver, updateButton, 5);
		updateButton.click();
		return new UpdateHolidayDetails(driver);
	}
	public HolidayDeletionAlert clickDelete()
	{
		PageUtility.waitForElement(driver, deleteButton, 5);
		deleteButton.click();
		return new HolidayDeletionAlert(driver);
	}
}
