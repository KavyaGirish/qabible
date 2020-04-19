package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Holiday 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement holidayPageHeaderText;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a")
	WebElement createHolidayButton;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[1]")
	WebElement viewButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[2]")
	WebElement updateButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[3]")
	WebElement deleteButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[11]/td[7]/a[3]/span")
	WebElement deleteButtonOfHoliday3;
	
	
	public Holiday(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getHolidayPageHeaderText()
	{
		return holidayPageHeaderText.getText();
	}
	public CreateHoliday clickCreateHolidayButton()
	{
		PageUtility.waitForElement(driver, createHolidayButton, 5);
		createHolidayButton.click();
		return new CreateHoliday(driver);
	}
	public HolidayDetails clickViewButtonOfHoliday2()	
	{
		PageUtility.waitForElement(driver, viewButtonOfHoliday2, 5);
		viewButtonOfHoliday2.click();
		return new HolidayDetails(driver);
	}
	public UpdateHolidayDetails clickUpdateButtonOfHoliday2()
	{
		PageUtility.waitForElement(driver, updateButtonOfHoliday2, 5);
		updateButtonOfHoliday2.click();
		return new UpdateHolidayDetails(driver);
	}
	public HolidayDeletionAlert clickDeleteButtonOfHoliday2()
	{
		PageUtility.waitForElement(driver, deleteButtonOfHoliday2, 5);
		deleteButtonOfHoliday2.click();
		return new HolidayDeletionAlert(driver);
	}
	public HolidayDeletionAlert clickDeleteButtonOfHoliday3()
	{
		PageUtility.waitForElement(driver, deleteButtonOfHoliday3, 5);
		deleteButtonOfHoliday3.click();
		return new HolidayDeletionAlert(driver);
	}
	
}
