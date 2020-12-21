package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FunctionLibrary;
import com_lib_FunctionLibrary.FunctionLibrary;

public class FWF_Tasks_Test extends BrowserInvoke {

	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException {
		//Step-1:-----Login---------------------------------------------//
			FunctionLibrary.fnLogin(driver, propEnv);
			
		//Step-2:-----Launch WorkFlow Manager---------------------------//
			FunctionLibrary.fnlaunchApplication(driver, "WorkFlow Manager");
			Thread.sleep(3000);
			
		//Step-3:-----Navigate to Respective Tab------------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
			FunctionLibrary.fnNavigateToTab(driver, "WorkFlow Browser");
			Thread.sleep(900);
			
		//Step-4:-----Search for the Required Workflow------------------//
			FunctionLibrary.fnWorkFlowBrowserSearch(driver, propParallelData);
			Thread.sleep(3000);
			
		//Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			Thread.sleep(10000);
			
		//Step-6:-----Click on Tasks Tab and Actions--------------------//
		//Step-7:-----Change Status-------------------------------------//
		//Step-8:-----Route Task----------------------------------------//
		//Step-9:-----Task Properties-----------------------------------//
		//Step-10:----Task History--------------------------------------//
		//Step-11:----Reset Checklist-----------------------------------//
		//Step-12:----Add Documents-------------------------------------//
		//Step-13:----View Documents------------------------------------//
		//Step-14:----Export--------------------------------------------//
		//Step-15:----Customize View-------------------------------------//
		//Step-16:----Save Preferences----------------------------------//
		//Step-17:----Save Preferences for All--------------------------//
		//Step-18:----LogOff-------------------------------------------//
		
	}
}
