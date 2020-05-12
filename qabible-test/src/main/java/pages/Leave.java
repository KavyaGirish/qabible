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
	WebElement worker1; //Sagar
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[3]")
	WebElement worker2; //Thomas
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/select/option[4]")
	WebElement worker3; //Anil
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
	public void clickLeaveDaysDropdown()
	{
		PageUtility.waitForElement(driver, leaveDaysDropdown, 5);
		leaveDaysDropdown.click();
	}
	public void clickStartDate(String worker)
	{
		if(worker=="Worker1")
		{
			PageUtility.waitForElement(driver, startDateForLeave_Worker1, 5);
			startDateForLeave_Worker1.click();
		}
		else if(worker=="Worker2")
		{
			PageUtility.waitForElement(driver, startDateForLeave_Worker2, 10);
			startDateForLeave_Worker2.click();
		}
		else {}
	}
	public void clickEndDate(String worker)
	{
		if(worker=="Worker1")
		{
			PageUtility.waitForElement(driver, endDateForLeave_Worker1, 10);
			endDateForLeave_Worker1.click();
		}
		else if(worker=="Worker2")
		{
			PageUtility.waitForElement(driver, endDateForLeave_Worker2, 10);
			endDateForLeave_Worker2.click();
		}
		else {}
	}
	public void clickCancel()
	{
		PageUtility.waitForElement(driver, cancelButtonInDatePicker, 5);
		cancelButtonInDatePicker.click();
	}
	public void clickApply()
	{
		PageUtility.waitForElement(driver, applyButtonInDatePicker, 5);
		applyButtonInDatePicker.click();
	}
	public void clickWorkerDropdown()
	{
		PageUtility.waitForElement(driver, worker, 10);
		worker.click();
	}
	public String getWorker(String worker)
	{
		String wo="";
		if(worker=="Worker1")
		{
			//PageUtility.waitForElementDisplayed(driver, worker1, 15);
			PageUtility.handleSleep(10000);
			wo= worker1.getText();
		}
		else if(worker=="Worker2")
		{
			//PageUtility.waitForElementDisplayed(driver, worker2, 15);
			PageUtility.handleSleep(10000);
			wo= worker2.getText();
		}
		else if(worker=="Worker3")
		{
			//PageUtility.waitForElementDisplayed(driver, worker3, 15);
			PageUtility.handleSleep(10000);
			wo= worker3.getText();
		}
		else {}
		return wo;
	}
	public void clickWorker(String worker)
	{
		if(worker=="Worker1")
		{
			PageUtility.waitForElement(driver, worker1, 10);
			worker1.click();
		}
		else if(worker=="Worker2")
		{
			PageUtility.waitForElement(driver, worker2, 10);
			worker2.click();
		}
		else if(worker=="Worker3")
		{
			PageUtility.waitForElement(driver, worker3, 10);
			worker3.click();
		}
		else {}
	}
	public void enterReason(String reason)
	{
		PageUtility.waitForElement(driver, reasonForLeave, 5);
		reasonForLeave.sendKeys(reason);
	}
	public Attendance clickSave()
	{
		PageUtility.waitForElement(driver, saveButton, 5);
		saveButton.click();
		return new Attendance(driver);
	}
	public boolean getWebElementVisibility()
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
