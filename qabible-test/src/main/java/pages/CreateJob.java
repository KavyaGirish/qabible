package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class CreateJob 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[2]/div/div/label")
	WebElement textAttendanceNotDone;
	
	@FindBy(xpath="/html/body/div[1]/header/nav/div/ul/form/select")
	WebElement branchDropdown;
	
	@FindBy(xpath="//*[@id=\"branchform-branch\"]/option[1]")
	WebElement branchTvmm;
	@FindBy(xpath="//*[@id=\"branchform-branch\"]/option[2]")
	WebElement branchBhopal;
	
	@FindBy(id="job-title")
	WebElement jobTitle;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/span/span[1]/span/span[2]")
	WebElement clientDropdown;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[2]")
	WebElement client_AAA;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[3]")
	WebElement client_Client1;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[4]")
	WebElement client_Client2;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/div")
	WebElement noClientErrorMessage;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select")
	WebElement jobTypeDropdown;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select/option[2]")
	WebElement jobType_Normal;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select/option[3]")
	WebElement jobType_Overtime;
	
	@FindBy(id="job-po")
	WebElement po;
	
	@FindBy(id="job-description")
	WebElement jobDescription;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/button")
	WebElement saveButton;
	
	public CreateJob(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getTextAttendanceNotDoneInCreateJobPage()
	{
		return textAttendanceNotDone.getText();
	}
	public void clickBranchDropdown()
	{
		branchDropdown.click();
	}
	public void clickBranchTvmm()
	{
		branchTvmm.click();
	}
	public void clickBranchBhopal()
	{
		branchBhopal.click();
	}
	/*
	public void clickBranchValueTvmmFromBranchDropdownInCreateJobPage()
	{
		branchDropdown.click();
		Select selectBranch= new Select(branchDropdown);
		selectBranch.selectByVisibleText("Tvmm");
	}
	public void clickBranchValueBhopalFromBranchDropdownInCreateJobPage()
	{
		branchDropdown.click();
		Select selectBranch= new Select(branchDropdown);
		selectBranch.selectByVisibleText("Bhopal");
	}
	*/
	public void enterJobTitle(String jobTitleValue)
	{
		jobTitle.sendKeys(jobTitleValue);
	}
	public void clickClientDropdown()
	{
		clientDropdown.click();
	}
	public void clickClient_AAA()
	{
		PageUtility.waitForElement(driver, client_AAA, 10);
		new Actions(driver).doubleClick(client_AAA);
	}
	public void clickClient_Client1()
	{
		PageUtility.waitForElement(driver, client_Client1, 10);
		new Actions(driver).doubleClick(client_Client1);
	}
	public void clickClient_Client2()
	{
		PageUtility.waitForElement(driver, client_Client2, 10);
		new Actions(driver).doubleClick(client_Client2);
	}
	public void clickJobTypeDropdown()
	{
		jobTypeDropdown.click();
	}
	public void clickJobType_Normal()
	{
		PageUtility.waitForElement(driver, jobType_Normal, 5);
		jobType_Normal.click();
	}
	public void clickJobType_Overtime()
	{
		PageUtility.waitForElement(driver, jobType_Overtime, 5);
		jobType_Overtime.click();
	}
	public void enterValueForPo(String poValue)
	{
		po.sendKeys(poValue);
	}
	public void enterValueForDescription(String description)
	{
		jobDescription.sendKeys(description);
	}
	public Job clickSaveButton()
	{
		saveButton.click();
		return new Job(driver);
	}
	public boolean getNoClientError()
	{
		if(noClientErrorMessage.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
