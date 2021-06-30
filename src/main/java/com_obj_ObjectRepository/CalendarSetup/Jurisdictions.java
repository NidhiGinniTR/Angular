package com_obj_ObjectRepository.CalendarSetup;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class Jurisdictions extends ExtentManager {
	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;

	By CalSetup_Jurisdiction_Country = By.xpath("//select[@id='ddlCountry']");
	By CalSetup_Jurisdiction_StateProvince = By.xpath("//select[@id='ddlStateProvince']");
	By CalSetup_Jurisdiction_Category = By.xpath("//select[@id='ddlCategory']");
	By CalSetup_Jurisdiction_JurisdictionCode = By.xpath("//input[@id='txtJurisdictionCode']");
	By CalSetup_Jurisdiction_JurisdictionName = By.xpath("//input[@id='txtDescription']");
	By CalSetup_Jurisdiction_Holiday = By.xpath("//select[@id='ddlAvailHolidays']");
	By CalSetup_Jurisdiction_Availbilitybutton = By.xpath("//span[@id='lblActive']");
	By CalSetup_Jurisdiction_Save = By.xpath("//input[@id='btnSave']");
	By CalSetup_Jurisdiction_Cancel = By.xpath("//input[@id='btnCancel']");
	
	/**************************ADD Calendar SetUP Juridictions criteria*********/
	
	By CalSetup_JurisdictionCriteria_Country = By.xpath("//select[@id='tcj_country_id']");
	By CalSetup_JurisdictionCriteria_StateProvince = By.xpath("//select[@id='tcj_category_id']");
	By CalSetup_JurisdictionCriteria_Category = By.xpath("//select[@id='tcj_state_province_id']");
	By CalSetup_JurisdictionCriteria_JurisdictionCode = By.xpath("//input[@id='tcj_code']");
	By CalSetup_JurisdictionCriteria_JurisdictionName = By.xpath("//input[@id='tcj_description']");
	By CalSetup_JurisdictionCriteria_Search = By.xpath("//input[@id='btnSearch']");
	By CalSetup_JurisdictionCriteria_Clear = By.xpath("//input[@id='btnCancel']");
	
	
	/***************************************************************************************
	 * This function is used to Add Jurisdiction in Calendar Set Up*
	 
	 ***************************************************************************************/
	
	
	public void add__newJurisdiction() throws InterruptedException {
		childTest = test.createNode("Description: Adding new Jurisdiction " + "<br>"
				+ "<< Screen Name: Entity information >></br>");

		// driver.switchTo().defaultContent();
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		if(alerttext.equalsIgnoreCase("Please enter all required fields.")) {
			alert.accept();
			childTest.info("All required must be entered before saving");
		}
		
		//waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
		fm.fnWebList(driver, CalSetup_Jurisdiction_Country, template.getProperty("Juri_Country"), "Juri_Country");
		fm.fnWebList(driver, CalSetup_Jurisdiction_StateProvince, template.getProperty("Juri_State"), "Juri_State");
		fm.fnWebList(driver,  CalSetup_Jurisdiction_Category, template.getProperty("Juri_Catagory"), "Juri_Catagory");
		fm.fnWebEdit(driver, CalSetup_Jurisdiction_JurisdictionCode, template.getProperty("Juri_code"), "Juri_code");
		fm.fnWebEdit(driver, CalSetup_Jurisdiction_JurisdictionName, template.getProperty("Juri_name"), "Juri_name");
		fm.fnWebList(driver, CalSetup_Jurisdiction_Holiday, template.getProperty("Holiday"), "Holiday");
		fm.fnWebEdit(driver, CalSetup_Jurisdiction_Availbilitybutton, template.getProperty("Avalibility_button"),
				"Avalibility_button");
		
		fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
		if(alerttext.equalsIgnoreCase("The Jurisdiction has been successfully saved.")) {
			alert.accept();
			childTest.pass("The Jurisdiction has been successfully saved.");
		}
		
		
	}



		/***************************************************************************************
		 * This function is used to perform in Search operation in Jurisdiction
		 
		 ***************************************************************************************/
	
		public void fnSearchTaxIds() throws InterruptedException {
			childTest = test.createNode(
					"Description: Search Jurisdiction" + "<br>" + "<<Screen Name: Workflow Manager >></br>");
			try {
				if (driver.getTitle().equalsIgnoreCase("Workflow Manager")) {
					
					fm.fnWebList(driver, CalSetup_JurisdictionCriteria_JurisdictionCode, template.getProperty("Jurisdiction_code"),
							"Jurisdiction_code");
					fm.fnWebList(driver, CalSetup_JurisdictionCriteria_JurisdictionName, template.getProperty("Jurisdiction_name"),
							"Jurisdiction_name");
					fm.fnWebButton(driver, CalSetup_JurisdictionCriteria_Search, "Search");
					
				}
			} catch (Exception e) {
				childTest.fail(e);
			}
		}
		
		/***************************************************************************************
		 * This function used to copy the jurisdiction to new values
		 
		 ***************************************************************************************/
		
		public void copy_Jurisdiction() throws InterruptedException {
			childTest = test.createNode("Description: Copy new Jurisdiction " + "<br>"
					+ "<< Screen Name: Workflow Manager>></br>");

			// driver.switchTo().defaultContent();
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
			Alert alert = driver.switchTo().alert();
			String alerttext = alert.getText();
			if(alerttext.equalsIgnoreCase("A jurisdiction already exists with these values. Cannot add")) {
				alert.accept();
				childTest.info("Values need to be changed");
			}
			
			//waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			fm.fnWebList(driver, CalSetup_Jurisdiction_Country, template.getProperty("Juri_Countrycopy"), "Juri_Countrycopy");
//			fm.fnWebList(driver, CalSetup_Jurisdiction_StateProvince, template.getProperty("Juri_State"), "Juri_State");
//			fm.fnWebList(driver,  CalSetup_Jurisdiction_Category, template.getProperty("Juri_Catagory"), "Juri_Catagory");
			fm.fnWebEdit(driver, CalSetup_Jurisdiction_JurisdictionCode, template.getProperty("Juri_codecopy"), "Juri_codecopy");
			fm.fnWebEdit(driver, CalSetup_Jurisdiction_JurisdictionName, template.getProperty("Juri_namecopy"), "Juri_namecopy");
//			fm.fnWebList(driver, CalSetup_Jurisdiction_Holiday, template.getProperty("Holiday"), "Holiday");
//			fm.fnWebEdit(driver, CalSetup_Jurisdiction_Availbilitybutton, template.getProperty("Avalibility_button"),
//					"Avalibility_button");
			
			fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
			if(alerttext.equalsIgnoreCase("The Jurisdiction has been successfully saved.")) {
				alert.accept();
				childTest.pass("The Jurisdiction has been successfully saved.");
			}
			
			
		}

		/***************************************************************************************
		 * This function is used to perform in Edit operation in Jurisdiction
		 
		 ***************************************************************************************/
		public void Edit_Jurisdiction() throws InterruptedException {
			childTest = test.createNode("Description: Edit  Jurisdiction " + "<br>"
					+ "<< Screen Name: Workflow Manager>></br>");

			// driver.switchTo().defaultContent();
			FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
					.withTimeout(Duration.ofSeconds(50))
					.pollingEvery(Duration.ofSeconds(5))
					.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
					.ignoring(NoSuchFrameException.class);
			fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
			Alert alert = driver.switchTo().alert();
			String alerttext = alert.getText();
			if(alerttext.equalsIgnoreCase("A jurisdiction already exists with these values. Cannot add")) {
				alert.accept();
				childTest.info("Values need to be changed");
			}
			
			//waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
			fm.fnWebList(driver, CalSetup_Jurisdiction_Country, template.getProperty("Juri_CountryEdit"), "Juri_CountryEdit");
			fm.fnWebList(driver, CalSetup_Jurisdiction_StateProvince, template.getProperty("Juri_StateEdit"), "Juri_StateEdit");
			fm.fnWebList(driver,  CalSetup_Jurisdiction_Category, template.getProperty("Juri_CatagoryEdit"), "Juri_CatagoryEdit");
//			

			fm.fnWebButton(driver, CalSetup_Jurisdiction_Save, "Save");
			if(alerttext.equalsIgnoreCase("The Jurisdiction has been successfully saved.")) {
				alert.accept();
				childTest.pass("The Jurisdiction has been successfully saved.");
			}
			
			
		}


}
