package com_obj_ObjectRepository.CalendarSetup;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_helper_Reporting.ExtentManager;
import com_lib_FunctionLibrary.FrameWork;

public class Holidays extends ExtentManager {

	WebDriver driver;
	FrameWork fm = new FrameWork();
	Properties data;
	Properties template;
	
	//--------------------------------------Holidays Search Criteria
	By CalSetup_Holidays_HolidayName = By.xpath("//*[@id='holiday_name']");
	By CalSetup_Holidays_Country = By.xpath("//*[@id='country_id']");
	//--------------------------------------Holidays Add New
	By CalSetup_Holidays_AddNew_HolidayName = By.xpath("//*[@id='txtHolidayName']");
	By CalSetup_Holidays_AddNew_Country = By.xpath("//*[@id='ddlCountry']");
	By CalSetup_Holidays_AddNew_SelectedDate = By.xpath("//*[@id='txtSelectedDate']");
	By CalSetup_Holidays_AddNew_Add = By.xpath("//*[@id='cmdadd']");
	By CalSetup_Holidays_AddNew_Replace = By.xpath("//*[@id='cmdReplace']");
	By CalSetup_Holidays_AddNew_SelectedDates = By.xpath("//*[@id='lstSelectedDates']");
	By CalSetup_Holidays_AddNew_Remove = By.xpath("//*[@id='cmdRemove']");
	By CalSetup_Holidays_AdddNew_Save = By.xpath("//*[@id='btnSave']");
	By CalSetup_Holidays_AddNew_Cancel = By.xpath("//*[@id='btnCancel']");
}
