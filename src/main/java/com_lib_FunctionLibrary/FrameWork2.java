package com_lib_FunctionLibrary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

//import org.testng.Assert;
import com.aventstack.extentreports.Status;
import com_helper_Reporting.ExtentManager;


public class FrameWork2 extends ExtentManager {
	Object flag = null;
	WebDriver driver;
	
	public void fnWebEdit(WebDriver driver,By element, String text, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).clear();
			Thread.sleep(100);
			driver.findElement(element).sendKeys(text);
			Thread.sleep(500);
			String enteredText = driver.findElement(element).getAttribute("value");
			if (enteredText.equalsIgnoreCase(text)) {
				//Assert.assertTrue(true);
				childTest.log(Status.PASS, label + " = " + text + ".");
			} else {
				//Assert.assertTrue(false);
				childTest.log(Status.FAIL, label + " = " + text + ".");
			}
		}
	}

	public void fnWebList(WebDriver driver,By element, String text, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			Select listelement = new Select(driver.findElement(element));
			listelement.selectByVisibleText(text);
			Thread.sleep(500);
			String enteredText = listelement.getFirstSelectedOption().getText();
			if (enteredText.equalsIgnoreCase(text)) {
				//Assert.assertTrue(true);
				childTest.log(Status.PASS, label + " = " + text + ".");
			} else {
				//Assert.assertTrue(false);
				childTest.log(Status.FAIL, label + " = " + text + ".");
				
			}
		}
	}

	public void fnWebButton(WebDriver driver,By element, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).click();
			Thread.sleep(500);
			childTest.log(Status.PASS, "Clicked on " + label + ".");
		}
	}

	public void fnWebCheckBox(WebDriver driver,By element, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
			driver.findElement(element).click();
			Thread.sleep(500);
			if (driver.findElement(element).isSelected()) {
				//Assert.assertTrue(true);
				childTest.log(Status.PASS, "" + label + " is Checked.");
				flag = 1;
			} else {
				//Assert.assertTrue(false);
				childTest.log(Status.FAIL, "" + label + " is Checked.");
				flag = 0;
			}
		}
	}
	
	public static void fnWebTable(WebDriver driver,WebElement oParent, String operation) {
		Actions action = new Actions(driver);
		switch (operation) {
		case "Click":
			action.moveToElement(oParent).click().build().perform();
			break;
		case "DoubleClick":
			action.moveToElement(oParent).doubleClick().build().perform();
			break;
		}
	}
	
	public void fnWebEditCompare(WebDriver driver,By element,String text,String label) {
        WebElement wait = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(element));
        if (wait.isDisplayed()) {
            String enteredText = driver.findElement(element).getAttribute("value");
            if (enteredText.equalsIgnoreCase(text)) {
                childTest.log(Status.PASS, label + " = '" + text + "' is matched.");
            } else {
                childTest.log(Status.FAIL, label + " = '" + text + "' is not matched.");
            }

 

        } else {
            childTest.log(Status.FAIL, "Element is either notvisible or displayed.");
        }

 

    }
	
	public void fnWebListCompare(WebDriver driver, By element, String text, String label) throws InterruptedException {
		WebElement wait = new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOfElementLocated(element));
		if (wait.isDisplayed()) {
		Select listelement = new Select(driver.findElement(element));
		String enteredText = listelement.getFirstSelectedOption().getText();
		if (enteredText.equalsIgnoreCase(text)) {
		childTest.log(Status.PASS, label + " = '" + text + "' is matched.");
		} else {
		Assert.assertTrue(false);
		childTest.log(Status.FAIL, label + " = '" + text + "' is not matched.");
		}
		}

		 

	}
}
