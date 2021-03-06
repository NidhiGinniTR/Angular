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

public class Authorities extends ExtentManager {
	
	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;
	
	
	By CalSetup_Authorities_ANAP_JurisdictionCode = By.xpath("//input[@id='txtRow1Col1']");  
	
	By CalSetup_Authorities_JurisdictionCode_Search = By.xpath("//img[@id='btnRow1Col1']"); 
	
	By CalSetup_Authorities_TaskType = By.xpath("//select[@id='ddlsRow2Col1']"); 
	
	By CalSetup_Authorities_PlusSymbol = By.xpath("//img[@id='imgAddTaxType']");
	
	By CalSetup_Authorities_MinusSymbol = By.xpath("//img[@id='imgRemoveTaxType']");
	
	By CalSetup_Authorities_AuthorityName = By.xpath("//input[@id='txtRow3Col1']"); 
	
	By CalSetup_Authorities_AuthorityName2 = By.xpath("//input[@id='txtRow4Col1']");
	
	By CalSetup_Authorities_PayableTo = By.xpath("//input[@id='txtRow5Col1']");
	
	By CalSetup_Authorities_AuthorityYearEndMonth = By.xpath("//select[@id='ddlRow6Col1']");
	
	By CalSetup_Authorities_AuthorityYearEndDate = By.xpath("//select[@id='ddlRow6Col2']");
	
	By CalSetup_Authorities_MainPhone = By.xpath("//input[@id='txtRow7Col1']");
	
	By CalSetup_Authorities_AlternatePhone = By.xpath("//input[@id='txtRow8Col1']");
	
	By CalSetup_Authorities_Fax = By.xpath("//input[@id='txtRow9Col1']");
	
	By CalSetup_Authorities_Email = By.xpath("//input[@id='txtRow10Col1']");
	
	By CalSetup_Authorities_Website = By.xpath("//input[@id='txtRow11Col1']");
	
	By CalSetup_Authorities_Vendor = By.xpath("//input[@id='txtRow12Col1']");
	
	By CalSetup_Authorities_Notes = By.xpath("//textarea[@id='txtRow13Col1']");
	
	By CalSetup_Authorities_Available = By.xpath("//input[@id='chkRow14Col1']");
	
	By CalSetup_Authorities_Save = By.xpath("//input[@id='btnOK']");
	
	By CalSetup_Authorities_Cancel = By.xpath("//input[@id='btnCancel']");
	
	// For authority search
	
	
	By CalSetup_AuthorityCri_Name = By.xpath("//input[@id='tcau_authority_name1']");
	
	By CalSetup_AuthorityCri_Name2 = By.xpath("//input[@id='tcau_authority_name2']");
	
	By CalSetup_AuthorityCri_Taxtype = By.xpath("//select[@id='tcau_tax_type_id']");
	
	By CalSetup_AuthorityCri_Country = By.xpath("//select[@id='tcj_country_id']");
	
	By CalSetup_AuthorityCri_State = By.xpath("//select[@id='tcj_state_province_id']");
	
	By CalSetup_AuthorityCri_Catagory = By.xpath("//select[@id='tcj_category_id']");
	
	By CalSetup_AuthorityCri_Juriscode = By.xpath("//input[@id='tcj_code']");
	
	By CalSetup_AuthorityCri_Availiable = By.xpath("//select[@id='tcau_visible']");
	
	By CalSetup_AuthorityCri_Search = By.xpath("//input[@id='btnSearch']");
	
	By CalSetup_AuthoritiesCri_Cancel = By.xpath("//input[@id='btnCancel']");
	
	
	
	
	
