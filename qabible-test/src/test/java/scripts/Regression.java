package scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
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
import pages.JobDetails;
import pages.Leave;
import pages.Login;
import pages.Payroll;
import pages.Report;
import pages.UpdateAreaDetails;
import pages.UpdateHolidayDetails;
import pages.UpdateJobDetails;
import utilities.ExcelUtility;

public class Regression extends TestHelper
{
	String path= "C:\\Users\\sabar\\git\\qabible\\qabible-test\\src\\test\\resources\\qatestdata.xlsx";
	String sheet= "Sheet1";
	
	//@Test 
	public void verifyValidLogin() throws IOException
	{
		String expectedPageHeader= "ERP | Dashboard";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		String actualPageHeader= homepage.getHomepageHeaderText();
		assertEquals(actualPageHeader, expectedPageHeader, "Homepage Launches!");
		
		ExcelUtility.writeExcelCellData(path, sheet, 1, 2, "Pass");
		
		homepage.clickUserIcon();
		homepage.clickLogOutButton();
	}
	
	//@Test 
	public void verifyInvalidLogin() throws IOException, InterruptedException, NullPointerException
	{
		
		String expectedErrorMessage= "Please fix the following errors:";
		int rowCount= ExcelUtility.getRowCount(path, sheet);
		
		for(int i=2; i<rowCount; i++)
		{
			String username= ExcelUtility.readExcelCellData(path,sheet,i,0);
			String password= ExcelUtility.readExcelCellData(path,sheet,i,1);
			
			Login login= new Login(driver);
			login.clearTextFieldsInLoginPage();
			
			login.login(username,password);
			
			String actualErrorMessage= login.getErrorMessage();
			assertEquals(actualErrorMessage, expectedErrorMessage, "Login fails!");
				
			ExcelUtility.writeExcelCellData(path, sheet, i, 2, "Fail");
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
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		homepage.clickModuleJobsInDashboard();
		
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		assertTrue(attendance.getWebElementsVisibilityInAttendancePageLoaged(), "Attendance Page Is Loaded");
	}
	
	//@Test
	public void verifyJobPageIsLoaded() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		homepage.clickModuleJobsInDashboard();
		
		Job job= homepage.clickOptionJobFromJobsModule();
		
		assertTrue(job.getWebElementsVisiblityInJobPageLoaded(), "Job page is loaded!");
	}

	//@Test
	public void verifyCreateAreaPageIsLoaded() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		CreateArea createArea= job.clickCreateAreaInJobPage();
		
		assertTrue(createArea.getWebElementsVisibilityInCreateAreaPage(), "Create Area Page is loaded!");
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
	public void verifyAreaPageIsLoaded() throws IOException
	{
			String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
			String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
			Login login= new Login(driver);
			Homepage homepage= login.login(username,password);
			
			homepage.clickModuleJobsInDashboard();
			Job job= homepage.clickOptionJobFromJobsModule();
			Area area= job.clickAreaInJobpage();
			
			assertTrue(area.getWebElementsVisiblityInAreaPage(), "Create Area Page is loaded!");
	}
	
	//@Test
	public void verifyUserIsAbleToViewDetailsOfExistingAreaInAreaPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedNameOfAreaViewed= "Area1";
		String expectedDescriptionOfAreaViewed= "Area1 for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		Area area= job.clickAreaInJobpage();
		AreaDetails areaDetails= area.clickViewButtonForArea1InAreaPage();
		
		String actualNameOfAreaViewed= areaDetails.getNameOfCreatedArea();
		String actualDescriptionOfAreaViewed= areaDetails.getDescriptionOfCreatedArea();
		
