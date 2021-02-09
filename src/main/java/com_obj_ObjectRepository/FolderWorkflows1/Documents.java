package com_obj_ObjectRepository.FolderWorkflows1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class Documents extends ExtentManager {

	WebDriver driver;
	Properties data;
	FrameWork fm = new FrameWork();
	// -------------Email Documents ------------------------------------------

	By EmailDoc_To = By.xpath("//INPUT[@id='txtTo']");
	By EmailDoc_CC = By.xpath("//INPUT[@id='txtCC']");
	By EmailDoc_BCC = By.xpath("//INPUT[@id='txtBCC']");
	By EmailDoc_Subject = By.xpath("//INPUT[@id='txtSubject']");
	By EmailDoc_Message = By.xpath("//TEXTAREA[@id='txtMsg']");
	By EmailDoc_AttachmentType = By.xpath("//*[@id='rdAttachmentType1']");
	By EmailDoc_AttachmenType_asLink = By.xpath("//*[@id='rdAttachmentType0']");
	By EmailDoc_Save = By.xpath("//IMG[@id='btnOK']");
	By EmailDoc_Cancel = By.xpath("//IMG[@id='btnCancel']");
	// -------------------------CopyDocuments---------------------------------------------------
	By Documents_EntityName = By.xpath("//input[@id='idx_000000000B']");
	By Documents_EntityID = By.xpath("//input[@id='idx_000000000C']");
	By Documents_TaxType = By.xpath("//select[@id='idx_000000000D']");
	By Documents_Year = By.xpath("//select[@id='idx_000000000E']");
	By Documents_Period = By.xpath("//select[@id='idx_000000000F']");
	By Documents_Jurisdiction = By.xpath("//input[@id='idx_000000000G']");
	By Documents_Description = By.xpath("//input[@id='idx_000000000H']");
	By Documents_FileSection = By.xpath("//select[@id='idx_000000000I']");
	By Documents_DocumentType = By.xpath("//select[@id='idx_000000000J']");
	By Documents_DocumentDate = By.xpath("//input[@id='idx_000000000K']");
	By Documents_WorkFLowAssociation = By.xpath("//select[@id='idx_000000000L']");
	By Documents_AssignedTo = By.xpath("//select[@id='DropDownListDocumentUIDAssignTo']");
	By Documents_DocumentStatus = By.xpath("//select[@id='DropDownListDocumentStatus']");
	By Documents_DueDate = By.xpath("//input[@id='txtDueDate']");
	By Documents_chkNotify = By.xpath("//input[@id='chkNotify']");
	By Documents_NotifyEmailButton = By.xpath("//input[@id='btnUserList']");
	By Documents_Save = By.xpath("//IMG[@id='btnOK']");
	By Documents_Cancel = By.xpath("//IMG[@id='btnCancel']");
	By Documents_Reset = By.xpath("//IMG[@id='btnReset']");
	// --------------------------------MoveDocument------------------------------------------------------------------
	By MoveDoc_Drawers = By.xpath("//SELECT[@id='DropDownListDrawers']");
	By MoveDoc_DeleteSourceDoc = By.xpath("//INPUT[@id='chkDeleteSourceDocument']");
	By MoveDoc_EntityName = By.xpath("//input[@id='idx_0000000004']");
	By MoveDoc_EntityID = By.xpath("//input[@id='idx_0000000005']");
	By MoveDoc_TaxType = By.xpath("//select[@id='idx_0000000001']");
	By MoveDoc_Year = By.xpath("//select[@id='idx_0000000002']");
	By MoveDoc_Period = By.xpath("//select[@id='idx_0000000003']");
	By MoveDoc_Jurisdiction = By.xpath("//input[@id='idx_0000000006']");
	By MoveDoc_Description = By.xpath("//input[@id='idx_0000000009']");
	By MoveDoc_FileSection = By.xpath("//select[@id='idx_0000000007']");
	By MoveDoc_DocumentType = By.xpath("//select[@id='idx_0000000008']");
	By MoveDoc_DocumentDate = By.xpath("//input[@id='idx_000000000A']");
	By MoveDoc_Save = By.xpath("//img[@id='btnOK']");
	By MoveDoc_Cancel = By.xpath("//img[@id='btnCancel']");
	// ----------------------Document Properties-------------------------------
	public By DocProp_AssignedTo = By.xpath("//select[@id='assigned_to']");
	public By DocProp_DocumentStatus = By.xpath("//select[@id='document_status']");
	public By DocProp_DueDate = By.xpath("//input[@id='due_date']");
	// -----------------Saved Search----------------------------------------
	By SavedSearch_SavedSearches = By.xpath("//select[@id='saved_searches']");
	By SavedSearch_DocID = By.xpath("//input[@id='d.doc_id']");
	By SavedSearch_Year = By.xpath("//select[@id='idx_000000000E_ddl']");
	By SavedSearch_Period = By.xpath("//select[@id='idx_000000000F_ddl']");
	By SavedSearch_TaxType = By.xpath("//select[@id='idx_000000000D_ddl']");
	By SavedSearch_WFTemplate = By.xpath("//select[@id='wt_name']");
	By SavedSearch_WFAssociation = By.xpath("//select[@id='idx_000000000L_ddl']");
	By SavedSearch_WorkFlowType = By.xpath("//select[@id='fw_workflow_type']");
	By SavedSearch_FileSection = By.xpath("//select[@id='idx_000000000I_ddl']");
	By SavedSearch_DocumentType = By.xpath("//select[@id='idx_000000000J_ddl']");
	By SavedSearch_DocumentDate = By.xpath("//input[@id='dt_range_idx_000000000K_FOLDERDOCUMENTS']");
	By SavedSearch_Status = By.xpath("//select[@id='folder_workflow_status_id_ddl']");
	By SavedSearch_GroupCodes = By.xpath("//select[@id='group_codes']");
	By SavedSearch_Text = By.xpath("//input[@id='full_text_search_text']");
	By SavedSearch_TextOperator = By.xpath("//select[@id='full_text_search_operator']");
	By SavedSearch_Save = By
			.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[1]");
	By SavedSearch_Delete = By
			.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[1]/IMG[2]");
	By SavedSearch_Search = By
			.xpath("//div[@id='divDocumentsCrit']/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[1]");
	By SavedSearch_Clear = By.xpath(
			"//div[@id=\"divDocumentsCrit\"]/TABLE[1]/TBODY[1]/TR[8]/TD[1]/TABLE[1]/TBODY[1]/TR[1]/TD[2]/IMG[2]");
	By SavedSearch_Close = By.xpath("//img[@id='btnClose']");

	public Documents(WebDriver driver, Properties data) {
		this.driver = driver;
		this.data = data;
	}

	public void fwf_fnEmailDocument() throws InterruptedException {
		childTest = test
				.createNode("Description: Email Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Email Document(s)")) {
			fm.fnWebButton(driver, EmailDoc_Save, "Save");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			if (text.contains("To address cannot be blank.")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass(
						"Verification: Click on Save before Emailing document alert" + "<br>" + text + " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save before Emailing document alert is missing");
			}
			fm.fnWebEdit(driver, EmailDoc_To, data.getProperty("doc_EmailTO"), " To ");
			fm.fnWebEdit(driver, EmailDoc_CC, data.getProperty("doc_EmailCC"), " CC ");
			fm.fnWebEdit(driver, EmailDoc_Subject, data.getProperty("doc_EmailSubject"), "Subject");
			fm.fnWebEdit(driver, EmailDoc_Message, "Hi All,", "\"Hi All,\" + \"+<br>+\"\r\n"
					+ "					+ \" This email is intended to verify Email Document's as a link/Attachment functionality</br>\"");
			fm.fnWebButton(driver, EmailDoc_AttachmenType_asLink, "As a Link");
			fm.fnWebButton(driver, EmailDoc_Save, "Save");
			Thread.sleep(900);
			w.until(ExpectedConditions.alertIsPresent());
			String text1 = driver.switchTo().alert().getText();
			if (text1.contains("Your email has been sent.")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass(
						"Verification: Click on Save after Emailing document: Alert" + "<br>" + text + " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save after Emailing document: Alert is missing");
			}
		}
	}

	public void fwf_fnCopyDocuments() throws InterruptedException {
		childTest = test
				.createNode("Description: Copy Documents " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Copy Document(s)")) {
			// owm.Documents_Entityname("");
			fm.fnWebButton(driver, Documents_Save, "Save");
			Thread.sleep(800);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text = driver.switchTo().alert().getText();
			if (text.contains("is required")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save before Copy documents mandatory field alert" + "<br>" + text
						+ " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save before copy documents mandatory field alert is missing");
			}
			Thread.sleep(800);
			fm.fnWebButton(driver, Documents_Reset, "Reset");
			Thread.sleep(800);
			fm.fnWebButton(driver, Documents_Save, "Save");
			w.until(ExpectedConditions.alertIsPresent());
			String text1 = driver.switchTo().alert().getText();
			if (text1.contains("Click 'OK' to continue")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save:Copy documents confirmation alert 1" + "<br>" + text
						+ " exists </br>");
				Thread.sleep(1500);
				w.until(ExpectedConditions.alertIsPresent());
				String text2 = driver.switchTo().alert().getText();
				if (text2.contains("Documents successfully copied and re-indexed: 1")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save:Copy documents confirmation alert 2" + "<br>" + text
							+ " exists </br>");
				} else {
					childTest.fail("Verification: Click on Save: Copy documents confirmation alert 2 is missing");
				}
			} else {
				childTest.fail("Verification: Click on Save: Copy documents confirmation alert 1 is missing");
			}
		}
	}

	public void fwf_fnMoveDocument() throws InterruptedException {
		childTest = test
				.createNode("Description: Move Document " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Move Document")) {
			fm.fnWebList(driver, MoveDoc_Drawers, data.getProperty("doc_MoveD_Drawer"), "Drawers");
			WebDriverWait w = new WebDriverWait(driver, 40);
			WebElement exist = w
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='idx_0000000004']")));
			if (exist.isDisplayed()) {
				fm.fnWebButton(driver, MoveDoc_Save, "Save");
				Thread.sleep(800);
				String text = driver.switchTo().alert().getText();
				if (text.contains("is required")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save: before Move document mandatory field alert" + "<br>"
							+ text + " exists </br>");
				} else {
					childTest
							.fail("Verification: Click on Save: before Move document mandatory field alert is missing");
				}
				fm.fnWebEdit(driver, MoveDoc_EntityName, data.getProperty("doc_MoveD_EntityName"), "Entity Name");
				fm.fnWebEdit(driver, MoveDoc_EntityID, data.getProperty("doc_MoveD_EntityNum"), "Entity ID");
				fm.fnWebList(driver, MoveDoc_TaxType, data.getProperty("TaxType"), "Tax Type");
				fm.fnWebList(driver, MoveDoc_FileSection, data.getProperty("doc_FileSection"), "File Section");
				fm.fnWebList(driver, MoveDoc_Year, data.getProperty("Year"), "Year");
				fm.fnWebEdit(driver, MoveDoc_Description, data.getProperty("doc_Description"), "Description");
				fm.fnWebList(driver, MoveDoc_Period, data.getProperty("Period"), "Period");
				fm.fnWebButton(driver, MoveDoc_Save, "Save");
				w.until(ExpectedConditions.alertIsPresent());
				String text1 = driver.switchTo().alert().getText();
				if (text1.contains("Click 'OK' to continue")) {
					Thread.sleep(200);
					driver.switchTo().alert().accept();
					childTest.pass("Verification: Click on Save:Move document confirmation alert 1" + "<br>" + text
							+ " exists </br>");
					Thread.sleep(2000);
					w.until(ExpectedConditions.alertIsPresent());
					String text2 = driver.switchTo().alert().getText();
					if (text2.contains("Document successfully moved and re-indexed")) {
						Thread.sleep(200);
						driver.switchTo().alert().accept();
						childTest.pass("Verification: Click on Save: Move document confirmation alert 2" + "<br>" + text
								+ " exists </br>");
					} else {
						childTest.fail("Verification: Click on Save: Move document confirmation alert 2 is missing");
					}
				} else {
					childTest.fail("Verification: Click on Save: Move document confirmation alert 1 is missing");
				}
			}
		}
	}

	public void fwf_fnDocumentProperties() throws InterruptedException {
		childTest = test
				.createNode("Description: Document Properties " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		if (driver.getTitle().equalsIgnoreCase("Document Properties")) {
			HashMap<By, String> txtCompare = new HashMap<By, String>();
			txtCompare.put(Documents_Description, data.getProperty("doc_Description")); // Description
			txtCompare.put(Documents_FileSection, data.getProperty("doc_FileSection")); // FileSection
			txtCompare.put(Documents_DocumentType, data.getProperty("doc_DocumentType")); // Document Type
			txtCompare.put(Documents_DocumentDate, data.getProperty("doc_DocumentDate")); // Document Date
			txtCompare.put(DocProp_AssignedTo, data.getProperty("doc_AssignedTo")); // Assigned To
			txtCompare.put(DocProp_DocumentStatus, data.getProperty("doc_DocumentStatus")); // Document Status
			txtCompare.put(DocProp_DueDate, data.getProperty("doc_DueDate")); // Due Date

			Set<By> map = txtCompare.keySet();
			for (Iterator<By> i = map.iterator(); i.hasNext();) {
				By key = (By) i.next();
				String value = (String) txtCompare.get(key);
				WebElement wait = new WebDriverWait(driver, 30)
						.until(ExpectedConditions.visibilityOfElementLocated(key));
				if (wait.isDisplayed()) {
					if (driver.findElement(key).getAttribute("value").equals(value)) {
						childTest.log(Status.PASS, value + " is matched.");
					} else {
						Select sel = new Select(driver.findElement(key));
						WebElement currValue = sel.getFirstSelectedOption();
						String option = currValue.getText();
						if (option.equals(value)) {
							childTest.log(Status.PASS, value + " is matched.");
						} else {
							childTest.log(Status.FAIL, value + " is not matched");
						}
					}
				} else {
					childTest.log(Status.FAIL, "Element is not visible");
				}
			}
			fm.fnWebButton(driver, Documents_Save, "Save");
			Thread.sleep(3000);
			WebDriverWait w = new WebDriverWait(driver, 20);
			w.until(ExpectedConditions.alertIsPresent());
			String text2 = driver.switchTo().alert().getText();
			if (text2.contains("Successfully re-indexed Documents: 1")) {
				Thread.sleep(200);
				driver.switchTo().alert().accept();
				childTest.pass("Verification: Click on Save: Move document confirmation alert 1" + "<br>" + text2
						+ " exists </br>");
			} else {
				childTest.fail("Verification: Click on Save: Move document confirmation alert 1 is missing");
			}
		}

	}

	// ------------------Customize View-------------------------------------
	By Doc_CustView_Save = By.xpath("//INPUT[@id='btnSave']");

	public void Doc_Custview_Save() throws InterruptedException {
		fm.fnWebButton(driver, Doc_CustView_Save, "Save");
	}

	public void fwf_fnSavedSearch() throws InterruptedException {
		childTest = test.createNode(
				"Description: Saved Seach/Document Search " + "<br>" + "<< Screen Name: Folder WorkFlows >></br>");
		Thread.sleep(3000);
		if (driver.getTitle().equalsIgnoreCase("Documents Search")) {
			fm.fnWebButton(driver, SavedSearch_Clear, "Clear");
			fm.fnWebList(driver, SavedSearch_Year, data.getProperty("Year"), "Year");
			fm.fnWebList(driver, SavedSearch_Period, data.getProperty("Period"), "Period");
			fm.fnWebList(driver, SavedSearch_TaxType, data.getProperty("TaxType"), "Tax Type");
			fm.fnWebList(driver, SavedSearch_WFTemplate, data.getProperty("WF_Template"), "WF Template");
			// owm.SavedSearch_WfAssociation("");
			fm.fnWebEdit(driver, Documents_EntityName, data.getProperty("Entity_Name"), "Entity Name");
			fm.fnWebEdit(driver, Documents_EntityID, data.getProperty("Entity_Id"), "Entity ID");
			fm.fnWebEdit(driver, Documents_Jurisdiction, data.getProperty("Jurisdiction"), "Jurisdiction");
			fm.fnWebEdit(driver, Documents_Description, data.getProperty("doc_Description"), "Description");
			fm.fnWebList(driver, SavedSearch_FileSection, data.getProperty("doc_FileSection"), "FileSection");
			fm.fnWebList(driver, SavedSearch_DocumentType, data.getProperty("doc_DocumentType"), "Document Type");
			fm.fnWebList(driver, Documents_AssignedTo, data.getProperty("doc_AssignedTo"), "Assigned To");
			fm.fnWebButton(driver, SavedSearch_Close, "Close");
		}
	}

}
