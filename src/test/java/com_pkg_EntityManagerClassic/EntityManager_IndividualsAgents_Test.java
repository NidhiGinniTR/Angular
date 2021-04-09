package com_pkg_EntityManagerClassic;

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
import com_obj_ObjectRepository.LS1.LS1;

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
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(50)).pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class).ignoring(NoSuchFrameException.class);
		
		// Step--------------Initializations----------------//
		lp.fnLogin();
		
		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager Classic");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		// Step-3:-----Verify Search Fields---------------------------//
		driver.switchTo().frame("gridFrame");

		// Step---3: Search and Navigate to Entity-------------//
		Eub.fnSearchEntity();
		
		// Double click on required workflow
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"DoubleClick");
		Thread.sleep(3500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Entity Information");
		Thread.sleep(3500);
		
		// Step----------Navigateto Individuals/Agents tab--------------------------//
		lp.fnEntitiesTabNavigation("Individuals/Agents","");
		//fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_2']//nobr"), "Individuals/Agents");
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
		Thread.sleep(3500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Entity Manager");
		Eub.fnEMAddNewPerson_IndividualsAgents();
		
		//Step-----------Assign Global Person--------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Assign Global Person", "");
		Thread.sleep(1500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Entity Manager");
		Eub.fnEMAssignGlobalPerson_IndividualsAgents();
		
		// Step-----------Edit/View Details-------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Individuals/Agents");
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_1']//nobr"), "Ownership");
		fm.fnWebButton(driver, By.xpath("//table[@id='TabStrip1_2']//nobr"), "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebTable(driver,driver.findElement(By.xpath("//DIV[@id='gridBODR_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[2]")),"Click");
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Edit/View Details", "");
		Thread.sleep(3500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Entity Manager");
		Thread.sleep(3500);
		Eub.fnEMEditViewIndividuals_Agents();
		Thread.sleep(3500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Individuals/Agents");
		
		// Step----------Customize View--------------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Customize View", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(4));
		lp.fnSwitchtoWindow(4, "Customize View");
		String[] array = new String[] { "First Name", "Middle Initial", "Last Name",
				"Title","Role","Position","Order","Date"};
		Eub.fnCustomizeView(array);

		// Step----------Save Preferences------------------------//
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Individuals/Agents");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("fraContent3"));
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step----------Save Preferences for All----------------//
		Thread.sleep(2000);
		fm.fnWebButton(driver, By.xpath("//img[@id='btnActionsMenu']"), "Actions");
		lp.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");

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
		//lp.fnSwitchtoWindow(2, "Entity Manager");

		// Step--------LogOFF-------------------------------//
		//Eub.fnLogOff();
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		driver.quit();
		//Eub.fnLogOff();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
