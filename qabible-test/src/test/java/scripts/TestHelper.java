package scripts;


import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import utilities.GenericUtility;
import utilities.NotepadUtility;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestHelper 
{
	WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws FileNotFoundException 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String path= "D:\\Workspace_Kavya\\qabible-test\\src\\test\\resources\\qaenvironment.txt";
		String url= NotepadUtility.readSampleNotepad(path);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws InterruptedException 
	{
		if(ITestResult.FAILURE== result.getStatus())
		{
			try 
			{
				TakesScreenshot screenshot= (TakesScreenshot)driver;
				File source= screenshot.getScreenshotAs(OutputType.FILE);
				GenericUtility.copyFileUsingStream(source, new File("./target/"+result.getName()+".png"));
				System.out.println("Screenshot taken!");
			}
			catch(Exception e)
			{
				System.out.println("Exception while taking screenshot: "+e.getMessage());
			}
		}
		
		driver.close();
	}

	public void f() {}
}
