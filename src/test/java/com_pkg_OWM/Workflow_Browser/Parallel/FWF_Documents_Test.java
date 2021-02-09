package com_pkg_OWM.Workflow_Browser.Parallel;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_obj_ObjectRepository.FolderWorkflows1.Events;
import com_obj_ObjectRepository.FolderWorkflows1.Tasks;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.OWM.WorkflowBrowser1;
import com_obj_ObjectRepository.FolderWorkflows1.Documents;

public class FWF_Documents_Test extends BrowserInvoke {
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
	public void Documents() throws InterruptedException, AWTException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
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
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),
				"DoubleClick");

		// Step-6:------Navigate to Events Tab----------------------------//
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		Events Ev = new Events(driver,propSerialData);
		Ev.fnFWFSwitchingTab("Documents");

		// Step-7:--------------Delete Existing
		// Documents----------------------------------//
		driver.switchTo().frame("tabIFrame");
		Actions action = new Actions(driver);
		WorkflowBrowser1 Wb = new WorkflowBrowser1(driver, propEnv, propSerialData);
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() > 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 1; i <= rows.size(); i++) {
				action.moveToElement(driver
						.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[" + i + "]")))
						.click().build().perform();
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			Ev.fnFWFClickActions();
			Wb.fnOWMActionsMenu(driver, "Other Actions", "Delete Document(s)");
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();
		}

		// Step-8:--------------Actions----------------------------------//
		Ev.fnFWFClickActions();

		// Step-9:--------------Add New Document----------------------------------//
		Wb.fnOWMActionsMenu(driver, "Add Document", "New Document");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		driver.switchTo().frame("frame1");
		Tasks Tk = new Tasks(driver, propSerialData);
		Tk.fnFWFAddDocument();

		// Step-10:--------------Email Document----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Email Document(s)", "");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Documents Doc = new Documents(driver, propSerialData);
		Doc.fwf_fnEmailDocument();

		// Step-11:--------------Change Status----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Change Status", "In Progress");
		String text = driver.switchTo().alert().getText();
		if (text.contains("Successfully updated 1 document(s).")) {
			driver.switchTo().alert().accept();
		}

		// Step-12:--------------Other Actions----------------------------------//
		// Step-13:--------------Copy Document----------------------------------//
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Other Actions", "Copy Document(s)");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Doc.fwf_fnCopyDocuments();

		// Step-14:--------------Move Document----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Other Actions", "Move Document");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Doc.fwf_fnMoveDocument();

		// Step-15:--------------Export Document----------------------------------//
		// Step-16:--------------Delete Document----------------------------------//

		// Step-17:---------------Review Documents--------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Review Document(s)", "Archive");
		String text1 = driver.switchTo().alert().getText();
		if (text1.contains("The selected document(s) have been successfully Archived.")) {
			driver.switchTo().alert().accept();
		}

		// Step-18:---------------UnArchive--------------------------------//
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Review Document(s)", "Unarchive");
		String text2 = driver.switchTo().alert().getText();
		if (text2.contains("Successfully removed the Archived Status for the selected document(s).")) {
			driver.switchTo().alert().accept();
		}

		// Step-19:----Associate Documents to workflow--------------------//
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Associate Document(s) to WorkFlow", "");
		String text3 = driver.switchTo().alert().getText();
		if (text3.contains("Selected document(s) have been associated to the")) {
			Thread.sleep(500);
			driver.switchTo().alert().accept();
		}

		// Step-20:----Document Properties--------------------------------//
		// Step-21:---Document History-----------------------------------//

		// Step-22:----------------Customize View-----------------------------------//
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Customize View", "");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		String[] array = new String[] { "Event", "Status", "Date Completed", "Assigned To", "Extended", "Authority",
				"Due Date" };
		Wb.fnOWMCustomizeView(array);

		// Step-23:----------------Save Preferences-----------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Save Preferences", "");
		Wb.fnOWMSavePreferences("Save Preferences");

		// Step-24:----------------Save Preferences for All-----------------------------------//
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver, "Save Preferences for All", "");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Wb.fnOWMSavePreferences("Save Preferences for All");
		
		//Step-25:---Saved Search---------------------------------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver,"Saved Search","");
		lp.fnSwitchtoWindow(4, "Folder WorkFlows");
		Doc.fwf_fnSavedSearch();
		
		//Step-26:-----------Delete Document uploaded-----------------//
		lp.fnSwitchtoWindow(3, "Folder WorkFlows");
		driver.switchTo().frame("tabIFrame");
		action.moveToElement(
				driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click()
				.build().perform();
		Ev.fnFWFClickActions();
		Wb.fnOWMActionsMenu(driver,"Other Actions","Delete Document(s)");
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
