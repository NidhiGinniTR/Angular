package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
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
import com_obj_ObjectRepository.LS1.Entity_Manager_People_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_People_BrowserClassic;
import com_obj_ObjectRepository.LS1.LS1;


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

		Entity_Manager_People_BrowserClassic ppl_browser = new Entity_Manager_People_BrowserClassic(driver,propSerialData);
		
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		lp.fnLogin();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);

		// Step-2:-----Launch Entity Unit Browser---------------------------//
		lp.LaunchApplication("Entity Manager Classic");

		// Step-3:-----Verify Search Fields---------------------------//
		//driver.switchTo().defaultContent();
		lp.fnSwitchtoWindow(2, "Entity Manager");
		
		//Step-3:--------Navigate to People Browser and go to Add New------------//
		
		ppl_browser.navigate_ToPeopleBrowser();
		driver.switchTo().frame("gridFrame");
		ppl_browser.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.fnOWMClassicActionsMenu("Add New", "");
		
		//Step-4:--------Creating New Individual Profile------------//
		
		
		lp.fnSwitchtoWindow(3, "Individual Profile");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ppl_browser.create_Individual();
		
		//Step-5------------Logoff from classic ---------------------//
		
		lp.fnSwitchtoWindow(2, "Entity Manager");
		driver.findElement(By.xpath("//table[@id='TabStrip1_7']")).click();
		
		
		
		
	
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