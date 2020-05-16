package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class Attendance 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement attendanceHeaderText;
	@FindBy(xpath="//*[@id=\"w0\"]/div[1]/label")
	WebElement textDate;
	@FindBy(xpath="//*[@id=\"attendanceform-date-kvdate\"]/span[1]/i")
	WebElement datePickerButton;
	@FindBy(xpath="//*[@id=\"attendanceform-date-kvdate\"]/span[2]/i")
	WebElement closeButton;
	@FindBy(xpath="//*[@id=\"attendanceform-date\"]")
	WebElement textFieldEnterDate;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/button")
	WebElement startButton;
	
	@FindBy(xpath="//*[@id=\"branchform-branch\"]")
	WebElement branchDropdown;
	@FindBy(xpath="//*[@id=\"branchform-branch\"]/option[1]")
	WebElement branchBanglore;
	@FindBy(xpath="//*[@id=\"branchform-branch\"]/option[2]")
	WebElement branchBhopal;
	
	@FindBy(xpath="/html/body/div/aside/section/ul/li[3]/a")
	WebElement attendanceCreate;
	@FindBy(xpath="/html/body/div/aside/section/ul/li[6]/a")
	WebElement report;
	@FindBy(xpath="/html/body/div/aside/section/ul/li[4]/a")
	WebElement leave;
	@FindBy(xpath="/html/body/div/aside/section/ul/li[5]/a")
	WebElement holiday;
	@FindBy(xpath="/html/body/div/aside/section/ul/li[7]/a")
	WebElement payroll;
	
	public Attendance(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getAttendancePageHeaderText()
	{
		return attendanceHeaderText.getText();
	}
	public boolean getWebElementsVisibility()
	{
		Boolean visibilityOFElement;
		if(attendanceHeaderText.isDisplayed() && textDate.isDisplayed() && datePickerButton.isDisplayed() && closeButton.isDisplayed() && textFieldEnterDate.isDisplayed() && startButton.isDisplayed())
		{
			visibilityOFElement= true;
		}
		else
		{
			visibilityOFElement= false;
		}
		return visibilityOFElement;
		
	}
	public void clickBranchDropdown()
	{
		PageUtility.waitForElementClicked(driver, branchDropdown, 5);
		branchDropdown.click();
	}
	public String getBranch(String branch)
	{
		String br="";
		if(branch=="Banglore")
		{
			br= branchBanglore.getText();
		}
		else if(branch=="Bhopal")
		{
			br= branchBhopal.getText();
		}
		else {}
		return br;
	}
	public void clickBranchValueBanglore(String branch)
	{
		if(branch=="Banglore")
		{
			PageUtility.waitForElementClicked(driver, branchBanglore, 5);
			branchBanglore.click();
		}
		else if(branch=="Bhopal")
		{
			PageUtility.waitForElementClicked(driver, branchBhopal, 5);
			branchBhopal.click();
		}
		else {}
	}
	public AttendanceCreate clickCreateAttendance()
	{
		PageUtility.waitForElementClicked(driver, attendanceCreate, 5);
		attendanceCreate.click();
		return new AttendanceCreate(driver);
	}
	public Report clickReport()
	{
		PageUtility.waitForElementClicked(driver, report, 5);
		report.click();
		return new Report(driver);
	}
	public Leave clickLeave()
	{
		PageUtility.waitForElementClicked(driver, leave, 5);
		leave.click();
		return new Leave(driver);
	}
	public Holiday clickHoliday()
	{
		PageUtility.waitForElementClicked(driver, holiday, 5);
		holiday.click();
		return new Holiday(driver);
	}
	public Payroll clickPayroll()
	{
		PageUtility.waitForElementClicked(driver, payroll, 5);
		payroll.click();
		return new Payroll(driver);
	}
}
