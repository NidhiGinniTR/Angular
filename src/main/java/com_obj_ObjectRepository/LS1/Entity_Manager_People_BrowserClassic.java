package com_obj_ObjectRepository.LS1;


import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork2;

public class Entity_Manager_People_BrowserClassic extends ExtentManager{
	WebDriver driver;
	Properties template;

	
	FrameWork2 fm = new FrameWork2();
	public Entity_Manager_People_BrowserClassic(WebDriver driver, Properties data2) {
		this.driver = driver;
		this.template = data2;
	}
	/************Navigate to people browser tab***************/
	
	By people_browser = By.xpath("//table[@id='TabStrip1_1']");
	
	/************Navigate to Actions and add new ***************/
	
	By people_browser_Actions = By.xpath("//img[@id='btnActionsMenu']");
	By people_browser_AddNew = By.xpath("//td[@id='mnuPeopleBrowser_0']");
	
	/************Create New Individual profile***************/
	
	By indProfile_FirstName = By.xpath("//input[@id='firstname']");
	By indProfile_LastName = By.xpath("//input[@id='lastname']");
	By indProfile_MiddleInit = By.xpath("//input[@id='middleinitial']");
	By indProfile_Organization = By.xpath("//input[@id='organization']");
	By indProfile_Title = By.xpath("//input[@id='title']");
	By indProfile_Addressone = By.xpath("//input[@id='address1']");
	By indProfile_Addresstwo = By.xpath("//input[@id='address2']");
	By indProfile_Country = By.xpath("//input[@id='country_Input']");
	By indProfile_State = By.xpath("//input[@id='state_Input']");
	By indProfile_Citizenship = By.xpath("//input[@id='citizenship_Input']");
	By indProfile_MainTelephone = By.xpath("//input[@id='mainphone']");
	By indProfile_Fax = By.xpath("//input[@id='fax']");
	By indProfile_Honorific = By.xpath("//input[@id='honorific']");
	By indProfile_City = By.xpath("//input[@id='city']");
	By indProfile_PostalCode = By.xpath("//input[@id='zip']");
	By indProfile_County = By.xpath("//input[@id='county']");
	By indProfile_ResidenceCountry = By.xpath("//input[@id='residency_Input']");
	By indProfile_Alternatephone = By.xpath("//input[@id='alternatephone']");
	By indProfile_Email = By.xpath("//input[@id='email']");
	By indProfile_notes = By.xpath("//textarea[@id='notes']");
	By indProfile_Save = By.xpath("//img[@id='btnSave']");
	By indProfile_Close = By.xpath("//img[@id='btnClose']");
	
	/**************Search Profile**************************/
	
	By search_firstName = By.xpath("//select[@id='SearchControl3']");
	By search_LastName = By.xpath("//select[@id='SearchControl4']");
	By search_Role = By.xpath("//select[@id='SearchControl5']");
	By search_Responsibility = By.xpath("//select[@id='SearchControl7']");
	By search_Residence = By.xpath("//select[@id='SearchControl8']");
	By search_Citizenship = By.xpath("//select[@id='SearchControl9']");
	By search_Begdate = By.xpath("//input[@id='SearchControl11']");
	By search_Enddate = By.xpath("//input[@id='SearchControl12']");
	By search_search = By.xpath("//img[@id='imgbtnSearch']");
	By search_clear = By.xpath("//img[@id='img1']");
	
	
	/********************Copy To New***************************/
	
	By firstName_ToCopy = By.xpath("//input[@id='firstname']");
	By lastName_ToCopy = By.xpath("//input[@id='lastname']");
	By middleName_ToCopy = By.xpath("//input[@id='middleinitial']");
	By save_ToCopy = By.xpath("//img[@id='Img2']");
	By close_ToCopy = By.xpath("//img[@id='Img3']");
	
	/********************Save All Preferences***************************/
	
	By save_pref = By.xpath("//button[@id='dialog-button-close']");
	By save_pref_All = By.xpath("//button[@id='dialog-button-action']");
	
