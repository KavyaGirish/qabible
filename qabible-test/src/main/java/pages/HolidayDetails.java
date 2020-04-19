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
	public String getHolidayDateInHolidayDetailsPage()
	{
		return holidayDate.getText();
	}
	public String getHolidayTitleInHolidayDetailsPage()
	{
		return holidayTitle.getText();
	}
	public String getBranchInHolidayDetailsPage()
	{
		return branch.getText();
	}
	public String getHolidayDescriptionInHolidayDetailsPage()
	{
		return holidayDescription.getText();
	}
	public String getHolidayStatusInHolidayDetailsPage()
	{
		return holidayStatus.getText();
	}
	public UpdateHolidayDetails clickUpdateButtonInHolidayDetailsPage()
	{
		PageUtility.waitForElement(driver, updateButton, 5);
		updateButton.click();
		return new UpdateHolidayDetails(driver);
	}
	public HolidayDeletionAlert clickDeleteButtonInHolidayDetailsPage()
	{
		PageUtility.waitForElement(driver, deleteButton, 5);
		deleteButton.click();
		return new HolidayDeletionAlert(driver);
	}
}
