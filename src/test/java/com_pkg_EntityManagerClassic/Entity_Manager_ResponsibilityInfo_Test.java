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
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
			Eub.navtoEditview();
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			
			//Step-4: -------Navigate and edit Responsbility info----------------//
			lp.fnSwitchtoWindow(3, "Entity Information");
			Eub.responsibility_info();
			wait.until(ExpectedConditions.numberOfWindowsToBe(2));
			
			//Step-5:---------View Responsibility Info Tab------------//
			lp.fnSwitchtoWindow(2, "Entity Manager");
			Eub.doubleclickEntity();
			wait.until(ExpectedConditions.numberOfWindowsToBe(3));
			lp.fnSwitchtoWindow(3, "Entity Information");
			Eub.viewResonsblityInfo();
			
			//Step-6:--------------------Logoff----------------//
			
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
