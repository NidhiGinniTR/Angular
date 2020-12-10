package com_obj_ObjectRepository.LS1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com_lib_FunctionLibrary.FrameWork;


public class OneSourceDashboard {
	WebDriver driver;
	FrameWork fm = new FrameWork();
	public OneSourceDashboard(WebDriver driver) {
		this.driver=driver;
	}
	
	By Applications = By.id("btnApps");
	/*By appCalendar =  By.xpath("//*[@id='appsMenu']/table/tbody/tr[1]"); 
	By appCheckpointLearning = By.xpath("//*[@id='appsMenu']/table/tbody/tr[2]"); 
	By appCheckpointworld = By.xpath("//*[@id='appsMenu']/table/tbody/tr[3]");
	By appDataflow = By.xpath("//*[@id='appsMenu']/table/tbody/tr[4]");
	By appEntitymanager = By.xpath("//*[@id='appsMenu']/table/tbody/tr[5]");
	By appFileroom = By.xpath("//*[@id='appsMenu']/table/tbody/tr[6]");
	By appMywork = By.xpath("//*[@id='appsMenu']/table/tbody/tr[7]");
	By appWorkflowmanager = By.xpath("//*[@id='appsMenu']/table/tbody/tr[8]");*/
	
	
	
	public void appMenuSelection(String Temp) throws InterruptedException {
		By appMenuItem = By.xpath("//*[@id='appsMenu']//*[contains(text(),'"+Temp+"')]");
		fm.fnWebButton(driver, appMenuItem, Temp);
	}
	
	public void launchApplications() throws InterruptedException {
		fm.fnWebButton(driver, Applications,"Applications");
	}
	
	/*public void appCalendar() throws InterruptedException {
		
			
		fm.fnWebButton(driver, appCalendar,"Calendar");
	}
	
	public void appCheckpointLearning() throws InterruptedException {
		

		fm.fnWebButton(driver, appCheckpointLearning,"Checkpoint Learning");
	}
	
	public void appCheckpointworld() throws InterruptedException {
		
		fm.fnWebButton(driver, appCheckpointworld,"Checkpoint World");
	}
	
	public void appDataflow() throws InterruptedException {
		
	
		fm.fnWebButton(driver, appDataflow,"Data Flow");
	}
	
	public void appEntitymanager() throws InterruptedException {
		

		fm.fnWebButton(driver, appEntitymanager,"Entity Manager");
	}
	
	public void appFileroom() throws InterruptedException {
		

		fm.fnWebButton(driver, appFileroom,"File Room");
	}
	
	public void appMywork() throws InterruptedException {
		
		fm.fnWebButton(driver, appMywork,"My Work");
	}
	
	public void appWorkflowmanager() throws InterruptedException {
		fm.fnWebButton(driver, appWorkflowmanager,"WorkFlow Manager");
	}*/

}
