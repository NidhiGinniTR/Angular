package com_obj_ObjectRepository.FolderWorkFlows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_lib_FunctionLibrary.FrameWork;

public class NavigationTabs {
	WebDriver driver;
	FrameWork fm = new FrameWork();

	public NavigationTabs(WebDriver driver) {
		this.driver = driver;
	}
	
	// ----------------Folder Workflow Tabs-----------------------------------------------------------------------------
	/*By fwf_Tasks = By.xpath("//*[@id='TabStrip1_0']");
	By fwf_Events = By.xpath("//*[@id='TabStrip1_1']");
	By fwf_Documents = By.xpath("//*[@id='TabStrip1_2']");
	By fwf_Dataflow = By.xpath("//*[@id='TabStrip1_3']");
	By fwf_Checklist = By.xpath("//*[@id='TabStrip1_5']");
	By fwf_DeliveryInstruction = By.xpath("//*[@id='TabStrip1_6']");
	By fwf_Notes = By.xpath("//*[@id='TabStrip1_7']");
	By fwf_Reasearch = By.xpath("//*[@id='TabStrip1_8']");
	By fwf_CustomForms = By.xpath("//*[@id='TabStrip1_9']");*/
	
	public void fwf_tabSelection(String text) throws InterruptedException{
		By tabItem = By.xpath("//*[@id='TabStrip1']//*[contains(text(),'"+text+"')]");
		fm.fnWebButton(driver, tabItem, text);
	}
	
	/*public void fwf_Tasks() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Tasks, "Task");
	}
	
	public void fwf_Events() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Events, "Events");
	}
	
	public void fwf_Documents() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Documents, "Documents");
	}
	
	public void fwf_Dataflow() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Dataflow, "Dataflow");
	}
	
	public void fwf_Checklist() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Checklist, "Checklist");
	}
	
	public void fwf_DeliveryInstruction() throws InterruptedException {
		fm.fnWebButton(driver, fwf_DeliveryInstruction, "Delivery Instruction");
	}
	
	public void fwf_Notes() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Notes, "Notes");
	}
	
	public void fwf_Reasearch() throws InterruptedException {
		fm.fnWebButton(driver, fwf_Reasearch, "Reasearch");
	}
	
	public void fwf_CustomForms() throws InterruptedException {
		fm.fnWebButton(driver, fwf_CustomForms, "Custom Forms");
	}*/
}
