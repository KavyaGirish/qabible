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
	public String getHeaderText() 
	{
		return headerText.getText();
	}
	public String getClient()
	{
		return client.getText();
	}
	public String getJobType()
	{
		return jobType.getText();
	}
	public String getPo()
	{
		return po.getText();
	}
	public String getDescription()
	{
		return description.getText();
	}
	public String getDate()
	{
		return date.getText();
	}
	
}
