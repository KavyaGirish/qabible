package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Leave 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/section[1]/h1")
	WebElement leavePageHeaderText;
	@FindBy(xpath="//*[@id=\"leaveform-date_range-container\"]/div/input")
	WebElement leaveDaysDropdown;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[2]")
	WebElement startDateForLeave_Worker1;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/table/tbody/tr[3]/td[6]")
	WebElement endDateForLeave_Worker1;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[2]")
	WebElement startDateForLeave_Worker2;
	@FindBy(xpath="/html/body/div[2]/div[2]/div[1]/table/tbody/tr[4]/td[6]")
	WebElement endDateForLeave_Worker2;
	@FindBy(xpath="/html/body/div[2]/div[4]/button[1]")
	WebElement cancelButtonInDatePicker;
	@FindBy(xpath="/html/body/div[2]/div[4]/button[2]")
	WebElement applyButtonInDatePicker;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/span/span[1]/span/span[2]")
	WebElement workerDropdown;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[2]")
	WebElement worker1;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[3]")
	WebElement worker2;
	@FindBy(xpath="//*[@id=\"leaveform-reason\"]")
	WebElement reasonForLeave;
	@FindBy(xpath="//*[@id=\"w0\"]/div[4]/button")
	WebElement saveButton;
	
	public Leave(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getLeavePageHeaderText()
	{
		return leavePageHeaderText.getText();
	}
	public void clickLeaveDaysDropdownInLeavePage()
	{
		PageUtility.waitForElement(driver, leaveDaysDropdown, 5);
		leaveDaysDropdown.click();
	}
	public void clickStartDateOfLeaveForWorker1()
	{
		PageUtility.waitForElement(driver, startDateForLeave_Worker1, 5);
		startDateForLeave_Worker1.click();
	}
	public void clickEndDateOfLeaveForWorker1()
	{
		PageUtility.waitForElement(driver, endDateForLeave_Worker1, 5);
		endDateForLeave_Worker1.click();
	}
	public void clickStartDateOfLeaveForWorker2()
	{
		PageUtility.waitForElement(driver, startDateForLeave_Worker2, 5);
		startDateForLeave_Worker2.click();
	}
	public void clickEndDateOfLeaveForWorker2()
	{
		PageUtility.waitForElement(driver, endDateForLeave_Worker2, 5);
		endDateForLeave_Worker2.click();
	}
	public void clickCancelButtonInDatePicker()
	{
		PageUtility.waitForElement(driver, cancelButtonInDatePicker, 5);
		cancelButtonInDatePicker.click();
	}
	public void clickApplyButtonInDatePicker()
	{
		PageUtility.waitForElement(driver, applyButtonInDatePicker, 5);
		applyButtonInDatePicker.click();
	}
	public void clickWorkerDropdown()
	{
		PageUtility.waitForElement(driver, workerDropdown, 10);
		workerDropdown.click();
	}
	public void clickWorker1()
	{
		PageUtility.waitForElement(driver, worker1, 10);
		worker1.click();
	}
	public void clickWorker2()
	{
		PageUtility.waitForElement(driver, worker2, 10);
		worker2.click();
	}
	public void enterReasonForLeave(String reason)
	{
		PageUtility.waitForElement(driver, reasonForLeave, 5);
		reasonForLeave.sendKeys(reason);
	}
	public Attendance clickSaveButton()
	{
		PageUtility.waitForElement(driver, saveButton, 5);
		saveButton.click();
		return new Attendance(driver);
	}
	public boolean getWebElementVisibilityInLeavePage()
	{
		Boolean visibilityOfElement;
		if(leavePageHeaderText.isDisplayed()&& leaveDaysDropdown.isDisplayed()&& workerDropdown.isDisplayed()&&reasonForLeave.isDisplayed()&&saveButton.isDisplayed())
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
