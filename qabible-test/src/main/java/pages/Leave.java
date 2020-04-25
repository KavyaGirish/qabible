package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/label")
	WebElement workerLabel;
	@FindBy(xpath="//*[@id=\"select2-leaveform-worker-container\"]")
	WebElement worker;
	@FindBy(xpath="//*[@id=\"leaveform-worker\"]")
	WebElement workerDropdownList;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[2]")
	WebElement worker1;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[3]")
	WebElement worker2;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[4]")
	WebElement worker3;
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
		PageUtility.waitForElement(driver, endDateForLeave_Worker1, 10);
		endDateForLeave_Worker1.click();
	}
	public void clickStartDateOfLeaveForWorker2()
	{
		PageUtility.waitForElement(driver, startDateForLeave_Worker2, 10);
		startDateForLeave_Worker2.click();
	}
	public void clickEndDateOfLeaveForWorker2()
	{
		PageUtility.waitForElement(driver, endDateForLeave_Worker2, 10);
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
		PageUtility.waitForElement(driver, worker, 10);
		worker.click();
	}
	public String getWorker1()
	{
		//PageUtility.waitForElement(driver, worker2, 5);
		return worker1.getText();
	}
	public String getWorker2()
	{
		//PageUtility.waitForElement(driver, worker2, 5);
		return worker2.getText();
	}
	public String getWorker3()
	{
		//PageUtility.waitForElement(driver, worker3, 5);
		return worker3.getText();
	}
	public void clickWorker1()
	{
		PageUtility.waitForElement(driver, worker1, 10);
		worker1.click();
	}
	public void clickWorker2()
	{
		PageUtility.waitForElement(driver, worker2, 20);
		worker2.click();
	}
	public void clickWorker3()
	{
		PageUtility.waitForElement(driver, worker3, 10);
		worker3.click();
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
		if(leavePageHeaderText.isDisplayed()&& leaveDaysDropdown.isDisplayed()&& workerLabel.isDisplayed()&&reasonForLeave.isDisplayed()&&saveButton.isDisplayed())
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
