package com_pkg_EntityManagerClassic;

import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

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
import com_obj_ObjectRepository.LS1.Entity_Manager_Charting_Browser;
import com_obj_ObjectRepository.LS1.Entity_Manager_Charting_BrowserClassic;
import com_obj_ObjectRepository.LS1.LS1;



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
		
		Entity_Manager_Charting_BrowserClassic cb = new Entity_Manager_Charting_BrowserClassic(driver, propEnv, propSerialData);
		
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
		
		//Step-3:--------Navigate to Charting Browser and go to Add New------------//
		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.navigate_ToChartingBrowser();
		
		//Step-4:--------------------Adding New Chart------------//
		
		driver.switchTo().frame("gridFrame");
		cb.actions();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.fnOWMClassicActionsMenu("Add New", "");
		lp.fnSwitchtoWindow(3, "Add Chart Page");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cb.add_ChartDetails();
		lp.fnSwitchtoWindow(3, "Entity Tree");
		
		
		
		
		

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
