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


public class People_Browser_CreatingProfile extends BrowserInvoke {

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
	public void people_Browser_AddNew() throws Exception {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		Entity_Manager_People_Browser ppl_browser = new Entity_Manager_People_Browser(driver, propEnv, propSerialData);
		
		
		//OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		
		lp.fnLogin();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		
		lp.LaunchApplication("Entity Manager");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().parentFrame();
		
		//Step-3:--------Navigate to People Browser and go to Add New------------//
		
		ppl_browser.navigate_ToPeopleBrowser();
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.fnOWMActionsMenu(driver, "Add New", "");
		
		//Step-4:--------Creating New Individual Profile------------//
		
		
		lp.fnSwitchtoWindow(2, "Individual Profile");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.create_Individual();
		
		
		
		
	
	}
	
//	@AfterMethod //AfterMethod annotation - This method executes after every test execution
//	public void screenShot(ITestResult result){
//		if(ITestResult.FAILURE==result.getStatus()){
//			try{				
//				TakesScreenshot screenshot=(TakesScreenshot)driver;
//				File src=screenshot.getScreenshotAs(OutputType.FILE);
//				FileUtils.copyFile(src, new File("C:\\Users\\X022129\\Pictures\\Screenshots\\Scnshot\\"+result.getName()+".png"));
//				System.out.println("Successfully captured a screenshot");
//			}catch (Exception e){
//				System.out.println("Exception while taking screenshot "+e.getMessage());
//			} 
//	}
//	
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