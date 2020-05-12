package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AttendanceCreate 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement attendanceCreatePageHeaderText;
	@FindBy(xpath="//*[@id=\"attendance-date-kvdate\"]/span[1]")
	WebElement datePicker;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr/td[contains(@class,'today day')]")
	WebElement currentDate;
	@FindBy(xpath="//*[@id=\"attendance-date-kvdate\"]/span[2]")
	WebElement clearDate;
	@FindBy(xpath="//*[@id=\"attendance-date\"]")
	WebElement textDate;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/button")
	WebElement createButton;
	
	public AttendanceCreate(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void clickDatePicker()
	{
		datePicker.click();
	}
	public void clearDate()
	{
		clearDate.click();
	}
	public void clickDate()
	{
		currentDate.click();
	}
	public AttendanceDetails clickCreate()
	{
		createButton.click();
		return new AttendanceDetails(driver);
	}
	public boolean getWebElementsVisibility()
	{
		Boolean visibilityOfElements;
		if(attendanceCreatePageHeaderText.isDisplayed()&& datePicker.isDisplayed()&& clearDate.isDisplayed()&& textDate.isDisplayed()&&createButton.isDisplayed())
		{
			visibilityOfElements= true;
		}
		else
		{
			visibilityOfElements= false;
		}
		return visibilityOfElements;
		
	}
}
