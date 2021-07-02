package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class FormsAddresses extends ExtentManager {
	WebDriver driver;
	
	Properties data;
	Properties template;
	
	public FormsAddresses(WebDriver driver,Properties data) {
		this.driver=driver;
		this.data=data;
	}
	//-------------------------------Forms Addresses Search Criteria------------------
	By CalSetup_FormsAddress_Country = By.xpath("//*[@id='tcj_country_id']");
	By CalSetup_FormsAddress_State = By.xpath("//*[@id='tcj_state_province_id']");
	By CalSetup_FormsAddress_Category = By.xpath("//*[@id='tcj_category_id']");
	By CalSetup_FormsAddress_JurisdictionCode = By.xpath("//*[@id='tcj_code']");
	By CalSetup_FormsAddress_AuthorityName = By.xpath("//*[@id='tcau_authority_name1']");
	By CalSetup_FormsAddress_Form = By.xpath("//*[@id='form_no']");
	By CalSetup_FormsAddress_FormType = By.xpath("//*[@id='form_type_id']");
	By CalSetup_FormsAddress_FormTaxType = By.xpath("//*[@id='tax_type_id']");
	By CalSetup_FormsAddress_FormEntityType = By.xpath("//*[@id='entity_type_id']");
	By CalSetup_FormsAddress_AddressName = By.xpath("//*[@id='address_name']");
	By CalSetup_FormsAddress_Available = By.xpath("//*[@id='visible']");
	//------------------------------Forms Addresses Add New-------------------------
	By CalSetup_FormsAddressAddNew_Authority = By.xpath("//*[@id='txtAuthority']");
	By CalSetup_FormsAddressAddNew_Form = By.xpath("//*[@id='txtFormNumber']");
	By CalSetup_FormsAddressAddNew_FormType = By.xpath("//*[@id='ddlFormType']");
	By CalSetup_FormsAddressAddNew_FormTaxType = By.xpath("//*[@id='ddlTaxType']");
	By CalSetup_FormsAddressAddNew_FormEntityType = By.xpath("//*[@id='ddlEntityType']");
	By CalSetup_FormsAddressAddNew_PlusFormTaxType = By.xpath("//*[@id='imgAddTaxType']");
	By CalSetup_FormsAddressAddNew_MinusFormTaxType = By.xpath("//*[@id='imgRemoveTaxType']");
	By CalSetup_FormsAddressAddNew_SelectedTaxTypes = By.xpath("//*[@id='lstTaxType']");
	By CalSetup_FormsAddressAddNew_PlusFormEntityType = By.xpath("//*[@id='imgAddEntityType']");
	By CalSetup_FormsAddressAddNew_MinusFormEntityType = By.xpath("//*[@id='imgRemoveEntityType']");
	By CalSetup_FormsAddressAddNew_SelectedEntityTypes = By.xpath("//*[@id='lstEntityType']");
	By CalSetup_FormsAddressAddNew_FormRule = By.xpath("//*[@id='txtRule']");
	By CalSetup_FormsAddressAddNew_AddressName = By.xpath("//*[@id='txtAddressName']");
	By CalSetup_FormsAddressAddNew_Description = By.xpath("//*[@id='txtDescription']");
	By CalSetup_FormsAddressAddNew_AddressLabel1 = By.xpath("//*[@id='txtAuthorityLabel1]");
	By CalSetup_FormsAddressAddNew_AddressLabel2 = By.xpath("//*[@id='txtAuthorityLabel2']");
	By CalSetup_FormsAddressAddNew_Address1 = By.xpath("//*[@id='txtAddress1']");
	By CalSetup_FormsAddressAddNew_Address2 = By.xpath("//*[@id='txtAddress2']");
	By CalSetup_FormsAddressAddNew_Country = By.xpath("//*[@id='ddlCountry']");
	By CalSetup_FormsAddressAddNew_State = By.xpath("//*[@id='ddlState']");
	By CalSetup_FormsAddressAddNew_City = By.xpath("//*[@id='txtCity']");
	By CalSetup_FormsAddressAddNew_Zip = By.xpath("//*[@id='txtZip']");
	By CalSetup_FormsAddressAddNew_County = By.xpath("//*[@id='txtCountyParish']");
	By CalSetup_FormsAddressAddNew_MainPhone = By.xpath("//*[@id='txtPhone']");
	By CalSetup_FormsAddressAddNew_AlternatePhone = By.xpath("//*[@id='txtAltPhone']");
	By CalSetup_FormsAddressAddNew_Fax = By.xpath("//*[@id='txtFax']");
	By CalSetup_FormsAddressAddNew_Email = By.xpath("//*[@id='txtEmail']");
	By CalSetup_FormsAddressAddNew_EFillingAddress = By.xpath("//*[@id='txtEFilingAddress']");
	By CalSetup_FormsAddressAddNew_Notes = By.xpath("//*[@id='txtNotes']");
	By CalSetup_FormsAddressAddNew_Available = By.xpath("//*[@id='chkAvailable']");
	By CalSetup_FormsAddressAddNew_Save = By.xpath("//*[@id='btnOK']");
	By CalSetup_FormsAddressAddNew_Cancel = By.xpath("//*[@id='btnCancel']");
	
	//--------------------------------------------------------------------------------------
	FrameWork fm = new FrameWork();
	
	public void CalSetup_AddNewForsmAddress() {
		childTest = test.createNode("Description: Add New Forms Address " + "<br>"
				+ "<<Screen Name: Calendar Setup -Forms/Addresses -Add New >></br>");
		try {
			fm.fnWebButton(driver,CalSetup_FormsAddressAddNew_Save ,"Save");
			String popuptext = driver.switchTo().alert().getText();
			if (popuptext.contains("Please enter all required fields") || !popuptext.isEmpty()) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS,
						"Verification: Click on Save without entering details'" + popuptext + "' Alert/Message exists");
			} else {
				childTest.log(Status.ERROR,
						"Verification: Click on Save without entering details, Alert/Message is missing");
			}
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Authority ,data.getProperty("Authority_Name"),"Authority Name");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Form ,data.getProperty("FormsAddress_Form"),"Form");
			fm.fnWebList(driver,CalSetup_FormsAddressAddNew_FormType ,data.getProperty("FormsAddress_FormType"),"Form Type");
			fm.fnWebList(driver,CalSetup_FormsAddressAddNew_FormTaxType ,data.getProperty("FormsAddress_FormTaxType"),"Form Tax Type");
			fm.fnWebButton(driver,CalSetup_FormsAddressAddNew_PlusFormTaxType,"Add Tax Type");
			Thread.sleep(500);
			String text =getCalSetup_FormsAddressAddNew_SelectedTaxTypes();
			if(text.contains(data.getProperty("FormsAddress_FormTaxType"))) {
				childTest.log(Status.INFO,"Selected date '"+data.getProperty("FormsAddress_FormTaxType")+"' has been added");
			}else {
				childTest.log(Status.ERROR,"Selected date '"+data.getProperty("FormsAddress_FormTaxType")+"' has not been added");
			}
			fm.fnWebList(driver,CalSetup_FormsAddressAddNew_FormEntityType ,data.getProperty("FormsAddress_FormEntityType"),"Form Entity Type");
			fm.fnWebButton(driver,CalSetup_FormsAddressAddNew_PlusFormEntityType,"Add Form Entity Type");
			Thread.sleep(500);
			String text1 =getCalSetup_FormsAddressAddNew_SelectedEntityTypes();
			if(text1.contains(data.getProperty("FormsAddress_FormEntityType"))) {
				childTest.log(Status.INFO,"Selected date '"+data.getProperty("FormsAddress_FormEntityType")+"' has been added");
			}else {
				childTest.log(Status.ERROR,"Selected date '"+data.getProperty("FormsAddress_FormEntityType")+"' has not been added");
			}
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_FormRule ,data.getProperty("FormsAddress_FormRule"),"Form Rule");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_AddressName ,data.getProperty("FormsAddress_AddressName"),"Address Name");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Description ,data.getProperty("FormsAddress_Description"),"Description");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_AddressLabel1 ,data.getProperty("FormsAddress_Address Label 1"),"Address label 1");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_AddressLabel2 ,data.getProperty("FormsAddress_Address Label 2"),"Address label 2");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Address1 ,data.getProperty("FormsAddress_Address1"),"Address1");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Address2 ,data.getProperty("FormsAddress_Address2"),"Address2");
			fm.fnWebList(driver,CalSetup_FormsAddressAddNew_Country ,data.getProperty("FormsAddress_Country"),"Country");
			fm.fnWebList(driver,CalSetup_FormsAddressAddNew_State ,data.getProperty("FormsAddress_State"),"State");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_City ,data.getProperty("FormsAddress_Address2"),"City");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Zip ,data.getProperty("FormsAddress_Address2"),"Zip");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_County ,data.getProperty("FormsAddress_Address2"),"County");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_MainPhone ,data.getProperty("FormsAddress_Address2"),"Main Phone");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_AlternatePhone ,data.getProperty("FormsAddress_Address2"),"Alternate Phone");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Fax ,data.getProperty("FormsAddress_Address2"),"Fax");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Email ,data.getProperty("FormsAddress_Address2"),"Email");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_EFillingAddress ,data.getProperty("FormsAddress_Address2"),"E-Filling Address");
			fm.fnWebEdit(driver,CalSetup_FormsAddressAddNew_Notes ,data.getProperty("FormsAddress_Address2"),"Notes");
			fm.fnWebButton(driver,CalSetup_FormsAddressAddNew_Save ,"Save");
			String popuptext1 = driver.switchTo().alert().getText();
			if (popuptext1.contains("The Form/Address has been successfully saved") || !popuptext.isEmpty()) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS,
						"Verification: Click on Save after entering details'" + popuptext1 + "' Alert/Message exists");
			} else {
				childTest.log(Status.ERROR,
						"Verification: Click on Save after entering details, Alert/Message is missing");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}

	private String getCalSetup_FormsAddressAddNew_SelectedTaxTypes() {
		return driver.findElement(CalSetup_FormsAddressAddNew_SelectedTaxTypes).getText();
	}

	private String getCalSetup_FormsAddressAddNew_SelectedEntityTypes() {
		return driver.findElement(CalSetup_FormsAddressAddNew_SelectedEntityTypes).getText();
	}

	
	
}
