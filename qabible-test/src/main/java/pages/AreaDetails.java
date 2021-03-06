package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AreaDetails 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/h1")
	WebElement areaDetailsPageHeaderText;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/table/tbody/tr[2]/td")
	WebElement nameOfArea;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/table/tbody/tr[3]/td")
	WebElement descriptionOfArea;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a")
	WebElement updateButton;
	
	public AreaDetails(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getHeaderText()
	{
		return areaDetailsPageHeaderText.getText();
	}
	public String getName()
	{
		return nameOfArea.getText();
	}
	public String getDescription()
	{
		return descriptionOfArea.getText();
	}
	public UpdateAreaDetails clickUpdate()
	{
		PageUtility.waitForElementClicked(driver, updateButton, 5);
		updateButton.click();
		return new UpdateAreaDetails(driver);
	}
}
