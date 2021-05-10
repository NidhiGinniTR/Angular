package com_obj_ObjectRepository.LS1;

import java.io.File;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork2;

public class Entity_Manager_Transaction_Browser extends ExtentManager {
	
	WebDriver driver;
	Properties template;

	
	FrameWork2 fm = new FrameWork2(driver);
	public Entity_Manager_Transaction_Browser(WebDriver driver, Properties data2, Properties propSerialData) {
		this.driver = driver;
		this.template = data2;
	}
	/************Navigate to transaction browser tab***************/
	
	By transaction_browser = By.xpath("//table[@id='TabStrip1_2']");
	
	
	/****************Add New**********************************************/
	By transaction_browser_FromEntityName = By.xpath("//input[@id='fromentity1_Input']");
	
	By transaction_browser_ToEntityNameOne = By.xpath("//input[@id='toentity_00001_Input']");
	By transaction_browser_DateOne = By.xpath("//input[@id='trandate_00001']");
	By transaction_browser_StreamOne = By.xpath("//select[@id='streamid_00001']");
	By transaction_browser_AmountOne = By.xpath("//input[@id='payment_00001']");
	
	By transaction_browser_ToEntityNameTwo = By.xpath("//input[@id='toentity_00002_Input']");
	By transaction_browser_DateTwo = By.xpath("//input[@id='trandate_00002']");
	By transaction_browser_StreamTwo = By.xpath("//select[@id='streamid_00002']");
	By transaction_browser_AmountTwo = By.xpath("//input[@id='payment_00002']");
	
	By transaction_browser_ToEntityNameThree = By.xpath("//input[@id='toentity_00003_Input']");
	By transaction_browser_DateThree = By.xpath("//input[@id='trandate_00003']");
	By transaction_browser_StreamThree = By.xpath("//select[@id='streamid_00003']");
	By transaction_browser_AmountThree = By.xpath("//input[@id='payment_00003']");
	
	By transaction_browser_ToEntityNameFour = By.xpath("//input[@id='toentity_00004_Input']");
	By transaction_browser_DateFour = By.xpath("//input[@id='trandate_00004']");
	By transaction_browser_StreamFour = By.xpath("//select[@id='streamid_00004']");
	By transaction_browser_AmountFour = By.xpath("//input[@id='payment_00004']");
	
	/****************Transactions Edit**********************************************/
	
	
	By transaction_browser_ToEntityNameOneEdit = By.xpath("//input[@id='toentity_16_Input']");
	By transaction_browser_DateOneEdit = By.xpath("//input[@id='trandate_16']");
	By transaction_browser_StreamOneEdit = By.xpath("//select[@id='streamid_16']");
	By transaction_browser_AmountOneEdit = By.xpath("//input[@id='payment_16']");
	
	By transaction_browser_ToEntityNameTwoEdit = By.xpath("//input[@id='toentity_17_Input']");
	By transaction_browser_DateTwoEdit = By.xpath("//input[@id='trandate_17']");
	By transaction_browser_StreamTwoEdit = By.xpath("//select[@id='streamid_17']");
	By transaction_browser_AmountTwoEdit = By.xpath("//input[@id='payment_17']");
	
	By transaction_browser_ToEntityNameThreeEdit = By.xpath("//input[@id='toentity_18_Input']");
	By transaction_browser_DateThreeEdit = By.xpath("//input[@id='trandate_18']");
	By transaction_browser_StreamThreeEdit = By.xpath("//select[@id='streamid_18']");
	By transaction_browser_AmountThreeEdit = By.xpath("//input[@id='payment_18']");
	
	By transaction_browser_ToEntityNameFourEdit = By.xpath("//input[@id='toentity_19_Input']");
	By transaction_browser_DateFourEdit = By.xpath("//input[@id='trandate_19']");
	By transaction_browser_StreamFourEdit = By.xpath("//select[@id='streamid_19']");
	By transaction_browser_AmountFourEdit = By.xpath("//input[@id='payment_19']");
	
	By transaction_browser_save = By.xpath("//img[@id='btnSave']");
	By transaction_browser_close = By.xpath("//img[@id='btnClose']");
	
	/********************Search Transactions*****************************/
	
	By transaction_FromEntityName = By.xpath("//input[@id='SearchControl1_Input']");
	By transaction_FromEntityID = By.xpath("//input[@id='SearchControl5_Input']");
	By transaction_ToEntityName = By.xpath("//input[@id='SearchControl2_Input']");
	By transaction_ToEntityNameID = By.xpath("//input[@id='SearchControl6_Input']");
	By transaction_DateRangeFrom = By.xpath("//input[@id='SearchControl3']");
	By transaction_DateRangeTo = By.xpath("//input[@id='SearchControl4']");
	By transaction_Search = By.xpath("//img[@id='imgbtnSearch']");
	By transaction_Close = By.xpath("//img[@id='img1']");
	
