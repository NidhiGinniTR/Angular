package com_obj_ObjectRepository.FolderWorkFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com_lib_FunctionLibrary.FrameWork;

public class Documents {

	WebDriver driver;
	FrameWork fm = new FrameWork();

	public Documents(WebDriver driver) {
		this.driver = driver;
	}
	
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

	public void Emaildoc_To(String text) throws InterruptedException {
		fm.fnWebEdit(driver, EmailDoc_To, text, " To ");
	}

	public void Emaildoc_CC(String text) throws InterruptedException {
		fm.fnWebEdit(driver, EmailDoc_CC, text, " CC ");
	}

	public void Emaildoc_BCC(String text) throws InterruptedException {
		fm.fnWebEdit(driver, EmailDoc_BCC, text, " BCC ");
	}

	public void Emaildoc_Subject(String text) throws InterruptedException {
		fm.fnWebEdit(driver, EmailDoc_Subject, text, "Subject");
	}

	public void Emaildoc_Message(String text) throws InterruptedException {
		fm.fnWebEdit(driver, EmailDoc_Message, text, "Message");
	}

	public WebElement Emaildoc_AttachmentType() throws InterruptedException {
		return driver.findElement(EmailDoc_AttachmentType);
	}

	public void EmailDoc_AttachmenType_asLink() throws InterruptedException {
		fm.fnWebButton(driver, EmailDoc_AttachmenType_asLink, "As a Link");
	}
	public void Emaildoc_Save() throws InterruptedException {
		fm.fnWebButton(driver, EmailDoc_Save, "Save");
	}

	public void Emaildoc_Cancel() throws InterruptedException {
		fm.fnWebButton(driver, EmailDoc_Cancel, "Cancel");
	}

	// -------------------------Copy
	// Documents---------------------------------------------------
	public By Documents_EntityName = By.xpath("//input[@id='idx_000000000B']");
	By Documents_EntityID = By.xpath("//input[@id='idx_000000000C']");
	By Documents_TaxType = By.xpath("//select[@id='idx_000000000D']");
	By Documents_Year = By.xpath("//select[@id='idx_000000000E']");
	By Documents_Period = By.xpath("//select[@id='idx_000000000F']");
	By Documents_Jurisdiction = By.xpath("//input[@id='idx_000000000G']");
	public By Documents_Description = By.xpath("//input[@id='idx_000000000H']");
	public By Documents_FileSection = By.xpath("//select[@id='idx_000000000I']");
	public By Documents_DocumentType = By.xpath("//select[@id='idx_000000000J']");
	public By Documents_DocumentDate = By.xpath("//input[@id='idx_000000000K']");
	By Documents_WorkFLowAssociation = By.xpath("//select[@id='idx_000000000L']");
	By Documents_AssignedTo = By.xpath("//select[@id='DropDownListDocumentUIDAssignTo']");
	By Documents_DocumentStatus = By.xpath("//select[@id='DropDownListDocumentStatus']");
	By Documents_DueDate = By.xpath("//input[@id='txtDueDate']");
	By Documents_chkNotify = By.xpath("//input[@id='chkNotify']");
	By Documents_NotifyEmailButton = By.xpath("//input[@id='btnUserList']");
	By Documents_Save = By.xpath("//IMG[@id='btnOK']");
	By Documents_Cancel = By.xpath("//IMG[@id='btnCancel']");
	By Documents_Reset = By.xpath("//IMG[@id='btnReset']");

