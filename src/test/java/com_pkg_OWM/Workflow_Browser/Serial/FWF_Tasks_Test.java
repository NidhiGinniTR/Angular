package com_pkg_OWM.Workflow_Browser.Serial;

import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
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

public class FWF_Tasks_Test extends BrowserInvoke {

	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	@Test
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
			
		//Step-6:-----Click on Tasks Tab and Actions--------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(3));
			driver.switchTo().parentFrame();
			FunctionLibrary.fnSwitchtoWindow(driver,3, "");
	        Thread.sleep(8000);
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]/td"))).click().build().perform();
	        Thread.sleep(300);
	        
		//Step-7:-----Change Status-------------------------------------//
	        NavigationTabs nav = new NavigationTabs(driver);
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Change Status","In Progress");
	        Thread.sleep(5000);
	        
		/*//Step-8:-----Route Task----------------------------------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Route Task","");
	        
		//Step-9:-----Task Properties-----------------------------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Task Properties","");
	        Thread.sleep(2345);
	        //FunctionLibrary.	        
		//Step-10:----Task History--------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Task History","");*/
	        
		//Step-11:----Reset Checklist-----------------------------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Reset Checklist","");
	        Thread.sleep(500);
	        String text = driver.switchTo().alert().getText();
			if (text.contains("Are you sure you want to proceed?")) {
				Thread.sleep(500);
				driver.switchTo().alert().accept();	
			}
			Thread.sleep(4000);
	        
		//Step-12:----Add Documents-------------------------------------//
			action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Add Document","");
	        Thread.sleep(5000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4,"Add document");
	        Thread.sleep(1567);
	        driver.switchTo().frame("frame1");
	        FunctionLibrary.fnFWFAddDocument(driver,propSerialData);
	        Thread.sleep(3000);
	        
		/*//Step-13:----View Documents------------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"View Document(s)","");
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Task Properties");
	        
	        
		//Step-14:----Export--------------------------------------------//
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Export","");*/
	        
		//Step-15:----Customize View-------------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Customize View","");
	        Thread.sleep(7000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4,"Grid Columns");
	        Thread.sleep(1567);
	        String[] array= new String[] {"Task","Status","Checklist","Assigned To","Priority","Link Name","Due Date"};
	        FunctionLibrary.fnOWMCustomizeView(driver, array);
	        Thread.sleep(5000);
	        
		//Step-16:----Save Preferences----------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences","");
	        Thread.sleep(5000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Save Preferences");
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences");
	        Thread.sleep(4000);
	        
		//Step-17:----Save Preferences for All--------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences for All","");
	        Thread.sleep(5000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Save Preferences");
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences for All");
	        
		//Step-18:----LogOff-------------------------------------------//
		
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
