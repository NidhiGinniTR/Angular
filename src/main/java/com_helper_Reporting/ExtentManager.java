package com_helper_Reporting;

import java.io.File;
import java.util.Date;
import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_data_Resources.Environment.BrowserInvoke;

public class ExtentManager extends BrowserInvoke{

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;
	

	@BeforeClass
	public static ExtentReports createInstance() {
		String fileName = getReportName();
		String directory = System.getProperty("user.dir") + "/reports.html/";
		new File(directory).mkdirs();
		String path = directory + fileName;
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(path);
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Automation-QA");
		htmlReporter.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "TechMahindra-TR");
		extent.setSystemInfo("HostName", System.getenv("COMPUTERNAME"));
		extent.attachReporter(htmlReporter);
		
		return extent;
	}

	public static String getReportName() {
		Date d = new Date();
		String fileName = "Automation Report" + "-" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
		return fileName;
	}
	
	@AfterClass
	public static void endReport() {
		extent.flush();

	}
}
