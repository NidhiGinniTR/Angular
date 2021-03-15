package com_pkg_OWM.Workflow_Browser.Serial;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FunctionLibrary;

public class FWF_SplitterMenu_Test extends BrowserInvoke {
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	@Test
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException, AWTException {
		//Step-1:-----Login---------------------------------------------//
			FunctionLibrary.fnLogin(driver, propEnv);
			Thread.sleep(3000);
			
		//Step-2:-----Launch WorkFlow Manager---------------------------//
			FunctionLibrary.fnLaunchApplication(driver, "WorkFlow Manager");
			Thread.sleep(3000);
			
		//Step-3:-----Navigate to Respective Tab------------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
			FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
			Thread.sleep(1800);
		
		//Step-4:-----Double click on the workflow to Folder Workflows---//
			
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			Thread.sleep(10000);
			//driver.switchTo().parentFrame();
			
		//Step-5:----Navigate to Splitter menu----------------------------//
			
			//FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
			String winHandleBefore = driver.getWindowHandle();

			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			Actions action_sm = new Actions(driver);
			action_sm.moveToElement(driver.findElement(By.xpath("//table[@id='Splitter1']/tbody/tr/td[2]/img"))).click().build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//Step-6:--------Locking Work flow----------------------------------//
			
			action_sm.moveToElement(driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_3']"))).contextClick().build().perform();
			FunctionLibrary.fnLockingworkflow(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//Step-7:--------UnLocking Work flow----------------------------------//	
			
			FunctionLibrary.fnUnLockingworkflow(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
		//Step-8:-------Saving preferences of the Work flow----------------------------------//
			
			action_sm.moveToElement(driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_3']"))).contextClick().build().perform();
			FunctionLibrary.fnsavepreferences(driver);
			
		//Step-9:-------Saving all preferences of the Work flow----------------------------------//
			
			action_sm.moveToElement(driver.findElement(By.xpath("//td[@id='FolderWorkflowGrid_cell_0_3']"))).contextClick().build().perform();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			action.moveToElement(driver.findElement(By.xpath("//td[@id='mnuFolderWorkflows_20']"))).click().build().perform();
			 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		        String[] array= new String[] {"Desc","Progress","Year","Period","Tax Type","Entity Name"};
		        FunctionLibrary.fnSwitchtoWindow(driver,4, "Customize View");
		        FunctionLibrary.fnOWMCustomizeView(driver,array);
			
			
	    
			
				
	}
	@AfterClass
	void closeBrowser() throws InterruptedException {
		//FunctionLibrary.fnLogOff(driver);
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}

}
