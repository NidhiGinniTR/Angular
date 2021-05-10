package com_obj_ObjectRepository.LS1;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork2;

public class Entity_Manager_Charting_BrowserClassic extends ExtentManager{
	WebDriver driver;
	Properties template;

	
	FrameWork2 fm = new FrameWork2(driver);
	public Entity_Manager_Charting_BrowserClassic(WebDriver driver, Properties data2, Properties propSerialData) {
		this.driver = driver;
		this.template = data2;
	}
	/************Navigate to charting browser tab***************/
	
	By charting_browser = By.xpath("//table[@id='TabStrip1_3']");
	
	/************Navigate to Actions and add new ***************/
	
	By charting_browser_Actions = By.xpath("//img[@id='btnActionsMenu']");
	
	/*****************Add New Chart Details******************/
	
	By charting_browser_ChartName = By.xpath("//input[@id='chartname']");
	By charting_browser_Year = By.xpath("//input[@id='chartyear']");
	By charting_browser_ChartType = By.xpath("//select[@id='charttype']");
	By charting_browser_ChartDate = By.xpath("//input[@id='asofchartdate']");
	By charting_browser_OwnerType = By.xpath("//select[@id='ownertype']");
	By charting_browser_Description = By.xpath("//input[@id='description']");
	By charting_browser_ChartingTool = By.xpath("//select[@id='chartingtool']");
	By charting_browser_AttributeOne = By.xpath("//select[@id='chartattribute1']");
	By charting_browser_AttributeTwo = By.xpath("//select[@id='chartattribute2']");
	By charting_browser_AttributeThree = By.xpath("//select[@id='chartattribute3']");
	By charting_browser_Notes = By.xpath("//textarea[@id='notes']");
	By charting_browser_Next = By.xpath("//img[@id='btnSave']");
	By charting_browser_Close = By.xpath("//img[@id='btnClose']");
	By charting_browser_GroupCode = By.xpath("//input[@id='srchCtrl2_Input']");
	By charting_browser_CountryOfBusiness = By.xpath("//input[@id='srchCtrl4_Input']");
	By charting_browser_INCOfBusiness = By.xpath("//input[@id='srchCtrl6_Input']");
	By charting_browser_Search = By.xpath("//img[@id='imgbtnSearch']");
	By charting_browser_Clear = By.xpath("//img[@id='ClearImage']");
	By charting_browser_CloseNext = By.xpath("//img[@id='Img5']");
	
	/********************Save All Preferences***************************/
	
	By save_pref = By.xpath("//button[@id='dialog-button-close']");
	By save_pref_All = By.xpath("//button[@id='dialog-button-action']");
	
	/*******************Copy Chart*************************************/
	
	By ChartNametoCopy = By.xpath("//input[@id='name']");
	By ChartTypeToCopy = By.xpath("//select[@id='charttype']");
	By SaveCopy = By.xpath("//img[@id='Img1']");
	By CloseCopy = By.xpath("//img[@id='btnClose']");
	
/********************Purge***************************/
	
	By purge = By.xpath("//input[@id='btnPurge']");
	By cancel = By.xpath("//input[@id='btnCancel']");
	
	/************************************************************************/
	/** This function is used to click and Navigate to Charting Browser		*/
	/************************************************************************/
	
