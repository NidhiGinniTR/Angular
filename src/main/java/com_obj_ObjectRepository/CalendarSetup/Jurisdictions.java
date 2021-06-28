package com_obj_ObjectRepository.CalendarSetup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Jurisdictions {
	WebDriver driver;

	public Jurisdictions(WebDriver driver) {
		this.driver = driver;
	}

	/************************** CalendarSetUP Juridictions *********/
	By CalSetup_Jurisdiction_Country = By.xpath("//select[@id='ddlCountry']");
	By CalSetup_Jurisdiction_StateProvince = By.xpath("//select[@id='ddlStateProvince']");
	By CalSetup_Jurisdiction_Category = By.xpath("//select[@id='ddlCategory']");
	By CalSetup_Jurisdiction_JurisdictionCode = By.xpath("//input[@id='txtJurisdictionCode']");
	By CalSetup_Jurisdiction_JurisdictionName = By.xpath("//input[@id='txtDescription']");
	By CalSetup_Jurisdiction_Holiday = By.xpath("//select[@id='ddlAvailHolidays']");
	By CalSetup_Jurisdiction_Availbilitybutton = By.xpath("//span[@id='lblActive']");
	By CalSetup_Jurisdiction_Save = By.xpath("//input[@id='btnSave']");
	By CalSetup_Jurisdiction_Cancel = By.xpath("//input[@id='btnCancel']");

	/************************** Juridictions Search criteria *********/
	By CalSetup_JurisdictionCriteria_Country = By.xpath("//select[@id='tcj_country_id']");
	By CalSetup_JurisdictionCriteria_StateProvince = By.xpath("//select[@id='tcj_category_id']");
	By CalSetup_JurisdictionCriteria_Category = By.xpath("//select[@id='tcj_state_province_id']");
	By CalSetup_JurisdictionCriteria_JurisdictionCode = By.xpath("//input[@id='tcj_code']");
	By CalSetup_JurisdictionCriteria_JurisdictionName = By.xpath("//input[@id='tcj_description']");
	By CalSetup_JurisdictionCriteria_Search = By.xpath("//input[@id='btnSearch']");
	By CalSetup_JurisdictionCriteria_Clear = By.xpath("//input[@id='btnCancel']");

}
