package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;
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

public class OWM_Actions_Test extends BrowserInvoke {

	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException {
		FrameWork fm = new FrameWork();
		// Step-1:-----Login---------------------------------------------//
		FunctionLibrary.fnLogin(driver, propEnv);

		// Step-2:-----Launch WorkFlow Manager---------------------------//
		FunctionLibrary.fnLaunchApplication(driver, "WorkFlow Manager");
		Thread.sleep(3000);

		// Step-3:-----Navigate to Respective Tab------------------------//
		new WebDriverWait(driver, 50).until(ExpectedConditions.numberOfWindowsToBe(2));
		FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
		Thread.sleep(900);

		// Step-4:---------------Create a New Folder----------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "New Folder", "");
		Thread.sleep(2500);
		new WebDriverWait(driver, 25000).until(ExpectedConditions.numberOfWindowsToBe(3));
		FunctionLibrary.fnNewFolderCreation(driver, propSerialData);

		// Step-5:---------Search for the Required Workflow---------------//
		FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
		Thread.sleep(2000);

		// Step-6:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"DoubleClick");
		Thread.sleep(500);

		// Step-7----------------------Create a New WorkFlow--------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "New WorkFlow", "");
		new WebDriverWait(driver, 2500).until(ExpectedConditions.numberOfWindowsToBe(3));
		FunctionLibrary.fnOWMNewWorkFlow(driver, propSerialData);

		// Step-8:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-9------Verifying the WorkFlow Properties-------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Delete WorkFlow(s)", "");
		FunctionLibrary.fnOWMDeleteWorkflow(driver, driver.switchTo().alert().getText(),
				"Do you want to delete these workflows?");

		// Step-10:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-11-----------------Lock WorkFlow--------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Lock WorkFlow(s)", "");
		if (driver.switchTo().alert().getText()
				.equalsIgnoreCase("You are about to lock the selected WorkFlow(s). Please confirm.")) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}

		// Step-12:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-13-------------Verify WorkFlow Properties----------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "WorkFlow Properties", "");

		// Step-14:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-15-------------Unlocking the WorkFlow---------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Unlock WorkFlow(s)", "");
		if (driver.switchTo().alert().getText()
				.equalsIgnoreCase("You are about to unlock the selected WorkFlow(s). Please confirm.")) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}

		// Step-16:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-17--------WorkFlow History-------------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "WorkFlow History", "");

		// Step-18:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"Click");
		Thread.sleep(500);

		// Step-19--------Export-------------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Export", "");

		// Step-20:---Customize View-------------------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Customize View", "");
		Thread.sleep(3000);
		String[] array = new String[] { "Year", "Period", "Tax Type", "Status", "Enity Name", "Entity ID",
				"Due Date" };
		FunctionLibrary.fnOWMCustomizeView(driver, array);

		// Step-21:----Save Preferences-----------------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Save Preferences", "");
		Thread.sleep(3000);
		FunctionLibrary.fnOWMSavePreferences(driver, "Save Preferences");

		// Step-22:---Save Preferences for all---------------------------//
		FunctionLibrary.fnOWMActionsMenu(driver, "Save Preferences for All", "");
		Thread.sleep(3000);
		FunctionLibrary.fnOWMSavePreferences(driver, "Save Preferences for All");

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
