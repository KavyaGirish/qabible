package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayrollDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement headerTextOfPayrollDetails;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[1]/td")
	WebElement workerFullName;
	@FindBy(xpath="//*[@id=\"w0\"]/tbody/tr[2]/td")
	WebElement workerBranch;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a[1]")
	WebElement updateButton;
	
	public PayrollDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}	
	public String getHeaderTextOfPayrollDetails(String employee)
	{
		String header="";
		if(employee=="Sagar")
		{
			header= headerTextOfPayrollDetails.getText();
		}
		return header;
	}
	public String getFullName()
	{
		return workerFullName.getText();
	}
	public String getBranch()
	{
		return workerBranch.getText();
	}
	public UpdatePayrollDetails clickUpdate()
	{
		updateButton.click();
		return new UpdatePayrollDetails(driver);
	}
}
