package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CreateHoliday 
{
	WebDriver driver;

	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement createHolidayPageHeaderText;
	@FindBy(xpath="//*[@id=\"holiday-date-kvdate\"]/span[1]")
	WebElement datePicker;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/thead/tr[2]/th[1]")
	WebElement previousMonth;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/thead/tr[2]/th[2]")
	WebElement MonthYear;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/thead/tr[2]/th[3]")
	WebElement nextMonth;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[contains(@class,'today active day')]") 
	WebElement currentDate; 
	@FindBy(xpath="//*[@id=\"holiday-date\"]")
	WebElement inputDate; 
	@FindBy(xpath="//*[@id=\"holiday-date-kvdate\"]/span[2]")
	WebElement clearDate;
	@FindBy(xpath="//*[@id=\"holiday-date\"]")
	WebElement holidayDate;
	@FindBy(xpath="//*[@id=\"holiday-title\"]")
	WebElement holidayTitle;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]")
	WebElement branchDropdown;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]/option[2]")
	WebElement branchTvmm;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]/option[3]")
	WebElement branchBhopal;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]/option[4]")
	WebElement branchKozhikode;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]/option[6]")
	WebElement branchAll;
	@FindBy(xpath="//*[@id=\"holiday-description\"]")
	WebElement holidayDescription;
	@FindBy(xpath="//*[@id=\"holiday-status\"]")
	WebElement holidayStatus;
	@FindBy(xpath="//*[@id=\"w0\"]/div[15]/div/button")
	WebElement saveButton;
	
	public CreateHoliday(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getCreateHolidayPageHeaderText()
	{
		return createHolidayPageHeaderText.getText();
	}
	public void clickDatePicker()
	{
		PageUtility.waitForElement(driver, datePicker, 5);
		datePicker.click();
	}
	public void clickDate()
	{
		PageUtility.waitForElement(driver, currentDate, 5);
		currentDate.click();
	}
	public void enterDate(String date)
	{
		PageUtility.waitForElement(driver, inputDate, 5);
		inputDate.sendKeys(date);
	}
	public void clickClose()
	{
		PageUtility.waitForElement(driver, clearDate, 5);
		clearDate.click();
	}
	public String getDate()
	{
		return holidayDate.getText();
	}
	public void enterTitle(String title)
	{
		PageUtility.waitForElement(driver, holidayTitle, 5);
		holidayTitle.sendKeys(title);
	}
	public void clickBranchDropdown()
	{
		PageUtility.waitForElement(driver, branchDropdown, 5);
		branchDropdown.click();
	}
	public void clickBranch(String branch)
	{
		if(branch=="Tvmm")
		{
			PageUtility.waitForElement(driver, branchTvmm, 5);
			branchTvmm.click();
		}
		else if(branch=="Bhopal")
		{
			PageUtility.waitForElement(driver, branchBhopal, 5);
			branchBhopal.click();
		}
		else if(branch=="Kozhikode")
		{
			PageUtility.waitForElement(driver, branchKozhikode, 5);
			branchKozhikode.click();
		}
		else if(branch=="All")
		{
			PageUtility.waitForElement(driver, branchAll, 5);
			branchAll.click();
		}
		else
		{}
	}
	public void enterDescription(String description)
	{
		PageUtility.waitForElement(driver, holidayDescription, 5);
		holidayDescription.sendKeys(description);
	}
	public void clickStatus()
	{
		PageUtility.waitForElement(driver, holidayStatus, 5);
		holidayStatus.click();
	}
	public HolidayDetails clickSave()
	{
		PageUtility.waitForElement(driver, saveButton, 5);
		saveButton.click();
		return new HolidayDetails(driver);
	}
	
}
