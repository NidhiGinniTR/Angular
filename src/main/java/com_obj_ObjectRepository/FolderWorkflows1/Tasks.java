package com_obj_ObjectRepository.FolderWorkflows1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class Tasks extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties template;

	/***************************************************************************************
	 * These element locators belongs to Add Workflow Task
	 ***************************************************************************************/
	By fwf_Task_TaskProperties = By.xpath("//*[@id='TabStripStepProperties_0']"); //Locator for Task Properties Tab in Task Properties Page 
	By fwf_Task_PageLinks = By.xpath("//*[@id='TabStripStepProperties_1']"); //Locator for Page Links Tab in Task Properties Page 
	By fwf_Task_CheckLists = By.xpath("//*[@id='TabStripStepProperties_2']"); //Locator for Checklist Tab in Task Properties Page 
	By fwf_Task_Documents = By.xpath("//*[@id='TabStripStepProperties_3']"); //Locator for Documents Tab in Task Properties Page 
	By fwf_Task_TaskName = By.xpath("//INPUT[@id='txtTask']"); //Locator for Task Name in Task Properties Page 
	By fwf_Task_AssignedToGroup = By.xpath("//SELECT[@id='ddlAssignedToGroup']"); //Locator for Assigned To Group in Task Properties Page 
	By fwf_Task_AssignedToPerson = By.xpath("//SELECT[@id='ddlAssignToUID']"); //Locator for Assigned To Person in Task Properties Page 
	By fwf_Task_LeadDays = By.xpath("//INPUT[@id='txtLeadDays']"); //Locator for Lead days in Task Properties Page 
	By fwf_Task_Status = By.xpath("//SELECT[@id='DropDownListTaskPropertiesStatus']"); //Locator for Status in Task Properties Page 
	By fwf_Task_DueDate = By.xpath("//INPUT[@id='pkDateDue']"); //Locator for Due Date in Task Properties Page 
	By fwf_Task_Priority = By.xpath("//SELECT[@id='DropDownListTaskPropertiesPriority']"); //Locator for Priority in Task Properties Page 
	By fwf_Task_NotifyByEmail = By.xpath("//INPUT[@id='chkNotify']"); //Locator for Notify By Email Checkbox in Task Properties Page 
	By fwf_Task_NotifyByCC = By.xpath("//INPUT[@id='chkNotifyCC']"); //Locator for Notify By CC in Task Properties Page 
	By fwf_Task_NotifyByCCEmailList = By.xpath("//INPUT[@id='btnEmailList']"); //Locator for Notify By CC Email List in Task Properties Page 
	By fwf_Task_Comment = By.xpath("//*[@id='txtNotes']"); //Locator for Comment in Task Properties Page 
	By fwf_Task_AddDocument = By.xpath("//*[@id='btnAddDoc']"); //Locator for Add document in Task Properties Page 
	By fwf_Task_Save = By.xpath("//*[@id='btnOK']"); //Locator for Save in Task Properties Page 
	By fwf_Task_Cancel = By.xpath("//IMG[@id='btnCancel']"); //Locator for Cancel in Task Properties Page 

	/***************************************************************************************
	 * These element locators belongs to Add Document
	 ***************************************************************************************/

	By fwf_Task_AD_ElectronicDocument = By.xpath("//INPUT[@id='doc']"); //Locator for Electronic Document in Add Document Page 
	By fwf_Task_AD_LinkToFile = By.xpath("//INPUT[@id='link']"); //Locator for Link To File in Add Document Page
	By fwf_Task_AD_Description = By.xpath("//INPUT[@id='idx_000000000H']"); //Locator for Description in Add Document Page
	By fwf_Task_AD_FileSection = By.xpath("//SELECT[@id='idx_000000000I']"); //Locator for File Section in Add Document Page
	By fwf_Task_AD_DocumentType = By.xpath("//SELECT[@id='idx_000000000J']"); //Locator for Document Type in Add Document Page
	By fwf_Task_AD_DocumentDate = By.xpath("//INPUT[@id='idx_000000000K']"); //Locator for Document Date in Add Document Page
	By fwf_Task_AD_AssignedTo = By.xpath("//SELECT[@id='assigned_to']"); //Locator for Assigned To in Add Document Page
	By fwf_Task_AD_DocumentStatus = By.xpath("//SELECT[@id='document_status']"); //Locator for Document Status in Add Document Page
	By fwf_Task_AD_DueDate = By.xpath("//INPUT[@id='due_date']"); //Locator for Due Date in Add Document Page
	By fwf_Task_AD_Notify = By.xpath("//INPUT[@id='chkNotify']"); //Locator for Notify in Add Document Page
	By fwf_Task_AD_NotifyUsersList = By.xpath("//INPUT[@id='btnUserList']"); //Locator for Notify Users List in Add Document Page
	By fwf_Task_AD_Clear = By.xpath("//IMG[@id='btnClear']"); //Locator for Clear in Add Document Page
	By fwf_Task_AD_Save = By.xpath("//IMG[@id='btnOK']"); //Locator for Save in Add Document Page
	By fwf_Task_AD_Cancel = By.xpath("//IMG[@id='Img1']"); //Locator for Cancel in Add Document Page
	By fwf_Task_AD_UserList = By.xpath("//table[@id='UsersTable']"); //Locator for User List in Add Document Page
	By fwf_Task_AD_UserList_Save = By.xpath("//*[@id='btnSaveValues']"); //Locator for Save in User List Page
	By fwf_Task_AD_UserList_Cancel = By.xpath("//*[@id='btnCancel']"); //Locator for Cancel in User List Page

	/***************************************************************************************
	 * These element locators belongs to Route Task
	 ***************************************************************************************/

	By fwf_Task_RT_CurrentTask = By.xpath("//INPUT[@id='txtTaskName']"); //Locator for Current Task in Route Workflow Page
	By fwf_Task_RT_CurrentTaskStatus = By.xpath("//SELECT[@id=\"DropDownListTaskStatusCurrent\"]"); //Locator for Current Task Status in Route Workflow Page
	By fwf_Task_RT_NewTask = By.xpath("//SELECT[@id='DropDownListTask']"); //Locator for New Task in Route Workflow Page
	By fwf_Task_RT_NewAssignedToGroup = By.xpath("//SELECT[@id='ddlAssignedToGroup']"); //Locator for Assigned To Group in Route Workflow Page
	By fwf_Task_RT_NewAssignedToPerson = By.xpath("//SELECT[@id='ddlAssignedToPerson']"); //Locator for Assigned To Person in Route Workflow Page
	By fwf_Task_RT_NewTaskStatus = By.xpath("//SELECT[@id='DropDownListTaskStatus']"); //Locator for New Tas Status in Route Workflow Page
	By fwf_Task_RT_NewDueDate = By.xpath("//INPUT[@id='pkDueDate']"); //Locator for New Due Date in Route Workflow Page
	By fwf_Task_RT_NewPriority = By.xpath("//SELECT[@id='DropDownListTaskPriority']"); //Locator for New Priority in Route Workflow Page
	By fwf_Task_RT_CurrentTaskList = By.xpath("//INPUT[@id='btnTaskList']"); //Locator for Current Task List in Route Workflow Page
	By fwf_Task_RT_NotifyByEmail = By.xpath("//INPUT[@id='chkNotify']"); //Locator for Notify By Email in Route Workflow Page
	By fwf_Task_RT_NotifyCC = By.xpath("//INPUT[@id='chkNotifyCC']"); //Locator for Notify CC in Route Workflow Page
	By fwf_Task_RT_NotifyEmailList = By.xpath("//INPUT[@id='btnEmailList']"); //Locator for Notify Email List in Route Workflow Page
	By fwf_Task_RT_Comment = By.xpath("//TEXTAREA[@id='txtNotes']"); //Locator for Comment in Route Workflow Page
	By fwf_Task_RT_Save = By.xpath("//IMG[@id='btnRoute']"); //Locator for Save in Route Workflow Page
	By fwf_Task_RT_Cancel = By.xpath("//IMG[@id='btnCancel']"); //Locator for Cancel in Route Workflow Page
	By fwf_Task_RT_Ok = By.xpath("//IMG[@id='btnOK']"); //Locator for Current Task in Route Workflow Page

	public Tasks(WebDriver driver, Properties data) {
		this.driver = driver;
		this.template = data;
	}

	/*********************************************************************************
	 * This function is used to Copy Data to clipboard
	 **********************************************************************************/

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/*********************************************************************************
	 * This function is used to Add a Document
	 **********************************************************************************/

	public void fnFWFAddDocument() throws InterruptedException, AWTException {
		childTest = test.createNode("Description: Add Document " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Add document")) {
			fm.fnWebButton(driver, fwf_Task_AD_Clear, "Clear");
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
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
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
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
			fm.fnWebEdit(driver, fwf_Task_AD_Description, template.getProperty("doc_Description"), "Description");
			fm.fnWebList(driver, fwf_Task_AD_FileSection, template.getProperty("doc_FileSection"), "File Section");
			fm.fnWebList(driver, fwf_Task_AD_DocumentType, template.getProperty("doc_DocumentType"), "Document Type");
			fm.fnWebEdit(driver, fwf_Task_AD_DocumentDate, template.getProperty("doc_DocumentDate"), "Document Date");
			fm.fnWebList(driver, fwf_Task_AD_AssignedTo, template.getProperty("doc_AssignedTo"), "Assigned To");
			fm.fnWebList(driver, fwf_Task_AD_DocumentStatus, template.getProperty("doc_DocumentStatus"),
					"Document Status");
			fm.fnWebEdit(driver, fwf_Task_AD_DueDate, template.getProperty("doc_DueDate"), "Due Date");
			fm.fnWebCheckBox(driver, fwf_Task_AD_Notify, "Notify");
			fm.fnWebButton(driver, fwf_Task_AD_NotifyUsersList, "Users List");
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
		}
	}

	/*********************************************************************************
	 * This function is used to View the Documents
	 **********************************************************************************/

	public void fnFWFViewDocuments() throws InterruptedException {
		childTest = test
				.createNode("Description: View Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Task Properties")) {
			WebElement Table = driver.findElement(By.xpath("//DIV[@id=\"grdTaskDocumentHitList_dom\"]/TABLE[1]"));
			List<WebElement> rows = Table.findElements(By.tagName("tr"));
			for (int i = 1; i <= rows.size() - 1; i++) {
				List<WebElement> columns = rows.get(i).findElements(By.tagName("td"));
				for (int j = 1; j < columns.size() - 1; j++) {
					String text = columns.get(j).getText();
					for (Object key : template.keySet()) {
						if (template.getProperty(key.toString()).equals(text)) {
							childTest.log(Status.INFO, text + " is matched in the Documents Table");
							break;
						}
					}
					break;
				}
				break;
			}
			Thread.sleep(1000);
			fm.fnWebButton(driver, fwf_Task_Save, "Save");
		}

	}

	/*********************************************************************************
	 * This function is used to Route Workflow or Route Task
	 **********************************************************************************/
	public void fnRouteTask() throws InterruptedException {
		childTest = test.createNode("Route Task. <br> << Screen Name : Folder Workflows>>");
		// FunctionLibrary.fnSwitchtoWindow(driver,4, "Route Task");
		if (driver.getTitle().equalsIgnoreCase("Route WorkFlow")) {
		fm.fnWebList(driver, fwf_Task_RT_CurrentTaskStatus, template.getProperty("Status"), "Current Task Status");
		fm.fnWebEdit(driver, fwf_Task_RT_NewDueDate, template.getProperty("DueDate"), "Due Date");
		fm.fnWebList(driver, fwf_Task_RT_NewPriority, template.getProperty("Priority"), "Priority");
		fm.fnWebCheckBox(driver, fwf_Task_RT_NotifyCC, "Notify CC");
		fm.fnWebCheckBox(driver, fwf_Task_RT_NotifyByEmail, "Notify By Email");
		// FunctionLibrary.fnSwitchtoWindow(driver,5, "Route Task");
		List<WebElement> chkBox = driver.findElements(By.xpath("//*[@type='checkbox']"));
		int no = chkBox.size();
		for (int i = 0; i < no; i++) {
			System.out.println(no);
			chkBox.get(i).click();
		}
		fm.fnWebButton(driver, fwf_Task_RT_Ok, "Ok");
		// FunctionLibrary.fnSwitchtoWindow(driver,4, "Route Task");
		fm.fnWebCheckBox(driver, fwf_Task_RT_NotifyByEmail, "Notify By Email");
		fm.fnWebEdit(driver, fwf_Task_RT_Comment, template.getProperty("Comments"), "Comment");
		fm.fnWebButton(driver, fwf_Task_RT_Save, "Save");
		}
	}
		
}
