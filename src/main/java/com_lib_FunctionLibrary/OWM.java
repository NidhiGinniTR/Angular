package com_lib_FunctionLibrary;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_obj_ObjectRepository.OWM.Navigations;
import com_obj_ObjectRepository.OWM.WorkFlowBrowser;

public class OWM extends ExtentManager {

	WebDriver driver;
	Properties template;
	loginPage lp;
	
	// *******Tab Selection*******
	By tabWorkFlowBrowser;
	By tabDocuments;
	By tabControlLog;
	By tabCalendar;
	By tabCalendarSetup;
	By tabReports;
	By tabDataFlow;
	By tabMyWork;
	By tabEntityBrowser;
	By tabSetup;
	By ftrClear;
	// *******New Folder**********
	By nf_Period;
	By nf_WFTemplate;
	By nf_EntityName;
	By nf_EntityID;
	By nf_Jurisdiction;
	By nf_SaveOK;
	By nf_cancel;
	By Actions;
	By nf_Year;
	By nf_TaxType;
	//******WorkflowBrowser Search*****
	By Sf_Clear;By Sf_Year;By Sf_Period;By Sf_TaxType;By Sf_WFTemplate;By Sf_EntityName;By Sf_EntityId;By Sf_Jurisdiction;
	By Sf_WorkflowAssociation;By Sf_WorkflowType;By Sf_GroupCodes;By Sf_Search;
	//*****New  Workflow & WorkflowProperties********
	By WFP_NWF_WFTemplate;By WFP_NWF_EntityName;By WFP_NWF_EntityID;By WFP_NWF_Jurisdiction;By WFP_NWF_DueDate;By WFP_NWF_WFDescription;
	By WFP_NWF_RIRouteToGroup;By WFP_NWF_RIRouteToPerson;By WFP_NWF_RIDueDate;By WFP_NWF_RI_CC_Email;By WFP_NWF_Save;
	//*****Customize View****************
	By CustView_Save;By CustView_Cancel;
	FrameWork2 fm = new FrameWork2();

	public OWM(WebDriver driver, Properties data2) {
		this.driver = driver;
		this.template = data2;
		/***************************************************************************************
		 * These element locators and function belongs to tab selection of Workflow
		 * manager
		 ***************************************************************************************/
		tabWorkFlowBrowser = By.xpath("//td[@id='FolderWorkflows']");
		tabDocuments = By.xpath("//td[@id='Documents']");
		tabControlLog = By.xpath("//[@id='ControlLog']");
		tabCalendar = By.xpath("//td[@id='TAXCAL_SCHEDULE_EVENTS']");
		tabCalendarSetup = By.xpath("//td[@id='TAXCAL_SETUP']");
		tabReports = By.xpath("//td[@id='ReportsFlow']");
		tabDataFlow = By.xpath("//td[@id='ReportsFlow']");
		tabMyWork = By.xpath("//[@id='MyWork']");
		tabEntityBrowser = By.xpath("//td[@id='TAXCAL_ENTITYTOPICBROWSER']");
		tabSetup = By.xpath("//td[@id='Setup']");
		ftrClear = By.xpath("//*[@id='btnCancel' and @title='Clear']");
		/***************************************************************************************
		 * These element locators belongs to OWM page of Onesource
		 ***************************************************************************************/
		Actions = By.xpath("//*[@id='spActions']");
		nf_Year = By.xpath("//*[@id='ctlval_fldr_4']");
		nf_TaxType = By.xpath("//*[@id='ctlval_fldr_6']");
		nf_Period = By.xpath("//*[@id='ctlval_fldr_5']");
		nf_WFTemplate = By.xpath("//*[@id='ctlval_fw_workflow_template_id']");
		nf_EntityName = By.xpath("//*[@id='ctlval_wf_14']");
		nf_EntityID = By.xpath("//*[@id='ctlval_wf_15']");
		nf_Jurisdiction = By.xpath("//*[@id='ctlval_wf_17']");
		nf_SaveOK = By.xpath("//*[@id='btnOK']");
		nf_cancel = By.xpath("//*[@id='btnCancel']");
		/***************************************************************************************
		 * These element locators and function belongs to search fields selection of Workflow
		 * manager
		 ***************************************************************************************/
		Sf_Clear = By.xpath(
				"//*[@id='btnCancel' and @title='Clear'] | //*[@class='btn btn-mini' and @title='Clear Search Criteria']");
		Sf_Year = By.xpath("//*[@id='fldr_4']");
		Sf_Period = By.xpath("//*[@id='fldr_5']");
		Sf_TaxType = By.xpath("//*[@id='fldr_6']");
		Sf_WFTemplate = By.xpath("//*[@id='wt_name']");
		Sf_EntityName = By.xpath("//*[@id='wf_14']");
		Sf_EntityId = By.xpath("//*[@id='wf_15']");
		Sf_Jurisdiction = By.xpath("//*[@id='wf_17']");
		Sf_WorkflowAssociation = By.xpath("//*[@id='wf_18']");
		Sf_WorkflowType = By.xpath("//*[@id='fw_workflow_type']");
		Sf_GroupCodes = By.xpath("//*[@id='gc_group_code_id']");
		Sf_Search = By.xpath("//*[@id='btnSearch']");
		/***************************************************************************************
		 * These element locators belongs to New Workflow and Workflow Properties of OWM
		 * manager
		 ***************************************************************************************/
		WFP_NWF_WFTemplate = By.xpath("//*[@id='ctlval_fw_workflow_template_id']");
	    WFP_NWF_EntityName = By.xpath("//*[@id='ctlval_wf_14']");
	    WFP_NWF_EntityID = By.xpath("//*[@id='ctlval_wf_15']");
	    WFP_NWF_Jurisdiction = By.xpath("//*[@id='ctlval_wf_17']");
	    WFP_NWF_DueDate = By.xpath("//*[@id='ctlval_fw_due_date']");
	    WFP_NWF_WFDescription = By.xpath("//*[@id='ctlval_fw_workflow_name']");
	    WFP_NWF_RIRouteToGroup = By.xpath("//*[@id='ddlAssignedToGroup']");
	    WFP_NWF_RIRouteToPerson = By.xpath("//*[@id='ddlAssignedToPerson']");
	    WFP_NWF_RIDueDate = By.xpath("//*[@id='pkDateDue']");
	    WFP_NWF_RI_CC_Email = By.xpath("//*[@id='txtNotifyCC']");
	    WFP_NWF_Save = By.xpath("//*[@id='btnOK']");
	    /****************************************************************************************
	     * These element locators belongs to Customize view page
	     ****************************************************************************************/
	    CustView_Save = By.xpath("//input[@id='btnSave']");
		CustView_Cancel = By.xpath("//input[@id='btnCancel']");

	}

