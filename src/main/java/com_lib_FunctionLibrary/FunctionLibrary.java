package com_lib_FunctionLibrary;

import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com_helper_Reporting.ExtentManager;
import com_obj_ObjectRepository.FolderWorkFlows.NavigationTabs;
import com_obj_ObjectRepository.LS1.OneSourceDashboard;
import com_obj_ObjectRepository.LS1.OneSourceLogin;
import com_obj_ObjectRepository.OWM.Navigations;
import com_obj_ObjectRepository.OWM.WorkFlowBrowser;

public class FunctionLibrary extends ExtentManager {
	
	public static void fnLogin(WebDriver driver, Properties Env) throws InterruptedException {
		childTest = test.createNode("Login Universal ID and Password. <br> << Screen Name : Login Page>>");
		OneSourceLogin Lp = new OneSourceLogin(driver);
		Lp.reloadPage();
		Lp.enterUsername(Env.getProperty("UniversalId"));
		Lp.enterPassword(Env.getProperty("Password"));
		Lp.clickonSignIn();

	}

	public static void fnLaunchApplication(WebDriver driver, String strAppName) throws InterruptedException
	{
		childTest = test.createNode("Launching Application. <br> << Screen Name : LS1 Dashboard>>");
		driver.switchTo().frame("header");
		if(driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			driver.switchTo().frame("header");
			OneSourceDashboard Lp = new OneSourceDashboard(driver);
			Lp.launchApplications();
			Thread.sleep(300);
			driver.switchTo().parentFrame();
			driver.switchTo().frame("menuPopup");
			Lp.appMenuSelection(strAppName);
			System.out.println(strAppName + "is selected from Applications dropdown");
		}
	}
	
	public static void fnNavigateTab(WebDriver driver, String tab) throws InterruptedException 
	{
		childTest = test.createNode("Navigation Tab. <br> << Screen Name : OWM Page>>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		Thread.sleep(500);
		driver.switchTo().window(childid);
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")) {
			driver.switchTo().frame("bottom");// Switch to respective window
			driver.switchTo().frame("content");
			driver.switchTo().frame("bottomFrame");
			WebElement cview = driver.findElement(By.id("navCurrentView"));
			Navigations Nt = new Navigations(driver);
			if (cview.getText().equalsIgnoreCase(tab)) {
				System.out.println("Navigated to: " + tab);
			} else {
				switch (tab) {
				case "WorkFlow Browser":
					Nt.tabWorkFlowBrowser();
					break;
				case "Documents":
					Nt.tabDocuments();
				case "My Work":
					Nt.tabMyWork();
					break;
				case "Control Log":
					Nt.tabControlLog();
					break;
				case "Reports":
					Nt.tabReports();
					break;
				case "Calendar":
					Nt.tabCalendar();
					break;
				case "Calendar Setup":
					Nt.tabCalendarSetup();
					break;
				case "Entity Browser":
					Nt.tabEntityBrowser();
					break;
				case "Setup":
					Nt.tabSetup();
					break;
				case "DataFlow":
					Nt.tabDataFlow();
					break;
				}
				System.out.println("Navigated to: " + tab);
			}
		}
	}
	
	public static void fnOWMActionsMenu(WebDriver driver, String item) throws InterruptedException 
	{
		driver.switchTo().defaultContent();
		driver.switchTo().frame("bottom");
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")) {
			WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			actionsMenu.Actions();
			Thread.sleep(1000);
			driver.switchTo().frame("viewIFrame");
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					System.out.println(item + " is enabled and is selected from actions menu");
					break;
				}
			}
		}
	}

	public static void fnNewFolderCreation(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode("New Folder Creation. <br> << Screen Name : NewFolder Page>>");

		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid = it1.next();
		String childid = it1.next();
		String childid1 = it1.next();
		Thread.sleep(300);
		driver.switchTo().window(childid1);
		Thread.sleep(1000);
		WorkFlowBrowser Nf = new WorkFlowBrowser(driver);
		if (driver.getTitle().equals("New Folder")) {
			Nf.newfolderYear(prop.getProperty("Year"));
			Nf.newfolderPeriod(prop.getProperty("Period"));
			Nf.newfolderTaxtype(prop.getProperty("TaxType"));
			Nf.newfolderWFTemplate(prop.getProperty("WF_Template"));
			Nf.newfolderEntityName(prop.getProperty("Entity_Name"));
			Nf.newfolderEntityID(prop.getProperty("Entity_Id"));
			Nf.newfolderJurisdiction(prop.getProperty("Jurisdiction"));
		} else {
			driver.quit();
		}
		Nf.newfolderSave();
	}

	public static void fnWorkflowBrowserSearch(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode("Search Fields. <br> << Screen Name : Workflow Browser Page>>");
		Set<String> ids = driver.getWindowHandles();
		java.util.Iterator<String> it = ids.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		driver.switchTo().frame("bottom");
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");

		WorkFlowBrowser Sf = new WorkFlowBrowser(driver);
		Sf.SearchClear();
		Sf.SearchYear(prop.getProperty("Year"));
		Sf.SerachPeriod(prop.getProperty("Period"));
		Sf.SearchTaxtype(prop.getProperty("TaxType"));
		Sf.SearchWFTemplate(prop.getProperty("WF_Template"));
		Sf.SearchEntityName(prop.getProperty("Entity_Name"));
		Sf.SearchEntityID(prop.getProperty("Entity_Id"));
		Sf.SearchJurisdiction(prop.getProperty("Jurisdiction"));
		//Sf.SearchWorkflowAssociation(prop.getProperty("Workflow_Association"));
		Sf.SearchWorkflowType(prop.getProperty("Workflow_Type"));
		//Sf.SearchGroupCodes(prop.getProperty("Group_Codes"));
		Sf.Search();
	}

	public static void fnFWFSwitchingTab(WebDriver driver,String tab) throws InterruptedException 
	{
		Set<String> ids = driver.getWindowHandles();
        java.util.Iterator<String> it = ids.iterator();
        String parentid = it.next();
        String childid = it.next();
        String childid1 = it.next();
        Thread.sleep(500);
        driver.switchTo().window(childid1);
        Thread.sleep(500);
        NavigationTabs St = new NavigationTabs(driver);
		St.fwf_tabSelection(tab);
	}

}
