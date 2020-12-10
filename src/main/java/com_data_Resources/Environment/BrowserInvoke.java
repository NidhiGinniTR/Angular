package com_data_Resources.Environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserInvoke {
	public WebDriver driver;
	public Properties propData;
	public Properties propEnv, propParallelData;

	public WebDriver InvokeDriver() throws IOException {

		propData = new Properties();
		// InputStream stream
		// =getClass().getResourceAsStream("environmentFile.properties");
		FileInputStream data = new FileInputStream(".\\src\\main\\java\\resources\\newFolderdata.properties");
		FileInputStream paralleldata = new FileInputStream(
				".\\src\\main\\java\\resources\\paralleltemplatedata.properties");
		FileInputStream launchandLogin = new FileInputStream(
				".\\src\\main\\java\\resources\\environmentFile.properties");
		propEnv = new Properties();
		propEnv.load(launchandLogin);
		propData.load(data);
		propParallelData = new Properties();
		propParallelData.load(paralleldata);
		String BrowserName = propEnv.getProperty("Browser");
		switch (BrowserName) {
		case "IE":
			// System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+System.getProperty("file.seperator")+"IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumDrivers\\IEDriverServer.exe");
			// WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			System.out.println("Browser " + BrowserName + " is Initialized");
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Browser " + BrowserName + " is Initialized");
			break;
		case "Firefox":
		case "Edge":

		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

}
