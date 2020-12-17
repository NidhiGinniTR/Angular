package com_pkg_OWM.Workflow_Browser.DynamicSerial;

import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import com_helper_Reporting.ExtentManager;
import com_data_Resources.Environment.BrowserInvoke;


public class FWF_Tasks_Test extends BrowserInvoke {
	ExtentTest test;

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
		//--------Login--------------------------------
		//--------Launch WorkFlow Manager--------------
		//-------Navigate to Respective Tab------------
		//-------Search for the Required Workflow------
		//-------DoubleClick on the Workflow ~ FolderWorkFows---
		//-------Click on Tasks Tab--------------------
		//------Actions Menu---------------------------
	}

}
