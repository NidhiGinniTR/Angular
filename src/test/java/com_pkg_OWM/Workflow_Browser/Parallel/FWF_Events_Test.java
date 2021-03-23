package com_pkg_OWM.Workflow_Browser.Parallel;


import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.FolderWorkflows1.Events;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.OWM.OWM;
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
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		}

		@Test(dependsOnMethods = "Initialize")
		public void Events() throws InterruptedException {
			// Step-1:-----Login---------------------------------------------//
			LS1 lp = new LS1(driver, propEnv, propSerialData);
			FrameWork fm = new FrameWork();
			OWM owm = new OWM(driver,propSerialData);
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(80))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			lp.fnLogin();

			// Step-2:-----Launch WorkFlow Manager---------------------------//
			lp.LaunchApplication("WorkFlow Manager");

			// Step-3:-----Navigate to Respective Tab------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			lp.fnSwitchtoWindow(2, "WorkFlow Manager");
			driver.manage().window().maximize();

			// Step-4:---------Search for the Required Workflow---------------//
			owm.fnWorkflowBrowserSearch();

			// Step-5:-----Double click on the workflow to Folder Workflows---//
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
			fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"DoubleClick");
			Thread.sleep(1000);
			
			// Step-6:------Navigate to Events Tab----------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Events Ev = new Events(driver, propSerialData);
			Ev.fnFWFSwitchingTab("Events");

			// Step-7:--------------Actions----------------------------------//
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
			//driver.switchTo().frame("tabIFrame");
			Ev.fnFWFClickActions();

			// Step-8:----Scheduled New Event-------------------------------------//
			WorkflowBrowser1 Wb = new WorkflowBrowser1(driver, propEnv, propSerialData);
			owm.fnOWMActionsMenu("Schedule New Event(s)", "");
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Schedule New Event(s)");
			Ev.fnFWFScheduleNewEvent();

			// Step-9:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-10:----Change Status-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Change Status", "On Hold");

			// Step-11:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-12:----Extend Event-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Extend Event(s)", "");
			Thread.sleep(500);
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Extension");
			Ev.fnFWFExtendEvent();
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText().equalsIgnoreCase("The Scheduled Event(s) has been extended.")) {
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}

			// Step-13:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-14:----------------Re-Calculate-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Re-calculate", "");
			// lp.fnSwitchtoWindow(4,"Folder WorkFlows");
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText().equalsIgnoreCase("0 out of 1 record(s) processed.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}

			// Step-15:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-16:----------------Edit Scheduled Event(s)-----------------------------------//
			// Step-17:----------------Mark Done-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Edit Scheduled Event(s)", "");
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Scheduled Event Profile");
			Ev.fnFWFESEMarkDone("Work Status");

			// Step-18:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-19:----------------Re-Calculate-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Edit Scheduled Event(s)", "");
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Scheduled Event Profile");
			Ev.fnFWFESEReCalculate();

			// Step-20:-----Select Event--------------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFSelectEvent();

			// Step-21:----------------Customize View-----------------------------------//
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Customize View", "");
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Grid Columns");
			String[] array = new String[] { "Event", "Status", "Date Completed", "Assigned To", "Extended", "Authority","Due Date" };
			owm.fnOWMCustomizeView(array);

			// Step-22:----------------Save Preferences-----------------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Folder WorkFlows");
			Ev.fnFWFClickActions();
			owm.fnOWMActionsMenu("Save Preferences", "");
			owm.fnOWMSavePreferences("Save Preferences");

			// Step-23:----------------Save Preferences for All-----------------------------------//
			//Ev.fnFWFClickActions();
			//Wb.fnOWMActionsMenu(driver,"Save Preferences for All", "");
			//wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			//lp.fnSwitchtoWindow(4, "Save Preferences");
			//Wb.fnOWMSavePreferences("Save Preferences for All");

		}
		
		@AfterClass
		void closeBrowser() throws InterruptedException {
			//FunctionLibrary.fnLogOff(driver);
			driver.quit();
		}

		@AfterSuite
		public void aftersuite() {
			ExtentManager.endReport();
		}

	}

