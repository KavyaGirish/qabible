package scripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.Area;
import pages.AreaDetails;
import pages.Attendance;
import pages.AttendanceCreate;
import pages.AttendanceDetails;
import pages.AttendanceMarkWindow;
import pages.CreateArea;
import pages.CreateHoliday;
import pages.CreateJob;
import pages.Holiday;
import pages.HolidayDeletionAlert;
import pages.HolidayDetails;
import pages.Homepage;
import pages.Job;
import pages.Leave;
import pages.Login;
import pages.Report;
import pages.UpdateAreaDetails;
import pages.UpdateHolidayDetails;
import utilities.ExcelUtility;

public class Regression extends TestHelper
{
	String path= "C:\\Users\\sabar\\git\\qabible\\qabible-test\\src\\test\\resources\\qatestdata.xlsx";
	String sheet= "Sheet1";
	
	//@Test 
	public void verifyValidLogin()
	{
		String expectedPageHeader= "ERP | Dashboard";
			
		Login login= new Login(driver);
		Homepage homepage= login.login("Kavya","kavya9094");
			
		String actualPageHeader= homepage.getHomepageHeaderText();
		assertEquals(actualPageHeader, expectedPageHeader, "Homepage Launches!");
	}
	
	@Test 
	public void verifyInvalidLogin() throws IOException, InterruptedException
	{
		
		String expectedPageHeader= "ERP | Dashboard";
		String expectedErrorMessage= "Please fix the following errors:";
		
		int rowCount= ExcelUtility.getRowCount(path, sheet);
		
		for(int i=1; i<rowCount; i++)
		{
			String username= ExcelUtility.readExcelCellData(path,sheet,i,0);
			String password= ExcelUtility.readExcelCellData(path,sheet,i,1);
			
			Login login= new Login(driver);
			Homepage homepage= login.login(username,password);
			if(username.equals("Kavya")&& password.equals("kavya9094"))
			{
				String actualPageHeader= homepage.getHomepageHeaderText();
				assertEquals(actualPageHeader, expectedPageHeader, "Homepage Launches!");
				
				homepage.clickUserIcon();
				homepage.clickLogOutButton();
				
				ExcelUtility.writeExcelCellData(path, sheet, i, 2, "Pass");
				
			}
			else
			{
				String actualErrorMessage= login.getErrorMessage();
				assertEquals(actualErrorMessage, expectedErrorMessage, "Login fails!");
				
				ExcelUtility.writeExcelCellData(path, sheet, i, 2, "Fail");
			}
		}		
	}	
	
	//@Test 
	public void verifyUserIsAbleToSeeOptionsOfJobsModuleInDashboard() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedOption1="Attendance";
		String expectedOption2="Job";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		homepage.clickModuleJobsInDashboard();
		
		String actualOption1= homepage.getOptionAttendanceFromJobsModule();
		String actualOption2= homepage.getOptionJobFromJobsModule();
		
