package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Area 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement areaPageHeaderText;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a")
	WebElement createAreaButton;
	@FindBy(xpath="//*[@id=\"w0\"]/table")
	WebElement tableContainingAreaDetails;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr/td[2]")
	List<WebElement> columnAreasOfTableAreaCreatedInAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[4]/td[3]/a[1]")
	WebElement viewArea1InAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[5]/td[3]/a[1]")
	WebElement viewArea2InAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[6]/td[3]/a[1]")
	WebElement viewXYZInAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[4]/td[3]/a[2]")
	WebElement updateArea1InAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[5]/td[3]/a[2]")
	WebElement updateArea2InAreaPage;
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/div/table/tbody/tr[6]/td[3]/a[2]")
	WebElement updateXYZInAreaPage;
	
	public Area(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public String getAreaPageTitle()
	{
		return areaPageHeaderText.getText();
	}
	public CreateArea clickCreateArea()
	{
		PageUtility.waitForElement(driver, createAreaButton, 5);
		createAreaButton.click();
		return new CreateArea(driver);
	}
	public String getName() //of created area
	{
		List<WebElement> rowsOfTableCreatedAreas= columnAreasOfTableAreaCreatedInAreaPage;
		int countOfAreasCreated= rowsOfTableCreatedAreas.size();
		System.out.println("Size of Table= "+countOfAreasCreated);
		String newlyCreatedJob= rowsOfTableCreatedAreas.get(countOfAreasCreated-1).getText();
		return newlyCreatedJob;
	}
	public AreaDetails clickView(String area) //area1
	{
		if(area=="Area1")
		{
			PageUtility.waitForElement(driver, viewArea1InAreaPage, 5);
			viewArea1InAreaPage.click();
		}
		else if(area=="Area2")
		{
			PageUtility.waitForElement(driver, viewArea2InAreaPage, 5);
			viewArea2InAreaPage.click();
		}
		else if(area=="XYZ")
		{
			PageUtility.waitForElement(driver, viewXYZInAreaPage, 5);
			viewXYZInAreaPage.click();
		}
		else
		{}
		return new AreaDetails(driver);
	}
	
	public UpdateAreaDetails clickUpdate(String area) //change as above
	{
		if(area=="Area1")
		{
			PageUtility.waitForElement(driver, updateArea1InAreaPage, 5);
			updateArea1InAreaPage.click();
		}
		else if(area=="Area2")
		{
			PageUtility.waitForElement(driver, updateArea2InAreaPage, 5);
			updateArea2InAreaPage.click();
		}
		else if(area=="XYZ")
		{
			PageUtility.waitForElement(driver, updateXYZInAreaPage, 5);
			updateXYZInAreaPage.click();
		}
		else {}
		return new UpdateAreaDetails(driver);
	}
	
	public boolean getWebElementsVisibility()
	{
		Boolean visibilityOFElement;
		if(areaPageHeaderText.isDisplayed()&& createAreaButton.isDisplayed()&& tableContainingAreaDetails.isDisplayed())
		{
			visibilityOFElement= true;
		}
		else
		{
			visibilityOFElement= false;
		}
		return visibilityOFElement;
	}
}
