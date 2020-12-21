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

public class OWM_Actions_Test extends BrowserInvoke {
	
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	@Test
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
		FunctionLibrary.fnLaunchApplication(driver, "WorkFlow Manager");
		Thread.sleep(3000);
		
	//Step-3:-----Navigate to Respective Tab------------------------//
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
		Thread.sleep(900);
		
	//Step-4:-----Search for the Required Workflow------------------//
		FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
		Thread.sleep(3000);
		
	//Step-5:-----Double click on the workflow to Folder Workflows---//
		driver.switchTo().frame("viewIFrame");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
		Thread.sleep(10000);
		
		//--------------------------------------------Login----------------------------------------------------------------------
		//-------------------------------------Launch WorkFlow Manager-----------------------------------------------------------
		//-----------------------------------Navigate to Respective Tab----------------------------------------------------------
		//----------------------------------Create a new Serial Workflow---------------------------------------------------------
		//--------------------------------Search for the Required Workflow-------------------------------------------------------
		//----------------------Verifying the WorkFlow Properties window fields with our data------------------------------------
		//----------------------Verifying the WorkFlow History window and exporting the data-------------------------------------
		//--------------Locking the particular WorkFlow and verifying the same in WorkFlow Properties window---------------------
		//-------------------------------------Unlocking the WorkFlow------------------------------------------------------------
		//-------------------------------Exporting the WorkFlow Browser records--------------------------------------------------
		//------------------------------Setting the Customize View window as required--------------------------------------------
		//------------------------------Saving the preferences in the WorkFlow Browser-------------------------------------------
		//-----------------------Saving the preferences in the WorkFlow Browser for all users------------------------------------
		//----------------------------Clicking on New WorkFlow and creating a new workflow---------------------------------------
		
	}

}
