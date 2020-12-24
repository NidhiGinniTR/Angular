package com_obj_ObjectRepository.FolderWorkFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com_lib_FunctionLibrary.FrameWork;

public class Events {

		WebDriver driver;
		FrameWork fm = new FrameWork();

		public Events(WebDriver driver) {
			this.driver = driver;
		}
		
		// ---------------Events-----------------------------------------------------------------------------
		//By fwf_Events = By.xpath("//TABLE[@id='TabStrip1_1']");
		
		// ---------------Schedule New Events Page1-----------------------------------------------------------------------------
				By fwf_Events_SNE_EntityName = By.xpath("//INPUT[@id='tcet_bi_name']");
				By fwf_Events_SNE_EntityID = By.xpath("//INPUT[@id='tcet_bi_id']");
				By fwf_Events_SNE_Location = By.xpath("//SELECT[@id='location']");
				By fwf_Events_SNE_EntityGroup = By.xpath("//SELECT[@id='entity_group_name']");
				By fwf_Events_SNE_EntityType = By.xpath("//SELECT[@id='tcet_bi_entity_type_id']");
				By fwf_Events_SNE_Status = By.xpath("//SELECT[@id='tcet_bi_status_id']");
				By fwf_Events_SNE_GroupCosdes = By.xpath("//SELECT[@id='group_codes']");
				By fwf_Events_SNE_Search = By.xpath("//INPUT[@id='btnSearch']");
				By fwf_Events_SNE_Clear = By.xpath("//INPUT[@id='btnCancel']");
				By fwf_Events_SNE_Next = By.xpath("//INPUT[@id='cmdEntityNext']");
				By fwf_Events_SNE_Cancel1 = By.xpath("//IMG[@id='imgCancel']");
			
