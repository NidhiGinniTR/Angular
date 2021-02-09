package com_obj_ObjectRepository.OWM;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class WorkflowBrowser1 extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties loginData;
	Properties template;
	
	// ---------------New Folder Page-----------------------------------------------------------------------------
		By Actions = By.xpath("//*[@id='spActions']");
		
	// ---------------Customize View--------------------------------------------------------------------------------
		By CustView_Save = By.xpath("//input[@id='btnSave']");
		By CustView_Cancel = By.xpath("//input[@id='btnCancel']");
	    
	 // ----------------Save Preferences-----------------------------------------------------------------------------
		By SavePreforAll_notify = By.xpath("//*[@id='chkNotify']");
		By SavePreforAll_save = By.xpath("//*[@name='btnSave']");
		By SavePreforAll_cancel = By.xpath("//*[@name='btnCancel']");
		
		
		public WorkflowBrowser1(WebDriver driver, Properties env, Properties data) {
			this.driver = driver;
			this.loginData = env;
			this.template = data;
		}
		
		
		
		
		public static void fnOWMActionsMenu(WebDriver driver, String item, String subItem) throws InterruptedException {
			if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")
					|| driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
				//WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
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
		
		public void fnOWMCustomizeView(String[] array) throws InterruptedException {
			childTest = test.createNode("Description: Customize View" + "<br>" + "<< Screen Name: OWM >></br>");
			if (driver.getTitle().equalsIgnoreCase("Grid Columns")) {
				for (int i = 0; i < array.length; i++) {
					if (driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).isSelected()) {
						childTest.log(Status.PASS, array[i] + " is checked.");
					} else {
						driver.findElement(By.xpath("//span/input[contains(..,'" + array[i] + "')]")).click();
						childTest.log(Status.PASS, array[i] + " is checked.");
					}
				}
				fm.fnWebButton(driver, CustView_Save, "Save");
			} else {
				childTest.log(Status.FAIL, "Customize view window failed to Open/Not in focus mode");
			}
		}
		public void fnOWMSavePreferences(String menuitem) throws InterruptedException {
			childTest = test.createNode("Description: Save Preferences/For All" + "<br>" + "<< Screen Name: OWM >></br>");
			
			if (menuitem.equals("Save Preferences for All")) {
				if (driver.getTitle().equals("Save Preferences")) {
					System.out.println(driver.getTitle());
					fm.fnWebCheckBox(driver, SavePreforAll_notify, "Notify by Email");
					Thread.sleep(500);
					fm.fnWebButton(driver, SavePreforAll_save, "Save");
					Thread.sleep(500);
					if (driver.switchTo().alert().getText().contains("Screen preferences changed for all users.Notifications were sent.")) {
						driver.switchTo().alert().accept();
						childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
					} else {
						childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
					}
				}
			} else if (menuitem.equals("Save Preferences")) {
				if (driver.switchTo().alert().getText().contains("Your changes have been saved.")) {
					driver.switchTo().alert().accept();
					childTest.log(Status.PASS, "Clicked on OK in the Alert Popup");
				} else {
					childTest.log(Status.ERROR, "Missing Confirmation Message / Alert Popup.");
				}
			}
		}
}
