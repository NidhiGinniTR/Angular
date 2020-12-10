package com_obj_ObjectRepository.LS1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_lib_FunctionLibrary.FrameWork;

public class OneSourceLogin {
	// POM for Onesource login page
	WebDriver driver;
	FrameWork fm = new FrameWork();

	public OneSourceLogin(WebDriver driver) {
		this.driver = driver;
	}

	By UserName = By.xpath("//input[@id='_txtLogin']"); // Locator for UserName in onesource login page
	By Password = By.xpath("//INPUT[@id='_txtPassword']"); // Locator for password in onesource login page
	By SignOn = By.xpath("//INPUT[@id='btnSignIn']"); // Locator for Sign-On button in onesource login page
	By EngUS = By.xpath("//A[@id='en']"); // Locator for English(US) reload button

	public void enterUsername(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, UserName, temp, "UniversalID");
	}

	public void enterPassword(String temp) throws InterruptedException {
		fm.fnWebEdit(driver, Password, temp, "Password");
	}

	public void clickonSignIn() throws InterruptedException {

		fm.fnWebButton(driver, SignOn, "SignIn");
	}

	public void reloadPage() throws InterruptedException {
		fm.fnWebButton(driver, EngUS, "English-US");
	}

}
