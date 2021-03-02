package com_pkg_OWM.Workflow_Browser.Parallel;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_obj_ObjectRepository.FolderWorkflows1.Events;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.OWM.WorkflowBrowser1;
public class FWF_Events_Test extends BrowserInvoke {

		@BeforeSuite
		public void beforeStart() {
			ExtentManager.createInstance();
		}

		@Test
		public void Initialize() throws IOException {
			driver = InvokeDriver();
			driver.get(propEnv.getProperty("URL"));
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		}

		@Test(dependsOnMethods = "Initialize")
		public void Tasks() throws InterruptedException {
			// Step-1:-----Login---------------------------------------------//
			LS1 lp = new LS1(driver, propEnv, propSerialData);
			FrameWork fm = new FrameWork();
			lp.fnLogin();

			// Step-2:-----Launch WorkFlow Manager---------------------------//
			lp.LaunchApplication("WorkFlow Manager");

			// Step-3:-----Navigate to Respective Tab------------------------//
			lp.fnSwitchtoWindow(2, "WorkFlow Manager");
			driver.manage().window().maximize();

			// Step-4:---------Search for the Required Workflow---------------//
			FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);

			// Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
					"DoubleClick");

			// Step-6:------Navigate to Events Tab----------------------------//
			Thread.sleep(1000);
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Events Ev = new Events(driver, propSerialData);
			Ev.fnFWFSwitchingTab("Events");

			// Step-7:--------------Actions----------------------------------//
			driver.switchTo().frame("tabIFrame");
			Ev.fnFWFClickActions();

			// Step-8:----Scheduled New Event-------------------------------------//
			WorkflowBrowser1 Wb = new WorkflowBrowser1(driver, propEnv, propSerialData);
			Wb.fnOWMActionsMenu(driver, "Schedule New Event(s)", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			Ev.fnFWFScheduleNewEvent();

			// Step-9:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-10:----Change Status-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Change Status", "On Hold");

			// Step-11:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-12:----Extend Event-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Extend Event(s)", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			Ev.fnFWFExtendEvent();
			if (driver.switchTo().alert().getText().equalsIgnoreCase("The Scheduled Event(s) has been extended.")) {
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}

			// Step-13:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-14:----------------Re-Calculate-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Re-calculate", "");
			// lp.fnSwitchtoWindow(4,"Folder WorkFlows");
			if (driver.switchTo().alert().getText().equalsIgnoreCase("0 out of 1 record(s) processed.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}

			// Step-15:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-16:----------------Edit Scheduled Event(s)-----------------------------------//
			// Step-17:----------------Mark Done-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			Ev.fnFWFESEMarkDone("Work Status");

			// Step-18:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-19:----------------Re-Calculate-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Edit Scheduled Event(s)", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			Ev.fnFWFESEReCalculate();

			// Step-20:-----Select Event--------------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-21:----------------Customize View-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Customize View", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			String[] array = new String[] { "Event", "Status", "Date Completed", "Assigned To", "Extended", "Authority",
					"Due Date" };
			Wb.fnOWMCustomizeView(array);

			// Step-22:----------------Save Preferences-----------------------------------//
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Save Preferences", "");
			Wb.fnOWMSavePreferences("Save Preferences");

			// Step-23:----------------Save Preferences for All-----------------------------------//
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver,"Save Preferences for All", "");
			lp.fnSwitchtoWindow(4, "Folder WorkFlows");
			Wb.fnOWMSavePreferences("Save Preferences for All");

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

