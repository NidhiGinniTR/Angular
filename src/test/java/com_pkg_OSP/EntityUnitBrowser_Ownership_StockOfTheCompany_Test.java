package com_pkg_OSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import org.openqa.selenium.interactions.Actions;
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
import com_obj_ObjectRepository.OWM.OWM;

public class EntityUnitBrowser_Ownership_StockOfTheCompany_Test extends BrowserInvoke {
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
	public void Ownership_StockOfTheCompany() throws InterruptedException, AWTException {
		// Step--------------Initializations----------------//
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver, propSerialData);
		EntityUnitBrowser em = new EntityUnitBrowser(driver, propSerialData,propSerialData);
		FrameWork fm = new FrameWork();
		// OWM owm = new OWM(driver,propSerialData);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		em.fnSearchEntity();
		// Double click on required workflow
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
				"DoubleClick");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Information");

		// Step----------Navigateto Ownership tab to Stock Of The Company--------------------------//
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_1']//nobr"), "Ownership");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//label[@id='lblStock']"), "Stock Of The Company");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By
								.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
			lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}

		// Step----------Add New-------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
		lp.fnOWMActionsMenu("Add New", "");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Manager");
			//Creating a Related Share Holder
				em.fnEMStockOfCompanyAddNew("Related");
				Thread.sleep(2000);
			//Creating a Unrelated Share Holder
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				lp.fnSwitchtoWindow(2, "Entity Information");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
				fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
				lp.fnOWMActionsMenu("Add New", "");
				Thread.sleep(1000);
				wait.until(ExpectedConditions.numberOfWindowsToBe(3));
				lp.fnSwitchtoWindow(3, "Entity Manager");
				em.fnEMStockOfCompanyAddNew("UnRelated");
				
		// Step-----------Edit/View Details-------------------//
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Information");
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOrg']"), "Org-Reorg");
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//label[@id='lblStock']"), "Stock Of The Company");
		Thread.sleep(2500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
		List<WebElement> rowsafter = driver
				.findElements(By.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rowsafter.size());
		if (rowsafter.size() >= 2) {
			for (int i = 2; i <= rowsafter.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By
								.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
				fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
				lp.fnOWMActionsMenu("Edit/View Details", "");
				Thread.sleep(1000);
				wait.until(ExpectedConditions.numberOfWindowsToBe(3));
				lp.fnSwitchtoWindow(3, "Entity Manager");
				em.fnEMStockOfCompanyEdit(i);
				Thread.sleep(1000);
				wait.until(ExpectedConditions.numberOfWindowsToBe(2));
				lp.fnSwitchtoWindow(2, "Entity Information");
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
				
			}
		}

		// Step----------Customize View--------------------------//
			driver.switchTo().parentFrame();
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOwner']"), "Owners");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//label[@id='lblStock']"), "Stock Of The Company");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
		lp.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array = new String[] { "Class of Stock", "Beginning of Tax Year", "End of Tax Year", "Name of Stock Holder","ID of Stock Holder"};
		em.fnCustomizeView(array);

		// Step----------Save Preferences------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Information");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent2"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
		lp.fnOWMActionsMenu("Save Preferences", "");
		em.fnSavePreferences("Save Preferences");

		// Step----------Save Preferences for All----------------//
		// lp.fnSwitchtoWindow(2, "Entity Information");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
		lp.fnOWMActionsMenu("Save Preferences for All", "");
		em.fnSavePreferences("Save Preferences for All");

		// Step-----------Delete---------------------------------//
		List<WebElement> rows1 = driver
				.findElements(By.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rows1.size());
		if (rows1.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows1.size(); i++) {
				fm.fnWebTable(driver,driver.findElement(By.xpath("//DIV[@id='gridSc_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"),"Actions");
			lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}
		driver.close();
		wait.until(ExpectedConditions.numberOfWindowsToBe(1));
		lp.fnSwitchtoWindow(1, "Onesource");

		// Step--------LogOFF-------------------------------//
		em.fnLogOff();
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		 driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
