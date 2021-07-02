package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.Status;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class Holidays extends ExtentManager {

	WebDriver driver;
	Properties data;
	Properties template;

	public Holidays(WebDriver driver, Properties data) {
		this.driver = driver;
		this.template = data;
	}

	// --------------------------------------Holidays Search Criteria
	By CalSetup_Holidays_HolidayName = By.xpath("//*[@id='holiday_name']");
	By CalSetup_Holidays_Country = By.xpath("//*[@id='country_id']");
	// --------------------------------------Holidays Add New
	By CalSetup_Holidays_AddNew_HolidayName = By.xpath("//*[@id='txtHolidayName']");
	By CalSetup_Holidays_AddNew_Country = By.xpath("//*[@id='ddlCountry']");
	By CalSetup_Holidays_AddNew_SelectedDate = By.xpath("//*[@id='txtSelectedDate']");
	By CalSetup_Holidays_AddNew_Add = By.xpath("//*[@id='cmdadd']");
	By CalSetup_Holidays_AddNew_Replace = By.xpath("//*[@id='cmdReplace']");
	By CalSetup_Holidays_AddNew_SelectedDates = By.xpath("//*[@id='lstSelectedDates']");
	By CalSetup_Holidays_AddNew_Remove = By.xpath("//*[@id='cmdRemove']");
	By CalSetup_Holidays_AdddNew_Save = By.xpath("//*[@id='btnSave']");
	By CalSetup_Holidays_AddNew_Cancel = By.xpath("//*[@id='btnCancel']");

	// ------------------------------------------------------------------

	FrameWork fm = new FrameWork();
	
	

	public void CalSetup_AddNewHoliday() {
		childTest = test.createNode("Description: Add New Holiday Window " + "<br>"
				+ "<<Screen Name: Calendar Setup - Holidays - Add New >></br>");
		try {
			fm.fnWebButton(driver, CalSetup_Holidays_AdddNew_Save, "Save");
			String popuptext = driver.switchTo().alert().getText();
			if (popuptext.contains("Please enter all required fields") || !popuptext.isEmpty()) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS,
						"Verification: Click on Save without entering details'" + popuptext + "' Alert/Message exists");
			} else {
				childTest.log(Status.ERROR,
						"Verification: Click on Save without entering details, Alert/Message is missing");
			}
			fm.fnWebEdit(driver,CalSetup_Holidays_AddNew_HolidayName ,data.getProperty("HolidayName"),"Holiday Name");
			fm.fnWebList(driver,CalSetup_Holidays_AddNew_Country ,data.getProperty("Holiday_Country"),"Country/Region");
			fm.fnWebEdit(driver, CalSetup_Holidays_AddNew_SelectedDate,data.getProperty("Holiday_SelectedDate"),"Selected Date");
			fm.fnWebButton(driver, CalSetup_Holidays_AddNew_Add, "Add");
			Thread.sleep(500);
			String text =getCalSetup_Holidays_AddNew_SelectedDates();
			if(text.contains(data.getProperty("Holiday_SelectedDate"))) {
				childTest.log(Status.INFO,"Selected date '"+data.getProperty("Holiday_SelectedDate")+"' has been added");
			}else {
				childTest.log(Status.ERROR,"Selected date '"+data.getProperty("Holiday_SelectedDate")+"' has not been added");
			}
			fm.fnWebButton(driver, CalSetup_Holidays_AdddNew_Save, "Save");
			Thread.sleep(1500);
			String popuptext1 = driver.switchTo().alert().getText();
			if (popuptext1.contains("The Holiday has been successfully saved.") || popuptext.isEmpty()) {
				driver.switchTo().alert().accept();
				childTest.log(Status.PASS,
						"Verification: Click on Save after entering details'" + popuptext1 + "' Alert/Message exists");
			} else {
				childTest.log(Status.ERROR,
						"Verification: Click on Save after entering details, Alert/Message is missing");
			}
			
		} catch (Exception e) {
			childTest.fail(e);
		}
	}



	private String getCalSetup_Holidays_AddNew_SelectedDates() {
		return driver.findElement(CalSetup_Holidays_AddNew_SelectedDates).getText();
	}

}
