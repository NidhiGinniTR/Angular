package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		lp.fnLogin();
		
		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager Classic");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		// Step-3:-----Verify Search Fields---------------------------//
		//driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		String[] array = new String[] { "Entity Name", "Entity ID", "Entity Type", "Status", "Locations", "Group Code",
				"Entity Group", "Archive", "PPOB State/Province", "PPOB Country/Region" };
		Eub.fnVerifySearchElements(array);

		// Step-4:------------Verify Action Menu items---------------------------//
		Eub.fnClickActions();
		Eub.fnActionsMenuEnabled();
		Eub.fnActionsMenuDisabled();

		// ------------------------------------------------------------------------------
		Eub.fnSearchEntity();
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridEntityBrowser_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
					"Click");
			Eub.fnClickActions();
			Eub.fnOWMActionsMenu("Delete", "");
			// fm.fnWebTable(driver,
			// driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
			lp.fnSwitchtoWindow(3, "Delete Entity");
			fm.fnWebButton(driver, By.xpath("//input[@id='btnPurge']"), "Delete");
			lp.fnSwitchtoWindow(2, "Entity Manager");
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
			Thread.sleep(2000);
			
		}

		// Step-5----------------------CLick Actions & Add New Entity---------------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Add New", "");

		// Step-6------------------------Create a New Entity-------------------------------------//
		Thread.sleep(3000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
		Eub.fnCreateEntity();

		// Step-7:--------------------Search created Entity--------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));

		Eub.fnSearchEntity();

		// Step-8:---------------------Click Actions--Edit/View Details-------------------------------//

		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
				"Click");
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Edit/View Details", "");

		// Step-9:--------------------Verify Edit/View Details--------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
		Eub.fnEditDeatils_Entity();

		// Step-10:----------------------Search Entity------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));

		Eub.fnSearchEntity();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
				"Click");

		// Step-11:--------------------Copy Entity--------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Copy to New", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Copy Entity");
		Eub.copyentity();

		// Step-12:---------------------Import Entity-------------------------------//
		// //
		// Eub.fnEntityManagerImport();

		// Step-13:----------------------------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");

		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));

		// Step-14:----------------Customize View-----------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(2500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array1 = new String[] { "Entity Name", "Status", "Entity Id", "State of Inc", "Group Code",
				"Entity Type", "Entity Group Name" };
		Eub.fnCustomizeView(array1);

		// Step-15:----------------Save Preferences-----------------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnClickActions();
		Thread.sleep(2500);
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step-16:----------------Save Preferences forAll-----------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");

		// Step-16-----------------LogOff--------------------------------------------------------//
		Eub.fnLogOff();

	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		// Eub.fnLogOff();
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}

}