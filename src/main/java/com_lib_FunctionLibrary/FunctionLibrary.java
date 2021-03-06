package com_lib_FunctionLibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_obj_ObjectRepository.FolderWorkFlows.Documents;
import com_obj_ObjectRepository.FolderWorkFlows.Events;
import com_obj_ObjectRepository.FolderWorkFlows.NavigationTabs;
import com_obj_ObjectRepository.FolderWorkFlows.Tasks;
import com_obj_ObjectRepository.LS1.OneSourceDashboard;
import com_obj_ObjectRepository.LS1.OneSourceLogin;
import com_obj_ObjectRepository.OWM.Navigations;
import com_obj_ObjectRepository.OWM.WorkFlowBrowser;

public class FunctionLibrary extends ExtentManager {

	public static void fnLogin(WebDriver driver, Properties Env) throws InterruptedException {
		childTest = test.createNode("Description: Entering UniversalID and Password." + "<br>"
				+ "<< Screen Name : OneSource Login Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE") || driver.getTitle().equalsIgnoreCase("THOMSON REUTERS")) {
			OneSourceLogin Lp = new OneSourceLogin(driver);
			Lp.reloadPage();
			Lp.enterUsername(Env.getProperty("UserName"));
			Lp.enterPassword(Env.getProperty("Password"));
			Lp.clickonSignIn();
		}
	}

	public static void fnLaunchApplication(WebDriver driver, String strAppName) throws InterruptedException {
		childTest = test.createNode("Description: Launching " + strAppName + " from Applications." + "<br>"
				+ "<< Screen Name: OneSource Dashboard >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			driver.switchTo().frame("header");
			OneSourceDashboard Lp = new OneSourceDashboard(driver);
			Lp.launchApplications();
			Thread.sleep(300);
			driver.switchTo().parentFrame();
			driver.switchTo().frame("menuPopup");
			Lp.appMenuSelection(strAppName);
			System.out.println(strAppName + "is selected from Applications dropdown");
		}
	}

	public static void fnNavigateTab(WebDriver driver, String tab) throws InterruptedException {
		childTest = test
				.createNode("Description: Navigating to: " + tab + "." + "<br>" + "<< Screen Name: OWM >></br>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		Thread.sleep(500);
		driver.switchTo().window(childid);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")) {
			driver.switchTo().frame("bottom");// Switch to respective window
			driver.switchTo().frame("content");
			driver.switchTo().frame("bottomFrame");
			WebElement cview = driver.findElement(By.id("navCurrentView"));
			Navigations Nt = new Navigations(driver);
			if (cview.getText().equalsIgnoreCase(tab)) {
				System.out.println("Navigated to: " + tab);
			} else {
				switch (tab) {
				case "WorkFlow Browser":
					Nt.tabWorkFlowBrowser();
					break;
				case "Documents":
					Nt.tabDocuments();
				case "My Work":
					Nt.tabMyWork();
					break;
				case "Control Log":
					Nt.tabControlLog();
					break;
				case "Reports":
					Nt.tabReports();
					break;
				case "Calendar":
					Nt.tabCalendar();
					break;
				case "Calendar Setup":
					Nt.tabCalendarSetup();
					break;
				case "Entity Browser":
					Nt.tabEntityBrowser();
					break;
				case "Setup":
					Nt.tabSetup();
					break;
				case "DataFlow":
					Nt.tabDataFlow();
					break;
				}
				childTest.log(Status.PASS, "Navigated to " + tab);
			}
		}
	}

	public static void fnOWMActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")
				|| driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
			WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver.findElements(By.className("MenuItem"));
						for (int j = 0; j < submenuItems.size(); j++) {
							if (subItem.equals(submenuItems.get(j).getText())) {
								String submenuItem = submenuItems.get(j).getAttribute("id");
								driver.findElement(By.id(submenuItem)).click();
								childTest.log(Status.PASS, subItem + " is selected from  " + item);
								break;
							}
						}
					}
					childTest.log(Status.PASS, item + " is enabled and is selected from actions menu.");
					break;
				}
			}
		}
	}

	public static void fnNewFolderCreation(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Folder." + "<br>" + "<< Screen Name: New Folder Webpage >></br>");
		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid = it1.next();
		String childid = it1.next();
		String childid1 = it1.next();
		Thread.sleep(300);
		driver.switchTo().window(childid1);
		Thread.sleep(1000);
		WorkFlowBrowser Nf = new WorkFlowBrowser(driver);
		if (driver.getTitle().equals("New Folder")) {
			Nf.newfolderYear(prop.getProperty("Year"));
			Nf.newfolderPeriod(prop.getProperty("Period"));
			Nf.newfolderTaxtype(prop.getProperty("TaxType"));
			Nf.newfolderWFTemplate(prop.getProperty("WF_Template"));
			Nf.newfolderEntityName(prop.getProperty("Entity_Name"));
			Nf.newfolderEntityID(prop.getProperty("Entity_Id"));
			Nf.newfolderJurisdiction(prop.getProperty("Jurisdiction"));
		} else {
			driver.quit();
		}
		Nf.newfolderSave();
		if (isAlertPresent(driver)) {
			if (driver.switchTo().alert().getText().equalsIgnoreCase("A Folder already exists")) {
				driver.switchTo().alert().accept();
				driver.switchTo().window(childid1).close();
				childTest.log(Status.INFO,
						"A folder already Exists with the given data<br>Creating a new folder by deleting the existing.</br>");
				fnWorkflowBrowserSearch(driver, prop);
				Thread.sleep(4000);
				driver.switchTo().frame("viewIFrame");
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")))
						.click().build().perform();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				fnOWMActionsMenu(driver, "Delete WorkFlow(s)", "");
				driver.switchTo().alert().accept();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				fnOWMActionsMenu(driver, "New Folder", "");
				Thread.sleep(5000);
				new WebDriverWait(driver, 2500).until(ExpectedConditions.numberOfWindowsToBe(3));
				fnNewFolderCreation(driver, prop);
			}
		} else {
			Thread.sleep(4000);
			System.out.println("New Folder has been successfully created");
			driver.switchTo().defaultContent();
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public static void fnWorkflowBrowserSearch(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Searching workflow with required fields" + "<br>" + "<<Screen Name: OWM >></br>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.switchTo().frame("bottom");
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		WorkFlowBrowser Sf = new WorkFlowBrowser(driver);
		Sf.SearchClear();
		Sf.SearchYear(prop.getProperty("Year"));
		Sf.SerachPeriod(prop.getProperty("Period"));
		Sf.SearchTaxtype(prop.getProperty("TaxType"));
		Sf.SearchWFTemplate(prop.getProperty("WF_Template"));
		Sf.SearchEntityName(prop.getProperty("Entity_Name"));
		Sf.SearchEntityID(prop.getProperty("Entity_Id"));
		Sf.SearchJurisdiction(prop.getProperty("Jurisdiction"));
		// Sf.SearchWorkflowAssociation(prop.getProperty("Workflow_Association"));
		Sf.SearchWorkflowType(prop.getProperty("Workflow_Type"));
		// Sf.SearchGroupCodes(prop.getProperty("Group_Codes"));
		Sf.Search();
		Thread.sleep(200);
	}

	public static void fnFWFSwitchingTab(WebDriver driver, String tab) throws InterruptedException{
		if(driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
		Thread.sleep(500);
		NavigationTabs St = new NavigationTabs(driver);
		St.fwf_tabSelection(tab);}
	}

	public static void fnOWMSavePreferences(WebDriver driver, String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: OWM >></br>");
		WorkFlowBrowser owm = new WorkFlowBrowser(driver);
		if (menuitem.equals("Save Preferences for All")) {
			if (driver.getTitle().equals("Save Preferences")) {
				System.out.println(driver.getTitle());
				owm.SavePreforAll_Notify();
				Thread.sleep(1000);
				owm.SavePreforAll_Save();
				Thread.sleep(3000);
				if (driver.switchTo().alert().getText().contains("Screen preferences changed for all users.Notifications were sent.")) {
					driver.switchTo().alert().accept();
					childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				} else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			}
		} else if (menuitem.equals("Save Preferences")) {
			if (driver.switchTo().alert().getText().contains("Your changes have been saved.")) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}

	public static void fnOWMCustomizeView(WebDriver driver, String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: OWM >></br>");
		WorkFlowBrowser owm = new WorkFlowBrowser(driver);
		if (driver.getTitle().equalsIgnoreCase("Grid Columns")) {
			for (int i = 0; i < array.length; i++) {
				if (driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).isSelected()) {
					childTest.log(Status.PASS, array[i] + " is checked.");
				} else {
					driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).click();
					childTest.log(Status.PASS, array[i] + " is checked.");
				}
			}
			owm.Custview_Save();
		} else {
			childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
		}
	}

	public static void fnFWFScheduleNewEvent(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Schedule Event." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		new WebDriverWait(driver, 25000).until(ExpectedConditions.numberOfWindowsToBe(4));
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		String childid1 = it.next();
		String childid2 = it.next();
		Thread.sleep(2500);
		driver.switchTo().window(childid2);
		Events SNE = new Events(driver);
		SNE.fwf_Events_SNE_Clear();
		SNE.fwf_Events_SNE_EventTemplateName(prop.getProperty(""));
		SNE.fwf_Events_SNE_TaxType(prop.getProperty(""));
		SNE.fwf_Events_SNE_Search();
		Thread.sleep(1500);

		ArrayList<WebElement> cells1 = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//DIV[@id='grd_SE_Event_dom']/table/tbody/tr"));
		System.out.println(cells1.size());
		if (cells1.size() >= 2) {
			SNE.fwf_Events_SNE_EventTemplateWebTable();
			// driver.findElement(By.xpath("//*[@id='grd_SE_Event_cell_0_1']")).click();
		} else {
			driver.quit();
		}
		SNE.fwf_Events_SNE_Next2();
		Thread.sleep(1000);
		SNE.fwf_Events_SNE_AssignedTo(prop.getProperty(""));
		SNE.fwf_Events_SNE_AssignedToCkBx();
		SNE.fwf_Events_SNE_Next3();
		Thread.sleep(500);
		List<WebElement> chkBox = driver.findElements(By.xpath("//DIV[@id='grd_SE_Entity_Event_dom']/TABLE/tbody/tr"));
		int no = chkBox.size();
		System.out.println(no);
		if (no > 1) {
			SNE.fwf_Events_SNE_EventWebCheckbox();
			// driver.findElement(By.xpath("//*[@id='chkEntityEvent']")).click();
		}
		SNE.fwf_Events_SNE_Finish();
		Thread.sleep(1500);
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();

	}

	public static void fnFWFESEMarkDone(WebDriver driver) throws InterruptedException {
		childTest = test.createNode("Description: Mark Done" + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		Events ESE = new Events(driver);
		Thread.sleep(2500);
		System.out.println(driver.getTitle());
		ESE.fwf_Events_ESE_Actions();
		Thread.sleep(1500);
		ESE.fwf_Events_ESE_MarkDone();
		ESE.fwf_EditEventtabSelection("Work Status");
		Thread.sleep(500);
		ESE.fwf_Events_Save();
		Thread.sleep(2500);
		if (driver.switchTo().alert().getText()
				.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}

		/*
		 * FunctionLibrary.fnFWFSelectEvent(driver, propSerialData); Thread.sleep(500);
		 * driver.findElement(By.xpath("//TD[@id='btnActionsMenu']")).click();
		 * Thread.sleep(1000); FunctionLibrary.fnOWMActionsMenu(driver,
		 * "Edit Scheduled Event(s)", ""); Thread.sleep(1500); /*new
		 * WebDriverWait(driver,35000).until(ExpectedConditions.numberOfWindowsToBe(4));
		 * Set<String> ids = driver.getWindowHandles(); java.util.Iterator<String> it =
		 * ids.iterator(); String parentid1 = it.next(); String childid3 = it.next();
		 * String childid4 = it.next(); String childid5= it.next() ; Thread.sleep(2500);
		 * driver.switchTo().window(childid5);
		 * ESE.fwf_EditEventtabSelection("Work Status"); Thread.sleep(500);
		 * ESE.fwf_Events_ESE_Status("On Hold"); Thread.sleep(2500);
		 * ESE.fwf_Events_Save(); Thread.sleep(2500);
		 * if(driver.switchTo().alert().getText().
		 * equalsIgnoreCase("The selected Scheduled Event(s) have been updated.") ) {
		 * Thread.sleep(2500); driver.switchTo().alert().accept(); }else {
		 * driver.close(); }
		 */
	}

	public static void fnFWFSelectEvent(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test
				.createNode("Description: Select a Event." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid1 = it.next();
		String childid2 = it.next();
		Thread.sleep(500);
		driver.switchTo().window(childid2);
		Thread.sleep(500);
		driver.switchTo().frame("tabIFrame");
		Thread.sleep(500);

		ArrayList<WebElement> cells = (ArrayList<WebElement>) driver
				.findElements(By.xpath("//DIV[@id='grdEvents_dom']/table/tbody/tr/td"));

		for (WebElement cell : cells) {
			if (cell.getText().equals(prop.getProperty(""))) {
				// Framework.fnWebTable(driver,cell,"Click");
				break;
			}
		}
	}

	public static void fnFWFESERollForward(WebDriver driver) throws InterruptedException {
		childTest = test.createNode("Description: Roll Forward" + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		Events ESE = new Events(driver);
		Thread.sleep(2500);
		System.out.println(driver.getTitle());
		ESE.fwf_Events_ESE_Actions();
		Thread.sleep(1500);
		ESE.fwf_Events_ESE_RollForward();
		Thread.sleep(1500);
		new WebDriverWait(driver, 25000).until(ExpectedConditions.numberOfWindowsToBe(5));
		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid1 = it1.next();
		String childid3 = it1.next();
		String childid4 = it1.next();
		String childid5 = it1.next();
		String childid6 = it1.next();

		Thread.sleep(2500);
		driver.switchTo().window(childid6);
		// Framework.fnWebCheckBox1(driver, element, label);
		System.out.println(driver.getTitle());
		ESE.fwf_Events_ESE_RollForwardCkBx();
		// driver.findElement(By.xpath("//INPUT[@id='chkRollAll']")).click();
		Thread.sleep(1500);
		ESE.fwf_Events_ESE_RollForward_Ok();
		// driver.findElement(By.xpath("//INPUT[@id='RolloverSchedEvents']")).click();
		// driver.findElement(By.xpath("//INPUT[@id='btnCancel']")).click();
		Thread.sleep(2500);
		System.out.println(driver.switchTo().alert().getText());
		if (driver.switchTo().alert().getText().equalsIgnoreCase(
				"Roll Forward has been processed for 1  event(s). An email will be sent to you when the Roll Forward process is completed.")) {
			driver.switchTo().alert().accept();
		}
		Thread.sleep(1500);
		ESE.fwf_Events_Save();
		Thread.sleep(1500);
		if (driver.switchTo().alert().getText()
				.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
			Thread.sleep(500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}
	}

	public static void fnFWFESEReCalculate(WebDriver driver) throws InterruptedException {
		childTest = test.createNode("Description: Re-Calculate." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		Events ESE = new Events(driver);
		Thread.sleep(2500);
		ESE.fwf_Events_ESE_Recalculate();
		Thread.sleep(2500);
		if (driver.switchTo().alert().getText().equalsIgnoreCase("1 out of 1 record(s) processed.")) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}
		ESE.fwf_Events_Save();
		if (driver.switchTo().alert().getText()
				.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
			Thread.sleep(2500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}
	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	public static void fnFWFAddDocument(WebDriver driver, Properties data) throws InterruptedException, AWTException {
		childTest = test.createNode("Description: Add Document " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Tasks owm = new Tasks(driver);
		//driver.switchTo().frame("frame1");
		if (driver.getTitle().equalsIgnoreCase("Add document")) {
			owm.fwf_Task_AD_Clear();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			owm.fwf_Task_AD_Save();
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			WebDriverWait w = new WebDriverWait(driver, 15);
			w.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			if (text.contains("Select a physical document to upload.")) {
				Thread.sleep(500);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save before uploading a document alert" + "<br>" + text
						+ " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save before uploading a document alert is missing");
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			String path = "C:\\RapidScripts\\Documents\\Doc";
			setClipboardData(path);
			driver.findElement(By.xpath("//TD[@id='tdSelectDocument']/TABLE[1]/tbody/tr[2]/td[2]")).click();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			owm.fwf_Task_AD_Save();
			Thread.sleep(2000);
			WebDriverWait w1 = new WebDriverWait(driver, 20);
			w1.until(ExpectedConditions.alertIsPresent());
			String text1 = driver.switchTo().alert().getText();
			if (text1.contains("is required.")) {
				Thread.sleep(500);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Mandatory field alert " + "<br>" + text1 + " exists </br>");
			} else {
				childTest.fail("Verification: Mandatory field alert is  missing");
			}
			Thread.sleep(500);
			owm.fwf_Task_AD_Description(data.getProperty("doc_Description"));
			owm.fwf_Task_AD_FileSection(data.getProperty("doc_FileSection"));
			owm.fwf_Task_AD_DocumentType(data.getProperty("doc_DocumentType"));
			owm.fwf_Task_AD_DocumentDate(data.getProperty("doc_DocumentDate"));
			owm.fwf_Task_AD_AssignedTo(data.getProperty("doc_AssignedTo"));
			owm.fwf_Task_AD_DocumentStatus(data.getProperty("doc_DocumentStatus"));
			owm.fwf_Task_AD_DueDate(data.getProperty("doc_DueDate"));
			owm.fwf_Task_AD_Notify();
			owm.fwf_Task_AD_NotifyUsersList();
			owm.fwf_Task_AD_Save();
		}
	}

	public static void fnWindowHandler(WebDriver driver, String Wname) {

	}

	public static void fwf_fnEmailDocument(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test
				.createNode("Description: Email Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Documents owm = new Documents(driver);
		if (driver.getTitle().equalsIgnoreCase("Email Document(s)")) {
			owm.Emaildoc_Save();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			if (text.contains("To address cannot be blank.")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass(
						"Verification: Click on Save before Emailing document alert" + "<br>" + text + " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save before Emailing document alert is missing");
			}
			owm.Emaildoc_To(data.getProperty("doc_EmailTO"));
			owm.Emaildoc_CC(data.getProperty("doc_EmailCC"));
			owm.Emaildoc_Subject(data.getProperty("doc_EmailSubject"));
			owm.Emaildoc_Message("Hi All," + "+<br>+"
					+ " This email is intended to verify Email Document's as a link/Attachment functionality</br>");
			owm.EmailDoc_AttachmenType_asLink();
			owm.Emaildoc_Save();
			Thread.sleep(900);
			w.until(ExpectedConditions.alertIsPresent());
			String text1 = driver.switchTo().alert().getText();
			if (text1.contains("Your email has been sent.")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass(
						"Verification: Click on Save after Emailing document: Alert" + "<br>" + text + " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save after Emailing document: Alert is missing");
			}
		}
	}

	public static void fwf_fnCopyDocuments(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test
				.createNode("Description: Copy Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Documents owm = new Documents(driver);
		if (driver.getTitle().equalsIgnoreCase("Copy Document(s)")) {
			//owm.Documents_Entityname("");
			owm.Documents_save();
			Thread.sleep(800);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			if (text.contains("is required")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save before Copy documents mandatory field alert" + "<br>" + text
						+ " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save before copy documents mandatory field alert is missing");
			}
			Thread.sleep(800);
			owm.Documents_Reset();
			Thread.sleep(800);
			owm.Documents_save();
			w.until(ExpectedConditions.alertIsPresent());
			String text1 = driver.switchTo().alert().getText();
			if (text1.contains("Click 'OK' to continue")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save:Copy documents confirmation alert 1" + "<br>" + text
						+ " exists </br>");
				Thread.sleep(1500);
				w.until(ExpectedConditions.alertIsPresent());
				String text2 = driver.switchTo().alert().getText();
				if (text2.contains("Documents successfully copied and re-indexed: 1")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save:Copy documents confirmation alert 2" + "<br>" + text
							+ " exists </br>");
				} else {
					childTest.fail("Verification: Click on Save: Copy documents confirmation alert 2 is missing");
				}
			} else {
				childTest.fail("Verification: Click on Save: Copy documents confirmation alert 1 is missing");
			}
		}
	}

	public static void fwf_fnMoveDocument(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test
				.createNode("Description: Move Document " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Documents owm = new Documents(driver);
		if (driver.getTitle().equalsIgnoreCase("Move Document")) {
			owm.MoveDoc_drawers(data.getProperty("doc_MoveD_Drawer"));
			WebDriverWait w = new WebDriverWait(driver, 40);
			WebElement exist = w
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idx_0000000004']")));
			if (exist.isDisplayed()) {
				owm.MoveDoc_save();
				Thread.sleep(800);
				String text = driver.switchTo().alert().getText();
				if (text.contains("is required")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save: before Move document mandatory field alert" + "<br>"
							+ text + " exists </br>");
				} else {
					childTest
							.fail("Verification: Click on Save: before Move document mandatory field alert is missing");
				}
				owm.MoveDoc_EntityName(data.getProperty("doc_MoveD_EntityName"));
				owm.MoveDoc_EntityID(data.getProperty("doc_MoveD_EntityNum"));
				owm.MoveDoc_TaxType(data.getProperty("TaxType"));
				owm.MoveDoc_FileSection(data.getProperty("doc_FileSection"));
				owm.MoveDoc_Year(data.getProperty("Year"));
				owm.MoveDoc_Description(data.getProperty("doc_Description"));
				owm.MoveDoc_Period(data.getProperty("Period"));
				owm.MoveDoc_save();
				w.until(ExpectedConditions.alertIsPresent());
				String text1 = driver.switchTo().alert().getText();
				if (text1.contains("Click 'OK' to continue")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save:Move document confirmation alert 1" + "<br>" + text
							+ " exists </br>");
					Thread.sleep(2000);
					w.until(ExpectedConditions.alertIsPresent());
					String text2 = driver.switchTo().alert().getText();
					if (text2.contains("Document successfully moved and re-indexed")) {
						Thread.sleep(200);
						driver.switchTo().alert().accept();
						childTest.pass("Verification: Click on Save: Move document confirmation alert 2" + "<br>" + text
								+ " exists </br>");
					} else {
						childTest.fail("Verification: Click on Save: Move document confirmation alert 2 is missing");
					}
				} else {
					childTest.fail("Verification: Click on Save: Move document confirmation alert 1 is missing");
				}
			}
		}
	}

	public static void fwf_fnDocumentProperties(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test
				.createNode("Description: Document Properties " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Documents owm = new Documents(driver);
		if (driver.getTitle().equalsIgnoreCase("Document Properties")) {

			HashMap<By, String> txtCompare = new HashMap<By, String>();
			txtCompare.put(owm.Documents_Description, data.getProperty("doc_Description")); // Description
			txtCompare.put(owm.Documents_FileSection, data.getProperty("doc_FileSection")); // FileSection
			txtCompare.put(owm.Documents_DocumentType, data.getProperty("doc_DocumentType")); // Document Type
			txtCompare.put(owm.Documents_DocumentDate, data.getProperty("doc_DocumentDate")); // Document Date
			txtCompare.put(owm.DocProp_AssignedTo, data.getProperty("doc_AssignedTo")); // Assigned To
			txtCompare.put(owm.DocProp_DocumentStatus, data.getProperty("doc_DocumentStatus")); // Document Status
			txtCompare.put(owm.DocProp_DueDate, data.getProperty("doc_DueDate")); // Due Date

			Set<By> map = txtCompare.keySet();
			for (Iterator<By> i = map.iterator(); i.hasNext();) {
				By key = (By) i.next();
				String value = (String) txtCompare.get(key);
				WebElement wait = new WebDriverWait(driver, 30)
						.until(ExpectedConditions.visibilityOfElementLocated(key));
				if (wait.isDisplayed()) {
					if (driver.findElement(key).getAttribute("value").equals(value)) {
						childTest.log(Status.PASS, value + " is matched.");
					} else {
						Select sel = new Select(driver.findElement(key));
						WebElement currValue = sel.getFirstSelectedOption();
						String option = currValue.getText();
						if (option.equals(value)) {
							childTest.log(Status.PASS, value + " is matched.");
						} else {
							childTest.log(Status.FAIL, value + " is not matched");
						}
					}
				} else {
					childTest.log(Status.FAIL, "Element is not visible");
				}
			}
			owm.Documents_save();
			Thread.sleep(3000);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text2 = driver.switchTo().alert().getText();
			if (text2.contains("Successfully re-indexed Documents: 1")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save: Move document confirmation alert 1" + "<br>" + text2
						+ " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save: Move document confirmation alert 1 is missing");
			}
		}

	}

	public static void fwf_fnSavedSearch(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test.createNode(
				"Description: Saved Seach/Document Search " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Thread.sleep(3000);
		Documents owm = new Documents(driver);
		if (driver.getTitle().equalsIgnoreCase("Documents Search")) {
			owm.SavedSearch_Clear();
			owm.SavedSearch_year(data.getProperty("Year"));
			owm.SavedSearch_period(data.getProperty("Period"));
			owm.SavedSearch_Taxtype(data.getProperty("TaxType"));
			owm.SavedSearch_WFtemplate(data.getProperty("WF_Template"));
			// owm.SavedSearch_WfAssociation("");
			owm.Documents_Entityname(data.getProperty("Entity_Name"));
			owm.Documents_EntityId(data.getProperty("Entity_Id"));
			owm.Documents_jurisdiction(data.getProperty("Jurisdiction"));
			owm.Documents_Description(data.getProperty("doc_Description"));
			owm.SavedSearch_FileSection(data.getProperty("doc_FileSection"));
			owm.SavedSearch_DocumentType(data.getProperty("doc_DocumentType"));
			owm.Documents_Assignedto(data.getProperty("doc_AssignedTo"));
			owm.SavedSearch_Close();
		}
	}

	public static void fnSwitchtoWindow(WebDriver driver, int winNum, String winName) throws InterruptedException {
		new WebDriverWait(driver, 50).until(ExpectedConditions.numberOfWindowsToBe(winNum));
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		/*while (ite.hasNext() && i <= s.size()) {
			String popHandle = ite.next().toString();
			driver.switchTo().window(popHandle);
			if (i == winNum)
				break;
			i++;
		}*/
		for(int j=0;j==winNum;j++) {
			String[] child = new String[winNum];
			 child[j]= ite.next();
			 if(j==winNum) {
				 driver.switchTo().window(child[j]);
				 break;
			 }
			 
		}
		if (winName != null || driver.getTitle().equals(winName)) {
			childTest.info("Switched to " + winName + " window.");
		} else {
			childTest.fail("Failed to Switch to " + winName + " window.");
		}
	}

	public static void fnOWMNewWorkFlow(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Create a New WorkFlow " + "<br>" + "<< Screen Name: WorkFlow Browser >></br>");
		FunctionLibrary.fnSwitchtoWindow(driver, 3, "Folder WorkFlows");
		WorkFlowBrowser NW = new WorkFlowBrowser(driver);
		NW.WFP_NWF_WfTemplate("");
		NW.WFP_NWF_Entityname("");
		NW.WFP_NWF_EntityId("");
		NW.WFP_NWF_jurisdiction("");
		Thread.sleep(200);
		NW.WFP_NWF_save();
	}

	public static void fnOWMDeleteWorkflow(WebDriver driver, String actualText, String expectedText) {
		childTest = test
				.createNode("Description: Delete WorkFlow " + "<br>" + "<< Screen Name: Workflow Browser >></br>");
		if (actualText.equals(expectedText)) {
			driver.switchTo().alert().accept();
		} else {
			driver.switchTo().alert().dismiss();
		}
	}

	public static void fnFWFESEExtendEvent(WebDriver driver) throws InterruptedException {
		childTest = test.createNode("Description:Extend Event in Edit Schedule Page " + "<br>"
				+ "<< Screen Name: Folder Workflows >></br>");
		FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		Events ESE = new Events(driver);
		Thread.sleep(2500);
		ESE.fwf_Events_ESE_Actions();
		Thread.sleep(1500);
		ESE.fwf_Events_ESE_ExtendEvent();
		Thread.sleep(2500);
		if (driver.switchTo().alert().getText().equalsIgnoreCase("The Scheduled Event(s) has been extended.")) {
			Thread.sleep(500);
			driver.switchTo().alert().accept();
		} else {
			driver.close();
		}
	}

	public static void fnLogOff(WebDriver driver) throws InterruptedException {
		childTest = test.createNode("Description:LogOut of the Tool " + "<br>" + "<< Screen Name:  >></br>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("bottom");// Switch to respective window
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		Navigations Lo = new Navigations(driver);
		Lo.OWMLogout();
		Thread.sleep(500);
		driver.switchTo().window(parentid);
		driver.switchTo().frame("header");
		Lo.LS1Logout();
		driver.close();
	}

	public static void fnFWFViewDocuments(WebDriver driver, Properties data) throws InterruptedException {
		childTest = test
				.createNode("Description: View Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Tasks tsk = new Tasks(driver);
		if (driver.getTitle().equalsIgnoreCase("Task Properties")) {
			WebElement Table = driver.findElement(By.xpath("//DIV[@id=\"grdTaskDocumentHitList_dom\"]/TABLE[1]"));
			List<WebElement> rows = Table.findElements(By.tagName("tr"));
			for (int i = 1; i <= rows.size() - 1; i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				for (int j = 1; j < columns.size() - 1; j++) {
					String text = columns.get(j).getText();
					for (Object key : data.keySet()) {
						if (data.getProperty(key.toString()).equals(text)) {
							childTest.log(Status.INFO, text + " is matched in the Documents Table");
							break;
						}
					}
					break;
				}
				break;
			}
			tsk.fwf_Task_Save();
		}
		
	}
	
	public static void fnLockingworkflow(WebDriver driver) throws InterruptedException {
		childTest = test.createNode(
				"Description: Lock workflow " + "<br>" + "<< Screen Name: Folder Workflow >></br>");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//td[@id='mnuFolderWorkflows_15']"))).click().build().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		WebElement locked = driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_0']/div/img"));
		if(locked.isDisplayed()) {
			childTest.pass("The selected workflow is locked successfully");
		}
		else {
			childTest.fail("The selected workflow locking is failed");
		}
	}

	public static void fnUnLockingworkflow(WebDriver driver) throws InterruptedException {
		childTest = test.createNode(
				"Description: UnLock workflow " + "<br>" + "<< Screen Name: Folder Workflow >></br>");
		WebElement locked = driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_0']/div/img"));
		if(locked.isDisplayed()) {
			Actions action_ul = new Actions(driver);
			action_ul.moveToElement(driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_3']"))).contextClick().build().perform();
			Thread.sleep(2000);
		}
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//td[@id='mnuFolderWorkflows_16']"))).click().build().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	}

	public static void fnsavepreferences(WebDriver driver) throws InterruptedException {
		childTest = test.createNode(
				"Description: saving changes of the workflow " + "<br>" + "<< Screen Name: Folder Workflow >></br>");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//td[@id='mnuFolderWorkflows_21']"))).click().build().perform();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		childTest.info("All the changes have been saved");
		
	}

	public static void fnNavtoaddnewEntity(WebDriver driver) {
		childTest = test.createNode(
				"Description:Navigate to add new entity funvtion on entity manager " + "<br>" + "<< Screen Name: ONESOURCE >></br>");
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@id='dvAction']"))).doubleClick().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action.moveToElement(driver.findElement(By.xpath("//td[@id='mnuEntityBrowser_0']"))).click().build().perform();
		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		driver.manage().window().maximize();
		
	}

	public static void fnAddnewEntity(WebDriver driver) {
		childTest = test.createNode(
				"Description:Add new entity to entity manager " + "<br>" + "<< Screen Name: Entity Information >></br>");
		driver.switchTo().frame("addeditFrame1");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("xyz41");
		driver.findElement(By.xpath("//input[@id='id']")).sendKeys("xyz41");
		Select entitytype = new Select(driver.findElement(By.id("entitytype")));
		entitytype.selectByIndex(4);
		driver.findElement(By.xpath("//input[@id='country_Input']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='state_Input']")).sendKeys("Assam");
		driver.findElement(By.xpath("//input[@id='countryincorporated_Input']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='stateincorporated_Input']")).sendKeys("Assam");
		driver.findElement(By.xpath("//input[@id='entitygroupid_Input']")).sendKeys("Hello");
		
		
		
	}

	

}
