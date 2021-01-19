package com_pkg_OWM.Workflow_Browser.Serial;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
import com_obj_ObjectRepository.FolderWorkFlows.NavigationTabs;

public class FWF_Documents_Test extends BrowserInvoke{
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
	public void Documents() throws InterruptedException, AWTException {
		//Step-1:-----Login---------------------------------------------//
			FunctionLibrary.fnLogin(driver, propEnv);
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//Step-2:-----Launch WorkFlow Manager---------------------------//
			FunctionLibrary.fnLaunchApplication(driver, "WorkFlow Manager");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//Step-3:-----Navigate to Respective Tab------------------------//
			new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(2));
			FunctionLibrary.fnNavigateTab(driver, "WorkFlow Browser");
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		//Step-4:-----Search for the Required Workflow------------------//
			FunctionLibrary.fnWorkflowBrowserSearch(driver, propSerialData);
			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
		//Step-5:-----Double click on the workflow to Folder Workflows---//
			driver.switchTo().frame("viewIFrame");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id='grdWFfolders_dom']/table/tbody/tr[3]/td"))).doubleClick().build().perform();
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			//Thread.sleep(10000);
			//driver.switchTo().parentFrame();
		//Step-6:----Navigate to Document Tab----------------------------//
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
			Thread.sleep(3000);
			FunctionLibrary.fnFWFSwitchingTab(driver,"Documents");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.switchTo().frame("tabIFrame");
		//Step-7:----Actions---------------------------------------------//
				//---Add Document~New Document--------------------------//
			NavigationTabs nav = new NavigationTabs(driver);
			List<WebElement> rows = driver.findElements(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR"));
			if(rows.size()>2) {
				Robot robot = new Robot();
		        robot.keyPress(KeyEvent.VK_CONTROL);
		        for(int i=1;i<=rows.size();i++) {
		        	action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR["+i+"]"))).click().build().perform();
		        }
				robot.keyRelease(KeyEvent.VK_CONTROL);
				nav.Actions();
		        FunctionLibrary.fnOWMActionsMenu(driver,"Other Actions","Delete Document(s)");
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        driver.switchTo().alert().accept();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		        driver.switchTo().alert().accept();
		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			}
			nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Add Document","New Document");
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Add document");
	        new WebDriverWait(driver,50).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
	        //driver.switchTo().frame("frame1");
	        FunctionLibrary.fnFWFAddDocument(driver,propSerialData);
	        //new WebDriverWait(driver,50).until(ExpectedConditions.numberOfWindowsToBe(4));
	        
		//Step-8:----Email Documents-------------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Folder WorkFlows");
	        new WebDriverWait(driver,50).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
	        //driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Email Document(s)","");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Email Document(s)");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        FunctionLibrary.fwf_fnEmailDocument(driver, propSerialData);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		//Step-9:-----Change Status--------------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Change Status","In Progress");
	        Thread.sleep(500);
	        String text = driver.switchTo().alert().getText();
			if (text.contains("Successfully updated 1 document(s).")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().alert().accept();	
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	    //Step--:----Other Actions-----------------------------------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Other Actions","Copy Document(s)");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //-------Copy Documents--------//
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Copy Document(s)");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        FunctionLibrary.fwf_fnCopyDocuments(driver, propSerialData);
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //-------Copy Documents to ClipBoard---//
	        //-------Move Document--------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Other Actions","Move Document");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Move Document");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        FunctionLibrary.fwf_fnMoveDocument(driver, propSerialData);
	        //-------Export Document-------//
	        //-------Delete Document-------//
		//Step-10:----Review Documents-----------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Review Document(s)","Archive");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        String text1 = driver.switchTo().alert().getText();
			if (text1.contains("The selected document(s) have been successfully Archived.")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().alert().accept();	
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        //-------UnArchive---------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Review Document(s)","Unarchive");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        String text2 = driver.switchTo().alert().getText();
			if (text2.contains("Successfully removed the Archived Status for the selected document(s).")) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.switchTo().alert().accept();	
			}
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
		//Step-11:----Associate Documents to workflow--------------------//
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Associate Document(s) to WorkFlow","");
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        String text3 = driver.switchTo().alert().getText();
			if (text3.contains("Selected document(s) have been associated to the")) {
				Thread.sleep(500);
				driver.switchTo().alert().accept();	
			}
	        
		//Step-12:----Document Properties--------------------------------//
	       /* action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
			Thread.sleep(300);
	        FunctionLibrary.fnOWMActionsMenu(driver,"Document Properties","");
	        Thread.sleep(8000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Document Properties");
	        Thread.sleep(2000);
	        FunctionLibrary.fwf_fnDocumentProperties(driver, propSerialData);
	        Thread.sleep(4000);*/
	        
		/*//Step-13:---Document History-----------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Document History","");
	        Thread.sleep(3000);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Document History");*/
	        
		//Step-14:---Customize View-------------------------------------//
	        //FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        //driver.switchTo().frame("tabIFrame");
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Customize View","");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        String[] array= new String[] {"Description","File Section","Document Type","Document Date","Status","Assigned To","Due Date"};
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Customize View");
	        FunctionLibrary.fnOWMCustomizeView(driver,array);
	        
		//Step-15:----Save Preferences-----------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences","");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Save Preferences");
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences");
	        
		//Step-16:---Save Preferences for all---------------------------//
	        //FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        //driver.switchTo().frame("tabIFrame");
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Save Preferences for All","");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Save Preferences");
	        FunctionLibrary.fnOWMSavePreferences(driver,"Save Preferences for All");
	        
		//Step-17:---Saved Search---------------------------------------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Saved Search","");
	        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	        FunctionLibrary.fnSwitchtoWindow(driver,4, "Documents Search");
	        FunctionLibrary.fwf_fnSavedSearch(driver, propSerialData);
	        
	        //Delete Document uploaded------//
	        FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
	        driver.switchTo().frame("tabIFrame");
	        action.moveToElement(driver.findElement(By.xpath("//DIV[@id=\"grdDocumentHitList_dom\"]/TABLE[1]/TBODY[1]/TR[2]"))).click().build().perform();
	        nav.Actions();
	        FunctionLibrary.fnOWMActionsMenu(driver,"Other Actions","Delete Document(s)");
	    //Step-18:---Log Off---------------------------------------------//
			
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
