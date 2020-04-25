package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Payroll
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement payrollPageHeaderText;
	@FindBy(xpath="//*[@id=\"payrollform-date-kvdate\"]/span[1]/i")
	WebElement monthYearPicker;
	@FindBy(xpath="//*[@id=\"payrollform-date-kvdate\"]/span[2]/i")
	WebElement clearMonthYear;
	@FindBy(xpath="//*[@id=\"payrollform-date\"]")
	WebElement textMonthYear;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/div/button")
	WebElement findButton;
	@FindBy(xpath="//*[@id=\"w1-cols\"]")
	WebElement columnsDropdown;
	@FindBy(xpath="//*[@id=\"w3\"]")
	WebElement exportAllDropdown;
	@FindBy(xpath="//*[@id=\"w5-container\"]/table")
	WebElement tableContainingPayrollDetails;
	
	public Payroll(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}	
	public boolean getWebElementsVisiblityInPayrollPage()
	{
		boolean visibilityOfElement;
		if(payrollPageHeaderText.isDisplayed()&& monthYearPicker.isDisplayed()&& clearMonthYear.isDisplayed()&& textMonthYear.isDisplayed()&&findButton.isDisplayed()&&columnsDropdown.isDisplayed()&&exportAllDropdown.isDisplayed()&&tableContainingPayrollDetails.isDisplayed())
		{
			visibilityOfElement= true;
		}
		else
		{
			visibilityOfElement= false;
		}
		return visibilityOfElement;
	}
	
}
