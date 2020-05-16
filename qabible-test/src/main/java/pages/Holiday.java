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
	@FindBy(xpath="//*[@id=\"w0\"]/table")
	WebElement tableContainingHolidays;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[1]")
	WebElement viewButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[2]")
	WebElement updateButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[10]/td[7]/a[3]")
	WebElement deleteButtonOfHoliday2;
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr[12]/td[7]/a[3]")
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
	public CreateHoliday clickCreateHoliday()
	{
		PageUtility.waitForElementClicked(driver, createHolidayButton, 5);
		createHolidayButton.click();
		return new CreateHoliday(driver);
	}
	public HolidayDetails clickView(String holiday)	
	{
		if(holiday=="Holiday2")
		{
			PageUtility.waitForElementClicked(driver, viewButtonOfHoliday2, 5);
			viewButtonOfHoliday2.click();
		}
		else 
		{}
		return new HolidayDetails(driver);
	}
	public UpdateHolidayDetails clickUpdate(String holiday)
	{
		if(holiday=="Holiday2")
		{
			PageUtility.waitForElementClicked(driver, updateButtonOfHoliday2, 5);
			updateButtonOfHoliday2.click();
		}
		return new UpdateHolidayDetails(driver);
	}
	public HolidayDeletionAlert clickDelete(String holiday)
	{
		if(holiday=="Holiday2")
		{
			PageUtility.waitForElementClicked(driver, deleteButtonOfHoliday2, 5);
			deleteButtonOfHoliday2.click();
		}
		else if(holiday=="Holiday3")
		{
			PageUtility.waitForElementClicked(driver, deleteButtonOfHoliday3, 5);
			deleteButtonOfHoliday3.click();
		}
		else
		{}
		return new HolidayDeletionAlert(driver);
	}
	public boolean getWebElementsVisibility()
	{
		Boolean visibilityOfElement;
		if(holidayPageHeaderText.isDisplayed()&& createHolidayButton.isDisplayed()&& tableContainingHolidays.isDisplayed())
		{
			visibilityOfElement= true;
		}
		else
		{
			visibilityOfElement= false;
		}
		return visibilityOfElement;
	}
}
