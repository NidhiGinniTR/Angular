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
import org.openqa.selenium.support.ui.WebDriverWait;
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

public class EntityManager_IndividualsAgents_Test extends BrowserInvoke {
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
	public void Individuals_Agents() throws InterruptedException, AWTException {
		// Step--------------Initializations----------------//
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver, propSerialData);
		EntityUnitBrowser em = new EntityUnitBrowser(driver, propSerialData,propSerialData);
		FrameWork fm = new FrameWork();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
				
		// OWM owm = new OWM(driver,propSerialData);
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
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Information");

		// Step----------Navigateto Individuals/Agents tab--------------------------//
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_2']//nobr"), "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(
								By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
			lp.fnOWMActionsMenu("Delete", "");
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");

		}

		// Step----------Add New Person-------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Add New Person", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Manager");
		em.fnEMAddNewPerson_IndividualsAgents();
		
		//Step-----------Assign Global Person--------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Assign Global Person", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Manager");
		em.fnEMAssignGlobalPerson_IndividualsAgents();
		
		// Step-----------Edit/View Details-------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Individuals/Agents");
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_1']//nobr"), "Ownership");
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_2']//nobr"), "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebTable(driver,driver.findElement(By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[2]")),"Click");
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Edit/View Details", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Manager");
		em.fnEMEditViewIndividuals_Agents();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Individuals/Agents");
		
		// Step----------Customize View--------------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Customize View", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array = new String[] { "First Name", "Middle Initial", "Last Name",
				"Title","Role","Position","Order","Date"};
		em.fnCustomizeView(array);

		// Step----------Save Preferences------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Save Preferences", "");
		em.fnSavePreferences("Save Preferences");

		// Step----------Save Preferences for All----------------//
		// lp.fnSwitchtoWindow(2, "Entity Information");
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Save Preferences for All", "");
		em.fnSavePreferences("Save Preferences for All");

		// Step-----------Delete---------------------------------//
		List<WebElement> rows1 = driver
				.findElements(By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rows1.size());
		if (rows1.size() >= 2) {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			for (int i = 2; i <= rows1.size(); i++) {
				fm.fnWebTable(driver,
						driver.findElement(
								By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[" + i + "]")),
						"Click");
			}
			robot.keyRelease(KeyEvent.VK_CONTROL);
			fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
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
		//driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
