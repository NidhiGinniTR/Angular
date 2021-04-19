package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.loginPage;
import com_obj_ObjectRepository.LS1.Entity_Manager_People_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_People_BrowserClassic;
import com_obj_ObjectRepository.LS1.Entity_Manager_Transaction_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_Transaction_BrowserClassic;
import com_obj_ObjectRepository.LS1.LS1;


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
		
		Entity_Manager_People_BrowserClassic ppl_browser = new Entity_Manager_People_BrowserClassic(driver,propSerialData);
		Entity_Manager_Transaction_BrowserClassic tr = new Entity_Manager_Transaction_BrowserClassic(driver, propEnv, propSerialData);
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		lp.fnLogin();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);

		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager Classic");

		// Step-3:-----Verify Search Fields---------------------------//
		//driver.switchTo().defaultContent();
		lp.fnSwitchtoWindow(2, "Entity Manager");
		
		
		//Step-3:--------Navigate to Transaction Browser and go to Add New------------//
		
				tr.navigate_ToTransectionBrowser();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
		
		//Step-4:-------------Search Transaction-----------------------//
		
				tr.search_Transaction();
		
		//Step-5:--------Edit the Transaction------------//
		
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Edit/View Details", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				lp.fnSwitchtoWindow(3, "Entity Manager");
				driver.switchTo().frame("Iframe1");
				tr.editTransaction();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
		//Step-6:--------View and Verify the Transaction------------//
				
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//				driver.switchTo().frame("maincontent");
//				driver.switchTo().frame("app_iFrame");
//				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				Actions action = new Actions(driver);
				action.moveToElement(driver.findElement(By.xpath("//tr[@id='gridTransactions_grdEntityManager_row_0']"))).doubleClick().build().perform();
				Thread.sleep(2000);
				lp.fnSwitchtoWindow(3, "Entity Manager");
				driver.switchTo().frame("Iframe1");
				tr.view_Transactions();
				
		//Step-7--------------Archive----------------------//
				
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Archive", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//button[@id='dialog-button-action']")).click();
				

		// Step-8:----------------Purge Entity-----------------------------------//
				
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Purge", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				lp.fnSwitchtoWindow(3, "Delete Entity");
				ppl_browser.deleteEntity("Delete Entity");
				
		//Step-9-----------------Customize View------------------//
				
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Customize View", "");
				lp.fnSwitchtoWindow(3, "Customize View");
				String[] array1 = new String[] { "From Entity Name", "From Entity ID" };
				ppl_browser.fnCustomizeView(array1);
				
		// Step-10:----------------Save Preferences-----------------------------------//

				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Save Preferences", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ppl_browser.fnSavePreferences("Save Preferences");

		// Step-11:----------------Save Preferences for All-----------------------------------//
					
				ppl_browser.actions();
				ppl_browser.fnOWMClassicActionsMenu("Save Preferences for All", "");
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