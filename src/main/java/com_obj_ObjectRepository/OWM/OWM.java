package com_obj_ObjectRepository.OWM;

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
import com_lib_FunctionLibrary.FrameWork2;
import com_lib_FunctionLibrary.loginPage;

public class OWM extends ExtentManager{

	WebDriver driver;
	Properties template;
	// ---------------New Folder Page-----------------------------------------------------------------------------
		By Actions = By.xpath("//*[@id='spActions']");
		By nf_Year = By.xpath("//*[@id='ctlval_fldr_4']");
		By nf_TaxType = By.xpath("//*[@id='ctlval_fldr_6']");
		By nf_Period = By.xpath("//*[@id='ctlval_fldr_5']");
		By nf_WFTemplate = By.xpath("//*[@id='ctlval_fw_workflow_template_id']");
		By nf_EntityName = By.xpath("//*[@id='ctlval_1_wf_14']");
		By nf_EntityID = By.xpath("//*[@id='ctlval_2_wf_15']");
		By nf_Jurisdiction = By.xpath("//*[@id='ctlval_wf_17']");
		By nf_SaveOK = By.xpath("//*[@id='btnOK']");	
		By nf_cancel =  By.xpath("//*[@id='btnCancel']");
	// ----------------Save Preferences-----------------------------------------------------------------------------
		By SavePreforAll_notify = By.xpath("//*[@id='chkNotify']");
		By SavePreforAll_save = By.xpath("//*[@name='btnSave']");
		By SavePreforAll_cancel = By.xpath("//*[@name='btnCancel']");
	// ---------------Customize View--------------------------------------------------------------------------------
		By CustView_Save = By.xpath("//input[@id='btnSave']");
		By CustView_Cancel = By.xpath("//input[@id='btnCancel']");
	// --------------Search Fields-------------------------------------------------------------------------
		By Sf_Clear = By.xpath("//*[@id='btnCancel' and @title='Clear'] | //*[@class='btn btn-mini' and @title='Clear Search Criteria']");
		By Sf_Year =  By.xpath("//*[@id='fldr_4']");
		By Sf_Period =  By.xpath("//*[@id='fldr_5']");
		By Sf_TaxType =  By.xpath("//*[@id='fldr_6']"); 
		By Sf_WFTemplate =  By.xpath("//*[@id='wt_name']");
		By Sf_EntityName =  By.xpath("//*[@id='wf_14']");
		By Sf_EntityId =  By.xpath("//*[@id='wf_15']");
		By Sf_Jurisdiction =  By.xpath("//*[@id='wf_17']");
		By Sf_WorkflowAssociation =  By.xpath("//*[@id='wf_18']");
		By Sf_WorkflowType =  By.xpath("//*[@id='fw_workflow_type']");
		By Sf_GroupCodes =  By.xpath("//*[@id='gc_group_code_id']");
		By Sf_Search =  By.xpath("//*[@id='btnSearch']");
	// --------------New Rule Based Workflow-------------------------------------------------------------------------
		By NewRuleBased_S1_EntityName = By.xpath("//input[@name='wf_14']");
		By NewRuleBased_S1_EntityID = By.xpath("//input[@name='wf_15']");
		By NewRuleBased_S1_Search = By.xpath("//input[@id='btnSearch']");
		By NewRuleBased_S1_Clear = By.xpath("//input[@id='btnCancel']");
		By NewRuleBased_S1_Next = By.xpath("//*[@id='cmdEntityNext']");
		By NewRuleBased_S1_Cancel = By.xpath("//*[@id='imgCancel']");
		By NewRuleBased_S1_WebTable = By.xpath("//DIV[@id='grd_SE_Entity_dom']/table[1]");
		By NewRuleBased_S2_WFTemplate = By.xpath("//input[@id='txtWFT']");
		By NewRuleBased_S2_TaxType = By.xpath("//select[@id='ddlTaxType']");
		By NewRuleBased_S2_Jurisdiction = By.xpath("//select[@id='ddlJurisdiction']");
		By NewRuleBased_S2_ServiceType = By.xpath("//select[@id='ddlServiceType']");
		By NewRuleBased_S2_WorlflowType = By.xpath("//select[@id='ddlWFType']");
		By NewRuleBased_S2_Search = By.xpath("//div[@id='divTCEventBrowserCrit']/TABLE[1]/TBODY[1]/TR[7]/TD[1]/IMG[1]");
		By NewRuleBased_S2_Clear = By.xpath("//div[@id='divTCEventBrowserCrit']/TABLE[1]/TBODY[1]/TR[7]/TD[1]/IMG[2]");
		By NewRuleBased_S2_WebTable = By.xpath("//div[@id='grd_SE_WF_dom']/table[1]");
		By NewRuleBased_S2_Previous = By.xpath("//img[@id='imgPreviousEvent']");
		By NewRuleBased_S2_Next = By.xpath("//img[@id='imgNextEvent']");
		By NewRuleBased_S2_Cancel = By.xpath("//div[@id='ViewsCallBackEventDiv']/TABLE[2]/TBODY[1]/TR[1]/TD[4]/IMG[1]");
		By NewRuleBased_S3_TaxYear = By.xpath("//select[@name='ctlstval_23_Tax_year']");
		By NewRuleBased_S3_TaxAcPeriodStartDate = By.xpath("//input[@name='ctlval_23_rb_Tax Accounting Period Start Date']");
		By NewRuleBased_S3_TaxAcPeriodEndDate = By.xpath("//input[@name='ctlval_23_rb_Tax Accounting Period End Date']");
		By NewRuleBased_S3_Year = By.xpath("//select[@name='ctlval_23_fldr_4']");
		By NewRuleBased_S3_Period = By.xpath("//select[@name='ctlval_23_fldr_5']");
		By NewRuleBased_S3_TaxType = By.xpath("//select[@name='ctlval_23_fldr_6']");
		By NewRuleBased_S3_Jurisdiction = By.xpath("//input[@name='ctlval_23_wf_17']");
		By NewRuleBased_S3_WorkFlowAssociation = By.xpath("//select[@name='ctlval_23_wf_18']");
		By NewRuleBased_S3_Description = By.xpath("//*[@name='ctlval_23_fw_workflow_name']");
		By NewRuleBased_S3_Previous = By.xpath("//DIV[@id='ViewsCallBackWFInstanceDiv']/TABLE[1]/TBODY[1]/TR[4]/TD[1]/IMG[1]");
		By NewRuleBased_S3_Finish = By.xpath("//img[@id='btnFinish']");
		By NewRuleBased_S3_Cancel = By.xpath("//div[@id='ViewsCallBackWFInstanceDiv']/TABLE[1]/TBODY[1]/TR[4]/TD[1]/IMG[3]");
	//----------------------New Workflow and WorkFlowProperties--------------------------------------------------------------------
			By WFP_NWF_WFTemplate = By.xpath("//*[@id='ctlval_fw_workflow_template_id']");
		    By WFP_NWF_EntityName = By.xpath("//*[@id='ctlval_1_wf_14']");
		    By WFP_NWF_EntityID = By.xpath("//*[@id='ctlval_2_wf_15']");
		    By WFP_NWF_Jurisdiction = By.xpath("//*[@id='ctlval_wf_17']");
		    By WFP_NWF_DueDate = By.xpath("//*[@id='ctlval_fw_due_date']");
		    By WFP_NWF_WFDescription = By.xpath("//*[@id='ctlval_fw_workflow_name']");
		    By WFP_NWF_RIRouteToGroup = By.xpath("//*[@id='ddlAssignedToGroup']");
		    By WFP_NWF_RIRouteToPerson = By.xpath("//*[@id='ddlAssignedToPerson']");
		    By WFP_NWF_RIDueDate = By.xpath("//*[@id='pkDateDue']");
		    By WFP_NWF_RI_CC_Email = By.xpath("//*[@id='txtNotifyCC']");
		    By WFP_NWF_Save = By.xpath("//*[@id='btnOK']");
     //------------------Customize View-------------------------------------
		    By Doc_CustView_Save = By.xpath("//INPUT[@id='btnSave']");
		    
