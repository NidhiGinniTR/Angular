package com_pkg_OSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

public class EntityUnitBrowser_Ownership_Owners_Test extends BrowserInvoke {
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}

	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	@Test(dependsOnMethods = "Initialize")
	public void Ownership_Owners() throws InterruptedException, AWTException {
		// Step--------------Initializations----------------//
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver, propSerialData);
		EntityUnitBrowser em = new EntityUnitBrowser(driver, propSerialData,propSerialData);
		FrameWork fm = new FrameWork();
		// OWM owm = new OWM(driver,propSerialData);
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager");
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		em.fnSearchEntity();
		// Double click on required workflow
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
				"DoubleClick");
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		lp.fnSwitchtoWindow(2, "Entity Information");

		// Step----------Navigateto Ownership tab to Owners
		// tab--------------------------//
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_1']//nobr"), "Ownership");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOwner']"), "Owners");
		driver.switchTo().frame("fraContent2");
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By
								.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}
		String temptext = driver.findElement(By.xpath("//div[@id='divRunningTotal']")).getText();

		// Step----------Add New-------------------------------//
		fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
				"Actions");
		lp.fnOWMActionsMenu("Add Owner", "");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		lp.fnSwitchtoWindow(3, "Entity Manager");
		em.fnEntityManagerOwnersAddNew(temptext);

		// Step-----------Edit/View Details-------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOrg']"), "Org-Reorg");
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOwner']"), "Owners");
		Thread.sleep(2500);
		driver.switchTo().frame("fraContent2");
		List<WebElement> rowsafter = driver
				.findElements(By.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rowsafter.size());
		if (rowsafter.size() >= 2) {
			for (int i = 2; i <= rowsafter.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By
								.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
				fm.fnWebButton(driver,
						By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"), "Actions");
				lp.fnOWMActionsMenu("Edit/View Details", "");
				Thread.sleep(3000);
				lp.fnSwitchtoWindow(3, "Entity Manager");
				em.fnEntityManagerOwnersEditViewDetails(i);
				lp.fnSwitchtoWindow(2, "Entity Information");
				driver.switchTo().frame("fraContent2");
				
			}
		}

		// Step----------Customize View--------------------------//
			driver.switchTo().parentFrame();
		//lp.fnSwitchtoWindow(2, "Entity Information");
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOrg']"), "Org-Reorg");
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//label[@id='lblOwner']"), "Owners");
		Thread.sleep(1000);
		driver.switchTo().frame("fraContent2");
		fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
				"Actions");
		lp.fnOWMActionsMenu("Customize View", "");
		Thread.sleep(1500);
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array = new String[] { "Owners Name", "Owners ID", "As of Date", "Percentage Owned" };
		em.fnCustomizeView(array);

		// Step----------Save Preferences------------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.switchTo().frame("fraContent2");
		fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
				"Actions");
		lp.fnOWMActionsMenu("Save Preferences", "");
		em.fnSavePreferences("Save Preferences");

		// Step----------Save Preferences for All----------------//
		// lp.fnSwitchtoWindow(2, "Entity Information");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
				"Actions");
		lp.fnOWMActionsMenu("Save Preferences for All", "");
		em.fnSavePreferences("Save Preferences for All");

		// Step-----------Delete---------------------------------//
		List<WebElement> rows1 = driver
				.findElements(By.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rows1.size());
		if (rows1.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows1.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By
								.xpath("//DIV[@id='gridOwners_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}
		driver.close();
		lp.fnSwitchtoWindow(1, "Onesource");

		// Step--------LogOFF-------------------------------//
		em.fnLogOff();
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		// driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