		assertEquals(actualOption1, expectedOption1, "Attendance Option!");
		assertEquals(actualOption2, expectedOption2, "Job Option!");
		
	}
	
	//@Test
	public void verifyAttendancePageIsLoaded() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		//String expectedAttendancePageHeaderText= "App Frontend";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		homepage.clickModuleJobsInDashboard();
		
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		//String actualAttendancePageHeaderText= attendance.getAttendancePageHeaderText();
		//assertEquals(actualAttendancePageHeaderText, expectedAttendancePageHeaderText, "Attendance Page Loaded!");
		
		assertEquals(attendance.getWebElementsVisibilityInAttendancePageLoaged(),true, "Attendance Page Is Loaded");
	}
	
	//@Test
	public void verifyJobPageIsLoaded() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		//String expectedJobPageHeaderText= "Jobs";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		homepage.clickModuleJobsInDashboard();
		
		Job job= homepage.clickOptionJobFromJobsModule();
		
		//String actualJobPageHeaderText= job.getJobPageHeaderText();
		//assertEquals(actualJobPageHeaderText, expectedJobPageHeaderText, "Job Page Loaded!");
		
		assertEquals(job.getWebElementsVisiblityInJobPageLoaded(), true, "Job page is loaded!");
	}

	//@Test 
	public void verifyUserIsAbleToCreateAndUpdateAreaInCreateAreaPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedNameOfAreaCreated= "Area for Test!";
		String expectedDescriptionOfAreaCreated= "Area for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		CreateArea createArea= job.clickCreateAreaInJobPage();
		
		createArea.enterValueForNameInCreateAreaPage("Test Area");
		createArea.enterValueForDescriptionInCreateAreaPage("Area for Test!");
		AreaDetails areaDetails= createArea.clickSaveButtonInCreateAreaPage();
		
		UpdateAreaDetails updateAreaDetails= areaDetails.clickUpdateButtonInAreaDetailsPage();
		
		updateAreaDetails.enterUpdatedValueForName("Area for Test!");
		updateAreaDetails.enterUpdatedValueForDescription("Area for Test!");
		areaDetails= updateAreaDetails.clickSaveButtonInUpdateAreaDetailsPage();
		 	
		String actualNameOfAreaCreated= areaDetails.getNameOfCreatedArea();
		String actualDescriptionOfAreaCreated= areaDetails.getDescriptionOfCreatedArea();
		
		assertEquals(actualNameOfAreaCreated, expectedNameOfAreaCreated);
		assertEquals(actualDescriptionOfAreaCreated, expectedDescriptionOfAreaCreated);
		
	}
	
	//@Test 
	public void verifyUserIsAbleToViewAndUpdateAreasInAreaPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedArea1NameViewed= "Area1";
		String expectedArea1DescriptionViewed= "Area1 for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		Area area= job.clickAreaInJobpage();
		AreaDetails areaDetails= area.clickViewButtonForArea1InAreaPage();
		
		String actualArea1NameViewed= areaDetails.getNameOfCreatedArea();
		String actualArea1DescriptionViewed= areaDetails.getDescriptionOfCreatedArea();
		
		assertEquals(actualArea1DescriptionViewed, expectedArea1DescriptionViewed, "Description of Area1!");
		assertEquals(actualArea1NameViewed, expectedArea1NameViewed, "Name of Area1!");
		
		area= job.clickAreaInJobpage();
		UpdateAreaDetails updateAreaDetails= area.clickUpdateButtonForArea1InAreaPage();
		
		updateAreaDetails.enterUpdatedValueForName("Area1");
		updateAreaDetails.enterUpdatedValueForDescription("Area1 for Test!");
		areaDetails= updateAreaDetails.clickSaveButtonInUpdateAreaDetailsPage();	
		
	}
		
	//@Test 
	public void verifyUserIsAbleToCreateHolidayInHolidayPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		/*
		String expectedHolidayDate= "16-04-2020";
		String expectedHolidayTitle= "Holiday1";
		String expectedBranch= "Banglore";
		String expectedHolidayDescription= "Holiday for Banglore!";
		String expectedHolidayStatus= "Active";
		*/		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		Holiday holiday= attendance.clickHolidayInAttendancePage();
		
		CreateHoliday createHoliday= holiday.clickCreateHolidayButton();
		
		//create a holiday for 16April2020
		createHoliday.clickDatePickerButtonInCreateHolidayPage();
		createHoliday.clickDate16April2020InCreateHolidayPage();
		
		createHoliday.enterTitleForHolidayInCreateHolidayPage("Holiday1");
		createHoliday.clickBranchDropdown();
		createHoliday.clickBranchBanglore();
		createHoliday.enterDescriptionForHoliday("Holiday for Banglore!");
		createHoliday.clickHolidayStatus();
		HolidayDetails holidayDetails= createHoliday.clickSaveButtonInCreateHolidayPage();
		
		/*
		String actualHolidayDate= holidayDetails.getHolidayDateInHolidayDetailsPage();
		String actualHolidayTitle= holidayDetails.getHolidayTitleInHolidayDetailsPage();
		String actualBranch= holidayDetails.getBranchInHolidayDetailsPage();
		String actualHolidayDescription= holidayDetails.getHolidayDescriptionInHolidayDetailsPage();
		String actualHolidayStatus= holidayDetails.getHolidayStatusInHolidayDetailsPage();
		
		assertEquals(actualHolidayDate, expectedHolidayDate);
		assertEquals(actualHolidayTitle, expectedHolidayTitle);
		assertEquals(actualBranch, expectedBranch);
		assertEquals(actualHolidayDescription, expectedHolidayDescription);
		assertEquals(actualHolidayStatus, expectedHolidayStatus);
		*/
	}
	
	//@Test 
	public void verifyUserIsAbleToUpdateAnExistingHolidayInHolidayPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedHolidayDateUpdated="18-04-2020";
		String expectedHolidayTitleUpdated="Holiday2";
		String expectedBranchUpdated="All";
		String expectedHolidayDescriptionUpdated="Holiday2 update";
		String expectedHolidayStatusUpdated="Inactive";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		Holiday holiday= attendance.clickHolidayInAttendancePage();
		holiday.clickViewButtonOfHoliday2();
		
		holiday= attendance.clickHolidayInAttendancePage();
		
		//update date of an existing holiday 'Holiday2'
		UpdateHolidayDetails updateHolidayDetails= holiday.clickUpdateButtonOfHoliday2();
		updateHolidayDetails.clickCrossButtonInCreateHolidayPage();
		updateHolidayDetails.clickDatePickerButtonInCreateHolidayPage();
		updateHolidayDetails.clickDate18April2020InCreateHolidayPage();
		updateHolidayDetails.enterUpdatedTitleForHolidayInCreateHolidayPage("Holiday2");
		updateHolidayDetails.clickBranchDropdown();
		updateHolidayDetails.clickBranchAll();
		updateHolidayDetails.enterUpdatedDescriptionForHoliday("Holiday2 updated");
		updateHolidayDetails.clickHolidayStatus();
		HolidayDetails holidayDetails= updateHolidayDetails.clickSaveButtonInCreateHolidayPage();
		
		holiday= attendance.clickHolidayInAttendancePage();
		holiday.clickViewButtonOfHoliday2();
	
		String actualHolidayDateUpdated= holidayDetails.getHolidayDateInHolidayDetailsPage();
		String actualHolidayTitleUpdated= holidayDetails.getHolidayTitleInHolidayDetailsPage();
		String actualBranchUpdated= holidayDetails.getBranchInHolidayDetailsPage();
		String actualHolidayDescriptionUpdated= holidayDetails.getHolidayDescriptionInHolidayDetailsPage();
		String actualHolidayStatusUpdated= holidayDetails.getHolidayStatusInHolidayDetailsPage();
		
		assertEquals(actualHolidayDateUpdated, expectedHolidayDateUpdated);
		assertEquals(actualHolidayTitleUpdated, expectedHolidayTitleUpdated);
		assertEquals(actualBranchUpdated, expectedBranchUpdated);
		assertEquals(actualHolidayDescriptionUpdated, expectedHolidayDescriptionUpdated);
		assertEquals(actualHolidayStatusUpdated, expectedHolidayStatusUpdated);
		
	}
	
	//@Test 
	public void verifyUserIsAbleToDeleteAnExistingHolidayInHolidayPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		//skip deleting an existing holiday Holiday2
		Holiday holiday= attendance.clickHolidayInAttendancePage();
		HolidayDeletionAlert holidayDeletionAlert1= holiday.clickDeleteButtonOfHoliday2();
		HolidayDetails holidayDetails= holidayDeletionAlert1.dismissAlertBoxForHolidayDeletion();
		
		//delete an existing holiday Holiday3
		holiday= attendance.clickHolidayInAttendancePage();		
		HolidayDeletionAlert holidayDeletionAlert2= holiday.clickDeleteButtonOfHoliday3();
		holidayDeletionAlert2.acceptAlertBoxForHolidayDeletion();
		
	}
	
	//@Test	
	public void verifyUserIsAbleToCreateAttendanceInAttendancePage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedAttendanceDate= "17-04-2020";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		AttendanceCreate attendanceCreate= attendance.clickCreateAttendanceInAttendancePage();
		
		attendanceCreate.clickDatePicker();
		attendanceCreate.clickDate();
		AttendanceDetails attendanceDetails= attendanceCreate.clickCreateButton();
		AttendanceMarkWindow attendanceMarkWindow= attendanceDetails.clickAttendanceMarkButtonForEmployee1();
		
		attendanceMarkWindow.enterTimeInValue(12, 30);
		attendanceMarkWindow.enterTimeOutValue(20, 10);
		
		attendanceMarkWindow.clickStatusAbsent();
		attendanceMarkWindow.clickShiftDropdown();
		attendanceMarkWindow.clickShiftA();
		attendanceMarkWindow.enterReason("Not feeling well!");
		attendanceDetails= attendanceMarkWindow.clickSaveButtonInAttendanceMarkWindow();
		
		String actualAttendanceDate= attendanceDetails.getAttendanceDetailsPageHeaderText();
		assertEquals(actualAttendanceDate, expectedAttendanceDate);
		
	}
	
	//@Test //fails since worker dropdown cause timeout exception on clicking options
	public void verifyUserIsAbleToApplyLeaveInLeavePage() throws IOException
	{
			
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
			Login login= new Login(driver);
			Homepage homepage= login.login(username,password);
					
			homepage.clickModuleJobsInDashboard();
			Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
			Leave leave= attendance.clickLeaveInAttendancePage();
				
			leave.clickLeaveDaysDropdownInLeavePage();
			leave.clickStartDateOfLeaveForWorker2();
			leave.clickEndDateOfLeaveForWorker2();
			leave.clickApplyButtonInDatePicker();
			leave.clickWorkerDropdown();
			leave.clickWorker2();	//exception since not clickable
			//leave.enterReasonForLeave("Unavoidable family function");
			//attendance= leave.clickSaveButton();
			
	}
	
	//@Test	//fails since client dropdown not interacting
	public void verifyUserIsAbleToCreateJobInJobPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		/*
		String expectedNewlyCreatedJobForBangloreInJobPage="Job1";
		String actualNewlyCreatedJobForBangloreInJobPage;
		
		String expectedNewlyCreatedJobForBhopalInJobPage="Job2";
		String actualNewlyCreatedJobForBhopalInJobPage;
		*/
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		CreateJob createJob= job.clickCreateJobsButtonInJobPage();
		
		createJob.clickBranchValueBangloreFromBranchDropdownInCreateJobPage();
		createJob.enterJobTitleValueInCreateJobPage("Job1");
		//createJob.clickClientValueClient1FromClientDropdownInCreateJobPage();	//not interacting
		createJob.clickJobTypeValueNormalFromJobTypeDropdownInCreateJobPage();
		createJob.enterValueForPoInCreateJobPage("xyz");
		createJob.enterValueForDescriptionInCreateJobPage("Job1 for Test!");
		createJob.clickSaveButtonInCreateJobPage();
		//job.getNewlyCreatedJobInJobPage();
		
	}
	
	//@Test //Incomplete
	public void verifyUserIsAbleToDownloadAttendanceOfTheMonthInReportPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
			Login login= new Login(driver);
			Homepage homepage= login.login(username,password);
					
			homepage.clickModuleJobsInDashboard();
			Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
			Report report= attendance.clickReportInAttendancePage();
					
	}
	
	//@Test //Incomplete
	public void verifyUserIsAbleToExportPayrollInPayrollPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
	}
}