	/********************Purge***************************/
	
	By purge = By.xpath("//input[@id='btnPurge']");
	By cancel = By.xpath("//input[@id='btnCancel']");
	
	/*******************Add Role To Entity************/
	
	By pb_roles_positions_Entity = By.xpath("//input[@id='entity_Input']");
	By pb_roles_positions_Role = By.xpath("//select[@id='role_0']");
	By pb_roles_positions_Position = By.xpath("//select[@id='position_0']");
	By pb_roles_positions_Begdate = By.xpath("//input[@id='datebegin_0']");
	By pb_roles_positions_Enddate = By.xpath("//input[@id='dateend_0'");
	By pb_roles_positions_Order = By.xpath("//select[@id='order_0']");
	By pb_roles_positions_AddNewRole = By.xpath("//img[@id='btnAddRole']");
	By pb_roles_positions_Save = By.xpath("//img[@id='btnSave']");
	By pb_roles_positions_close = By.xpath("//img[@id='btnClose']");
	
	/************************Role Edit*********************/
	
	By Pb_roles_positions_editBegdate = By.xpath("//input[@id='datebegin_14']");
	By Pb_roles_positions_editOrder = By.xpath("//select[@id='order_14']");
	By pb_roles_positions_RoleEdit = By.xpath("//select[@id='role_14']");
	By pb_roles_positions_PositionEdit = By.xpath("//select[@id='position_14']");

	
	
	
	
	

	/************************************************************************/
	/** This function is used for navigate to people browser			 */
	/************************************************************************/
			
