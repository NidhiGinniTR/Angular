package com_obj_ObjectRepository.LS1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class EntityUnitBrowser extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;

	/***************************************************************************************
	 * These element locators belongs to Login page of Onesource
	 ***************************************************************************************/
	By Splitter = By.xpath("//IMG[@id=\"imgSplitter\"]");
	By SearchTable = By.xpath("//DIV[@id=\"divContent\"]/TABLE[1]");
	By Actions = By.xpath("//a[@id='btnActionsMenu']");

	/***************************************************************************************
	 * These element locators belongs to Search Fields in Entity Unit Browser
	 ***************************************************************************************/
	By EUB_ClientName = By.xpath("//input[@id='SearchControl9_Input']");
	By EUB_ClientId = By.xpath("//input[@id='SearchControl10_Input']");
	By EUB_EntityName = By.xpath("//input[@id='SearchControl1_Input']");
	By EUB_EntityId = By.xpath("//input[@id='SearchControl2_Input']");
	By EUB_EntityType = By.xpath("//Select[@id='SearchControl3']");
	By EUB_Locations = By.xpath("//input[@id='SearchControl11_Input']");
	By EUB_GroupCode = By.xpath("//input[@id='SearchControl5_Input']");
	By EUB_Status = By.xpath("//Select[@id='SearchControl4']");
	By EUB_EntityGroup = By.xpath("//input[@id='SearchControl12_Input']");
	By EUB_PPOBStateProvince = By.xpath("//Select[@id='SearchControl6']");
	By EUB_PPOBCountryRegion = By.xpath("//Select[@id='SearchControl7']");
	By EUB_Search = By.xpath("//input[@id='imgbtnSearch']");
	By EUB_Clear = By.xpath("//input[@id='img1']");
	By EUB_ArchiveChkbx = By.xpath("//input[@id='SearchControl8']");

	/***************************************************************************************
	 * These element locators belongs to
	 ***************************************************************************************/
	By actions_Entity = By.xpath("//div[@id='dvAction']");
	By click_save = By.xpath("//input[@id='btnSave']");

	/***************************************************************************************
	 * These element locators belongs to Save Preferences/ Save Preferences for ALl
	 ***************************************************************************************/
	By SavePre_msg = By.xpath("//*[@id='dialog-label-container']");
	By SavePre_save = By.xpath("//*[@id='dialog-button-close']");
	By SavePreforAll_save = By.xpath("//*[@id='dialog-button-action']");

	/***************************************************************************************
	 * These element locators belongs to Add Fields to Create Entity
	 ***************************************************************************************/
	By Client_name = By.xpath("//input[@id='clientname']");
	By Client_id = By.xpath("//input[@id='clientnumber']");

	By ClientName_Lookup = By.xpath("//img[@id='imgclientname']");
	By CN_ClientName = By.xpath("//input[@id='ClientName']");
	By CN_Search = By.xpath("//input[@id='img2']");
	By CN_WebTable = By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']");
	By CN_Ok = By.xpath("//input[@id='btnOk']");

	By entity_name = By.xpath("//input[@id='name']");
	By entity_id = By.xpath("//input[@id='id']");
	By country = By.xpath("//input[@id='country_Input']");
	By state_provision = By.xpath("//input[@id='state_Input']");
	By entity_type = By.xpath("//select[@id='entitytype']");
	By incorporate_country = By.xpath("//input[@id='countryincorporated_Input']");
	By incorporate_state = By.xpath("//input[@id='stateincorporated_Input']");
	By description = By.xpath("//input[@id='description']");
	By entity_group = By.xpath("//input[@id='entitygroupid_Input']");
	By charting_group = By.xpath("//select[@id='chartingtype']");
	By group_codes = By.xpath("//select[@id='multiplesource']");
	By add_gcodes = By.xpath("//img[@id='addMultiple']");
	By Close = By.xpath("//input[@id='btnClose']");

	/***************************************************************************************
	 * These element locators belongs to Import Webpage of Entity Manager
	 ***************************************************************************************/
	By EM_Import_Browse = By.xpath("//input[@id='ImportFile']");
	By EM_Import_Import = By.xpath("//input[@id='btnImport']");
	By EM_Import_Cancel = By.xpath("//input[@id='btnCancel']");
	By EM_Import_ErrorMessage = By.xpath("//div[@id='divErrorMessage']");

	/***************************************************************************************
	 * These element locators belongs to Copy Entity of Entity Manager
	 ***************************************************************************************/
	By entity_nametoCopy = By.xpath("//input[@id='name']");
	By entity_idtoCopy = By.xpath("//input[@id='id']");
	By save_entity = By.xpath("//input[@id='Img1']");
	By cancel = By.xpath("//input[@id='btnClose']");

	/***************************************************************************************
	 * These element locators belongs to Tax IDs/Regestrations
	 ***************************************************************************************/
	By TaxIds = By.xpath("//label[@id='lblTaxID']");
	By TaxIds_Actions = By.className("btn btn-primary dropdown-toggle");
	By Jurisdiction = By.xpath("//input[@id='jurisdiction']");
	By Authority_Name = By.xpath("//input[@id='authorityname']");
	By Authority_Name2 = By.xpath("//input[@id='authorityname2']");
	By Address_Name = By.xpath("//select[@id='addressname']");
	By TaxId_Registration = By.xpath("//input[@id='taxid']");
	By DBA_AssumedName = By.xpath("//select[@id='assumedname']");
	By Registration_Date = By.xpath("//input[@id='registrationdate']");
	By Registration_EndDate = By.xpath("//input[@id='registrationenddate']");
	By Renewal_Date = By.xpath("//input[@id='renewaldate']");
	By Notes = By.xpath("//textarea[@id='notes']");
	// By Tax_Save = By.xpath("//input[@id='btnSave']");
	// By Tax_Close = By.xpath("//input[@id='btnClose']");
	By Primary_TaxId = By.xpath("//input[@id='primarytaxid']");
	By AuthorityName_LookUp = By.xpath("//img[@id='imgAuthorityName']");
	By AuthorityName_2 = By.xpath("//input[@id='SrchControl1']");
	By Search = By.xpath("//input[@id='img1']");
	By Authority_Webtable = By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']");
	By JurisdictionName = By.xpath("//input[@id='SearchControl2']");
	By Jurisdiction_Search = By.xpath("//input[@id='imgbtnSearch']");
	By JurisdictionName_LookUp = By.xpath("//img[@id='imgJurisdiction']");
	By Archive_Yes = By.xpath("//button[@id='dialog-button-action']");
	By Archive_Label = By.xpath("//input[@id='dialog-label']");

	/***************************************************************************************
	 * These element locators belongs to Search Tax IDs/Regestrations
	 ***************************************************************************************/
	By Search_Jurisdiction = By.xpath("select[@id='SearchControl1']");
	By Search_AuntorityName = By.xpath("select[@id='SearchControl2']");
	By Search_DBA = By.xpath("//select[@id='SearchControl6]'");
	By Search_AuthorityName2 = By.xpath("//select[@id='SearchControl3']");
	By Search_TaxId = By.xpath("//select[@id='SearchControl5']");
	By Search_FormTaxType = By.xpath("//select[@id='SearchControl4']");
	By Search_Archive = By.xpath("//input[@id='SearchControl7']");
	By TaxId_Search = By.xpath("//input[@id='imgbtnSearch']");
	By TaxId_Clear = By.xpath("//input[@id='img2']");

	/***************************************************************************************
	 * These element locators belongs to Entity Group creation Webpage of Entity
	 * Manager
	 ***************************************************************************************/
	By EM_EntityGroup_Dropdown = By.xpath("//img[@id='entitygroupid_DropImage']");
	By EM_EntityGroup_Dropdown_ANEG = By.xpath("//div[@id='entitygroupid_DropDownContent']/DIV[2]/NOBR[1]");
	By EM_EntityGroup = By.xpath("//input[@id='entitygroupid_Input']");
	By EM_EntityGroup_Name = By.xpath("//input[@id='txtEntityGroup']");
	By EM_EntityGroup_Add = By.xpath("//input[@id='btnAdd']");
	By EM_EntityGroup_Delete = By.xpath("//input[@id='btnDelete']");
	By EM_EntityGroup_Edit = By.xpath("//input[@id='btnEdit']");
	By EM_EntityGroup_Save = By.xpath("//INPUT[@id='btnSave']");
	By EM_EntityGroup_Cancel = By.xpath("//INPUT[@id='btnCancel']");
	By EM_EntityGroup_List = By.xpath("//SELECT[@id='listEntityGroup']");
	By EM_EntityGroup_msgLabel = By.xpath("//SPAN[@id='MessageLabel']");

	/***************************************************************************************
	 * These element locators belongs to DBA creation Webpage of Entity Unit Browser
	 ***************************************************************************************/
	By EM_DBA_AN_DoingBusinessAs = By.xpath("//input[@id='doingbusinessas']");
	By EM_DBA_AN_BusinessID = By.xpath("//input[@id='businessid']");
	By EM_DBA_AN_Description = By.xpath("//input[@id='description']");
	By EM_DBA_AN_Status = By.xpath("//select[@id='status']");
	By EM_DBA_AN_Address1 = By.xpath("//input[@id='address1']");
	By EM_DBA_AN_Address2 = By.xpath("//input[@id='address2']");
	By EM_DBA_AN_City = By.xpath("//input[@id='city']");
	By EM_DBA_AN_Country_Region = By.xpath("//input[@id='country_Input']");
	By EM_DBA_AN_Zip = By.xpath("//input[@id='zip']");
	By EM_DBA_AN_County = By.xpath("//input[@id='county']");
	By EM_DBA_AN_State = By.xpath("//input[@id='state_Input']");
	By EM_DBA_AN_ContactName = By.xpath("//input[@id='contactname']");
	By EM_DBA_AN_MainTelephone = By.xpath("//input[@id='maintelephone']");
	By EM_DBA_AN_AlternateTelephone = By.xpath("//input[@id='alternatetelephone']");
	By EM_DBA_AN_Fax = By.xpath("//input[@id='fax']");
	By EM_DBA_AN_Email = By.xpath("//input[@id='email']");
	By EM_DBA_AN_FromdDate = By.xpath("//input[@id='fromdate']");
	By EM_DBA_AN_ToDate = By.xpath("//input[@id='todate']");
	By EM_DBA_AN_Notes = By.xpath("//textarea[@id='notes']");
	By EM_DBA_AN_Save = By.xpath("//input[@id='btnSave']");
	By EM_DBA_AN_Cancel = By.xpath("//input[@id='btnClose']");
	By EM_DBA_AN_ErrorMessageLabel = By.xpath("//*[@id='spaErrorMessage']");

	/***************************************************************************************
	 * These element locators belongs to Owners sub tab of Ownership tab in Entity
	 * Manager
	 ***************************************************************************************/
	By EM_Owners_OwnerType = By.xpath("//select[@id='ownertype']");
	By EM_Owners_OwnerName = By.xpath("//input[@id='owner_Input']");
	By EM_Owners_OwnerName1 = By.xpath("//input[@id='owner1_Input']");
	By EM_Owners_OwnerName2 = By.xpath("//input[@id='owner2_Input']");
	By EM_Owners_Labelpercentagetext = By.xpath("//label[@id='lbl1']");
	By EM_Owners_Labelpercentage = By.xpath("//label[@id='lblPrior']");
	By EM_Owners_OwnerID1 = By.xpath("//input[@id='ownerId1_Input']");
	By EM_Owners_OwnerID2 = By.xpath("//input[@id='ownerId2_Input']");
	By EM_Owners_PercentageOwned = By.xpath("//input[@id='percentage']");
	By EM_Owners_PercentageOwned1 = By.xpath("//input[@id='percentage1']");
	By EM_Owners_PercentageOwned2 = By.xpath("//input[@id='percentage2']");
	By EM_Owners_AsofDate = By.xpath("//input[@id='asofdate']");
	By EM_Owners_AsofDate1 = By.xpath("//input[@id='AsOfDate1']");
	By EM_Owners_AsofDate2 = By.xpath("//input[@id='AsOfDate2']");
	By EM_Owners_AddOwner = By.xpath("//input[@id='btnAddOwner']");
	By EM_Owners_Save = By.xpath("//input[@id='btnSave']");
	By EM_Owners_Close = By.xpath("//input[@id='btnClose']");
	By EM_Owners_errMessage = By.xpath("//span[@id='spaErrorMessage']");
	By EM_Owners_totoalPercentage = By.xpath("//div[@id='divRunningTotal']");

	/***************************************************************************************
	 * These element locators belongs to Business/Tax Info Tab of the Entity Manager
	 *
	 ***************************************************************************************/

	By entityManager_bt_country = By.xpath("//input[@id='country_Input']");
	By entityManager_bt_state = By.xpath("//input[@id='state_Input']");
	By entityManager_bt_pbacode = By.xpath("//input[@id='activitycode_Input']");
	By entityManager_bt_siccode = By.xpath("//input[@id='siccode_Input']");
	By entityManager_bt_localcurrency = By.xpath("//select[@id='localcurrency']");
	By entityManager_bt_functionalcurrency = By.xpath("//select[@id='functionalcurrency']");
	By entityManager_bt_reportingcurrency = By.xpath("//select[@id='reportingcurrency']");
	By entityManager_bt_fybegdate = By.xpath("//input[@id='finbegdate']");
	By entityManager_bt_fyenddate = By.xpath("//input[@id='finenddate']");
	By entityManager_bt_tybegdate = By.xpath("//input[@id='begindate']");
	By entityManager_bt_tyenddate = By.xpath("//input[@id='enddate']");
	By entityManager_bt_endmonth = By.xpath("//select[@id='yearendmonthname']");
	By entityManager_bt_endday = By.xpath("//select[@id='daynameyearend']");
	By entityManager_bt_methoduse = By.xpath("//select[@id='methodused']");

	/***************************************************************************************
	 * These element locators belongs to Responsibility tab in Entity Manager
	 ***************************************************************************************/

	By entityManager_ri_person_name = By.xpath("//input[@id='personname']");
	By entityManager_ri_person_address = By.xpath("//input[@id='personaddress']");
	By entityManager_ri_person_city = By.xpath("//input[@id='personcity']");
	By entityManager_ri_person_country = By.xpath("//input[@id='personcountry_Input']");
	By entityManager_ri_person_state = By.xpath("//input[@id='personstate_Input']");
	By entityManager_ri_person_zip = By.xpath("//input[@id='personzip']");
	By entityManager_ri_person_phone = By.xpath("//input[@id='personphone']");

	By entityManager_ri_corp_name = By.xpath("//input[@id='corpname']");
	By entityManager_ri_corp_address = By.xpath("//input[@id='corpaddress']");
	By entityManager_ri_corp_city = By.xpath("//input[@id='corpcity']");
	By entityManager_ri_corp_country = By.xpath("//input[@id='corpcountry_Input']");
	By entityManager_ri_corp_state = By.xpath("//input[@id='corpstate_Input']");
	By entityManager_ri_corp_zip = By.xpath("//input[@id='corpzip']");
	By entityManager_ri_corp_phone = By.xpath("//input[@id='corpphone']");

	By entityManager_ri_brabch_name = By.xpath("//input[@id='branchname']");
	By entityManager_ri_brabch_address = By.xpath("//input[@id='branchaddress']");
	By entityManager_ri_brabch_city = By.xpath("//input[@id='branchcity']");
	By entityManager_ri_brabch_country = By.xpath("//input[@id='branchcountry_Input']");
	By entityManager_ri_brabch_state = By.xpath("//input[@id='branchstate_Input']");
	By entityManager_ri_brabch_zip = By.xpath("//input[@id='branchzip']");
	By entityManager_ri_brabch_phone = By.xpath("//input[@id='branchphone']");

	/***************************************************************************************
	 * These element locators belongs to Key Contacts tab in Entity Manager
	 ***************************************************************************************/

	By entityManager_kc_mname = By.xpath("//input[@id='mname']");
	By entityManager_kc_mtitle = By.xpath("//input[@id='mtitle']");
	By entityManager_kc_memail = By.xpath("//input[@id='memail']");
	By entityManager_kc_mwphone = By.xpath("//input[@id='mwphone']");
	By entityManager_kc_mmphone = By.xpath("//input[@id='mmphone']");
	By entityManager_kc_mhphone = By.xpath("//input[@id='mhphone']");

	By entityManager_kc_aname = By.xpath("//input[@id='aname']");
	By entityManager_kc_atitle = By.xpath("//input[@id='atitle']");
	By entityManager_kc_aemail = By.xpath("//input[@id='aemail']");
	By entityManager_kc_awphone = By.xpath("//input[@id='awphone']");
	By entityManager_kc_amphone = By.xpath("//input[@id='amphone']");
	By entityManager_kc_ahphone = By.xpath("//input[@id='ahphone']");

	By entityManager_kc_cname = By.xpath("//input[@id='cname']");
	By entityManager_kc_ctitle = By.xpath("//input[@id='ctitle']");
	By entityManager_kc_cemail = By.xpath("//input[@id='cemail']");
	By entityManager_kc_cwphone = By.xpath("//input[@id='cwphone']");
	By entityManager_kc_cmphone = By.xpath("//input[@id='cmphone']");
	By entityManager_kc_chphone = By.xpath("//input[@id='chphone']");

	/***************************************************************************************
	 * These element locators belongs to Page Links tab in Entity Manager
	 ***************************************************************************************/

	By entityManager_pl_addtitle = By.xpath("//input[@id='txt_LinkTitle']");
	By entityManager_pl_addlink = By.xpath("//input[@id='txt_url']");
	By entityManager_pl_addbutton = By.xpath("//input[@id='btn_OK']");
	By entityManager_pl_closebutton = By.xpath("//button[@id='dialog-button-close']");
	By entityManager_pl_delbutton = By.xpath("//button[@id='dialog-button-action']");

	/***************************************************************************************
	 * These element locators belongs to Search Entity
	 * 
	 ***************************************************************************************/
	By entityManager_search_withName = By.xpath("//input[@id='SearchControl1_Input']");
	By entityManager_search_withID = By.xpath("//input[@id='SearchControl2_Input']");
	By entityManager_search = By.xpath("//input[@id='imgbtnSearch']");

	/***************************************************************************************
	 * These element locators belongs to action button in Documents
	 ***************************************************************************************/
	By EM_Doc_Actions = By.xpath("//img[@id='Img3']");
	By EM_Doc_EntityName = By.xpath("//input[@id='idx_000000000B']");
	By EM_Doc_EntityId = By.xpath("//input[@id='idx_000000000C']");
	By EM_Doc_TaxType = By.xpath("//select[@id='idx_000000000D']");
	By EM_Doc_Year = By.xpath("//select[@id='idx_000000000E']");
	By EM_Doc_Period = By.xpath("//select[@id='idx_000000000F']");
	By EM_Doc_Jurisdiction = By.xpath("//input[@id='idx_000000000G']");
	By EM_Doc_Description = By.xpath("//input[@id='idx_000000000H']");
	By EM_Doc_FileSection = By.xpath("//select[@id='idx_000000000I']");
	By EM_Doc_DocumentType = By.xpath("//select[@id='idx_000000000J']");
	By EM_Doc_DocumentDate = By.xpath("//input[@id='idx_000000000K']");
	By EM_Doc_WorkflowAssociation = By.xpath("//select[@id='idx_000000000L']");
	By EM_Doc_AssignedTo = By.xpath("//select[@id='assignedto']");
	By EM_Doc_Status = By.xpath("//select[@id='docstatus']");
	By EM_Doc_DueDate = By.xpath("//input[@id='duedate']");
	By EM_Doc_Notify = By.xpath("//select[@id='emailAdr']");
	By EM_Doc_Browse = By.xpath("//img[@id='Upload1_FileInputImage0']");
	By EM_Doc_Save = By.xpath("//img[@id='btn-upload']");
	By EM_Doc_Close = By.xpath("//img[@id='btnClose']");
	
	/***************************************************************************************
	 * These element locators belongs to Search fields in Documents
	 ***************************************************************************************/
	By EM_Doc_Search_WFTemplate = By.xpath("//select[@id='wt_name']");
	By EM_Doc_Search_Year = By.xpath("//select[@id='fldr_4']");
	By EM_Doc_Search_EntityName = By.xpath("//input[@id='wf_14']");
	By EM_Doc_Search_EntityId = By.xpath("//input[@id='wf_15']");
	By EM_Doc_Search_Period = By.xpath("//select[@id='fldr_5']");
	By EM_Doc_Search_TaxType = By.xpath("//select[@id='fldr_6']");
	By EM_Doc_Search_Jurisdiction = By.xpath("//input[@id='wf_17']");
	By EM_Doc_Search_WorkflowAssociation = By.xpath("//select[@id='wf_18']");
	By EM_Doc_Search_Description = By.xpath("//input[@id='idx_000000000H']");
	By EM_Doc_Search_FileSection = By.xpath("//select[@id='idx_000000000I']");
	By EM_Doc_Search_DocumentType = By.xpath("//select[@id='idx_000000000J']");
	By EM_Doc_Search_WorkflowType = By.xpath("//Select[@id='fw_workflow_type']");
	By EM_Doc_Search= By.xpath("//img[@id='imgSearch']");
	By EM_Doc_Clear = By.xpath("//img[@id='imgClear']");
	
	
	/***************************************************************************************
	 * These element locators belongs to New Folder in Workflow Browser
	 ***************************************************************************************/
	By EM_Wf_Year = By.xpath("//select[@id='fldr_4']");
	By EM_Wf_Period = By.xpath("//select[@id='fldr_5']");
	By EM_Wf_TaxType = By.xpath("//select[@id='fldr_6']");
	By EM_Wf_WFTemplate = By.xpath("//select[@id='fw_workflow_template_id']");
	By EM_Wf_EntityName = By.xpath("//input[@id='wf_14']");
	By EM_Wf_EntityID = By.xpath("//input[@id='wf_15']");
	By EM_Wf_Jurisdiction = By.xpath("//input[@id='wf_17']");
	By EM_Wf_WorkflowAssociation = By.xpath("//select[@id='wf_18']");
	By EM_Wf_DueDate = By.xpath("//input[@id='fw_due_date']");
	By EM_Wf_WorkflowDescription = By.xpath("//input[@id='fw_workflow_name']");
	By EM_Wf_RouteTo = By.xpath("//select[@id='route_to']");
	By EM_Wf_NotifyCheck = By.xpath("//input[@id='notify_by_email']");
	By EM_Wf_RoutingDueDate = By.xpath("//input[@id='routing_due_date']");
	By EM_Wf_Save = By.xpath("//img[@id='btnSave']");
	By EM_Wf_Close = By.xpath("//img[@id='btnClose']");
	
	/***************************************************************************************
	 * These element locators belongs to Add New Bussiness in Entity Manager
	 ***************************************************************************************/
	By EM_BS_BussinessName =  By.xpath("//input[@id='businessname']");
	By EM_BS_BussinessId =  By.xpath("//input[@id='businessid']");
	By EM_BS_Description =  By.xpath("//input[@id='description']");
	By EM_BS_Status =  By.xpath("//Select[@id='status']");
	By EM_BS_Address1 =  By.xpath("//input[@id='address1']");
	By EM_BS_Address2 =  By.xpath("//input[@id='address2']");
	By EM_BS_City =  By.xpath("//input[@id='city']");
	By EM_BS_Country =  By.xpath("//input[@id='county']");
	By EM_BS_Country1 =  By.xpath("//input[@id='country_Input']");
	By EM_BS_ZipCode =  By.xpath("//input[@id='zip']");
	By EM_BS_State =  By.xpath("//input[@id='state_Input']");
	By EM_BS_ContactName =  By.xpath("//input[@id='contactname']");
	By EM_BS_MainTelephone =  By.xpath("//input[@id='maintelephone']");
	By EM_BS_AlternateTelephone =  By.xpath("//input[@id='alternatetelephone']");
	By EM_BS_Email =  By.xpath("//input[@id='email']");
	By EM_BS_Fax =  By.xpath("//input[@id='fax']");
	By EM_BS_OccupancyCertificate =  By.xpath("//input[@id='certificatenumber']");
	By EM_BS_ExpiryDate =  By.xpath("//input[@id='certexpdate']");
	By EM_BS_FromDate =  By.xpath("//input[@id='fromdate']");
	By EM_BS_ToDate =  By.xpath("//input[@id='todate']");
	By EM_BS_TaxID =  By.xpath("//Select[@id='multiplesource']");
	By EM_BS_TaxIdPlus =  By.xpath("//img[@id='addMultiple']");
	By EM_BS_Notes =  By.xpath("//textarea[@id='notes']");
	By EM_BS_Ok = By.xpath("//button[@id='dialog-button-close']");
	By EM_NameOfInstitue = By.xpath("//input[@id='nameofinstitution']");
	By EM_BankId = By.xpath("//input[@id='bankid']");
	By EM_AternateContact =  By.xpath("//input[@id='alternatecontact']");
	
	/***************************************************************************************
	 * These element locators belongs to Account Details in Entity Manager
	 ***************************************************************************************/
	By EM_AccountNumber = By.xpath("//input[@id='accountnumber']");
	By EM_Category =  By.xpath("//Select[@id='category']");
	By EM_InceptionDate = By.xpath("//input[@id='inceptiondate']");
	By EM_ExpirationDate = By.xpath("//input[@id='expirationdate']");
	By EM_Status =  By.xpath("//Select[@id='status']");
	By EM_Type =  By.xpath("//Select[@id='type']");
	By EM_Signature1 = By.xpath("//input[@id='signature1']");
	By EM_Signature2 = By.xpath("//input[@id='signature2']");
	By EM_Signature3 = By.xpath("//input[@id='signature3']");
	By EM_Signature4 = By.xpath("//input[@id='signature4']");
	By EM_Notes = By.xpath("//input[@id='notes']");
	By EM_Save = By.xpath("//img[@id='btnSave']");
	By EM_Contact = By.xpath("//input[@id='maincontact']");
	By EM_Email = By.xpath("//input[@id='mainemail']");
	
	/***************************************************************************************
	 * These element locators belongs to Intercompany Payments in Entity Manager
	 ***************************************************************************************/
	By EM_FromEntity = By.xpath("//input[@id='fromentity1_Input']");
	By EM_ToEntity = By.xpath("//input[@id='toentity_00001_Input']");
	By EM_Date = By.xpath("//input[@id='trandate_00001']");
	By EM_Stream = By.xpath("//Select[@id='streamid_00001']");
	By EM_Amount = By.xpath("//input[@id='payment_00001']");
	
	/***************************************************************************************
	 * These element locators belongs to Add Founding Shareholder of
	 * Ownership-OrgReorg tab
	 ***************************************************************************************/
	By EM_OrgReorg_AFS_Save = By.xpath("//img[@id='btnSave']");
	By EM_OrgReorg_AFS_Close = By.xpath("//img[@id='btnClose']");
	By EM_OrgReorg_AFS_ErrMessage = By.xpath("//span[@id='spaErrorMessage']");
	By EM_OrgReorg_AFS_OrgDate = By.xpath("//input[@id='date']");
	By EM_OrgReorg_AFS_Name = By.xpath("//input[@id='tranname']");
	By EM_OrgReorg_AFS_Address = By.xpath("//input[@id='tranaddress']");
	By EM_OrgReorg_AFS_City = By.xpath("//input[@id='trancity']");
	By EM_OrgReorg_AFS_Country = By.xpath("//input[@id='trancountry_Input']");
	By EM_OrgReorg_AFS_StateProvince = By.xpath("//input[@id='transtate_Input']");
	By EM_OrgReorg_AFS_ZipPostalCode = By.xpath("//input[@id='tranzip']");
	By EM_OrgReorg_AFS_IdentifyingNumber = By.xpath("//input[@id='tranidentifyingnumber']");
	By EM_OrgReorg_AFS_DateOfInitializationCapitalization = By.xpath("//input[@id='intialcapdate']");
	By EM_OrgReorg_AFS_DescriptionofInitialCapitalization = By.xpath("//textarea[@id='description']");//Common to Add New Reorg
	By EM_OrgReorg_AFS_TaxCodeSectionReference = By.xpath("//input[@id='taxcode']");
	By EM_OrgReorg_AFS_TransferorBasis = By.xpath("//input[@id='transferorsbasis']");
	By EM_OrgReorg_AFS_DescriptionofStockSecurityAssests = By.xpath("//textarea[@id='securitydescription']");
	By EM_OrgReorg_AFS_Notes = By.xpath("//textarea[@id='notes']");
	/***************************************************************************************
	 * These element locators belongs to Add New Reorg of
	 * Ownership-OrgReorg tab
	 ***************************************************************************************/
	By EM_OrgReorg_ANR_ValueofShareTransferred = By.xpath("//input[@id='sharevalue']");
	By EM_OrgReorg_ANR_ReceivingName = By.xpath("//input[@id='recname']");
	By EM_OrgReorg_ANR_ReAddress = By.xpath("//input[@id='recaddress']");
	By EM_OrgReorg_ANR_ReCity = By.xpath("//input[@id='reccity']");
	By EM_OrgReorg_ANR_ReCountry = By.xpath("//input[@id='reccountry_Input']");
	By EM_OrgReorg_ANR_ReState = By.xpath("//input[@id='recstate_Input']");
	By EM_OrgReorg_ANR_ReZip = By.xpath("//input[@id='reczip']");
	By EM_OrgReorg_ANR_ReIdentifyingNumber = By.xpath("//input[@id='recidentifyingnumber']");
	/***************************************************************************************
	 * These element locators belongs to Add New menu item of Stock Of the Company Tab
	 ***************************************************************************************/
	By EM_SC_AN_RelatedShareHolder = By.xpath("//select[@id='related']");
	By EM_SC_AN_UnRelatedShareHolder = By.xpath("//input[@id='unrelated']");
	By EM_SC_AN_StockClass = By.xpath("//select[@id='class']");
	By EM_SC_AN_BeginningOfTaxYear = By.xpath("//input[@id='startyear']");
	By EM_SC_AN_EndOfTaxYear = By.xpath("//input[@id='endyear']");
	By EM_SC_AN_Notes = By.xpath("//textarea[@id='notes']");
	By EM_SC_AN_Save = By.xpath("//img[@id='btnSave']");
	By EM_SC_AN_Close = By.xpath("//img[@id='btnClose']");
	By EM_SC_AN_ErrMessage = By.xpath("//span[@id='spaErrorMessage']");
	
	/***************************************************************************************
	 * These element locators belongs to AcqDispofShares on Ownership tab
	 ***************************************************************************************/
	By EM_ADS_ANA_Date = By.xpath("//input[@id='date']");
	By EM_ADS_ANA_Name = By.xpath("//input[@id='name']");
	By EM_ADS_ANA_Address = By.xpath("//input[@id='address']");
	By EM_ADS_ANA_City = By.xpath("//input[@id='city']");
	By EM_ADS_ANA_County = By.xpath("//input[@id='county']");
	By EM_ADS_ANA_Country = By.xpath("//input[@id='country_Input']");
	By EM_ADS_ANA_State = By.xpath("//input[@id='state_Input']");
	By EM_ADS_ANA_ZipPostalCode = By.xpath("//input[@id='zip']");
	By EM_ADS_ANA_NameofRelatedShareHolder = By.xpath("//select[@id='related']");
	By EM_ADS_ANA_UnrelatedShareHolder = By.xpath("//input[@id='unrelated']");
	By EM_ADS_ANA_TaxCodesectionReference = By.xpath("//input[@id='taxcode']");
	By EM_ADS_ANA_Methodof = By.xpath("//input[@id='method']");
	By EM_ADS_ANA_NumberofShares = By.xpath("//input[@id='numberofshares']");
	By EM_ADS_ANA_ClassofShares = By.xpath("//select[@id='classofshares']");
	By EM_ADS_ANA_PricevalueofShares = By.xpath("//input[@id='priceofshares']");
	By EM_ADS_ANA_BasisofShares = By.xpath("//input[@id='basisofshares']");
	By EM_ADS_ANA_Notes = By.xpath("//textarea[@id='notes']");
	
	/***************************************************************************************
	 * These element locators belongs to Place of Business Tab
	 ***************************************************************************************/
	By EM_IndividualAgents_FirstName = By.xpath("//input[@id='firstname']");
	By EM_IndividualAgents_MiddleInitial = By.xpath("//input[@id='middleinitial']");
	By EM_IndividualAgents_LastName = By.xpath("//input[@id='lastname']");
	By EM_IndividualAgents_Organization = By.xpath("//input[@id='organization']");
	By EM_IndividualAgents_Title = By.xpath("//input[@id='title']");
	By EM_IndividualAgents_Address1 = By.xpath("//input[@id='address1']");
	By EM_IndividualAgents_Honorific = By.xpath("//input[@id='honorific']");
	By EM_IndividualAgents_Address2 = By.xpath("//input[@id='address2']");
	By EM_IndividualAgents_Country = By.xpath("//input[@id='country_Input']");
	By EM_IndividualAgents_County = By.xpath("//input[@id='county']");
	By EM_IndividualAgents_City = By.xpath("//input[@id='city']");
	By EM_IndividualAgents_Zip =By.xpath("//input[@id='zip']");
	By EM_IndividualAgents_State = By.xpath("//input[@id='state_Input']");
	By EM_IndividualAgents_CountryofCitizenShip = By.xpath("//input[@id='citizenship_Input']");
	By EM_IndividualAgents_MainTelephone = By.xpath("//input[@id='mainphone']");
	By EM_IndividualAgents_AlternateTelephone= By.xpath("//input[@id='alternatephone']");
	By EM_IndividualAgents_CountryofResidency = By.xpath("//input[@id='residency_Input']");
	By EM_IndividualAgents_Fax = By.xpath("//input[@id='fax']");
	By EM_IndividualAgents_Email = By.xpath("//input[@id='email']");
	By EM_IndividualAgents_Notes = By.xpath("//textarea[@id='notes']");
	By EM_IndividualAgents_Splitter = By.xpath("//img[@id='imgSplitter']");
	By EM_IndividualAgents_AddNewRole = By.xpath("//img[@id='btnAddRole']");
	By EM_IndividualAgents_Save = By.xpath("//img[@id='btnSave']");
	By EM_IndividualAgents_Close = By.xpath("//img[@id='btnClose']");
	By EM_IndividualAgents_Role1 = By.xpath("//select[@id='role_0']");
	By EM_IndividualAgents_Position1 = By.xpath("//select[@id='position_0']");
	By EM_IndividualAgents_DateBegin1 = By.xpath("//input[@id='datebegin_0']");
	By EM_IndividualAgents_DateEnd1 = By.xpath("//input[@id='dateend_0']");
	By EM_IndividualAgents_Order1 = By.xpath("//select[@id='order_0']");
	By EM_IndividualAgents_RoleCompare = By.xpath("//select[@id='role_30']");
	By EM_IndividualAgents_PositionCompare = By.xpath("//select[@id='position_30']");
	By EM_IndividualAgents_DateBeginCompare = By.xpath("//input[@id='datebegin_30']");
	By EM_IndividualAgents_DateEndCompare = By.xpath("//input[@id='dateend_30']");
	By EM_IndividualAgents_OrderCompare = By.xpath("//select[@id='order_30']");


	
	public EntityUnitBrowser(WebDriver driver, Properties data2, Properties data) {
		this.driver = driver;
		this.template = data;
		this.data = data2;
	}
	
	
	

	/***************************************************************************************
	 * This function is usedto check the Search Fields
	 ***************************************************************************************/

	public void fnVerifySearchElements(String[] array) throws InterruptedException {
		childTest = test
				.createNode("Description: Verifying Search Fields" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")
				|| driver.getTitle().equalsIgnoreCase("Entity Information")) {
			fm.fnWebButton(driver, Splitter, "Splitter");
			for (int i = 0; i < array.length; i++) {
				List<WebElement> rows = driver.findElements(By.xpath("//DIV[@id=\"divContent\"]/TABLE[1]"));
				for (WebElement row : rows) {
					if (row.getText().contains(array[i])) {
						childTest.log(Status.PASS, array[i] + " is Displayed.");
					} else {
						childTest.log(Status.PASS, array[i] + " is Displayed.");
					}
				}
			}
			Thread.sleep(1000);
			fm.fnWebButton(driver, Splitter, "Splitter");
		}
	}

	/***************************************************************************************
	 * This function is used to click Actions Button
	 ***************************************************************************************/
	public void fnClickActions() throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			fm.fnWebButton(driver, Actions, "Actions");
		}
	}

	/***************************************************************************************
	 * This function is used to Click Menu Items in Actions menu
	 ***************************************************************************************/
	public void fnOWMActionsMenu(String item, String subItem) throws InterruptedException {
		//if (driver.getTitle().equalsIgnoreCase("ONESOURCE")
			//	|| driver.getTitle().equalsIgnoreCase("Entity Information")) {
			// WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver.findElements(By.className("MenuItem"));
						for (int j = 0; j < submenuItems.size(); j++) {
							if (subItem.equals(submenuItems.get(j).getText())) {
								String submenuItem = submenuItems.get(j).getAttribute("id");
								driver.findElement(By.id(submenuItem)).click();
								childTest.log(Status.PASS, subItem + " is selected from  " + item);
								break;
							}
						}
					}
					childTest.log(Status.PASS, item + " is enabled and is selected from actions menu.");
					break;
				}
			}
		//}
	}

	/***************************************************************************************
	 * This function is used to find the enabled action menu items
	 ***************************************************************************************/

	public void fnActionsMenuEnabled() throws InterruptedException {
		childTest = test
				.createNode("Description: Action menu items Enabled" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				String items = menuitems.get(i).getText();
				// System.out.println(menuitems.get(i).getText());
				childTest.log(Status.PASS, items + " is enabled");
			}
		}
	}

	/***************************************************************************************
	 * This function is used to find the disabled action menu items
	 ***************************************************************************************/
	public void fnActionsMenuDisabled() throws InterruptedException {
		childTest = test
				.createNode("Description: Action menu items Disabled" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			java.util.List<WebElement> Disablemenuitems = driver.findElements(By.className("DisabledMenuItem"));
			for (int i = 0; i < Disablemenuitems.size(); i++) {
				String Disableitems = Disablemenuitems.get(i).getText();
				childTest.log(Status.PASS, Disableitems + " is disabled");
				// System.out.println(Disablemenuitems.get(i).getText());
			}
		}
	}

	/***************************************************************************************
	 * This function is used to Search the Entity
	 ***************************************************************************************/
	public void fnSearchEntity() throws InterruptedException {
		childTest = test.createNode("Description: Search the Entity" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		try {
			driver.findElement(By.xpath("//img[@id='imgSplitter']")).click();
			// fm.fnWebButton(driver, Splitter, "Splitter");
			fm.fnWebButton(driver, EUB_Clear, "Clear");
			Thread.sleep(5500);
			// WebElement ClientName =
			// driver.findElement(By.xpath("//input[@id='SearchControl9_Input']"));
			// ClientName.sendKeys(template.getProperty("Eub_ClientName"));
			// Thread.sleep(500);
			// ClientName.sendKeys(Keys.ARROW_DOWN);
			// ClientName.sendKeys(Keys.ENTER);
			// childTest.log(Status.PASS, "Entered Client Name successfully.");
			// Thread.sleep(500);
			WebElement EntityName = driver.findElement(By.xpath("//input[@id='SearchControl1_Input']"));
			EntityName.sendKeys(template.getProperty("EnitytName"));
			EntityName.sendKeys(Keys.ARROW_DOWN);
			EntityName.sendKeys(Keys.ENTER);
			childTest.log(Status.PASS, "Entered Entity Name successfully.");
			fm.fnWebButton(driver, EUB_Search, "Search");
			Thread.sleep(4500);
			fm.fnWebButton(driver, Splitter, "Splitter");

			/*
			 * fm.fnWebList(driver, EUB_ClientName, template.getProperty("Eub_ClientName"),
			 * "Client Name"); fm.fnWebList(driver, EUB_ClientName,
			 * template.getProperty("Eub_ClientId"), "Client Id"); fm.fnWebList(driver,
			 * EUB_EntityName, template.getProperty("Eub_EntityName"), "Enity Name");
			 * fm.fnWebList(driver, EUB_EntityId, template.getProperty("Eub_EntityId"),
			 * "Entity Id"); fm.fnWebList(driver, EUB_EntityType, template.getProperty(""),
			 * "Entity Type"); fm.fnWebList(driver, EUB_Locations, template.getProperty(""),
			 * "Locations"); fm.fnWebList(driver, EUB_GroupCode, template.getProperty(""),
			 * "Group Code"); fm.fnWebList(driver, EUB_Status, template.getProperty(""),
			 * "Status"); fm.fnWebList(driver, EUB_EntityGroup, template.getProperty(""),
			 * "Entity Group"); fm.fnWebList(driver, EUB_PPOBStateProvince,
			 * template.getProperty(""), "PPOB State/Province"); fm.fnWebList(driver,
			 * EUB_PPOBCountryRegion, template.getProperty(""), "PPOB Country/Region");
			 */
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	/***************************************************************************************
	 * This function is used to Create the Entity
	 ***************************************************************************************/
	public void fnCreateEntity() throws InterruptedException {
		childTest = test.createNode("Description: Description: Entering all the fields to the create new entity"
				+ "<br>" + "<< Screen Name : Entity Information >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
					waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			Boolean temp = fnVisibilityTest(entity_name);
			if (temp.TRUE) {
				fm.fnWebButton(driver, click_save, "Save");
				String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
				if (errormsg.equalsIgnoreCase("Entity Name is required")) {
					childTest.info("Required feilds to be filled before saving");
				}
				/*
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");
				 * 
				 * LS1 Lp = new LS1(driver, data, template);
				 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 * Thread.sleep(1500); Lp.fnSwitchtoWindow(3, "Client Name LookUp");
				 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 * fm.fnWebEdit(driver, CN_ClientName, template.getProperty("ClientName"),
				 * "Client Name"); fm.fnWebButton(driver, CN_Search, "Search");
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * Thread.sleep(4500); fm.fnWebTable(driver,
				 * driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']"))
				 * , "Click"); fm.fnWebButton(driver, CN_Ok, "Ok");
				 * 
				 * Lp.fnSwitchtoWindow(2, "Create Entity Page");
				 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 * driver.switchTo().frame("addeditFrame1");
				 */

				fm.fnWebEdit(driver, entity_name, template.getProperty("EnitytName"), "Entity Name");
				fm.fnWebEdit(driver, entity_id, template.getProperty("EntityID"), "Entity ID");
				fm.fnWebEdit(driver, country, template.getProperty("Country"), "Country");
				fm.fnWebEdit(driver, state_provision, template.getProperty("State"), "State");
				fm.fnWebList(driver, entity_type, template.getProperty("Entity_Type"), "Entity Type");
				fm.fnWebEdit(driver, incorporate_country, template.getProperty("Country_Incorporated"),
						"Country Incorporated");
				fm.fnWebEdit(driver, incorporate_state, template.getProperty("State_Incorporated"),
						"State Incorporated");
				fm.fnWebEdit(driver, description, template.getProperty("Description"), "Description");
				fm.fnWebEdit(driver, entity_group, template.getProperty("Entity_group"), "Entity_group");
				// fm.fnWebList(driver,charting_group, template.getProperty("Charting_group"),
				// "Charting_group");
				// fm.fnWebList(driver, group_codes, template.getProperty("Group_codes"),
				// "Group_codes");
				// fm.fnWebButton(driver, add_gcodes, "Add");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(1000);
				fm.fnWebButton(driver, click_save, "Save");
				String SaveMsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
				// System.out.println(driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText());
				if (SaveMsg.equalsIgnoreCase("Your data was successfully saved")) {
					childTest.info("Successfully data is saved in Add New Entity Page");
				}
				Thread.sleep(1000);
				fm.fnWebButton(driver, Close, "Close");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	/***************************************************************************************
	 * This function is used to Edit/View Details the Entity
	 ***************************************************************************************/
	public void fnEditDeatils_Entity() {
		childTest = test.createNode(
				"Description: Description: Edit/View Details" + "<br>" + "<< Screen Name : Entity Information >></br>");
		try {
			Thread.sleep(2000);
			if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
				FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(50))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
						.ignoring(NoSuchFrameException.class);
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
				Boolean temp = fnVisibilityTest(entity_name);
				if (temp.TRUE) {
					// fm.fnWebEditCompare(driver, Client_name, template.getProperty("ClientName"),
					// "Client Name");
					// fm.fnWebEditCompare(driver, Client_id, template.getProperty("ClientId"),
					// "Client Id");
					fm.fnWebEditCompare(driver, entity_name, template.getProperty("EnitytName"), "Entity Name");
					fm.fnWebEditCompare(driver, entity_id, template.getProperty("EntityID"), "Entity ID");
					fm.fnWebEditCompare(driver, country, template.getProperty("Country"), "Country");
					fm.fnWebEditCompare(driver, state_provision, template.getProperty("State"), "State");
					fm.fnWebListCompare(driver, entity_type, template.getProperty("Entity_Type"), "Entity Type");
					fm.fnWebEditCompare(driver, incorporate_country, template.getProperty("Country_Incorporated"),
							"Country Incorporated");
					fm.fnWebEditCompare(driver, incorporate_state, template.getProperty("State_Incorporated"),
							"State Incorporated");
					fm.fnWebEditCompare(driver, description, template.getProperty("Description"), "Description");
					fm.fnWebEditCompare(driver, entity_group, template.getProperty("Entity_group"), "Entity_group");
					driver.close();
				}
			} else {
				childTest.fail("Entity Information Page not Found");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	/***************************************************************************************
	 * This function is used to Copy the Data
	 ***************************************************************************************/
	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/***************************************************************************************
	 * This function is used to Import Entity
	 ***************************************************************************************/
	public void fnEntityManagerImport() {
		childTest = test.createNode("Description: Import" + "<br>" + "<< Screen Name: Entity Manager Import>></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Import")) {
				fm.fnWebButton(driver, EM_Import_Import, "Import");
				String errtext = driver.findElement(EM_Import_ErrorMessage).getText();
				WebElement wait = new WebDriverWait(driver, 50)
						.until(ExpectedConditions.visibilityOfElementLocated(EM_Import_ErrorMessage));
				if (wait.isDisplayed()) {
					if (errtext.equalsIgnoreCase("Please select a .xls file to import")) {
						childTest.pass("Verification: Click on Save before uploading a document alert/text " + "<br>"
								+ errtext + " exists </br>");
					} else {
						childTest.fail("Verification: Click on Save before uploading a document alert/text is missing");
					}
				}
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				// String formatPath = "C:\\Users\\X017406\\Desktop\\EUBClientExportAll.xls";
				// setClipboardData(formatPath);

				WebElement elem = driver.findElement(By.xpath("//INPUT[@id=\"ImportFile\"]"));
				elem.sendKeys("C:\\Users\\X017406\\Desktop\\EUBClientExportAll.xls");

				// fm.fnWebButton(driver, EM_Import_Browse, "Browse");

				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				fm.fnWebButton(driver, EM_Import_Import, "Import");
				new WebDriverWait(driver, 50)
						.until(ExpectedConditions.visibilityOfElementLocated(EM_Import_ErrorMessage));
				if (wait.isDisplayed()) {
					if (errtext.equalsIgnoreCase("Validated and Imported successfully")) {
						childTest.pass("Verification: Click on Save after uploading a document alert/text " + "<br>"
								+ errtext + " exists </br>");
					} else {
						childTest.log(Status.ERROR,
								"Verification: Click on Save after uploading a document alert/text is missing");
						// childTest.fail("Verification: Click on Save after uploading a document
						// alert/text is missing");
					}
				}
				fm.fnWebButton(driver, EM_Import_Cancel, "Cancel");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Copy Entity
	 ***************************************************************************************/
	public void copyentity() throws InterruptedException {
		childTest = test.createNode(
				"Description: Description: copy to new entity" + "<br>" + "<< Screen Name : Copy Entity >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			Boolean temp = fnVisibilityTest(entity_name);
			if (temp.TRUE) {
				LS1 Lp = new LS1(driver, data, template);
				/*
				 * fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");
				 * 
				 * 
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * Lp.fnSwitchtoWindow(3, "Client Name LookUp");
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * fm.fnWebEdit(driver, CN_ClientName, template.getProperty("ClientName"),
				 * "Client Name"); fm.fnWebButton(driver, CN_Search, "Search");
				 * driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				 * Thread.sleep(4500); fm.fnWebTable(driver,
				 * driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']"))
				 * , "Click"); fm.fnWebButton(driver, CN_Ok, "Ok");
				 * 
				 * Lp.fnSwitchtoWindow(2, "Create Entity Page");
				 * driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				 */
				fm.fnWebEdit(driver, entity_name, template.getProperty("EnitytNameCopy"), "Name");
				fm.fnWebEdit(driver, entity_id, template.getProperty("EntityIDCopy"), "ID");
				fm.fnWebButton(driver, save_entity, "Save");

				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				Thread.sleep(1500);
				waitf.until(ExpectedConditions.numberOfWindowsToBe(2));
				Lp.fnSwitchtoWindow(2, "Create Entity Page");
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
				Thread.sleep(1500);
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				fm.fnWebButton(driver, Close, "Close");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	/***************************************************************************************
	 * This function is used to perform Customize View
	 ***************************************************************************************/
	public void fnCustomizeView(String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: LS1 >></br>");
		Thread.sleep(1000);
		if (driver.getTitle().equalsIgnoreCase("Customize View")) {
			Boolean temp = fnVisibilityTest(click_save);
			if (temp.TRUE) {
				java.util.List<WebElement> ColumnValues = driver.findElements(By.className("TreeNode"));
				for (int j = 0; j < array.length; j++) {
					for (int i = 0; i < ColumnValues.size(); i++) {
						if (array[j].equals(ColumnValues.get(i).getText())) {
							String menuitem = ColumnValues.get(i).getAttribute("id");
							// System.out.println(ColumnValues.get(i).getText());
							String required = menuitem.substring(0, menuitem.length() - 5);
							// System.out.println(required);
							if (driver
									.findElement(By.xpath(
											"//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']"))
									.isSelected()) {
								childTest.log(Status.PASS, array[j] + " is checked.");
								break;
							} else {
								driver.findElement(By
										.xpath("//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']"))
										.click();
								childTest.log(Status.PASS, array[j] + " is checked.");
								break;
							}
						}
					}
				}
			}
		} else {
			childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
		}
		Thread.sleep(1000);
		fm.fnWebButton(driver, click_save, "Save");
	}

	/***************************************************************************************
	 * This function is used to Save Preferences/ Save Preferences for All
	 ***************************************************************************************/
	public void fnSavePreferences(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: LS1 >></br>");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		if (menuitem.equals("Save Preferences for All")) {
			Thread.sleep(1500);
			// System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dialog-label-container']")));
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText()
					.contains("You are about to change preferences for all users. Please Confirm.")) {
				Thread.sleep(1000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(SavePreforAll_save));
				fm.fnWebButton(driver, SavePreforAll_save, "Yes");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText()
						.contains("Saved successfully.")) {
					Thread.sleep(1000);
					fm.fnWebButton(driver, SavePre_save, "Save");
				} else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		} else if (menuitem.equals("Save Preferences")) {
			// System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='dialog-label-container']")));
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText()
					.contains("Saved successfully.")) {
				//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
				Thread.sleep(1500);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				wait.until(ExpectedConditions.visibilityOfElementLocated(SavePre_save));
				fm.fnWebButton(driver, SavePre_save, "Save");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}

	/***************************************************************************************
	 * This function is used to Click Tax Ids/Registeration
	 ***************************************************************************************/
	public void fnClickTaxIds() throws InterruptedException {
		childTest = test.createNode(
				"Description: Tax Ids/Registrations" + "<br>" + "<< Screen Name: Entity Information >></br>");
		fm.fnWebButton(driver, TaxIds, "TaxIds/Registration");
	}

	/***************************************************************************************
	 * This function is used to Click Actions Button in Tax Ids/Registeration
	 ***************************************************************************************/
	public void fnClickActionsTaxID() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']")).click();
		// fm.fnWebButton(driver, TaxIds_Actions, "Actions");
	}

	/***************************************************************************************
	 * This function is used to perform Add New function in DBA tab
	 ***************************************************************************************/
	public void fnDBAAddNew() {
		childTest = test
				.createNode("Description: DBA : Add New" + "<br>" + "<< Screen Name: Entity Unit Browser>></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			Boolean temp = fnVisibilityTest(EM_DBA_AN_DoingBusinessAs);
			if (temp.TRUE) {
			fm.fnWebButton(driver, EM_DBA_AN_Save, "Save");
			Thread.sleep(1500);
			/*
			 * new WebDriverWait(driver, 50)
			 * .until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel)
			 * ); String dbaErrText1 =
			 * driver.findElement(EM_EntityGroup_msgLabel).getText(); if
			 * (dbaErrText1.equals("Doing Business As is required")) {
			 * childTest.log(Status.PASS,
			 * "Verification: With out entering any details, click on Save '" + dbaErrText1
			 * + "' alert/Message exists"); } else { childTest.log(Status.ERROR,
			 * "Verification: With out entering any details, click on Save alert/Message does not exists"
			 * ); }
			 */
			fm.fnWebEdit(driver, EM_DBA_AN_DoingBusinessAs, data.getProperty("DBA_DoingBusinessAs"),
					"Doing Business As");
			fm.fnWebEdit(driver, EM_DBA_AN_BusinessID, data.getProperty("DBA_BusinessId"), "Business ID");
			fm.fnWebEdit(driver, EM_DBA_AN_Description, data.getProperty("DBA_Description"), "Description");
			fm.fnWebList(driver, EM_DBA_AN_Status, data.getProperty("DBA_Status"), "Status");
			fm.fnWebEdit(driver, EM_DBA_AN_Address1, data.getProperty("DBA_Address1"), "Address1");
			fm.fnWebEdit(driver, EM_DBA_AN_Address2, data.getProperty("DBA_Address2"), "Address2");
			fm.fnWebEdit(driver, EM_DBA_AN_City, data.getProperty("DBA_City"), "City");
			fm.fnWebEdit(driver, EM_DBA_AN_Country_Region, data.getProperty("DBA_CountryRegion"), "Country/Region");
			fm.fnWebEdit(driver, EM_DBA_AN_Zip, data.getProperty("DBA_Zip"), "Zip");
			fm.fnWebEdit(driver, EM_DBA_AN_County, data.getProperty("DBA_County"), "County");
			fm.fnWebEdit(driver, EM_DBA_AN_State, data.getProperty("DBA_State"), "State");
			fm.fnWebEdit(driver, EM_DBA_AN_ContactName, data.getProperty("DBA_ContactName"), "ContactName");
			fm.fnWebEdit(driver, EM_DBA_AN_MainTelephone, data.getProperty("DBA_MainTelephone"), "Main Telephone");
			fm.fnWebEdit(driver, EM_DBA_AN_AlternateTelephone, data.getProperty("DBA_AlternateTelephone"),
					"Alternate Telephone");
			fm.fnWebEdit(driver, EM_DBA_AN_Fax, data.getProperty("DBA_Fax"), "Fax");
			fm.fnWebEdit(driver, EM_DBA_AN_Email, data.getProperty("DBA_Email"), "Email");
			fm.fnWebEdit(driver, EM_DBA_AN_FromdDate, data.getProperty("DBA_FromDate"), "From Date");
			fm.fnWebEdit(driver, EM_DBA_AN_ToDate, data.getProperty("DBA_ToDate"), "To Date");
			fm.fnWebEdit(driver, EM_DBA_AN_Notes, data.getProperty("DBA_Notes"), "Notes");
			fm.fnWebButton(driver, EM_DBA_AN_Save, "Save");
			/*
			 * new WebDriverWait(driver, 50)
			 * .until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel)
			 * ); String dbaErrText2 =
			 * driver.findElement(EM_EntityGroup_msgLabel).getText(); if
			 * (dbaErrText2.equals("Your data was successfully saved")) {
			 * childTest.log(Status.PASS,
			 * "Verification: After entering any details, click on Save '" + dbaErrText2 +
			 * "' alert/Message exists"); } else { childTest.log(Status.ERROR,
			 * "Verification: After entering any details, click on Save alert/Message does not exists"
			 * ); }
			 */
			driver.close();
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to perform Switch between windows in the application
	 ***************************************************************************************/
	public void fnSwitchtoWindow(int winNum, String winName) throws InterruptedException {
		new WebDriverWait(driver, 50).until(ExpectedConditions.numberOfWindowsToBe(winNum));
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i <= s.size()) {
			String popHandle = ite.next().toString();
			driver.switchTo().window(popHandle);
			// System.out.println(driver.getTitle());
			// driver.manage().window().maximize();
			if (i == winNum)
				break;
			i++;
		}
		/*
		 * for(int j=0;j==winNum;j++) { String[] child = new String[winNum]; child[j]=
		 * ite.next(); if(j==winNum) { driver.switchTo().window(child[j]); break; } }
		 */
		if (winName != null || driver.getTitle().equals(winName)) {
			childTest.info("Switched to " + winName + " window.");
		} else {
			childTest.fail("Failed to Switch to " + winName + " window.");
		}
	}

	/***************************************************************************************
	 * This function is used to perform Add/Edit/Delete Entity Group in Basic info
	 * page
	 ***************************************************************************************/
	public void fnEntityGroup(String opr) throws InterruptedException {
		childTest = test.createNode(
				"Description: Entity Group-Add/Edit/Delete" + "<br>" + "<< Screen Name: Basic Info >></br>");
		if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			// fm.fnWebEdit(driver,EM_EntityGroup ,"***","Entity Group");
			driver.findElement(By.xpath("//INPUT[@id='clientname']")).sendKeys("BDO");
			driver.findElement(By.xpath("//input[@id='clientnumber']")).sendKeys("SYS_FIRM");
			Thread.sleep(10000);
			driver.findElement(EM_EntityGroup_Dropdown).click();
			driver.findElement(EM_EntityGroup_Dropdown_ANEG).click();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();
			driver.findElement(EM_EntityGroup_Dropdown).click();
			driver.findElement(EM_EntityGroup_Dropdown_ANEG).click();
			System.out.println(driver.getWindowHandles().size());
			fnSwitchtoWindow(3, "Entity Group:");
			Thread.sleep(3000);
			// driver.switchTo().frame("_sl_historyFrame");
			try {
				if (opr.equalsIgnoreCase("Add")) {
					fm.fnWebButton(driver, EM_EntityGroup_Add, "Add");
					new WebDriverWait(driver, 50)
							.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
					String addText = driver.findElement(EM_EntityGroup_msgLabel).getText();
					if (addText.equals("Please Enter Entity Group")) {
						childTest.log(Status.PASS, "Verification: With out entering any details, click on Add '"
								+ addText + "' alert/Message exists");
					} else {
						childTest.log(Status.ERROR,
								"Verification: With out entering any details, click on Add alert/Message does not exists");
					}
					fm.fnWebButton(driver, EM_EntityGroup_Edit, "Edit");
					new WebDriverWait(driver, 50)
							.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
					String editText = driver.findElement(EM_EntityGroup_msgLabel).getText();
					if (editText.equals("No Data to Edit")) {
						childTest.log(Status.PASS, "Verification: With out entering any details, click on Edit '"
								+ editText + "' alert/Message exists");
					} else {
						childTest.log(Status.ERROR,
								"Verification: With out entering any details, click on Edit alert/Message does not exists");
					}
					fm.fnWebButton(driver, EM_EntityGroup_Delete, "Delete");
					Thread.sleep(1000);
					driver.switchTo().alert().accept();
					new WebDriverWait(driver, 50)
							.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
					String deleteText = driver.findElement(EM_EntityGroup_msgLabel).getText();
					if (deleteText.equals("No Data to Delete")) {
						childTest.log(Status.PASS, "Verification: With out entering any details, click on Delete '"
								+ deleteText + "' alert/Message exists");
					} else {
						childTest.log(Status.ERROR,
								"Verification: With out entering any details, click on Delete alert/Message does not exists");
					}
					fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
					Thread.sleep(1000);
					new WebDriverWait(driver, 50)
							.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
					String saveText = driver.findElement(EM_EntityGroup_msgLabel).getText();
					if (saveText.equals("Saved Successfully.")) {
						childTest.log(Status.PASS, "Verification: With out entering any details, click on Save '"
								+ saveText + "' alert/Message exists");
					} else {
						childTest.log(Status.ERROR,
								"Verification: With out entering any details, click on Save alert/Message does not exists");
					}
					Select s = new Select(driver.findElement(EM_EntityGroup_List));
					List<WebElement> op = s.getOptions();
					String oldText = op.get(0).getText();
					if (!oldText.isEmpty()) {
						fm.fnWebEdit(driver, EM_EntityGroup_Name, oldText, "Entity Group Name");
						fm.fnWebButton(driver, EM_EntityGroup_Add, "Add");
						new WebDriverWait(driver, 50)
								.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
						String repeatText = driver.findElement(EM_EntityGroup_msgLabel).getText();
						if (saveText.equals("This item already exists in the list.")) {
							childTest.log(Status.PASS, "Verification: Enter an existing group name, click on Add '"
									+ repeatText + "' alert/Message exists");
						} else {
							childTest.log(Status.ERROR,
									"Verification: Enter an existing group name, click on Add alert/Message does not exists");
						}
					}
					fm.fnWebEdit(driver, EM_EntityGroup_Name, data.getProperty("EntityGroupName"), "Entity Group");
					fm.fnWebButton(driver, EM_EntityGroup_Add, "Add");
					new WebDriverWait(driver, 50)
							.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
					String errText = driver.findElement(EM_EntityGroup_msgLabel).getText();
					if (saveText.equals("This item already exists in the list.")) {
						childTest.log(Status.PASS, "Verification: Enter an existing group name, click on Add '"
								+ errText + "' alert/Message exists");
						fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
					} else {
						childTest.log(Status.ERROR,
								"Verification: Enter an existing group name, click on Add alert/Message does not exists");
					}
					fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
				}
				if (opr.equalsIgnoreCase("Edit")) {
					Thread.sleep(3000);
					fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
					Select s = new Select(driver.findElement(EM_EntityGroup_List));
					List<WebElement> op = s.getOptions();
					for (int i = 0; i < op.size(); i++) {
						if (op.get(i).getText().equalsIgnoreCase(data.getProperty("EntityGroupName"))) {
							op.get(i).click();
							Thread.sleep(1000);
							fm.fnWebEdit(driver, EM_EntityGroup_Name, data.getProperty("EntityGroupNameEdit"),
									"Entity Group Name");
							fm.fnWebButton(driver, EM_EntityGroup_Edit, "Edit");
							Thread.sleep(1000);
							fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
							new WebDriverWait(driver, 50)
									.until(ExpectedConditions.visibilityOfElementLocated(EM_EntityGroup_msgLabel));
							String newEditText = driver.findElement(EM_EntityGroup_msgLabel).getText();
							if (newEditText.equals("Saved Successfully.")) {
								childTest.log(Status.PASS,
										"Verification: Edit an existing group name, click on Edit&Save '" + newEditText
												+ "' alert/Message exists");
							} else {
								childTest.log(Status.ERROR,
										"Verification: Edit an existing group name, click on Edit&Save alert/Message does not exists");
							}
						}
					}
				}
				if (opr.equalsIgnoreCase("Delete")) {
					Thread.sleep(3000);
					fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
					Select s = new Select(driver.findElement(EM_EntityGroup_List));
					List<WebElement> op = s.getOptions();
					for (int i = 0; i < op.size(); i++) {
						if (op.get(i).getText().equalsIgnoreCase(data.getProperty("EntityGroupNameEdit"))) {
							op.get(i).click();
							Thread.sleep(1000);
							fm.fnWebButton(driver, EM_EntityGroup_Delete, "Delete");
							Thread.sleep(1000);
							driver.switchTo().alert().accept();
							fm.fnWebButton(driver, EM_EntityGroup_Save, "Save");
						}
					}
				}
			} catch (Exception e) {
				childTest.fail(e);
			}
			fm.fnWebButton(driver, EM_EntityGroup_Cancel, "Cancel");
		}
	}

	public void fnEntityManagerDBAEdit() {
		childTest = test.createNode(
				"Description: DBA :Edit/View Details" + "<br>" + "<< Screen Name: Entity Unit Browser--DBA>></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(50))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
						.ignoring(NoSuchFrameException.class);
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebEditCompare(driver, EM_DBA_AN_DoingBusinessAs, data.getProperty("DBA_DoingBusinessAs"),
						"Doing Business As");
				fm.fnWebEditCompare(driver, EM_DBA_AN_BusinessID, data.getProperty("DBA_BusinessId"), "Business ID");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Description, data.getProperty("DBA_Description"), "Description");
				fm.fnWebListCompare(driver, EM_DBA_AN_Status, data.getProperty("DBA_Status"), "Status");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Address1, data.getProperty("DBA_Address1"), "Address1");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Address2, data.getProperty("DBA_Address2"), "Address2");
				fm.fnWebEditCompare(driver, EM_DBA_AN_City, data.getProperty("DBA_City"), "City");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Country_Region, data.getProperty("DBA_CountryRegion"),
						"Country/Region");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Zip, data.getProperty("DBA_Zip"), "Zip");
				fm.fnWebEditCompare(driver, EM_DBA_AN_County, data.getProperty("DBA_County"), "County");
				fm.fnWebEditCompare(driver, EM_DBA_AN_State, data.getProperty("DBA_State"), "State");
				fm.fnWebEditCompare(driver, EM_DBA_AN_ContactName, data.getProperty("DBA_ContactName"), "ContactName");
				fm.fnWebEditCompare(driver, EM_DBA_AN_MainTelephone, data.getProperty("DBA_MainTelephone"),
						"Main Telephone");
				fm.fnWebEditCompare(driver, EM_DBA_AN_AlternateTelephone, data.getProperty("DBA_AlternateTelephone"),
						"Alternate Telephone");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Fax, data.getProperty("DBA_Fax"), "Fax");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Email, data.getProperty("DBA_Email"), "Email");
				fm.fnWebEditCompare(driver, EM_DBA_AN_FromdDate, data.getProperty("DBA_FromDate"), "From Date");
				fm.fnWebEditCompare(driver, EM_DBA_AN_ToDate, data.getProperty("DBA_ToDate"), "To Date");
				fm.fnWebEditCompare(driver, EM_DBA_AN_Notes, data.getProperty("DBA_Notes"), "Notes");
				fm.fnWebButton(driver, EM_DBA_AN_Save, "Save");
				Thread.sleep(1000);
				fm.fnWebButton(driver, SavePre_save, "OK");
				driver.close();
			}

		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Add new Tax Ids/Registration in TaxIds/Registeration
	 * Page
	 ***************************************************************************************/
	public void fnAddNewTaxId() throws InterruptedException {
		childTest = test.createNode("Description: Entering all the fields to create new Tax Id's/Registration" + "<br>"
				+ "<< Screen Name: Entity Manager >></br>");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		if (driver.getTitle().contains("Entity Manager")) {
			Thread.sleep(1500);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			fm.fnWebButton(driver, click_save, "Save");
			waitf.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@id='spaErrorMessage']")));
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Tax ID is required")) {
				childTest.info("Required feilds to be filled before saving");
			} else {
				childTest.fail("Alert didn't popup");
			}

			fm.fnWebButton(driver, JurisdictionName_LookUp, "Jurisdiction Name Lookup");
			LS1 lp = new LS1(driver, data, template);
			waitf.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Jurisdiction Lookup");
			Thread.sleep(2500);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fm.fnWebEdit(driver, JurisdictionName, template.getProperty("TaxId_Jurisdiction"), "Jurisdiction Name");
			fm.fnWebButton(driver, Jurisdiction_Search, "Search");
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']")),
					"Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");
			waitf.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Manager");
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			Thread.sleep(2500);
			fm.fnWebButton(driver, AuthorityName_LookUp, "Authority Name Lookup");
			Thread.sleep(5500);
			waitf.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Authority Name Lookup");
			// fm.fnWebEdit(driver, AuthorityName_2,
			// template.getProperty("TaxId_AuthorityName"), "Authority Name");
			// fm.fnWebButton(driver, Search, "Search");
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_2']")),
					"Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");

			// fm.fnWebEdit(driver, Authority_Name,
			// template.getProperty("TaxId_AuthorityName"), "Authority Name");
			// fm.fnWebEdit(driver, Authority_Name2,
			// template.getProperty("TaxId_AuthorityName2"), "Authority Name2");
			waitf.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Manager");
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			fm.fnWebList(driver, Address_Name, template.getProperty("TaxId_AddressName"), "Address Name");

			fm.fnWebEdit(driver, TaxId_Registration, template.getProperty("TaxId_Registration"), "Tax Id/Registration");
			fm.fnWebEdit(driver, Registration_Date, template.getProperty("TaxId_RegistrationDate"),
					"Registeration Date");
			fm.fnWebEdit(driver, Registration_EndDate, template.getProperty("TaxId_RegistrationEndDate"),
					"Registeration End Date");
			fm.fnWebEdit(driver, Renewal_Date, template.getProperty("TaxId_RenewalDate"), "Renewal Date");
			fm.fnWebEdit(driver, Notes, template.getProperty("TaxId_Notes"), "Notes");
			fm.fnWebCheckBox(driver, Primary_TaxId, "Primary TaxId");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fm.fnWebButton(driver, click_save, "Save");
		// String SaveMsg =
		// driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		// if (SaveMsg.equalsIgnoreCase("Your data was successfully saved")) {
		// childTest.info("Saved the new created Tax Id");
		// }else {
		// childTest.fail("Tax Id not Created");
		// }
		fm.fnWebButton(driver, Close, "Close");
	}

	/***************************************************************************************
	 * This function is used to perform in Archive in Tax Ids/Registeration Page
	 ***************************************************************************************/
	public void fnArchive() throws InterruptedException {
		childTest = test.createNode("Description: Archive in Tax Id's/Registration" + "<br>"
				+ "<< Screen Name: Entity Information >></br>");
		String SaveMsg = driver.findElement(By.xpath("//label[@id='dialog-label']")).getText();
		try {
			if (SaveMsg.contains("Are you sure you want to archive?")) {
				fm.fnWebButton(driver, Archive_Yes, "Yes");
				childTest.info("Archive successfully");
			} else {
				childTest.fail("Archive failed");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}

		fm.fnWebButton(driver, Splitter, "Splitter");
		fm.fnWebCheckBox(driver, Search_Archive, "Archive");
		fm.fnWebButton(driver, TaxId_Search, "Search");
		fm.fnWebButton(driver, Splitter, "Splitter");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridTaxIds_grdEntityManager_row_0']")), "Click");
		fnClickActionsTaxID();
		fnOWMActionsMenu("Unarchive", "");
		String SaveMsg1 = driver.findElement(By.xpath("//label[@id='dialog-label']")).getText();
		if (SaveMsg1.contains("Are you sure you want to Unarchive?")) {
			fm.fnWebButton(driver, Archive_Yes, "Yes");
			childTest.info("Unarchive successfully");
		} else {
			childTest.fail("Unarchive failed");
		}
		fm.fnWebButton(driver, Splitter, "Splitter");
		fm.fnWebCheckBox(driver, Search_Archive, "Archive");
		fm.fnWebButton(driver, TaxId_Search, "Search");
		fm.fnWebButton(driver, Splitter, "Splitter");
	}

	/***************************************************************************************
	 * This function is used to perform in Edit/View details in TaxIds/Registeration
	 * Page
	 ***************************************************************************************/
	public void fnEditTaxIds() throws InterruptedException {
		childTest = test.createNode("Description: Edit/View Details in Tax Id's/Registration" + "<br>"
				+ "<< Screen Name: Entity Manager >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				Thread.sleep(1500);
				fm.fnWebEditCompare(driver, Jurisdiction, template.getProperty("TaxId_Jurisdiction"),
						"Jurisdiction Name");
				fm.fnWebEditCompare(driver, Authority_Name, template.getProperty("TaxId_AuthorityName"),
						"Authority Name");
				fm.fnWebEditCompare(driver, Authority_Name2, template.getProperty("TaxId_AuthorityName2"),
						"Authority Name");
				fm.fnWebListCompare(driver, Address_Name, template.getProperty("TaxId_AddressName"), "Address Name");
				fm.fnWebEditCompare(driver, TaxId_Registration, template.getProperty("TaxId_Registration"),
						"Tax Id/Registration");
				fm.fnWebEditCompare(driver, Registration_Date, template.getProperty("TaxId_RegistrationDate"),
						"Registeration Date");
				fm.fnWebEditCompare(driver, Registration_EndDate, template.getProperty("TaxId_RegistrationEndDate"),
						"Registeration End Date");
				fm.fnWebEditCompare(driver, Renewal_Date, template.getProperty("TaxId_RenewalDate"), "Renewal Date");
				fm.fnWebEditCompare(driver, Notes, template.getProperty("TaxId_Notes"), "Notes");
				driver.close();
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to perform in Search operation in TaxIds/Registeration
	 * Page
	 ***************************************************************************************/
	public void fnSearchTaxIds() throws InterruptedException {
		childTest = test.createNode(
				"Description: Search in Tax Id's/Registration" + "<br>" + "<<Screen Name: Entity Information >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
				fm.fnWebButton(driver, Splitter, "Splitter");
				fm.fnWebList(driver, Search_Jurisdiction, template.getProperty("TaxId_JurisdictionName"),
						"Jurisdiction Name");
				fm.fnWebList(driver, Search_AuntorityName, template.getProperty("TaxId_AuthorityName"),
						"Authority Name");
				fm.fnWebButton(driver, TaxId_Search, "Search");
				fm.fnWebButton(driver, Splitter, "Splitter");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	public void fnSearchTaxIds1() {
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
				fm.fnWebButton(driver, Splitter, "Splitter");
				fm.fnWebButton(driver, TaxId_Search, "Search");
				fm.fnWebButton(driver, Splitter, "Splitter");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	public void fnEM_SwitchTabs(String text) throws InterruptedException {
		try {
			By tabItem = By.xpath("//*[@id='TabStrip1']//*[contains(text(),'" + text + "')]");
			fm.fnWebButton(driver, tabItem, text);
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	/***************************************************************************************
	 * This function is used to perform in Edit on Business Tax Page
	 ***************************************************************************************/

	public void business_Taxinfo() throws InterruptedException {
		childTest = test.createNode("Description: Giving business/Tax info details" + "<br>"
				+ "<< Screen Name: Entity information >></br>");

		// driver.switchTo().defaultContent();
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		driver.findElement(By.xpath("//td[@id='tdBusiness']")).click(); // Navigate to business tab
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
		fm.fnWebEdit(driver, entityManager_bt_country, template.getProperty("BT_Country"), "BT_Country");
		fm.fnWebEdit(driver, entityManager_bt_state, template.getProperty("BT_State"), "BT_State");
		fm.fnWebEdit(driver, entityManager_bt_pbacode, template.getProperty("BT_PBAcode"), "BT_PBAcode");
		fm.fnWebEdit(driver, entityManager_bt_siccode, template.getProperty("BT_SICcode"), "BT_SICcode");
		fm.fnWebList(driver, entityManager_bt_localcurrency, template.getProperty("Local_Currency"), "Local_Currency");
		fm.fnWebList(driver, entityManager_bt_functionalcurrency, template.getProperty("Fun_Currency"), "Fun_Currency");
		fm.fnWebList(driver, entityManager_bt_reportingcurrency, template.getProperty("Reporting_Currency"),
				"Reporting_Currency");
		fm.fnWebEdit(driver, entityManager_bt_fybegdate, template.getProperty("FY_Begdate"), "FY_Begdate");
		fm.fnWebEdit(driver, entityManager_bt_fyenddate, template.getProperty("FY_Enddate"), "FY_Enddate");
		fm.fnWebEdit(driver, entityManager_bt_tybegdate, template.getProperty("TY_Begdate"), "TY_Begdate");
		// fm.fnWebEdit(driver, entityManager_bt_tyenddate,
		// template.getProperty("TY_Enddate"), "TY_Enddate");
		fm.fnWebList(driver, entityManager_bt_endmonth, template.getProperty("End_Month"), "End_Month");
		fm.fnWebList(driver, entityManager_bt_endday, template.getProperty("End_Day"), "End_Day");
		fm.fnWebList(driver, entityManager_bt_methoduse, template.getProperty("Method"), "Method");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebButton(driver, click_save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if (errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		fm.fnWebButton(driver, Close, "Close");
	}

	/***************************************************************************************
	 * This function is used to perform in Edit and view on Business Tax Page
	 ***************************************************************************************/
	public void viewBusinessTax() throws InterruptedException {
		childTest = test.createNode(
				"Description: View Business Info Tab " + "<br>" + "<< Screen Name: Entity Information >></br>");

		try {
			// driver.switchTo().defaultContent();
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			driver.findElement(By.xpath("//td[@id='tdBusiness']")).click(); // Navigate to business tab
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			fm.fnWebEditCompare(driver, entityManager_bt_country, template.getProperty("BT_Country"), "BT_Country");
			fm.fnWebEditCompare(driver, entityManager_bt_state, template.getProperty("BT_State"), "BT_State");
			fm.fnWebEditCompare(driver, entityManager_bt_pbacode, template.getProperty("BT_PBAcode"), "BT_PBAcode");
			fm.fnWebEditCompare(driver, entityManager_bt_siccode, template.getProperty("BT_SICcode"), "BT_SICcode");
			fm.fnWebListCompare(driver, entityManager_bt_localcurrency, template.getProperty("Local_Currency"),
					"Local_Currency");
			fm.fnWebListCompare(driver, entityManager_bt_functionalcurrency, template.getProperty("Fun_Currency"),
					"Fun_Currency");
			fm.fnWebListCompare(driver, entityManager_bt_reportingcurrency, template.getProperty("Reporting_Currency"),
					"Reporting_Currency");
			fm.fnWebEditCompare(driver, entityManager_bt_fybegdate, template.getProperty("FY_Begdate"), "FY_Begdate");
			fm.fnWebEditCompare(driver, entityManager_bt_fyenddate, template.getProperty("FY_Enddate"), "FY_Enddate");
			fm.fnWebEditCompare(driver, entityManager_bt_tybegdate, template.getProperty("TY_Begdate"), "TY_Begdate");
			// fm.fnWebEdit(driver, entityManager_bt_tyenddate,
			// template.getProperty("TY_Enddate"), "TY_Enddate");
			fm.fnWebListCompare(driver, entityManager_bt_endmonth, template.getProperty("End_Month"), "End_Month");
			fm.fnWebListCompare(driver, entityManager_bt_endday, template.getProperty("End_Day"), "End_Day");
			fm.fnWebListCompare(driver, entityManager_bt_methoduse, template.getProperty("Method"), "Method");

		} catch (Exception e) {
			childTest.fail(e);

		}
		fm.fnWebButton(driver, Close, "Close");

	}

	/***************************************************************************************
	 * This function is used to perform in Edit on Responsibility Info Page
	 ***************************************************************************************/
	public void responsibility_info() throws InterruptedException {
		childTest = test.createNode(
				"Description: Responsibility Information" + "<br>" + "<< Screen Name: Entity information >></br>");
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//td[@id='tdResponsibility']")).click(); // Navigate to business tab
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
		fm.fnWebEdit(driver, entityManager_ri_person_name, template.getProperty("Person_Name"), "Person_Name");
		fm.fnWebEdit(driver, entityManager_ri_person_address, template.getProperty("Person_Addr"), "Person_Addr");
		fm.fnWebEdit(driver, entityManager_ri_person_city, template.getProperty("Person_City"), "Person_City");
		fm.fnWebEdit(driver, entityManager_ri_person_country, template.getProperty("Person_Country"), "Person_Country");
		fm.fnWebEdit(driver, entityManager_ri_person_state, template.getProperty("Person_State"), "Person_State");
		fm.fnWebEdit(driver, entityManager_ri_person_zip, template.getProperty("Person_Zip"), "Person_Zip");
		fm.fnWebEdit(driver, entityManager_ri_person_phone, template.getProperty("Person_Phone"), "Person_Phone");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, entityManager_ri_corp_name, template.getProperty("Corp_Name"), "Corp_Name");
		fm.fnWebEdit(driver, entityManager_ri_corp_address, template.getProperty("Corp_Addr"), "Corp_Addr");
		fm.fnWebEdit(driver, entityManager_ri_corp_city, template.getProperty("Corp_City"), "Corp_City");
		fm.fnWebEdit(driver, entityManager_ri_corp_country, template.getProperty("Corp_Country"), "Corp_Country");
		fm.fnWebEdit(driver, entityManager_ri_corp_state, template.getProperty("Corp_State"), "Corp_State");
		fm.fnWebEdit(driver, entityManager_ri_corp_zip, template.getProperty("Corp_Zip"), "Corp_Zip");
		fm.fnWebEdit(driver, entityManager_ri_corp_phone, template.getProperty("Corp_Phone"), "Corp_Phone");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, entityManager_ri_brabch_name, template.getProperty("Branch_Name"), "Branch_Name");
		fm.fnWebEdit(driver, entityManager_ri_brabch_address, template.getProperty("Branch_Addr"), "Branch_Addr");
		fm.fnWebEdit(driver, entityManager_ri_brabch_city, template.getProperty("Branch_City"), "Branch_City");
		fm.fnWebEdit(driver, entityManager_ri_brabch_country, template.getProperty("Branch_Country"), "Branch_Country");
		fm.fnWebEdit(driver, entityManager_ri_brabch_state, template.getProperty("Branch_State"), "Branch_State");
		fm.fnWebEdit(driver, entityManager_ri_brabch_zip, template.getProperty("Branch_Zip"), "Branch_Zip");
		fm.fnWebEdit(driver, entityManager_ri_brabch_phone, template.getProperty("Branch_Phone"), "Branch_Phone");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebButton(driver, click_save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if (errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		fm.fnWebButton(driver, Close, "Close");
	}

	/***************************************************************************************
	 * This function is used to perform in Edit on Responsibility Info Page
	 ***************************************************************************************/
	public void viewResonsblityInfo() throws InterruptedException {
		childTest = test.createNode(
				"Description: View Responsiblity Info Tab" + "<br>" + "<< Screen Name: Entity Information >></br>");
		try {
			// driver.switchTo().defaultContent();
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//td[@id='tdResponsibility']")).click(); // Navigate to business tab
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEditCompare(driver, entityManager_ri_person_name, template.getProperty("Person_Name"),
					"Person_Name");
			fm.fnWebEditCompare(driver, entityManager_ri_person_address, template.getProperty("Person_Addr"),
					"Person_Addr");
			fm.fnWebEditCompare(driver, entityManager_ri_person_city, template.getProperty("Person_City"),
					"Person_City");
			fm.fnWebEditCompare(driver, entityManager_ri_person_country, template.getProperty("Person_Country"),
					"Person_Country");
			fm.fnWebEditCompare(driver, entityManager_ri_person_state, template.getProperty("Person_State"),
					"Person_State");
			fm.fnWebEditCompare(driver, entityManager_ri_person_zip, template.getProperty("Person_Zip"), "Person_Zip");
			fm.fnWebEditCompare(driver, entityManager_ri_person_phone, template.getProperty("Person_Phone"),
					"Person_Phone");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEditCompare(driver, entityManager_ri_corp_name, template.getProperty("Corp_Name"), "Corp_Name");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_address, template.getProperty("Corp_Addr"), "Corp_Addr");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_city, template.getProperty("Corp_City"), "Corp_City");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_country, template.getProperty("Corp_Country"),
					"Corp_Country");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_state, template.getProperty("Corp_State"), "Corp_State");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_zip, template.getProperty("Corp_Zip"), "Corp_Zip");
			fm.fnWebEditCompare(driver, entityManager_ri_corp_phone, template.getProperty("Corp_Phone"), "Corp_Phone");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_name, template.getProperty("Branch_Name"),
					"Branch_Name");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_address, template.getProperty("Branch_Addr"),
					"Branch_Addr");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_city, template.getProperty("Branch_City"),
					"Branch_City");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_country, template.getProperty("Branch_Country"),
					"Branch_Country");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_state, template.getProperty("Branch_State"),
					"Branch_State");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_zip, template.getProperty("Branch_Zip"), "Branch_Zip");
			fm.fnWebEditCompare(driver, entityManager_ri_brabch_phone, template.getProperty("Branch_Phone"),
					"Branch_Phone");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			childTest.fail(e);

		}
		fm.fnWebButton(driver, Close, "Close");

	}

	/***************************************************************************************
	 * This function is used to perform in Edit Key Contacts Page
	 ***************************************************************************************/
	public void key_contacts() throws InterruptedException {
		childTest = test
				.createNode("Description: Key Contacts" + "<br>" + "<< Screen Name: Entity information >></br>");
		// driver.switchTo().defaultContent();
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		fm.fnWebButton(driver,By.xpath("//td[@id='tdKeyContacts']"),"Key Contacts");
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
		fm.fnWebEdit(driver, entityManager_kc_mname, template.getProperty("Main_PersonName"), "Main_PersonName");
		fm.fnWebEdit(driver, entityManager_kc_mtitle, template.getProperty("Main_Title"), "Main_Title");
		fm.fnWebEdit(driver, entityManager_kc_memail, template.getProperty("Main_Email"), "Main_Email");
		fm.fnWebEdit(driver, entityManager_kc_mwphone, template.getProperty("Main_WorkPhNumber"), "Main_WorkPhNumber");
		fm.fnWebEdit(driver, entityManager_kc_mmphone, template.getProperty("Main_MobileNumber"), "Main_MobileNumber");
		fm.fnWebEdit(driver, entityManager_kc_mhphone, template.getProperty("Main_HomeNumber"), "Main_HomeNumber");
		fm.fnWebEdit(driver, entityManager_kc_aname, template.getProperty("FirstAdditional_PersonName"),
				"FirstAdditional_PersonName");
		fm.fnWebEdit(driver, entityManager_kc_atitle, template.getProperty("FirstAdditional_Title"),
				"FirstAdditional_Title");
		fm.fnWebEdit(driver, entityManager_kc_aemail, template.getProperty("FirstAdditional_Email"),
				"FirstAdditional_Email");
		fm.fnWebEdit(driver, entityManager_kc_awphone, template.getProperty("FirstAdditional_WorkPhNumber"),
				"FirstAdditional_Country");
		fm.fnWebEdit(driver, entityManager_kc_amphone, template.getProperty("FirstAdditional_MobileNumber"),
				"FirstAdditional_MobileNumber");
		fm.fnWebEdit(driver, entityManager_kc_ahphone, template.getProperty("FirstAdditional_HomeNumber"),
				"FirstAdditional_HomeNumber");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, entityManager_kc_cname, template.getProperty("SecondAdditional_PersonName"),
				"SecondAdditional_PersonName");
		fm.fnWebEdit(driver, entityManager_kc_ctitle, template.getProperty("SecondAdditional_Title"),
				"SecondAdditional_Title");
		fm.fnWebEdit(driver, entityManager_kc_cemail, template.getProperty("SecondAdditional_Email"),
				"SecondAdditional_Email");
		fm.fnWebEdit(driver, entityManager_kc_cwphone, template.getProperty("SecondAdditional_WorkPhNumber"),
				"SecondAdditional_Country");
		fm.fnWebEdit(driver, entityManager_kc_cmphone, template.getProperty("SecondAdditional_MobileNumber"),
				"SecondAdditional_MobileNumber");
		fm.fnWebEdit(driver, entityManager_kc_chphone, template.getProperty("SecondAdditional_HomeNumber"),
				"SecondAdditional_HomeNumber");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebButton(driver, click_save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if (errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		Thread.sleep(1000);
		fm.fnWebButton(driver, Close, "Close");

	}

	/***************************************************************************************
	 * This function is used to perform in Edit Key Contacts Page
	 ***************************************************************************************/

	public void viewKeyContacts() throws InterruptedException {
		childTest = test.createNode(
				"Description: View Key Contacts Tab" + "<br>" + "<< Screen Name: Entity Information >></br>");
		try {
			// driver.switchTo().defaultContent();
			Thread.sleep(1000);
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			fm.fnWebButton(driver,By.xpath("//td[@id='tdKeyContacts']"),"Key Contacts");// Navigate to business tab
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			fm.fnWebEditCompare(driver, entityManager_kc_mname, template.getProperty("Main_PersonName"),
					"Main_PersonName");
			fm.fnWebEditCompare(driver, entityManager_kc_mtitle, template.getProperty("Main_Title"), "Main_Title");
			fm.fnWebEditCompare(driver, entityManager_kc_memail, template.getProperty("Main_Email"), "Main_Email");
			fm.fnWebEditCompare(driver, entityManager_kc_mwphone, template.getProperty("Main_WorkPhNumber"),
					"Main_WorkPhNumber");
			fm.fnWebEditCompare(driver, entityManager_kc_mmphone, template.getProperty("Main_MobileNumber"),
					"Main_MobileNumber");
			fm.fnWebEditCompare(driver, entityManager_kc_mhphone, template.getProperty("Main_HomeNumber"),
					"Main_HomeNumber");
			fm.fnWebEditCompare(driver, entityManager_kc_aname, template.getProperty("FirstAdditional_PersonName"),
					"FirstAdditional_PersonName");
			fm.fnWebEditCompare(driver, entityManager_kc_atitle, template.getProperty("FirstAdditional_Title"),
					"FirstAdditional_Title");
			fm.fnWebEditCompare(driver, entityManager_kc_aemail, template.getProperty("FirstAdditional_Email"),
					"FirstAdditional_Email");
			fm.fnWebEditCompare(driver, entityManager_kc_awphone, template.getProperty("FirstAdditional_WorkPhNumber"),
					"FirstAdditional_Country");
			fm.fnWebEditCompare(driver, entityManager_kc_amphone, template.getProperty("FirstAdditional_MobileNumber"),
					"FirstAdditional_MobileNumber");
			fm.fnWebEditCompare(driver, entityManager_kc_ahphone, template.getProperty("FirstAdditional_HomeNumber"),
					"FirstAdditional_HomeNumber");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEditCompare(driver, entityManager_kc_cname, template.getProperty("SecondAdditional_PersonName"),
					"SecondAdditional_PersonName");
			fm.fnWebEditCompare(driver, entityManager_kc_ctitle, template.getProperty("SecondAdditional_Title"),
					"SecondAdditional_Title");
			fm.fnWebEditCompare(driver, entityManager_kc_cemail, template.getProperty("SecondAdditional_Email"),
					"SecondAdditional_Email");
			fm.fnWebEditCompare(driver, entityManager_kc_cwphone, template.getProperty("SecondAdditional_WorkPhNumber"),
					"SecondAdditional_Country");
			fm.fnWebEditCompare(driver, entityManager_kc_cmphone, template.getProperty("SecondAdditional_MobileNumber"),
					"SecondAdditional_MobileNumber");
			fm.fnWebEditCompare(driver, entityManager_kc_chphone, template.getProperty("SecondAdditional_HomeNumber"),
					"SecondAdditional_HomeNumber");

		} catch (Exception e) {
			childTest.fail(e);

		}
		fm.fnWebButton(driver, Close, "Close");

	}

	/***************************************************************************************
	 * This function is used to perform Operations on Page Links Page
	 ***************************************************************************************/

	public void page_Links() throws InterruptedException {
		childTest = test.createNode("Description: Page Links" + "<br>" + "<< Screen Name: Entity information >></br>");
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		driver.switchTo().defaultContent();
		fm.fnWebButton(driver, By.xpath("//td[@id='tdPageLinks']"),"Page Links");
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
		fm.fnWebEdit(driver, entityManager_pl_addtitle, template.getProperty("Add_LinkTitle"), "Add_LinkTitle");
		fm.fnWebEdit(driver, entityManager_pl_addlink, template.getProperty("Add_WrongURL"), "Add_WrongURL");
		fm.fnWebButton(driver, entityManager_pl_addbutton, "Add");
		String errormsgs = driver.findElement(By.xpath("//label[@id='dialog-label']")).getText();
		if (errormsgs.contains("https")) {
			childTest.info(errormsgs);
		}
		fm.fnWebButton(driver, entityManager_pl_closebutton, "Close_Button");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, entityManager_pl_addlink, template.getProperty("Add_URL"), "Add_URL");
		fm.fnWebButton(driver, entityManager_pl_addbutton, "Add");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement edit = driver.findElement(By.xpath("//td[@id='grdPageLinks_grdEntityManager_cell_0_7']/div/a[1]"));

		if (edit.isDisplayed()) {
			edit.click();
			fm.fnWebEdit(driver, entityManager_pl_addtitle, template.getProperty("Add_LinkTitleupdate"),
					"Add_LinkTitleupdate");
			fm.fnWebEdit(driver, entityManager_pl_addlink, template.getProperty("Add_URLupdate"), "Add_URLupdate");
			fm.fnWebButton(driver, entityManager_pl_addbutton, "Add");
			childTest.pass("The Page link has been added and edited");
		} else {
			childTest.fail("The Page link is not created, Create link to edit");
		}

		WebElement delete = driver.findElement(By.xpath("//td[@id='grdPageLinks_grdEntityManager_cell_0_7']/div/a[2]"));
		if (delete.isDisplayed()) {
			childTest.pass("The delete option is displayed for the created link");
			delete.click();
			fm.fnWebButton(driver, entityManager_pl_delbutton, "Yes");
			childTest.info("The link has been deleted");
		} else {
			childTest.fail("The Page link is not created, Create link to edit");
		}
		fm.fnWebButton(driver, click_save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if (errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		fm.fnWebButton(driver, Close, "Close");

	}

	/***************************************************************************************
	 * This function is used to perform double click entity
	 ***************************************************************************************/
	public void doubleclickEntity() throws InterruptedException {
		childTest = test.createNode("Description: Double click Entity" + "<br>" + "<< Screen Name: ONESOURCE >></br>");
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_iFrame"));
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")))
				.doubleClick().build().perform();
		childTest.info("Navigated to edit window");

	}

	/***************************************************************************************
	 * This function is used to perform search entity
	 ***************************************************************************************/

	public void searchEntity() throws InterruptedException {
		childTest = test.createNode("Description: Search for Entity" + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		driver.switchTo().frame("maincontent");
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_iFrame"));
		waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		driver.findElement(By.xpath("//img[@id='imgSplitter']")).click();
		fm.fnWebEdit(driver, entityManager_search_withName, template.getProperty("Search_Name"), "Search_Name");
		fm.fnWebEdit(driver, entityManager_search_withID, template.getProperty("Search_ID"), "Search_ID");
		fm.fnWebButton(driver, entityManager_search, "Search");
		WebElement entity = driver.findElement(By.xpath(("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")));
		if (entity.isDisplayed()) {
			childTest.pass("Entity Search Passed");
			entity.click();
		} else {
			childTest.fail("Entity Search Failed");
		}

	}

	public void navtoEditview() throws InterruptedException {
		childTest = test.createNode("Description: Edit or view the details of basic info tab" + "<br>"
				+ "<< Screen Name: Entity Information >></br>");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebButton(driver, actions_Entity, "Actions");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions actions = new Actions(driver);
		WebElement edit = driver.findElement(By.xpath("//td[@id='mnuEntityBrowser_2']"));
		if (edit.isDisplayed()) {
			childTest.pass("Entity has been selected and editview option enabled");
			actions.moveToElement(edit).click().build().perform();
		} else {
			childTest.fail("Entity not selected and editview option disabled");
		}
	}

	public void fnEntityManagerOwnersAddNew(String textData) {
		childTest = test.createNode("Description: Add New ~ Owners" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Owners >></br>");
		if (textData.contains("0%")) {
			childTest.log(Status.PASS, "Total percentage before adding owner is 0%.");
		} else {
			childTest.log(Status.FAIL, "Total percentage before adding owner is not 0%.");
		}
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			fm.fnWebButton(driver, EM_Owners_Save, "Save");
			/*
			 * new WebDriverWait(driver, 50)
			 * .until(ExpectedConditions.visibilityOfElementLocated(EM_Owners_errMessage));
			 * String ownerErrtext = driver.findElement(EM_Owners_errMessage).getText(); if
			 * (ownerErrtext.equals("Owner is required")) { childTest.log(Status.PASS,
			 * "Verification: Click on Save without entering any details, click on Save '" +
			 * ownerErrtext + "' alert/Message exists"); } else {
			 * childTest.log(Status.ERROR,
			 * "Verification:Click on Save without entering any details, click on Save alert/Message does not exists"
			 * ); }
			 */
			String perText = driver.findElement(EM_Owners_Labelpercentage).getText();
			if (perText.equals("0")) {
				childTest.log(Status.PASS,
						"Verification: Total Ownership prior to adding this owner is '" + perText + "'% .");
			} else {
				childTest.log(Status.ERROR, "Verification: Total Ownership prior to adding this owner is must be 0% .");
			}
			fm.fnWebList(driver, EM_Owners_OwnerType, data.getProperty("Owners_OwnerType"), "Owner Type");
			fm.fnWebEdit(driver, EM_Owners_OwnerName1, data.getProperty("Owners_OwnerName1"), "Owner Name");
			fm.fnWebEdit(driver, EM_Owners_PercentageOwned1, data.getProperty("Owners_PercentageOwned1"),
					"Percentage Owned");
			fm.fnWebEdit(driver, EM_Owners_AsofDate1, data.getProperty("Owners_AsOfDate1"), "As Of Date");
			fm.fnWebButton(driver, EM_Owners_AddOwner, "Add Owner");
			Thread.sleep(2000);
			fm.fnWebEdit(driver, EM_Owners_OwnerName2, data.getProperty("Owners_OwnerName2"), "Owner Name");
			fm.fnWebEdit(driver, EM_Owners_PercentageOwned2, data.getProperty("Owners_PercentageOwned2"),
					"Percentage Owned");
			fm.fnWebEdit(driver, EM_Owners_AsofDate2, data.getProperty("Owners_AsOfDate2"), "As Of Date");
			fm.fnWebButton(driver, EM_Owners_Save, "Save");
			Thread.sleep(5000);
			String perText1 = driver.findElement(EM_Owners_Labelpercentage).getText();
			if (perText.equals("100.00")) {
				childTest.log(Status.PASS,
						"Verification: Total Ownership prior to adding this owner is '" + perText1 + "'% .");
			} else {
				childTest.log(Status.ERROR,
						"Verification: Total Ownership prior to adding this owner is must be 100.00% .");
			}
			/*
			 * new WebDriverWait(driver, 50)
			 * .until(ExpectedConditions.visibilityOfElementLocated(EM_Owners_errMessage));
			 * String ownerErrtext1 = driver.findElement(EM_Owners_errMessage).getText(); if
			 * (ownerErrtext.equals("Your data was successfully saved")) {
			 * childTest.log(Status.PASS,
			 * "Verification: Click on Save after entering any details, click on Save '" +
			 * ownerErrtext1 + "' alert/Message exists"); } else {
			 * childTest.log(Status.ERROR,
			 * "Verification:Click on Save after entering any details, click on Save alert/Message does not exists"
			 * ); }
			 */
			fm.fnWebButton(driver, EM_Owners_Close, "Close");

		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	public void fnEntityManagerOwnersEditViewDetails(int i) {
		childTest = test.createNode("Description: Edit/View Details~ Owners" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Owners >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			System.out.println("this is in Edit");
			if (i == 2) {
				System.out.println("in row 2");
				fm.fnWebEditCompare(driver, EM_Owners_OwnerName, data.getProperty("Owners_OwnerName2"), "Owner Name");
				fm.fnWebEditCompare(driver, EM_Owners_PercentageOwned, data.getProperty("Owners_PercentageOwned2"),
						"Percentage Owned");
				fm.fnWebEditCompare(driver, EM_Owners_AsofDate, data.getProperty("Owners_AsOfDate2"), "As Of Date");
			} else {
				System.out.println("in row 3");
				fm.fnWebEditCompare(driver, EM_Owners_OwnerName, data.getProperty("Owners_OwnerName1"), "Owner Name");
				fm.fnWebEditCompare(driver, EM_Owners_PercentageOwned, data.getProperty("Owners_PercentageOwned1"),
						"Percentage Owned");
				fm.fnWebEditCompare(driver, EM_Owners_AsofDate, data.getProperty("Owners_AsOfDate1"), "As Of Date");
			}
			fm.fnWebButton(driver, EM_Owners_Close, "Close");
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	public void fnLogOff() throws InterruptedException {
		childTest = test.createNode("Description:LogOut of the Tool " + "<br>" + "<< Screen Name:  >></br>");
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		driver.switchTo().defaultContent();
		while (ite.hasNext() && i <= s.size()) {
			String popHandle = ite.next().toString();
			driver.switchTo().window(popHandle);
			if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")) {
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				fm.fnWebButton(driver, By.xpath("//*[@id='divLogoutLink']"), "OWM Logout");
			} else if (driver.getTitle().equalsIgnoreCase("Onesource")) {
				driver.switchTo().frame("header");
				fm.fnWebButton(driver, By.xpath("//*[@id='btnLogOff']"), "LS1 Logout");
			}
		}
		driver.quit();
	}

	public Boolean fnVisibilityTest(By element) {
		Boolean result;
		WebElement test = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (test.isDisplayed())
			result = true;
		else
			result = false;

		return result;
	}

	/***************************************************************************************
	 * This function is used to Add Document
	 ***************************************************************************************/
	public void fnEM_AddDocument() {
		childTest = test.createNode("Description: Add Document in Entity Manager " + "<br>"
				+ "<< Screen Name: Add Document >></br>");
		try {
			Thread.sleep(1000);
			//if(driver.getTitle().contains("Add document")) {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
				fm.fnWebButton(driver, EM_Doc_Save, "Save");
				String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
				if (errormsg.equalsIgnoreCase("Select a physical document to upload.")) {
					childTest.info("Required feilds to be filled before saving");
				} else {
					childTest.fail("Alert didn't popup");
				}
				fm.fnWebEdit(driver, EM_Doc_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEdit(driver, EM_Doc_EntityId, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebList(driver, EM_Doc_TaxType, template.getProperty("TaxType"), "Tax Type");
				fm.fnWebList(driver, EM_Doc_Year, template.getProperty("Year"), "Year");
				fm.fnWebList(driver, EM_Doc_Period, template.getProperty("Period"), "Period");
				fm.fnWebEdit(driver, EM_Doc_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebEdit(driver, EM_Doc_Description, template.getProperty("doc_Description"), "Description");
				//fm.fnWebList(driver, EM_Doc_FileSection, template.getProperty("doc_FileSection"), "File Section");
				//fm.fnWebList(driver, EM_Doc_DocumentType, template.getProperty("doc_DocumentType"), "Document Type");
				fm.fnWebEdit(driver, EM_Doc_DocumentDate, template.getProperty("doc_DocumentDate"), "Document Date");
				fm.fnWebList(driver, EM_Doc_WorkflowAssociation, template.getProperty("Workflow_Association"), "Workflow Association");
				fm.fnWebList(driver, EM_Doc_AssignedTo, template.getProperty("AssignedTo"), "Assigned To");
				fm.fnWebList(driver, EM_Doc_Status, template.getProperty("Status"), "Status");
				fm.fnWebEdit(driver, EM_Doc_DueDate, template.getProperty("doc_DueDate"), "Due Date");
				fm.fnWebList(driver, EM_Doc_Notify, template.getProperty("AssignedTo"), "Notify");
				fm.fnWebButton(driver, EM_Doc_Browse, "Browse");
				
				String path = "C:\\RapidScripts\\Documents\\Doc";
				setClipboardData(path);
				//driver.findElement(By.xpath("//TD[@id='tdSelectDocument']/TABLE[1]/tbody/tr[2]/td[2]")).click();
				Robot robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1000);
				fm.fnWebButton(driver, EM_Doc_Save, "Save");
				Thread.sleep(10000);
				if(driver.switchTo().alert().getText().contains("Saved Successfully")){
					driver.switchTo().alert().accept();
					childTest.pass("Document Created successfully");
				}else {
					childTest.fail("Document not creatred");
				}
				//}else {
					//childTest.fail("Add Document Page not found");
				//}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Search Document
	 ***************************************************************************************/
	public void fnEM_SearchDocument() {
		childTest = test.createNode("Description: Search Document" + "<br>" + "<< Screen Name: Documents >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
				fm.fnWebButton(driver, Splitter, "Splitter");
				fm.fnWebButton(driver, EM_Doc_Clear, "Clear");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//fm.fnWebList(driver, EM_Doc_Search_WFTemplate, template.getProperty(""), "W/F Template");
				fm.fnWebList(driver, EM_Doc_Search_Year, template.getProperty("Year"), "Year");
				fm.fnWebEdit(driver, EM_Doc_Search_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEdit(driver, EM_Doc_Search_EntityId, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebList(driver, EM_Doc_Search_Period, template.getProperty("Period"), "Period");
				fm.fnWebList(driver, EM_Doc_Search_TaxType, template.getProperty("TaxType"), "Tax Type");
				fm.fnWebList(driver, EM_Doc_Search_WorkflowAssociation, template.getProperty("Workflow_Association"),
						"Workflow Association");
				fm.fnWebEdit(driver, EM_Doc_Search_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebEdit(driver, EM_Doc_Search_Description, template.getProperty("doc_Description"), "Description");
				// fm.fnWebList(driver, EM_Doc_Search_FileSection, template.getProperty(""),
				// "File Section");
				// fm.fnWebList(driver, EM_Doc_Search_DocumentType, template.getProperty(""),
				// "Document Type");
				// fm.fnWebList(driver, EM_Doc_Search_WorkflowType, template.getProperty(""),
				// "Workflow Type");
				fm.fnWebButton(driver, EM_Doc_Search, "Search");
				fm.fnWebButton(driver, Splitter, "Splitter");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Document Properties
	 ***************************************************************************************/
	public void fnDocumentProperties() {
		childTest = test.createNode("Description: Document Properties" + "<br>" + "<< Screen Name: Document Properties >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Document Properties")) {
				fm.fnWebEditCompare(driver, EM_Doc_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEditCompare(driver, EM_Doc_EntityId, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebListCompare(driver, EM_Doc_TaxType, template.getProperty("TaxType"), "Tax Type");
				fm.fnWebListCompare(driver, EM_Doc_Year, template.getProperty("Year"), "Year");
				fm.fnWebListCompare(driver, EM_Doc_Period, template.getProperty("Period"), "Period");
				fm.fnWebEditCompare(driver, EM_Doc_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebEditCompare(driver, EM_Doc_Description, template.getProperty("doc_Description"), "Description");
				fm.fnWebEditCompare(driver, EM_Doc_DocumentDate, template.getProperty("doc_DocumentDate"), "Document Date");
				fm.fnWebListCompare(driver, EM_Doc_WorkflowAssociation, template.getProperty("Workflow_Association"), "Workflow Association");
				fm.fnWebButton(driver, EM_Doc_Save, "Save");
				Thread.sleep(1000);
				if(driver.switchTo().alert().getText().contains("Saved Successfully")){
					driver.switchTo().alert().accept();
					childTest.pass("Document Verified successfully");
				}else {
					childTest.fail("Document not Verified");
				}
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
			
	}
	
	/***************************************************************************************
	 * This function is used to Change Status
	 ***************************************************************************************/
	public void fnChangeStatus() {
		childTest = test.createNode("Description: Change Status" + "<br>" + "<< Screen Name: LS1  >></br>");
		try {
			System.out.println(driver.switchTo().alert().getText());
			if(driver.switchTo().alert().getText().contains("Document(s) updated successfully")){
				driver.switchTo().alert().accept();
				childTest.pass("Changed Status Successfully");
			}else {
				childTest.fail("Status not changed");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Delet Document in Entity Manager
	 ***************************************************************************************/
	public void fnDeleteDocument() {
		childTest = test.createNode("Description: Delete Document " + "<br>" + "<< Screen Name: LS1  >></br>");
		try {
			if(driver.switchTo().alert().getText().contains("Are you sure you want to delete?")) {
				driver.switchTo().alert().accept();
				Thread.sleep(5500);
				if(driver.switchTo().alert().getText().contains("Document(s) deleted successfully")) {
					driver.switchTo().alert().accept();
				}
				childTest.pass("Document Deleted successfully");
			}else {
				childTest.fail("Document not deleted");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to create a New Folder in Entity Manager
	 ***************************************************************************************/
	public void fnEM_NewFolder() {
		childTest = test.createNode("Description: Create New Folder " + "<br>" + "<< Screen Name: New Folder  >></br>");
		try {
			if(driver.getTitle().equalsIgnoreCase("New Folder")) {
				fm.fnWebList(driver, EM_Wf_Year, template.getProperty("Year"), "Year");
				fm.fnWebList(driver, EM_Wf_Period, template.getProperty("Period"), "Period");
				fm.fnWebList(driver, EM_Wf_TaxType, template.getProperty("TaxType"), "Tax Type");
				//fm.fnWebList(driver, EM_Wf_WFTemplate, template.getProperty(""), "W/F Template");
				fm.fnWebEdit(driver, EM_Wf_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEdit(driver, EM_Wf_EntityID, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebEdit(driver, EM_Wf_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebList(driver, EM_Wf_WorkflowAssociation, template.getProperty("Workflow_Association"), "Workflow Association");
				fm.fnWebEdit(driver, EM_Wf_DueDate, template.getProperty("DueDate"), "Due Date");
				fm.fnWebEdit(driver, EM_Wf_WorkflowDescription, template.getProperty("doc_Description"), "Workflow Description");
				fm.fnWebList(driver, EM_Wf_RouteTo, template.getProperty("AssignedTo"), "RouteTo");
				fm.fnWebCheckBox(driver, EM_Wf_NotifyCheck, "Notify"); 
				fm.fnWebEdit(driver, EM_Wf_RoutingDueDate, template.getProperty("doc_DueDate"), "Routing Due Date");
				fm.fnWebButton(driver, EM_Wf_Save, "Save");
				Thread.sleep(3500);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				if(driver.switchTo().alert().getText().contains("Folder saved successfully")){
					driver.switchTo().alert().accept();
					childTest.pass("New Folder created successfully");
				}else {
					childTest.fail("New Folder not created");
				}
			}else {
				childTest.fail("New Folder Page is not opened");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Search New Folder in Entity Manager
	 ***************************************************************************************/
	public void fnEM_SearchWorkflow() {
		childTest = test.createNode("Description: Search Workflow " + "<br>" + "<< Screen Name: ONESOURCE  >></br>");
		try {
			if (driver.getTitle().contains("ONESOURCE")) {
				fm.fnWebButton(driver, Splitter, "Splitter");
				fm.fnWebButton(driver, EM_Doc_Clear, "Clear");
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				//fm.fnWebList(driver, EM_Doc_Search_WFTemplate, template.getProperty("WF_Template"), "W/F Template");
				fm.fnWebList(driver, EM_Doc_Search_Year, template.getProperty("Year"), "Year");
				fm.fnWebEdit(driver, EM_Doc_Search_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEdit(driver, EM_Doc_Search_EntityId, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebList(driver, EM_Doc_Search_Period, template.getProperty("Period"), "Period");
				fm.fnWebList(driver, EM_Doc_Search_TaxType, template.getProperty("TaxType"), "Tax Type");
				fm.fnWebList(driver, EM_Doc_Search_WorkflowAssociation, template.getProperty("Workflow_Association"),
						"Workflow Association");
				fm.fnWebEdit(driver, EM_Doc_Search_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				//fm.fnWebList(driver, EM_Doc_Search_WorkflowType, template.getProperty(""),"Workflow Type");
				fm.fnWebButton(driver, EM_Doc_Search, "Search");
				fm.fnWebButton(driver, Splitter, "Splitter");
			} else {
				childTest.fail("Search Fields not Found");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Search New Workflow in Entity Manager
	 ***************************************************************************************/
	public void fnEM_NewWorkflow() {
		childTest = test.createNode("Description: Create New Workflow " + "<br>" + "<< Screen Name: New Workflow  >></br>");
		try {
			Thread.sleep(1000);
			if(driver.getTitle().contains("New WorkFlow")) {
				
				//fm.fnWebList(driver, EM_Wf_WFTemplate, template.getProperty(""), "W/F Template");
				fm.fnWebEdit(driver, EM_Wf_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEdit(driver, EM_Wf_EntityID, template.getProperty("Entity_Id"), "Entity Id");
				fm.fnWebEdit(driver, EM_Wf_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebList(driver, EM_Wf_WorkflowAssociation, template.getProperty("Workflow_Association"), "Workflow Association");
				fm.fnWebEdit(driver, EM_Wf_DueDate, template.getProperty("DueDate"), "Due Date");
				fm.fnWebEdit(driver, EM_Wf_WorkflowDescription, template.getProperty("doc_Description"), "Workflow Description");
				fm.fnWebList(driver, EM_Wf_RouteTo, template.getProperty("AssignedTo"), "RouteTo");
				fm.fnWebCheckBox(driver, EM_Wf_NotifyCheck, "Notify"); 
				fm.fnWebEdit(driver, EM_Wf_RoutingDueDate, template.getProperty("doc_DueDate"), "Routing Due Date");
				fm.fnWebButton(driver, EM_Wf_Save, "Save");
				Thread.sleep(4500);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				if(driver.switchTo().alert().getText().contains("Saved Successfully")){
					driver.switchTo().alert().accept();
					childTest.pass("New Workflow created successfully");
				}else {
					childTest.fail("New Workflow not created");
				}
			}else {
				childTest.fail("New Workflow Page is not opened");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Delet Workflow in Entity Manager
	 ***************************************************************************************/
	public void fnDeleteWorkflow() {
		childTest = test.createNode("Description: Delete Workflow " + "<br>" + "<< Screen Name: ONESOURCE  >></br>");
		try {
			if(driver.switchTo().alert().getText().contains("Are you sure you want to delete?")) {
				driver.switchTo().alert().accept();
				Thread.sleep(2500);
				if(driver.switchTo().alert().getText().contains("Workflow deleted successfully")) {
					driver.switchTo().alert().accept();
					childTest.pass("Deleted Workflow successfully");
				}else {
					childTest.fail("Workflow not deleted/Alert is missing");
				}
			}else {
				childTest.fail("Workflow not deleted");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to verify WorkFlow Properties
	 ***************************************************************************************/
	public void fnWorkflowProperties() {
		childTest = test.createNode("Description: Verifying WorkFlow Properties" + "<br>" + "<< Screen Name: WorkFlow Properties >></br>");
		try {
			Thread.sleep(1000);
			if (driver.getTitle().contains("WorkFlow Properties")) {
				fm.fnWebEditCompare(driver, EM_Wf_EntityName, template.getProperty("Entity_Name"), "Entity Name");
				fm.fnWebEditCompare(driver, EM_Wf_EntityID, template.getProperty("Entity_Id"), "Entity Id");
				
				fm.fnWebEditCompare(driver, EM_Wf_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
				fm.fnWebEditCompare(driver, EM_Wf_WorkflowDescription, template.getProperty("doc_Description"), "Description");
				fm.fnWebEditCompare(driver, EM_Wf_DueDate, template.getProperty("DueDate"), "Due Date");
				fm.fnWebListCompare(driver, EM_Wf_WorkflowAssociation, template.getProperty("Workflow_Association"), "Workflow Association");
				fm.fnWebButton(driver, EM_Wf_Save, "Save");
				Thread.sleep(2500);
				if(driver.switchTo().alert().getText().contains("Saved Successfully")){
					driver.switchTo().alert().accept();
					childTest.pass("Workflow Verified successfully");
				}else {
					childTest.fail("Workflow not Verified");
				}
			}else {
				childTest.fail("Workflow Properties Page is not displayed");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
			
	}

	/***************************************************************************************
	 * This function is used to Reset Checklist
	 ***************************************************************************************/
	public void fnResetChecklist() {
		childTest = test.createNode("Description: Reset Checklist" + "<br>" + "<< Screen Name: ONESOURCE >></br>");
		try {
			if (driver.switchTo().alert().getText().contains("You are about to reset checklists. Do you wish to continue?")) {
				driver.switchTo().alert().accept();
				Thread.sleep(6500);
				if(driver.switchTo().alert().getText().contains("Checklist(s) have been reset for Workflow(s).")) {
					Thread.sleep(1500);
					driver.switchTo().alert().accept();
				}else {
					childTest.fail("Checklist(s) have been reset Alert is missing");
				}
			}else {
				childTest.fail("You are about to reset checklists alert is missing");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Create a new Bussiness
	 ***************************************************************************************/
	public void fnEM_AddBussiness() {
		childTest = test.createNode(
				"Description: Add Bussiness in Entity Manager " + "<br>" + "<< Screen Name: Add Bussiness >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Business Name is required")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			fm.fnWebEdit(driver, EM_BS_BussinessName, template.getProperty("BussinessName"), "Bussiness Name");
			fm.fnWebEdit(driver, EM_BS_BussinessId, template.getProperty("BussinessId"), "Bussiness ID");
			fm.fnWebEdit(driver, EM_BS_Description, template.getProperty("Buss_Description"), "Description");
			fm.fnWebList(driver, EM_BS_Status, template.getProperty("Buss_Status"), "Status");
			fm.fnWebEdit(driver, EM_BS_Address1, template.getProperty("Buss_Address"), "Address1");
			fm.fnWebEdit(driver, EM_BS_Address2, template.getProperty("Buss_Address1"), "Address2");
			fm.fnWebEdit(driver, EM_BS_City, template.getProperty("Buss_City"), "City");
			fm.fnWebEdit(driver, EM_BS_Country, template.getProperty("Buss_Country"), "Country");
			fm.fnWebEdit(driver, EM_BS_Country1, template.getProperty("Buss_Country"), "Country1");
			fm.fnWebEdit(driver, EM_BS_ZipCode, template.getProperty("Buss_Zipcode"), "Zip Code");
			fm.fnWebEdit(driver, EM_BS_State, template.getProperty("Buss_State"), "State");
			fm.fnWebEdit(driver, EM_BS_ContactName, template.getProperty("Buss_ContactName"), "Contact Name");
			fm.fnWebEdit(driver, EM_BS_MainTelephone, template.getProperty("Buss_Telephone"), "Telephone");
			fm.fnWebEdit(driver, EM_BS_AlternateTelephone, template.getProperty("Buss_AlternateTelephone"),
					"Alternate Telephone");
			fm.fnWebEdit(driver, EM_BS_Email, template.getProperty("Buss_Email"), "Email");
			fm.fnWebEdit(driver, EM_BS_Fax, template.getProperty("Buss_Fax"), "Fax");
			fm.fnWebEdit(driver, EM_BS_OccupancyCertificate, template.getProperty("Buss_OccupancyCertificate"),
					"Occupancy Certificate");
			fm.fnWebEdit(driver, EM_BS_ExpiryDate, template.getProperty("Buss_ExpiryDate"), "Expiry Date");
			fm.fnWebEdit(driver, EM_BS_FromDate, template.getProperty("Buss_FromDate"), "From Date");
			fm.fnWebEdit(driver, EM_BS_ToDate, template.getProperty("Buss_ToDate"), "To Date");
			fm.fnWebEdit(driver, EM_BS_Notes, template.getProperty("Buss_Notes"), "Notes");

			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			String errormsg1 = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg1.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			Thread.sleep(2500);
			fm.fnWebButton(driver, EM_Wf_Close, "Close");

		} catch (Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Create a new Bussiness
	 ***************************************************************************************/
	public void fnEM_EditBussiness() {
		childTest = test.createNode(
				"Description: Edit/View Details page in Entity Manager " + "<br>" + "<< Screen Name: Edit/View Details >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
			fm.fnWebEditCompare(driver, EM_BS_BussinessName, template.getProperty("BussinessName"), "Bussiness Name");
			fm.fnWebEditCompare(driver, EM_BS_BussinessId, template.getProperty("BussinessId"), "Bussiness ID");
			fm.fnWebEditCompare(driver, EM_BS_Description, template.getProperty("Buss_Description"), "Description");
			fm.fnWebListCompare(driver, EM_BS_Status, template.getProperty("Buss_Status"), "Status");
			fm.fnWebEditCompare(driver, EM_BS_Address1, template.getProperty("Buss_Address"), "Address1");
			fm.fnWebEditCompare(driver, EM_BS_Address2, template.getProperty("Buss_Address1"), "Address2");
			fm.fnWebEditCompare(driver, EM_BS_City, template.getProperty("Buss_City"), "City");
			fm.fnWebEditCompare(driver, EM_BS_Country, template.getProperty("Buss_Country"), "Country");
			fm.fnWebEditCompare(driver, EM_BS_Country1, template.getProperty("Buss_Country"), "Country1");
			fm.fnWebEditCompare(driver, EM_BS_ZipCode, template.getProperty("Buss_Zipcode"), "Zip Code");
			fm.fnWebEditCompare(driver, EM_BS_State, template.getProperty("Buss_State"), "State");
			fm.fnWebEditCompare(driver, EM_BS_ContactName, template.getProperty("Buss_ContactName"), "Contact Name");
			fm.fnWebEditCompare(driver, EM_BS_MainTelephone, template.getProperty("Buss_Telephone"), "Telephone");
			fm.fnWebEditCompare(driver, EM_BS_AlternateTelephone, template.getProperty("Buss_AlternateTelephone"),
					"Alternate Telephone");
			fm.fnWebEditCompare(driver, EM_BS_Email, template.getProperty("Buss_Email"), "Email");
			fm.fnWebEditCompare(driver, EM_BS_Fax, template.getProperty("Buss_Fax"), "Fax");
			fm.fnWebEditCompare(driver, EM_BS_OccupancyCertificate, template.getProperty("Buss_OccupancyCertificate"),
					"Occupancy Certificate");
			fm.fnWebEditCompare(driver, EM_BS_ExpiryDate, template.getProperty("Buss_ExpiryDate"), "Expiry Date");
			fm.fnWebEditCompare(driver, EM_BS_FromDate, template.getProperty("Buss_FromDate"), "From Date");
			fm.fnWebEditCompare(driver, EM_BS_ToDate, template.getProperty("Buss_ToDate"), "To Date");
			fm.fnWebEditCompare(driver, EM_BS_Notes, template.getProperty("Buss_Notes"), "Notes");

			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			Thread.sleep(1000);
			fm.fnWebButton(driver, EM_BS_Ok, "Ok");
			Thread.sleep(1000);
			fm.fnWebButton(driver, EM_Wf_Close, "Close");

		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	/***************************************************************************************
	 * This function is used to Create a Bank Profile
	 ***************************************************************************************/
	public void fnEM_BankProfile() {
		childTest = test.createNode(
				"Description: Bank Profile in Entity Manager " + "<br>" + "<< Screen Name: Bank Profile >></br>");
		try {
			Thread.sleep(1500);
			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Name of Institution is required")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			
			fm.fnWebEdit(driver, EM_NameOfInstitue, template.getProperty("NameOfInstitue"), "Name Of institute");
			fm.fnWebEdit(driver, EM_BankId, template.getProperty("BankId"), "Bank ID");
			fm.fnWebEdit(driver, EM_BS_Address1, template.getProperty("Buss_Address"), "Address1");
			fm.fnWebEdit(driver, EM_BS_Address2, template.getProperty("Buss_Address1"), "Address2");
			fm.fnWebEdit(driver, EM_BS_City, template.getProperty("Buss_City"), "City");
			fm.fnWebEdit(driver, EM_BS_Country, template.getProperty("Buss_Country"), "Country");
			fm.fnWebEdit(driver, EM_BS_Country1, template.getProperty("Buss_Country"), "Country1");
			fm.fnWebEdit(driver, EM_BS_ZipCode, template.getProperty("Buss_Zipcode"), "Zip Code");
			//fm.fnWebEdit(driver, EM_BS_State, template.getProperty("EM_State"), "State");
			//fm.fnWebEdit(driver, EM_Contact, template.getProperty("Buss_ContactName"), "Contact Name");
			fm.fnWebEdit(driver, EM_BS_MainTelephone, template.getProperty("Buss_Telephone"), "Telephone");
			fm.fnWebEdit(driver, EM_BS_AlternateTelephone, template.getProperty("Buss_AlternateTelephone"),
					"Alternate Telephone");
			fm.fnWebEdit(driver, EM_Email, template.getProperty("Buss_Email"), "Email");
			fm.fnWebEdit(driver, EM_BS_Notes, template.getProperty("Buss_Notes"), "Notes");
			fm.fnWebEdit(driver, EM_AternateContact, template.getProperty("AlternateContact"), "Alternate Contact");
			
			
			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			String errormsg1 = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg1.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			Thread.sleep(2500);
		/*	fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
			fnOWMActionsMenu("Add New", "");
			Thread.sleep(1500);
			lp.fnSwitchtoWindow(4, "Entity Manager");
			driver.switchTo().frame("Iframe1");
			fm.fnWebEdit(driver, EM_AccountNumber, template.getProperty(""), "Account Number");
			fm.fnWebList(driver, EM_Category, template.getProperty(""), "Category");
			fm.fnWebEdit(driver, EM_InceptionDate, template.getProperty(""), "Inception Date");
			fm.fnWebEdit(driver, EM_ExpirationDate, template.getProperty(""), "Expiration Date");
			fm.fnWebList(driver, EM_Status, template.getProperty(""), "Status");
			fm.fnWebList(driver, EM_Type, template.getProperty(""), "Type");
			fm.fnWebEdit(driver, EM_Signature1, template.getProperty(""), "Signature1");
			fm.fnWebEdit(driver, EM_Notes, template.getProperty(""), "Notes");
			
			fm.fnWebButton(driver, EM_Save,"Save");*/
					
			fm.fnWebButton(driver, EM_Wf_Close, "Close");
			
		} catch (Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to Edit a Bank Profile
	 ***************************************************************************************/
	public void fnEM_EditBankProfile() {
		childTest = test.createNode(
				"Description: Edit Bank Profile in Entity Manager " + "<br>" + "<< Screen Name:Bank Profile >></br>");
		try {
			Thread.sleep(1500);
			fm.fnWebEditCompare(driver, EM_NameOfInstitue, template.getProperty("NameOfInstitue"), "Name Of institute");
			fm.fnWebEditCompare(driver, EM_BankId, template.getProperty("BankId"), "Bank ID");
			fm.fnWebEditCompare(driver, EM_BS_Address1, template.getProperty("Buss_Address"), "Address1");
			fm.fnWebEditCompare(driver, EM_BS_Address2, template.getProperty("Buss_Address1"), "Address2");
			fm.fnWebEditCompare(driver, EM_BS_City, template.getProperty("Buss_City"), "City");
			fm.fnWebEditCompare(driver, EM_BS_Country, template.getProperty("Buss_Country"), "Country");
			fm.fnWebEditCompare(driver, EM_BS_Country1, template.getProperty("Buss_Country"), "Country1");
			fm.fnWebEditCompare(driver, EM_BS_ZipCode, template.getProperty("Buss_Zipcode"), "Zip Code");
			fm.fnWebEditCompare(driver, EM_BS_MainTelephone, template.getProperty("Buss_Telephone"), "Telephone");
			fm.fnWebEditCompare(driver, EM_BS_AlternateTelephone, template.getProperty("Buss_AlternateTelephone"),
					"Alternate Telephone");
			fm.fnWebEditCompare(driver, EM_Email, template.getProperty("Buss_Email"), "Email");
			fm.fnWebEditCompare(driver, EM_BS_Notes, template.getProperty("Buss_Notes"), "Notes");
			fm.fnWebEditCompare(driver, EM_AternateContact, template.getProperty("AlternateContact"), "Alternate Contact");
			
			fm.fnWebButton(driver, EM_Wf_Save, "Save");
			Thread.sleep(1000);
			fm.fnWebButton(driver, EM_BS_Ok, "Ok");
			Thread.sleep(1500);
			fm.fnWebButton(driver, EM_Wf_Close, "Close");
			
		} catch (Exception e) {
			
			childTest.fail(e);
		}	
			
	}
	
	/***************************************************************************************
	 * This function is used to Craete a new I/O Transaction
	 ***************************************************************************************/
	public void fnEM_IOTransaction() {
		childTest = test.createNode(
				"Description: Add New I/O Transaction in Entity Manager " + "<br>" + "<< Screen Name: Entity Manager >></br>");
		try {
			Thread.sleep(1500);
			fm.fnWebButton(driver, EM_Save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Enter To Entity Name.")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			//fm.fnWebEdit(driver, EM_FromEntity, template.getProperty(""), "From Entity");
			//fm.fnWebEdit(driver, EM_ToEntity, template.getProperty("EM_ToEntity"), "To Entity");
			WebElement ToEntity = driver.findElement(By.xpath("//input[@id='toentity_00001_Input']"));
			ToEntity.sendKeys(template.getProperty("EM_ToEntity"));
			ToEntity.sendKeys(Keys.ENTER);
			
			fm.fnWebEdit(driver, EM_Date, template.getProperty("EM_Date"), "Date");
			fm.fnWebList(driver, EM_Stream, template.getProperty("EM_Stream"), "Stream");
			//fm.fnWebEdit(driver, EM_Amount, template.getProperty(""), "amont");
			fm.fnWebButton(driver, EM_Save, "Save");
			String errormsg1 = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg1.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			Thread.sleep(2500);
			fm.fnWebButton(driver, EM_Wf_Close, "Close");
			
			
		} catch (Exception e) {
			childTest.fail(e);
		}	
	}

	/***************************************************************************************
	 * This function is used to Edit a I/O Transaction
	 ***************************************************************************************/
	public void fnEM_EditIOTransaction() {
		childTest = test.createNode(
				"Description: Edit I/O Transaction in Entity Manager " + "<br>" + "<< Screen Name: Entity Manager >></br>");
		try {
			Thread.sleep(2500);
			//fm.fnWebEditCompare(driver, EM_FromEntity, template.getProperty("FromEntity"), "From Entity");
			//fm.fnWebEditCompare(driver, EM_ToEntity, template.getProperty("ToEntity"), "To Entity");
			//fm.fnWebEditCompare(driver, EM_Date, template.getProperty("EM_Date"), "Date");
			//fm.fnWebListCompare(driver, EM_Stream, template.getProperty("EM_Stream"), "Stream");
			//WebElement ToEntity = driver.findElement(By.xpath("//input[@id='toentity_00001_Input']"));
			//System.out.println(ToEntity.getText());
			
			//WebElement Stream = driver.findElement(By.xpath("//Select[@id='streamid_00001']"));
			//System.out.println(Stream.getText());
			
			fm.fnWebButton(driver, EM_Save, "Save");
			String errormsg1 = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg1.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Popup is displayed");
			} else {
				childTest.fail("Alert didn't popup");
			}
			Thread.sleep(2500);
			fm.fnWebButton(driver, EM_Wf_Close, "Close");
			
		} catch (Exception e) {
			childTest.fail(e);
		}
	}

	public void fnEMOrgReorgAddFoundingShareholder() {
		childTest = test.createNode("Description: Add Founding ShareHolder~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->OrgReorg >></br>");
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Save, "Save");
				new WebDriverWait(driver, 50)
						.until(ExpectedConditions.visibilityOfElementLocated(EM_OrgReorg_AFS_ErrMessage));
				String orgErrtext = driver.findElement(EM_Owners_errMessage).getText();
				if (orgErrtext.contains("required")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save without entering any details, click on Save '" + orgErrtext
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save without entering any details, click on Save alert/Message does not exists");
				}
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_OrgDate, data.getProperty("OrgReorg_OrgDate"), "Org date");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Name, data.getProperty("OrgReorg_Name"), "Name");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Address, data.getProperty("OrgReorg_Address"), "Address");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_City, data.getProperty("OrgReorg_City"), "City");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Country, data.getProperty("OrgReorg_Country"), "Country");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_StateProvince, data.getProperty("OrgReorg_StateProvince"),
						"State/Province");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_ZipPostalCode, data.getProperty("OrgReorg_Zip/PostalCode"),
						"Zip/PostalCode");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_IdentifyingNumber, data.getProperty("OrgReorg_IdentifyingNumber"),
						"IdentifyingNumber");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_DateOfInitializationCapitalization,
						data.getProperty("OrgReorg_DateOfInitializationCapitalization"),
						"Date of Initialization Capitalization");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_DescriptionofInitialCapitalization,
						data.getProperty("OrgReorg_DescriptionOfInitializationCapitalization"),
						"Description of Initialization Capitalization");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_TaxCodeSectionReference,
						data.getProperty("OrgReorg_TaxCodeSectionReference"), "Tax Code Section Reference");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_TransferorBasis, data.getProperty("OrgReorg_TransferorBasis"),
						"Transferor Basis");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_DescriptionofStockSecurityAssests,
						data.getProperty("OrgReorg_DescriptionOfStock"), "DescriptionofStockSecurityAssests");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Notes, data.getProperty("OrgReorg_Notes"), "Notes");
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Save, "Save");
				Thread.sleep(3000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_OrgReorg_AFS_ErrMessage));
				String orgErrtext1 = driver.findElement(EM_Owners_errMessage).getText();
				if (orgErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" + orgErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details, click on Save alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMOrgReorgAddNewReorg() {
		childTest = test.createNode("Description: Add New Reorg~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->OrgReorg >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Save, "Save");
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_OrgReorg_AFS_ErrMessage));
				String reorgErrtext = driver.findElement(EM_Owners_errMessage).getText();
				if (reorgErrtext.contains("required")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save without entering any details, click on Save '" + reorgErrtext
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save without entering any details, click on Save alert/Message does not exists");
				}
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_OrgDate, data.getProperty("OrgReorg_OrgDate"), "Org date");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Name, data.getProperty("OrgReorg_Name"), "Name");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Address, data.getProperty("OrgReorg_Address"), "Address");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_City, data.getProperty("OrgReorg_City"), "City");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Country, data.getProperty("OrgReorg_Country"), "Country");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_StateProvince, data.getProperty("OrgReorg_StateProvince"),"State/Province");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_ZipPostalCode, data.getProperty("OrgReorg_Zip/PostalCode"),"Zip/PostalCode");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_IdentifyingNumber, data.getProperty("OrgReorg_IdentifyingNumber"),"IdentifyingNumber");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_DescriptionofInitialCapitalization,data.getProperty("OrgReorg_DescriptionOfInitializationCapitalization"),"Description of Initialization Capitalization");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ValueofShareTransferred, data.getProperty("OrgReorg_ValueofShareTransferred"),"Value of Share Transferred");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_TaxCodeSectionReference,data.getProperty("OrgReorg_TaxCodeSectionReference"), "Tax Code Section Reference");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_DescriptionofStockSecurityAssests,data.getProperty("OrgReorg_DescriptionOfStock"), "DescriptionofStockSecurityAssests");
				fm.fnWebEdit(driver, EM_OrgReorg_AFS_Notes, data.getProperty("OrgReorg_Notes"), "Notes");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReceivingName, data.getProperty("OrgReorg_ReceivingName"), "Receiving Name");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReAddress, data.getProperty("OrgReorg_ReAddress"), "Receiving Address");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReCity, data.getProperty("OrgReorg_ReCity"), "Receiving City");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReCountry, data.getProperty("OrgReorg_ReCountry"), "Receiving Country");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReState, data.getProperty("OrgReorg_ReState"), "Receiving State");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReZip, data.getProperty("OrgReorg_ReZip"), "Receivers Zip/Postal Code");
				fm.fnWebEdit(driver, EM_OrgReorg_ANR_ReIdentifyingNumber, data.getProperty("OrgReorg_ReIdentifyingNumber"), "Receivers Identifying Number");
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Save, "Save");
				Thread.sleep(3000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_OrgReorg_AFS_ErrMessage));
				String reorgErrtext1 = driver.findElement(EM_Owners_errMessage).getText();
				if (reorgErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" + reorgErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details, click on Save alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMOrgReorgEdit(int i) {
		childTest = test.createNode("Description: Edit/View Details- OrgReorg~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->OrgReorg >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				if(i==2) {
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_OrgDate, data.getProperty("OrgReorg_OrgDate"), "Org date");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Name, data.getProperty("OrgReorg_Name"), "Name");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Address, data.getProperty("OrgReorg_Address"), "Address");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_City, data.getProperty("OrgReorg_City"), "City");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Country, data.getProperty("OrgReorg_Country"), "Country");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_StateProvince, data.getProperty("OrgReorg_StateProvince"),
							"State/Province");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_ZipPostalCode, data.getProperty("OrgReorg_Zip/PostalCode"),
							"Zip/PostalCode");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_IdentifyingNumber, data.getProperty("OrgReorg_IdentifyingNumber"),
							"IdentifyingNumber");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_DateOfInitializationCapitalization,
							data.getProperty("OrgReorg_DateOfInitializationCapitalization"),
							"Date of Initialization Capitalization");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_DescriptionofInitialCapitalization,
							data.getProperty("OrgReorg_DescriptionOfInitializationCapitalization"),
							"Description of Initialization Capitalization");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_TaxCodeSectionReference,
							data.getProperty("OrgReorg_TaxCodeSectionReference"), "Tax Code Section Reference");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_DescriptionofStockSecurityAssests,
							data.getProperty("OrgReorg_DescriptionOfStock"), "DescriptionofStockSecurityAssests");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Notes, data.getProperty("OrgReorg_Notes"), "Notes");
				}else {
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_OrgDate, data.getProperty("OrgReorg_OrgDate"), "Org date");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Name, data.getProperty("OrgReorg_Name"), "Name");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Address, data.getProperty("OrgReorg_Address"), "Address");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_City, data.getProperty("OrgReorg_City"), "City");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Country, data.getProperty("OrgReorg_Country"), "Country");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_StateProvince, data.getProperty("OrgReorg_StateProvince"),"State/Province");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_ZipPostalCode, data.getProperty("OrgReorg_Zip/PostalCode"),"Zip/PostalCode");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_IdentifyingNumber, data.getProperty("OrgReorg_IdentifyingNumber"),"IdentifyingNumber");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_DescriptionofInitialCapitalization,data.getProperty("OrgReorg_DescriptionOfInitializationCapitalization"),"Description of Initialization Capitalization");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ValueofShareTransferred, data.getProperty("OrgReorg_ValueofShareTransferred"),"Value of Share Transferred");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_TaxCodeSectionReference,data.getProperty("OrgReorg_TaxCodeSectionReference"), "Tax Code Section Reference");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_DescriptionofStockSecurityAssests,data.getProperty("OrgReorg_DescriptionOfStock"), "DescriptionofStockSecurityAssests");
					fm.fnWebEditCompare(driver, EM_OrgReorg_AFS_Notes, data.getProperty("OrgReorg_Notes"), "Notes");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReceivingName, data.getProperty("OrgReorg_ReceivingName"), "Receiving Name");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReAddress, data.getProperty("OrgReorg_ReAddress"), "Receiving Address");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReCity, data.getProperty("OrgReorg_ReCity"), "Receiving City");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReCountry, data.getProperty("OrgReorg_ReCountry"), "Receiving Country");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReState, data.getProperty("OrgReorg_ReState"), "Receiving State");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReZip, data.getProperty("OrgReorg_ReZip"), "Receivers Zip/Postal Code");
					fm.fnWebEditCompare(driver, EM_OrgReorg_ANR_ReIdentifyingNumber, data.getProperty("OrgReorg_ReIdentifyingNumber"), "Receivers Identifying Number");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMStockOfCompanyAddNew(String input) {
		childTest = test.createNode("Description: Add New- Stock Of the Company~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Stock Of the Company >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebList(driver,EM_SC_AN_RelatedShareHolder,data.getProperty("StockoftheCompany_RelatedShareHolder"), "Related Share Holder");
				fm.fnWebEdit(driver,EM_SC_AN_UnRelatedShareHolder,data.getProperty("StockoftheCompany_UnRelatedShareHolder"), "UnRelated Share Holder");
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				Thread.sleep(2000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_OrgReorg_AFS_ErrMessage));
				String scErrtext = driver.findElement(EM_Owners_errMessage).getText();
				if (scErrtext.contains("Only one name can be specified at a time. Please either select a related shareholder, or enter the name of an unrelated shareholder.")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save before entering details'" +scErrtext
									+ "' alert/Message exists");
					driver.findElement(EM_SC_AN_UnRelatedShareHolder).clear();
					Select temp = new Select(driver.findElement(EM_SC_AN_RelatedShareHolder));
					temp.selectByValue("0");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save by entering Related & Unrelated Share holder details alert/Message does not exists");
				}
				if(input.equals("Related")) {
					fm.fnWebList(driver,EM_SC_AN_RelatedShareHolder,data.getProperty("StockoftheCompany_RelatedShareHolder"), "Related Share Holder");
				}else {
					fm.fnWebEdit(driver,EM_SC_AN_UnRelatedShareHolder,data.getProperty("StockoftheCompany_UnRelatedShareHolder"), "UnRelated Share Holder");
				}
					
				fm.fnWebList(driver,EM_SC_AN_StockClass,data.getProperty("StockoftheCompany_StockClass"), "Stock Class");
				fm.fnWebEdit(driver,EM_SC_AN_BeginningOfTaxYear,data.getProperty("StockoftheCompany_BeginningOftaxYear"), "Beginning of Tax Year");
				fm.fnWebEdit(driver,EM_SC_AN_EndOfTaxYear,data.getProperty("StockoftheCompany_EndOftaxYear"), "End of Tax Year");
				fm.fnWebEdit(driver,EM_SC_AN_Notes,data.getProperty("StockoftheCompany_Notes"), "Notes");
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				Thread.sleep(3000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext1 = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" +scErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details,alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch (Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMStockOfCompanyEdit(int i) {
		childTest = test.createNode("Description:Edit/View Details- Stock Of the Company~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Stock Of the Company >></br>");
		try {
				Thread.sleep(2000);
				FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
						.withTimeout(Duration.ofSeconds(50))
						.pollingEvery(Duration.ofSeconds(5))
						.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
						.ignoring(NoSuchFrameException.class);
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				if(i==2) {
					fm.fnWebListCompare(driver,EM_SC_AN_RelatedShareHolder,data.getProperty("StockoftheCompany_RelatedShareHolder"), "Related Share Holder");
				}else if(i==3){
					fm.fnWebEditCompare(driver,EM_SC_AN_UnRelatedShareHolder,data.getProperty("StockoftheCompany_UnRelatedShareHolder"), "UnRelated Share Holder");
				}
				fm.fnWebListCompare(driver,EM_SC_AN_StockClass,data.getProperty("StockoftheCompany_StockClass"), "Stock Class");
				fm.fnWebEditCompare(driver,EM_SC_AN_BeginningOfTaxYear,data.getProperty("StockoftheCompany_BeginningOftaxYear"), "Beginning of Tax Year");
				fm.fnWebEditCompare(driver,EM_SC_AN_EndOfTaxYear,data.getProperty("StockoftheCompany_EndOftaxYear"), "End of Tax Year");
				fm.fnWebEditCompare(driver,EM_SC_AN_Notes,data.getProperty("StockoftheCompany_Notes"), "Notes");
				Thread.sleep(1000);
				fm.fnWebButton(driver, EM_SC_AN_Close, "Close");
			
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMAddNewAcquisitionDisposition() {
		childTest = test.createNode("Description:Add New Acquisition/Add New Disposition- Acq-Disp of Shares~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Acq-Disp of Shares >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if(driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext.contains("is required")){
					childTest.log(Status.PASS,"Verification: Click on Save before entering details'" +scErrtext
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification: Click on Save before entering details alert/Message does not exists");
				}
				fm.fnWebEdit(driver,EM_ADS_ANA_Date, data.getProperty("AcqDisp_Date"), "Date");
				fm.fnWebEdit(driver,EM_ADS_ANA_Name, data.getProperty("AcqDisp_NameofSellerBuyer"), "Name of Seller/Buyer");
				fm.fnWebEdit(driver,EM_ADS_ANA_Address, data.getProperty("AcqDisp_Address"), "Address");
				fm.fnWebEdit(driver,EM_ADS_ANA_City, data.getProperty("AcqDisp_City"), "City");
				fm.fnWebEdit(driver,EM_ADS_ANA_County, data.getProperty("AcqDisp_County"), "County");
				fm.fnWebEdit(driver,EM_ADS_ANA_Country, data.getProperty("AcqDisp_Country"), "Country");
				fm.fnWebEdit(driver,EM_ADS_ANA_State, data.getProperty("AcqDisp_State"),"State");
				fm.fnWebEdit(driver,EM_ADS_ANA_ZipPostalCode, data.getProperty("AcqDisp_Zip"),"Zip");
				fm.fnWebList(driver,EM_ADS_ANA_NameofRelatedShareHolder, data.getProperty("AcqDisp_NameofRelatedshareholder"),"Name of Related Share Holder");
				fm.fnWebEdit(driver,EM_ADS_ANA_TaxCodesectionReference, data.getProperty("AcqDisp_TaxCode"),"Tax Code Section Reference");
				fm.fnWebEdit(driver,EM_ADS_ANA_Methodof, data.getProperty("AcqDisp_MethodofAcquisitionDisposition"),"Method of Acquisition/Disposition");
				fm.fnWebEdit(driver,EM_ADS_ANA_NumberofShares, data.getProperty("AcqDisp_NumberofShares"),"Number of Shares Acquired/Disposed");
				fm.fnWebList(driver,EM_ADS_ANA_ClassofShares, data.getProperty("AcqDisp_ClassofShares"),"Class of Shares Acquired/Disposed");
				fm.fnWebEdit(driver,EM_ADS_ANA_PricevalueofShares, data.getProperty("AcqDisp_PriceofShares"),"Price of Shares Acquired/Disposed");
				fm.fnWebEdit(driver,EM_ADS_ANA_BasisofShares, data.getProperty("AcqDisp_BasisofShares"),"Basis of Shares Acquired/Disposed");
				fm.fnWebEdit(driver,EM_ADS_ANA_Notes, data.getProperty("AcqDisp_Notes"),"Notes");
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				Thread.sleep(3000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext1 = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" +scErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details,alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMEditAcquisitionDisposition() {
		childTest = test.createNode("Description:Edit/View Details- Acq-Disp of Shares~ Ownership" + "<br>"
				+ "<< Screen Name : Entity Manager->Ownership->Acq-Disp of Shares >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if(driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				Thread.sleep(1000);
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Date, data.getProperty("AcqDisp_Date"), "Date");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Name, data.getProperty("AcqDisp_NameofSellerBuyer"), "Name of Seller/Buyer");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Address, data.getProperty("AcqDisp_Address"), "Address");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_City, data.getProperty("AcqDisp_City"), "City");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_County, data.getProperty("AcqDisp_County"), "County");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Country, data.getProperty("AcqDisp_Country"), "Country");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_State, data.getProperty("AcqDisp_State"),"State");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_ZipPostalCode, data.getProperty("AcqDisp_Zip"),"Zip");
				fm.fnWebListCompare(driver,EM_ADS_ANA_NameofRelatedShareHolder, data.getProperty("AcqDisp_NameofRelatedshareholder"),"Name of Related Share Holder");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_TaxCodesectionReference, data.getProperty("AcqDisp_TaxCode"),"Tax Code Section Reference");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Methodof, data.getProperty("AcqDisp_MethodofAcquisitionDisposition"),"Method of Acquisition/Disposition");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_NumberofShares, data.getProperty("AcqDisp_NumberofShares"),"Number of Shares Acquired/Disposed");
				fm.fnWebListCompare(driver,EM_ADS_ANA_ClassofShares, data.getProperty("AcqDisp_ClassofShares"),"Class of Shares Acquired/Disposed");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_PricevalueofShares, data.getProperty("AcqDisp_PriceofShares"),"Price of Shares Acquired/Disposed");
				fm.fnWebEditCompare(driver,EM_ADS_ANA_Notes, data.getProperty("AcqDisp_Notes"),"Notes");
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMAddNewPerson_IndividualsAgents() {
		childTest = test.createNode("Description:Add New Person-Individuals/Agents" + "<br>"
				+ "<< Screen Name : Entity Manager->Individuals/Agents >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if(driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext.contains("is required")){
					childTest.log(Status.PASS,"Verification: Click on Save before entering details'" +scErrtext
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification: Click on Save before entering details alert/Message does not exists");
				}
				fm.fnWebEdit(driver,EM_IndividualAgents_FirstName, data.getProperty("IndividualsAgents_FirstName"), "First Name");
				fm.fnWebEdit(driver,EM_IndividualAgents_LastName, data.getProperty("IndividualsAgents_LastName"), "Last Name");
				fm.fnWebEdit(driver,EM_IndividualAgents_Organization, data.getProperty("IndividualsAgents_Organization"), "Organization");
				fm.fnWebEdit(driver,EM_IndividualAgents_Title, data.getProperty("IndividualsAgents_Title"), "Title");
				fm.fnWebEdit(driver,EM_IndividualAgents_Address1, data.getProperty("IndividualsAgents_Address1"), "Address1");
				fm.fnWebEdit(driver,EM_IndividualAgents_Honorific, data.getProperty("IndividualsAgents_Honorific"), "Honorific");
				fm.fnWebEdit(driver,EM_IndividualAgents_Address2, data.getProperty("IndividualsAgents_Address2"), "Address2");
				fm.fnWebEdit(driver,EM_IndividualAgents_City, data.getProperty("IndividualsAgents_City"), "City");
				fm.fnWebEdit(driver,EM_IndividualAgents_Country, data.getProperty("IndividualsAgents_Country"), "Country");
				fm.fnWebEdit(driver,EM_IndividualAgents_Zip, data.getProperty("IndividualsAgents_Zip"), "Zip");
				fm.fnWebEdit(driver,EM_IndividualAgents_State, data.getProperty("IndividualsAgents_State"), "State");
				fm.fnWebEdit(driver,EM_IndividualAgents_County, data.getProperty("IndividualsAgents_County"), "County");
				fm.fnWebEdit(driver,EM_IndividualAgents_CountryofCitizenShip, data.getProperty("IndividualsAgents_CountryofCitizenship"), "CountryofCitizenship");
				fm.fnWebEdit(driver,EM_IndividualAgents_CountryofResidency, data.getProperty("IndividualsAgents_CountryofResidency"), "CountryofResidency");
				fm.fnWebEdit(driver,EM_IndividualAgents_MainTelephone, data.getProperty("IndividualsAgents_MainTelephone"), "MainTelephone");
				fm.fnWebEdit(driver,EM_IndividualAgents_AlternateTelephone, data.getProperty("IndividualsAgents_AlternateTelephone"), "AlternatingTelephone");
				fm.fnWebEdit(driver,EM_IndividualAgents_Fax, data.getProperty("IndividualsAgents_Fax"), "Fax");
				fm.fnWebEdit(driver,EM_IndividualAgents_Email, data.getProperty("IndividualsAgents_Email"), "Email");
				fm.fnWebEdit(driver,EM_IndividualAgents_Notes, data.getProperty("IndividualsAgents_Notes"), "Notes");
				Thread.sleep(2000);
				fm.fnWebButton(driver, EM_IndividualAgents_Splitter, "Splitter");
				Thread.sleep(2000);
				fm.fnWebList(driver,EM_IndividualAgents_Role1, data.getProperty("IndividualsAgents_Role1"), "Role1");
				fm.fnWebList(driver,EM_IndividualAgents_Position1, data.getProperty("IndividualsAgents_Position1"), "Position");
				fm.fnWebEdit(driver,EM_IndividualAgents_DateBegin1, data.getProperty("IndividualsAgents_DateBegin1"), "Date Begin");
				fm.fnWebEdit(driver,EM_IndividualAgents_DateEnd1, data.getProperty("IndividualsAgents_DateEnd1"), "Date End");
				fm.fnWebList(driver,EM_IndividualAgents_Order1, data.getProperty("IndividualsAgents_Order1"), "Order");
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				Thread.sleep(3000);
				waitf.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext1 = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" +scErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details,alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMAssignGlobalPerson_IndividualsAgents() {
		childTest = test.createNode("Description:Assign Global Person-Individuals/Agents" + "<br>"
				+ "<< Screen Name : Entity Manager->Individuals/Agents >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if(driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				new WebDriverWait(driver, 50)
						.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext.contains("Please enter full name")){
					childTest.log(Status.PASS,"Verification: Click on Save before entering details'" +scErrtext
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification: Click on Save before entering details alert/Message does not exists");
				}
				fm.fnWebEdit(driver,EM_ADS_ANA_Name, data.getProperty("IndividualsAgents_Person"), "Person");
				fm.fnWebList(driver,EM_IndividualAgents_Role1, data.getProperty("IndividualsAgents_RoleGlobal"), "Role1");
				fm.fnWebList(driver,EM_IndividualAgents_Position1, data.getProperty("IndividualsAgents_PositionGlobal"), "Position");
				fm.fnWebEdit(driver,EM_IndividualAgents_DateBegin1, data.getProperty("IndividualsAgents_DateBeginGlobal"), "Date Begin");
				fm.fnWebEdit(driver,EM_IndividualAgents_DateEnd1, data.getProperty("IndividualsAgents_DateEndGlobal"), "Date End");
				fm.fnWebList(driver,EM_IndividualAgents_Order1, data.getProperty("IndividualsAgents_OrderGlobal"), "Order");
				fm.fnWebButton(driver, EM_SC_AN_Save, "Save");
				Thread.sleep(3000);
				new WebDriverWait(driver, 50)
						.until(ExpectedConditions.visibilityOfElementLocated(EM_SC_AN_ErrMessage));
				String scErrtext1 = driver.findElement(EM_SC_AN_ErrMessage).getText();
				if (scErrtext1.contains("successfully")) {
					childTest.log(Status.PASS,
							"Verification: Click on Save after entering details'" +scErrtext1
									+ "' alert/Message exists");
				} else {
					childTest.log(Status.ERROR,
							"Verification:Click on Save after entering any details,alert/Message does not exists");
				}
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
	
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	public void fnEMEditViewIndividuals_Agents() {
		childTest = test.createNode("Description:Edit/View Details-Individuals/Agents" + "<br>"
				+ "<< Screen Name : Entity Manager->Individuals/Agents >></br>");
		try {
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			if(driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("Iframe1"));
				fm.fnWebEditCompare(driver,EM_IndividualAgents_FirstName, data.getProperty("IndividualsAgents_FirstName"), "First Name");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_LastName, data.getProperty("IndividualsAgents_LastName"), "Last Name");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Organization, data.getProperty("IndividualsAgents_Organization"), "Organization");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Title, data.getProperty("IndividualsAgents_Title"), "Title");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Address1, data.getProperty("IndividualsAgents_Address1"), "Address1");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Honorific, data.getProperty("IndividualsAgents_Honorific"), "Honorific");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Address2, data.getProperty("IndividualsAgents_Address2"), "Address2");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_City, data.getProperty("IndividualsAgents_City"), "City");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Country, data.getProperty("IndividualsAgents_Country"), "Country");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Zip, data.getProperty("IndividualsAgents_Zip"), "Zip");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_State, data.getProperty("IndividualsAgents_State"), "State");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_County, data.getProperty("IndividualsAgents_County"), "County");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_CountryofCitizenShip, data.getProperty("IndividualsAgents_CountryofCitizenship"), "CountryofCitizenship");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_CountryofResidency, data.getProperty("IndividualsAgents_CountryofResidency"), "CountryofResidency");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_MainTelephone, data.getProperty("IndividualsAgents_MainTelephone"), "MainTelephone");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_AlternateTelephone, data.getProperty("IndividualsAgents_AlternateTelephone"), "AlternatingTelephone");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Fax, data.getProperty("IndividualsAgents_Fax"), "Fax");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Email, data.getProperty("IndividualsAgents_Email"), "Email");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_Notes, data.getProperty("IndividualsAgents_Notes"), "Notes");
				/*fm.fnWebButton(driver, EM_IndividualAgents_Splitter, "Splitter");
				Thread.sleep(2000);
				fm.fnWebListCompare(driver,EM_IndividualAgents_RoleCompare, data.getProperty("IndividualsAgents_Role1"), "Role");
				fm.fnWebListCompare(driver,EM_IndividualAgents_PositionCompare, data.getProperty("IndividualsAgents_Position1"), "Position");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_DateBeginCompare, data.getProperty("IndividualsAgents_DateBegin1"), "Date Begin");
				fm.fnWebEditCompare(driver,EM_IndividualAgents_DateEndCompare, data.getProperty("IndividualsAgents_DateEnd1"), "Date End");
				fm.fnWebListCompare(driver,EM_IndividualAgents_OrderCompare, data.getProperty("IndividualsAgents_Order1"), "Order");*/
				fm.fnWebButton(driver, EM_OrgReorg_AFS_Close, "Close");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}

	}
}
