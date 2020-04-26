package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class Report 
{
	WebDriver driver;
	
	@FindBy(xpath="/html/body/div/div/section[1]/h1")
	WebElement reportPageHeadeText;
	@FindBy(xpath="//*[@id=\"attendanceform-date-kvdate\"]/span[1]/i")
	WebElement monthYearPicker;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[1]")
	WebElement january2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[2]")
	WebElement february2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[3]")
	WebElement march2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[4]")
	WebElement april2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[5]")
	WebElement may2020;
	@FindBy(xpath="//*[@id=\"attendanceform-date-kvdate\"]/span[2]/i")
	WebElement clearMonthYear;
	@FindBy(xpath="//*[@id=\"attendanceform-date\"]")
	WebElement textMonthYear;
	@FindBy(xpath="//*[@id=\"w0\"]/div[2]/div/button")
	WebElement findButton;
	@FindBy(xpath="/html/body/div/div/section[2]/div/div[1]/div[2]/div/div/ul/li/a")
	WebElement downloadAttendanceOfMonthButton;
	@FindBy(xpath="//*[@id=\"w3-container\"]/table")
	WebElement tableContainingAttendances;
	@FindBy(xpath="/html/body/div[3]/div/div/div[3]/div/div/button[1]")
	WebElement cancelButtonInAlertBox;
	@FindBy(xpath="/html/body/div[3]/div/div/div[3]/div/div/button[2]")
	WebElement okButtonInAlertBox;
	
	public Report(WebDriver driver) 
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public boolean getWebElementsVisiblityInReportPage()
	{
		Boolean visibilityOfElement;
		if(reportPageHeadeText.isDisplayed()&& monthYearPicker.isDisplayed()&& clearMonthYear.isDisplayed()&& textMonthYear.isDisplayed()&&findButton.isDisplayed()&&downloadAttendanceOfMonthButton.isDisplayed()&&tableContainingAttendances.isDisplayed())
		{
			visibilityOfElement= true;
		}
		else
		{
			visibilityOfElement= false;
		}
		return visibilityOfElement;
	}
	public void mouseHoverOnDatePicker()
	{
		//PageUtility.waitForElement(driver, monthYearPicker, 10);
		new Actions(driver).moveToElement(monthYearPicker).build().perform();
	}
	public String getTooltipTextOfDatePickerButton()
	{
		String toolTipText= monthYearPicker.getAttribute("title");
		return toolTipText;
	}
	public void clickMonthYearPicker()
	{
		monthYearPicker.click();
	}
	public void clickJanuary2020()
	{
		january2020.click();
	}
	public void clickFebruary2020()
	{
		february2020.click();
	}
	public void clickMarch2020()
	{
		march2020.click();
	}
	public void clickApril2020()
	{
		april2020.click();
	}
	public void clickMay2020()
	{
		may2020.click();
	}
	public void clickClearMonthYearPicked()
	{
		clearMonthYear.click();
	}
	public String getMonthYearPicked()
	{
		return textMonthYear.getText();
	}
	public void clickFindButton()
	{
		PageUtility.waitForElement(driver, findButton, 10);
		findButton.click();
	}
	
	public void clickDownloadAttendanceOfTheMonthButton()
	{
		PageUtility.waitForElement(driver, downloadAttendanceOfMonthButton, 10);
		downloadAttendanceOfMonthButton.click();
	}
	public void clickCancelButtonInAlertBox()
	{
		PageUtility.waitForElement(driver, cancelButtonInAlertBox, 20);
		cancelButtonInAlertBox.click();
	}
	public void clickOkButtonInAlertBox()
	{
		PageUtility.waitForElement(driver, okButtonInAlertBox, 20);
		okButtonInAlertBox.click();
	}
	public boolean isAttendanceReportDownloaded(String downloadPath, String extension)
	{
		boolean statusOfDownload= false;
		File downloadsFolder = new File(downloadPath);
    	File[] files = downloadsFolder.listFiles();
    	if(files==null || files.length==0) 
    	{
    		statusOfDownload=false;
    	}
    	else
    	{
    		File lastDownloadedFile= files[0];
    		for(int i= 1; i<files.length; i++) 
    		{
    			if(lastDownloadedFile.lastModified()< files[i].lastModified()) 
    			{
    				lastDownloadedFile = files[i];
    				if(lastDownloadedFile.getName().contains(extension))
    				{
    					statusOfDownload=true;
    				}
    			}
    		}
    	}
    	return statusOfDownload;
	}
}
