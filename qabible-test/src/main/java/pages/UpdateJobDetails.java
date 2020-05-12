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
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/div[contains(@class,'help-block')]")
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
	public String getHeaderText()
	{
		return headerText.getText();
	}
	public void enterTitle(String job)
	{
		jobTitle.clear();
		jobTitle.sendKeys(job); //"Accountant"
	}
	public void clearClient()
	{
		PageUtility.waitForElement(driver, clearClientValue, 5);
		clearClientValue.click();
	}
	public boolean isNoClientErrorDisplayed()
	{
		//PageUtility.handleSleep(6000);
		PageUtility.waitForElementDisplayed(driver, noClientValueError, 6);
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
	public void clickClient(String client) 
	{
		if(client=="AAA")
		{
			PageUtility.waitForElement(driver, client_AAA, 5);
			new Actions(driver).doubleClick(client_AAA);
		}
		else if(client=="Client1")
		{
			PageUtility.waitForElement(driver, client_Client1, 5);
			new Actions(driver).doubleClick(client_Client1);
		}
		else if(client=="Client2")
		{
			PageUtility.waitForElement(driver, client_Client2, 5);
			new Actions(driver).doubleClick(client_Client2);
		}
		else
		{}
	}
	public String getClient(String client)
	{
		String cl="";
		if(client=="AAA")
		{
			PageUtility.waitForElementDisplayed(driver, client_AAA, 5);
			cl= client_AAA.getText();
		}
		else if(client=="Client1")
		{
			PageUtility.waitForElementDisplayed(driver, client_Client1, 5);
			cl= client_Client1.getText();
		}
		else if(client=="Client2")
		{
			PageUtility.waitForElementDisplayed(driver, client_Client2, 5);
			cl= client_Client2.getText();
		}
		else
		{}
		return cl;
	}
	public void clickJobType()
	{
		PageUtility.waitForElement(driver, jobType, 20);
		jobType.click();
	}
	public void clickJobType(String type)
	{
		if(type=="Normal")
		{
			PageUtility.waitForElement(driver, jobType_Normal, 20);
			jobType_Normal.click();
		}
		else if (type=="Overtime")
		{
			PageUtility.waitForElement(driver, jobType_Overtime, 20);
			jobType_Overtime.click();
		}
		else
		{}
	}
	public String getJobType(String jobtype)
	{
		String job="";
		if(jobtype=="Normal")
		{
			job= jobType_Normal.getText();
		}
		else if(jobtype=="Overtime")
		{
			job= jobType_Overtime.getText();
		} 
		else
		{}
		return job;
	}
	public void enterPo(String poUpdate)
	{
		PageUtility.waitForElement(driver, po, 20);
		po.clear();
		po.sendKeys(poUpdate);
	}
	public void enterDescription(String desc)
	{
		PageUtility.waitForElement(driver, description, 20);
		description.clear();
		description.sendKeys(desc);
	}
	public Job clickSave()
	{
		saveButton.click();
		return new Job(driver);
		
	}
}
