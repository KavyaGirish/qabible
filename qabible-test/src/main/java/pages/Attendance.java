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
	public boolean getWebElementsVisibilityInAttendancePageLoaged()
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
		PageUtility.waitForElement(driver, branchDropdown, 5);
		branchDropdown.click();
	}
	public String getBranchValueBanglore()
	{
		return branchBanglore.getText();
	}
	public String getBranchValueBhopal()
	{
		return branchBhopal.getText();
	}
	/*
	public String[] getBranchValue()
	{
		Select select= new Select(branchDropdown);
		List<WebElement> branch= select.getOptions();
		String br[] = new String[branch.size()];
		for(int i=0;i<branch.size();i++)
		{
			br[i]= branch.get(i).getText();
		}
		return br;
	}
	*/
	public void clickBranchValueBanglore()
	{
		PageUtility.waitForElement(driver, branchDropdown, 5);
		Select select= new Select(branchDropdown);
		select.selectByVisibleText("Banglore");
	}
	public void clickBranchValueBhopal()
	{
		PageUtility.waitForElement(driver, branchDropdown, 5);
		Select select= new Select(branchDropdown);
		select.selectByVisibleText("Bhopal");
	}
	public String getBranchValueWhenBranchIsSelected()
	{
		String branchValue= new Select(branchDropdown).getFirstSelectedOption().getText();
		return branchValue;	
	}
	public AttendanceCreate clickCreateAttendanceInAttendancePage()
	{
		PageUtility.waitForElement(driver, attendanceCreate, 5);
		attendanceCreate.click();
		return new AttendanceCreate(driver);
	}
	public Report clickReportInAttendancePage()
	{
		PageUtility.waitForElement(driver, report, 5);
		report.click();
		return new Report(driver);
	}
	public Leave clickLeaveInAttendancePage()
	{
		PageUtility.waitForElement(driver, leave, 5);
		leave.click();
		return new Leave(driver);
	}
	public Holiday clickHolidayInAttendancePage()
	{
		PageUtility.waitForElement(driver, holiday, 5);
		holiday.click();
		return new Holiday(driver);
	}
	public Payroll clickPayrollInAttendancePage()
	{
		PageUtility.waitForElement(driver, payroll, 5);
		payroll.click();
		return new Payroll(driver);
	}
}
