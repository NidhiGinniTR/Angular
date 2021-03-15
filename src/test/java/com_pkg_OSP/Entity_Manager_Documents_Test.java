package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;
import com_obj_ObjectRepository.LS1.LS1;

public class Entity_Manager_Documents_Test extends BrowserInvoke {
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void EUB_Documents() throws InterruptedException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager");

		// Step-3:-----Click Documents Tab---------------------------//
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		Eub.fnEM_SwitchTabs("Documents");

		// Step-4:-----Verify Search Fields---------------------------//
		driver.switchTo().frame("gridFrame");
		Thread.sleep(500);
		// String[] array = new String[] { "W/F
		// Template:","Period:","Year:","Jurisdiction:", "Entity Name:", "Entity ID:",
		// "Tax Type:",
		// "WorkFlow Association:", "Description:","File Section:","Document
		// Type:","Document Date:","WorkFlow Type:" };
		// Eub.fnVerifySearchElements(array);

		// Step-5:------------Verify Action Menu items---------------------------//
		FrameWork fm = new FrameWork();
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnActionsMenuEnabled();
		Eub.fnActionsMenuDisabled();

		// Step-6:---------------------Click Actions and Add Document------------------------------------//
		Eub.fnOWMActionsMenu("Add Document", "");

		//Step-7----------------------Add Document-----------------------------------------
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "Add document");
		Eub.fnEM_AddDocument();

		//Step-8--------------------Search Document---------------------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		Eub.fnEM_SearchDocument();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridDocuments_grdEntityManager_row_0']")),
				"Click");

		//Step-9----------------------Document Properties----------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Document Properties", "");

		//Step-10-------------------------Document Properties---------------------------
		lp.fnSwitchtoWindow(2, "Document Properties");
		Eub.fnDocumentProperties();

		//Step-11----------------------------Switch Frame--------------------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridDocuments_grdEntityManager_row_0']")),
				"Click");

		//Step-12-------------------------Change Status-------------------------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Thread.sleep(1000);
		Eub.fnOWMActionsMenu("Change Status", "InProgress");
		Thread.sleep(1500);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Eub.fnChangeStatus();
		Thread.sleep(1500);

		//Step-13:-----------------------Switch Frame-----------------------------------//
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");

		//Step-14:----------------Customize View-----------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(2500);
		lp.fnSwitchtoWindow(2, "Customize View");
		String[] array3 = new String[] { "Entity Name", "Entity ID", "Tax Type", "Year", "Period", "Jurisdiction",
				"Description" };
		Eub.fnCustomizeView(array3);

		//Step-15:----------------Save Preferences-----------------------------------//
		/* lp.fnSwitchtoWindow(1, "LS1"); driver.switchTo().defaultContent();
		 * driver.switchTo().frame("maincontent");
		 * driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		 * driver.switchTo().frame("gridFrame"); //lp.fnSwitchtoWindow(1, "LS1");
		 * Thread.sleep(1500); fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"),
		 * "Actions"); Eub.fnOWMActionsMenu("Save Preferences", "");
		 * Eub.fnSavePreferences("Save Preferences");
		 * 
		 * // Step-16:----------------Save Preferences for All-----------------------------------// 
		 * fm.fnWebButton(driver,
		 * By.xpath("//img[@id='Img3']"), "Actions");
		 * Eub.fnOWMActionsMenu("Save Preferences for All", "");
		 * Eub.fnSavePreferences("Save Preferences for All");
		 */
		Thread.sleep(1500);

		//Step-17------------------------Switch Frame------------------------------------
		lp.fnSwitchtoWindow(1, "Onesource");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridDocuments_grdEntityManager_row_0']")),
				"Click");

		//Step-18:----------------------------Delete Document-------------------------------//
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Delete Document(s)", "");
		Thread.sleep(1000);
		Eub.fnDeleteDocument();
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(1, "Onesource");
		
		// Step--------LogOFF-------------------------------//
		Eub.fnLogOff();
	}
	
	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		//driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
