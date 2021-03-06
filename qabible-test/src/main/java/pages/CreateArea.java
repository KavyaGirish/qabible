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
	WebElement createAreaPageHeaderText;
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
	public String getCreateAreaPageHeaderText()
	{
		return createAreaPageHeaderText.getText();
	}
	public void enterName(String name)
	{
		PageUtility.waitForElementClicked(driver, fieldNameInCreateAreaPage, 5);
		fieldNameInCreateAreaPage.sendKeys(name);
	}
	public void enterDescription(String description)
	{
		PageUtility.waitForElementClicked(driver, fieldNameInCreateAreaPage, 5);
		fieldDescriptionInCreateAreaPage.sendKeys(description);
	}
	public AreaDetails clickSave()
	{
		PageUtility.waitForElementClicked(driver, buttonSave, 5);
		buttonSave.click();
		return new AreaDetails(driver);
	}
	public boolean getWebElementsVisibility()
	{
		Boolean visibilityOfElement;
		if(createAreaPageHeaderText.isDisplayed()&& fieldNameInCreateAreaPage.isDisplayed()&& fieldDescriptionInCreateAreaPage.isDisplayed()&&buttonSave.isDisplayed())
		{
			visibilityOfElement=true;
		}
		else
		{
			visibilityOfElement=false;
		}
		return visibilityOfElement;
	}
}
