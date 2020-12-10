package com_lib_FunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com_helper_Reporting.ExtentManager;


public class FrameWork extends ExtentManager {
	Object flag = null;

	public void fnWebEdit(WebDriver driver, By element, String text, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).clear();
			Thread.sleep(100);
			driver.findElement(element).sendKeys(text);
			Thread.sleep(1000);
			String enteredText = driver.findElement(element).getAttribute("value");
			if (enteredText.equalsIgnoreCase(text)) {
				Assert.assertTrue(true);
				childTest.log(Status.PASS, label + " = " + text + ".");
				flag = 1;
			} else {
				Assert.assertTrue(false);
				childTest.log(Status.FAIL, label + " = " + text + ".");
				flag = 0;
			}

		} else {
			flag = 0;
		}
	}

	public void fnWebList(WebDriver driver, By element, String text, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			Select listelement = new Select(driver.findElement(element));
			listelement.selectByVisibleText(text);
			Thread.sleep(1000);
			String enteredText = listelement.getFirstSelectedOption().getText();
			if (enteredText.equalsIgnoreCase(text)) {
				Assert.assertTrue(true);
				childTest.log(Status.PASS, label + " = " + text + ".");
				flag = 1;
			} else {
				Assert.assertTrue(false);
				childTest.log(Status.FAIL, label + " = " + text + ".");
				flag = 0;
			}
		} else {
			flag = 0;
		}
	}

	public void fnWebButton(WebDriver driver, By element, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).click();
			Thread.sleep(1000);
			childTest.log(Status.PASS, "Clicked on " + label + ".");
			flag = 1;
		} else {
			flag = 0;
		}
	}

	public void fnWebCheckBox(WebDriver driver, By element, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).click();
			Thread.sleep(2000);
			if (driver.findElement(element).isSelected()) {
				Assert.assertTrue(true);
				childTest.log(Status.PASS, "" + label + " is Checked.");
				flag = 1;
			} else {
				Assert.assertTrue(false);
				childTest.log(Status.FAIL, "" + label + " is Checked.");
				flag = 0;
			}

		} else {
			flag = 0;
		}
	}

}
