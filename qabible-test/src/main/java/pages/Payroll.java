package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

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
	WebElement colsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[1]/div/label/input")
	WebElement toggleAll_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[3]/div/label/input")
	WebElement hash_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[4]/div/label/input")
	WebElement employee_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[5]/div/label/input")
	WebElement branch_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[6]/div/label/input")
	WebElement workingDays_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[7]/div/label/input")
	WebElement holidays_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[8]/div/label/input")
	WebElement sunday_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[9]/div/label/input")
	WebElement extraDuty_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[10]/div/label/input")
	WebElement ot_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[11]/div/label/input")
	WebElement totalDays_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[12]/div/label/input")
	WebElement dailyWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[13]/div/label/input")
	WebElement monthlyWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[14]/div/label/input")
	WebElement actualRate_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[15]/div/label/input")
	WebElement basicWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[16]/div/label/input")
	WebElement vda_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[17]/div/label/input")
	WebElement otWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[18]/div/label/input")
	WebElement extra_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[19]/div/label/input")
	WebElement hr_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[20]/div/label/input")
	WebElement medical_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[21]/div/label/input")
	WebElement fooding_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[22]/div/label/input")
	WebElement grossWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[23]/div/label/input")
	WebElement deductionAdvance_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[24]/div/label/input")
	WebElement deduction_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[25]/div/label/input")
	WebElement professionalTax_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[26]/div/label/input")
	WebElement pf_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[27]/div/label/input")
	WebElement netWage_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[28]/div/label/input")
	WebElement accountNumber_ColsDropdown;
	@FindBy(xpath="//*[@id=\"w1-cols-list\"]/li[29]/div/label/input")
	WebElement uan_ColsDropdown;
	
	@FindBy(xpath="//*[@id=\"w3\"]")
	WebElement exportAllDropdown;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[1]/a")
	WebElement HTML_ExportAll;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[2]/a")
	WebElement CSV_ExportAll;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[3]/a")
	WebElement text_ExportAll;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[4]/a")
	WebElement PDF_ExportAll;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[5]/a")
	WebElement excel95_ExportAll;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div[3]/div/div[2]/div/div[2]/ul/li[6]/a")
	WebElement excel2007_ExportAll;
	
	
	@FindBy(xpath="//*[@id=\"w5-container\"]/table")
	WebElement tableContainingPayrollDetails;
	
	@FindBy(xpath="//*[@id=\"w5-container\"]/table/tbody/tr/td[11]/a")
	WebElement attachPayrollButtonOfSagar;
	@FindBy(xpath="//*[@id=\"w5-container\"]/table/tbody/tr/td[12]/a[1]")
	WebElement viewPayrollButtonOfSagar;
	@FindBy(xpath="//*[@id=\"w5-container\"]/table/tbody/tr/td[12]/a[2]")
	WebElement updatePayrollButtonOfSagar;
	
	public Payroll(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}	
	public boolean getWebElementsVisiblity()
	{
		boolean visibilityOfElement;
		if(payrollPageHeaderText.isDisplayed()&& monthYearPicker.isDisplayed()&& clearMonthYear.isDisplayed()&& textMonthYear.isDisplayed()&&findButton.isDisplayed()&&colsDropdown.isDisplayed()&&exportAllDropdown.isDisplayed()&&tableContainingPayrollDetails.isDisplayed())
		{
			visibilityOfElement= true;
		}
		else
		{
			visibilityOfElement= false;
		}
		return visibilityOfElement;
	}
	public void mouseHoverOnColumnsDropdown()
	{
		new Actions(driver).moveToElement(colsDropdown).build().perform();
	}
	public String getTooltipTextOfColumnsDropdown()
	{
		String toolTipText= colsDropdown.getAttribute("title");
		return toolTipText;
	}
	public void clickColumsDropdown()
	{
		PageUtility.waitForElement(driver, colsDropdown, 10);
		colsDropdown.click();
	}
	public void clickToggleAll()	//checkbox
	{
		PageUtility.waitForElement(driver, toggleAll_ColsDropdown, 15);
		toggleAll_ColsDropdown.click();
	}
	public boolean isAllDropdownOptionsToggled()
	{
		if(hash_ColsDropdown.isSelected()&&employee_ColsDropdown.isSelected()&&branch_ColsDropdown.isSelected()&&workingDays_ColsDropdown.isSelected()&&holidays_ColsDropdown.isSelected()&&sunday_ColsDropdown.isSelected()&&extraDuty_ColsDropdown.isSelected()&&ot_ColsDropdown.isSelected()&&totalDays_ColsDropdown.isSelected()&&dailyWage_ColsDropdown.isSelected()&&monthlyWage_ColsDropdown.isSelected()&&actualRate_ColsDropdown.isSelected()&&basicWage_ColsDropdown.isSelected()&&vda_ColsDropdown.isSelected()&&otWage_ColsDropdown.isSelected()&&extra_ColsDropdown.isSelected()&&hr_ColsDropdown.isSelected()&&medical_ColsDropdown.isSelected()&&medical_ColsDropdown.isSelected()&&fooding_ColsDropdown.isSelected()&&grossWage_ColsDropdown.isSelected()&&deductionAdvance_ColsDropdown.isSelected()&&deduction_ColsDropdown.isSelected()&&professionalTax_ColsDropdown.isSelected()&&pf_ColsDropdown.isSelected()&&netWage_ColsDropdown.isSelected()&&accountNumber_ColsDropdown.isSelected()&&uan_ColsDropdown.isSelected())
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public void mouseHoverOnExportAllDropdown()
	{
		new Actions(driver).moveToElement(exportAllDropdown).build().perform();
	}
	public String getTooltipTextOfExportAllDropdown()
	{
		String toolTipText= exportAllDropdown.getAttribute("title");
		return toolTipText;
	}
	public void clickExportAllDropdown()
	{
		exportAllDropdown.click();
	}
	public String getOptionOfExportAll(String option)
	{
		String op="";
		if(option=="HTML")
		{
			op= HTML_ExportAll.getText();
		}
		else if(option=="CSV")
		{
			op= CSV_ExportAll.getText();
		}
		else if(option=="Text")
		{
			op= text_ExportAll.getText();
		}
		else if(option=="PDF")
		{
			op= PDF_ExportAll.getText();
		}
		else if(option=="Excel95")
		{
			op= excel95_ExportAll.getText();
		}
		else if(option=="Excel2007")
		{
			op= excel2007_ExportAll.getText();
		}
		else
		{}
		return op;
	}
	
	public PayrollDetails clickView(String employee)
	{
		if(employee=="Sagar")
		{
			viewPayrollButtonOfSagar.click();
		}
		return new PayrollDetails(driver);
	}
	public UpdatePayrollDetails clickUpdate(String employee)
	{
		if(employee=="Sagar")
		{
			updatePayrollButtonOfSagar.click();
		}
		return new UpdatePayrollDetails(driver);
	}
}
