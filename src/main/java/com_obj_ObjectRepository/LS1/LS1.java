package com_obj_ObjectRepository.LS1;

import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class LS1 extends ExtentManager {
	// POM for Onesource login page
	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties loginData;
	Properties template;

	/***************************************************************************************
	 * These element locators belongs to Login page of Onesource
	 ***************************************************************************************/
	By UserName = By.xpath("//input[@id='_txtLogin']"); // Locator for UserName in onesource login page
	By Password = By.xpath("//INPUT[@id='_txtPassword']"); // Locator for password in onesource login page
	By SignOn = By.xpath("//INPUT[@id='btnSignIn']"); // Locator for Sign-On button in onesource login page
	By EngUS = By.xpath("//A[@id='en']"); // Locator for English(US) reload button

	/*************************************************************************************
	 * These element locators belongs to LS1 page
	 ************************************************************************************/
	By Applications = By.id("btnApps"); // Locator for Application Menu Items in Dashboard Page

	public LS1(WebDriver driver, Properties env, Properties data2) {
		this.driver = driver;
		this.loginData = env;
		this.template = data2;
	}

	/***************************************************************************************
	 * This function is used Login to the Application
	 ***************************************************************************************/

	public void fnLogin() throws InterruptedException {
		childTest = test.createNode("Description: Entering UniversalID and Password." + "<br>"
				+ "<< Screen Name : OneSource Login Page >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE") || driver.getTitle().equalsIgnoreCase("THOMSON REUTERS")) {
			fm.fnWebButton(driver, EngUS, "English-US");
			fm.fnWebEdit(driver, UserName, loginData.getProperty("UserName"), "UniversalID");
			fm.fnWebEdit(driver, Password, loginData.getProperty("Password"), "Password");
			fm.fnWebButton(driver, SignOn, "SignIn");

		}
	}

	/*************************************************************************************
	 * This function is used to launch Applications menu
	 ************************************************************************************/

	public void LaunchApplication(String Temp) throws InterruptedException {
		childTest = test.createNode("Description: Launching " + Temp + " from Applications." + "<br>"
				+ "<< Screen Name: OneSource Dashboard >></br>");
		if (driver.getTitle().equalsIgnoreCase("ONESOURCE")) {
			driver.switchTo().frame("header");
			fm.fnWebButton(driver, Applications, "Applications");
			driver.switchTo().parentFrame();
			driver.switchTo().frame("menuPopup");
			By appMenuItem = By.xpath("//*[@id='appsMenu']//*[contains(text(),'" + Temp + "')]");
			fm.fnWebButton(driver, appMenuItem, Temp);
		}

	}

	/*********************************************************************************
	 * This function handles switching between windows
	 **********************************************************************************/

	public void fnSwitchtoWindow(int winNum, String winName) throws InterruptedException {
		new WebDriverWait(driver, 60).until(ExpectedConditions.numberOfWindowsToBe(winNum));
		Set<String> s = driver.getWindowHandles();
		Iterator<String> ite = s.iterator();
		int i = 1;
		while (ite.hasNext() && i <= s.size()) {
			String popHandle = ite.next().toString();
			driver.switchTo().window(popHandle);
			// driver.manage().window().maximize();
			if (i == winNum)
				break;
			i++;
		}
		/*
		 * for(int j=0;j==winNum;j++) { String[] child = new String[winNum]; child[j]=
		 * ite.next(); if(j==winNum) { driver.switchTo().window(child[j]); break; } }
		 */
		if (winName != null || driver.getTitle().equals(winName)) {
			childTest.info("Switched to " + winName + " window.");
		} else {
			childTest.info("Failed to Switch to " + winName + " window. Trying to switch again");
			fnSwitchtoWindow(winNum,winName);
		}
	}

	/*********************************************************************************
	 * This function is used to select menu item from Actions
	 **********************************************************************************/
	
	public void fnOWMActionsMenu(String item, String subItem) throws InterruptedException {
		if (driver.getTitle().equalsIgnoreCase("WorkFlow Manager")
				|| driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
			// WorkFlowBrowser actionsMenu = new WorkFlowBrowser(driver);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			java.util.List<WebElement> menuitems = driver
					.findElements(By.xpath("//table[@class='MenuGroup']//td[ @class='MenuItem']"));
			for (int i = 0; i < menuitems.size(); i++) {
				// String name = webelement.getText();
				if (item.equals(menuitems.get(i).getText())) {
					String menuitem = menuitems.get(i).getAttribute("id");
					driver.findElement(By.id(menuitem)).click();
					if (!subItem.isEmpty()) {
						List<WebElement> submenuItems = driver
								.findElements(By.xpath("//table[@class='MenuGroup']//td[ @class='MenuItem']"));
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
}
