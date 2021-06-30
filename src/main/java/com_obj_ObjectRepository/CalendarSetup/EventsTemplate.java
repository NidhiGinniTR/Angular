package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class EventsTemplate extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;

	// -------------------------------Event Template Search
	// Criteria------------------
	By CalSetup_EventTemplate_EventTemplateName = By.xpath("//*[@id='tce_event_name']");
	By CalSetup_EventTemplate_EventDescription = By.xpath("//*[@id='tce_event_description']");
	By CalSetup_EventTemplate_TaxType = By.xpath("//*[@id='tax_type_id']");
	By CalSetup_EventTemplate_Country = By.xpath("//*[@id='tcj_country_id']");
	By CalSetup_EventTemplate_State = By.xpath("//*[@id='tcj_state_province_id']");
	By CalSetup_EventTemplate_Category = By.xpath("//*[@id='tcj_category_id']");
	By CalSetup_EventTemplate_JurisdictionCode = By.xpath("//*[@id='tcj_code']");
	By CalSetup_EventTemplate_AuthorityName = By.xpath("//*[@id='tcau_authority_name1']");
	By CalSetup_EventTemplate_Form = By.cssSelector("#form_no");
	By CalSetup_EventTemplate_FormType = By.xpath("//*[@id='form_type_id']");
	By CalSetup_EventTemplate_Available = By.xpath("//*[@id='tce_visible']");
	By CalSetup_EventTemplate_Obsolete = By.xpath("//*[@id='tce_obsolete']");
	// ------------------------------Event Template Add
	// New--------------------------
	By CalSetup_Event_Template_ANET_EventTemplateName = By.xpath("//input[@id='txtRow1Col1']");
	By CalSetup_Event_Template_ANET_Description = By.xpath("//input[@id='txtRow2Col1']");
	By CalSetup_Event_Template_ANET_SearchFormAndAddress = By.xpath("//img[@id='imgLookupForms']");
	By CalSetup_Event_Template_ANET_AddressName = By.xpath("//select[@id='ddlRow9Col1Txt']");
	By CalSetup_Event_Template_ANET_RecurringEventChk = By.xpath("//input[@id='chkRow11Col1Row1Col1']");
	By CalSetup_Event_Template_ANET_AdjustDueDate = By.xpath("//select[@id='ddlRow11aCol1']");
	By CalSetup_Event_Template_ANET_Action = By.xpath("//select[@id='ddlRow12Col1']");
	By CalSetup_Event_Template_ANET_PaymentMethod = By.xpath("//select[@id='ddlRow13Col1']");
	By CalSetup_Event_Template_ANET_BasedOn = By.xpath("//select[@id='ddlRow1Col2']");
	By CalSetup_Event_Template_ANET_Frequency = By.xpath("//select[@id='ddlRow2Col2']");
	By CalSetup_Event_Template_ANET_UseMonths = By.xpath("//select[@id='ddlUseMonths']");
	By CalSetup_Event_Template_ANET_UseDays = By.xpath("//select[@id='ddlUseDays']");
	By CalSetup_Event_Template_ANET_Months = By.xpath("//input[@id='txtRow3Col2Mon']");
	By CalSetup_Event_Template_ANET_Days = By.xpath("//input[@id='txtRow2Col2Day']");
	By CalSetup_Event_Template_ANET_Add = By.xpath("//input[@id='cmdadd']");
	By CalSetup_Event_Template_ANET_Replace = By.xpath("//input[@id='cmdReplace']");
	By CalSetup_Event_Template_ANET_Remove = By.xpath("//input[@id='cmdRemove']");
	By CalSetup_Event_Template_ANET_SelectedDates = By.xpath("//select[@id='lstRow4Col2dd']");
	By CalSetup_Event_Template_ANET_AdjustDueDateToLastDayOfMonth = By.xpath("//input[@id='chkRow6Col2']");
	By CalSetup_Event_Template_ANET_ForPrecedingTaxYear = By.xpath("input[@id='chkRow7Col2']");
	By CalSetup_Event_Template_ANET_TaxYearForSchedulingIsBasedOn = By.xpath("//select[@id='ddlRow7bCol1']");
	By CalSetup_Event_Template_ANET_FirstExtensionMonthsChk = By.xpath("//input[@id='txtRow4Col2ex']");
	By CalSetup_Event_Template_ANET_FirstExtensionDaysChk = By.xpath("//input[@id='txtRow4Col3ex']");
	By CalSetup_Event_Template_ANET_FirstExtensionADDTLDOMChk = By.xpath("//input[@id='chkext1Row4Col4']");
	By CalSetup_Event_Template_ANET_SecondExtensionMonthsChk = By.xpath("//input[@id='txtRow5Col2ex']");
	By CalSetup_Event_Template_ANET_SecondExtensionDaysChk = By.xpath("//input[@id='txtRow5Col3ex']");
	By CalSetup_Event_Template_ANET_SecondExtensionADDTLDOMChk = By.xpath("//input[@id='chkext2Row5Col4']");
	By CalSetup_Event_Template_ANET_ThirdExtensionMonthsChk = By.xpath("//input[@id='txtRow6Col2ex']");
	By CalSetup_Event_Template_ANET_ThirdExtensionDaysChk = By.xpath("//input[@id='txtRow6Col3ex']");
	By CalSetup_Event_Template_ANET_ThirdExtensionADDTLDOMChk = By.xpath("//input[@id='chkext3Row6Col4']");
	By CalSetup_Event_Template_ANET_Notes = By.xpath("//textarea[@id='txtNotes']");
	By CalSetup_Event_Template_ANET_AvailableChk = By.xpath("//input[@id='chkVisible']");
	By CalSetup_Event_Template_ANET_ObsoleteChk = By.xpath("//input[@id='chkObsolete']");
	By CalSetup_Event_Template_ANET_SaveBtn = By.xpath("//input[@id='cmdSave']");
	By CalSetup_Event_Template_ANET_CancelBtn = By.xpath("//input[@id='cmdCancel']");

}