	/*****************Delete Transaction**********************************/
	
	By purge = By.xpath("//input[@id='btnPurge']");
	By cancel = By.xpath("//input[@id='btnCancel']");
	
	/// screen shot
	public static void screenShot(WebDriver webdriver,String fileWithPath) throws Exception{

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
                File DestFile=new File(fileWithPath);
                FileUtils.copyFile(SrcFile, DestFile);

    }
	
	/************************************************************************/
	/** This function is used to navigate to the Transaction browser tab    */
	/************************************************************************/
	
	public void navigate_ToTransectionBrowser() throws InterruptedException {
		childTest = test.createNode(
				"Description: Navigating to Transaction Tab " + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		String title = driver.getTitle();
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("maincontent");
			driver.switchTo().frame("app_iFrame");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebButton(driver, transaction_browser, "People_Browser");
			String pplbrowser = driver.findElement(By.xpath("//div[@id='divheader']")).getText();
			if(pplbrowser.equalsIgnoreCase("Transactions")) {
				childTest.pass("Navigated to the Transactions browser tab");
			}
			else {
				childTest.fail("Transactions browser not launched");
			}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
	
	
	/************************************************************************/
	/** This function is used to add new transaction						 */
	/**
	 * @throws Exception **********************************************************************/
	
	public void add_Transaction() throws Exception {
		childTest = test.createNode(
				"Description: Giving all values to Add Transaction " + "<br>" + "<<Screen Name: Entity Manager >></br>");
		try {
		
		fm.fnWebEdit(driver, transaction_browser_FromEntityName, template.getProperty("From_EntityName"), "From_EntityName");
		
		fm.fnWebEdit(driver, transaction_browser_ToEntityNameOne, template.getProperty("ToEntityName_One"), "ToEntityName_One");
		fm.fnWebEdit(driver, transaction_browser_DateOne, template.getProperty("Date_One"), "Date_One");
		fm.fnWebList(driver, transaction_browser_StreamOne, template.getProperty("Stream_One"), "Stream_One");
		fm.fnWebEdit(driver, transaction_browser_AmountOne, template.getProperty("Amount_One"), "Amount_One");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, transaction_browser_ToEntityNameTwo, template.getProperty("ToEntityName_Two"), "ToEntityName_Two");
		fm.fnWebEdit(driver, transaction_browser_DateTwo, template.getProperty("Date_Two"), "Date_Two");
		fm.fnWebList(driver, transaction_browser_StreamTwo, template.getProperty("Stream_Two"), "Stream_Two");
		fm.fnWebEdit(driver, transaction_browser_AmountTwo, template.getProperty("Amount_Two"), "Amount_Two");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, transaction_browser_ToEntityNameThree, template.getProperty("ToEntityName_Three"), "ToEntityName_Three");
		fm.fnWebEdit(driver, transaction_browser_DateThree, template.getProperty("Date_Three"), "Date_Three");
		fm.fnWebList(driver, transaction_browser_StreamThree, template.getProperty("Stream_Three"), "Stream_Three");
		fm.fnWebEdit(driver, transaction_browser_AmountThree, template.getProperty("Amount_Three"), "Amount_Three");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEdit(driver, transaction_browser_ToEntityNameFour, template.getProperty("ToEntityName_Four"), "ToEntityName_Four");
		fm.fnWebEdit(driver, transaction_browser_DateFour, template.getProperty("Date_Four"), "Date_Four");
		fm.fnWebList(driver, transaction_browser_StreamFour, template.getProperty("Stream_Four"), "Stream_Four");
		fm.fnWebEdit(driver, transaction_browser_AmountFour, template.getProperty("Amount_Four"), "Amount_Four");
		
		Thread.sleep(2000);
		fm.fnWebButton(driver, transaction_browser_save, "Save");
		String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		fm.fnWebButton(driver, transaction_browser_close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
			screenShot(driver, "C:\\Users\\X022129\\Pictures\\Screenshots\\Scnshot\\TransactionAddfail.jpeg");
		
		
		}
}
	
	/************************************************************************/
	/** This function is used to Edit the transaction						 */
	/************************************************************************/
	
	public void editTransaction() throws InterruptedException {
		childTest = test.createNode(
				"Description: Edit the Transaction" + "<br>" + "<<Screen Name: Entity Manager >></br>");
		try {
			fm.fnWebEdit(driver, transaction_browser_ToEntityNameTwoEdit, template.getProperty("ToEntityName_TwoEdit"), "ToEntityName_TwoEdit");
			fm.fnWebEdit(driver, transaction_browser_DateTwoEdit, template.getProperty("Date_TwoEdit"), "Date_TwoEdit");
			fm.fnWebList(driver, transaction_browser_StreamTwoEdit, template.getProperty("Stream_TwoEdit"), "Stream_TwoEdit");
			fm.fnWebEdit(driver, transaction_browser_AmountTwoEdit, template.getProperty("Amount_TwoEdit"), "Amount_TwoEdit");
			
			Thread.sleep(2000);
			fm.fnWebButton(driver, transaction_browser_save, "Save");
			String errormsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if(errormsg.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Entered data was saved successfully");
			}
			try {
				WebElement save_changes = driver.findElement(By.xpath("//button[@id='dialog-button-close']"));
				if(save_changes.isDisplayed()) {
					save_changes.click();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					fm.fnWebButton(driver, transaction_browser_close, "Close");
				}
				}
				catch(Exception e) {
					fm.fnWebButton(driver, transaction_browser_close, "Close");
				}
				
			}
			catch(Exception e) {
				childTest.fail(e);
		}
		
}
	
	/************************************************************************/
	/** This function is used to View and Verify the transaction			 */
	/************************************************************************/
	
	public void view_Transactions() throws InterruptedException {
		childTest = test.createNode(
				"Description: View and Verify  " + "<br>" + "<<Screen Name: Entity Manager>></br>");
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, transaction_browser_FromEntityName, template.getProperty("From_EntityName"), "From_EntityName");
		
		fm.fnWebEditCompare(driver, transaction_browser_ToEntityNameOneEdit, template.getProperty("ToEntityName_One"), "ToEntityName_One");
		fm.fnWebEditCompare(driver, transaction_browser_DateOneEdit, template.getProperty("Date_One"), "Date_One");
		fm.fnWebListCompare(driver, transaction_browser_StreamOneEdit, template.getProperty("Stream_One"), "Stream_One");
		fm.fnWebEditCompare(driver, transaction_browser_AmountOneEdit, template.getProperty("Amount_One"), "Amount_One");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, transaction_browser_ToEntityNameTwoEdit, template.getProperty("ToEntityName_TwoEdit"), "ToEntityName_TwoEdit");
		fm.fnWebEditCompare(driver, transaction_browser_DateTwoEdit, template.getProperty("Date_TwoEdit"), "Date_TwoEdit");
		fm.fnWebListCompare(driver, transaction_browser_StreamTwoEdit, template.getProperty("Stream_TwoEdit"), "Stream_TwoEdit");
		fm.fnWebEditCompare(driver, transaction_browser_AmountTwoEdit, template.getProperty("Amount_TwoEdit"), "Amount_TwoEdit");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, transaction_browser_ToEntityNameThreeEdit, template.getProperty("ToEntityName_Three"), "ToEntityName_Three");
		fm.fnWebEditCompare(driver, transaction_browser_DateThreeEdit, template.getProperty("Date_Three"), "Date_Three");
		fm.fnWebListCompare(driver, transaction_browser_StreamThreeEdit, template.getProperty("Stream_Three"), "Stream_Three");
		fm.fnWebEditCompare(driver, transaction_browser_AmountThreeEdit, template.getProperty("Amount_Three"), "Amount_Three");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, transaction_browser_ToEntityNameFourEdit, template.getProperty("ToEntityName_Four"), "ToEntityName_Four");
		fm.fnWebEditCompare(driver, transaction_browser_DateFourEdit, template.getProperty("Date_Four"), "Date_Four");
		fm.fnWebListCompare(driver, transaction_browser_StreamFourEdit, template.getProperty("Stream_Four"), "Stream_Four");
		fm.fnWebEditCompare(driver, transaction_browser_AmountFourEdit, template.getProperty("Amount_Four"), "Amount_Four");
		Thread.sleep(2000);
		
		fm.fnWebButton(driver, transaction_browser_close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
	/************************************************************************/
	/** This function is used to Search the transaction			 */
	/************************************************************************/
	
	public void search_Transaction() throws InterruptedException {
		childTest = test.createNode(
				"Description: Search for Transaction" + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		
		try {
		
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.switchTo().frame("gridFrame");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(By.xpath("//img[@id='imgSplitter']")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebEditCompare(driver, transaction_FromEntityName, template.getProperty("Search_fromEntityName"), "Search_fromEntityName");
			fm.fnWebEditCompare(driver, transaction_FromEntityID, template.getProperty("Search_FromEntityID"), "Search_FromEntityID");
			
			fm.fnWebButton(driver, transaction_Search, "Search");
			WebElement transaction = driver.findElement(By.xpath(("//tr[@id='gridTransactions_grdEntityManager_row_0']")));
			if(transaction.isDisplayed()) {
				childTest.pass(" Transaction Search Passed");
				transaction.click();
			}
			else {
				childTest.fail("Transaction Search Failed");
			}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
		
	}
	
	/************************************************************************/
	/** This function is used to Delete the transaction			 */
	/************************************************************************/
	
	public void deleteEntity(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Delete Entity" + "<br>" + "<< Screen Name: LS1 >></br>");
		try {
		
		if (menuitem.equals("Delete Entity")) {
			fm.fnWebButton(driver, purge, "Delete");
		}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
	}
	
	
	
}
