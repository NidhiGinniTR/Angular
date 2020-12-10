package com_obj_ObjectRepository.OWM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_lib_FunctionLibrary.FrameWork;

public class Navigations {
	WebDriver driver;
	FrameWork fm = new FrameWork();

	public Navigations(WebDriver driver) {
		this.driver = driver;
	}

	// ----------------WorkflowTabs-----------------------------------------------------------------------------
	By tabWorkFlowBrowser = By.xpath("//td[@id='FolderWorkflows']");
	By tabDocuments = By.xpath("//td[@id='Documents']");
	By tabControlLog = By.xpath("//[@id='ControlLog']");
	By tabCalendar = By.xpath("//td[@id='TAXCAL_SCHEDULE_EVENTS']");
	By tabCalendarSetup = By.xpath("//td[@id='TAXCAL_SETUP']");
	By tabReports = By.xpath("//td[@id='ReportsFlow']");
	By tabDataFlow = By.xpath("//td[@id='ReportsFlow']");
	By tabMyWork = By.xpath("//[@id='MyWork']");
	By tabEntityBrowser = By.xpath("//td[@id='TAXCAL_ENTITYTOPICBROWSER']");
	By tabSetup = By.xpath("//td[@id='Setup']");

	public void tabWorkFlowBrowser() throws InterruptedException {
		fm.fnWebButton(driver, tabWorkFlowBrowser, "WorkFlow Browser Tab");
	}

	public void tabDocuments() throws InterruptedException {
		fm.fnWebButton(driver, tabDocuments, "Documents Tab");
	}

	public void tabControlLog() throws InterruptedException {
		fm.fnWebButton(driver, tabControlLog, "Control Log Tab");
	}

	public void tabCalendar() throws InterruptedException {
		fm.fnWebButton(driver, tabCalendar, "Calendar Tab");
	}

	public void tabCalendarSetup() throws InterruptedException {
		fm.fnWebButton(driver, tabCalendarSetup, "CalendarSetup Tab");
	}

	public void tabReports() throws InterruptedException {
		fm.fnWebButton(driver, tabReports, "Reports Tab");
	}

	public void tabDataFlow() throws InterruptedException {
		fm.fnWebButton(driver, tabDataFlow, "DataFlow Tab");
	}

	public void tabMyWork() throws InterruptedException {
		fm.fnWebButton(driver, tabMyWork, "MyWork Tab");
	}

	public void tabEntityBrowser() throws InterruptedException {
		fm.fnWebButton(driver, tabEntityBrowser, "EntityBrowser Tab");
	}

	public void tabSetup() throws InterruptedException {
		fm.fnWebButton(driver, tabSetup, "Setup Tab");
	}

	// ---------------ActionsButton------------------------------------------------------------------------------
	By Actions = By.xpath("//span[@id='spActions']");
	By ftrClear = By.xpath("//*[@id='btnCancel' and @title='Clear']");

	public void filterClear() throws InterruptedException {
		fm.fnWebButton(driver, ftrClear, "Clear");
	}

	public void Actions() throws InterruptedException {
		fm.fnWebButton(driver, Actions, "Actions");
	}

}
