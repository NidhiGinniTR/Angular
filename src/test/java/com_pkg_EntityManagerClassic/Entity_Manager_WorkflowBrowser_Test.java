package com_pkg_EntityManagerClassic;

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
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com_data_Resources.Environment.BrowserInvoke;
import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;
import com_obj_ObjectRepository.LS1.EntityUnitBrowser;
import com_obj_ObjectRepository.LS1.LS1;

public class Entity_Manager_WorkflowBrowser_Test extends BrowserInvoke {
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
	public void EUB_WorkflowBrowser() throws InterruptedException {
		LS1 lp = new LS1(driver, propEnv, propSerialData);
		EntityUnitBrowser Eub = new EntityUnitBrowser(driver, propEnv, propSerialData);
		FrameWork fm = new FrameWork();
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(80))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		
		// Step-1:-----Login---------------------------------------------//
		lp.fnLogin();

		// Step-2:-----Launch Entity Manager---------------------------//
		lp.LaunchApplication("Entity Manager Classic");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		
		// Step-3:----------Workflow Browser---------------------------//
		//driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		Eub.fnEM_SwitchTabs("Workflow Browser");
		
		// Step-4:---------Verify Search Fields---------------------------//
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		//driver.switchTo().frame("gridFrame");
		Thread.sleep(500);
		//String[] array = new String[] { "W/F Template:","Period:","Year:","Jurisdiction:", "Entity Name:", "Entity ID:", "Tax Type:",
				//"WorkFlow Association:","WorkFlow Type:" };
		//Eub.fnVerifySearchElements(array);
		
		// Step-5:------------Verify Action Menu items---------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnActionsMenuEnabled();
		Eub.fnActionsMenuDisabled();
		
		//-----------------------------------------------------------------------
		Eub.fnEM_SearchWorkflow();
		List<WebElement> rows = driver
				.findElements(By.xpath("//DIV[@id='gridWorkflowFolders_grdEntityManager_dom']/TABLE[1]/TBODY[1]/TR"));
		if (rows.size() >= 2) {
			fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
			fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
			Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
			Eub.fnDeleteWorkflow();
			lp.fnSwitchtoWindow(2,"Entity Manager");
			driver.switchTo().defaultContent();
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
			//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		}
		Thread.sleep(1000);
		
		//Step-6:---------------------New Folder------------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("New Folder", "");
		
		//Step-7--------------------------New Folder-------------------------------
		Thread.sleep(1000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "New Folder");
		Eub.fnEM_NewFolder();
		
		//Step-8---------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
	
		//Step-9------------------New Workflow--------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("New WorkFlow", "");
		
		//Step-10--------------------New Workflow------------------------------------
		Thread.sleep(1000);
		lp.fnSwitchtoWindow(3, "New WorkFlow");
		Eub.fnEM_NewWorkflow();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Step-11---------------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-12-----------------Delete Workflow------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		Eub.fnDeleteWorkflow();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Step-13------------------Search Workflow---------------------------
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
	
		//Step-14------------------------Workflow Properties------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("WorkFlow Properties", "");
		Thread.sleep(3500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		
		//Step-15----------------------Workflow Properties-----------------------------
		lp.fnSwitchtoWindow(3, "WorkFlow Properties");
		Eub.fnWorkflowProperties();
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Step-16------------------------Switch Frame--------------------------------
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		//Eub.fnEM_SearchDocument();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-17----------------------Click Actions------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		//Eub.fnOWMActionsMenu("Reset Checklist", "");
		//Eub.fnResetChecklist();
		//Thread.sleep(2500);
		
		//Step-18:----------------Customize View-----------------------------------//
		//fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu( "Customize View", "");
		Thread.sleep(2500);
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		lp.fnSwitchtoWindow(3, "Customize View");
		String[] array3 = new String[] { "Entity Name", "Entity ID", "Tax Type", "Year", "Period","Jurisdiction", "Description" };
		Eub.fnCustomizeView(array3);
		
		// Step-19:----------------Save Preferences-----------------------------------//
		/*lp.fnSwitchtoWindow(1, "LS1");
		driver.switchTo().defaultContent();
		driver.switchTo().frame("maincontent");
		driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
		driver.switchTo().frame("gridFrame");
		//lp.fnSwitchtoWindow(1, "LS1");
		Thread.sleep(1500);
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences", "");
		Eub.fnSavePreferences("Save Preferences");

		// Step-20:----------------Save Preferences for All-----------------------------------//
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Save Preferences for All", "");
		Eub.fnSavePreferences("Save Preferences for All");*/
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		
		//Step-21------------------------Search Workflow--------------------------------------
		lp.fnSwitchtoWindow(2,"Entity Manager");
		driver.switchTo().defaultContent();
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("maincontent"));
		//wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad"));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("gridFrame"));
		Eub.fnEM_SearchWorkflow();
		fm.fnWebTable(driver, driver.findElement(By.xpath("//tr[@id='gridWorkflowFolders_grdEntityManager_row_0']")), "Click");
		
		//Step-22------------------Delete Workflow-------------------------------------
		fm.fnWebButton(driver, By.xpath("//img[@id='Img3']"), "Actions");
		Eub.fnOWMActionsMenu("Delete WorkFlow(s)", "");
		Eub.fnDeleteWorkflow();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		lp.fnSwitchtoWindow(2,"Entity Manager");
		
		// Step--------LogOFF-------------------------------//
		Eub.fnLogOff();
	}
	
	@AfterClass
	void closeBrowser() throws InterruptedException {
		// FunctionLibrary.fnLogOff(driver);
		//driver.quit();
	}

	@AfterSuite
	public void aftersuite() {
		ExtentManager.endReport();
	}
}
