package com_obj_ObjectRepository.FolderWorkflows1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;



public class Events extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties template;

	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page1
	 ***************************************************************************************/
	By fwf_Events_SNE_EntityName = By.xpath("//INPUT[@id='tcet_bi_name']"); //Locator for Entity Name in Schedule New Event Page1 
	By fwf_Events_SNE_EntityID = By.xpath("//INPUT[@id='tcet_bi_id']"); //Locator for Entity ID in Schedule New Event Page1 
	By fwf_Events_SNE_Location = By.xpath("//SELECT[@id='location']"); //Locator for Location in Schedule New Event Page1 
	By fwf_Events_SNE_EntityGroup = By.xpath("//SELECT[@id='entity_group_name']"); //Locator for Entity Group in Schedule New Event Page1 
	By fwf_Events_SNE_EntityType = By.xpath("//SELECT[@id='tcet_bi_entity_type_id']"); //Locator for Entity Type in Schedule New Event Page1 
	By fwf_Events_SNE_Status = By.xpath("//SELECT[@id='tcet_bi_status_id']"); //Locator for Status in Schedule New Event Page1 
	By fwf_Events_SNE_GroupCosdes = By.xpath("//SELECT[@id='group_codes']"); //Locator for Group Codes in Schedule New Event Page1 
	By fwf_Events_SNE_Search = By.xpath("//INPUT[@id='btnSearch']"); //Locator for Search in Schedule New Event Page1 
	By fwf_Events_SNE_Clear = By.xpath("//INPUT[@id='btnCancel']"); //Locator for Clear in Schedule New Event Page1 
	By fwf_Events_SNE_Next = By.xpath("//INPUT[@id='cmdEntityNext']"); //Locator for Next in Schedule New Event Page1 
	By fwf_Events_SNE_Cancel1 = By.xpath("//IMG[@id='imgCancel']"); //Locator for Cancel in Schedule New Event Page1 

	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page2
	 ***************************************************************************************/
	By fwf_Events_SNE_EventTemplateName = By.xpath("//INPUT[@id='tce_event_name']"); //Locator for Event Template Name in Schedule New Event Page2 
	By fwf_Events_SNE_EventDescription = By.xpath("//INPUT[@id='tce_event_description']"); //Locator for Event Description in Schedule New Event Page2 
	By fwf_Events_SNE_TaxType = By.xpath("//SELECT[@id='tax_type_id']"); //Locator for Tax Type in Schedule New Event Page2 
	By fwf_Events_SNE_FormEntityType = By.xpath("//SELECT[@id='entity_type_id']"); //Locator for Form Entity Type in Schedule New Event Page2 
	By fwf_Events_SNE_Country_Region = By.xpath("//SELECT[@id='tcj_country_id']"); //Locator for Country Region in Schedule New Event Page2 
	By fwf_Events_SNE_State_Province = By.xpath("//SELECT[@id='tcj_state_province_id']"); //Locator for State Province in Schedule New Event Page2 
	By fwf_Events_SNE_Category = By.xpath("//SELECT[@id='tcj_category_id']"); //Locator for Category Schedule New Event Page2 
	By fwf_Events_SNE_JurisdictionCode = By.xpath("//INPUT[@id='tcj_code']"); //Locator for Jurisdiction Code in Schedule New Event Page2 
	By fwf_Events_SNE_AuthorityName = By.xpath("//INPUT[@id='tcau_authority_name1']"); //Locator for Authority Name in Schedule New Event Page2 
	By fwf_Events_SNE_Form = By.xpath("//INPUT[@id='form_no']"); //Locator for Form in Schedule New Event Page2 
	By fwf_Events_SNE_FormType = By.xpath("//SELECT[@id='form_type_id']"); //Locator for Form Type in Schedule New Event Page2 
	By fwf_Events_SNE_Next2 = By.xpath("//INPUT[@id='imgNextEvent']"); //Locator for Next in Schedule New Event Page2 
	By fwf_Events_SNE_Previous = By.xpath("//INPUT[@id='imgPreviousEvent']"); //Locator for Previous in Schedule New Event Page2 
	By fwf_Events_SNE_Cancel2 = By.xpath("//INPUT[@id='Image2']"); //Locator for Cancel in Schedule New Event Page2 
	By fwf_Events_SNE_EventTemplateWebTable = By.xpath("//*[@id='grd_SE_Event_cell_0_1']"); //Locator for Event Template Webtable in Schedule New Event Page2 

	/***************************************************************************************
	 * These element locators belongs to Schedule New Events Page3
	 ***************************************************************************************/
	By fwf_Events_SNE_OverallResponsibility = By.xpath("//SELECT[@id='ddlOverallResp']"); //Locator for Over all Responsibility in Schedule New Event Page3 
	By fwf_Events_SNE_OverallResponsibilityCkBx = By.xpath("//INPUT[@id='chkOverallResp']"); //Locator for Over all Responsibility Check Box in Schedule New Event Page3 
	By fwf_Events_SNE_AssignedTo = By.xpath("//SELECT[@id='ddlAssignedTo']"); //Locator for Assigned To in Schedule New Event Page3 
	By fwf_Events_SNE_AssignedToCkBx = By.xpath("//INPUT[@id='chkAssignedTo']"); //Locator for Assigned to checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_TaxAcct = By.xpath("//SELECT[@id='ddlResponsible1']"); //Locator for Tax Act in Schedule New Event Page3 
	By fwf_Events_SNE_TaxAcctCkBx = By.xpath("//INPUT[@id='chkResponsible1']"); //Locator for Tax Act Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility3 = By.xpath("//SELECT[@id='ddlResponsible3']"); //Locator for Responsibility3 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility3CkBx = By.xpath("//INPUT[@id='chkResponsible3']"); //Locator for Responsibility3 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Manager = By.xpath("//SELECT[@id='ddlResponsible2']"); //Locator for Manager in Schedule New Event Page3 
	By fwf_Events_SNE_ManagerCkBx = By.xpath("//INPUT[@id='chkResponsible2']"); //Locator for Manager Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility4 = By.xpath("//SELECT[@id='ddlResponsible4']"); //Locator for Responsibility4 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility4CkBx = By.xpath("//INPUT[@id='chkResponsible4']"); //Locator for Responsibility4 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility5 = By.xpath("//SELECT[@id='ddlResponsible5']"); //Locator for Responsibility5 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility5CkBx = By.xpath("//INPUT[@id='chkResponsible5']"); //Locator for Responsibility5 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility6 = By.xpath("//SELECT[@id='ddlResponsible6']"); //Locator for Responsibility6 in Schedule New Event Page3 
	By fwf_Events_SNE_Responsibility6CkBx = By.xpath("//INPUT[@id='chkResponsible6']"); //Locator for Responsibility6 Checkbox in Schedule New Event Page3 
	By fwf_Events_SNE_Previous3 = By.xpath("//IMG[@id='imgPreviousResp']"); //Locator for Previous in Schedule New Event Page3 
	By fwf_Events_SNE_Next3 = By.xpath("//INPUT[@id='imgNextResp']"); //Locator for Next in Schedule New Event Page3
	By fwf_Events_SNE_Cancel3 = By.xpath("//INPUT[@id='Img5']"); //Locator for Cancel in Schedule New Event Page3
	By fwf_Events_SNE_Finish = By.xpath("//INPUT[@id='img1']"); //Locator for Finish in Schedule New Event Page3
	By fwf_Events_SNE_EventWebCheckbox = By.xpath("//*[@id='chkEntityEvent']"); //Locator for Event Web Checkbox in Schedule New Event Page3

	/***************************************************************************************
	 * These element locators belongs to Extend Event
	 ***************************************************************************************/
	By fwf_Events_ScheduleExtension = By.xpath("//INPUT[@id='btnScheduleExtension']"); //Locator for Schedule Extension in Extend Event Alert

	/***************************************************************************************
	 * These element locators belongs to Edit Schedule Event
	 ***************************************************************************************/
	
	By fwf_Events_ESE_Actions = By.xpath("//td[@class='actionsMiddle']"); //Locator for Actions in Edit Schedule Event
	//By fwf_Events_ESE_Actions = By.className("actionsMiddle"); //Locator for Actions in Edit Schedule Event
	By fwf_Events_ESE_Status = By.xpath("//SELECT[@id='ddlStatusWS']"); //Locator for Status in Edit Schedule Event
	By fwf_Events_ESE_Priority = By.xpath("//SELECT[@id='ddlPriorityWS']"); //Locator for Priority in Edit Schedule Event
	By fwf_Events_ESE_OWM_W_F_Template = By.xpath("//INPUT[@id='txtRelatedToWF']"); //Locator for W/F template in Edit Schedule Event
	By fwf_Events_ESE_NotifyCkBx = By.xpath("//IMG[@id='chkNotifyAssigned_mcbox']"); //Locator for Notify Checkbox in Edit Schedule Event
	By fwf_Events_Save = By.xpath("//INPUT[@id='btnSave']"); //Locator for Save in Edit Schedule Event
	By fwf_Events_ESE_MarkDone = By.xpath("//*[@id='mnuProperties_0']"); //Locator for Mark Done in Edit Schedule Event
	By fwf_Events_ESE_ExtendEvent = By.xpath("//*[@id='mnuProperties_1']"); //Locator for Extend event in Edit Schedule Event
	By fwf_Events_ESE_RollForward = By.xpath("//*[@id='mnuProperties_2']"); //Locator for Roll Forward in Edit Schedule Event
	By fwf_Events_ESE_Recalculate = By.xpath("//*[@id='mnuProperties_3']"); //Locator for Re-Calculate in Edit Schedule Event
	By fwf_Events_ESE_UndoExtension = By.xpath("//*[@id='mnuProperties_4']"); //Locator for Undo Extension in Edit Schedule Event
	By fwf_Events_ESE_PrintCertifiedMailer = By.xpath("//*[@id='mnuProperties_5']"); //Locator for Print certified Mailer in Edit Schedule Event
	By fwf_Events_ESE_RollForwardCkBx = By.xpath("//INPUT[@id='chkRollAll']"); //Locator for Roll Forward Checkbox in Roll Forward Page
	By fwf_Events_ESE_RollForward_Ok = By.xpath("//INPUT[@id='RolloverSchedEvents']"); //Locator for Ok in Roll Forward Page
	By fwf_Events_ESE_RollForward_Cancel = By.xpath("//INPUT[@id='btnCancel']"); //Locator for Cancel in Roll Forward Page
	
	/***************************************************************************************
	 * These element locators belongs to Actions Button
	 ***************************************************************************************/
	
	By Actions = By.xpath("//td[@id='btnActionsMenu']"); //Locator for Actions Button
	
		
	public Events(WebDriver driver, Properties data) {
		this.driver = driver;
		this.template = data;
	}
	
	/*********************************************************************************
	 * This function is used to Extend the Event
	 **********************************************************************************/
	
	public void fnFWFExtendEvent() throws InterruptedException{
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(1500);
		System.out.println(driver.getTitle());
		if(driver.getTitle().contains("Extension")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ScheduleExtension));
			fm.fnWebButton(driver, fwf_Events_ScheduleExtension, "Extend Event(s)");
		}
	}
	
	/*********************************************************************************
	 * This function is used to click Actions in Folder Workflows
	 **********************************************************************************/
	
	public void fnFWFClickActions() throws InterruptedException{
		if(driver.getTitle().equalsIgnoreCase("Folder WorkFlows")) {
			fm.fnWebButton(driver, Actions, "Actions");
		}
	}
	
	/*********************************************************************************
	 * This function is used to Swtich Tabs in Folder Workflows
	 **********************************************************************************/
	
	public void fnFWFSwitchingTab(String text) throws InterruptedException{
		Thread.sleep(1500);
		if(driver.getTitle().contains("Folder WorkFlows")) {
			By tabItem = By.xpath("//*[@id='TabStrip1']//*[contains(text(),'"+text+"')]");
			fm.fnWebButton(driver, tabItem, text);
		}
	}
	
	
	/*********************************************************************************
	 * This function is used to Schedule a New Event
	 **********************************************************************************/

	public void fnFWFScheduleNewEvent() throws InterruptedException {
		childTest = test.createNode(
				"Description: Creating a New Schedule Event." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(3500);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_SNE_Clear));
		if (driver.getTitle().equalsIgnoreCase("Schedule New Event(s)")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_SNE_EventTemplateName));
			fm.fnWebButton(driver, fwf_Events_SNE_Clear, "Cancel");
			fm.fnWebEdit(driver, fwf_Events_SNE_EventTemplateName, template.getProperty("Event_Template_Name"), "Event Template Name");
			fm.fnWebList(driver, fwf_Events_SNE_TaxType, template.getProperty("E_TaxType"), "Tax Type");
			fm.fnWebButton(driver, fwf_Events_SNE_Search, "Search");
			ArrayList<WebElement> cells1 = (ArrayList<WebElement>) driver
					.findElements(By.xpath("//DIV[@id='grd_SE_Event_dom']/table/tbody/tr"));
			System.out.println(cells1.size());
			if (cells1.size() >= 2) {
				fm.fnWebButton(driver, fwf_Events_SNE_EventTemplateWebTable, "Event Template Name WebTable");
			} else {
				driver.quit();
			}
			fm.fnWebButton(driver, fwf_Events_SNE_Next2, "Next");
			fm.fnWebList(driver, fwf_Events_SNE_AssignedTo, template.getProperty("AssignedTo"), "Assigned To");
			fm.fnWebCheckBox(driver, fwf_Events_SNE_AssignedToCkBx, "Assigned ToCkBx");
			fm.fnWebButton(driver, fwf_Events_SNE_Next3, "Next");
			List<WebElement> chkBox = driver
					.findElements(By.xpath("//DIV[@id='grd_SE_Entity_Event_dom']/TABLE/tbody/tr"));
			int no = chkBox.size();
			System.out.println(no);
			if (no > 1) {
				fm.fnWebButton(driver, fwf_Events_SNE_EventWebCheckbox, "Event Checkbox");
			}
			fm.fnWebButton(driver, fwf_Events_SNE_Finish, "Finish");
			Thread.sleep(1500);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert().accept();
			childTest.log(Status.PASS, "Successfully a Event is created");
		}else {
			childTest.log(Status.FAIL, "Schedule New Event Page is not Focused/Opened");
		}

	}

	/***********************************************************************************
	 * This function is used to perform Mark Done function in Edit Schedule Events Page
	 ***********************************************************************************/
	
	public void fnFWFESEMarkDone(String text) throws InterruptedException {
		childTest = test.createNode("Description: Mark Done" + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		// FunctionLibrary.fnSwitchtoWindow(driver, 4, "Folder WorkFlows");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(100))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
		Thread.sleep(1500);
		if (driver.getTitle().equalsIgnoreCase("Scheduled Event Profile")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
			fm.fnWebButton(driver, fwf_Events_ESE_Actions, "Action");
			fm.fnWebButton(driver, fwf_Events_ESE_MarkDone, "Mark Done");
			By tabItem = By.xpath("//*[@id='TabStripStepProperties']//*[contains(text(),'" + text + "')]");
			fm.fnWebButton(driver, tabItem, text);
			fm.fnWebButton(driver, fwf_Events_Save, "Save");
			//System.out.println(driver.switchTo().alert().getText());
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText()
					.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Selected event has been upated");
			} else {
				childTest.log(Status.FAIL, "Selected event is not updated");
				driver.close();
			}

		}else {
			driver.close();
			childTest.log(Status.FAIL, "Scheduled Event Profile page is not recoginzed");
		}
	}

	/**************************************************************************************
	 * This function is used to perform Re-Calculate function in Edit Schedule Events Page
	 **************************************************************************************/
	
	public void fnFWFESEReCalculate() throws InterruptedException {
		childTest = test.createNode("Description: Re-Calculate." + "<br>" + "<< Screen Name: Folder Workflows >></br>");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		Thread.sleep(1500);
		if (driver.getTitle().equalsIgnoreCase("Scheduled Event Profile")) {
			wait.until(ExpectedConditions.visibilityOfElementLocated(fwf_Events_ESE_Actions));
			fm.fnWebButton(driver, fwf_Events_ESE_Actions, "Action");
			fm.fnWebButton(driver, fwf_Events_ESE_Recalculate, "Re-Calculate");
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText().equalsIgnoreCase("0 out of 1 record(s) processed.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
			} else {
				driver.close();
			}
			Thread.sleep(1000);
			fm.fnWebButton(driver, fwf_Events_Save, "Save");
			wait.until(ExpectedConditions.alertIsPresent());
			if (driver.switchTo().alert().getText()
					.equalsIgnoreCase("The selected Scheduled Event(s) have been updated.")) {
				Thread.sleep(2500);
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS, "Selected scheduled event is updated");
			} else {
				driver.close();
				childTest.log(Status.FAIL, "Selected scheduled event is not updated");
			}
		}
	}

	/**************************************************************************************
	 * This function is used to Select a Event
	 **************************************************************************************/
	
	public void fnFWFSelectEvent() throws InterruptedException {
		//FunctionLibrary.fnSwitchtoWindow(driver,3, "Folder WorkFlows");
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(70))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class,NoSuchWindowException.class)
				.ignoring(NoSuchFrameException.class);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("tabIFrame"));
		
         ArrayList<WebElement> cells = (ArrayList<WebElement>) driver.findElements(By.xpath("//DIV[@id='grdEvents_dom']/table/tbody/tr/td"));
         for (WebElement cell : cells) {
             if(cell.getText().equals(template.getProperty("Event_Template_Name"))) {
            	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//DIV[@id='grdEvents_dom']/table/tbody/tr/td")));
             	fm.fnWebTable(driver, cell, "Click");
            	break;
 	        }
 	    }
    }

}
