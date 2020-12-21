package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;

public class OWM_Actions_Test extends BrowserInvoke {
	
	@BeforeSuite
	public void beforeStart() {
		ExtentManager.createInstance();
	}
	
	public void Initialize() throws IOException {
		driver = InvokeDriver();
		driver.get(propEnv.getProperty("URL"));
	}
	
	@Test(dependsOnMethods = "Initialize")
	public void Tasks() throws InterruptedException {
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
