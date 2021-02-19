package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.loginPage;

import com_obj_ObjectRepository.LS1.EntityUnitBrowser;

public class Entity_Manager_ResponsbilityInfo_Test extends BrowserInvoke {
	
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
		public void NewFolderCreation() throws InterruptedException {
			loginPage lp = new loginPage(driver,propEnv,propSerialData);
			EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
			//OWM owm = new OWM(driver,propSerialData);
			
			// Step-1:-----Login---------------------------------------------//
			
			lp.fnLogin();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			//Step-2:-----Launch WorkFlow Manager---------------------------//
			
			lp.LaunchApplication("Entity Manager");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().parentFrame();
			
			// Step---3: Search and Navigate to Entity-------------//
			
			Eub.searchEntity();
			Eub.navtoEditview();
			
			//Step-4: -------Navigate and edit Responsbility info----------------//
			
			lp.fnSwitchtoWindow(2, "Entity Information");
			Eub.responsibility_info();
			
			//Step-5:---------View Responsibility Info Tab------------//
			
			lp.fnSwitchtoWindow(1, "LS1");
			driver.switchTo().defaultContent();
			Eub.doubleclickEntity();
			lp.fnSwitchtoWindow(2, "Entity Information");
			Eub.viewResonsblityInfo();
			
			//Step-6:--------------------Logoff----------------//
			
		}
		
		@AfterClass
		void closeBrowser() throws InterruptedException {
			//FunctionLibrary.fnLogOff(driver);
			driver.quit();
		}

		@AfterSuite
		public void aftersuite() {
			ExtentManager.endReport();
		}


}
