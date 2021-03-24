package com_obj_ObjectRepository.FolderWorkflows1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
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
	
	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page1
	 ***************************************************************************************/
	By fwf_Events_SNE_EntityName = By.xpath("//INPUT[@id='tcet_bi_name']"); //Locator for Entity Name in Schedule New Event Page1 
	By fwf_Events_SNE_EntityID = By.xpath("//INPUT[@id='tcet_bi_id']"); //Locator for Entity ID in Schedule New Event Page1 
	By fwf_Events_SNE_Location = By.xpath("//SELECT[@id='location']"); //Locator for Location in Schedule New Event Page1 
	By fwf_Events_SNE_EntityGroup = By.xpath("//SELECT[@id='entity_group_name']"); //Locator for Entity Group in Schedule New Event Page1 
	By fwf_Events_SNE_EntityType = By.xpath("//SELECT[@id='tcet_bi_entity_type_id']"); //Locator for Entity Type in Schedule New Event Page1 
	By fwf_Events_SNE_Status = By.xpath("//SELECT[@id='tcet_bi_status_id']"); //Locator for Status in Schedule New Event Page1 
	By fwf_Events_SNE_GroupCosdes = By.xpath("//SELECT[@id='group_codes']"); //Locator for Group Codes in Schedule New Event Page1 
	By fwf_Events_SNE_Search = By.xpath("//INPUT[@id='btnSearch']"); //Locator for Search in Schedule New Event Page1 
	By fwf_Events_SNE_Clear = By.xpath("//INPUT[@id='btnCancel']"); //Locator for Clear in Schedule New Event Page1 
	By fwf_Events_SNE_Next = By.xpath("//INPUT[@id='cmdEntityNext']"); //Locator for Next in Schedule New Event Page1 
	By fwf_Events_SNE_Cancel1 = By.xpath("//IMG[@id='imgCancel']"); //Locator for Cancel in Schedule New Event Page1 

	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page2
	 ***************************************************************************************/
	By fwf_Events_SNE_EventTemplateName = By.xpath("//INPUT[@id='tce_event_name']"); //Locator for Event Template Name in Schedule New Event Page2 
	By fwf_Events_SNE_EventDescription = By.xpath("//INPUT[@id='tce_event_description']"); //Locator for Event Description in Schedule New Event Page2 
	By fwf_Events_SNE_TaxType = By.xpath("//SELECT[@id='tax_type_id']"); //Locator for Tax Type in Schedule New Event Page2 
	By fwf_Events_SNE_FormEntityType = By.xpath("//SELECT[@id='entity_type_id']"); //Locator for Form Entity Type in Schedule New Event Page2 
	By fwf_Events_SNE_Country_Region = By.xpath("//SELECT[@id='tcj_country_id']"); //Locator for Country Region in Schedule New Event Page2 
	By fwf_Events_SNE_State_Province = By.xpath("//SELECT[@id='tcj_state_province_id']"); //Locator for State Province in Schedule New Event Page2 
	By fwf_Events_SNE_Category = By.xpath("//SELECT[@id='tcj_category_id']"); //Locator for Category Schedule New Event Page2 
	By fwf_Events_SNE_JurisdictionCode = By.xpath("//INPUT[@id='tcj_code']"); //Locator for Jurisdiction Code in Schedule New Event Page2 
	By fwf_Events_SNE_AuthorityName = By.xpath("//INPUT[@id='tcau_authority_name1']"); //Locator for Authority Name in Schedule New Event Page2 
	By fwf_Events_SNE_Form = By.xpath("//INPUT[@id='form_no']"); //Locator for Form in Schedule New Event Page2 
	By fwf_Events_SNE_FormType = By.xpath("//SELECT[@id='form_type_id']"); //Locator for Form Type in Schedule New Event Page2 
	By fwf_Events_SNE_Next2 = By.xpath("//INPUT[@id='imgNextEvent']"); //Locator for Next in Schedule New Event Page2 
	By fwf_Events_SNE_Previous = By.xpath("//INPUT[@id='imgPreviousEvent']"); //Locator for Previous in Schedule New Event Page2 
	By fwf_Events_SNE_Cancel2 = By.xpath("//INPUT[@id='Image2']"); //Locator for Cancel in Schedule New Event Page2 
	By fwf_Events_SNE_EventTemplateWebTable = By.xpath("//*[@id='grd_SE_Event_cell_0_1']"); //Locator for Event Template Webtable in Schedule New Event Page2 

	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page3
	 ***************************************************************************************/
	By fwf_Events_SNE_OverallResponsibility = By.xpath("//SELECT[@id='ddlOverallResp']"); //Locator for Over all Responsibility in Schedule New Event Page3 
	By fwf_Events_SNE_OverallResponsibilityCkBx = By.xpath("//INPUT[@id='chkOverallResp']"); //Locator for Over all Responsibility Check Box in Schedule New Event Page3 
	By fwf_Events_SNE_AssignedTo = By.xpath("//SELECT[@id='ddlAssignedTo']"); //Locator for Assigned To in Schedule New Event Page3 
	By fwf_Events_SNE_AssignedToCkBx = By.xpath("//INPUT[@id='chkAssignedTo']"); //Locator for Assigned to checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_TaxAcct = By.xpath("//SELECT[@id='ddlResponsible1']"); //Locator for Tax Act in Schedule New Event Page3 
	By fwf_Events_SNE_TaxAcctCkBx = By.xpath("//INPUT[@id='chkResponsible1']"); //Locator for Tax Act Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility3 = By.xpath("//SELECT[@id='ddlResponsible3']"); //Locator for Responsibility3 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility3CkBx = By.xpath("//INPUT[@id='chkResponsible3']"); //Locator for Responsibility3 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Manager = By.xpath("//SELECT[@id='ddlResponsible2']"); //Locator for Manager in Schedule New Event Page3 
	By fwf_Events_SNE_ManagerCkBx = By.xpath("//INPUT[@id='chkResponsible2']"); //Locator for Manager Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility4 = By.xpath("//SELECT[@id='ddlResponsible4']"); //Locator for Responsibility4 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility4CkBx = By.xpath("//INPUT[@id='chkResponsible4']"); //Locator for Responsibility4 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility5 = By.xpath("//SELECT[@id='ddlResponsible5']"); //Locator for Responsibility5 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility5CkBx = By.xpath("//INPUT[@id='chkResponsible5']"); //Locator for Responsibility5 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility6 = By.xpath("//SELECT[@id='ddlResponsible6']"); //Locator for Responsibility6 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility6CkBx = By.xpath("//INPUT[@id='chkResponsible6']"); //Locator for Responsibility6 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Previous3 = By.xpath("//IMG[@id='imgPreviousResp']"); //Locator for Previous in Schedule New Event Page3 
	By fwf_Events_SNE_Next3 = By.xpath("//INPUT[@id='imgNextResp']"); //Locator for Next in Schedule New Event Page3
	By fwf_Events_SNE_Cancel3 = By.xpath("//INPUT[@id='Img5']"); //Locator for Cancel in Schedule New Event Page3
	By fwf_Events_SNE_Finish = By.xpath("//INPUT[@id='img1']"); //Locator for Finish in Schedule New Event Page3
	By fwf_Events_SNE_EventWebCheckbox = By.xpath("//*[@id='chkEntityEvent']"); //Locator for Event Web Checkbox in Schedule New Event Page3

	/***************************************************************************************
	 * These element locators belongs to Extend Event
	 ***************************************************************************************/
	By fwf_Events_ScheduleExtension = By.xpath("//INPUT[@id='btnScheduleExtension']"); //Locator for Schedule Extension in Extend Event Alert

	/***************************************************************************************
	 * These element locators belongs to Edit Schedule Event
	 ***************************************************************************************/
	
	By fwf_Events_ESE_Actions = By.xpath("//td[@class='actionsMiddle']"); //Locator for Actions in Edit Schedule Event
	//By fwf_Events_ESE_Actions = By.className("actionsMiddle"); //Locator for Actions in Edit Schedule Event
	By fwf_Events_ESE_Status = By.xpath("//SELECT[@id='ddlStatusWS']"); //Locator for Status in Edit Schedule Event
	By fwf_Events_ESE_Priority = By.xpath("//SELECT[@id='ddlPriorityWS']"); //Locator for Priority in Edit Schedule Event
	By fwf_Events_ESE_OWM_W_F_Template = By.xpath("//INPUT[@id='txtRelatedToWF']"); //Locator for W/F template in Edit Schedule Event
	By fwf_Events_ESE_NotifyCkBx = By.xpath("//IMG[@id='chkNotifyAssigned_mcbox']"); //Locator for Notify Checkbox in Edit Schedule Event
	By fwf_Events_Save = By.xpath("//INPUT[@id='btnSave']"); //Locator for Save in Edit Schedule Event
	By fwf_Events_ESE_MarkDone = By.xpath("//*[@id='mnuProperties_0']"); //Locator for Mark Done in Edit Schedule Event
	By fwf_Events_ESE_ExtendEvent = By.xpath("//*[@id='mnuProperties_1']"); //Locator for Extend event in Edit Schedule Event
	By fwf_Events_ESE_RollForward = By.xpath("//*[@id='mnuProperties_2']"); //Locator for Roll Forward in Edit Schedule Event
	By fwf_Events_ESE_Recalculate = By.xpath("//*[@id='mnuProperties_3']"); //Locator for Re-Calculate in Edit Schedule Event
	By fwf_Events_ESE_UndoExtension = By.xpath("//*[@id='mnuProperties_4']"); //Locator for Undo Extension in Edit Schedule Event
	By fwf_Events_ESE_PrintCertifiedMailer = By.xpath("//*[@id='mnuProperties_5']"); //Locator for Print certified Mailer in Edit Schedule Event
	By fwf_Events_ESE_RollForwardCkBx = By.xpath("//INPUT[@id='chkRollAll']"); //Locator for Roll Forward Checkbox in Roll Forward Page
	By fwf_Events_ESE_RollForward_Ok = By.xpath("//INPUT[@id='RolloverSchedEvents']"); //Locator for Ok in Roll Forward Page
	By fwf_Events_ESE_RollForward_Cancel = By.xpath("//INPUT[@id='btnCancel']"); //Locator for Cancel in Roll Forward Page
	
	/***************************************************************************************
	 * These element locators belongs to Actions Button
	 ***************************************************************************************/
	
	By Actions = By.xpath("//td[@id='btnActionsMenu']"); //Locator for Actions Button
	
	// -------------Email Documents ------------------------------------------

		By EmailDoc_To = By.xpath("//INPUT[@id='txtTo']");
		By EmailDoc_CC = By.xpath("//INPUT[@id='txtCC']");
		By EmailDoc_BCC = By.xpath("//INPUT[@id='txtBCC']");
		By EmailDoc_Subject = By.xpath("//INPUT[@id='txtSubject']");
		By EmailDoc_Message = By.xpath("//TEXTAREA[@id='txtMsg']");
		By EmailDoc_AttachmentType = By.xpath("//*[@id='rdAttachmentType1']");
		By EmailDoc_AttachmenType_asLink = By.xpath("//*[@id='rdAttachmentType0']");
		By EmailDoc_Save = By.xpath("//IMG[@id='btnOK']");
		By EmailDoc_Cancel = By.xpath("//IMG[@id='btnCancel']");
		// -------------------------CopyDocuments---------------------------------------------------
		By Documents_EntityName = By.xpath("//input[@id='idx_000000000B']");
		By Documents_EntityID = By.xpath("//input[@id='idx_000000000C']");
		By Documents_TaxType = By.xpath("//select[@id='idx_000000000D']");
		By Documents_Year = By.xpath("//select[@id='idx_000000000E']");
		By Documents_Period = By.xpath("//select[@id='idx_000000000F']");
		By Documents_Jurisdiction = By.xpath("//input[@id='idx_000000000G']");
		By Documents_Description = By.xpath("//input[@id='idx_000000000H']");
		By Documents_FileSection = By.xpath("//select[@id='idx_000000000I']");
		By Documents_DocumentType = By.xpath("//select[@id='idx_000000000J']");
		By Documents_DocumentDate = By.xpath("//input[@id='idx_000000000K']");
		By Documents_WorkFLowAssociation = By.xpath("//select[@id='idx_000000000L']");
		By Documents_AssignedTo = By.xpath("//select[@id='DropDownListDocumentUIDAssignTo']");
		By Documents_DocumentStatus = By.xpath("//select[@id='DropDownListDocumentStatus']");
		By Documents_DueDate = By.xpath("//input[@id='txtDueDate']");
		By Documents_chkNotify = By.xpath("//input[@id='chkNotify']");
		By Documents_NotifyEmailButton = By.xpath("//input[@id='btnUserList']");
		By Documents_Save = By.xpath("//IMG[@id='btnOK']");
		By Documents_Cancel = By.xpath("//IMG[@id='btnCancel']");
		By Documents_Reset = By.xpath("//IMG[@id='btnReset']");
		// --------------------------------MoveDocument------------------------------------------------------------------
		By MoveDoc_Drawers = By.xpath("//SELECT[@id='DropDownListDrawers']");
		By MoveDoc_DeleteSourceDoc = By.xpath("//INPUT[@id='chkDeleteSourceDocument']");
		By MoveDoc_EntityName = By.xpath("//input[@id='idx_0000000004']");
		By MoveDoc_EntityID = By.xpath("//input[@id='idx_0000000005']");
		By MoveDoc_TaxType = By.xpath("//select[@id='idx_0000000001']");
		By MoveDoc_Year = By.xpath("//select[@id='idx_0000000002']");
		By MoveDoc_Period = By.xpath("//select[@id='idx_0000000003']");
		By MoveDoc_Jurisdiction = By.xpath("//input[@id='idx_0000000006']");
		By MoveDoc_Description = By.xpath("//input[@id='idx_0000000009']");
		By MoveDoc_FileSection = By.xpath("//select[@id='idx_0000000007']");
		By MoveDoc_DocumentType = By.xpath("//select[@id='idx_0000000008']");
		By MoveDoc_DocumentDate = By.xpath("//input[@id='idx_000000000A']");
		By MoveDoc_Save = By.xpath("//img[@id='btnOK']");
		By MoveDoc_Cancel = By.xpath("//img[@id='btnCancel']");
		// ----------------------Document Properties-------------------------------
		public By DocProp_AssignedTo = By.xpath("//select[@id='assigned_to']");
		public By DocProp_DocumentStatus = By.xpath("//select[@id='document_status']");
		public By DocProp_DueDate = By.xpath("//input[@id='due_date']");
		// -----------------Saved Search----------------------------------------
		By SavedSearch_SavedSearches = By.xpath("//select[@id='saved_searches']");
		By SavedSearch_DocID = By.xpath("//input[@id='d.doc_id']");
		By SavedSearch_Year = By.xpath("//select[@id='idx_000000000E_ddl']");
		By SavedSearch_Period = By.xpath("//select[@id='idx_000000000F_ddl']");
		By SavedSearch_TaxType = By.xpath("//select[@id='idx_000000000D_ddl']");
		By SavedSearch_WFTemplate = By.xpath("//select[@id='wt_name']");
		By SavedSearch_WFAssociation = By.xpath("//select[@id='idx_000000000L_ddl']");
		By SavedSearch_WorkFlowType = By.xpath("//select[@id='fw_workflow_type']");
		By SavedSearch_FileSection = By.xpath("//select[@id='idx_000000000I_ddl']");
		By SavedSearch_DocumentType = By.xpath("//select[@id='idx_000000000J_ddl']");
		By SavedSearch_DocumentDate = By.xpath("//input[@id='dt_range_idx_000000000K_FOLDERDOCUMENTS']");
		By SavedSearch_Status = By.xpath("//select[@id='folder_workflow_status_id_ddl']");
		By SavedSearch_GroupCodes = By.xpath("//select[@id='group_codes']");
		By SavedSearch_Text = By.xpath("//input[@id='full_text_search_text']");
		By SavedSearch_TextOperator = By.xpath("//select[@id='full_text_search_operator']");
		By SavedSearch_Save = By
				.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[1]");
		By SavedSearch_Delete = By
				.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[2]");
		By SavedSearch_Search = By
				.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[1]");
		By SavedSearch_Clear = By.xpath(
				"//div[@id=\"divDocumentsCrit\"]/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[2]");
		By SavedSearch_Close = By.xpath("//img[@id='btnClose']");

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
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class).ignoring(NoSuchFrameException.class);
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		if (driver.getTitle().equalsIgnoreCase("Add document")) {
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
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
			Thread.sleep(900);
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(1000);
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fwf_Task_AD_Save));
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
			Thread.sleep(2000);
			//WebDriverWait w1 = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.alertIsPresent());
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
			//fm.fnWebButton(driver, fwf_Task_AD_NotifyUsersList, "Users List");
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fwf_Task_AD_Save));
			fm.fnWebButton(driver, fwf_Task_AD_Save, "Save");
			Thread.sleep(1500);
		}else {
			childTest.log(Status.FAIL, "Add Document Page is not in Focus/Add Document Page is not opened");
		}
	}

	/*********************************************************************************
	 * This function is used to Extend the Event
	 **********************************************************************************/
	
	public void fnFWFExtendEvent() throws InterruptedException{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(1500);
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Extension")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ScheduleExtension));
			fm.fnWebButton(driver, fwf_Events_ScheduleExtension, "Extend Event(s)");
		}
	}
	
	/*********************************************************************************
	 * This function is used to click Actions in Folder Workflows
	 **********************************************************************************/
	
	public void fnFWFClickActions() throws InterruptedException{
		if(driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
			fm.fnWebButton(driver, Actions, "Actions");
		}
	}
	
	/*********************************************************************************
	 * This function is used to Swtich Tabs in Folder Workflows
	 **********************************************************************************/
	
	public void fnFWFSwitchingTab(String text) throws InterruptedException{
		Thread.sleep(1500);
		if(driver.getTitle().contains("Folder WorkFlows")) {
			By tabItem = By.xpath("//*[@id='TabStrip1']//*[contains(text(),'"+text+"')]");
			fm.fnWebButton(driver, tabItem, text);
		}
	}
	
	
	/*********************************************************************************
	 * This function is used to Schedule a New Event
	 **********************************************************************************/

	public void fnFWFScheduleNewEvent() throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Schedule Event." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(5500);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_SNE_Clear));
		if (driver.getTitle().equalsIgnoreCase("Schedule New Event(s)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_SNE_EventTemplateName));
			fm.fnWebButton(driver, fwf_Events_SNE_Clear, "Cancel");
			fm.fnWebEdit(driver, fwf_Events_SNE_EventTemplateName, template.getProperty("Event_Template_Name"), "Event Template Name");
			fm.fnWebList(driver, fwf_Events_SNE_TaxType, template.getProperty("E_TaxType"), "Tax Type");
			fm.fnWebButton(driver, fwf_Events_SNE_Search, "Search");
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) driver
					.findElements(By.xpath("//DIV[@id='grd_SE_Event_dom']/table/tbody/tr"));
			System.out.println(cells1.size());
			if (cells1.size() >= 2) {
				fm.fnWebButton(driver, fwf_Events_SNE_EventTemplateWebTable, "Event Template Name WebTable");
			} else {
				driver.quit();
			}
			fm.fnWebButton(driver, fwf_Events_SNE_Next2, "Next");
			fm.fnWebList(driver, fwf_Events_SNE_AssignedTo, template.getProperty("AssignedTo"), "Assigned To");
			fm.fnWebCheckBox(driver, fwf_Events_SNE_AssignedToCkBx, "Assigned ToCkBx");
			fm.fnWebButton(driver, fwf_Events_SNE_Next3, "Next");
			List<WebElement> chkBox = driver
					.findElements(By.xpath("//DIV[@id='grd_SE_Entity_Event_dom']/TABLE/tbody/tr"));
			int no = chkBox.size();
			System.out.println(no);
			if (no > 1) {
				fm.fnWebButton(driver, fwf_Events_SNE_EventWebCheckbox, "Event Checkbox");
			}
			fm.fnWebButton(driver, fwf_Events_SNE_Finish, "Finish");
			Thread.sleep(1500);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			childTest.log(Status.PASS, "Successfully a Event is created");
		}else {
			childTest.log(Status.FAIL, "Schedule New Event Page is not Focused/Opened");
		}

	}

	/***********************************************************************************
	 * This function is used to perform Mark Done function in Edit Schedule Events Page
	 ***********************************************************************************/
	
	public void fnFWFESEMarkDone(String text) throws InterruptedException {
		childTest = test.createNode("Description: Mark Done" + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		// FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
		Thread.sleep(1500);
		if (driver.getTitle().equalsIgnoreCase("Scheduled Event Profile")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
			fm.fnWebButton(driver, fwf_Events_ESE_Actions, "Action");
			fm.fnWebButton(driver, fwf_Events_ESE_MarkDone, "Mark Done");
			By tabItem = By.xpath("//*[@id='TabStripStepProperties']//*[contains(text(),'" + text + "')]");
			fm.fnWebButton(driver, tabItem, text);
			fm.fnWebButton(driver, fwf_Events_Save, "Save");
			//System.out.println(driver.switchTo().alert().getText());
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText()
					.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Selected event has been upated");
			} else {
				childTest.log(Status.FAIL, "Selected event is not updated");
				driver.close();
			}

		}else {
			driver.close();
			childTest.log(Status.FAIL, "Scheduled Event Profile page is not recoginzed");
		}
	}

	/**************************************************************************************
	 * This function is used to perform Re-Calculate function in Edit Schedule Events Page
	 **************************************************************************************/
	
	public void fnFWFESEReCalculate() throws InterruptedException {
		childTest = test.createNode("Description: Re-Calculate." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(1500);
		if (driver.getTitle().equalsIgnoreCase("Scheduled Event Profile")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
			fm.fnWebButton(driver, fwf_Events_ESE_Actions, "Action");
			fm.fnWebButton(driver, fwf_Events_ESE_Recalculate, "Re-Calculate");
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText().equalsIgnoreCase("0 out of 1 record(s) processed.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}
			Thread.sleep(1000);
			fm.fnWebButton(driver, fwf_Events_Save, "Save");
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText()
					.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Selected scheduled event is updated");
			} else {
				driver.close();
				childTest.log(Status.FAIL, "Selected scheduled event is not updated");
			}
		}
	}

	/**************************************************************************************
	 * This function is used to Select a Event
	 **************************************************************************************/
	
	public void fnFWFSelectEvent() throws InterruptedException {
		//FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		
         ArrayList<WebElement> cells = (ArrayList<WebElement>) driver.findElements(By.xpath("//DIV[@id='grdEvents_dom']/table/tbody/tr/td"));
         for (WebElement cell : cells) {
             if(cell.getText().equals(template.getProperty("Event_Template_Name"))) {
            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@id='grdEvents_dom']/table/tbody/tr/td")));
             	fm.fnWebTable(driver, cell, "Click");
            	break;
 	        }
 	    }
    }
	
	
	/*********************************************************************************
	 * This function is used to View the Documents
	 **********************************************************************************/

	public void fnFWFViewDocuments() throws InterruptedException {
		childTest = test
				.createNode("Description: View Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(100)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class).ignoring(NoSuchFrameException.class);
		Thread.sleep(1500);
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
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fwf_Task_Save));
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
	
	/*********************************************************************************
	 * This function is used to Email Document
	 **********************************************************************************/
	public void fwf_fnEmailDocument() throws InterruptedException {
		childTest = test
				.createNode("Description: Email Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Email Document(s)")) {
			fm.fnWebButton(driver, EmailDoc_Save, "Save");
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
			fm.fnWebEdit(driver, EmailDoc_To, template.getProperty("doc_EmailTO"), " To ");
			fm.fnWebEdit(driver, EmailDoc_CC, template.getProperty("doc_EmailCC"), " CC ");
			fm.fnWebEdit(driver, EmailDoc_Subject, template.getProperty("doc_EmailSubject"), "Subject");
			fm.fnWebEdit(driver, EmailDoc_Message, "Hi All,", "\"Hi All,\" + \"+<br>+\"\r\n"
					+ "					+ \" This email is intended to verify Email Document's as a link/Attachment functionality</br>\"");
			fm.fnWebButton(driver, EmailDoc_AttachmenType_asLink, "As a Link");
			fm.fnWebButton(driver, EmailDoc_Save, "Save");
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

	/*********************************************************************************
	 * This function is used to Copy Document
	 **********************************************************************************/
	public void fwf_fnCopyDocuments() throws InterruptedException {
		childTest = test
				.createNode("Description: Copy Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Copy Document(s)")) {
			// owm.Documents_Entityname("");
			fm.fnWebButton(driver, Documents_Save, "Save");
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
			fm.fnWebButton(driver, Documents_Reset, "Reset");
			Thread.sleep(800);
			fm.fnWebButton(driver, Documents_Save, "Save");
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

	/*********************************************************************************
	 * This function is used to Move Document
	 **********************************************************************************/
	public void fwf_fnMoveDocument() throws InterruptedException {
		childTest = test
				.createNode("Description: Move Document " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Move Document")) {
			fm.fnWebList(driver, MoveDoc_Drawers, template.getProperty("doc_MoveD_Drawer"), "Drawers");
			WebDriverWait w = new WebDriverWait(driver, 40);
			WebElement exist = w
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idx_0000000004']")));
			if (exist.isDisplayed()) {
				fm.fnWebButton(driver, MoveDoc_Save, "Save");
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
				fm.fnWebEdit(driver, MoveDoc_EntityName, template.getProperty("doc_MoveD_EntityName"), "Entity Name");
				fm.fnWebEdit(driver, MoveDoc_EntityID, template.getProperty("doc_MoveD_EntityNum"), "Entity ID");
				fm.fnWebList(driver, MoveDoc_TaxType, template.getProperty("TaxType"), "Tax Type");
				fm.fnWebList(driver, MoveDoc_FileSection, template.getProperty("doc_FileSection"), "File Section");
				fm.fnWebList(driver, MoveDoc_Year, template.getProperty("Year"), "Year");
				fm.fnWebEdit(driver, MoveDoc_Description, template.getProperty("doc_Description"), "Description");
				fm.fnWebList(driver, MoveDoc_Period, template.getProperty("Period"), "Period");
				fm.fnWebButton(driver, MoveDoc_Save, "Save");
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

	/*********************************************************************************
	 * This function is used to verify Document Properties
	 **********************************************************************************/
	public void fwf_fnDocumentProperties() throws InterruptedException {
		childTest = test
				.createNode("Description: Document Properties " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Document Properties")) {
			HashMap<By, String> txtCompare = new HashMap<By, String>();
			txtCompare.put(Documents_Description, template.getProperty("doc_Description")); // Description
			txtCompare.put(Documents_FileSection, template.getProperty("doc_FileSection")); // FileSection
			txtCompare.put(Documents_DocumentType, template.getProperty("doc_DocumentType")); // Document Type
			txtCompare.put(Documents_DocumentDate, template.getProperty("doc_DocumentDate")); // Document Date
			txtCompare.put(DocProp_AssignedTo, template.getProperty("doc_AssignedTo")); // Assigned To
			txtCompare.put(DocProp_DocumentStatus, template.getProperty("doc_DocumentStatus")); // Document Status
			txtCompare.put(DocProp_DueDate, template.getProperty("doc_DueDate")); // Due Date

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
			fm.fnWebButton(driver, Documents_Save, "Save");
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

	// ------------------Customize View-------------------------------------
	By Doc_CustView_Save = By.xpath("//INPUT[@id='btnSave']");

	/*********************************************************************************
	 * This function is used to Customize view save
	 **********************************************************************************/
	public void Doc_Custview_Save() throws InterruptedException {
		fm.fnWebButton(driver, Doc_CustView_Save, "Save");
	}

	/*********************************************************************************
	 * This function is used for saved search
	 **********************************************************************************/
	public void fwf_fnSavedSearch() throws InterruptedException {
		childTest = test.createNode(
				"Description: Saved Seach/Document Search " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Thread.sleep(3000);
		if (driver.getTitle().equalsIgnoreCase("Documents Search")) {
			fm.fnWebButton(driver, SavedSearch_Clear, "Clear");
			fm.fnWebList(driver, SavedSearch_Year, template.getProperty("Year"), "Year");
			fm.fnWebList(driver, SavedSearch_Period, template.getProperty("Period"), "Period");
			fm.fnWebList(driver, SavedSearch_TaxType, template.getProperty("TaxType"), "Tax Type");
			fm.fnWebList(driver, SavedSearch_WFTemplate, template.getProperty("WF_Template"), "WF Template");
			// owm.SavedSearch_WfAssociation("");
			fm.fnWebEdit(driver, Documents_EntityName, template.getProperty("Entity_Name"), "Entity Name");
			fm.fnWebEdit(driver, Documents_EntityID, template.getProperty("Entity_Id"), "Entity ID");
			fm.fnWebEdit(driver, Documents_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
			fm.fnWebEdit(driver, Documents_Description, template.getProperty("doc_Description"), "Description");
			fm.fnWebList(driver, SavedSearch_FileSection, template.getProperty("doc_FileSection"), "FileSection");
			fm.fnWebList(driver, SavedSearch_DocumentType, template.getProperty("doc_DocumentType"), "Document Type");
			fm.fnWebList(driver, Documents_AssignedTo, template.getProperty("doc_AssignedTo"), "Assigned To");
			fm.fnWebButton(driver, SavedSearch_Close, "Close");
		}
	}

		
}
