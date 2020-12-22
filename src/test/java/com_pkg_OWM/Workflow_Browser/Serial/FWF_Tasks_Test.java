package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;
import java.util.Set;
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

public class FWF_Tasks_Test extends BrowserInvoke {

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
			
		//Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			Thread.sleep(10000);
			
		//Step-6:-----Click on Tasks Tab and Actions--------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(3));
			driver.switchTo().parentFrame();
			Set<String> ids = driver.getWindowHandles();
	        java.util.Iterator<String> it = ids.iterator();
	        String parentid = it.next();
	        String childid = it.next();
	        String childid1 = it.next();
	        driver.switchTo().window(childid1);
	        Thread.sleep(8000);
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id='grdTasks_dom']/table/tbody/tr[2]"))).click().build().perform();
	        Thread.sleep(300);
	        driver.findElement(By.xpath("//td[@id='btnActionsMenu']")).click();
			Thread.sleep(300);
		//Step-7:-----Change Status-------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Change Status","Not Started");
		//Step-8:-----Route Task----------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Route Task","");
		//Step-9:-----Task Properties-----------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Task Properties","");
		//Step-10:----Task History--------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Task History","");
		//Step-11:----Reset Checklist-----------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Reset Checklist","");
		//Step-12:----Add Documents-------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Add Document","");
		//Step-13:----View Documents------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"View Document(s)","");
		//Step-14:----Export--------------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Export","");
		//Step-15:----Customize View-------------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Customize View","");
		//Step-16:----Save Preferences----------------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences","");
		//Step-17:----Save Preferences for All--------------------------//
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences for All","");
		//Step-18:----LogOff-------------------------------------------//
		
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
