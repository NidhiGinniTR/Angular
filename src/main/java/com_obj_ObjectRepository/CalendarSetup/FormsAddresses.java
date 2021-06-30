package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class FormsAddresses extends ExtentManager {
	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;
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
	
}
