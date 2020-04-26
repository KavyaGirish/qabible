package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Homepage 
{
	WebDriver driver;
	
	@FindBy(xpath= "/html/body/div/header/nav/div/ul/li[8]/a")
	WebElement userDropdown;
	@FindBy(xpath= "/html/body/div/header/nav/div/ul/li[8]/ul/li[5]/a")
	WebElement logOutButton;
	@FindBy(xpath= "/html/body/div/div/section[1]/h1")
	WebElement homepageHeaderText;
	@FindBy(xpath= "/html/body/div/header/nav/div/ul/li[3]/a")
	WebElement jobsModuleInDashboard;
	@FindBy(xpath= "/html/body/div/header/nav/div/ul/li[3]/ul/li[1]/a")
	WebElement attendanceOption;
	@FindBy(xpath= "/html/body/div/header/nav/div/ul/li[3]/ul/li[2]/a")
	WebElement jobOption;
	
	
	public Homepage(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickUserIcon()
	{
		userDropdown.click();
	}
	public void clickLogOutButton()
	{
		logOutButton.click();
	}
	public String getHomepageHeaderText()	
	{
		return homepageHeaderText.getText();
	}
	public void mouseHoverOnJobsModuleInDashboard()
	{
		new Actions(driver).moveToElement(jobsModuleInDashboard).build().perform();
	}
	public String getTooltipTextOfJobsModule()
	{
		String toolTipText= jobsModuleInDashboard.getAttribute("title");
		return toolTipText;
	}
	public void clickModuleJobsInDashboard()
	{
		PageUtility.waitForElement(driver, jobsModuleInDashboard, 5);
		jobsModuleInDashboard.click();
	}
	public String getOptionAttendanceFromJobsModule()
	{
		return attendanceOption.getText();
	}
	public String getOptionJobFromJobsModule()
	{
		return jobOption.getText();
	}
	public Attendance clickOptionAttendanceFromJobsModule()
	{
		PageUtility.waitForElement(driver, attendanceOption, 5);
		attendanceOption.click();
		return new Attendance(driver);
	}
	public Job clickOptionJobFromJobsModule()
	{
		PageUtility.waitForElement(driver, jobOption, 5);
		jobOption.click();
		return new Job(driver);
	}
}
