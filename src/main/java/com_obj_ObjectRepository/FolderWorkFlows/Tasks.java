package com_obj_ObjectRepository.FolderWorkFlows;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com_lib_FunctionLibrary.FrameWork;

public class Tasks {
	WebDriver driver;
	FrameWork fm = new FrameWork();

		public Tasks(WebDriver driver) {
			this.driver = driver;
		}
		
		// ---------------Add Workflow Task-----------------------------------------------------------------------------
		By fwf_Task_TaskProperties = By.xpath("//*[@id='TabStripStepProperties_0']");
		By fwf_Task_PageLinks = By.xpath("//*[@id='TabStripStepProperties_1']");
		By fwf_Task_CheckLists = By.xpath("//*[@id='TabStripStepProperties_2']");
		By fwf_Task_Documents = By.xpath("//*[@id='TabStripStepProperties_3']");
		By fwf_Task_TaskName = By.xpath("//INPUT[@id='txtTask']");
		By fwf_Task_AssignedToGroup = By.xpath("//SELECT[@id='ddlAssignedToGroup']");
		By fwf_Task_AssignedToPerson = By.xpath("//SELECT[@id='ddlAssignToUID']");
		By fwf_Task_LeadDays = By.xpath("//INPUT[@id='txtLeadDays']");
		By fwf_Task_Status= By.xpath("//SELECT[@id='DropDownListTaskPropertiesStatus']");
		By fwf_Task_DueDate = By.xpath("//INPUT[@id='pkDateDue']");
		By fwf_Task_Priority = By.xpath("//SELECT[@id='DropDownListTaskPropertiesPriority']");
		By fwf_Task_NotifyByEmail = By.xpath("//INPUT[@id='chkNotify']");
		By fwf_Task_NotifyByCC = By.xpath("//INPUT[@id='chkNotifyCC']");
		By fwf_Task_NotifyByCCEmailList = By.xpath("//INPUT[@id='btnEmailList']");
		By fwf_Task_Comment = By.xpath("//*[@id='txtNotes']");
		By fwf_Task_AddDocument = By.xpath("//*[@id='btnAddDoc']");
		By fwf_Task_Save = By.xpath("//*[@id='btnOK']");
		By fwf_Task_Cancel = By.xpath("//IMG[@id='btnCancel']");
		
