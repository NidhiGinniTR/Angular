package com_pkg_OSP;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;
import com_obj_ObjectRepository.LS1.LS1;

public class Entity_Manager_Banking_Test extends BrowserInvoke {
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
	public void EUB_Banking() throws InterruptedException, AWTException {
		// Step-1:-----Login---------------------------------------------//
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager");

		// Step-3:-----Switch Frames---------------------------//
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		Eub.fnSearchEntity();

		// Step-4:---------------------Double Click Banking-------------------------------//
		FrameWork fm = new FrameWork();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),
				"DoubleClick");

		//Step-5:--------------------------------Switch Window---------------------------------------//
		Eub.fnClickActions();
		Eub.fnOWMActionsMenu("Edit/View Details", "");
		lp.fnSwitchtoWindow(2, "Entity Information");
		System.out.println(driver.getTitle());
		Thread.sleep(2500);
		WebDriverWait wait = new WebDriverWait(driver, 60);
		
		// Step-6:------------------------------Delete Existing Banking---------------------------------------
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='TabStrip1_6']//nobr")));
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_6']//nobr"), "Banking");
		// fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_3']//nobr"), "Places
		// of Business");
		// fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_6']//nobr"),
		// "Banking");

		Thread.sleep(1000);
		
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent6"));
		//driver.switchTo().frame("fraContent6");
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridBanking_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(By.xpath(
								"//DIV[@id='gridBanking_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
			Thread.sleep(1000);
			Eub.fnOWMActionsMenu("Delete", "");
			// lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}

		// Step-7:----------Add New-------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Add New", "");
		Thread.sleep(2000);
		lp.fnSwitchtoWindow(3, "Entity Manager");
		Eub.fnEM_BankProfile();

		// Step-8:-----------------------Switch Frame-------------------------------------------
		lp.fnSwitchtoWindow(2, "Entity Information");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent6"));
		Thread.sleep(1500);
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridBanking_grdEntityManager_row_0']")), "Click");

		// Step-9:------------------------Edit Banking--------------------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Edit/View Details", "");
		Thread.sleep(2500);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		lp.fnSwitchtoWindow(3, "Entity Manager");
		System.out.println(driver.getTitle());
		Eub.fnEM_EditBankProfile();

		// Step-10:----------------Customize View-----------------------------------//
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(2, "Entity Information");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent6"));
		Thread.sleep(1500);

		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Customize View", "");
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array = new String[] { "Name of Institution", "Zip", "Main Email", "City", "State/Province", "Country",
				"Status" };
		Eub.fnCustomizeView(array);

		// Step-11:----------------Save Preferences-----------------------------------//
		lp.fnSwitchtoWindow(2, "Entity Information");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent6"));
		Thread.sleep(1500);

		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step-12:----------------Save Preferences for All-----------------------------------//
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");

		// Step-13:--------------------------------Delete Banking--------------------------------------------------------
		Thread.sleep(1500);
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridBanking_grdEntityManager_row_0']")), "Click");
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		Eub.fnOWMActionsMenu("Delete", "");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");
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
