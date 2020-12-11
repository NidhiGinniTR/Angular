package com_obj_ObjectRepository.OWM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com_lib_FunctionLibrary.FrameWork;

public class WorkFlowBrowser {
	WebDriver driver;
	FrameWork fm = new FrameWork();

	public WorkFlowBrowser(WebDriver driver) {
		this.driver = driver;
	}

	// ---------------New Folder
	// Page-----------------------------------------------------------------------------
	By nf_Year = By.xpath("//*[@id='ctlval_fldr_4']");
	By nf_TaxType = By.xpath("//*[@id='ctlval_fldr_6']");
	By nf_Period = By.xpath("//*[@id='ctlval_fldr_5']");
	By nf_WFTemplate = By.xpath("//*[@id='ctlval_fw_workflow_template_id']");
	By nf_EntityName = By.xpath("//*[@id='ctlval_wf_14']");
	By nf_EntityID = By.xpath("//*[@id='ctlval_wf_15']");
	By nf_Jurisdiction = By.xpath("//*[@id='ctlval_wf_17']");
	By nf_SaveOK = By.xpath("//*[@id='btnOK']");

	public void newfolderYear(String temp) throws InterruptedException {
		fm.fnWebList(driver, nf_Year, temp, "Year");
	}

	public void newfolderPeriod(String temp) throws InterruptedException {
		fm.fnWebList(driver, nf_Period, temp, "Period");
	}

	public void newfolderTaxtype(String temp) throws InterruptedException {
		fm.fnWebList(driver, nf_TaxType, temp, "TaxType");
	}

	public void newfolderWFTemplate(String temp) throws InterruptedException {
		fm.fnWebList(driver, nf_WFTemplate, temp, "WorkFlow Template");
	}

