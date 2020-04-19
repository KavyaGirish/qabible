package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[2]/div[1]/h1")
	WebElement attendanceDetailsPageHeaderText;
	@FindBy(xpath="//*[@id=\"uploadform-file\"]")
	WebElement selectExcelFileButton;
	@FindBy(xpath="//*[@id=\"w1\"]/table/tbody/tr[1]/td[9]/a/span")
	WebElement attendanceMarkForEmployee1;
	@FindBy(xpath="//*[@id=\"w1\"]/table/tbody/tr[2]/td[9]/a")
	WebElement attendanceMarkForEmployee2;
	
	public AttendanceDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getAttendanceDetailsPageHeaderText()	//text will be the date itself
	{
		return attendanceDetailsPageHeaderText.getText();
	}
	public void clickSelectExcelFileButton()
	{
		selectExcelFileButton.click();
	}
	public AttendanceMarkWindow clickAttendanceMarkButtonForEmployee1()
	{
		attendanceMarkForEmployee1.click();
		return new AttendanceMarkWindow(driver);
	}
	public AttendanceMarkWindow clickAttendanceMarkButtonForEmployee2()
	{
		attendanceMarkForEmployee2.click();
		return new AttendanceMarkWindow(driver);
	}
	
}