	public void navigate_ToPeopleBrowser() throws InterruptedException {
		childTest = test.createNode(
				"Description: Navigating to People Browser Tab " + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		String title = driver.getTitle();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.switchTo().frame("maincontent");
//			driver.switchTo().frame("app_iFrame");
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebButton(driver, people_browser, "People_Browser");
			String pplbrowser = driver.findElement(By.xpath("//div[@id='divheader']")).getText();
			if(pplbrowser.equalsIgnoreCase("People Browser")) {
				childTest.pass("Navigated to the people browser tab");
			}
			else {
				childTest.fail("People Browser not launched");
			}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}

	/************************************************************************/
	/** This function is used to click on actions button					 */
	/************************************************************************/
	
	public void actions() throws InterruptedException {
		childTest = test.createNode(
				"Description: Click on add new " + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebButton(driver, people_browser_Actions, "Actions");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
		

	/************************************************************************/
	/** This function is used to create individual in people browser		 */
	/************************************************************************/
	
	public void create_Individual() throws InterruptedException {
		childTest = test.createNode(
				"Description: Giving all values to create individual " + "<br>" + "<<Screen Name: Individual Profile >></br>");
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, indProfile_FirstName, template.getProperty("First_Name"), "First_Name");
		fm.fnWebEdit(driver, indProfile_LastName, template.getProperty("Last_Name"), "Last_Name");
		fm.fnWebEdit(driver, indProfile_MiddleInit, template.getProperty("Middle_Initial"), "Middle_Initial");
		fm.fnWebEdit(driver, indProfile_Organization, template.getProperty("Organization"), "Organization");
		fm.fnWebEdit(driver, indProfile_Title, template.getProperty("indProfile_Title"), "indProfile_Title");
		fm.fnWebEdit(driver, indProfile_Addressone, template.getProperty("Address_one"), "Address_one");
		fm.fnWebEdit(driver, indProfile_Addresstwo, template.getProperty("Address_two"), "Address_two");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, indProfile_Country, template.getProperty("indProfile_Country"), "indProfile_Country");
		fm.fnWebEdit(driver, indProfile_State, template.getProperty("indProfile_State"), "indProfile_State");
		fm.fnWebEdit(driver, indProfile_Citizenship, template.getProperty("indProfile_Citizenship"), "indProfile_Citizenship");
		fm.fnWebEdit(driver, indProfile_MainTelephone, template.getProperty("Main_Telephone"), "Main_Telephone");
		fm.fnWebEdit(driver, indProfile_Fax, template.getProperty("indProfile_Fax"), "indProfile_Fax");
		fm.fnWebEdit(driver, indProfile_Honorific, template.getProperty("indProfile_Honorific"), "indProfile_Honorific");
		fm.fnWebEdit(driver, indProfile_City, template.getProperty("indProfile_City"), "indProfile_City");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, indProfile_PostalCode, template.getProperty("indProfile_PostalCode"), "indProfile_PostalCode");
		fm.fnWebEdit(driver, indProfile_County, template.getProperty("indProfile_County"), "indProfile_County");
		fm.fnWebEdit(driver, indProfile_ResidenceCountry, template.getProperty("indProfile_ResidenceCountry"), "indProfile_ResidenceCountry");
		fm.fnWebEdit(driver, indProfile_Alternatephone, template.getProperty("indProfile_Alternatephone"), "indProfile_Alternatephone");
		fm.fnWebEdit(driver, indProfile_Email, template.getProperty("indProfile_Email"), "indProfile_Email");
		//fm.fnWebEdit(driver, indProfile_notes, template.getProperty("indProfile_notes"), "indProfile_notes");
		Thread.sleep(2000);
		fm.fnWebButton(driver, indProfile_Save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		fm.fnWebButton(driver, indProfile_Close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}

	/************************************************************************/
	/** This function is used to Search created profile in people browser	 */
	/************************************************************************/
	
	public void search_IndProfile() throws InterruptedException {
		childTest = test.createNode(
				"Description: Search for Entity" + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		
		try {
		
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.findElement(By.xpath("//img[@id='imgSplitter']")).click();
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			//fm.fnWebList(driver, search_firstName, template.getProperty("search_firstName"), "search_firstName");
//			//fm.fnWebList(driver, search_LastName, template.getProperty("search_LastName"), "search_LastName");
//			Select first_name = new Select(driver.findElement(By.xpath("//select[@id='SearchControl3']")));
//			Select last_name = new Select(driver.findElement(By.xpath("//select[@id='SearchControl4']")));
//			first_name.selectByVisibleText("naresh");
//			last_name.selectByVisibleText("goud");
//			fm.fnWebButton(driver, search_search, "Search");
			WebElement profile = driver.findElement(By.xpath(("//tr[@id='gridPeopleBrowser_grdEntityManager_row_0']")));
			if(profile.isDisplayed()) {
				childTest.pass(" Profile Search Passed");
							profile.click();			}
			else {
				childTest.fail("Profile Search Failed");
			}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
		
	}
	

	/************************************************************************/
	/** This function is used to edit the individual profile				 */
	/************************************************************************/
	
	public void editIndividual() throws InterruptedException {
		childTest = test.createNode(
				"Description: Edit the Individual in People Browser" + "<br>" + "<<Screen Name: Individual Profile >></br>");
		try {
			fm.fnWebEdit(driver, indProfile_MainTelephone, template.getProperty("Main_TelephoneEdit"), "Main_TelephoneEdit");
			fm.fnWebEdit(driver, indProfile_Fax, template.getProperty("indProfile_FaxEdit"), "indProfile_FaxEdit");
			fm.fnWebEdit(driver, indProfile_Alternatephone, template.getProperty("indProfile_AlternatephoneEdit"), "indProfile_AlternatephoneEdit");
			fm.fnWebEdit(driver, indProfile_Email, template.getProperty("indProfile_EmailEdit"), "indProfile_EmailEdit");
			
			Thread.sleep(2000);
			fm.fnWebButton(driver, indProfile_Save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Entered data was saved successfully");
			}
			try {
				WebElement save_changes = driver.findElement(By.xpath("//button[@id='dialog-button-close']"));
				if(save_changes.isDisplayed()) {
					save_changes.click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					fm.fnWebButton(driver, indProfile_Close, "Close");
				}
				}
				catch(Exception e) {
					fm.fnWebButton(driver, indProfile_Close, "Close");
				}
				
			}
			catch(Exception e) {
				childTest.fail(e);
		}
		
}

	/************************************************************************/
	/** This function is used to perform double click operation on profile	 */
	/************************************************************************/
	
	public void doubleclick_OnProfile() throws InterruptedException {
		childTest = test.createNode(
				"Description: Double click on Entity" + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		try {
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.switchTo().frame("maincontent");
//			driver.switchTo().frame("app_iFrame");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("gridFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//div[@id='gridPeopleBrowser_grdEntityManager_dom']/table[1]/tbody[1]/tr[2]"))).doubleClick().build().perform();
			childTest.info("Navigated to edit window");
		}
		catch(Exception e) {
			childTest.fail(e);
	}
		
}

	/************************************************************************/
	/** This function is used to View details and verify profile		 */
	/************************************************************************/
	
	public void view_IndividualProfile() throws InterruptedException {
		childTest = test.createNode(
				"Description: View and Verify  " + "<br>" + "<<Screen Name: Individual Profile >></br>");
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, indProfile_FirstName, template.getProperty("First_Name"), "First_Name");
		fm.fnWebEditCompare(driver, indProfile_LastName, template.getProperty("Last_Name"), "Last_Name");
		fm.fnWebEditCompare(driver, indProfile_MiddleInit, template.getProperty("Middle_Initial"), "Middle_Initial");
		fm.fnWebEditCompare(driver, indProfile_Organization, template.getProperty("Organization"), "Organization");
		fm.fnWebEditCompare(driver, indProfile_Title, template.getProperty("indProfile_Title"), "indProfile_Title");
		fm.fnWebEditCompare(driver, indProfile_Addressone, template.getProperty("Address_one"), "Address_one");
		fm.fnWebEditCompare(driver, indProfile_Addresstwo, template.getProperty("Address_two"), "Address_two");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, indProfile_Country, template.getProperty("indProfile_Country"), "indProfile_Country");
		fm.fnWebEditCompare(driver, indProfile_State, template.getProperty("indProfile_State"), "indProfile_State");
		fm.fnWebEditCompare(driver, indProfile_Citizenship, template.getProperty("indProfile_Citizenship"), "indProfile_Citizenship");
		fm.fnWebEditCompare(driver, indProfile_MainTelephone, template.getProperty("Main_TelephoneEdit"), "Main_TelephoneEdit");
		fm.fnWebEditCompare(driver, indProfile_Fax, template.getProperty("indProfile_FaxEdit"), "indProfile_FaxEdit");
		fm.fnWebEditCompare(driver, indProfile_Honorific, template.getProperty("indProfile_Honorific"), "indProfile_Honorific");
		fm.fnWebEditCompare(driver, indProfile_City, template.getProperty("indProfile_City"), "indProfile_City");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, indProfile_PostalCode, template.getProperty("indProfile_PostalCode"), "indProfile_PostalCode");
		fm.fnWebEditCompare(driver, indProfile_County, template.getProperty("indProfile_County"), "indProfile_County");
		fm.fnWebEditCompare(driver, indProfile_ResidenceCountry, template.getProperty("indProfile_ResidenceCountry"), "indProfile_ResidenceCountry");
		fm.fnWebEditCompare(driver, indProfile_Alternatephone, template.getProperty("indProfile_AlternatephoneEdit"), "indProfile_AlternatephoneEdit");
		fm.fnWebEditCompare(driver, indProfile_Email, template.getProperty("indProfile_EmailEdit"), "indProfile_EmailEdit");
		//fm.fnWebEditCompare(driver, indProfile_notes, template.getProperty("indProfile_notes"), "indProfile_notes");
		Thread.sleep(2000);
		
		fm.fnWebButton(driver, indProfile_Close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}

	/************************************************************************/
	/** This function is used to Perform copy to new operation	 */
	/************************************************************************/
	
	public void copyToNew() throws InterruptedException {
		childTest = test.createNode(
				"Description: Copy to new  " + "<br>" + "<<Screen Name: Copy People >></br>");
		try {
			Thread.sleep(3000);
			fm.fnWebEdit(driver, firstName_ToCopy, template.getProperty("FirstName_ToCopy"), "FirstName_ToCopy");
			fm.fnWebEdit(driver, lastName_ToCopy, template.getProperty("LastName_ToCopy"), "LastName_ToCopy");
			fm.fnWebEdit(driver, middleName_ToCopy, template.getProperty("MiddleName_ToCopy"), "MiddleName_ToCopy");
			fm.fnWebButton(driver, save_ToCopy, "Save");
			fm.fnWebButton(driver, close_ToCopy, "Close");
				
		}
		catch(Exception e) {
			childTest.fail(e);
		}
	}
	

	/************************************************************************/
	/** This function is used to perform Replace operation		 */
	/************************************************************************/
	
	public void verifyReplace() {
		childTest = test.createNode(
				"Description: Verify the role replacing " + "<br>" + "<<Screen Name: Replace Roles >></br>");
		try {
			WebElement replace = driver.findElement(By.xpath("//span[@id='replacedpersonname']"));
			if(replace.isDisplayed()) {
				childTest.pass("The role is replaced and assigned to someone");
				driver.findElement(By.xpath("//img[@id='btnClose']")).click();
			}
			
		}
		catch(Exception e) {
			childTest.fail(e);
		}
		
	}
	

	/************************************************************************/
	/** This function is used to click and navigate to actions elements		 */
	/************************************************************************/
	
	
	public  void fnOWMActionsMenu( String item, String subItem) throws InterruptedException {
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
	
	/************************************************************************/
	/** This function is used to click and navigate to actions elements		 */
	/************************************************************************/
	
	
	public  void fnOWMClassicActionsMenu( String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
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

	/************************************************************************/
	/** This function is used to verify Customize view						 */
	/************************************************************************/
	
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
		fm.fnWebButton(driver, By.xpath("//input[@id='btnSave']"), "Save");
	}

	
	

	/************************************************************************/
	/** This function is used to perform Save Preferences			 */
	/************************************************************************/
	
	public void fnSavePreferences(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: LS1 >></br>");

		if (menuitem.equals("Save Preferences for All")) {
			Thread.sleep(1500);
			//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("You are about to change preferences for all users. Please Confirm.")) {
				Thread.sleep(1000);
				fm.fnWebButton(driver, save_pref_All, "Yes");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("Saved successfully.")) {
					Thread.sleep(1000); 
					fm.fnWebButton(driver, save_pref, "Save");
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
				fm.fnWebButton(driver, save_pref, "Save");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}
	

	/************************************************************************/
	/** This function is used to Delete the Individual profile			 */
	/************************************************************************/
	
	public void deleteEntity(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Delete Entity" + "<br>" + "<< Screen Name: LS1 >></br>");
		try {
		
		if (menuitem.equals("Delete Entity")) {
			fm.fnWebButton(driver, purge, "Delete");
			childTest.info("The entity has been deleted");
		}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
	}
	

	/************************************************************************/
	/** This function is used to add New Role and Position to profile		 */
	/************************************************************************/
	
	
	public void add_NewRoleandPosition() {
		childTest = test.createNode("Description: Assigning new roles and position" + "<br>" + "<< Screen Name: Entity Manager >></br>");
		try {
			WebElement entity = driver.findElement(By.xpath("//span[@id='spaEntName']"));
			if(entity.isDisplayed()){
				Thread.sleep(1000);
				driver.switchTo().frame("Iframe1");
				fm.fnWebEdit(driver, pb_roles_positions_Entity, template.getProperty("Entity_ToAssignRole"), "Entity_ToAssignRole");
				fm.fnWebList(driver, pb_roles_positions_Role, template.getProperty("Assign_Role"), "Assign_Role");
				fm.fnWebList(driver, pb_roles_positions_Position, template.getProperty("Assign_Position"), "Assign_Position");
				fm.fnWebList(driver, pb_roles_positions_Order, template.getProperty("Assign_Order"), "Assign_Order");
				fm.fnWebEdit(driver, pb_roles_positions_Begdate, template.getProperty("Begin_Date"), "Begin_Date");
				//fm.fnWebEdit(driver,pb_roles_positions_Enddate, template.getProperty("End_Date"), "End_Date");
				fm.fnWebButton(driver, pb_roles_positions_AddNewRole, "Add_Role");
				fm.fnWebButton(driver, pb_roles_positions_Save, "Save");
				String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
				if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
					childTest.info("Entered data was saved successfully");
				}
				fm.fnWebButton(driver, pb_roles_positions_close, "Close");
			}
			
		}
		catch(Exception e) {
			childTest.fail(e);
		}
	}
	

	/************************************************************************/
	/** This function is used to navigate to actions elements on Profile page		 */
	/************************************************************************/
	
	public static void fnIPActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("Individual Profile")) {
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
	

	/************************************************************************/
	/** This function is used to edit the Role and Position		 */
	/************************************************************************/
	
	public void editRoleandPosition() {
		childTest = test.createNode(
				"Description: Edit the Individual in People Browser" + "<br>" + "<<Screen Name: Individual Profile >></br>");
		try {
			driver.switchTo().frame("Iframe1");
			fm.fnWebList(driver, Pb_roles_positions_editOrder, template.getProperty("Assign_OrderEdit"), "Assign_OrderEdit");
			fm.fnWebEdit(driver, Pb_roles_positions_editBegdate, template.getProperty("Begin_DateEdit"), "Begin_DateEdit");
			//fm.fnWebEdit(driver, pb_roles_positions_Enddate, template.getProperty("End_DateEdit"), "End_DateEdit");
			fm.fnWebButton(driver, pb_roles_positions_AddNewRole, "Add_Role");
			
			
			Thread.sleep(2000);
			fm.fnWebButton(driver, pb_roles_positions_Save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Entered data was saved successfully");
			}
			try {
				WebElement save_changes = driver.findElement(By.xpath("//button[@id='dialog-button-close']"));
				if(save_changes.isDisplayed()) {
					save_changes.click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					fm.fnWebButton(driver, pb_roles_positions_close, "Close");
				}
				}
				catch(Exception e) {
					fm.fnWebButton(driver, pb_roles_positions_close, "Close");
				}
				
			}
			catch(Exception e) {
				childTest.fail(e);
		}
		
		
	}
	

	/************************************************************************/
	/** This function is used to View Details and verify Role and Position		 */
	/************************************************************************/
	
	public void view_RoleandPosition() throws InterruptedException {
		childTest = test.createNode(
				"Description: View and Verify  " + "<br>" + "<<Screen Name: Entity Manager >></br>");
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("Iframe1");
		fm.fnWebEditCompare(driver, pb_roles_positions_Entity, template.getProperty("Entity_ToAssignRole"), "Entity_ToAssignRole");
		fm.fnWebListCompare(driver, pb_roles_positions_RoleEdit, template.getProperty("Assign_Role"), "Assign_Role");
		fm.fnWebListCompare(driver, pb_roles_positions_PositionEdit, template.getProperty("Assign_Position"), "Assign_Position");
		fm.fnWebListCompare(driver, Pb_roles_positions_editOrder, template.getProperty("Assign_OrderEdit"), "Assign_OrderEdit");
		fm.fnWebEditCompare(driver, Pb_roles_positions_editBegdate, template.getProperty("Begin_DateEdit"), "Begin_DateEdit");
		//fm.fnWebEdit(driver, pb_roles_positions_Enddate, template.getProperty("End_DateEdit"), "End_DateEdit");
		fm.fnWebButton(driver, pb_roles_positions_close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
	
	
	
	


}