		public void fwf_Task_TaskProperties() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_TaskProperties, "Task Properties");
		}
		
		public void fwf_Task_PageLinks() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_PageLinks, "Page Links");
		}
		
		public void fwf_Task_CheckLists() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_CheckLists, "Checklist");
		}
		
		public void fwf_Task_Documents() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_Documents, "Documents");
		}
		
		public void fwfTask(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_TaskName, temp, "Task");
		}
		
		public void fwfAssignedToGroup(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AssignedToGroup, temp, "Assigned To Group");
		}
		
		public void fwf_AssignedToPerson(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AssignedToPerson, temp, "Assigned To Person");
		}
		
		public void fwf_LeadDays(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_LeadDays, temp, "Lead Days");
		}
		
		public void fwf_Status(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_Status, temp, "Status");
		}
		
		public void fwf_DueDate(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_DueDate, temp, "Due Date");
		}
		
		public void fwf_Priority(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_Priority, temp, "Assigned To Group");
		}
		
		public void fwf_NotifyByEmail() throws InterruptedException {
			fm.fnWebCheckBox(driver, fwf_Task_NotifyByEmail,"Notify By Email");
		}
		
		public void fwf_NotifyByCC() throws InterruptedException {
			fm.fnWebCheckBox(driver, fwf_Task_NotifyByCC,"Notify CC");
		}
		
		public void fwf_NotifyByCCEmailList(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_NotifyByCCEmailList, temp, "Email List");
		}
		
		public void fwf_Task_Comment(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_Comment, temp, "Comment");
		}
		
		public void fwf_Task_AddDocument(String temp) throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_AddDocument, "Add Document");
		}
		
		public void fwf_Task_Save() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_Save, "Save");
		}
		
		public void fwf_Task_Cancel() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_Cancel, "Cancel");
		}
		
		
		// ---------------Add Document-----------------------------------------------------------------------------
		By fwf_Task_AD_ElectronicDocument = By.xpath("//INPUT[@id='doc']");
		By fwf_Task_AD_LinkToFile = By.xpath("//INPUT[@id='link']");
		By fwf_Task_AD_Description = By.xpath("//INPUT[@id='idx_000000000H']");
		By fwf_Task_AD_FileSection = By.xpath("//SELECT[@id='idx_000000000I']");
		By fwf_Task_AD_DocumentType = By.xpath("//SELECT[@id='idx_000000000J']");
		By fwf_Task_AD_DocumentDate = By.xpath("//INPUT[@id='idx_000000000K']");
		By fwf_Task_AD_AssignedTo= By.xpath("//SELECT[@id='assigned_to']");
		By fwf_Task_AD_DocumentStatus = By.xpath("//SELECT[@id='document_status']");
		By fwf_Task_AD_DueDate = By.xpath("//INPUT[@id='due_date']");
		By fwf_Task_AD_Notify = By.xpath("//INPUT[@id='chkNotify']");
		By fwf_Task_AD_NotifyUsersList = By.xpath("//INPUT[@id='btnUserList']");
		By fwf_Task_AD_Clear = By.xpath("//IMG[@id='btnClear']");
		By fwf_Task_AD_Save = By.xpath("//IMG[@id='btnOK']");
		By fwf_Task_AD_Cancel = By.xpath("//IMG[@id='Img1']");
		By fwf_Task_AD_UserList = By.xpath("//table[@id='UsersTable']");
 		By fwf_Task_AD_UserList_Save = By.xpath("//*[@id='btnSaveValues']");
 		By fwf_Task_AD_UserList_Cancel = By.xpath("//*[@id='btnCancel']");
		
		public void fwf_Task_AD_ElectronicDocument(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_AD_ElectronicDocument, temp, "Electronic Document");
		}
		public void fwf_Task_AD_LinkToFile(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_AD_LinkToFile, temp, "Link To File");
		}
		public void fwf_Task_AD_Description(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_AD_Description, temp, "Description");
		}
		public void fwf_Task_AD_FileSection(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AD_FileSection, temp, "File Section");
		}
		public void fwf_Task_AD_DocumentType(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AD_DocumentType, temp, "Document Type");
		}
		public void fwf_Task_AD_DocumentDate(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_AD_DocumentDate, temp, "Document Date");
		}
		public void fwf_Task_AD_AssignedTo(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AD_AssignedTo, temp, "Assigned To");
		}
		public void fwf_Task_AD_DocumentStatus(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_AD_DocumentStatus, temp, "Document Status");
		}
		public void fwf_Task_AD_DueDate(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_AD_DueDate, temp, "Due Date");
		}
		public void fwf_Task_AD_Notify() throws InterruptedException {
			fm.fnWebCheckBox(driver, fwf_Task_AD_Notify,"Notify");
		}
		public void fwf_Task_AD_NotifyUsersList() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_AD_NotifyUsersList, "Users List");
		}
		public void fwf_Task_AD_Clear() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_AD_Clear, "Clear");
		}
		public void fwf_Task_AD_Save() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
		}
		public void fwf_Task_AD_Cancel() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_AD_Cancel, "Cancel");
		}
		public WebElement fwf_Task_AD_UserList() throws InterruptedException{
 			return driver.findElement(fwf_Task_AD_UserList);
 		}
 		public void fwf_Task_AD_UserList_Save() throws InterruptedException{
 			fm.fnWebButton(driver, fwf_Task_AD_UserList_Save, "Save");
 		}
 		public void fwf_Task_AD_UserList_Cancel() throws InterruptedException{
 			fm.fnWebButton(driver, fwf_Task_AD_UserList_Cancel, "Save");
 		}

		// ---------------Route Task-----------------------------------------------------------------------------
		By fwf_Task_RT_CurrentTask = By.xpath("//INPUT[@id='txtTaskName']");
		By fwf_Task_RT_CurrentTaskStatus = By.xpath("//SELECT[@id=\"DropDownListTaskStatusCurrent\"]");
		By fwf_Task_RT_NewTask = By.xpath("//SELECT[@id='DropDownListTask']");
		By fwf_Task_RT_NewAssignedToGroup = By.xpath("//SELECT[@id='ddlAssignedToGroup']");
		By fwf_Task_RT_NewAssignedToPerson = By.xpath("//SELECT[@id='ddlAssignedToPerson']");
		By fwf_Task_RT_NewTaskStatus = By.xpath("//SELECT[@id='DropDownListTaskStatus']");
		By fwf_Task_RT_NewDueDate = By.xpath("//INPUT[@id='pkDueDate']");
		By fwf_Task_RT_NewPriority = By.xpath("//SELECT[@id='DropDownListTaskPriority']");
		By fwf_Task_RT_CurrentTaskList = By.xpath("//INPUT[@id='btnTaskList']");
		By fwf_Task_RT_NotifyByEmail = By.xpath("//INPUT[@id='chkNotify']");
		By fwf_Task_RT_NotifyCC = By.xpath("//INPUT[@id='chkNotifyCC']");
		By fwf_Task_RT_NotifyEmailList = By.xpath("//INPUT[@id='btnEmailList']");
		By fwf_Task_RT_Comment = By.xpath("//TEXTAREA[@id='txtNotes']");
		By fwf_Task_RT_Save = By.xpath("//IMG[@id='btnRoute']");
		By fwf_Task_RT_Cancel = By.xpath("//IMG[@id='btnCancel']");
		
		public void fwf_Task_RT_CurrentTask(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_RT_CurrentTask, temp, "Current Task");
		}
		
		public void fwf_Task_RT_CurrentTaskStatus(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_CurrentTaskStatus, temp, "Current Task Status");
		}
		
		public void fwf_Task_RT_NewTask(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_NewTask, temp, "New Task");
		}
		
		public void fwf_Task_RT_NewAssignedToGroup(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_NewTask, temp, "Assigned To Group");
		}
		
		public void fwf_Task_RT_NewAssignedToPerson(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_NewAssignedToPerson, temp, "Assigned To Person");
		}
		
		public void fwf_Task_RT_NewTaskStatus(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_NewTaskStatus, temp, "Task Status");
		}
		
		public void fwf_Task_RT_NewDueDate(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_RT_NewDueDate, temp, "Due Date");
		}
		
		public void fwf_Task_RT_NewPriority(String temp) throws InterruptedException {
			fm.fnWebList(driver, fwf_Task_RT_NewPriority, temp, "Priority");
		}
		
		public void fwf_Task_RT_CurrentTaskList() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_RT_CurrentTaskList, "Task List");
		}
		
		public void fwf_Task_RT_NotifyByEmail() throws InterruptedException {
			fm.fnWebCheckBox(driver, fwf_Task_RT_NotifyByEmail,"Notify By Email");
		}
		
		public void fwf_Task_RT_NotifyCC() throws InterruptedException {
			fm.fnWebCheckBox(driver, fwf_Task_RT_NotifyCC,"Notify CC");
		}
		
		public void fwf_Task_RT_Comment(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, fwf_Task_RT_Comment, temp, "Comment");
		}
		
		public void fwf_Task_RT_NotifyEmailList() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_RT_NotifyEmailList, "Email List");
		}
		
		public void fwf_Task_RT_Save() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_RT_Save, "Save");
		}
		
		public void fwf_Task_RT_Cancel() throws InterruptedException {
			fm.fnWebButton(driver, fwf_Task_RT_Cancel, "Cancel");
		}
		
	}

