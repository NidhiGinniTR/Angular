package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_obj_ObjectRepository.FolderWorkFlows.Events;



public class FWF_Events_Test extends BrowserInvoke {
	
	@BeforeSuite
	public void beforesuit() {
		ExtentManager.createInstance();
	}
	
	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods =  "Initialize" )
	public void EventActions() throws InterruptedException {
	//Step-1:-----Login---------------------------------------------//
		FunctionLibrary.fnLogin(driver, propEnv);
		
	//Step-2:-----Launch WorkFlow Manager---------------------------//
		FunctionLibrary.fnLaunchApplication(driver, "Calendar");
		Thread.sleep(1500);
		
	//Step-3:-----Navigate to Respective Tab------------------------//
		new WebDriverWait(driver, 50).until(ExpectedConditions.numberOfWindowsToBe(2));
		FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
		Thread.sleep(1000);
		
	//Step-4:---------------Create a New Folder----------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "New Folder","");
		Thread.sleep(2500);
		//Thread.sleep(2500);
		new WebDriverWait(driver, 30).until(ExpectedConditions.numberOfWindowsToBe(3));
		FunctionLibrary.fnNewFolderCreation(driver, propSerialData);
		
	//Step-5:---------Search for the Required Workflow---------------//	
		FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
		Thread.sleep(2000);
		
	//Step-6:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"DoubleClick");
		Thread.sleep(500);
		
	//Step-7:------Navigate to Events Tab----------------------------//
		FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
		Thread.sleep(2500);
		FunctionLibrary.fnFWFSwitchingTab(driver, "Events");
		
	//Step-8:--------------Actions----------------------------------//
		FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
		Thread.sleep(1000);
		driver.switchTo().frame("tabIFrame");
		Thread.sleep(500);
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Schedule New Event(s)", "");	
		       
	//Step-9:----Scheduled New Event-------------------------------------//
		FunctionLibrary.fnSwitchtoWindow(driver,4, "Folder WorkFlows");
		FunctionLibrary.fnFWFScheduleNewEvent(driver, propSerialData);
        
	//Step-10:-----Select Event--------------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
        
	//Step-11:----Change Status-----------------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Change Status", "On Hold");
		Thread.sleep(1500);
		
	//Step-12:-----------Select Event--------------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500); 
		
	//Step-13:-----------------Extend Events--------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Extend Event(s)", "");
		Thread.sleep(3500);
		FunctionLibrary.fnSwitchtoWindow(driver,4, "Folder WorkFlows");
        Events SNE=new Events(driver);
		Thread.sleep(1500);
		SNE.fwf_Events_SNE_ScheduleExtension();
		Thread.sleep(1500);
		System.out.println(driver.switchTo().alert().getText());
		if(driver.switchTo().alert().getText().equalsIgnoreCase("The Scheduled Event(s) has been extended.")) {
			driver.switchTo().alert().accept();
		}else {
			driver.close();
		}
		Thread.sleep(1500);
        
	//Step-14:-----------Select Event---------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
		
        
	//Step-15:----------------Re-Calculate-----------------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Re-calculate", "");
		Thread.sleep(1500);
		if(driver.switchTo().alert().getText().equalsIgnoreCase("0 out of 1 record(s) processed.") ) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		}else {
			driver.close();
		}
		Thread.sleep(1500);
        
	//Step-16:--------Select Event------------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
	
	//Step-17:--------Edit Scheduled Event - Mark Done------------------------------------//	
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
		Thread.sleep(1500);
		FunctionLibrary.fnFWFESEMarkDone(driver);
		Thread.sleep(1500);
		
	//Step-18:--------Select Event------------------------------------//
		/*FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
			
	//Step-19:--------Edit Scheduled Event - Roll Forward------------------------------------//	
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1500);
		FunctionLibrary.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
		Thread.sleep(1500);
		FunctionLibrary.fnFWFESERollForward(driver);*/
		Thread.sleep(1500);
	
	//Step-20:--------Select Event------------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
	
	//Step-21:--------Edit Scheduled Event-Re-Calculate-------------------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
		Thread.sleep(1500);
		FunctionLibrary.fnFWFESEReCalculate(driver);
		
	//Step-22:--------Select Event------------------------------------//
		/*FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
		 
	//Step-23:--------Edit Scheduled Event-Extend Event-------------------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
		Thread.sleep(1500);
		FunctionLibrary.fnFWFESEExtendEvent(driver);*/
	
	//Step-22:--------Select Event------------------------------------//
		FunctionLibrary.fnFWFSelectEvent(driver, propSerialData);
		Thread.sleep(500);
				
	//Step-24:--------Customize View------------------------------------//
		driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		Thread.sleep(1000);
		FunctionLibrary.fnOWMActionsMenu(driver, "Customize View", "");
		String[] array= new String[] {"Event","Status","Date Completed","Assigned To","Extended","Authority","Due Date"};
	    FunctionLibrary.fnOWMCustomizeView(driver, array);
		Thread.sleep(1500);
		
	//Step-25:----Save Preferences-----------------------------------//
		 driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		 FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences","");
	     Thread.sleep(3000);
	     FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences");
	        
	//Step-26:---Save Preferences for all---------------------------//
	      driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
	      FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences for All","");
	      Thread.sleep(3000);
	      FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences for All");
        
    //Step-27:---Log Off---------------------------------------------//
	      
	}
	
	@AfterClass
	void closeBrowser() throws InterruptedException {
		FunctionLibrary.fnLogOff(driver);
	}
	
	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
	
}
