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
	public AttendanceDetails clickClose() //close window
	{
		closeWindowButton.click();
		return new AttendanceDetails(driver);
	}
	public void enterTimeIn(int timeInHours, int timeInMinutes)
	{
		attendanceTimeInText.sendKeys(String.valueOf(timeInHours)+":"+String.valueOf(timeInMinutes));
	}
	public void enterTimeOut(int timeOutHours, int timeOutMinutes)
	{
		attendanceTimeOutText.sendKeys(String.valueOf(timeOutHours)+":"+String.valueOf(timeOutMinutes));
	}
	public void clickTimeIn()
	{
		attendanceTimeIn.click();
	}
	public void enterTimeInHours(int timeInHours)
	{
		attendanceTimeInHours.sendKeys(String.valueOf(timeInHours));
	}
	public void enterTimeInMinutes(int timeInMinutes)
	{
		attendanceTimeInMinutes.sendKeys(String.valueOf(timeInMinutes));
	}
	public void clickTimeOut()
	{
		attendanceTimeOut.click();
	}
	public void enterTimeOutHours(int timeOutHours)
	{
		attendanceTimeOutHours.sendKeys(String.valueOf(timeOutHours));
	}
	public void enterTimeOutMinutes(int timeOutMinutes)
	{
		attendanceTimeOutMinutes.sendKeys(String.valueOf(timeOutMinutes));
	}
	public void clickStatusDropdown()
	{
		attendanceStatusDropdown.click();
	}
	public void clickStatus(String status) //parameter
	{
		if(status=="Absent")
		{
			statusAbsent.click();
		}
		else if(status=="Present")
		{
			statusPresent.click();
		}
		else if(status=="InMissing")
		{
			statusInMissing.click();
		}
		else if(status=="OutMissing")
		{
			statusOutMissing.click();
		}
		else
		{}
	}
	
	public void clickShiftDropdown()
	{
		shiftDropdown.click();
	}
	
	public void clickShift(String shift)
	{
		if(shift=="A")
		{
			shiftA.click();
		}
		else if(shift=="B")
		{
			shiftB.click();
		}
		else if(shift=="C")
		{
			shiftC.click();
		}
		else if(shift=="G")
		{
			shiftG.click();
		}
		else if(shift=="N")
		{
			shiftN.click();
		}
		else
		{}
	}
	
	public void enterOvertimeValueInHours(String overtime) 
	{
		overtimeInHours.sendKeys(overtime);
	}
	public void enterReason(String reasonForAbsence)
	{
		reason.sendKeys(reasonForAbsence);
	}
	public AttendanceDetails clickSave()
	{
		saveButton.click();
		return new AttendanceDetails(driver);
	}
}
