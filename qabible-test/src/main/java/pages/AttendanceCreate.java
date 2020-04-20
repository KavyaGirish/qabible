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
	
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[5]")
	WebElement date16April2020;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[6]")
	WebElement date17April2020;
	@FindBy(xpath="/html/body/div[2]/div[1]/table/tbody/tr[3]/td[7]")
	WebElement date18April2020;
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
		date17April2020.click();
		//date18April2020.click();
	}
	public void enterDate(String date)
	{
		textDate.sendKeys(date);
	}
	public String getDatePicked()
	{
		return textDate.getText().toString();
	}
	public AttendanceDetails clickCreateButton()
	{
		createButton.click();
		return new AttendanceDetails(driver);
	}
	public boolean getWebElementsVisibilityInAttendencePage()
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
