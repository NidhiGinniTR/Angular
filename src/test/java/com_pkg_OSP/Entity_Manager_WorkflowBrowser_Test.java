package com_pkg_OSP;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;
import com_obj_ObjectRepository.LS1.LS1;

public class Entity_Manager_WorkflowBrowser_Test extends BrowserInvoke {
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void EUB_WorkflowBrowser() throws InterruptedException {
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager");

		// Step-3:----------Workflow Browser---------------------------//
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		
		Eub.fnEM_SwitchTabs("Workflow Browser");
		
		// Step-4:---------Verify Search Fields---------------------------//
		driver.switchTo().frame("gridFrame");
		Thread.sleep(500);
		//String[] array = new String[] { "W/F Template:","Period:","Year:","Jurisdiction:", "Entity Name:", "Entity ID:", "Tax Type:",
				//"WorkFlow Association:","WorkFlow Type:" };
		//Eub.fnVerifySearchElements(array);
		
		// Step-5:------------Verify Action Menu items---------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnActionsMenuEnabled();
		Eub.fnActionsMenuDisabled();
		
		//-----------------------------------------------------------------------
		Eub.fnEM_SearchWorkflow();
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridWorkflowFolders_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
			fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
			Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
			Eub.fnDeleteWorkflow();
			lp.fnSwitchtoWindow(1, "Onesource");
			driver.switchTo().defaultContent();
			driver.switchTo().frame("maincontent");
			driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
			driver.switchTo().frame("gridFrame");
		}
		Thread.sleep(1000);
		
		//Step-6:---------------------New Folder------------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("New Folder", "");
		
		//Step-7--------------------------New Folder-------------------------------
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "New Folder");
		Eub.fnEM_NewFolder();
		
		//Step-8---------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
	
		//Step-9------------------New Workflow--------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("New WorkFlow", "");
		
		//Step-10--------------------New Workflow------------------------------------
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "New WorkFlow");
		Eub.fnEM_NewWorkflow();
		
		//Step-11---------------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-12-----------------Delete Workflow------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		Eub.fnDeleteWorkflow();
		
		//Step-13------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
	
		//Step-14------------------------Workflow Properties------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("WorkFlow Properties", "");
		
		//Step-15----------------------Workflow Properties-----------------------------
		lp.fnSwitchtoWindow(2, "WorkFlow Properties");
		Eub.fnWorkflowProperties();
		
		//Step-16------------------------Switch Frame--------------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		//Eub.fnEM_SearchDocument();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-17----------------------Click Actions------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		//Eub.fnOWMActionsMenu("Reset Checklist", "");
		//Eub.fnResetChecklist();
		//Thread.sleep(2500);
		
		//Step-18:----------------Customize View-----------------------------------//
		//fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu( "Customize View", "");
		Thread.sleep(2500);
		lp.fnSwitchtoWindow(2, "Customize View");
		String[] array3 = new String[] { "Entity Name", "Entity ID", "Tax Type", "Year", "Period","Jurisdiction", "Description" };
		Eub.fnCustomizeView(array3);
		
		// Step-19:----------------Save Preferences-----------------------------------//
		/*lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		//lp.fnSwitchtoWindow(1, "LS1");
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step-20:----------------Save Preferences for All-----------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");*/
		
		//Step-21------------------------Search Workflow--------------------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-22------------------Delete Workflow-------------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		Eub.fnDeleteWorkflow();
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(1, "Onesource");
		
		// Step--------LogOFF-------------------------------//
		Eub.fnLogOff();
	}
	
	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		//driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