	// ----------------WorkflowTabs-----------------------------------------------------------------------------
			By tabWorkFlowBrowser = By.xpath("//td[@id='FolderWorkflows']");
			By tabDocuments = By.xpath("//td[@id='Documents']");
			By tabControlLog = By.xpath("//[@id='ControlLog']");
			By tabCalendar = By.xpath("//td[@id='TAXCAL_SCHEDULE_EVENTS']");
			By tabCalendarSetup = By.xpath("//td[@id='TAXCAL_SETUP']");
			By tabReports = By.xpath("//td[@id='ReportsFlow']");
			By tabDataFlow = By.xpath("//td[@id='ReportsFlow']");
			By tabMyWork = By.xpath("//[@id='MyWork']");
			By tabEntityBrowser = By.xpath("//td[@id='TAXCAL_ENTITYTOPICBROWSER']");
			By tabSetup = By.xpath("//td[@id='Setup']");
			// ---------------ActionsButton------------------------------------------------------------------------------
			//By Actions = By.xpath("//span[@id='spActions']");
			By ftrClear = By.xpath("//*[@id='btnCancel' and @title='Clear']");
			
			FrameWork2 fm = new FrameWork2();
	public OWM(WebDriver driver, Properties data2) {
		this.driver = driver;
		this.template = data2;
	}
	public void Actions() throws InterruptedException {
		fm.fnWebButton(driver, Actions, "Actions");
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
			//driver.switchTo().defaultContent();
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
			childTest.pass("Verification: Confirmation Alert" + "<br>" + actualText
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
	public void fnOWMSavePreferences(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: OWM >></br>");
		WorkFlowBrowser owm = new WorkFlowBrowser(driver);
		if (menuitem.equals("Save Preferences for All")) {
			if (driver.getTitle().equals("Save Preferences")) {
				System.out.println(driver.getTitle());
				fm.fnWebCheckBox(driver, SavePreforAll_notify, "Notify by Email");
				Thread.sleep(500);
				fm.fnWebButton(driver, SavePreforAll_save, "Save");
				Thread.sleep(500);
				if (driver.switchTo().alert().getText().contains("Screen preferences changed for all users.Notifications were sent.")) {
					driver.switchTo().alert().accept();
					childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				} else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			}
		} else if (menuitem.equals("Save Preferences")) {
			if (driver.switchTo().alert().getText().contains("Your changes have been saved.")) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}

}
