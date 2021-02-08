package com_pkg_OWM.Workflow_Browser.Serial;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.loginPage;
import com_obj_ObjectRepository.OWM.OWM;


public class OWM_Test_WorkFlowBrowserActions extends BrowserInvoke {
	
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
	public void NewFolderCreation() throws InterruptedException {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver,propSerialData);
		//OWM owm = new OWM(driver,propSerialData);
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		lp.LaunchApplication("WorkFlow Manager");
		Thread.sleep(5000);
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step-3:-----Navigate to Respective Tab------------------------//
		owm.fnNavigateTab("WorkFlow Browser");
		
		// Step-4:---------------Create a New Folder----------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("New Folder", "");
		Thread.sleep(2000);
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"New Folder");
		owm.fnNewFolderCreation();
		
		// Step-5:---------Search for the Required Workflow---------------//
		//new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		owm.fnWorkflowBrowserSearch();
		Thread.sleep(2000);
		
		// Step-6:-----Select the workflow created-------------------//
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-7------New WorkFlow------------------------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("New WorkFlow", "");
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"New WorkFlow");
		owm.fnOWMNewWorkFlow();
		Thread.sleep(3000);
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step-8:-----Select the workflow---//
		driver.switchTo().frame("bottom");// Switch to respective window
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-9------Delete Newly Created workflow-------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"Do you want to delete these workflows?");
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		// Step-10:-----Select the workflow---//
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-11-----------------Lock WorkFlow--------------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Lock WorkFlow(s)", "");
		Thread.sleep(1000);
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"You are about to lock");
		driver.switchTo().parentFrame();
		// Step-12:-----Unlock Workflow---//
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Unlock WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"You are about to unlock");

		// Step-13-------------Verify WorkFlow Properties----------------//
		// Step-14:-----Select the workflow---//
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		// Step-17--------WorkFlow History-------------------------------//
		// Step-18:-----Select the workflow---//
		// Step-19--------Export-------------------------------//
		// Step-20:---Customize View-------------------------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Customize View", "");
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"Grid Columns");
		String[] array = new String[] { "Year", "Period", "Tax Type", "Status", "Entity Name", "Entity ID",
		"Due Date"};
		owm.fnOWMCustomizeView(array);
		Thread.sleep(3000);
		new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		// Step8:-----Select the workflow---//
		driver.switchTo().frame("bottom");// Switch to respective window
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-21:----Save Preferences-----------------------------------//
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Save Preferences", "");
		owm.fnOWMSavePreferences("Save Preferences");
		// Step-22:---Save Preferences for all---------------------------//
		owm.Actions();
		lp.fnOWMActionsMenu("Save Preferences for All", "");
		owm.fnOWMSavePreferences("Save Preferences for All");
		driver.switchTo().parentFrame();
		//-----------------Delete the created WorkFlow----------------//
		driver.switchTo().frame("bottom");// Switch to respective window
		driver.switchTo().frame("content");
		driver.switchTo().frame("bottomFrame");
		driver.switchTo().frame("viewIFrame");
		FrameWork.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		owm.Actions();
		driver.switchTo().frame("viewIFrame");
		lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"Do you want to delete these workflows?");
		Thread.sleep(1000);
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
