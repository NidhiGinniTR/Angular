package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.loginPage;
import com_obj_ObjectRepository.LS1.Entity_Manager_People_Browser;


public class People_Browser_Actions extends BrowserInvoke {
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
	public void people_Browser_Actions() throws InterruptedException {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		Entity_Manager_People_Browser ppl_browser = new Entity_Manager_People_Browser(driver, propEnv, propSerialData);
		
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
		lp.fnLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
		lp.LaunchApplication("Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		
		//Step-3:--------Navigate to People Browser and go to Add New------------//
		
		ppl_browser.navigate_ToPeopleBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//Step-5:--------Search for created profile------------//
		
		
		ppl_browser.search_IndProfile();
		
		//Step-6:--------Edit the created profile------------//
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Edit/View Details", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(2, "Individual Profile");
		ppl_browser.editIndividual();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
		//Step-7:--------View and Verify the values of profile------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		ppl_browser.doubleclick_OnProfile();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(2, "Individual Profile");
		ppl_browser.view_IndividualProfile();
		
		//Step-8------------Copy To New------------------------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Copy to New", "");
		//ppl_browser.click_CopyToNew();
		lp.fnSwitchtoWindow(2, "Copy People");
		ppl_browser.copyToNew();
		
		//Step-9------------Replace----------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
//		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		ppl_browser.click_ToReplace();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Replace", "");
		lp.fnSwitchtoWindow(2, "Replace Roles");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@id='imgPeople']")).click();
		lp.fnSwitchtoWindow(3, "People Lookup");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='SearchControl1']")).sendKeys("ram");
		driver.findElement(By.xpath("//img[@id='imgbtnSearch']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//tr[@id='gridPeople_grdEntityManager_row_0']"))).doubleClick().build().perform();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(2, "Replace Roles");
		driver.findElement(By.xpath("//img[@id='Img1']")).click();
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Replace", "");
		lp.fnSwitchtoWindow(2, "Replace Roles");
		ppl_browser.verifyReplace();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-10--------------Archive----------------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Archive", "");
		
//		ppl_browser.click_ToArchive();
		//ppl_browser.archiveVerify();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@id='dialog-button-action']")).click();
		
		
		// Step-11:----------------Purge Entity-----------------------------------//
		
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Purge", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(2, "Delete Entity");
		ppl_browser.deleteEntity("Delete Entity");
		
		//Step-12-----------------Customize View------------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_iFrame");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMActionsMenu("Customize View", "");
		lp.fnSwitchtoWindow(2, "Customize View");
		String[] array1 = new String[] { "First Name", "Middle Initial", "Last Name", "Title", "Organization",
				"City", "State" };
		ppl_browser.fnCustomizeView(array1);
		
		// Step-13:----------------Save Preferences-----------------------------------//

				lp.fnSwitchtoWindow(1, "LS1");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("maincontent");
				driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu("Save Preferences", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ppl_browser.fnSavePreferences("Save Preferences");

		// Step-14:----------------Save Preferences for All-----------------------------------//
				
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu("Save Preferences for All", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ppl_browser.fnSavePreferences("Save Preferences for All");
				
		
				

	}
	@AfterClass
	void closeBrowser() throws InterruptedException {
		//FunctionLibrary.fnLogOff(driver);
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}

}
