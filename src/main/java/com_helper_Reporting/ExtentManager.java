package com_helper_Reporting;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static ExtentTest childTest;

	@BeforeClass
	public static void setExtent() {
		htmlReporter = new ExtentHtmlReporter("./Reports/NewFolderCreation.html");
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("New Folder Creation");
		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.setSystemInfo("Organization", "TechMahindra-TR");
		extent.setSystemInfo("HostName", System.getenv("COMPUTERNAME"));
		extent.attachReporter(htmlReporter);
	}

	@AfterClass
	public static void endReport() {
		extent.flush();

	}
}
