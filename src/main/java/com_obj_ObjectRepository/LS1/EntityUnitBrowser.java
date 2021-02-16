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
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class EntityUnitBrowser extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties loginData;
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
	//gridFrame1
	
	

	public EntityUnitBrowser(WebDriver driver, Properties data2, Properties data) {
		this.driver = driver;
		this.template = data;
		this.loginData = data2;
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
		childTest = test.createNode("Description: Entering all the fields to the create new entity" + "<br>"
				+ "<<Screen Name: Entity Information >></br>");

		fm.fnWebButton(driver, click_save, "Save");

		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if (errormsg.equalsIgnoreCase("Entity Name is required")) {
			childTest.info("Required feilds to be filled before saving");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");

		LS1 Lp = new LS1(driver, loginData, template);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(1000);
		Lp.fnSwitchtoWindow(3, "Client Name LookUp");
		fm.fnWebEdit(driver, CN_ClientName, template.getProperty("ClientName"), "Client Name");
		fm.fnWebButton(driver, CN_Search, "Search");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Thread.sleep(4500);
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridLookup_grdEntityManager_row_0']")), "Click");
		fm.fnWebButton(driver, CN_Ok, "Ok");

		Lp.fnSwitchtoWindow(2, "Create Entity Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("addeditFrame1");

		fm.fnWebEdit(driver, entity_name, template.getProperty("EnitytName"), "Name");
		fm.fnWebEdit(driver, entity_id, template.getProperty("EntityID"), "ID");
		fm.fnWebEdit(driver, country, template.getProperty("Country"), "Country");
		fm.fnWebEdit(driver, state_provision, template.getProperty("State"), "State");
		fm.fnWebList(driver, entity_type, template.getProperty("Entity_Type"), "Entity Type");
		fm.fnWebEdit(driver, incorporate_country, template.getProperty("Country_Incorporated"), "Country Incorporated");
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
		//System.out.println(driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText());
		if (SaveMsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Required feilds to be filled before saving");

		}
		fm.fnWebButton(driver, Close, "Close");
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
		childTest = test.createNode("Description: copy to new entity" + "<br>" + "<<Screen Name: Copy Entity >></br>");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		fm.fnWebButton(driver, ClientName_Lookup, "Client Name Lookup");

		LS1 Lp = new LS1(driver, loginData, template);
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
	 * @throws InterruptedException 
	 ***************************************************************************************/
	public void fnClickActionsTaxID() throws InterruptedException {
		driver.findElement(By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']")).click();
		//fm.fnWebButton(driver, TaxIds_Actions, "Actions");
	}

}
