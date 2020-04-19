package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Job 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement jobPageHeaderText;
	@FindBy(xpath="//*[@id=\"p0\"]/p/a")
	WebElement createJobButton;
	@FindBy(xpath="//*[@id=\"w0\"]/table")
	WebElement tableContainingJobDetails;
	
	
	@FindBy(xpath="//*[@id=\"w0\"]/table/tbody/tr/td[2]")
	List<WebElement> columnJobTitleOfTableJobsCreated;	
	
	@FindBy(xpath="/html/body/div/aside/section/ul/li[9]/a")
	WebElement createAreaModule;	
	@FindBy(xpath="/html/body/div/aside/section/ul/li[8]/a")
	WebElement areaModule;
	
	public Job(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getJobPageHeaderText()
	{
		return jobPageHeaderText.getText();
	}
	public boolean getWebElementsVisiblityInJobPageLoaded()
	{
		Boolean visibilityOFElement;
		if(jobPageHeaderText.isDisplayed() && createJobButton.isDisplayed() && tableContainingJobDetails.isDisplayed() )
		{
			visibilityOFElement= true;
		}
		else
		{
			visibilityOFElement= false;
		}
		return visibilityOFElement;
		
	}
	public CreateJob clickCreateJobsButtonInJobPage()
	{
		PageUtility.waitForElement(driver, createJobButton, 5);
		createJobButton.click();
		return new CreateJob(driver);
	}
	public String getCreatedJobInJobPage() //pending
	{
		//from Dynamic Web Table
		List<WebElement> rowOfTableJobs= columnJobTitleOfTableJobsCreated;
		int rowCountOfTableJobs= rowOfTableJobs.size();
		System.out.println("Size of Table= "+rowCountOfTableJobs);
		String newlyCreatedJob= rowOfTableJobs.get(rowCountOfTableJobs-1).getText();
		return newlyCreatedJob;
	}
	public CreateArea clickCreateAreaInJobPage()
	{
		PageUtility.waitForElement(driver, createAreaModule, 5);
		createAreaModule.click();
		return new CreateArea(driver);
	}
	public Area clickAreaInJobpage()
	{
		PageUtility.waitForElement(driver, areaModule, 5);
		areaModule.click();
		return new Area(driver);
	}
}
