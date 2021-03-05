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
import com_obj_ObjectRepository.LS1.Entity_Manager_Transaction_Browser;


public class Transaction_Browser_Actions  extends BrowserInvoke{
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
	public void transaction_Browser_Actions() throws InterruptedException {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		Entity_Manager_People_Browser ppl_browser = new Entity_Manager_People_Browser(driver, propEnv, propSerialData);
		Entity_Manager_Transaction_Browser tr = new Entity_Manager_Transaction_Browser(driver, propEnv, propSerialData);
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
				lp.fnLogin();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
				lp.LaunchApplication("Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().parentFrame();
		
		//Step-3:--------Navigate to Transaction Browser and go to Add New------------//
		
				tr.navigate_ToTransectionBrowser();
		
		//Step-4:-------------Search Transaction-----------------------//
		
				tr.search_Transaction();
		
		//Step-5:--------Edit the Transaction------------//
		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Edit/View Details", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.switchTo().frame("Iframe1");
				tr.editTransaction();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Step-6:--------View and Verify the Transaction------------//
				
				lp.fnSwitchtoWindow(1, "LS1");
				driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("maincontent");
				driver.switchTo().frame("app_iFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//tr[@id='gridTransactions_grdEntityManager_row_0']"))).doubleClick().build().perform();
				Thread.sleep(2000);
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.switchTo().frame("Iframe1");
				tr.view_Transactions();
				
		//Step-7--------------Archive----------------------//
				
				lp.fnSwitchtoWindow(1, "LS1");
				driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("maincontent");
				driver.switchTo().frame("app_iFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Archive", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//button[@id='dialog-button-action']")).click();
				

		// Step-8:----------------Purge Entity-----------------------------------//
				
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Purge", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				lp.fnSwitchtoWindow(2, "Delete Entity");
				ppl_browser.deleteEntity("Delete Entity");
				
		//Step-9-----------------Customize View------------------//
				
				lp.fnSwitchtoWindow(1, "LS1");
				driver.switchTo().defaultContent();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("maincontent");
				driver.switchTo().frame("app_iFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Customize View", "");
				lp.fnSwitchtoWindow(2, "Customize View");
				String[] array1 = new String[] { "From Entity Name", "From Entity ID" };
				ppl_browser.fnCustomizeView(array1);
				
		// Step-10:----------------Save Preferences-----------------------------------//

				lp.fnSwitchtoWindow(1, "LS1");
				driver.switchTo().defaultContent();
				driver.switchTo().frame("maincontent");
				driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Save Preferences", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ppl_browser.fnSavePreferences("Save Preferences");

		// Step-11:----------------Save Preferences for All-----------------------------------//
					
				ppl_browser.actions();
				ppl_browser.fnOWMActionsMenu(driver, "Save Preferences for All", "");
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