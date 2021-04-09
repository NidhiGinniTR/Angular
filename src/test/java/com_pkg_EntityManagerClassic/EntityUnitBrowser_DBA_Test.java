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
import org.openqa.selenium.Keys;
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
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;
import com_obj_ObjectRepository.LS1.LS1;

public class EntityUnitBrowser_DBA_Test extends BrowserInvoke {
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
	public void EntityUnitBrowserDBA() throws InterruptedException, AWTException {
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propSerialData, propSerialData);
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);

		//--------Login-----------------------------------------//
			lp.fnLogin();
		// Step-2:-----Launch Entity Unit Browser---------------------------//
			lp.LaunchApplication("Entity Manager Classic");

		// Step-3:-----Verify Search Fields---------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			lp.fnSwitchtoWindow(2, "Entity Manager");
			driver.manage().window().maximize();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));

		// Step---3: Search and Navigate to Entity-------------//
			Eub.fnSearchEntity();
		
		// Selecting required Workflow------------------------->
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"DoubleClick");
			Thread.sleep(4000);
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Information");
	
		//Step----------NavigatetoDBA--------------------------//
			lp.fnEntitiesTabNavigation("Entity Information", "DBA");
			//fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
			List<WebElement> rows = driver.findElements(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
			System.out.println(rows.size());
			Actions action = new Actions(driver);
			if(rows.size()>=2) {
				Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        //action.keyDown(Keys.CONTROL).build().perform();
		        for(int i=2;i<=rows.size();i++) {
		        	action.moveToElement(driver.findElement(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR["+i+"]"))).click().build().perform();
		        }
		        //action.keyUp(Keys.CONTROL).build().perform();
		        robot.keyRelease(KeyEvent.VK_CONTROL);
				fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
						"Actions");
				lp.fnOWMActionsMenu("Delete", "");
				Thread.sleep(1000);
				fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");
			}
			
		//Step----------Add New-------------------------------//
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//a[@class='btn btn-primary dropdown-toggle']"),	"Actions");
			//Eub.fnClickActionsTaxID();
			lp.fnOWMActionsMenu("Add New", "");
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Entity Manager");
			Eub.fnDBAAddNew();
			
		//Step-----------Edit/View Details-------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Information");
			lp.fnEntitiesTabNavigation("", "KeyContacts");
			//fm.fnWebButton(driver, By.xpath("//label[@id='lblKeyContacts']"),"Key Contacts");
			Thread.sleep(1000);
			lp.fnEntitiesTabNavigation("", "DBA");
			//fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
			fm.fnWebTable(driver,
					driver.findElement(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[2]")),
					"Click");
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Edit/View Details", "");
			Thread.sleep(1500);
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Entity Manager");
			Eub.fnEntityManagerDBAEdit();
			
		//Step----------Customize View--------------------------//
			driver.close();
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Information");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Customize View", "");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.numberOfWindowsToBe(4));
			lp.fnSwitchtoWindow(4, "Customize View");
			Thread.sleep(1000);
			String[] array = new String[] { "DBA Name", "Description", "From Date", "Status", "County",
			"To Date" };
			Eub.fnCustomizeView(array);
			
		//Step----------Save Preferences------------------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Information");
			lp.fnEntitiesTabNavigation("", "DBA");
			Thread.sleep(1000);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame1"));
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Save Preferences", "");
			Eub.fnSavePreferences("Save Preferences");
			
		//Step----------Save Preferences for All----------------//
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Save Preferences for All", "");
			Eub.fnSavePreferences("Save Preferences for All");
			
		//Step-----------Delete---------------------------------//
			fm.fnWebTable(driver,
					driver.findElement(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[2]")),
					"Click");
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Delete", "");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");
			driver.close();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			lp.fnSwitchtoWindow(2, "Entity Manager");
			//Step--------LogOFF-------------------------------//
			lp.fnEntityManagerTabNavigation("Logout");
			Eub.fnLogOff();
	}

	@AfterClass
	void closeBrowser() throws InterruptedException {
		//EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		//Eub.fnLogOff();
		driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
