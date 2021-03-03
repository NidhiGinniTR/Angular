package com_pkg_OSP;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.loginPage;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;

public class Entity_Manager_BusinessTaxInfo_Test extends BrowserInvoke{
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	@Test(dependsOnMethods = "Initialize")
	public void BusinessTaxInfo() throws InterruptedException {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
		lp.fnLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
		lp.LaunchApplication("Entity Manager");
		//driver.switchTo().parentFrame();
		//lp.fnSwitchtoWindow(1, "LS1");

		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");


		// Step---3: Search and Navigate to Entity-------------//
	
		//Eub.searchEntity();
		Eub.fnSearchEntity();
		
		FrameWork fm = new FrameWork();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridEntityBrowser_grdEntityManager_row_0']")),"Click");
		
		Eub.navtoEditview();
		
		//Step-4: -------Navigate and edit Business tax info----------------//
		
		lp.fnSwitchtoWindow(2, "Entity Information");
		Eub.business_Taxinfo();
		
		//Step-5:---------View Business/Tax Info Tab------------//
		
		lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		Eub.doubleclickEntity();
		lp.fnSwitchtoWindow(2, "Entity Information");
		Eub.viewBusinessTax();
		
		//Step--------LogOFF-------------------------------//
		//em.fnLogOff();
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
