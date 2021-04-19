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
import com_obj_ObjectRepository.LS1.Entity_Manager_Charting_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_Charting_BrowserClassic;
import com_obj_ObjectRepository.LS1.LS1;



public class Charting_Browser_Actions extends BrowserInvoke {
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
	public void addNew_Chart() throws Exception {
		
		Entity_Manager_Charting_BrowserClassic cb = new Entity_Manager_Charting_BrowserClassic(driver, propEnv, propSerialData);
		//OWM owm = new OWM(driver,propSerialData);
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
		
		//Step-3:--------Navigate to Charting Browser and go to Add New------------//
		
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.navigate_ToChartingBrowser();
		
		//Step-4:--------------------Editing Chart------------//
		
		driver.switchTo().frame("gridFrame");
		driver.findElement(By.xpath("//tr[@id='gridChartingBrowser_grdEntityManager_row_6']")).click();
		cb.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.fnOWMClassicActionsMenu("Edit/View Details", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(3, "Add Chart Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.editChartDetails();
		
		//Step-5:-----------------View and Verify Chart----------------------//
		
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		driver.findElement(By.xpath("//tr[@id='gridChartingBrowser_grdEntityManager_row_6']")).click();
		cb.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.fnOWMClassicActionsMenu("Edit/View Details", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(3, "Add Chart Page");
		cb.view_Chart();
		
		//Step-5:-----------------Copy to New Chart----------------------//
		
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
		driver.findElement(By.xpath("//tr[@id='gridChartingBrowser_grdEntityManager_row_6']")).click();
		cb.actions();
		cb.fnOWMClassicActionsMenu("Copy to New", "");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(3, "Copy Chart");
		cb.copyToNew();
		lp.fnSwitchtoWindow(3, "Add Chart Page");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='btnSave']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@id='Img5']")).click();
		
		
		//Step-6--------------Archive----------------------//
		
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("gridFrame");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//tr[@id='gridChartingBrowser_grdEntityManager_row_6']")).click();
				cb.actions();
				cb.fnOWMClassicActionsMenu("Archive", "");
				
//				ppl_browser.click_ToArchive();
				//ppl_browser.archiveVerify();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//button[@id='dialog-button-action']")).click();
				
				
				// Step-7:----------------Purge Entity-----------------------------------//
				
				cb.actions();
				cb.fnOWMClassicActionsMenu("Purge", "");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				lp.fnSwitchtoWindow(3, "Delete Entity");
				cb.deleteEntity("Delete Entity");
				
				//Step-8-----------------Customize View------------------//
				
				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
				cb.actions();
				cb.fnOWMClassicActionsMenu("Customize View", "");
				lp.fnSwitchtoWindow(3, "Customize View");
				String[] array1 = new String[] { "Chart Name", "Chart Type", "Year", "As of Chart Date", "Owner Type",
						"Charting Tool", "Checked Out By", "Last Modified By", "Last Modified Date" };
				cb.fnCustomizeView(array1);
				
				// Step-9:----------------Save Preferences-----------------------------------//

				lp.fnSwitchtoWindow(2, "Entity Manager");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().frame("gridFrame");
						cb.actions();
						cb.fnOWMClassicActionsMenu("Save Preferences", "");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						cb.fnSavePreferences("Save Preferences");

				// Step-10:----------------Save Preferences for All-----------------------------------//
						
						cb.actions();
						cb.fnOWMClassicActionsMenu("Save Preferences for All", "");
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						cb.fnSavePreferences("Save Preferences for All");
						
				
		

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
