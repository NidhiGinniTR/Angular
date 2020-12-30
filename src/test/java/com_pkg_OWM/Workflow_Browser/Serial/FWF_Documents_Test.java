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

public class FWF_Documents_Test extends BrowserInvoke{
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException {
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
			
		//Step-4:-----Search for the Required Workflow------------------//
			FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
			Thread.sleep(2000);
			
		//Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			Thread.sleep(10000);
			
		//Step-6:----Navigate to Document Tab----------------------------//
		
		//Step-7:----Actions---------------------------------------------//
				//---Add Document~New Document--------------------------//
		//Step-8:----Email Documents-------------------------------------//
		//Step-9:-----Change Status--------------------------------------//
		//Step-10:----Review Documents-----------------------------------//
		//Step-11:----Associate Documents to workflow--------------------//
		//Step-12:----Document Properties--------------------------------//
		//Step-13:---Document History-----------------------------------//
		//Step-14:---Customize View-------------------------------------//
		//Step-15:----Save Preferences-----------------------------------//
		//Step-16:---Save Preferences for all---------------------------//
		//Step-17:---Saved Search---------------------------------------//
			
}
}
