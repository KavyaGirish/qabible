package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class CreateArea 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/h1")
	WebElement createAreaPageTitle;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[1]/input")
	WebElement fieldNameInCreateAreaPage;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[2]/textarea")
	WebElement fieldDescriptionInCreateAreaPage;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[3]/button")
	WebElement buttonSave;
	
	public CreateArea(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getCreateAreaPageTitle()
	{
		return createAreaPageTitle.getText();
	}
	public void enterValueForNameInCreateAreaPage(String name)
	{
		PageUtility.waitForElement(driver, fieldNameInCreateAreaPage, 5);
		fieldNameInCreateAreaPage.sendKeys(name);
	}
	public void enterValueForDescriptionInCreateAreaPage(String description)
	{
		PageUtility.waitForElement(driver, fieldNameInCreateAreaPage, 5);
		fieldDescriptionInCreateAreaPage.sendKeys(description);
	}
	public AreaDetails clickSaveButtonInCreateAreaPage()
	{
		PageUtility.waitForElement(driver, buttonSave, 5);
		buttonSave.click();
		return new AreaDetails(driver);
	}
}
