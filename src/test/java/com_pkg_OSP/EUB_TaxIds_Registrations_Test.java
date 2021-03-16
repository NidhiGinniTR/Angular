package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class EUB_TaxIds_Registrations_Test extends BrowserInvoke {

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
	public void EUB_TaxIds() throws InterruptedException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		lp.fnLogin();

		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager");

		// Step-3:-----Search Entity---------------------------//
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		Eub.fnSearchEntity();
		Thread.sleep(1000);

		// Step-4:-------------------Select Entity---------------------------------//
		FrameWork fm = new FrameWork();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");

		//Step-5--------------------------------------Edit/View Details-------------------------------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Edit/View Details", "");
		Thread.sleep(500);
		lp.fnSwitchtoWindow(2, "Entity Information");
		Eub.fnClickTaxIds();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
		//driver.switchTo().frame("gridFrame1");

		//Step-6----------------------------------------Verify Search Fields-------------------------------------------------------------//
		String[] array2 = new String[] { "Jurisdiction", "Authority Name", "DBA", "Form Tax Type", "Tax ID",
				"Authority Name2", "Archive", "Search", "Clear" };
		Eub.fnVerifySearchElements(array2);

		//Step-7---------------------------------------------Add New TaxID--------------------------------------------------------//
		Eub.fnClickActionsTaxID();
		Thread.sleep(500);
		Eub.fnOWMActionsMenu("Add New", "");
		lp.fnSwitchtoWindow(3, "Entity Manager");
		Eub.fnAddNewTaxId();

		//Step-8------------------------------------------Search TaxId-----------------------------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
		Eub.fnSearchTaxIds1();
		Thread.sleep(1000);
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridTaxIds_grdEntityManager_row_0']")), "Click");

		//Step-9-----------------------------------------Archive------------------------------------------//
		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Archive", "");
		Eub.fnArchive();
		Thread.sleep(1000);
		
		//Step-10---------------------------------------Edit/View details of TaxId---------------------------------------------//
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridTaxIds_grdEntityManager_row_0']")), "Click");
		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Edit/View Details", "");
		lp.fnSwitchtoWindow(3, "Entity Manager");
		Eub.fnEditTaxIds();

		//Step-11:----------------Customize View-----------------------------------//
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
		
		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(1500);
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array3 = new String[] { "Authority Name", "Jurisdiction", "Form Tax Type", "DBA", "Notes",
				"Renewal Date", "Authority Name2" };
		Eub.fnCustomizeView(array3);

		//Step-12:----------------Save Preferences-----------------------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));

		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Thread.sleep(1000);
		Eub.fnSavePreferences("Save Preferences");

		//Step-13:----------------Save Preferences for All-----------------------------------//
		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");

	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}

}
