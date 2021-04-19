package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
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
import com_obj_ObjectRepository.LS1.LS1;


public class People_Browser_AddingRoles  extends BrowserInvoke {
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
	public void people_Browser_AddRoleandPosition() throws InterruptedException {
		Entity_Manager_People_BrowserClassic ppl_browser = new Entity_Manager_People_BrowserClassic(driver,propSerialData);
		
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
		
		//Step-3:--------Navigate to People Browser and go to Add New------------//
		
		ppl_browser.navigate_ToPeopleBrowser();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		
		
		//Step-5:--------Search for created profile------------//
		
		
		ppl_browser.search_IndProfile();
		
		//Step-6:--------Edit the created profile------------//
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ppl_browser.actions();
		ppl_browser.fnOWMClassicActionsMenu("Edit/View Details", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(3, "Individual Profile");
		
		//Step-7----------------------Add New Roles and Positions------------------//
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.actions();
		ppl_browser.fnIPActionsMenu(driver, "Add New", "");
		lp.fnSwitchtoWindow(4, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 
		ppl_browser.add_NewRoleandPosition();
		lp.fnSwitchtoWindow(3, "Individual Profile");
		driver.findElement(By.xpath("//img[@id='btnClose']")).click();
		
		//Step-8-------------------Edit Role and Position-------------------//
		
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		ppl_browser.fnOWMClassicActionsMenu("Edit/View Details", "");
		lp.fnSwitchtoWindow(3, "Individual Profile");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//tr[@id='gridIndividualEntitiesRole_grdEntityManager_row_0']")).click();
		ppl_browser.actions();
		ppl_browser.fnIPActionsMenu(driver, "Edit/View Details", "");
		lp.fnSwitchtoWindow(3, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		ppl_browser.editRoleandPosition();
		lp.fnSwitchtoWindow(3, "Individual Profile");
		ppl_browser.actions();
		ppl_browser.fnIPActionsMenu(driver, "Edit/View Details", "");
		lp.fnSwitchtoWindow(4, "Entity Manager");
		ppl_browser.view_RoleandPosition();
		
		
		//Step - 9 -------------------Delete------------------------//
		
		lp.fnSwitchtoWindow(3, "Individual Profile");
		ppl_browser.actions();
		ppl_browser.fnIPActionsMenu(driver, "Delete", "");
		driver.findElement(By.xpath("//button[@id='dialog-button-action']")).click();
		
		//Step-10---------------Customize View----------------------//
		
		ppl_browser.actions();
		ppl_browser.fnIPActionsMenu(driver, "Customize View", "");
		lp.fnSwitchtoWindow(4, "Customize View");
		String[] array1 = new String[] { "Entity Name", "Entity ID", "Role", "Position", "Date",
				"Order" };
		ppl_browser.fnCustomizeView(array1);
		
		// Step-11:----------------Save Preferences-----------------------------------//

		lp.fnSwitchtoWindow(3, "Individual Profile");
				
				ppl_browser.actions();
				ppl_browser.fnIPActionsMenu(driver, "Save Preferences", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				ppl_browser.fnSavePreferences("Save Preferences");

		// Step-12:----------------Save Preferences for All-----------------------------------//
				
				ppl_browser.actions();
				ppl_browser.fnIPActionsMenu(driver, "Save Preferences for All", "");
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