	public void navigate_ToChartingBrowser() throws InterruptedException {
		childTest = test.createNode(
				"Description: Navigating to Charting Browser Tab " + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		String title = driver.getTitle();
		try {
//			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//			driver.switchTo().frame("maincontent");
//			driver.switchTo().frame("app_frame_a01b96d5-d9c7-455c-98a9-b084156123ad");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebButton(driver, charting_browser, "Charting_Browser");
			String pplbrowser = driver.findElement(By.xpath("//div[@id='divheader']")).getText();
			if(pplbrowser.equalsIgnoreCase("Charting Browser")) {
				childTest.pass("Navigated to the Charting Browser tab");
			}
			else {
				childTest.fail("Charting Browser not launched");
			}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}

	/************************************************************************/
	/** This function is used to click on actions button					 */
	/************************************************************************/
	
	public void actions() throws InterruptedException {
		childTest = test.createNode(
				"Description: Click on add new " + "<br>" + "<<Screen Name: ONESOURCE >></br>");
		try {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			fm.fnWebButton(driver, charting_browser_Actions, "Actions");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
	
	/************************************************************************/
	/** This function is used to click and navigate to actions elements		 */
	/************************************************************************/
	
	
	public static void fnOWMActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			// WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver.findElements(By.className("MenuItem"));
						for (int j = 0; j < submenuItems.size(); j++) {
							if (subItem.equals(submenuItems.get(j).getText())) {
								String submenuItem = submenuItems.get(j).getAttribute("id");
								driver.findElement(By.id(submenuItem)).click();
								childTest.log(Status.PASS, subItem + " is selected from  " + item);
								break;
							}
						}
					}
					childTest.log(Status.PASS, item + " is enabled and is selected from actions menu.");
					break;
				}
			}
		}
	}
	
	
	
	/************************************************************************/
	/** This function is used to click and navigate to actions elements		 */
	/************************************************************************/
	
	
	public  void fnOWMClassicActionsMenu( String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("Entity Manager")) {
			// WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			java.util.List<WebElement> menuitems = driver.findElements(By.className("MenuItem"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver.findElements(By.className("MenuItem"));
						for (int j = 0; j < submenuItems.size(); j++) {
							if (subItem.equals(submenuItems.get(j).getText())) {
								String submenuItem = submenuItems.get(j).getAttribute("id");
								driver.findElement(By.id(submenuItem)).click();
								childTest.log(Status.PASS, subItem + " is selected from  " + item);
								break;
							}
						}
					}
					childTest.log(Status.PASS, item + " is enabled and is selected from actions menu.");
					break;
				}
			}
		}
	}
	

	/************************************************************************/
	/** This function is used to verify Customize view						 */
	/************************************************************************/
	
	public void fnCustomizeView(String[] array) throws InterruptedException {
		childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: LS1 >></br>");
		if (driver.getTitle().equalsIgnoreCase("Customize View")) {
			java.util.List<WebElement> ColumnValues = driver.findElements(By.className("TreeNode"));
			for (int j = 0; j < array.length; j++) {
				for (int i = 0; i < ColumnValues.size(); i++) {
					if (array[j].equals(ColumnValues.get(i).getText())) {
						String menuitem = ColumnValues.get(i).getAttribute("id");
						//System.out.println(ColumnValues.get(i).getText());
						String required = menuitem.substring(0, menuitem.length() - 5);
						//System.out.println(required);
						if (driver.findElement(By.xpath("//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']")).isSelected()) {
							childTest.log(Status.PASS, array[j] + " is checked.");
							break;
						} else {
							driver.findElement(By.xpath("//*[@id='" + required + "']/tbody/tr[1]/td[2]/INPUT[@type='checkbox']")).click();
							childTest.log(Status.PASS, array[j] + " is checked.");
							break;
						}
					}
				}
			}
		} else {
			childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
		}
		Thread.sleep(1000);
		fm.fnWebButton(driver, By.xpath("//input[@id='btnSave']"), "Save");
	}

	
	

	/************************************************************************/
	/** This function is used to perform Save Preferences			 */
	/************************************************************************/
	
	public void fnSavePreferences(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: LS1 >></br>");

		if (menuitem.equals("Save Preferences for All")) {
			Thread.sleep(1500);
			//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("You are about to change preferences for all users. Please Confirm.")) {
				Thread.sleep(1000);
				fm.fnWebButton(driver, save_pref_All, "Yes");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("Saved successfully.")) {
					Thread.sleep(1000); 
					fm.fnWebButton(driver, save_pref, "Save");
				}else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		} else if (menuitem.equals("Save Preferences")) {
			//System.out.println(driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText());
			if (driver.findElement(By.xpath("//*[@id='dialog-label-container']")).getText().contains("Saved successfully.")) {
				Thread.sleep(500);
				fm.fnWebButton(driver, save_pref, "Save");
				childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
			} else {
				childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
			}
		}
	}
	
	/************************************************************************/
	/** This function is used to add new Chart Details					 */
	/**
	 * @throws Exception **********************************************************************/
	
	public void add_ChartDetails() throws Exception {
		childTest = test.createNode(
				"Description: Giving all values to Add Chart Details " + "<br>" + "<<Screen Name: Add Chart Page>></br>");
		try {
		fm.fnWebEdit(driver, charting_browser_ChartName, template.getProperty("Chart_Name"), "Chart_Name");
		fm.fnWebEdit(driver, charting_browser_Year, template.getProperty("Chart_Year"), "Chart_Year");
		fm.fnWebList(driver, charting_browser_ChartType, template.getProperty("Chart_Type"), "Chart_Type");
		fm.fnWebEdit(driver, charting_browser_ChartDate, template.getProperty("Chart_Date"), "Chart_Date");
		fm.fnWebEdit(driver, charting_browser_Description, template.getProperty("Chart_Description"), "Chart_Description");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebList(driver, charting_browser_OwnerType, template.getProperty("Chart_Owner"), "Chart_Owner");
		fm.fnWebList(driver, charting_browser_ChartingTool, template.getProperty("Chart_Tool"), "Chart_Tool");
		fm.fnWebList(driver, charting_browser_AttributeOne, template.getProperty("Chart_AttrOne"), "Chart_AttrOne");
		fm.fnWebList(driver, charting_browser_AttributeTwo, template.getProperty("Chart_AttrTwo"), "Chart_AttrTwo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebList(driver, charting_browser_AttributeThree, template.getProperty("Chart_AttrThree"), "Chart_AttrThree");
		fm.fnWebButton(driver, charting_browser_Next, "Save");
		String successmsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
		if(successmsg.equalsIgnoreCase("Your data was successfully saved")) {
			childTest.info("Entered data was saved successfully");
		}
		Thread.sleep(2000);
		fm.fnWebButton(driver, charting_browser_CloseNext, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		
		}
		
}
	

	/************************************************************************/
	/** This function is used to Edit the Chart details						 */
	/************************************************************************/
	
	public void editChartDetails() throws InterruptedException {
		childTest = test.createNode(
				"Description: Edit the Charting Details" + "<br>" + "<<Screen Name: Add Chart Page  >></br>");
		try {
			fm.fnWebEdit(driver, charting_browser_Description, template.getProperty("Chart_DescriptionEdit"), "Chart_DescriptionEdit");
			fm.fnWebEdit(driver, charting_browser_ChartDate, template.getProperty("Chart_DateEdit"), "Chart_DateEdit");
			
			Thread.sleep(2000);
			fm.fnWebButton(driver, charting_browser_Next, "Save");
			String successmsg = driver.findElement(By.xpath("//span[@id='spaErrorMessage']")).getText();
			if(successmsg.equalsIgnoreCase("Your data was successfully saved")) {
				childTest.info("Entered data was saved successfully");
			}

			}
			catch(Exception e) {
				childTest.fail(e);
		}
		fm.fnWebButton(driver, charting_browser_CloseNext, "Close");
		
}
	
	/************************************************************************/
	/** This function is used to View and Verify the transaction			 */
	/************************************************************************/
	
	public void view_Chart() throws InterruptedException {
		childTest = test.createNode(
				"Description: View and Verify  " + "<br>" + "<<Screen Name:Add Chart Page>></br>");
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebEditCompare(driver, charting_browser_ChartName, template.getProperty("Chart_Name"), "Chart_Name");
		fm.fnWebEditCompare(driver, charting_browser_Year, template.getProperty("Chart_Year"), "Chart_Year");
		fm.fnWebListCompare(driver, charting_browser_ChartType, template.getProperty("Chart_Type"), "Chart_Type");
		fm.fnWebEditCompare(driver, charting_browser_ChartDate, template.getProperty("Chart_DateEdit"), "Chart_DateEdit");
		fm.fnWebEditCompare(driver, charting_browser_Description, template.getProperty("Chart_DescriptionEdit"), "Chart_DescriptionEdit");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//fm.fnWebListCompare(driver, charting_browser_OwnerType, template.getProperty("Chart_OwnerEdit"), "Chart_OwnerEdit");
		//fm.fnWebListCompare(driver, charting_browser_ChartingTool, template.getProperty("Chart_Tool"), "Chart_Tool");
		fm.fnWebListCompare(driver, charting_browser_AttributeOne, template.getProperty("Chart_AttrOne"), "Chart_AttrOne");
		fm.fnWebListCompare(driver, charting_browser_AttributeTwo, template.getProperty("Chart_AttrTwo"), "Chart_AttrTwo");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fm.fnWebListCompare(driver, charting_browser_AttributeThree, template.getProperty("Chart_AttrThree"), "Chart_AttrThree");
	
		Thread.sleep(2000);
		
		fm.fnWebButton(driver, charting_browser_Close, "Close");
		}
		catch(Exception e) {
			childTest.fail(e);
		}
}
	

/************************************************************************/
/** This function is used to Perform copy to new operation	 */
/************************************************************************/

	public void copyToNew() throws InterruptedException {
		childTest = test.createNode(
			"Description: Copy to new  " + "<br>" + "<<Screen Name: Copy Chart >></br>");
			try {
				fm.fnWebEdit(driver, ChartNametoCopy, template.getProperty("Name_ToCopy"), "Name_ToCopy");
				//fm.fnWebEdit(driver, ChartTypeToCopy, template.getProperty("LastName_ToCopy"), "LastName_ToCopy");
				
				fm.fnWebButton(driver, SaveCopy, "Save");
				//fm.fnWebButton(driver, CloseCopy, "Close");
					
			}
			catch(Exception e) {
				childTest.fail(e);
			}
			
}

	

	/************************************************************************/
	/** This function is used to Delete the Chart		 */
	/************************************************************************/
	
	public void deleteEntity(String menuitem) throws InterruptedException {
		childTest = test.createNode("Description: Delete Entity" + "<br>" + "<< Screen Name: LS1 >></br>");
		try {
		
		if (menuitem.equals("Delete Entity")) {
			fm.fnWebButton(driver, purge, "Delete");
			childTest.info("The entity has been deleted");
		}
		}
		catch(Exception e) {
			childTest.fail(e);
		}
	}
	

}

