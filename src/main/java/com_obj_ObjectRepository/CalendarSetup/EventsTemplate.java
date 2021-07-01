package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class EventsTemplate extends ExtentManager {

	WebDriver driver;
	
	Properties data;
	Properties template;
	
	public EventsTemplate(WebDriver driver, Properties data) {
		this.driver = driver;
		this.template = data;
	}

	// -------------------------------Event Template SearchCriteria------------------
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
	// ------------------------------Event Template AddNew--------------------------
	By CalSetup_EventTemplate_AddNew_EventTemplateName = By.xpath("//input[@id='txtRow1Col1']");
	By CalSetup_EventTemplate_AddNew_Description = By.xpath("//input[@id='txtRow2Col1']");
	By CalSetup_EventTemplate_AddNew_SearchFormAndAddress = By.xpath("//img[@id='imgLookupForms']");
	By CalSetup_EventTemplate_AddNew_AddressName = By.xpath("//select[@id='ddlRow9Col1Txt']");
	By CalSetup_EventTemplate_AddNew_RecurringEventChk = By.xpath("//input[@id='chkRow11Col1Row1Col1']");
	By CalSetup_EventTemplate_AddNew_AdjustDueDate = By.xpath("//select[@id='ddlRow11aCol1']");
	By CalSetup_EventTemplate_AddNew_Action = By.xpath("//select[@id='ddlRow12Col1']");
	By CalSetup_EventTemplate_AddNew_PaymentMethod = By.xpath("//select[@id='ddlRow13Col1']");
	By CalSetup_EventTemplate_AddNew_BasedOn = By.xpath("//select[@id='ddlRow1Col2']");
	By CalSetup_EventTemplate_AddNew_Frequency = By.xpath("//select[@id='ddlRow2Col2']");
	By CalSetup_EventTemplate_AddNew_UseMonths = By.xpath("//select[@id='ddlUseMonths']");
	By CalSetup_EventTemplate_AddNew_UseDays = By.xpath("//select[@id='ddlUseDays']");
	By CalSetup_EventTemplate_AddNew_Months = By.xpath("//input[@id='txtRow3Col2Mon']");
	By CalSetup_EventTemplate_AddNew_Days = By.xpath("//input[@id='txtRow2Col2Day']");
	By CalSetup_EventTemplate_AddNew_Add = By.xpath("//input[@id='cmdadd']");
	By CalSetup_EventTemplate_AddNew_Replace = By.xpath("//input[@id='cmdReplace']");
	By CalSetup_EventTemplate_AddNew_Remove = By.xpath("//input[@id='cmdRemove']");
	By CalSetup_EventTemplate_AddNew_SelectedDates = By.xpath("//select[@id='lstRow4Col2dd']");
	By CalSetup_EventTemplate_AddNew_AdjustDueDateToLastDayOfMonth = By.xpath("//input[@id='chkRow6Col2']");
	By CalSetup_EventTemplate_AddNew_ForPrecedingTaxYear = By.xpath("input[@id='chkRow7Col2']");
	By CalSetup_EventTemplate_AddNew_TaxYearForSchedulingIsBasedOn = By.xpath("//select[@id='ddlRow7bCol1']");
	By CalSetup_EventTemplate_AddNew_FirstExtensionMonthsChk = By.xpath("//input[@id='txtRow4Col2ex']");
	By CalSetup_EventTemplate_AddNew_FirstExtensionDaysChk = By.xpath("//input[@id='txtRow4Col3ex']");
	By CalSetup_EventTemplate_AddNew_FirstExtensionADDTLDOMChk = By.xpath("//input[@id='chkext1Row4Col4']");
	By CalSetup_EventTemplate_AddNew_SecondExtensionMonthsChk = By.xpath("//input[@id='txtRow5Col2ex']");
	By CalSetup_EventTemplate_AddNew_SecondExtensionDaysChk = By.xpath("//input[@id='txtRow5Col3ex']");
	By CalSetup_EventTemplate_AddNew_SecondExtensionADDTLDOMChk = By.xpath("//input[@id='chkext2Row5Col4']");
	By CalSetup_EventTemplate_AddNew_ThirdExtensionMonthsChk = By.xpath("//input[@id='txtRow6Col2ex']");
	By CalSetup_EventTemplate_AddNew_ThirdExtensionDaysChk = By.xpath("//input[@id='txtRow6Col3ex']");
	By CalSetup_EventTemplate_AddNew_ThirdExtensionADDTLDOMChk = By.xpath("//input[@id='chkext3Row6Col4']");
	By CalSetup_EventTemplate_AddNew_Notes = By.xpath("//textarea[@id='txtNotes']");
	By CalSetup_EventTemplate_AddNew_AvailableChk = By.xpath("//input[@id='chkVisible']");
	By CalSetup_EventTemplate_AddNew_ObsoleteChk = By.xpath("//input[@id='chkObsolete']");
	By CalSetup_EventTemplate_AddNew_Save = By.xpath("//input[@id='cmdSave']");
	By CalSetup_EventTemplate_AddNew_Cancel = By.xpath("//input[@id='cmdCancel']");
	
	//-------------------------------------------------------------------------------------
	FrameWork fm = new FrameWork();
	
	public void CalSetup_AddNewEventTemplate() {
		childTest = test.createNode("Description: Add New Event Template " + "<br>"
				+ "<<Screen Name: Calendar Setup -Event template -Add New Event Template >></br>");
		try {
				fm.fnWebButton(driver,CalSetup_EventTemplate_AddNew_Save ,"Save");
				String popuptext = driver.switchTo().alert().getText();
				if (popuptext.contains("Please fill in all required fields") || !popuptext.isEmpty()) {
					driver.switchTo().alert().accept();
					childTest.log(Status.PASS,
							"Verification: Click on Save without entering details'" + popuptext + "' Alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification: Click on Save without entering details, Alert/Message is missing");
				}
				fm.fnWebEdit(driver, CalSetup_EventTemplate_AddNew_EventTemplateName,data.getProperty("Eventtemplate_Name"), "Event Template Name");
				fm.fnWebEdit(driver, CalSetup_EventTemplate_AddNew_Description,data.getProperty("Eventtemplate_Description"), "Description");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_AdjustDueDate,data.getProperty("Eventtemplate_AdjustDueDate"), "Adjust Due Date");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_Action,data.getProperty("Eventtemplate_Action"), "Action");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_PaymentMethod,data.getProperty("Eventtemplate_PaymentMethod"), "Payment Method");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_BasedOn,data.getProperty("Eventtemplate_BasedOn"), "Based On");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_Frequency,data.getProperty("Eventtemplate_Frequency"), "Frequency");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_UseMonths,data.getProperty("Eventtemplate_UseMonths"), "Use_Month");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_UseDays,data.getProperty("Eventtemplate_UseDays"), "Use_Days");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_Months,data.getProperty("Eventtemplate_Months"), "Months");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_Days,data.getProperty("Eventtemplate_Days"), "Days");
				fm.fnWebButton(driver,CalSetup_EventTemplate_AddNew_Add ,"Add");
				fm.fnWebList(driver, CalSetup_EventTemplate_AddNew_TaxYearForSchedulingIsBasedOn,data.getProperty("Eventtemplate_TaxYearforschedulingisbasedon"), "Tax Year for scheduling is based on");
				fm.fnWebEdit(driver, CalSetup_EventTemplate_AddNew_Notes,data.getProperty("Eventtemplate_Notes"), "Notes");
				fm.fnWebButton(driver,CalSetup_EventTemplate_AddNew_Save ,"Save");
		}catch(Exception e) {
			childTest.fail(e);
		}
	}

}
