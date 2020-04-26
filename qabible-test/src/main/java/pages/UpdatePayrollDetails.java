package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatePayrollDetails 
{

	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement headerText;
	@FindBy(xpath="")
	WebElement workingDays;
	@FindBy(xpath="")
	WebElement holiday;
	@FindBy(xpath="")
	WebElement sunday;
	@FindBy(xpath="")
	WebElement extraDuty;
	@FindBy(xpath="")
	WebElement ot;
	@FindBy(xpath="")
	WebElement totalDays;
	@FindBy(xpath="")
	WebElement dailyWage;
	@FindBy(xpath="")
	WebElement monthlyWage;
	@FindBy(xpath="")
	WebElement actualRate;
	@FindBy(xpath="")
	WebElement basicWage;
	@FindBy(xpath="")
	WebElement vda;
	@FindBy(xpath="")
	WebElement otExtra;
	@FindBy(xpath="")
	WebElement extra;
	@FindBy(xpath="")
	WebElement hr;
	@FindBy(xpath="")
	WebElement medical;
	@FindBy(xpath="")
	WebElement fooding;
	@FindBy(xpath="")
	WebElement grossWage;
	@FindBy(xpath="")
	WebElement deductionAdvance;
	@FindBy(xpath="")
	WebElement deduction;
	@FindBy(xpath="")
	WebElement professionalTax;
	@FindBy(xpath="")
	WebElement pf;
	@FindBy(xpath="")
	WebElement netWage;
	@FindBy(xpath="")
	WebElement accountNumber;
	@FindBy(xpath="")
	WebElement saveButton;
	
	public UpdatePayrollDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
}