	public void add__newJurisdiction() throws InterruptedException {
		childTest = test.createNode("Description: Adding new Authority " + "<br>"
				+ "<< Screen Name: Entity information >></br>");

		// driver.switchTo().defaultContent();
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		if(alerttext.equalsIgnoreCase("Please enter all required fields.")) {
			alert.accept();
			childTest.info("All required must be entered before saving");
		}
		
		//waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
		fm.fnWebList(driver, CalSetup_Authorities_TaskType, template.getProperty("Task_Type"), "Task_Type");
		fm.fnWebButton(driver, CalSetup_Authorities_PlusSymbol, "Add Symbol");
		fm.fnWebEdit(driver, CalSetup_Authorities_AuthorityName, template.getProperty("Authority_Name"), "Authority_Name");
		fm.fnWebEdit(driver, CalSetup_Authorities_AuthorityName2, template.getProperty("Authority_Name2"), "Authority_Name");
		fm.fnWebEdit(driver, CalSetup_Authorities_PayableTo, template.getProperty("Payble_To"), "Payble_To");
		fm.fnWebList(driver, CalSetup_Authorities_AuthorityYearEndMonth, template.getProperty("End_Month"), "End_Month");
		fm.fnWebList(driver, CalSetup_Authorities_AuthorityYearEndDate, template.getProperty("End_Year"), "End_Year");
		fm.fnWebEdit(driver, CalSetup_Authorities_MainPhone, template.getProperty("CS_mainphone"), "CS_mainphone");
		fm.fnWebEdit(driver, CalSetup_Authorities_AlternatePhone, template.getProperty("CS_altphone"),
				"CS_altphone");
		fm.fnWebEdit(driver, CalSetup_Authorities_Fax, template.getProperty("Authority_Fax"), "Authority_Fax");
		fm.fnWebEdit(driver, CalSetup_Authorities_Email, template.getProperty("Authority_Email"), "Authority_Email");
		fm.fnWebEdit(driver, CalSetup_Authorities_Website, template.getProperty("Authority_Website"), "Authority_Website");
		fm.fnWebList(driver, CalSetup_Authorities_Vendor, template.getProperty("Authority_Vendor"), "Authority_Vendor");
		
		
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		if(alerttext.equalsIgnoreCase("The Authority has been successfully saved.")) {
			alert.accept();
			childTest.pass("The Authority has been successfully saved.");
		}
		
		
	}
	
	
	/***************************************************************************************
	 * This function is used to perform in Search operation in Jurisdiction
	 
	 ***************************************************************************************/

	public void fnSearchTaxIds() throws InterruptedException {
		childTest = test.createNode(
				"Description: Search Authority" + "<br>" + "<<Screen Name: Workflow Manager >></br>");
		try {
			if (driver.getTitle().equalsIgnoreCase("Workflow Manager")) {
				
				fm.fnWebList(driver, CalSetup_AuthorityCri_Name, template.getProperty("AuthorityCri_name"),
						"Jurisdiction_code");
				fm.fnWebList(driver, CalSetup_AuthorityCri_Taxtype, template.getProperty("Authority_Taxtype"),
						"Jurisdiction_name");
				fm.fnWebButton(driver, CalSetup_AuthorityCri_Search, "Search");
				
			}
		} catch (Exception e) {
			childTest.fail(e);
		}
	}


	/***************************************************************************************
	 * This function used to copy the jurisdiction to new values
	 
	 ***************************************************************************************/
	
	public void copy_Authority() throws InterruptedException {
		childTest = test.createNode("Description: Copy Authority" + "<br>"
				+ "<< Screen Name: Workflow Manager>></br>");

		// driver.switchTo().defaultContent();(
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		if(alerttext.equalsIgnoreCase("Please enter all required fields.")) {
			alert.accept();
			childTest.info("Required values need to be entered");
		}
		fm.fnWebEdit(driver, CalSetup_Authorities_AuthorityName, template.getProperty("Auth_Name_Copy"),
				"Auth_Name_Copy");
		
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		if(alerttext.equalsIgnoreCase("The Authority has been successfully saved.")) {
			alert.accept();
			childTest.pass("The Authority has been successfully saved.");
		}
		
		
	}
	
	public void edit_Authority() throws InterruptedException {
		childTest = test.createNode("Description: Edit Authority " + "<br>"
				+ "<< Screen Name: Entity information >></br>");

		// driver.switchTo().defaultContent();
		FluentWait<WebDriver> waitf = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		Alert alert = driver.switchTo().alert();
		String alerttext = alert.getText();
		if(alerttext.equalsIgnoreCase("Please enter all required fields.")) {
			alert.accept();
			childTest.info("All required must be entered before saving");
		}
		
		//waitf.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("addeditFrame1"));
	
		fm.fnWebEdit(driver, CalSetup_Authorities_Fax, template.getProperty("Authority_FaxEdit"), "Authority_FaxEdit");
		fm.fnWebEdit(driver, CalSetup_Authorities_Email, template.getProperty("Authority_EmailEdit"), "Authority_EmailEdit");
		fm.fnWebEdit(driver, CalSetup_Authorities_Website, template.getProperty("Authority_WebsiteEdit"), "Authority_WebsiteEdit");
		fm.fnWebList(driver, CalSetup_Authorities_Vendor, template.getProperty("Authority_VendorEdit"), "Authority_VendorEdit");
		
		
		fm.fnWebButton(driver, CalSetup_Authorities_Save, "Save");
		if(alerttext.equalsIgnoreCase("The Authority has been successfully saved.")) {
			alert.accept();
			childTest.pass("The Authority has been successfully saved.");
		}
		
		
	}
	


}