	public void newfolderEntityName(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, nf_EntityName, temp, "EntityName");
	}

	public void newfolderEntityID(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, nf_EntityID, temp, "Entity ID");
	}

	public void newfolderJurisdiction(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, nf_Jurisdiction, temp, "Jurisdiction");
	}

	public void newfolderSave() throws InterruptedException {
		fm.fnWebButton(driver, nf_SaveOK, "Save");
	}

	// ----------------Save
	// Preferences-----------------------------------------------------------------------------
	By SavePreforAll_notify = By.xpath("//*[@id='chkNotify']");
	By SavePreforAll_save = By.xpath("//*[@name='btnSave']");
	By SavePreforAll_cancel = By.xpath("//*[@name='btnCancel']");

	public void SavePreforAll_Save() throws InterruptedException {
		fm.fnWebButton(driver, SavePreforAll_save, "Save");
	}

	public void SavePreforAll_Cancel() throws InterruptedException {
		fm.fnWebButton(driver, SavePreforAll_cancel, "Cancel");
	}

	public void SavePreforAll_Notify() throws InterruptedException {
		fm.fnWebCheckBox(driver, SavePreforAll_notify, "Notify by Email");
	}

	// ---------------Customize
	// View--------------------------------------------------------------------------------
	By CustView_Save = By.xpath("//input[@id='btnSave']");
	By CustView_Cancel = By.xpath("//input[@id='btnCancel']");

	public void Custview_Save() throws InterruptedException {
		fm.fnWebButton(driver, CustView_Save, "Save");
	}

	public void Custview_Cancel() throws InterruptedException {
		fm.fnWebButton(driver, CustView_Cancel, "Save");
	}

	// --------------New Rule Based
	// Workflow-------------------------------------------------------------------------
	By NewRuleBased_S1_EntityName = By.xpath("//input[@name='wf_14']");
	By NewRuleBased_S1_EntityID = By.xpath("//input[@name='wf_15']");
	By NewRuleBased_S1_Search = By.xpath("//input[@id='btnSearch']");
	By NewRuleBased_S1_Clear = By.xpath("//input[@id='btnCancel']");
	By NewRuleBased_S1_Next = By.xpath("//*[@id='cmdEntityNext']");
	By NewRuleBased_S1_Cancel = By.xpath("//*[@id='imgCancel']");
	By NewRuleBased_S1_WebTable = By.xpath("//DIV[@id='grd_SE_Entity_dom']/table[1]");
	By NewRuleBased_S2_WFTemplate = By.xpath("//input[@id='txtWFT']");
	By NewRuleBased_S2_TaxType = By.xpath("//select[@id='ddlTaxType']");
	By NewRuleBased_S2_Jurisdiction = By.xpath("//select[@id='ddlJurisdiction']");
	By NewRuleBased_S2_ServiceType = By.xpath("//select[@id='ddlServiceType']");
	By NewRuleBased_S2_WorlflowType = By.xpath("//select[@id='ddlWFType']");
	By NewRuleBased_S2_Search = By.xpath("//div[@id='divTCEventBrowserCrit']/TABLE[1]/TBODY[1]/TR[7]/TD[1]/IMG[1]");
	By NewRuleBased_S2_Clear = By.xpath("//div[@id='divTCEventBrowserCrit']/TABLE[1]/TBODY[1]/TR[7]/TD[1]/IMG[2]");
	By NewRuleBased_S2_WebTable = By.xpath("//div[@id='grd_SE_WF_dom']/table[1]");
	By NewRuleBased_S2_Previous = By.xpath("//img[@id='imgPreviousEvent']");
	By NewRuleBased_S2_Next = By.xpath("//img[@id='imgNextEvent']");
	By NewRuleBased_S2_Cancel = By.xpath("//div[@id='ViewsCallBackEventDiv']/TABLE[2]/TBODY[1]/TR[1]/TD[4]/IMG[1]");
	By NewRuleBased_S3_TaxYear = By.xpath("//select[@name='ctlstval_23_Tax_year']");
	By NewRuleBased_S3_TaxAcPeriodStartDate = By
			.xpath("//input[@name='ctlval_23_rb_Tax Accounting Period Start Date']");
	By NewRuleBased_S3_TaxAcPeriodEndDate = By.xpath("//input[@name='ctlval_23_rb_Tax Accounting Period End Date']");
	By NewRuleBased_S3_Year = By.xpath("//select[@name='ctlval_23_fldr_4']");
	By NewRuleBased_S3_Period = By.xpath("//select[@name='ctlval_23_fldr_5']");
	By NewRuleBased_S3_TaxType = By.xpath("//select[@name='ctlval_23_fldr_6']");
	By NewRuleBased_S3_Jurisdiction = By.xpath("//input[@name='ctlval_23_wf_17']");
	By NewRuleBased_S3_WorkFlowAssociation = By.xpath("//select[@name='ctlval_23_wf_18']");
	By NewRuleBased_S3_Description = By.xpath("//*[@name='ctlval_23_fw_workflow_name']");
	By NewRuleBased_S3_Previous = By
			.xpath("//DIV[@id='ViewsCallBackWFInstanceDiv']/TABLE[1]/TBODY[1]/TR[4]/TD[1]/IMG[1]");
	By NewRuleBased_S3_Finish = By.xpath("//img[@id='btnFinish']");
	By NewRuleBased_S3_Cancel = By
			.xpath("//div[@id='ViewsCallBackWFInstanceDiv']/TABLE[1]/TBODY[1]/TR[4]/TD[1]/IMG[3]");

	public void NewRuleBased_S1_Entityname(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S1_EntityName, temp, "Entity Name");
	}

	public void NewRuleBased_S1_Entityid(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S1_EntityID, temp, "Entity ID");
	}

	public void NewRuleBased_S1_search() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S1_Search, "Search");
	}

	public void NewRuleBased_S1_clear() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S1_Clear, "Clear");
	}

	public void NewRuleBased_S1_next() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S1_Next, "Next");
	}

	public void NewRuleBased_S1_cancel() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S1_Cancel, "Cancel");
	}

	public WebElement NewRuleBased_S1_webTable() throws InterruptedException {
		return driver.findElement(NewRuleBased_S1_WebTable);
	}

	public void NewRuleBased_S2_wfTemplate(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S2_WFTemplate, temp, "WFTemplate");
	}

	public void NewRuleBased_S2_Taxtype(String temp) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S2_TaxType, temp, "Tax Type");
	}

	public void NewRuleBased_S2_jurisdiction(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S2_Jurisdiction, text, "Jurisdiction");
	}

	public void NewRuleBased_S2_servicetype(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S2_ServiceType, text, "Service Type");
	}

	public void NewRuleBased_S2_Workflowtype(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S2_WorlflowType, text, "WorkFlow Type");
	}

	public void NewRuleBased_S2_search() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S2_Search, "Search");
	}

	public void NewRuleBased_S2_clear() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S2_Clear, "Clear");
	}

	public void NewRuleBased_S2_previous() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S2_Previous, "Previous");
	}

	public void NewRuleBased_S2_next() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S2_Next, "Next");
	}

	public void NewRuleBased_S2_cancel() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S2_Cancel, "Cancel");
	}

	public void NewRuleBased_S3_Taxyear(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S3_TaxYear, text, "Tax Year");
	}

	public void NewRuleBased_S3_TaxPeriodStartDate(String text) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S3_TaxAcPeriodStartDate, text, "Tax Account Period Start Date");
	}

	public void NewRuleBased_S3_TaxPeriodEndDate(String text) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S3_TaxAcPeriodEndDate, text, "Tax Account Period End Date");
	}

	public void NewRuleBased_S3_year(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S3_Year, text, "Year");
	}

	public void NewRuleBased_S3_period(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S3_Period, text, "Period");
	}

	public void NewRuleBased_S3_Taxtype(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S3_TaxType, text, "Tax Type");
	}

	public void NewRuleBased_S3_jurisdiction(String text) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S3_Jurisdiction, text, "Jurisdiction");
	}

	public void NewRuleBased_S3_WorkflowAssociation(String text) throws InterruptedException {
		fm.fnWebList(driver, NewRuleBased_S3_WorkFlowAssociation, text, "WorkFlow Association");
	}

	public void NewRuleBased_S3_description(String text) throws InterruptedException {
		fm.fnWebEdit(driver, NewRuleBased_S3_Description, text, "Description");
	}

	public void NewRuleBased_S3_previous() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S3_Previous, "Previous");
	}

	public void NewRuleBased_S3_finish() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S3_Finish, "Finish");
	}

	public void NewRuleBased_S3_cancel() throws InterruptedException {
		fm.fnWebButton(driver, NewRuleBased_S3_Cancel, "Cancel");
	}

	
}
