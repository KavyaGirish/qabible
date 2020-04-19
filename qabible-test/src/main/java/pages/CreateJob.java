package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class CreateJob 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[2]/div/div/label")
	WebElement textAttendanceNotDone;
	
	@FindBy(xpath="/html/body/div[1]/header/nav/div/ul/form/select")
	WebElement branchDropdown;
	
	@FindBy(id="job-title")
	WebElement fieldJobTitle;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select")
	WebElement fieldClientDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[2]")
	WebElement optionValueAAAInClientDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[3]")
	WebElement optionValueClient1InClientDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[2]/div[1]/div/select/option[4]")
	WebElement optionValueClient2InClientDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select")
	WebElement fieldJobTypeDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select/option[2]")
	WebElement optionValueNormalJobTypeDropdown;
	
	@FindBy(xpath="/html/body/div[1]/div/section[2]/div[1]/form/div[3]/div[1]/div/select/option[3]")
	WebElement optionValueOvertimeJobTypeDropdown;
	
	@FindBy(id="job-po")
	WebElement fieldPo;
	
	@FindBy(id="job-description")
	WebElement fieldJobDescription;
	
	@FindBy(xpath="//*[@id=\"w0\"]/div[5]/button")
	WebElement buttonSave;
	
	public CreateJob(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getTextAttendanceNotDoneInCreateJobPage()
	{
		return textAttendanceNotDone.getText();
	}
	public void clickBranchValueBangloreFromBranchDropdownInCreateJobPage()
	{
		branchDropdown.click();
		Select selectBranch= new Select(branchDropdown);
		selectBranch.selectByVisibleText("Banglore");
	}
	public void clickBranchValueBhopalFromBranchDropdownInCreateJobPage()
	{
		branchDropdown.click();
		Select selectBranch= new Select(branchDropdown);
		selectBranch.selectByVisibleText("Bhopal");
	}
	public void enterJobTitleValueInCreateJobPage(String jobTitle)
	{
		fieldJobTitle.sendKeys(jobTitle);
	}
	public void clickClientValueAAAFromClientDropdownInCreateJobPage()
	{
		PageUtility.waitForElement(driver, fieldClientDropdown, 5);
		fieldClientDropdown.click();
		optionValueAAAInClientDropdown.click();
	}
	public void clickClientValueClient1FromClientDropdownInCreateJobPage()
	{
		PageUtility.waitForElement(driver, fieldClientDropdown, 5);
		fieldClientDropdown.click();
		optionValueClient1InClientDropdown.click();
	}
	public void clickClientValueClient2FromClientDropdownInCreateJobPage()
	{
		PageUtility.waitForElement(driver, fieldClientDropdown, 5);
		fieldClientDropdown.click();
		optionValueClient2InClientDropdown.click();
	}
	public void clickJobTypeValueNormalFromJobTypeDropdownInCreateJobPage()
	{
		fieldJobTypeDropdown.click();
		optionValueNormalJobTypeDropdown.click();
	}
	public void clickJobTypeValueOvertimeFromJobTypeDropdownInCreateJobPage()
	{
		fieldJobTypeDropdown.click();
		optionValueOvertimeJobTypeDropdown.click();
	}
	public void enterValueForPoInCreateJobPage(String po)
	{
		fieldPo.sendKeys(po);
	}
	public void enterValueForDescriptionInCreateJobPage(String description)
	{
		fieldJobDescription.sendKeys(description);
	}
	public Job clickSaveButtonInCreateJobPage()
	{
		buttonSave.click();
		return new Job(driver);
	}
}
