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
	WebElement areaPageTitle;
	
	@FindBy(xpath="/html/body/div/div/section[2]/div[1]/p/a")
	WebElement createAreaButton;
	
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
		return areaPageTitle.getText();
	}
	public CreateArea clickCreateAreaButtonInAreaPage()
	{
		PageUtility.waitForElement(driver, createAreaButton, 5);
		createAreaButton.click();
		return new CreateArea(driver);
	}
	public String getNameOfCreatedAreaInAreaPage()
	{
		List<WebElement> rowsOfTableCreatedAreas= columnAreasOfTableAreaCreatedInAreaPage;
		int countOfAreasCreated= rowsOfTableCreatedAreas.size();
		System.out.println("Size of Table= "+countOfAreasCreated);
		String newlyCreatedJob= rowsOfTableCreatedAreas.get(countOfAreasCreated-1).getText();
		return newlyCreatedJob;
	}
	public AreaDetails clickViewButtonForArea1InAreaPage()
	{
		PageUtility.waitForElement(driver, viewArea1InAreaPage, 5);
		viewArea1InAreaPage.click();
		return new AreaDetails(driver);
	}
	public AreaDetails clickViewButtonForArea2InAreaPage()
	{
		PageUtility.waitForElement(driver, viewArea2InAreaPage, 5);
		viewArea2InAreaPage.click();
		return new AreaDetails(driver);
	}
	public AreaDetails clickViewButtonForXYZInAreaPage()
	{
		PageUtility.waitForElement(driver, viewXYZInAreaPage, 5);
		viewXYZInAreaPage.click();
		return new AreaDetails(driver);
	}
	public UpdateAreaDetails clickUpdateButtonForArea1InAreaPage()
	{
		PageUtility.waitForElement(driver, updateArea1InAreaPage, 5);
		updateArea1InAreaPage.click();
		return new UpdateAreaDetails(driver);
	}
	public UpdateAreaDetails clickUpdateButtonForArea2InAreaPage()
	{
		PageUtility.waitForElement(driver, updateArea2InAreaPage, 5);
		updateArea2InAreaPage.click();
		return new UpdateAreaDetails(driver);
	}
	public UpdateAreaDetails clickUpdateButtonForXYZInAreaPage()
	{
		PageUtility.waitForElement(driver, updateXYZInAreaPage, 5);
		updateXYZInAreaPage.click();
		return new UpdateAreaDetails(driver);
	}
}
