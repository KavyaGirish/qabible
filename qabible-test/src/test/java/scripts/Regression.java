package scripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.DataProvider;
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
import pages.PayrollDetails;
import pages.Report;
import pages.UpdateAreaDetails;
import pages.UpdateHolidayDetails;
import pages.UpdateJobDetails;
import pages.UpdatePayrollDetails;
import utilities.ExcelUtility;
import utilities.GenericUtility;

public class Regression extends TestHelper
{
	String path= "C:\\Users\\sabar\\git\\qabible\\qabible-test\\src\\test\\resources\\qatestdata.xlsx";
	String sheet= "Login";
	
	@DataProvider (name="loginCredentials")
	public Object[][] getLoginCredentials() throws Exception
	{	
		int rowCount= ExcelUtility.getRowCount(path, sheet);
		//System.out.println(rowCount);
		int columnCount= ExcelUtility.getColumnCount(path, sheet);
		//System.out.println(columnCount);
		
		Object[][] credentials= new Object[rowCount-1][columnCount];
		
		int k=0;
		for(int i=1; i<rowCount; i++)
		{
			credentials[k][0]=  ExcelUtility.readExcelCellData(path, sheet, i, 0);
			credentials[k][1]=  ExcelUtility.readExcelCellData(path, sheet, i, 1);
			k++;
		}
		return credentials; 
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyValidLogin(String username, String password)
	{
		String expectedPageHeader= "ERP | Dashboard";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		String actualPageHeader= homepage.getHomepageHeaderText();
		assertEquals(actualPageHeader, expectedPageHeader, "Homepage Launches!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyInvalidLogin(String username, String password) 
	{
		String expectedErrorMessage= "Please fix the following errors:";
		
		Login login= new Login(driver);
		login.clearTextFields();	
		login.login(username,password);
			
		String actualErrorMessage= login.getErrorMessage();
		assertEquals(actualErrorMessage, expectedErrorMessage, "Login fails!");
	}	
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyTooltipTextOfJobsModuleInDashboard(String username, String password) 
	{
		String expectedTooltip= "Jobs";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.mouseHoverOnJobsModuleInDashboard();
		String actualTooltip= homepage.getTooltipTextOfJobsModule();
		assertEquals(actualTooltip, expectedTooltip, "Tooltip!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToSeeOptionsOfJobsModuleInDashboard(String username, String password) 
	{
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
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyAttendancePageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		assertTrue(attendance.getWebElementsVisibility(), "Attendance Page Is Loaded");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyJobPageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		assertTrue(job.getWebElementsVisibility(), "Job page is loaded!");
	}

	//@Test (dataProvider= "loginCredentials")
	public void verifyCreateAreaPageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		CreateArea createArea= job.clickCreateArea();
		
		assertTrue(createArea.getWebElementsVisibility(), "Create Area Page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToCreateAndUpdateAreaInCreateAreaPage(String username, String password) 
	{
		String expectedName= "Area for Test!";
		String expectedDescription= "Area for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		CreateArea createArea= job.clickCreateArea();
		
		createArea.enterName("Test Area");
		createArea.enterDescription("Area for Test!");
		AreaDetails areaDetails= createArea.clickSave();
		
		UpdateAreaDetails updateAreaDetails= areaDetails.clickUpdate();
		
		updateAreaDetails.enterName("Area for Test!");
		updateAreaDetails.enterDescription("Area for Test!");
		areaDetails= updateAreaDetails.clickSave();
		 	
		String actualName= areaDetails.getName();
		String actualDescription= areaDetails.getDescription();
		
		assertEquals(actualName, expectedName);
		assertEquals(actualDescription, expectedDescription);
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyAreaPageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		Area area= job.clickArea();
			
		assertTrue(area.getWebElementsVisibility(), "Create Area Page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToViewDetailsOfExistingAreaInAreaPage(String username, String password) 
	{
		String expectedName= "Area1";
		String expectedDescription= "Area1 for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		Area area= job.clickArea();
		AreaDetails areaDetails= area.clickView("Area1"); 
		
		String actualName= areaDetails.getName();
		String actualDescription= areaDetails.getDescription();
		
		assertEquals(actualName, expectedName, "Description of Area1!");
		assertEquals(actualDescription, expectedDescription, "Name of Area1!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToUpdateDetailsOfAnAreaInAreaPage(String username, String password)
	{
		String expectedName= "Area1";
		String expectedDescription= "Area1 for Test!";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
		
		homepage.clickModuleJobsInDashboard();
		Job job= homepage.clickOptionJobFromJobsModule();
		
		Area area= job.clickArea();
		area= job.clickArea();
		UpdateAreaDetails updateAreaDetails= area.clickUpdate("Area1"); 
		
		updateAreaDetails.enterName("Area1");
		updateAreaDetails.enterDescription("Area1 for Test!");
		AreaDetails areaDetails= updateAreaDetails.clickSave();	
		
		String actualName= areaDetails.getName();
		String actualDescription= areaDetails.getDescription();
		
		assertEquals(actualName, expectedName, "Name of Area1!");
		assertEquals(actualDescription, expectedDescription, "Description of Area1!");	
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyHolidayPageIsLoaded(String username, String password) 	
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Holiday holiday= attendance.clickHoliday();
		
		assertTrue(holiday.getWebElementsVisibility(), "Holiday page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToCreateHolidayInHolidayPage(String username, String password) 
	{
		String expectedDate= GenericUtility.getCurrentDate();
		String expectedTitle= "Holiday1";
		String expectedBranch= "Tvmm";
		String expectedDescription= "Holiday for Banglore!";
		String expectedStatus= "Active";
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		Holiday holiday= attendance.clickHoliday();
		
		CreateHoliday createHoliday= holiday.clickCreateHoliday();
		
		createHoliday.clickDatePicker();
		//createHoliday.clickDate(); 
		createHoliday.enterDate(GenericUtility.getCurrentDate());
		createHoliday.enterTitle("Holiday1");
		createHoliday.clickBranchDropdown();
		createHoliday.clickBranch("Tvmm");
		createHoliday.enterDescription("Holiday for Banglore!");
		createHoliday.clickStatus();
		HolidayDetails holidayDetails= createHoliday.clickSave();
		
		String actualDate= holidayDetails.getDate();
		String actualTitle= holidayDetails.getTitle();
		String actualBranch= holidayDetails.getBranch();
		String actualDescription= holidayDetails.getDescription();
		String actualStatus= holidayDetails.getStatus();
		
		assertEquals(actualDate, expectedDate);
		assertEquals(actualTitle, expectedTitle);
		assertEquals(actualBranch, expectedBranch);
		assertEquals(actualDescription, expectedDescription);
		assertEquals(actualStatus, expectedStatus);
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToUpdateAnExistingHolidayInHolidayPage(String username, String password) 
	{
		String expectedTitle= "Holiday2";
		String expectedBranch= "All";
		String expectedDescription= "Holiday2 updated";
		String expectedStatus= "Inactive";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		
		Holiday holiday= attendance.clickHoliday();
		holiday.clickView("Holiday2");
		
		holiday= attendance.clickHoliday();
		
		UpdateHolidayDetails updateHolidayDetails= holiday.clickUpdate("Holiday2");
		updateHolidayDetails.clickClose();
		updateHolidayDetails.clickDatePicker();
		updateHolidayDetails.clickDate();
		updateHolidayDetails.enterTitle("Holiday2");
		updateHolidayDetails.clickBranchDropdown();
		updateHolidayDetails.clickBranch("All");
		updateHolidayDetails.enterDescription("Holiday2 updated");
		updateHolidayDetails.clickStatus();
		HolidayDetails holidayDetails= updateHolidayDetails.clickSave();
	
		String actualTitle= holidayDetails.getTitle();
		String actualBranch= holidayDetails.getBranch();
		String actualDescription= holidayDetails.getDescription();
		String actualStatus= holidayDetails.getStatus();
		
		assertEquals(actualTitle, expectedTitle);
		assertEquals(actualBranch, expectedBranch);
		assertEquals(actualDescription, expectedDescription);
		assertEquals(actualStatus, expectedStatus);
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyAttendanceCreatePageIsLoaded(String username, String password)
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		AttendanceCreate attendanceCreate= attendance.clickCreateAttendance();
		
		assertTrue(attendanceCreate.getWebElementsVisibility(), "Attendance Create page loaded!");
	}
	
	//@Test	 (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToCreateAttendanceInAttendancePage(String username, String password) 
	{
		String expectedAttendanceDate= GenericUtility.getCurrentDate();
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		AttendanceCreate attendanceCreate= attendance.clickCreateAttendance();
		
		attendanceCreate.clickDatePicker();
		attendanceCreate.clickDate();
		
		AttendanceDetails attendanceDetails= attendanceCreate.clickCreate();
		AttendanceMarkWindow attendanceMarkWindow= attendanceDetails.clickAttendanceMark("Employee1");
		
		attendanceMarkWindow.enterTimeIn(12, 30);
		attendanceMarkWindow.enterTimeOut(20, 10);
		attendanceMarkWindow.clickStatus("Absent");
		attendanceMarkWindow.clickShiftDropdown();
		attendanceMarkWindow.clickShift("A");
		attendanceMarkWindow.enterReason("Not feeling well!");
		attendanceDetails= attendanceMarkWindow.clickSave();
		
		String actualAttendanceDate= attendanceDetails.getAttendanceDetailsPageHeaderText();
		assertEquals(actualAttendanceDate, expectedAttendanceDate);
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyLeavePageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Leave leave= attendance.clickLeave();
				
		assertTrue(leave.getWebElementVisibility(), "Leave Page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToSeeOptionsOfWorkerDropdownInLeavePage(String username, String password)
	{
		String expectedWorker1= "Sagar Alias Jacky";
		String expectedWorker2= "Thomas Mathew";
		String expectedWorker3= "Anil P Tharian";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Leave leave= attendance.clickLeave();
		
		leave.clickWorkerDropdown();
	
		String actualWorker1= leave.getWorker("Worker1");
		String actualWorker2= leave.getWorker("Worker2");
		String actualWorker3= leave.getWorker("Worker3");
		
		assertEquals(actualWorker1,expectedWorker1,"Worker1 visible");
		assertEquals(actualWorker2,expectedWorker2,"Worker2 visible");
		assertEquals(actualWorker3,expectedWorker3,"Worker3 visible");
	}
	
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyReportPageIsLoaded(String username, String password)
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Report report= attendance.clickReport();
			
		assertTrue(report.getWebElementsVisiblity(), "Report page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToDownloadAttendanceOfTheMonthInReportPage(String username, String password) 
	{
		String downloadFolderPath= "C:\\Users\\sabar\\Downloads";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
					
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Report report= attendance.clickReport();
			
		report.clickMonthYearPicker();
		report.clickMonth("March2020");
		report.clickFind();
		report.clickDownloadAttendanceOfTheMonth();
		//report.clickCancel();
		report.clickOk();
		
	    boolean actualDownloadFileStatus= report.isAttendanceReportDownloaded(downloadFolderPath, "xlsx");
	    assertTrue(actualDownloadFileStatus, "Attendance report is downloaded!");
	}
	
	//@Test	(dataProvider= "loginCredentials")
	public void verifyUserIsAbleToCreateJobInJobPage(String username, String password) 
	{
		String expectedJob="Test job";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		CreateJob createJob= job.clickCreateJobs();
		
		createJob.clickBranchDropdown();
		createJob.clickBranch("Tvmm");
		createJob.enterTitle("Test job");
		createJob.clickClientDropdown();
		createJob.clickClient("Client1");
		createJob.clickJobTypeDropdown();
		createJob.clickJobType("Normal");
		createJob.enterPo("test");
		createJob.enterDescription("Desc");
		job= createJob.clickSave();
		
		String actualJob= job.getJobCreated();
		assertEquals(actualJob, expectedJob, "Test job!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyJobIsNotCreatedWithoutClient(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		CreateJob createJob= job.clickCreateJobs();
		
		createJob.clickBranchDropdown();
		createJob.clickBranch("Tvmm");
		createJob.enterTitle("Test job without Client");
		createJob.clickJobTypeDropdown();
		createJob.clickJobType("Overtime");
		createJob.enterPo("abc");
		createJob.enterDescription("testing");
		createJob.clickSave();
	
		assertTrue(createJob.getNoClientError(), "Error!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToViewExistingJobInJobPage(String username, String password)
	{
		String expectedHeaderText= "Business Analyst";
		String expectedClient="Client1";
		String expectedJobType= "Normal";
		String expectedPo= "xyz";
		String expectedDescription= "Challenging";
		String expectedDate= "Apr 10, 2020";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
			
		JobDetails jobDetails= job.clickView("BusinessAnalyst");
		
		String actualHeaderText= jobDetails.getHeaderText();
		String actualClient= jobDetails.getClient();
		String actualJobType= jobDetails.getJobType();
		String actualPo= jobDetails.getPo();
		String actualDescription= jobDetails.getDescription();
		String actualDate= jobDetails.getDate();
		
		assertEquals(actualHeaderText, expectedHeaderText, "Title!");
		assertEquals(actualClient, expectedClient, "Client");
		assertEquals(actualJobType, expectedJobType, "Job type!");
		assertEquals(actualPo, expectedPo, "Po!");
		assertEquals(actualDescription, expectedDescription, "Description!");
		assertEquals(actualDate, expectedDate, "Date!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToUpdateExistingJobInJobPage(String username, String password) 
	{
		String expectedClient= "Client2";
		String expectedJobType= "Normal";
		String expectedPo= "xyz";
		String expectedDescription= "Accounting";
		String expectedDate= "Apr 10, 2020";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdate("Accountant");
		updateJobDetails.clickJobType();
		updateJobDetails.clickJobType("Normal");
		job= updateJobDetails.clickSave();
		
		JobDetails jobDetails= job.clickView("Accountant");
		String actualClient= jobDetails.getClient();
		String actualJobType= jobDetails.getJobType();
		String actualPo= jobDetails.getPo();
		String actualDescription= jobDetails.getDescription();
		String actualDate= jobDetails.getDate();
		
		assertEquals(actualClient, expectedClient, "Client");
		assertEquals(actualJobType, expectedJobType, "JobType");
		assertEquals(actualPo, expectedPo, "Po");
		assertEquals(actualDescription, expectedDescription, "Description");
		assertEquals(actualDate, expectedDate, "Date");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyErrorDisplayedWhenClientValueIsBlankInUpdateJobDetailPage(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdate("Accountant");
		updateJobDetails.clearClient();
	
		assertTrue(updateJobDetails.isNoClientErrorDisplayed(),"Error!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToSeeOptionsInClientDropdownInUpdateJobDetailsPage(String username, String password) 
	{
		String expectedOption1= "AAA";
		String expectedOption2= "Client1";
		String expectedOption3= "Client2";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdate("Accountant");
		updateJobDetails.clickClientDropdown();
		
		String actualOption1= updateJobDetails.getClient("AAA");
		String actualOption2= updateJobDetails.getClient("Client1");
		String actualOption3= updateJobDetails.getClient("Client2");
		
		assertEquals(actualOption1, expectedOption1, "AAA");
		assertEquals(actualOption2, expectedOption2, "Client1");
		assertEquals(actualOption3, expectedOption3, "Client2");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToSeeOptionsInJobTypeDropdownInUpdateJobDetailsPage(String username, String password) 
	{
		String expectedOption1= "Normal";
		String expectedOption2= "Overtime";
		
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();			
		Job job= homepage.clickOptionJobFromJobsModule();
		
		UpdateJobDetails updateJobDetails= job.clickUpdate("Accountant");
		updateJobDetails.clickJobType();
		
		String actualOption1= updateJobDetails.getJobType("Normal");
		String actualOption2= updateJobDetails.getJobType("Overtime");
		
		assertEquals(actualOption1, expectedOption1, "normal!");
		assertEquals(actualOption2, expectedOption2, "overtime!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyPayrollPageIsLoaded(String username, String password) 
	{
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
			
		assertEquals(payroll.getWebElementsVisiblity(), true, "Payroll Page is loaded!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyTooltipTextOfColumnsDropdownInPayrollPage(String username, String password) 
	{
		String expectedTooltipText= "Select columns to export";
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
		
		payroll.mouseHoverOnColumnsDropdown();
		String actualTooltipText= payroll.getTooltipTextOfColumnsDropdown();
		assertEquals(actualTooltipText, expectedTooltipText, "Tooltip text of Cols!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyTooltipTextOfExportAllDropdownInPayrollPage(String username, String password) 
	{
		String expectedTooltipText= "Export data in selected format";
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
		
		payroll.mouseHoverOnExportAllDropdown();
		String actualTooltipText= payroll.getTooltipTextOfExportAllDropdown();
		assertEquals(actualTooltipText, expectedTooltipText, "Tooltip text of Export All!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyToggleAllCheckboxTogglesAllColumnsOfColumnsDropdownInPayrollPage(String username, String password) 
	{	
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
		
		payroll.clickColumsDropdown();
		payroll.clickToggleAll();
		
		boolean actualToggle= payroll.isAllDropdownOptionsToggled();
		assertTrue(actualToggle,"Toggling!");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToSeeOptionsOfExportAllDropdownInPayrollPage(String username, String password) 
	{
		String expectedOption1= "HTML";
		String expectedOption2= "CSV";
		String expectedOption3= "Text";
		String expectedOption4= "PDF";
		String expectedOption5= "Excel 95 +";
		String expectedOption6= "Excel 2007+";
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
		
		payroll.clickExportAllDropdown();
		String actualOption1= payroll.getOptionOfExportAll("HTML");
		String actualOption2= payroll.getOptionOfExportAll("CSV");
		String actualOption3= payroll.getOptionOfExportAll("Text");
		String actualOption4= payroll.getOptionOfExportAll("PDF");
		String actualOption5= payroll.getOptionOfExportAll("Excel95");
		String actualOption6= payroll.getOptionOfExportAll("Excel2007");
		
		assertEquals(actualOption1, expectedOption1, "HTML");
		assertEquals(actualOption2, expectedOption2, "CSV");
		assertEquals(actualOption3, expectedOption3, "Text");
		assertEquals(actualOption4, expectedOption4, "PDF");
		assertEquals(actualOption5, expectedOption5, "Excel 95 +");
		assertEquals(actualOption6, expectedOption6, "Excel 2007+");
	}
	
	//@Test (dataProvider= "loginCredentials")
	public void verifyUserIsAbleToViewExistingPayrollDetailsOfEmployeeInPayrollPage(String username, String password) 
	{
		String expectedHeaderText= "sagar";
		String expectedFullName= "Sagar Alias Jacky";
		String expectedBranch= "Tvmm";
			
		Login login= new Login(driver);
		Homepage homepage= login.login(username,password);
			
		homepage.clickModuleJobsInDashboard();
		Attendance attendance= homepage.clickOptionAttendanceFromJobsModule();
		Payroll payroll= attendance.clickPayroll();
					
		PayrollDetails payrollDetails= payroll.clickView("Sagar");
		
		String actualHeaderText= payrollDetails.getHeaderTextOfPayrollDetails("Sagar");
		String actualFullName= payrollDetails.getFullName();
		String actualBranch= payrollDetails.getBranch();
		
		assertEquals(actualHeaderText, expectedHeaderText, "Header text!");
		assertEquals(actualFullName, expectedFullName, "Sagar");
		assertEquals(actualBranch, expectedBranch, "Tvmm");
	}	
}
