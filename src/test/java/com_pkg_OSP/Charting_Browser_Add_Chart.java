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
import com_obj_ObjectRepository.LS1.Entity_Manager_Charting_Browser;



public class Charting_Browser_Add_Chart extends BrowserInvoke {
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
	public void addNew_Chart() throws Exception {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		Entity_Manager_Charting_Browser cb = new Entity_Manager_Charting_Browser(driver, propEnv, propSerialData);
		
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
		lp.fnLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
		lp.LaunchApplication("Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		
		//Step-3:--------Navigate to Charting Browser and go to Add New------------//
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.navigate_ToChartingBrowser();
		
		//Step-4:--------------------Adding New Chart------------//
		
		driver.switchTo().frame("gridFrame");
		cb.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.fnOWMActionsMenu(driver, "Add New", "");
		lp.fnSwitchtoWindow(2, "Add Chart Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.add_ChartDetails();
		lp.fnSwitchtoWindow(2, "Entity Tree");
		
		
		
		
		

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
