package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.LS1.LS1;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;

public class EUB_Test extends BrowserInvoke {

	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void EntityUnitBrowser() throws InterruptedException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		lp.fnLogin();

		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager");

		// Step-3:-----Verify Search Fields---------------------------//
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		String[] array = new String[] { "Entity Name", "Entity ID", "Entity Type","Status","Locations", "Group Code","Entity Group","Archive","PPOB State/Province","PPOB Country/Region" };
		Eub.fnVerifySearchElements(array);

		// Step-4:------------Verify Action Menu items---------------------------//
		Eub.fnClickActions();
		Eub.fnActionsMenuEnabled();
		Eub.fnActionsMenuDisabled();

		// Step-5----------------------CLick Actions & Add New Entity---------------------------------------//
		Eub.fnOWMActionsMenu("Add New", "");

		// Step-6------------------------Create a New Entity-------------------------------------//
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.switchTo().frame("addeditFrame1");
		Eub.fnCreateEntity();

		// Step-7:--------------------Search created Entity--------------------------------//
		lp.fnSwitchtoWindow(1, "Onesource");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");

		Eub.fnSearchEntity();

		// Step-8:---------------------Click Actions--Edit/View Details-------------------------------//
		FrameWork fm = new FrameWork();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Edit/View Details", "");
		
		// Step-9:--------------------Verify Edit/View Details--------------------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.switchTo().frame("addeditFrame1");
		Eub.fnEditDeatils_Entity();

		// Step-10:----------------------Search Entity------------------------------//
		lp.fnSwitchtoWindow(1, "Onesource");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");

		Eub.fnSearchEntity();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
		
		// Step-11:--------------------Copy Entity--------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Copy to New", "");
		lp.fnSwitchtoWindow(2, "Copy Entity");
		Eub.copyentity();
		
		// Step-12:---------------------Import Entity-------------------------------// //
		// Eub.fnEntityManagerImport();
		
		// Step-13:----------------------------------------------------//
		lp.fnSwitchtoWindow(1, "Onesource");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");

		// Step-14:----------------Customize View-----------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Customize View", "");
		lp.fnSwitchtoWindow(2, "Customize View");
		String[] array1 = new String[] { "Entity Name", "Status", "Entity Id", "State of Inc", "Group Code",
				"Entity Type", "Entity Group Name" };
		Eub.fnCustomizeView(array1);

		// Step-15:----------------Save Preferences-----------------------------------//

		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step-16:----------------Save Preferences for All-----------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");
		
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		driver.quit();
		// FunctionLibrary.fnLogOff(driver);
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}

}