	public void fnNavigateTab(String tab) throws InterruptedException {
		childTest = test
				.createNode("Description: Navigating to: " + tab + "." + "<br>" + "<< Screen Name: OWM >></br>");
		driver.manage().window().maximize();
		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")) {
			driver.manage().window().maximize();
			driver.switchTo().frame("bottom");// Switch to respective window
			driver.switchTo().frame("content");
			driver.switchTo().frame("bottomFrame");
			WebElement cview = driver.findElement(By.id("navCurrentView"));
			if (cview.getText().equalsIgnoreCase(tab)) {
				System.out.println("Navigated to: " + tab);
			} else {
				switch (tab) {
				case "WorkFlow Browser":
					fm.fnWebButton(driver, tabWorkFlowBrowser, "WorkFlow Browser Tab");
					break;
				case "Documents":
					fm.fnWebButton(driver, tabDocuments, "Documents Tab");
				case "My Work":
					fm.fnWebButton(driver, tabMyWork, "MyWork Tab");
					break;
				case "Control Log":
					fm.fnWebButton(driver, tabControlLog, "Control Log Tab");
					break;
				case "Reports":
					fm.fnWebButton(driver, tabReports, "Reports Tab");
					break;
				case "Calendar":
					fm.fnWebButton(driver, tabCalendar, "Calendar Tab");
					break;
				case "Calendar Setup":
					fm.fnWebButton(driver, tabCalendarSetup, "CalendarSetup Tab");
					break;
				case "Entity Browser":
					fm.fnWebButton(driver, tabEntityBrowser, "EntityBrowser Tab");
					break;
				case "Setup":
					fm.fnWebButton(driver, tabSetup, "Setup Tab");
					break;
				case "DataFlow":
					fm.fnWebButton(driver, tabDataFlow, "DataFlow Tab");
					break;
				}
				childTest.log(Status.PASS, "Navigated to " + tab);
			}
		}
	}

	public void Actions() throws InterruptedException {
		fm.fnWebButton(driver, Actions, "Actions");
	}

	public void fnNewFolderCreation() throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Folder." + "<br>" + "<< Screen Name: New Folder Webpage >></br>");
		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid = it1.next();
		String childid = it1.next();
		String childid1 = it1.next();
		Thread.sleep(2000);
		loginPage lp = new loginPage(driver, template, template);
		if (driver.getTitle().equals("New Folder")) {
			fm.fnWebList(driver, nf_Year, template.getProperty("Year"), "Year");
			fm.fnWebList(driver, nf_Period, template.getProperty("Period"), "Period");
			fm.fnWebList(driver, nf_TaxType, template.getProperty("TaxType"), "TaxType");
			fm.fnWebList(driver, nf_WFTemplate, template.getProperty("WF_Template"), "WorkFlow Template");
			fm.fnWebEdit(driver, nf_EntityName, template.getProperty("Entity_Name"), "EntityName");
			fm.fnWebEdit(driver, nf_EntityID, template.getProperty("Entity_Id"), "Entity ID");
			fm.fnWebEdit(driver, nf_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
		} else {
			driver.close();
		}
		fm.fnWebButton(driver, nf_SaveOK, "Save");
		Thread.sleep(2000);
		if (isAlertPresent(driver)) {
			if (driver.switchTo().alert().getText().equalsIgnoreCase("A Folder already exists")) {
				driver.switchTo().alert().accept();
				fm.fnWebButton(driver, nf_cancel, "Cancel");
				childTest.log(Status.INFO,
						"A folder already Exists with the given data<br>Creating a new folder by deleting the existing.</br>");
				lp.fnSwitchtoWindow(2, "WorkFlow Manager");
				fnWorkflowBrowserSearch();
				Thread.sleep(4000);
				driver.switchTo().frame("viewIFrame");
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")))
						.click().build().perform();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				Actions();
				driver.switchTo().frame("viewIFrame");
				lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
				driver.switchTo().alert().accept();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				Actions();
				driver.switchTo().frame("viewIFrame");
				lp.fnOWMActionsMenu("New Folder", "");
				Thread.sleep(5000);
				new WebDriverWait(driver, 2500).until(ExpectedConditions.numberOfWindowsToBe(3));
				lp.fnSwitchtoWindow(3, "New Folder");
				fnNewFolderCreation();
			}
		} else {
			Thread.sleep(4000);
			System.out.println("New Folder has been successfully created");
			driver.switchTo().defaultContent();
		}
	}

	public boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	public void fnWorkflowBrowserSearch() throws InterruptedException {
		childTest = test.createNode(
				"Description: Searching workflow with required fields" + "<br>" + "<<Screen Name: OWM >></br>");
		driver.switchTo().frame("bottom");
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		fm.fnWebButton(driver, Sf_Clear, "Clear");
		fm.fnWebList(driver, Sf_Year, template.getProperty("Year"), "Year");
		fm.fnWebList(driver, Sf_Period, template.getProperty("Period"), "Period");
		fm.fnWebList(driver, Sf_TaxType, template.getProperty("TaxType"), "TaxType");
		fm.fnWebList(driver, Sf_WFTemplate, template.getProperty("WF_Template"), "WorkFlow Template");
		fm.fnWebEdit(driver, Sf_EntityName, template.getProperty("Entity_Name"), "EntityName");
		fm.fnWebEdit(driver, Sf_EntityId, template.getProperty("Entity_Id"), "Entity ID");
		fm.fnWebEdit(driver, Sf_Jurisdiction, template.getProperty("Jurisdiction"), "Jurisdiction");
		fm.fnWebList(driver, Sf_WorkflowType, template.getProperty("Workflow_Type"), "WorkFlow Type");
		// Sf.SearchWorkflowAssociation(prop.getProperty("Workflow_Association"));
		// Sf.SearchGroupCodes(prop.getProperty("Group_Codes"));
		fm.fnWebButton(driver, Sf_Search, "Search");
		Thread.sleep(200);
	}
	
	public void fnOWMNewWorkFlow() throws InterruptedException {
		childTest = test.createNode(
				"Description: Create a New WorkFlow " + "<br>" + "<< Screen Name: WorkFlow Browser >></br>");
		loginPage lp1 = new loginPage(driver, template, template);
		//lp1.fnSwitchtoWindow(3, "Folder WorkFlows");
		fm.fnWebList(driver, WFP_NWF_WFTemplate,template.getProperty("WF_Template"),"WF Template");
		fm.fnWebEdit(driver, WFP_NWF_EntityName,template.getProperty("Entity_Name"),"Entity Name");
		fm.fnWebEdit(driver, WFP_NWF_EntityID,template.getProperty("Entity_Id"),"Entity ID");
		fm.fnWebEdit(driver, WFP_NWF_Jurisdiction,template.getProperty("Jurisdiction"),"Jurisdiction");
		Thread.sleep(200);
		fm.fnWebButton(driver, WFP_NWF_Save, "Save");  
	}
	
	public void fnWorkflowAlert(String actualText, String expectedText) {
		childTest = test
				.createNode("Description: WorkFlow Alert " + "<br>" + "<< Screen Name: Workflow Browser >></br>");
		if (actualText.contains(expectedText)) {
			driver.switchTo().alert().accept();
			childTest.log(Status.INFO,"Clicked on Alert");
			childTest.pass("Verification: Confirmation Alert" + "<br>" + expectedText
					+ " is present </br>");
		} else {
			driver.switchTo().alert().dismiss();
			childTest.pass("Verification: Confirmation Alert" + "<br>" + expectedText
					+ " is Expected but "+actualText+"is present.</br>");
		}
	}
	public void fnOWMCustomizeView(String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: OWM >></br>");
		if (driver.getTitle().equalsIgnoreCase("Grid Columns")) {
			for (int i = 0; i < array.length; i++) {
				if (driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).isSelected()) {
					childTest.log(Status.PASS, array[i] + " is checked.");
				} else {
					driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).click();
					childTest.log(Status.PASS, array[i] + " is checked.");
				}
			}
			fm.fnWebButton(driver, CustView_Save, "Save");
		} else {
			childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
		}
	}
}