		assertEquals(actualNameOfAreaViewed, expectedNameOfAreaViewed, "Description of Area1!");
		assertEquals(actualDescriptionOfAreaViewed, expectedDescriptionOfAreaViewed, "Name of Area1!");
		
	}
	
	//@Test 
	public void verifyUserIsAbleToUpdateDetailsOfAnAreaInAreaPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		String expectedNameOfAreaUpdated= "Area1";
		String expectedDescriptionOfAreaUpdated= "Area1 for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		Area area= job.clickAreaInJobpage();
		area= job.clickAreaInJobpage();
		UpdateAreaDetails updateAreaDetails= area.clickUpdateButtonForArea1InAreaPage();
		
		updateAreaDetails.enterUpdatedValueForName("Area1");
		updateAreaDetails.enterUpdatedValueForDescription("Area1 for Test!");
		AreaDetails areaDetails= updateAreaDetails.clickSaveButtonInUpdateAreaDetailsPage();	
		
		String actualNameOfAreaUpdated= areaDetails.getNameOfCreatedArea();
		String actualDescriptionOfAreaUpdated= areaDetails.getDescriptionOfCreatedArea();
		
		assertEquals(actualNameOfAreaUpdated, expectedNameOfAreaUpdated, "Name of Area1!");
		assertEquals(actualDescriptionOfAreaUpdated, expectedDescriptionOfAreaUpdated, "Description of Area1!");	
	}
	
	//@Test
	public void verifyHolidayPageIsLoaded() throws IOException	
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		Holiday holiday= attendance.clickHolidayInAttendancePage();
		
		assertTrue(holiday.getWebElementsVisiblityInHolidayPage(), "Holiday page is loaded!");
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
	public void verifyAttendanceCreatePageIsLoaded() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		AttendanceCreate attendanceCreate= attendance.clickCreateAttendanceInAttendancePage();
		
		assertTrue(attendanceCreate.getWebElementsVisibilityInAttendencePage(), "Attendance Create page loaded!");
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
		
		//attendanceCreate.clickDatePicker();
		//attendanceCreate.clickDate();
		attendanceCreate.enterDate("17/04/2020");
		
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
	
	//@Test
	public void verifyLeavePageIsLoaded() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Leave leave= attendance.clickLeaveInAttendancePage();
				
		assertTrue(leave.getWebElementVisibilityInLeavePage(), "Leave Page is loaded!");
	}
	
	//@Test //Assertion error on worker dropdown
	public void verifyUserIsAbleToSeeOptionsOfWorkerDropdownInLeavePage() throws IOException
	{
		String expectedWorker1= "Sagar Alias Jacky";
		String expectedWorker2= "Thomas Mathew";
		String expectedWorker3= "Anil P Tharian";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Leave leave= attendance.clickLeaveInAttendancePage();
		
		leave.clickWorkerDropdown();
	
		String actualWorker1= leave.getWorker1();
		String actualWorker2= leave.getWorker2();
		String actualWorker3= leave.getWorker3();
		
		assertEquals(actualWorker1,expectedWorker1,"Worker1 visible");
		assertEquals(actualWorker2,expectedWorker2,"Worker2 visible");
		assertEquals(actualWorker3,expectedWorker3,"Worker3 visible");
	
	}
	
	//@Test //fails since Worker is not interacting
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
	
	//@Test
	public void verifyReportPageIsLoaded() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Report report= attendance.clickReportInAttendancePage();
			
		assertTrue(report.getWebElementsVisiblityInReportPage(), "Report page is loaded!");
	}
	
	//@Test //Ok button of AlertBox not clickable
	public void verifyUserIsAbleToDownloadAttendanceOfTheMonthInReportPage() throws IOException
	{
		String downloadFolderPath= "C:\\Users\\sabar\\Downloads";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Report report= attendance.clickReportInAttendancePage();
			
		report.clickMonthYearPicker();
		report.clickMarch2020();
		report.clickFindButton();
		report.clickDownloadAttendanceOfTheMonthButton();
		//report.clickCancelButtonInAlertBox();
		
		//report.clickOkButtonInAlertBox();
		//driver.switchTo().alert().accept();
		
	    boolean actualDownloadFileStatus= report.isAttendanceReportDownloaded(downloadFolderPath, "xlsx");
	    assertTrue(actualDownloadFileStatus, "Attendance report is downloaded!");
	
	}
	
	//@Test	//client dropdown not interacting
	public void verifyUserIsAbleToCreateJobInJobPage() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		CreateJob createJob= job.clickCreateJobsButtonInJobPage();
		
		createJob.clickBranchDropdown();
		createJob.clickBranchTvmm();
		createJob.enterJobTitle("Test job");
		createJob.clickClientDropdown();
		createJob.clickClient_Client2();
		createJob.clickJobTypeDropdown();
		
	}
	
	//@Test //assertion fails //error message fails to display
	public void verifyIfJobIsCreatedWithoutClient() throws IOException
	{
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		CreateJob createJob= job.clickCreateJobsButtonInJobPage();
		
		createJob.clickBranchDropdown();
		createJob.clickBranchTvmm();
		createJob.enterJobTitle("Test job without Client");
		createJob.clickJobTypeDropdown();
		createJob.clickJobType_Overtime();
		createJob.enterValueForPo("abc");
		createJob.enterValueForDescription("testing");
		createJob.clickSaveButton();
	
		//assertTrue(createJob.getNoClientError(), "Error!");
		
	}
	
	//@Test 
	public void verifyUserIsAbleToViewExistingJobInJobPage() throws IOException
	{
		String expectedHeaderTextOfBusinessAnalyst= "Business Analyst";
		String expectedClient="Client1";
		String expectedJobType= "Normal";
		String expectedPo= "xyz";
		String expectedDescription= "Challenging";
		String expectedDate= "Apr 10, 2020";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		JobDetails jobDetails= job.clickViewButtonOfBusinessAnalyst();
		
		String actualHeaderTextOfBusinessAnalyst= jobDetails.getHeaderTextOfJobDetailsPageOfBusinessAnalyst();
		String actualClient= jobDetails.getClientOfBusinessAnalyst();
		String actualJobType= jobDetails.getJobTypeOfBusinessAnalyst();
		String actualPo= jobDetails.getPoOfBusinessAnalyst();
		String actualDescription= jobDetails.getDescriptionOfBusinessAnalyst();
		String actualDate= jobDetails.getDateOfBusinessAnalyst();
		
		assertEquals(actualHeaderTextOfBusinessAnalyst, expectedHeaderTextOfBusinessAnalyst, "Title!");
		assertEquals(actualClient, expectedClient, "Client");
		assertEquals(actualJobType, expectedJobType, "Job type!");
		assertEquals(actualPo, expectedPo, "Po!");
		assertEquals(actualDescription, expectedDescription, "Description!");
		assertEquals(actualDate, expectedDate, "Date!");
		
	}
	
	//@Test 
	public void verifyUserIsAbleToUpdateExistingJobInJobPage() throws IOException
	{
		String expectedHeaderTextOfAccountant= "Update Job: Accountant";
		/*
		String expectedClient= "Client2";
		String expectedJobType= "Normal";
		String expectedPo= "xyz";
		String expectedDescription= "Accounting";
		String expectedDate= "Apr 10, 2020";
		*/
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdateButtonOfAccountant();
		
		String actualHeaderTextOfAccountant= updateJobDetails.getHeaderTextOfUpdateJobDetailsPageOfAccountant();
		assertEquals(actualHeaderTextOfAccountant, expectedHeaderTextOfAccountant, "Header!");
		
		updateJobDetails.clickJobType();
		updateJobDetails.clickJobTypeNormal();
		job= updateJobDetails.clickSaveButton();
		
		/*
		JobDetails jobDetails= job.clickViewButtonOfAccountant();
		String actualClient= jobDetails.getClientOfAccountant();
		String actualJobType= jobDetails.getJobTypeOfAccountant();
		String actualPo= jobDetails.getPoOfAccountant();
		String actualDescription= jobDetails.getDescriptionOfAccountant();
		String actualDate= jobDetails.getDateOfAccountant();
		
		assertEquals(actualClient, expectedClient, "Client");
		assertEquals(actualJobType, expectedJobType, "JobType");
		assertEquals(actualPo, expectedPo, "Po");
		assertEquals(actualDescription, expectedDescription, "Description");
		assertEquals(actualDate, expectedDate, "Date");
		*/
	}
	
	//@Test //error message not asserted
	public void verifyErrorDisplayedWhenClientValueIsBlankInUpdateJobDetailPage() throws IOException
	{
		String expectedErrorMessage= "Client cannot be blank.";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdateButtonOfAccountant();
		updateJobDetails.clearClientValue();
	
		assertTrue(updateJobDetails.checkNoClientErrorDisplayed(),"Error!");
		
	}
	
	//@Test //client dropdown options not interacting
	public void verifyUserIsAbleToSeeOptionsInClientDropdownInUpdateJobDetailsPage() throws IOException
	{
		
		String expectedClientOption1= "AAA";
		String expectedClientOption2= "Client1";
		String expectedClientOption3= "Client2";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdateButtonOfAccountant();
		//updateJobDetails.clearClientValue();
		updateJobDetails.clickClientDropdown();
		
		String actualClientOption1= updateJobDetails.getClientAAA();
		String actualClientOption2= updateJobDetails.getClient1();
		String actualClientOption3= updateJobDetails.getClient2();
		
		assertEquals(actualClientOption1, expectedClientOption1, "AAA");
		assertEquals(actualClientOption2, expectedClientOption2, "Client1");
		assertEquals(actualClientOption3, expectedClientOption3, "Client2");
		
	}
	
	//@Test 
	public void verifyUserIsAbleToSeeOptionsInJobTypeDropdownInUpdateJobDetailsPage() throws IOException
	{
		String expectedJobtypeOption1= "Normal";
		String expectedJobtypeOption2= "Overtime";
		
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdateButtonOfAccountant();
		updateJobDetails.clickJobType();
		
		String actualJobtypeOption1= updateJobDetails.getJobType_Normal();
		String actualJobtypeOption2= updateJobDetails.getJobType_Overtime();
		
		assertEquals(actualJobtypeOption1, expectedJobtypeOption1, "normal!");
		assertEquals(actualJobtypeOption2, expectedJobtypeOption2, "overtime!");
		
	}
	
	//@Test
	public void verifyPayrollPageIsLoaded() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayrollInAttendancePage();
			
		assertEquals(payroll.getWebElementsVisiblityInPayrollPage(), true, "Payroll Page is loaded!");
	}
		
	//@Test //Incomplete
	public void verifyUserIsAbleToExportPayrollInPayrollPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayrollInAttendancePage();
			
			//page methods pending
	}
		
	//@Test //Incomplete
	public void verifyUserIsAbleToViewExistingPayrollDetailsOfEmployeeInPayrollPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayrollInAttendancePage();
					
	}
	
	//@Test //Incomplete
	public void verifyUserIsAbleToUpdateExistingPayrollDetailsOfEmployeeInPayrollPage() throws IOException
	{
		String username= ExcelUtility.readExcelCellData(path,sheet,1,0);
		String password= ExcelUtility.readExcelCellData(path,sheet,1,1);
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayrollInAttendancePage();
						
	}
}
