package com_pkg_OWM.Workflow_Browser.Parallel;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.FolderWorkflows1.Tasks;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.OWM.OWM;

public class FWF_Tasks_Test extends BrowserInvoke {

	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException, AWTException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		OWM owm = new OWM(driver, propSerialData);
		FrameWork fm = new FrameWork();
		Tasks Tk = new Tasks(driver, propSerialData);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(90))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class, NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		lp.fnLogin();

		// Step-2:-----Launch WorkFlow Manager---------------------------//
		lp.LaunchApplication("WorkFlow Manager");

		// Step-3:-----Navigate to Respective Tab------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "WorkFlow Manager");
		driver.manage().window().maximize();
		owm.fnNavigateTab("WorkFlow Browser");
		Thread.sleep(1000);
		driver.switchTo().defaultContent();

		// Step-4:---------Search for the Required Workflow---------------//
		owm.fnWorkflowBrowserSearch();

		// Step-5:-----Double click on the workflow to Folder Workflows---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"DoubleClick");
		Thread.sleep(3000);

		// Step-6:------Navigate to Events Tab----------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		Thread.sleep(1500);

		// Step-7:--------------Actions----------------------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]/td"))).click()
				.build().perform();
		Tk.fnFWFClickActions();

		// Step-8:-----Change Status-------------------------------------//
		// WorkflowBrowser1 Wb = new WorkflowBrowser1(driver, propEnv, propSerialData);
		owm.fnOWMActionsMenu("Change Status", "In Progress");

		// Step-9:-----Route Task----------------------------------------//

		// Step-10:-----Task Properties-----------------------------------//

		// Step-11:----Task History--------------------------------------//

		// Step-12:----Reset Checklist-----------------------------------//
		Thread.sleep(1500);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@id='grdTasks_cell_0_2']")));
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Tk.fnFWFClickActions();
		owm.fnOWMActionsMenu("Reset Checklist", "");
		String text = driver.switchTo().alert().getText();
		if (text.contains("Are you sure you want to proceed?")) {
			driver.switchTo().alert().accept();
		}
		Thread.sleep(1000);

		// Step-13:----Add Documents-------------------------------------//
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Tk.fnFWFClickActions();
		owm.fnOWMActionsMenu("Add Document", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Add document");
		Thread.sleep(1000);
		Tk.fnFWFAddDocument();

		// Step-14:----View Documents------------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		// driver.switchTo().frame("");
		action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click()
				.build().perform();
		Tk.fnFWFClickActions();
		owm.fnOWMActionsMenu("View Document(s)", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Task Properties");
		Tk.fnFWFViewDocuments();

		// Step-15:----Export--------------------------------------------//

		// Step-16:----------------Customize View-----------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));

		Tk.fnFWFClickActions();
		owm.fnOWMActionsMenu("Customize View", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		String[] array = new String[] { "Task", "Status", "Link Name", "Date Completed", "Checklist", "Comments",
				"Due Date" };
		Thread.sleep(1000);
		owm.fnOWMCustomizeView(array);

		// Step-17:----------------Save Preferences-----------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		Tk.fnFWFClickActions();
		owm.fnOWMActionsMenu("Save Preferences", "");
		owm.fnOWMSavePreferences("Save Preferences");

		// Step-18:----------------Save Preferences for
		// All-----------------------------------//
		// lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		// wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		// Ev.fnFWFClickActions();
		// Wb.fnOWMActionsMenu(driver, "Save Preferences for All", "");
		// Wb.fnOWMSavePreferences("Save Preferences for All");

	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
