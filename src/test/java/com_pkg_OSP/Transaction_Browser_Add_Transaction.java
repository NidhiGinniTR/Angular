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
import com_obj_ObjectRepository.LS1.Entity_Manager_People_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_Transaction_Browser;


public class Transaction_Browser_Add_Transaction extends BrowserInvoke {
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
	public void transaction_Browser_AddNew() throws Exception {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		Entity_Manager_People_Browser ppl_browser = new Entity_Manager_People_Browser(driver, propEnv, propSerialData);
		Entity_Manager_Transaction_Browser tr = new Entity_Manager_Transaction_Browser(driver, propEnv, propSerialData);
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
		lp.fnLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
		lp.LaunchApplication("Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		
		//Step-3:--------Navigate to Transaction Browser and go to Add New------------//
		
		tr.navigate_ToTransectionBrowser();
		
		//Step-4:--------------------Adding New Transactions------------//
		
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.fnOWMActionsMenu("Add New", "");
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().frame("Iframe1");
		tr.add_Transaction();
		
		
		
		

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