	public void Documents_Entityname(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_EntityName, text, "Entity Name");
	}

	public void Documents_EntityId(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_EntityID, text, "Entity ID");
	}

	public void Documents_Taxtype(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_TaxType, text, "Tax Type");
	}

	public void Documents_year(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_Year, text, "Year");
	}

	public void Documents_period(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_Period, text, "Period");
	}

	public void Documents_jurisdiction(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_Jurisdiction, text, "Jurisdiction");
	}

	public void Documents_Description(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_Description, text, "Description");
	}

	public void Documents_Filesection(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_FileSection, text, "FileSection");
	}

	public void Documents_Documenttype(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_DocumentType, text, "Document Type");
	}

	public void Documents_Documentdate(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_DocumentDate, text, "Document Date");
	}

	public void Documents_WorkfLowAssociation(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_WorkFLowAssociation, text, "WorkFLow Association");
	}

	public void Documents_Assignedto(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_AssignedTo, text, "Assigned To");
	}

	public void Documents_Documentstatus(String text) throws InterruptedException {
		fm.fnWebList(driver, Documents_DocumentStatus, text, "DocumentStatus");
	}

	public void Documents_Duedate(String text) throws InterruptedException {
		fm.fnWebEdit(driver, Documents_DueDate, text, "Due Date");
	}

	public void Documents_chknotify() throws InterruptedException {
		fm.fnWebButton(driver, Documents_chkNotify, "Notify");
	}

	public void Documents_NotifyEmailbutton() throws InterruptedException {
		fm.fnWebButton(driver, Documents_NotifyEmailButton, "Notify Email list Button");
	}

	public void Documents_save() throws InterruptedException {
		fm.fnWebButton(driver, Documents_Save, "Save");
	}

	public void Documents_cancel() throws InterruptedException {
		fm.fnWebButton(driver, Documents_Cancel, "Cancel");
	}

	public void Documents_Reset() throws InterruptedException {
		fm.fnWebButton(driver, Documents_Reset, "Reset");
	}

	// --------------------------------Move
	// Document------------------------------------------------------------------
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

	public void MoveDoc_drawers(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_Drawers, text, "Drawers");
	}

	public void MoveDoc_DeleteSourcedoc() throws InterruptedException {
		fm.fnWebButton(driver, MoveDoc_DeleteSourceDoc, "Delete Source Document checkbox");
	}

	public void MoveDoc_save() throws InterruptedException {
		fm.fnWebButton(driver, MoveDoc_Save, "Save");
	}

	public void MoveDoc_Cancel() throws InterruptedException {
		fm.fnWebButton(driver, MoveDoc_Cancel, "Cancel");
	}

	public void MoveDoc_TaxType(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_TaxType, text, "Tax Type");
	}

	public void MoveDoc_Year(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_Year, text, "Year");
	}

	public void MoveDoc_Period(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_Period, text, "Period");
	}

	public void MoveDoc_FileSection(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_FileSection, text, "File Section");
	}

	public void MoveDoc_DocumentType(String text) throws InterruptedException {
		fm.fnWebList(driver, MoveDoc_DocumentType, text, "Document Type");
	}

	public void MoveDoc_DocumentDate(String text) throws InterruptedException {
		fm.fnWebEdit(driver, MoveDoc_DocumentDate, text, "Document Date");
	}

	public void MoveDoc_Description(String text) throws InterruptedException {
		fm.fnWebEdit(driver, MoveDoc_Description, text, "Description");
	}

	public void MoveDoc_Jurisdiction(String text) throws InterruptedException {
		fm.fnWebEdit(driver, MoveDoc_Jurisdiction, text, "Jurisdiction");
	}

	public void MoveDoc_EntityID(String text) throws InterruptedException {
		fm.fnWebEdit(driver, MoveDoc_EntityID, text, "Entity ID");
	}

	public void MoveDoc_EntityName(String text) throws InterruptedException {
		fm.fnWebEdit(driver, MoveDoc_EntityName, text, "Entity Name");
	}

	//----------------------Document Properties-------------------------------
    public By DocProp_AssignedTo = By.xpath("//select[@id='assigned_to']");
    public By DocProp_DocumentStatus = By.xpath("//select[@id='document_status']");
    public By DocProp_DueDate = By.xpath("//input[@id='due_date']");
    
    public void DocProp_Assignedto(String text) throws InterruptedException{
    	fm.fnWebList(driver, DocProp_AssignedTo, text, "Assigned To");
    }
    public void DocProp_Documentstatus(String text) throws InterruptedException{
    	fm.fnWebList(driver, DocProp_DocumentStatus, text, "Document Status");
    }
    public void DocProp_Duedate(String text) throws InterruptedException{
    	fm.fnWebEdit(driver,DocProp_DueDate , text,"Due Date");
    }
    
    //------------------Customize View-------------------------------------
    By Doc_CustView_Save = By.xpath("//INPUT[@id='btnSave']");
    
    public void Doc_Custview_Save() throws InterruptedException{
    	fm.fnWebButton(driver, Doc_CustView_Save, "Save");
    }
    
    //-----------------Saved Search----------------------------------------
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
    By SavedSearch_DocumentDate =  By.xpath("//input[@id='dt_range_idx_000000000K_FOLDERDOCUMENTS']");
    By SavedSearch_Status = By.xpath("//select[@id='folder_workflow_status_id_ddl']");
    By SavedSearch_GroupCodes = By.xpath("//select[@id='group_codes']");
    By SavedSearch_Text = By.xpath("//input[@id='full_text_search_text']");
    By SavedSearch_TextOperator = By.xpath("//select[@id='full_text_search_operator']");
    By SavedSearch_Save = By.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[1]");
    By SavedSearch_Delete = By.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[2]");
    By SavedSearch_Search = By.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[1]");
    By SavedSearch_Clear = By.xpath("//div[@id=\"divDocumentsCrit\"]/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[2]");
    By SavedSearch_Close = By.xpath("//img[@id='btnClose']"); 
    
   
    public void SavedSearch_Savedsearches(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_SavedSearches, text,"Saved Searches");
    }
    public void SavedSearch_DocId(String text) throws InterruptedException{
    	fm.fnWebEdit(driver, SavedSearch_DocID, text,"Doc ID");
    }
    public void SavedSearch_year(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_Year, text,"Year");
    }
    public void SavedSearch_period(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_Period, text,"Period");
    }
    public void SavedSearch_Taxtype(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_TaxType, text, "Tax Type");
    }
    public void SavedSearch_WFtemplate(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_WFTemplate, text,"WF Template");
    }
    public void SavedSearch_WfAssociation(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_WFAssociation, text,"WF Association");
    }
    public void SavedSearch_FileSection(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_FileSection, text,"FileSection");
    }
    public void SavedSearch_DocumentType(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_DocumentType, text,"Document Type");
    }
    public void SavedSearch_DocumentDate(String text) throws InterruptedException{
    	fm.fnWebEdit(driver, SavedSearch_DocumentDate, text,"Document Date");
    }
    public void SavedSearch_Status(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_Status, text,"Status");
    }
    public void SavedSearch_GroupCodes(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_GroupCodes, text,"Group Codes");
    }
    public void SavedSearch_Text(String text) throws InterruptedException{
    	fm.fnWebEdit(driver, SavedSearch_Text, text,"Text");
    }
    public void SavedSearch_TextOperator(String text) throws InterruptedException{
    	fm.fnWebList(driver, SavedSearch_TextOperator, text,"Text Operator Filter");
    }
    public void SavedSearch_Save() throws InterruptedException{
    	fm.fnWebButton(driver, SavedSearch_Save, "Save");
    }
    public void SavedSearch_Search() throws InterruptedException{
    	fm.fnWebButton(driver, SavedSearch_Search, "Search");
    }
    public void SavedSearch_Delete() throws InterruptedException{
    	fm.fnWebButton(driver, SavedSearch_Delete, "Delete");
    }
    public void SavedSearch_Clear() throws InterruptedException{
    	fm.fnWebButton(driver, SavedSearch_Clear, "Clear");
    }
    public void SavedSearch_Close() throws InterruptedException {
		fm.fnWebButton(driver, SavedSearch_Close, "Close");
	}
}
