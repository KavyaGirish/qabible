package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UpdateHolidayDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"holiday-date-kvdate\"]/span[1]")
	WebElement datePicker;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[4]")
	WebElement date15April2020;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[5]")
	WebElement date16April2020;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[6]")
	WebElement date17April2020;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[7]")
	WebElement date18April2020;
	@FindBy(xpath="//*[@id=\"holiday-date-kvdate\"]/span[2]")
	WebElement clearDate;
	@FindBy(xpath="//*[@id=\"holiday-date\"]")
	WebElement holidayDate;
	@FindBy(xpath="//*[@id=\"holiday-title\"]")
	WebElement holidayTitle;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]")
	WebElement branchDropdown;
	@FindBy(xpath="//*[@id=\"holiday-branch_id\"]/option[2]")
	WebElement branchBanglore;
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
	
	
	public UpdateHolidayDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickDatePickerButtonInCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, datePicker, 5);
		datePicker.click();
	}
	public void clickDate15April2020InCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, date15April2020, 5);
		date15April2020.click();
	}
	public void clickDate16April2020InCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, date16April2020, 5);
		date16April2020.click();
	}
	public void clickDate17April2020InCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, date17April2020, 5);
		date17April2020.click();
	}
	public void clickDate18April2020InCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, date18April2020, 5);
		date18April2020.click();
	}
	public void clickCrossButtonInCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, clearDate, 5);
		clearDate.click();
	}
	public String getUpdatedDatePickedForHoliday()
	{
		return holidayDate.getText();
	}
	public void enterUpdatedTitleForHolidayInCreateHolidayPage(String title)
	{
		PageUtility.waitForElement(driver, holidayTitle, 5);
		holidayTitle.clear();
		holidayTitle.sendKeys(title);
	}
	public void clickBranchDropdown()
	{
		PageUtility.waitForElement(driver, branchDropdown, 5);
		branchDropdown.click();
	}
	public void clickBranchBanglore()
	{
		PageUtility.waitForElement(driver, branchBanglore, 5);
		branchBanglore.click();
	}
	public void clickBranchBhopal()
	{
		PageUtility.waitForElement(driver, branchBhopal, 5);
		branchBhopal.click();
	}
	public void clickBranchKozhikode()
	{
		PageUtility.waitForElement(driver, branchKozhikode, 5);
		branchKozhikode.click();
	}
	public void clickBranchAll()
	{
		PageUtility.waitForElement(driver, branchAll, 5);
		branchAll.click();
	}
	public void enterUpdatedDescriptionForHoliday(String description)
	{
		PageUtility.waitForElement(driver, holidayDescription, 5);
		holidayDescription.clear();
		holidayDescription.sendKeys(description);
	}
	public void clickHolidayStatus()
	{
		PageUtility.waitForElement(driver, holidayStatus, 5);
		//holidayStatus.clear();
		holidayStatus.click();
	}
	public HolidayDetails clickSaveButtonInCreateHolidayPage()
	{
		PageUtility.waitForElement(driver, saveButton, 5);
		saveButton.click();
		return new HolidayDetails(driver);
	}
}
