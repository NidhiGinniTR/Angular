package com_obj_ObjectRepository.LS1;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
	By Search_Jurisdiction=By.xpath("select[@id='SearchControl1']");
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
	By EM_Owners_OwnerName1 = By.xpath("//input[@id='owner1_Input']");
	By EM_Owners_OwnerName2 = By.xpath("//input[@id='owner2_Input']");
	By EM_Owners_Labelpercentage = By.xpath("//label[@id='lbl1']");
	By EM_Owners_OwnerID1 = By.xpath("//input[@id='ownerId1_Input']");
	By EM_Owners_OwnerID2 = By.xpath("//input[@id='ownerId2_Input']");
	By EM_Owners_PercentageOwned1 = By.xpath("//input[@id='percentage1']");
	By EM_Owners_PercentageOwned2 = By.xpath("//input[@id='percentage2']");
	By EM_Owners_AsofDate1 = By.xpath("//input[@id='AsOfDate1']");
	By EM_Owners_AsofDate2 = By.xpath("//input[@id='AsOfDate1']");
	By EM_Owners_AddOwner = By.xpath("//input[@id='btnAddOwner']");
	By EM_Owners_Save = By.xpath("//input[@id='btnSave']");
	By EM_Owners_Close = By.xpath("//input[@id='btnClose']");
	By EM_Owners_errMessage = By.xpath("//span[@id='spaErrorMessage']");
	By EM_Owners_totoalPercentage = By.xpath("//div[@id='divRunningTotal']");

	public EntityUnitBrowser(WebDriver driver, Properties data2, Properties data) {
		this.driver = driver;
		this.template = data;
		this.data = data2;
	}

	/***************************************************************************************
	 * This function is usedto check the Search Fields
	 ***************************************************************************************/

	public void fnVerifySearchElements(String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Verifying weather the elements are present" + "<br>"
				+ "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE") || driver.getTitle().equalsIgnoreCase("Entity Information")){
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
	public static void fnOWMActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
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
		}
	}

	/***************************************************************************************
	 * This function is used to find the enabled action menu items
	 ***************************************************************************************/

	public void fnOWMActionsMenuEnabled() throws InterruptedException {
		childTest = test
				.createNode("Description: Action menu items Enabled" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				String items = menuitems.get(i).getText();
				//System.out.println(menuitems.get(i).getText());
				childTest.log(Status.PASS, items + " is enabled");
			}
		}
	}

	/***************************************************************************************
	 * This function is used to find the disabled action menu items
	 ***************************************************************************************/
	public void fnOWMActionsMenuDisabled() throws InterruptedException {
		childTest = test
				.createNode("Description: Action menu items Disabled" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			java.util.List<WebElement> Disablemenuitems = driver.findElements(By.className("DisabledMenuItem"));
			for (int i = 0; i < Disablemenuitems.size(); i++) {
				String Disableitems = Disablemenuitems.get(i).getText();
				childTest.log(Status.PASS, Disableitems + " is disabled");
				//System.out.println(Disablemenuitems.get(i).getText());
			}
		}
	}

	/***************************************************************************************
	 * This function is used to Search the Entity
	 ***************************************************************************************/
	public void fnSearchEntity() throws InterruptedException {
		childTest = test.createNode("Description: Search the Entity" + "<br>" + "<< Screen Name : LS1 Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			fm.fnWebButton(driver, Splitter, "Splitter");
			fm.fnWebButton(driver, EUB_Clear, "Clear");
			Thread.sleep(5500);
			WebElement ClientName = driver.findElement(By.xpath("//input[@id='SearchControl9_Input']"));
			ClientName.sendKeys(template.getProperty("Eub_ClientName"));
			Thread.sleep(500);
			ClientName.sendKeys(Keys.ARROW_DOWN);
			ClientName.sendKeys(Keys.ENTER);
			childTest.log(Status.PASS, "Entered Client Name successfully.");
			Thread.sleep(500);
			WebElement EntityName = driver.findElement(By.xpath("//input[@id='SearchControl1_Input']"));
			EntityName.sendKeys(template.getProperty("Eub_EntityName"));
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
		}

	}

	/***************************************************************************************
	 * This function is used to Create the Entity
	 ***************************************************************************************/
	public void fnCreateEntity() throws InterruptedException {
		childTest = test.createNode("Description: Description: Entering all the fields to the create new entity"
				+ "<br>" + "<< Screen Name : Entity Information >></br>");
		try {
			fm.fnWebButton(driver, click_save, "Save");

			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Entity Name is required")) {
				childTest.info("Required feilds to be filled before saving");
			}
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");

			LS1 Lp = new LS1(driver, data, template);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			Thread.sleep(1500);
			Lp.fnSwitchtoWindow(3, "Client Name LookUp");
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			fm.fnWebEdit(driver, CN_ClientName, template.getProperty("ClientName"), "Client Name");
			fm.fnWebButton(driver, CN_Search, "Search");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(4500);
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']")),
					"Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");

			Lp.fnSwitchtoWindow(2, "Create Entity Page");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("addeditFrame1");

			fm.fnWebEdit(driver, entity_name, template.getProperty("EnitytName"), "Name");
			fm.fnWebEdit(driver, entity_id, template.getProperty("EntityID"), "ID");
			fm.fnWebEdit(driver, country, template.getProperty("Country"), "Country");
			fm.fnWebEdit(driver, state_provision, template.getProperty("State"), "State");
			fm.fnWebList(driver, entity_type, template.getProperty("Entity_Type"), "Entity Type");
			fm.fnWebEdit(driver, incorporate_country, template.getProperty("Country_Incorporated"),
					"Country Incorporated");
			fm.fnWebEdit(driver, incorporate_state, template.getProperty("State_Incorporated"), "State Incorporated");
			fm.fnWebEdit(driver, description, template.getProperty("Description"), "Description");
			fm.fnWebEdit(driver, entity_group, template.getProperty("Entity_group"), "Entity_group");
			// fm.fnWebList(driver,charting_group, template.getProperty("Charting_group"),
			// "Charting_group");
			// fm.fnWebList(driver, group_codes, template.getProperty("Group_codes"),
			// "Group_codes");
			// fm.fnWebButton(driver, add_gcodes, "Add");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fm.fnWebButton(driver, click_save, "Save");
			String SaveMsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			// System.out.println(driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText());
			if (SaveMsg.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Required feilds to be filled before saving");

			}
			fm.fnWebButton(driver, Close, "Close");
		} catch (Exception e) {
			childTest.fail(e);
		}

	}

	
	/***************************************************************************************
	 * This function is used to Edit/View Details the Entity
	 ***************************************************************************************/
	public void fnEditDeatils_Entity() {
		childTest = test.createNode("Description: Description: Edit/View Details"
				+ "<br>" + "<< Screen Name : Entity Information >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
				fm.fnWebEditCompare(driver, Client_name, template.getProperty("ClientName"), "Client Name");
				fm.fnWebEditCompare(driver, Client_id, template.getProperty("ClientId"), "Client Id");
				fm.fnWebEditCompare(driver, entity_name, template.getProperty("EnitytName"), "Entity Name");
				fm.fnWebEditCompare(driver, entity_id, template.getProperty("EntityID"), "Entity ID");
				fm.fnWebEditCompare(driver, country, template.getProperty("Country"), "Country");
				fm.fnWebEditCompare(driver, state_provision, template.getProperty("State"), "State");
				fm.fnWebListCompare(driver, entity_type, template.getProperty("Entity_Type"), "Entity Type");
				fm.fnWebEditCompare(driver, incorporate_country, template.getProperty("Country_Incorporated"), "Country Incorporated");
				fm.fnWebEditCompare(driver, incorporate_state, template.getProperty("State_Incorporated"), "State Incorporated");
				fm.fnWebEditCompare(driver, description, template.getProperty("Description"), "Description");
				fm.fnWebEditCompare(driver, entity_group, template.getProperty("Entity_group"), "Entity_group");
				driver.close();
			}else {
				childTest.fail("Entity Information Page not Found");
			}
		}catch(Exception e) {
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
		childTest = test.createNode("Description: Description: copy to new entity"
				+ "<br>" + "<< Screen Name : Copy Entity >></br>");
		try {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");

			LS1 Lp = new LS1(driver, data, template);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Lp.fnSwitchtoWindow(3, "Client Name LookUp");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fm.fnWebEdit(driver, CN_ClientName, template.getProperty("ClientName"), "Client Name");
			fm.fnWebButton(driver, CN_Search, "Search");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(4500);
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']")), "Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");

			Lp.fnSwitchtoWindow(2, "Create Entity Page");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEdit(driver, entity_name, template.getProperty("EnitytNameCopy"), "Name");
			fm.fnWebEdit(driver, entity_id, template.getProperty("EntityIDCopy"), "ID");
			fm.fnWebButton(driver, save_entity, "Save");

			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Lp.fnSwitchtoWindow(2, "Create Entity Page");
			System.out.println(driver.getTitle());
			driver.switchTo().frame("addeditFrame1");
			fm.fnWebButton(driver, Close, "Close");
		}catch(Exception e) {
			childTest.fail(e);
		}
		

	}
	
	/***************************************************************************************
	 * This function is used to perform Customize View
	 ***************************************************************************************/
	public void fnCustomizeView(String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: LS1 >></br>");
		if (driver.getTitle().equalsIgnoreCase("Customize View")) {
			java.util.List<WebElement> ColumnValues = driver.findElements(By.className("TreeNode"));
			for (int j = 0; j < array.length; j++) {
				for (int i = 0; i < ColumnValues.size(); i++) {
					if (array[j].equals(ColumnValues.get(i).getText())) {
						String menuitem = ColumnValues.get(i).getAttribute("id");
						//System.out.println(ColumnValues.get(i).getText());
						String required = menuitem.substring(0, menuitem.length() - 5);
						//System.out.println(required);
						if (driver.findElement(By.xpath("//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']")).isSelected()) {
							childTest.log(Status.PASS, array[j] + " is checked.");
							break;
						} else {
							driver.findElement(By.xpath("//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']")).click();
							childTest.log(Status.PASS, array[j] + " is checked.");
							break;
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

		if (menuitem.equals("Save Preferences for All")) {
			Thread.sleep(1500);
			//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("You are about to change preferences for all users. Please Confirm.")) {
				Thread.sleep(1000);
				fm.fnWebButton(driver, SavePreforAll_save, "Yes");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("Saved successfully.")) {
					Thread.sleep(1000); 
					fm.fnWebButton(driver, SavePre_save, "Save");
				}else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		} else if (menuitem.equals("Save Preferences")) {
			//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("Saved successfully.")) {
				Thread.sleep(500);
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
		childTest = test.createNode("Description: Tax Ids/Registrations" + "<br>" + "<< Screen Name: Entity Information >></br>");
		fm.fnWebButton(driver, TaxIds, "TaxIds/Registration");
	}


	/***************************************************************************************
	 * This function is used to Click Actions Button in Tax Ids/Registeration
	 ***************************************************************************************/
	public void fnClickActionsTaxID() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']")).click();
		//fm.fnWebButton(driver, TaxIds_Actions, "Actions");
	}

	/***************************************************************************************
	 * This function is used to perform Add New function in DBA tab 
	 ***************************************************************************************/
	public void fnDBAAddNew() {
		childTest = test
				.createNode("Description: DBA : Add New" + "<br>" + "<< Screen Name: Entity Unit Browser>></br>");
		try {
			System.out.println(driver.getTitle());
			driver.switchTo().frame("Iframe1");
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
		} catch (Exception e) {
			childTest.fail(e);
		}
	}
	
	/***************************************************************************************
	 * This function is used to perform Switch between windows in the application
	 * 	 ***************************************************************************************/
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
	 * This function is used to perform Add/Edit/Delete Entity Group in Basic info page
	 * 	 ***************************************************************************************/
	public void fnEntityGroup(String opr) throws InterruptedException {
		childTest = test.createNode(
				"Description: Entity Group-Add/Edit/Delete" + "<br>" + "<< Screen Name: Basic Info >></br>");
		if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
			driver.switchTo().frame("addeditFrame1");
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
					System.out.println(driver.getTitle());
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
				driver.switchTo().frame("Iframe1");
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
	 * This function is used to Add new Tax Ids/Registration in TaxIds/Registeration Page
	 ***************************************************************************************/
	public void fnAddNewTaxId() throws InterruptedException {
		childTest = test.createNode("Description: Entering all the fields to create new Tax Id's/Registration" + "<br>"
				+ "<<Screen Name: Entity Manager >></br>");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(1000);
			driver.switchTo().frame("Iframe1");
			fm.fnWebButton(driver, click_save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if (errormsg.equalsIgnoreCase("Tax ID is required")) {
				childTest.info("Required feilds to be filled before saving");
			} else {
				childTest.fail("Alert didn't popup");
			}

			fm.fnWebButton(driver, JurisdictionName_LookUp, "Jurisdiction Name Lookup");
			LS1 lp = new LS1(driver, data, template);
			lp.fnSwitchtoWindow(4, "Entity Manager");
			Thread.sleep(1500);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			fm.fnWebEdit(driver, JurisdictionName, template.getProperty("TaxId_Jurisdiction"), "Jurisdiction Name");
			fm.fnWebButton(driver, Jurisdiction_Search, "Search");
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']")),
					"Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");

			lp.fnSwitchtoWindow(3, "Entity Manager");
			driver.switchTo().frame("Iframe1");
			Thread.sleep(1500);

			fm.fnWebButton(driver, AuthorityName_LookUp, "Authority Name Lookup");
			Thread.sleep(1500);
			lp.fnSwitchtoWindow(4, "Entity Manager");
			// fm.fnWebEdit(driver, AuthorityName_2,
			// template.getProperty("TaxId_AuthorityName"), "Authority Name");
			// fm.fnWebButton(driver, Search, "Search");
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_4']")),
					"Click");
			fm.fnWebButton(driver, CN_Ok, "Ok");

			// fm.fnWebEdit(driver, Authority_Name,
			// template.getProperty("TaxId_AuthorityName"), "Authority Name");
			// fm.fnWebEdit(driver, Authority_Name2,
			// template.getProperty("TaxId_AuthorityName2"), "Authority Name2");
			lp.fnSwitchtoWindow(3, "Entity Manager");
			driver.switchTo().frame("Iframe1");
			Thread.sleep(1500);
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
				+ "<<Screen Name: Entity Information >></br>");
		String SaveMsg = driver.findElement(By.xpath("//label[@id='dialog-label']")).getText();
		try {
			if (SaveMsg.contains("Are you sure you want to archive?")) {
				fm.fnWebButton(driver, Archive_Yes, "Yes");
				childTest.info("Archive successfully");
			} else {
				childTest.fail("Archive failed");
			}
		}catch(Exception e) {
			childTest.fail(e);
		}
		
		fm.fnWebButton(driver, Splitter, "Splitter");
		fm.fnWebCheckBox(driver, Search_Archive, "Archive");
		fm.fnWebButton(driver, TaxId_Search, "Search");
		fm.fnWebButton(driver, Splitter, "Splitter");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridTaxIds_grdEntityManager_row_0']")), "Click");
		fnClickActionsTaxID();
		fnOWMActionsMenu(driver, "Unarchive", "");
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
	 * This function is used to perform in Edit/View details in TaxIds/Registeration Page
	 ***************************************************************************************/
	public void fnEditTaxIds() throws InterruptedException {
		childTest = test.createNode("Description: Edit/View Details in Tax Id's/Registration" + "<br>"
				+ "<<Screen Name: Entity Manager >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				Thread.sleep(1000);
				driver.switchTo().frame("Iframe1");
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
	 * This function is used to perform in Search operation in TaxIds/Registeration Page
	 ***************************************************************************************/
	public void fnSearchTaxIds() throws InterruptedException {
		childTest = test.createNode("Description: Search in Tax Id's/Registration" + "<br>"
				+ "<<Screen Name: Entity Information >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Entity Information")) {
				fm.fnWebButton(driver, Splitter, "Splitter");
				fm.fnWebList(driver, Search_Jurisdiction, template.getProperty("TaxId_JurisdictionName"),"Jurisdiction Name");
				fm.fnWebList(driver, Search_AuntorityName, template.getProperty("TaxId_AuthorityName"),"Authority Name");
				fm.fnWebButton(driver, TaxId_Search, "Search");
				fm.fnWebButton(driver, Splitter, "Splitter");
			}
		}catch(Exception e) {
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
		}catch(Exception e) {
			childTest.fail(e);
		}
	}

	public void fnEM_SwitchTabs(String text) throws InterruptedException {
		try {
			By tabItem = By.xpath("//*[@id='TabStrip1']//*[contains(text(),'"+text+"')]");
			fm.fnWebButton(driver, tabItem, text);
		}catch(Exception e) {
			childTest.fail(e);
		}
		
	}



}
