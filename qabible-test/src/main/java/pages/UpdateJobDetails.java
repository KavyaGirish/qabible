package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UpdateJobDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/section[1]/h1")
	WebElement headerText;
	@FindBy(xpath="//*[@id=\"job-title\"]")
	WebElement jobTitle;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/span/span[1]/span/span[1]")
	WebElement clientValue;
	@FindBy(xpath="//*[@id=\"select2-job-client_id-container\"]/span")
	WebElement clearClientValue;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/div")
	WebElement noClientValueError;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/div[1]/div/span/span[1]/span/span[2]")
	WebElement clientDropdown;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[2]")
	WebElement client_AAA;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[3]")
	WebElement client_Client1;
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[4]")
	WebElement client_Client2;
	
	@FindBy(xpath="//*[@id=\"job-type\"]")
	WebElement jobType;
	@FindBy(xpath="//*[@id=\"job-type\"]/option[2]")
	WebElement jobType_Normal;
	@FindBy(xpath="//*[@id=\"job-type\"]/option[3]")
	WebElement jobType_Overtime;
	
	
	@FindBy(xpath="//*[@id=\"job-po\"]")
	WebElement po;
	@FindBy(xpath="//*[@id=\"job-description\"]")
	WebElement description;
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/button")
	WebElement saveButton;
	
	public UpdateJobDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getHeaderTextOfUpdateJobDetailsPageOfAccountant()
	{
		return headerText.getText();
	}
	public void updateJobTitle()
	{
		jobTitle.clear();
		jobTitle.sendKeys("Accountant");
	}
	public void clearClientValue()
	{
		PageUtility.waitForElement(driver, clearClientValue, 5);
		clearClientValue.click();
	}
	public boolean checkNoClientErrorDisplayed()
	{
		if(noClientValueError.isDisplayed())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	public void clickClientDropdown()
	{
		PageUtility.waitForElement(driver, clientDropdown, 10);
		clientDropdown.click();
	}
	public void clickClientOptionAAA()
	{
		PageUtility.waitForElement(driver, client_AAA, 5);
		new Actions(driver).doubleClick(client_AAA);
	}
	public void clickClientOptionClient1()
	{
		PageUtility.waitForElement(driver, client_Client1, 5);
		new Actions(driver).doubleClick(client_Client1);
	}
	public void clickClientOptionClient2()
	{
		PageUtility.waitForElement(driver, client_Client2, 5);
		new Actions(driver).doubleClick(client_Client2);
	}
	public String getClientAAA()
	{
		PageUtility.waitForElement(driver, client_AAA, 5);
		return client_AAA.getText();
	}
	public String getClient1()
	{
		PageUtility.waitForElement(driver, client_Client1, 5);
		return client_Client1.getText();
	}
	public String getClient2()
	{
		PageUtility.waitForElement(driver, client_Client2, 5);
		return client_Client2.getText();
	}
	public void clickJobType()
	{
		PageUtility.waitForElement(driver, jobType, 20);
		jobType.click();
	}
	public void clickJobTypeNormal()
	{
		PageUtility.waitForElement(driver, jobType_Normal, 20);
		jobType_Normal.click();
	}
	public void clickJobTypeOvertime()
	{
		PageUtility.waitForElement(driver, jobType_Overtime, 20);
		jobType_Overtime.click();
	}
	public String getJobType_Normal()
	{
		return jobType_Normal.getText();
	}
	public String getJobType_Overtime()
	{
		return jobType_Overtime.getText();
	}
	public void updatePoOfAccountant()
	{
		PageUtility.waitForElement(driver, po, 20);
		po.clear();
		po.sendKeys("xyz");
	}
	public void updateDescriptionOfAccountant()
	{
		PageUtility.waitForElement(driver, description, 20);
		description.clear();
		description.sendKeys("Accounting");
	}
	public Job clickSaveButton()
	{
		saveButton.click();
		return new Job(driver);
		
	}
}
