package com_pkg_OWM.Workflow_Browser.Serial;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_obj_ObjectRepository.FolderWorkFlows.NavigationTabs;

public class FWF_Documents_Test extends BrowserInvoke{
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException, AWTException {
		//Step-1:-----Login---------------------------------------------//
			FunctionLibrary.fnLogin(driver, propEnv);
			Thread.sleep(3000);
			
		//Step-2:-----Launch WorkFlow Manager---------------------------//
			FunctionLibrary.fnLaunchApplication(driver, "WorkFlow Manager");
			Thread.sleep(3000);
			
		//Step-3:-----Navigate to Respective Tab------------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
			FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
			Thread.sleep(1800);
			
		//Step-4:-----Search for the Required Workflow------------------//
			FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
			Thread.sleep(2000);
			
		//Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			Thread.sleep(10000);
			
		//Step-6:----Navigate to Document Tab----------------------------//
			FunctionLibrary.fnFWFSwitchingTab(driver,"Documents");
			Thread.sleep(2000);
			driver.switchTo().frame("tabIFrame");
		//Step-7:----Actions---------------------------------------------//
				//---Add Document~New Document--------------------------//
			NavigationTabs nav = new NavigationTabs(driver);
			nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Add Document","New Document");
	        Thread.sleep(3000);
	        FunctionLibrary.fnFWFAddDocument(driver,propEnv);
	        
		//Step-8:----Email Documents-------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Email Document(s)","");
	        Thread.sleep(3000);
	        FunctionLibrary.fwf_fnEmailDocument(driver, propEnv);
	        
		//Step-9:-----Change Status--------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Change Status","In Progress");
	        Thread.sleep(3000);
	        
		//Step-10:----Review Documents-----------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Review Document(s)","Archive");
	        Thread.sleep(3000);
	        
		//Step-11:----Associate Documents to workflow--------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Associate Document(s) to WorkFlow","");
	        Thread.sleep(3000);
	        
		//Step-12:----Document Properties--------------------------------//
	        nav.Actions();
			Thread.sleep(300);
	        FunctionLibrary.fnOWMActionsMenu(driver,"Document Properties","");
	        Thread.sleep(3000);
	        FunctionLibrary.fwf_fnDocumentProperties(driver, propEnv);
	        
		//Step-13:---Document History-----------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Document History","");
	        Thread.sleep(3000);
	        
		//Step-14:---Customize View-------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Customize View","");
	        Thread.sleep(3000);
	        String[] array= new String[] {"Task","Status","Checklist","Assigned To","Priority","Link Name","Due Date"};
	        FunctionLibrary.fnOWMCustomizeView(driver,array);
	        
		//Step-15:----Save Preferences-----------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences","");
	        Thread.sleep(3000);
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences");
	        
		//Step-16:---Save Preferences for all---------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences for All","");
	        Thread.sleep(3000);
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences for All");
	        
		//Step-17:---Saved Search---------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Saved Search","");
	        Thread.sleep(3000);
	        FunctionLibrary.fwf_fnSavedSearch(driver, propEnv);
	        
	    //Step-18:---Log Off---------------------------------------------//
			
}
	@AfterClass
	void closeBrowser() throws InterruptedException {
		//FunctionLibrary.fnLogOff(driver);
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
