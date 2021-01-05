package com_obj_ObjectRepository.OWM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_lib_FunctionLibrary.FrameWork;


public class Navigations {
	WebDriver driver;
	FrameWork fm = new FrameWork();

	public Navigations(WebDriver driver) {
		this.driver = driver;
	}

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

	public void tabWorkFlowBrowser() throws InterruptedException {
		fm.fnWebButton(driver, tabWorkFlowBrowser, "WorkFlow Browser Tab");
	}

	public void tabDocuments() throws InterruptedException {
		fm.fnWebButton(driver, tabDocuments, "Documents Tab");
	}

	public void tabControlLog() throws InterruptedException {
		fm.fnWebButton(driver, tabControlLog, "Control Log Tab");
	}

	public void tabCalendar() throws InterruptedException {
		fm.fnWebButton(driver, tabCalendar, "Calendar Tab");
	}

	public void tabCalendarSetup() throws InterruptedException {
		fm.fnWebButton(driver, tabCalendarSetup, "CalendarSetup Tab");
	}

	public void tabReports() throws InterruptedException {
		fm.fnWebButton(driver, tabReports, "Reports Tab");
	}

	public void tabDataFlow() throws InterruptedException {
		fm.fnWebButton(driver, tabDataFlow, "DataFlow Tab");
	}

	public void tabMyWork() throws InterruptedException {
		fm.fnWebButton(driver, tabMyWork, "MyWork Tab");
	}

	public void tabEntityBrowser() throws InterruptedException {
		fm.fnWebButton(driver, tabEntityBrowser, "EntityBrowser Tab");
	}

	public void tabSetup() throws InterruptedException {
		fm.fnWebButton(driver, tabSetup, "Setup Tab");
	}

	// ---------------ActionsButton------------------------------------------------------------------------------
	By Actions = By.xpath("//span[@id='spActions']");
	By ftrClear = By.xpath("//*[@id='btnCancel' and @title='Clear']");

	public void filterClear() throws InterruptedException {
		fm.fnWebButton(driver, ftrClear, "Clear");
	}

	public void Actions() throws InterruptedException {
		fm.fnWebButton(driver, Actions, "Actions");
	}
	
	// ------------------------WorkFlow Browser SearchFields------------------------------------------------------------------
		By Clear = By.xpath("//*[@id='btnCancel' and @title='Clear'] | //*[@class='btn btn-mini' and @title='Clear Search Criteria']");
		By searchYear = By.id("fldr_4");
		By searchPeriod = By.id("fldr_5");
		By searchTaxType = By.id("fldr_6");
		By searchWF_Template = By.id("wt_name");
		By searchEntity_Name = By.id("wf_14");
		By searchEntity_Id = By.id("wf_15");
		By searchJurisdiction = By.id("wf_17");
		By searchWorkflow_Association = By.id("wf_18");
		By searchWorkflow_Type = By.id("fw_workflow_type");
		By searchGroup_Codes = By.id("gc_group_code_id");
		By Search = By.id("btnSearch");

		public void searchFieldYear(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchYear, temp, "Year");
		}
		public void searchFieldPeriod(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchPeriod, temp, "Period");
		}
		public void searchFieldTaxType(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchTaxType, temp, "TaxType");
		}
		public void searchFieldWF_Template(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchWF_Template, temp, "WorkFlow Template");
		}
		public void searchFieldEntity_Name(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, searchEntity_Name, temp, "Entity Name");
		}
		public void searchFieldEntity_Id(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, searchEntity_Id, temp, "Entity ID");
		}
		public void searchFieldJurisdiction(String temp) throws InterruptedException {
			fm.fnWebEdit(driver, searchJurisdiction, temp, "Jurisdiction");
		}
		public void searchFieldWorkflow_Association(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchWorkflow_Association, temp, "WorkFlow Association");
		}
		public void searchFieldWorkflow_Type(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchWorkflow_Type, temp, "WorkFlow Type");
		}
		public void searchFieldGroup_Codes(String temp) throws InterruptedException {
			fm.fnWebList(driver, searchGroup_Codes, temp, "Group Codes");
		}
		public void Clear() throws InterruptedException {
			fm.fnWebButton(driver, Clear, "Clear");
		}
		public void Search() throws InterruptedException {
			fm.fnWebButton(driver, Search, "Search");
		}

	// ------------------------LogOut------------------------------------------------------------------
		By OWMLogout = By.xpath("//*[@id='divLogoutLink']"); 
		By LS1Logout = By.xpath("//*[@id='btnLogOff']");
		
		public void OWMLogout() throws InterruptedException {
			fm.fnWebButton(driver, OWMLogout, "OWMLogout");
		}
		
		public void LS1Logout() throws InterruptedException {
			fm.fnWebButton(driver, LS1Logout, "LS1Logout");
		}
		

}
