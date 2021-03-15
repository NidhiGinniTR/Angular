package com_pkg_OWM.Workflow_Browser.Parallel;

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
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_obj_ObjectRepository.FolderWorkflows1.Events;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.OWM.OWM;
import com_obj_ObjectRepository.OWM.WorkflowBrowser1;
import com_obj_ObjectRepository.FolderWorkflows1.Tasks;

public class FWF_Tasks_Test extends BrowserInvoke {

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
	public void Tasks() throws InterruptedException, AWTException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver,propSerialData);
		FrameWork fm = new FrameWork();
		lp.fnLogin();

		// Step-2:-----Launch WorkFlow Manager---------------------------//
		lp.LaunchApplication("WorkFlow Manager");

		// Step-3:-----Navigate to Respective Tab------------------------//
		lp.fnSwitchtoWindow(2, "WorkFlow Manager");
		driver.manage().window().maximize();
		owm.fnNavigateTab("WorkFlow Browser");

		// Step-4:---------Search for the Required Workflow---------------//
		FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);

		// Step-5:-----Double click on the workflow to Folder Workflows---//
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		//driver.switchTo().frame("viewIFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"DoubleClick");

		// Step-6:------Navigate to Events Tab----------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		Events Ev = new Events(driver,propSerialData);
		Thread.sleep(1500);
		
		// Step-7:--------------Actions----------------------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]/td"))).click()
				.build().perform();
		Ev.fnFWFClickActions();

		// Step-8:-----Change Status-------------------------------------//
		WorkflowBrowser1 Wb = new WorkflowBrowser1(driver, propEnv, propSerialData);
		Wb.fnOWMActionsMenu(driver, "Change Status", "In Progress");

		// Step-9:-----Route Task----------------------------------------//

		// Step-10:-----Task Properties-----------------------------------//

		// Step-11:----Task History--------------------------------------//

		// Step-12:----Reset Checklist-----------------------------------//
		Thread.sleep(1500);
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Reset Checklist", "");
		String text = driver.switchTo().alert().getText();
		if (text.contains("Are you sure you want to proceed?")) {
			driver.switchTo().alert().accept();
		}

		// Step-13:----Add Documents-------------------------------------//
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Add Document", "");
		lp.fnSwitchtoWindow(4, "Add document");
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
		Tasks Tk = new Tasks(driver,propSerialData);
		Tk.fnFWFAddDocument();

		// Step-14:----View Documents------------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		//driver.switchTo().frame("");
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "View Document(s)", "");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Tk.fnFWFViewDocuments();

		// Step-15:----Export--------------------------------------------//

		// Step-16:----------------Customize View-----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));

		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Customize View", "");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		String[] array = new String[] { "Event", "Status", "Date Completed", "Assigned To", "Extended", "Authority",
				"Due Date" };
		Thread.sleep(1000);
		Wb.fnOWMCustomizeView(array);

		// Step-17:----------------Save Preferences-----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Save Preferences", "");
		Wb.fnOWMSavePreferences("Save Preferences");

		// Step-18:----------------Save Preferences for All-----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Save Preferences for All", "");
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
