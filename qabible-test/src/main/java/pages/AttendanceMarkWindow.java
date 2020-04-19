package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceMarkWindow 
{
	WebDriver driver;
	
	@FindBy(xpath="//*[@id=\"modal\"]/div/div/div[1]/h4")
	WebElement attendanceMarkWindowHeaderText;
	@FindBy(xpath="//*[@id=\"modal\"]/div/div/div[1]/button")
	WebElement closeWindowButton;
	
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[1]/div/div[1]/span")
	WebElement attendanceTimeIn;
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[2]/td[1]/input")
	WebElement attendanceTimeInHours;
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[1]/div/div[1]/div/table/tbody/tr[2]/td[3]/input")
	WebElement attendanceTimeInMinutes;
	
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[2]/div/div[1]/span")
	WebElement attendanceTimeOut;
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[2]/td[1]/input")
	WebElement attendanceTimeOutHours;
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[1]/div[2]/div/div[1]/div/table/tbody/tr[2]/td[3]/input")
	WebElement attendanceTimeOutMinutes;
	
	@FindBy(xpath="//*[@id=\"workerattendance-in\"]")
	WebElement attendanceTimeInText;
	@FindBy(xpath="//*[@id=\"workerattendance-out\"]")
	WebElement attendanceTimeOutText;
	
	@FindBy(xpath="//*[@id=\"workerattendance-status\"]")
	WebElement attendanceStatusDropdown;
	@FindBy(xpath="//*[@id=\"workerattendance-status\"]/option[1]")
	WebElement statusAbsent;
	@FindBy(xpath="//*[@id=\"workerattendance-status\"]/option[2]")
	WebElement statusPresent;
	@FindBy(xpath="//*[@id=\"workerattendance-status\"]/option[3]")
	WebElement statusOutMissing;
	@FindBy(xpath="//*[@id=\"workerattendance-status\"]/option[4]")
	WebElement statusInMissing;
	
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]")
	WebElement shiftDropdown;
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]/option[1]")
	WebElement shiftA;
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]/option[2]")
	WebElement shiftB;
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]/option[3]")
	WebElement shiftC;
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]/option[4]")
	WebElement shiftG;
	@FindBy(xpath="//*[@id=\"workerattendance-shift\"]/option[5]")
	WebElement shiftN;
	
	@FindBy(xpath="//*[@id=\"workerattendance-overtime\"]")
	WebElement overtimeInHours;
	@FindBy(xpath="//*[@id=\"workerattendance-reason\"]")
	WebElement reason;
	@FindBy(xpath="//*[@id=\"WorkerAttendance\"]/div[2]/button")
	WebElement saveButton;
	
	public AttendanceMarkWindow(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getAttendanceMarkWindowHeaderText()
	{
		return attendanceMarkWindowHeaderText.getText();
	}
	public AttendanceDetails clickCloseWindowButton()
	{
		closeWindowButton.click();
		return new AttendanceDetails(driver);
	}
	public void enterTimeInValue(int timeInHours, int timeInMinutes)
	{
		attendanceTimeInText.sendKeys(String.valueOf(timeInHours)+":"+String.valueOf(timeInMinutes));
	}
	public void enterTimeOutValue(int timeOutHours, int timeOutMinutes)
	{
		attendanceTimeOutText.sendKeys(String.valueOf(timeOutHours)+":"+String.valueOf(timeOutMinutes));
	}
	public void clickTimeInButton()
	{
		attendanceTimeIn.click();
	}
	public void enterTimeInHoursValue(int timeInHours)
	{
		attendanceTimeInHours.sendKeys(String.valueOf(timeInHours));
	}
	public void enterTimeInMinutesValue(int timeInMinutes)
	{
		attendanceTimeInMinutes.sendKeys(String.valueOf(timeInMinutes));
	}
	public void clickTimeOutButton()
	{
		attendanceTimeOut.click();
	}
	public void enterTimeOutHoursValue(int timeOutHours)
	{
		attendanceTimeOutHours.sendKeys(String.valueOf(timeOutHours));
	}
	public void enterTimeOutMinutesValue(int timeOutMinutes)
	{
		attendanceTimeOutMinutes.sendKeys(String.valueOf(timeOutMinutes));
	}
	public void clickAttendanceStatusDropdown()
	{
		attendanceStatusDropdown.click();
	}
	public void clickStatusAbsent()
	{
		statusAbsent.click();
	}
	public void clickStatusPresent()
	{
		statusPresent.click();
	}
	public void clickStatusInMissing()
	{
		statusInMissing.click();
	}
	public void clickStatusOutMissing()
	{
		statusOutMissing.click();
	}
	public void clickShiftDropdown()
	{
		shiftDropdown.click();
	}
	public void clickShiftA()
	{
		shiftA.click();
	}
	public void clickShiftB()
	{
		shiftB.click();
	}
	public void clickShiftC()
	{
		shiftC.click();
	}
	public void clickShiftG()
	{
		shiftG.click();
	}
	public void clickShiftN()
	{
		shiftN.click();
	}
	public void enterOvertimeValueInHours(String overtime) 
	{
		overtimeInHours.sendKeys(overtime);
	}
	public void enterReason(String reasonForAbsence)
	{
		reason.sendKeys(reasonForAbsence);
	}
	public AttendanceDetails clickSaveButtonInAttendanceMarkWindow()
	{
		saveButton.click();
		return new AttendanceDetails(driver);
	}
}
