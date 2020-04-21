package scripts;


import org.testng.annotations.BeforeMethod;

import utilities.NotepadUtility;

import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	public void closeBrowser() throws InterruptedException 
	{
		Thread.sleep(5000);
		driver.close();
	}

	public void f() {}
}