				public void fwf_Events_SNE_EntityName(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_EntityName, temp, "Entity Name");
				}
				
				public void fwf_Events_SNE_EntityID(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_EntityID, temp, "Entity ID");
				}
				
				public void fwf_Events_SNE_Location(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Location, temp, "Location");
				}
				
				public void fwf_Events_SNE_EntityGroup(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_EntityGroup, temp, "Entity Group");
				}
				
				public void fwf_Events_SNE_EntityType(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_EntityType, temp, "Entity Type");
				}
				
				public void fwf_Events_SNE_Status(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Status, temp, "Status");
				}
				
				public void fwf_Events_SNE_GroupCosdes(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_GroupCosdes, temp, "Group Codes");
				}
				
				public void fwf_Events_SNE_Search() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Search, "Search");
				}
				
				public void fwf_Events_SNE_Clear() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Clear, "Cancel");
				}
				
				public void fwf_Events_SNE_Next() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Next, "Next");
				}
				
				public void fwf_Events_SNE_Cancel1() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Cancel1, "Cancel");
				}
				//DIV[@id="grd_SE_Entity_dom"]/TABLE[1]
				
				// ---------------Schedule New Events Page2-----------------------------------------------------------------------------
				By fwf_Events_SNE_EventTemplateName = By.xpath("//INPUT[@id='tce_event_name']");
				By fwf_Events_SNE_EventDescription = By.xpath("//INPUT[@id='tce_event_description']");
				By fwf_Events_SNE_TaxType = By.xpath("//SELECT[@id='tax_type_id']");
				By fwf_Events_SNE_FormEntityType = By.xpath("//SELECT[@id='entity_type_id']");
				By fwf_Events_SNE_Country_Region = By.xpath("//SELECT[@id='tcj_country_id']");
				By fwf_Events_SNE_State_Province = By.xpath("//SELECT[@id='tcj_state_province_id']");
				By fwf_Events_SNE_Category = By.xpath("//SELECT[@id='tcj_category_id']");
				By fwf_Events_SNE_JurisdictionCode = By.xpath("//INPUT[@id='tcj_code']");
				By fwf_Events_SNE_AuthorityName = By.xpath("//INPUT[@id='tcau_authority_name1']");
				By fwf_Events_SNE_Form = By.xpath("//INPUT[@id='form_no']");
				By fwf_Events_SNE_FormType = By.xpath("//SELECT[@id='form_type_id']");
				By fwf_Events_SNE_Next2 = By.xpath("//INPUT[@id='imgNextEvent']");
				By fwf_Events_SNE_Previous = By.xpath("//INPUT[@id='imgPreviousEvent']");
				By fwf_Events_SNE_Cancel2 = By.xpath("//INPUT[@id='Image2']");
				By fwf_Events_SNE_EventTemplateWebTable = By.xpath("//*[@id='grd_SE_Event_cell_0_1']");
				
				public void fwf_Events_SNE_EventTemplateWebTable() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_EventTemplateWebTable,"Event Template Name WebTable");
				}
				
				public void fwf_Events_SNE_EventTemplateName(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_EventTemplateName, temp, "Event Template Name");
				}
				
				public void fwf_Events_SNE_EventDescription(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_EventDescription, temp, "Entity Description");
				}
				
				public void fwf_Events_SNE_TaxType(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_TaxType, temp, "Tax Type");
				}
				
				public void fwf_Events_SNE_FormEntityType(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_FormEntityType, temp, "Form Entity Type");
				}
				
				public void fwf_Events_SNE_Country_Region(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Country_Region, temp, "Country/Region");
				}
				
				public void fwf_Events_SNE_State_Province(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_State_Province, temp, "State/Province");
				}
				
				public void fwf_Events_SNE_Category(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Category, temp, "Category");
				}
				
				public void fwf_Events_SNE_JurisdictionCode(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_JurisdictionCode, temp, "Jurisdiction Code");
				}
				
				public void fwf_Events_SNE_AuthorityName(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_AuthorityName, temp, "Authority Name");
				}
				
				public void fwf_Events_SNE_Form(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_SNE_Form, temp, "Form");
				}
				
				public void fwf_Events_SNE_FormType(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_FormType, temp, "Form Type");
				}
				
				public void fwf_Events_SNE_Next2() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Next2, "Next");
				}
				
				public void fwf_Events_SNE_Previous() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Previous, "Previous");
				}
				
				public void fwf_Events_SNE_Cancel2() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Cancel2, "Cancel");
				}
				
				//DIV[@id='grd_SE_Event_dom']/TABLE[1]
				
				// ---------------Schedule New Events Page3-----------------------------------------------------------------------------
				By fwf_Events_SNE_OverallResponsibility = By.xpath("//SELECT[@id='ddlOverallResp']");
				By fwf_Events_SNE_OverallResponsibilityCkBx = By.xpath("//INPUT[@id='chkOverallResp']");
				By fwf_Events_SNE_AssignedTo = By.xpath("//SELECT[@id='ddlAssignedTo']");
				By fwf_Events_SNE_AssignedToCkBx = By.xpath("//INPUT[@id='chkAssignedTo']");
				By fwf_Events_SNE_TaxAcct = By.xpath("//SELECT[@id='ddlResponsible1']");
				By fwf_Events_SNE_TaxAcctCkBx = By.xpath("//INPUT[@id='chkResponsible1']");
				By fwf_Events_SNE_Responsibility3 = By.xpath("//SELECT[@id='ddlResponsible3']");
				By fwf_Events_SNE_Responsibility3CkBx = By.xpath("//INPUT[@id='chkResponsible3']");
				By fwf_Events_SNE_Manager = By.xpath("//SELECT[@id='ddlResponsible2']");
				By fwf_Events_SNE_ManagerCkBx = By.xpath("//INPUT[@id='chkResponsible2']");
				By fwf_Events_SNE_Responsibility4 = By.xpath("//SELECT[@id='ddlResponsible4']");
				By fwf_Events_SNE_Responsibility4CkBx = By.xpath("//INPUT[@id='chkResponsible4']");
				By fwf_Events_SNE_Responsibility5 = By.xpath("//SELECT[@id='ddlResponsible5']");
				By fwf_Events_SNE_Responsibility5CkBx = By.xpath("//INPUT[@id='chkResponsible5']");
				By fwf_Events_SNE_Responsibility6 = By.xpath("//SELECT[@id='ddlResponsible6']");
				By fwf_Events_SNE_Responsibility6CkBx = By.xpath("//INPUT[@id='chkResponsible6']");
				By fwf_Events_SNE_Previous3 = By.xpath("//IMG[@id='imgPreviousResp']");
				By fwf_Events_SNE_Next3 = By.xpath("//INPUT[@id='imgNextResp']");
				By fwf_Events_SNE_Cancel3 = By.xpath("//INPUT[@id='Img5']");
				By fwf_Events_SNE_Finish = By.xpath("//INPUT[@id='img1']");
				
				public void fwf_Events_SNE_OverallResponsibility(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_OverallResponsibility, temp, "Overall Responsibility");
				}
				
				public void fwf_Events_SNE_OverallResponsibilityCkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_OverallResponsibilityCkBx,"Overall ResponsibilityCkBx");
				}
				
				public void fwf_Events_SNE_AssignedTo(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_AssignedTo, temp, "Assigned To");
				}
				
				public void fwf_Events_SNE_AssignedToCkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_AssignedToCkBx,"Assigned ToCkBx");
				}
				
				public void fwf_Events_SNE_TaxAcct(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_TaxAcct, temp, "Tax Acct");
				}
				
				public void fwf_Events_SNE_TaxAcctCkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_TaxAcctCkBx,"Tax AcctCkBx");
				}
				
				public void fwf_Events_SNE_Responsibility3(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Responsibility3, temp, "Responsibility3");
				}
				
				public void fwf_Events_SNE_Responsibility3CkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_Responsibility3CkBx,"Responsibility3CkBx");
				}
				
				public void fwf_Events_SNE_Manager(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Manager, temp, "Manager");
				}
				
				public void fwf_Events_ManagerCkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_ManagerCkBx,"ManagerCkBx");
				}
				
				public void fwf_Events_SNE_Responsibility4(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Responsibility4, temp, "Responsibility4");
				}
				
				public void fwf_Events_SNE_Responsibility4CkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_Responsibility4CkBx,"Responsibility4CkBx");
				}
				
				public void fwf_Events_SNE_Responsibility5(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Responsibility5, temp, "Responsibility5");
				}
				
				public void fwf_Events_SNE_Responsibility5CkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_Responsibility5CkBx,"Responsibility5CkBx");
				}
				
				public void fwf_Events_SNE_Responsibility6(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_SNE_Responsibility6, temp, "Responsibility6");
				}
				
				public void fwf_Events_SNE_Responsibility6CkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_SNE_Responsibility6CkBx,"Responsibility6CkBx");
				}
				
				public void fwf_Events_SNE_Next3() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Next3, "Next");
				}
				
				public void fwf_Events_SNE_Previous3() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Previous3, "Previous");
				}
				
				public void fwf_Events_SNE_Cancel3() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Cancel3, "Cancel");
				}
				
				public void fwf_Events_SNE_Finish() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_Finish, "Finish");
				}
				
				//-------------------------------------------------------------------------------------------------------------------------------------
				By fwf_Events_SNE_EventWebCheckbox = By.xpath("//*[@id='chkEntityEvent']");
				
				public void fwf_Events_SNE_EventWebCheckbox() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_SNE_EventWebCheckbox, "Event Checkbox");
				}
				
				//DIV[@id='grd_SE_Entity_Event_dom']/TABLE[1]
				
				// ---------------Extend Events-----------------------------------------------------------------------------
				By fwf_Events_ScheduleExtension = By.xpath("//INPUT[@id='btnScheduleExtension']");
				
				public void fwf_Events_SNE_ScheduleExtension() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_ScheduleExtension, "Schedule Extension");
				}
				
				// ---------------Edit Schedule Event-----------------------------------------------------------------------------
				By fwf_Events_ESE_Status = By.xpath("//SELECT[@id='ddlStatusWS']");
				By fwf_Events_ESE_Priority = By.xpath("//SELECT[@id='ddlPriorityWS']");
				By fwf_Events_ESE_OWM_W_F_Template = By.xpath("//INPUT[@id='txtRelatedToWF']");
				By fwf_Events_ESE_NotifyCkBx = By.xpath("//IMG[@id='chkNotifyAssigned_mcbox']");
				By fwf_Events_Save = By.xpath("//INPUT[@id='btnSave']");
				
				public void fwf_Events_ESE_Status(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_ESE_Status, temp, "Status");
				}
				public void fwf_Events_ESE_Priority(String temp) throws InterruptedException {
					fm.fnWebList(driver, fwf_Events_ESE_Priority, temp, "Priority");
				}
				
				public void fwf_Events_ESE_OWM_W_F_Template(String temp) throws InterruptedException {
					fm.fnWebEdit(driver, fwf_Events_ESE_OWM_W_F_Template, temp, "W/F Template");
				}
				
				public void fwf_Events_ESE_NotifyCkBx() throws InterruptedException {
					fm.fnWebCheckBox(driver, fwf_Events_ESE_NotifyCkBx,"NotifyCkBx");
				}
				
				public void fwf_Events_Save() throws InterruptedException {
					fm.fnWebButton(driver, fwf_Events_Save, "Save");
				}
			// ---------------Roll Forward-----------------------------------------------------------------------------
			//DIV[@id='grd_Rollover_dom']/TABLE[1]
	}

