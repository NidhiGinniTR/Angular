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

public class EntityUnitBrowser_DBA_Test extends BrowserInvoke {
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
	public void EntityUnitBrowserDBA() throws InterruptedException, AWTException {
		//Step--------------Initializations----------------//
		loginPage lp = new loginPage(driver, propEnv, propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver, propSerialData);
		EntityUnitBrowser em = new EntityUnitBrowser(driver, propSerialData,propSerialData);
		FrameWork fm = new FrameWork();
		// OWM owm = new OWM(driver,propSerialData);
		// Step-1:-----Login---------------------------------------------//
			lp.fnLogin();
			
		//Step-2:-----Launch Entity Manager---------------------------//
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
	
		//Step----------NavigatetoDBA--------------------------//
			fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			driver.switchTo().frame("gridFrame1");
			List<WebElement> rows = driver.findElements(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
			Actions action = new Actions(driver);
			if(rows.size()>1) {
				Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        for(int i=1;i<=rows.size();i++) {
		        	action.moveToElement(driver.findElement(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR["+i+"]"))).click().build().perform();
		        }
				robot.keyRelease(KeyEvent.VK_CONTROL);
				fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
						"Actions");
				lp.fnOWMActionsMenu("Delete", "");
				Thread.sleep(1000);
				fm.fnWebButton(driver, By.xpath("//*[@id='dialog-button-action']"), "OK");
			}
			
		//Step----------Add New-------------------------------//
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Add New", "");
			Thread.sleep(2000);
			System.out.println(driver.getTitle());
			lp.fnSwitchtoWindow(3, "Entity Manager");
			em.fnDBAAddNew();
			
		//Step-----------Edit/View Details-------------------//
			lp.fnSwitchtoWindow(2, "Entity Information");
			fm.fnWebButton(driver, By.xpath("//label[@id='lblKeyContacts']"),"Key Contacts");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			driver.switchTo().frame("gridFrame1");
			fm.fnWebTable(driver,
					driver.findElement(By.xpath("//DIV[@id='gridDBA_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR[2]")),
					"Click");
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Edit/View Details", "");
			Thread.sleep(1500);
			lp.fnSwitchtoWindow(3, "Entity Manager");
			em.fnEntityManagerDBAEdit();
			
		//Step----------Customize View--------------------------//
			lp.fnSwitchtoWindow(2, "Entity Information");
			fm.fnWebButton(driver, By.xpath("//label[@id='lblKeyContacts']"),"Key Contacts");
			Thread.sleep(1500);
			fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			driver.switchTo().frame("gridFrame1");
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Customize View", "");
			lp.fnSwitchtoWindow(3, "Customize View");
			String[] array = new String[] { "DBA Name", "Description", "From Date", "Status", "County",
			"To Date" };
			em.fnCustomizeView(array);
			
		//Step----------Save Preferences------------------------//
			lp.fnSwitchtoWindow(2, "Entity Information");
			fm.fnWebButton(driver, By.xpath("//label[@id='lblKeyContacts']"),"Key Contacts");
			Thread.sleep(1500);
			fm.fnWebButton(driver, By.xpath("//label[@id='lblDBA']"),"DBA");
			Thread.sleep(1000);
			driver.switchTo().frame("gridFrame1");
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Save Preferences", "");
			em.fnSavePreferences("Save Preferences");
			
		//Step----------Save Preferences for All----------------//
			//lp.fnSwitchtoWindow(2, "Entity Information");
			Thread.sleep(1000);
			fm.fnWebButton(driver, By.xpath("//div[@class='btn-group']//*[@class='btn btn-primary dropdown-toggle']"),
					"Actions");
			lp.fnOWMActionsMenu("Save Preferences for All", "");
			em.fnSavePreferences("Save Preferences for All");
			
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
			driver.quit();
		
			//Step--------LogOFF-------------------------------//
			//em.fnLogOff();
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
