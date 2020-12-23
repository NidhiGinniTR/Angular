package com_lib_FunctionLibrary;

import java.util.List;
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
import com_obj_ObjectRepository.FolderWorkFlows.NavigationTabs;
import com_obj_ObjectRepository.LS1.OneSourceDashboard;
import com_obj_ObjectRepository.LS1.OneSourceLogin;
import com_obj_ObjectRepository.OWM.Navigations;
import com_obj_ObjectRepository.OWM.WorkFlowBrowser;


public class FunctionLibrary extends ExtentManager {

	public static void fnLogin(WebDriver driver, Properties Env) throws InterruptedException {
		childTest = test.createNode("Description: Entering UniversalID and Password." + "<br>"
				+ "<< Screen Name : OneSource Login Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE") || driver.getTitle().equalsIgnoreCase("THOMSON REUTERS")) {
			OneSourceLogin Lp = new OneSourceLogin(driver);
			Lp.reloadPage();
			Lp.enterUsername(Env.getProperty("UserName"));
			Lp.enterPassword(Env.getProperty("Password"));
			Lp.clickonSignIn();
		}
	}

	public static void fnLaunchApplication(WebDriver driver, String strAppName) throws InterruptedException {
		childTest = test.createNode("Description: Launching " + strAppName + " from Applications." + "<br>"
				+ "<< Screen Name: OneSource Dashboard >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
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

	public static void fnNavigateTab(WebDriver driver, String tab) throws InterruptedException {
		childTest = test
				.createNode("Description: Navigating to: " + tab + "." + "<br>" + "<< Screen Name: OWM >></br>");
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
				childTest.log(Status.PASS, "Navigated to " + tab);
			}
		}
	}

	public static void fnOWMActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
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
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver.findElements(By.className("MenuItem"));
						for (int j = 0; j < submenuItems.size(); j++) {
							if (subItem.equals(submenuItems.get(j).getText())) {
								String submenuItem = submenuItems.get(j).getAttribute("id");
								driver.findElement(By.id(submenuItem)).click();
								childTest.log(Status.PASS, subItem+" is selected from  " +item);
								break;
							}
						}
					}
					childTest.log(Status.PASS, item+" is enabled and is selected from actions menu.");
					break;
				}
			}
		}
	}

	public static void fnNewFolderCreation(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Folder." + "<br>" + "<< Screen Name: New Folder Webpage >></br>");
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
		if (isAlertPresent(driver)) {
			if (driver.switchTo().alert().getText().equalsIgnoreCase("A Folder already exists")) {
				driver.switchTo().alert().accept();
				driver.switchTo().window(childid1).close();
				childTest.log(Status.INFO,
						"A folder already Exists with the given data<br>Creating a new folder by deleting the existing.</br>");
				fnWorkflowBrowserSearch(driver, prop);
				Thread.sleep(4000);
				driver.switchTo().frame("viewIFrame");
				Actions action = new Actions(driver);
				action.moveToElement(
						driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).click()
						.build().perform();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				fnOWMActionsMenu(driver, "Delete WorkFlow(s)", "");
				driver.switchTo().alert().accept();
				Thread.sleep(500);
				driver.switchTo().defaultContent();
				driver.switchTo().frame("bottom");// Switch to respective window
				driver.switchTo().frame("content");
				driver.switchTo().frame("bottomFrame");
				fnOWMActionsMenu(driver, "New Folder", "");
				Thread.sleep(5000);
				new WebDriverWait(driver, 50).until(ExpectedConditions.numberOfWindowsToBe(3));
				fnNewFolderCreation(driver, prop);
			}
		} else {
			Thread.sleep(4000);
			System.out.println("New Folder has been successfully created");
			driver.switchTo().defaultContent();
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}
	
	public static void fnWorkflowBrowserSearch(WebDriver driver, Properties prop) throws InterruptedException {
		childTest = test.createNode(
				"Description: Searching workflow with required fields" + "<br>" + "<<Screen Name: OWM >></br>");
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
		// Sf.SearchWorkflowAssociation(prop.getProperty("Workflow_Association"));
		Sf.SearchWorkflowType(prop.getProperty("Workflow_Type"));
		// Sf.SearchGroupCodes(prop.getProperty("Group_Codes"));
		Sf.Search();
		Thread.sleep(2500);
	}

	public static void fnFWFSwitchingTab(WebDriver driver, String tab) throws InterruptedException {
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

	public static void fnOWMSavePreferences(WebDriver driver, String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences For All" + "<br>" + "<< Screen Name: OWM >></br>");
		WorkFlowBrowser owm = new WorkFlowBrowser(driver);
		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid = it1.next();
		String childid = it1.next();
		String childid1 = it1.next();
		driver.switchTo().window(childid1);
		if (menuitem.equals("Save Preferences for All")) {
			if (driver.getTitle().equals("Save Preferences")) {
				System.out.println(driver.getTitle());
				owm.SavePreforAll_Notify();
				Thread.sleep(1000);
				owm.SavePreforAll_Save();
				Thread.sleep(3000);
				driver.switchTo().window(childid);
				if (driver.switchTo().alert().getText().contains("Screen preferences changed for all users")) {
					driver.switchTo().alert().accept();
					childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				} else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			}
		} else if (menuitem.equals("Save Preferences")) {
			driver.switchTo().window(childid);
			if (driver.switchTo().alert().getText().contains("Your changes have been saved")) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}
	
	public static void fnOWMCustomizeView(WebDriver driver, String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: OWM >></br>");
		Set<String> ids1 = driver.getWindowHandles();
		java.util.Iterator<String> it1 = ids1.iterator();
		String parentid = it1.next();
		String childid = it1.next();
		String childid1 = it1.next();
		driver.switchTo().window(childid1);
		WorkFlowBrowser owm = new WorkFlowBrowser(driver);
		if (driver.getTitle().equalsIgnoreCase("Grid Columns")) {
			for (int i = 0; i < array.length; i++) {
				if (driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).isSelected()) {
					childTest.log(Status.PASS, array[i] + " is checked.");
				} else {
					driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).click();
					childTest.log(Status.PASS, array[i] + " is checked.");
				}
			}
			owm.Custview_Save();
		} else {
			childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
		}
	}
}
