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
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[6]")
	WebElement june2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[7]")
	WebElement july2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[8]")
	WebElement august2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[9]")
	WebElement september2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[10]")
	WebElement october2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[11]")
	WebElement november2020;
	@FindBy(xpath="/html/body/div[2]/div[2]/table/tbody/tr/td/span[12]")
	WebElement december2020;
	
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
	public boolean getWebElementsVisiblity()
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
	public void clickMonth(String monthYear)
	{
		if(monthYear=="January2020")
		{
			january2020.click();
		}
		else if(monthYear=="February2020")
		{
			february2020.click();
		}
		else if(monthYear=="March2020")
		{
			march2020.click();
		}
		else if(monthYear=="April2020")
		{
			april2020.click();
		}
		else if(monthYear=="May2020")
		{
			may2020.click();
		}
		else if(monthYear=="June2020")
		{
			june2020.click();
		}
		else if(monthYear=="July2020")
		{
			july2020.click();
		}
		else if(monthYear=="August2020")
		{
			august2020.click();
		}
		else if(monthYear=="September2020")
		{
			september2020.click();
		}
		else if(monthYear=="October2020")
		{
			october2020.click();
		}
		else if(monthYear=="November2020")
		{
			november2020.click();
		}
		else if(monthYear=="December2020")
		{
			december2020.click();
		}
		else
		{}
	}
	public void clickClearMonthYear()
	{
		clearMonthYear.click();
	}
	public String getMonthYear()
	{
		return textMonthYear.getText();
	}
	public void clickFind()
	{
		PageUtility.waitForElement(driver, findButton, 10);
		findButton.click();
	}
	
	public void clickDownloadAttendanceOfTheMonth()
	{
		PageUtility.waitForElementClicked(driver, downloadAttendanceOfMonthButton, 20);
		downloadAttendanceOfMonthButton.click();
	}
	public void clickCancel()
	{
		PageUtility.waitForAlert(driver, cancelButtonInAlertBox, 15);
		cancelButtonInAlertBox.click();
	}
	public void clickOk()
	{
		PageUtility.waitForAlert(driver, okButtonInAlertBox, 15);
		okButtonInAlertBox.click();
	}
	public boolean isAttendanceReportDownloaded(String downloadPath, String extension)
	{
		PageUtility.handleSleep(10000);
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
