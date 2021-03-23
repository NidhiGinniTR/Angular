package com_pkg_OWM.Workflow_Browser.Parallel;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_lib_FunctionLibrary.loginPage;
import com_obj_ObjectRepository.OWM.OWM;

public class OWM_Actions_Test extends BrowserInvoke {
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
	public void WorkFlowManager_Actions() throws InterruptedException {
		loginPage lp = new loginPage(driver,propEnv,propSerialData);
		//OWM owm = new com_obj_ObjectRepository.OWM.OWM(driver,propSerialData);
		FrameWork fm= new FrameWork();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		OWM owm = new OWM(driver,propSerialData);
		
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();
		
		//Step-2:-----Launch WorkFlow Manager---------------------------//
		lp.LaunchApplication("WorkFlow Manager");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step-3:-----Navigate to Respective Tab------------------------//
		owm.fnNavigateTab("WorkFlow Browser");
		//driver.switchTo().parentFrame();
		
		//----------------------------------------------------------------------------
		/*owm.fnWorkflowBrowserSearch();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		List<WebElement> rows = driver.findElements(By.xpath("//DIV[@id='grdWFfolders_dom']/TABLE[1]/TBODY[1]/TR"));
		System.out.println(rows.size());
		if (rows.size() > 3) {
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
			fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
			driver.switchTo().parentFrame();
			owm.Actions();
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
			lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
			Thread.sleep(2000);
			owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"Do you want to delete these workflows?");
			driver.switchTo().parentFrame();
		}*/
		
		// Step-4:---------------Create a New Folder----------------------//
		owm.Actions();
		//driver.switchTo().frame("viewIFrame");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("New Folder", "");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"New Folder");
		owm.fnNewFolderCreation();
		
		// Step-5:---------Search for the Required Workflow---------------//
		//new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		owm.fnWorkflowBrowserSearch();
		Thread.sleep(2000);
		
		// Step-6:-----Select the workflow created-------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-7------New WorkFlow------------------------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("New WorkFlow", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"New WorkFlow");
		owm.fnOWMNewWorkFlow();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step-8:-----Select the workflow---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottomFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-9------Delete Newly Created workflow-------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"Do you want to delete these workflows?");
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		
		// Step-10:-----Select the workflow---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-11-----------------Lock WorkFlow--------------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Lock WorkFlow(s)", "");
		Thread.sleep(1000);
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"You are about to lock");
		driver.switchTo().parentFrame();
		
		// Step-12:-----Unlock Workflow---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Unlock WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"You are about to unlock");
		Thread.sleep(5000);
		driver.switchTo().parentFrame();
		
		// Step-10:-----Select the workflow---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-11-----------------Lock WorkFlow--------------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("WorkFlow Properties", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"WorkFlow Properties");
		owm.fnWorkflowProperties();
		
		/*wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step-13-------------Verify WorkFlow Properties----------------//
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("WorkFlow Properties", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"WorkFlow Properties");
		owm.fnWorkflowProperties();*/
		//driver.switchTo().parentFrame();
		
		// Step-14:-----Select the workflow---//
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottomFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		Thread.sleep(1000);
		
		// Step-17--------WorkFlow History-------------------------------//
		// Step-18:-----Select the workflow---//
		// Step-19--------Export-------------------------------//
		
		// Step-20:---Customize View-------------------------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Customize View", "");
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3,"Grid Columns");
		String[] array = new String[] { "Year", "Period", "Tax Type", "Status", "Entity Name", "Entity ID","Due Date"};
		owm.fnOWMCustomizeView(array);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"WorkFlow Manager");
		
		// Step8:-----Select the workflow---//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottomFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		
		// Step-21:----Save Preferences-----------------------------------//
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Save Preferences", "");
		owm.fnOWMSavePreferences("Save Preferences");
		//driver.switchTo().parentFrame();
		
		// Step-22:---Save Preferences for all---------------------------//
		//owm.Actions();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		//lp.fnOWMActionsMenu("Save Preferences for All", "");
		//lp.fnSwitchtoWindow(3,"Save Preferences");
		//owm.fnOWMSavePreferences("Save Preferences for All");
		/*driver.switchTo().parentFrame();
		
		//-----------------Delete the created WorkFlow----------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottom"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("content"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("bottomFrame"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		fm.fnWebTable(driver, driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td")),"Click");
		driver.switchTo().parentFrame();
		owm.Actions();
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("viewIFrame"));
		lp.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		owm.fnWorkflowAlert(driver.switchTo().alert().getText(),"Do you want to delete these workflows?");
		Thread.sleep(1000);*/
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
