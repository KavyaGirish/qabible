package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JobDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement headerText;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[1]/td")
	WebElement client;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[2]/td")
	WebElement jobType;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[3]/td")
	WebElement po;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[4]/td")
	WebElement description;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[5]/td")
	WebElement date;
	
	public JobDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getHeaderTextOfJobDetailsPageOfBusinessAnalyst()
	{
		return headerText.getText();
	}
	public String getClientOfBusinessAnalyst()
	{
		return client.getText();
	}
	public String getJobTypeOfBusinessAnalyst()
	{
		return jobType.getText();
	}
	public String getPoOfBusinessAnalyst()
	{
		return po.getText();
	}
	public String getDescriptionOfBusinessAnalyst()
	{
		return description.getText();
	}
	public String getDateOfBusinessAnalyst()
	{
		return date.getText();
	}
	public String getHeaderTextOfJobDetailsPageOfAccountant()
	{
		return headerText.getText();
	}
	public String getClientOfAccountant()
	{
		return client.getText();
	}
	public String getJobTypeOfAccountant()
	{
		return jobType.getText();
	}
	public String getPoOfAccountant()
	{
		return po.getText();
	}
	public String getDescriptionOfAccountant()
	{
		return description.getText();
	}
	public String getDateOfAccountant()
	{
		return date.getText();
	}
}
