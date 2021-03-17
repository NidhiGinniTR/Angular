package com_pkg_OSP;

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

public class Entity_Manager_ResponsibilityInfo_Test extends BrowserInvoke {
	
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
		public void ResponsbilityInfo() throws InterruptedException {
			loginPage lp = new loginPage(driver,propEnv,propSerialData);
			EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
			FrameWork fm = new FrameWork();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);			
	//Step-1:-----Login---------------------------------------------//
			lp.fnLogin();
			
	//Step-2:-----Launch WorkFlow Manager---------------------------//
			lp.LaunchApplication("Entity Manager");
			driver.switchTo().defaultContent();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));

	// Step---3: Search and Navigate to Entity-------------//
			Eub.fnSearchEntity();
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
			Eub.navtoEditview();
			
	//Step-4: -------Navigate and edit Responsbility info----------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			lp.fnSwitchtoWindow(2, "Entity Information");
			Eub.responsibility_info();
			
			//Step-5:---------View Responsibility Info Tab------------//
			wait.until(ExpectedConditions.numberOfWindowsToBe(1));
			lp.fnSwitchtoWindow(1, "LS1");
			driver.switchTo().defaultContent();
			Eub.doubleclickEntity();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			lp.fnSwitchtoWindow(2, "Entity Information");
			Eub.viewResonsblityInfo();
			lp.fnSwitchtoWindow(1, "LS1");
			//Step-6:--------------------Logoff----------------//
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
