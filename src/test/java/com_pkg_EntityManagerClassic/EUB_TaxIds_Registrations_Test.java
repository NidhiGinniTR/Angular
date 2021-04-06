package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.loginPage;
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
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();
		
		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager Classic");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		// Step---3: Search and Navigate to Entity-------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnSearchEntity();
		
		// Double click on required workflow
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"DoubleClick");
		// driver.switchTo().defaultContent();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
		System.out.println(driver.getTitle());
		
//		//Step-5--------------------------------------Edit/View Details-------------------------------------------------------//
//		Eub.fnClickActions();
//		Eub.fnOWMActionsMenu("Edit/View Details", "");
//		Thread.sleep(500);
//		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
//		lp.fnSwitchtoWindow(2, "Entity Information");
		Eub.fnClickTaxIds();
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
		Thread.sleep(1500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Entity Manager");
		Eub.fnAddNewTaxId();

		//Step-8------------------------------------------Search TaxId-----------------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
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
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Entity Manager");
		Eub.fnEditTaxIds();

		//Step-11:----------------Customize View-----------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
		Eub.fnClickActionsTaxID();
		Eub.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Customize View");
		String[] array3 = new String[] { "Authority Name", "Jurisdiction", "Form Tax Type", "DBA", "Notes",
				"Renewal Date", "Authority Name2" };
		Eub.fnCustomizeView(array3);

		//Step-12:----------------Save Preferences-----------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
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
