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
	@FindBy(xpath="/html/body/span/span/span[1]/input")
	WebElement clientText;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[2]")
	WebElement client_AAA;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[3]")
	WebElement client_Client1;
	@FindBy(xpath="//*[@id=\"job-client_id\"]/option[4]")
	WebElement client_Client2;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/div[contains(@class,'help-block')]")
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
	public String getTextAttendanceNotDone()
	{
		return textAttendanceNotDone.getText();
	}
	public void clickBranchDropdown()
	{
		branchDropdown.click();
	}
	public void clickBranch(String branch)
	{
		if(branch=="Tvmm")
		{
			branchTvmm.click();
		}
		else if(branch=="Bhopal")
		{
			branchBhopal.click();
		}
		else
		{}
	}
	public void enterTitle(String jobTitleValue)
	{
		jobTitle.sendKeys(jobTitleValue);
	}
	public void clickClientDropdown()
	{
		clientDropdown.click();
	}
	public void enterClient(String client)
	{
		PageUtility.handleSleep(6000);
		clientText.sendKeys(client);
	}
	public void clickClient(String client)
	{
		if(client=="AAA")
		{
			PageUtility.handleSleep(6000);
			//new Actions(driver).doubleClick(client_AAA);
			client_AAA.click();
		}
		else if(client=="Client1")
		{
			PageUtility.handleSleep(10000);
			//new Actions(driver).doubleClick(client_Client1);
			client_Client1.click();
		}
		else if(client=="Client2")
		{
			PageUtility.handleSleep(10000);
			//new Actions(driver).doubleClick(client_Client2);
			client_Client2.click();
		}
		else
		{}
	}
	public void clickJobTypeDropdown()
	{
		jobTypeDropdown.click();
	}
	public void clickJobType(String jobType)
	{
		if(jobType=="Normal")
		{
			PageUtility.waitForElementClicked(driver, jobType_Normal, 5);
			jobType_Normal.click();
		}
		else if(jobType=="Overtime")
		{
			PageUtility.waitForElementClicked(driver, jobType_Overtime, 5);
			jobType_Overtime.click();
		}
	}
	public void enterPo(String poValue)
	{
		po.sendKeys(poValue);
	}
	public void enterDescription(String description)
	{
		jobDescription.sendKeys(description);
	}
	public Job clickSave()
	{
		saveButton.click();
		return new Job(driver);
	}
	public boolean getNoClientError()
	{
		PageUtility.handleSleep(5000);
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
