package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UpdateAreaDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/h1")
	WebElement updateAreaDetailsPageHeaderText;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[1]/input")
	WebElement updatedNameOfArea;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[2]/textarea")
	WebElement updatedDescriptionOfArea;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/form/div[3]/button")
	WebElement saveButton;
	
	public UpdateAreaDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getHeaderTextOfUpdateAreaDetailsPage()
	{
		return updateAreaDetailsPageHeaderText.getText();
	}
	public void enterUpdatedValueForName(String updatedName)
	{
		PageUtility.waitForElement(driver, updatedNameOfArea, 5);
		updatedNameOfArea.clear();
		updatedNameOfArea.sendKeys(updatedName);
	}
	public void enterUpdatedValueForDescription(String updatedDescription)
	{
		PageUtility.waitForElement(driver, updatedDescriptionOfArea, 5);
		updatedDescriptionOfArea.clear();
		updatedDescriptionOfArea.sendKeys(updatedDescription);
	}
	public AreaDetails clickSaveButtonInUpdateAreaDetailsPage()
	{
		PageUtility.waitForElement(driver, saveButton, 5);
		saveButton.click();
		return new AreaDetails(driver);
	}
}
