package com_data_Resources.Environment;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BrowserInvoke {
	public WebDriver driver;
	public Properties propData;
	public Properties propEnv, propSerialData;

	public WebDriver InvokeDriver() throws IOException {

		propData = new Properties();
		// InputStream stream
		// =getClass().getResourceAsStream("environmentFile.properties");
		//FileInputStream data = new FileInputStream(".\\src\\main\\java\\resources\\newFolderdata.properties");
		FileInputStream serialdata = new FileInputStream(
				".\\src\\main\\java\\com_data_Resources\\Environment\\Serialtemplatedata.properties");
		FileInputStream launchandLogin = new FileInputStream(
				".\\src\\main\\java\\com_data_Resources\\Environment\\environmentFile.properties");
		propEnv = new Properties();
		propEnv.load(launchandLogin);
		//propData.load(data);
		propSerialData = new Properties();
		propSerialData.load(serialdata);
		String BrowserName = propEnv.getProperty("Browser");
		switch (BrowserName) {
		case "IE":
			// System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+System.getProperty("file.seperator")+"IEDriverServer.exe");
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumDrivers\\IEDriverServer.exe");
			// WebDriverManager.iedriver().setup();
			DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
	        capability.setCapability("ignoreZoomSetting", true);
	        capability.setCapability(InternetExplorerDriver.
	            INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	        driver = new InternetExplorerDriver();
	        //WebDriver driver = new RemoteWebDriver();
	        System.setProperty("webdriver.ie.whitelistedips", "10.21.4.117");
			driver = new InternetExplorerDriver();
			System.out.println("Browser " + BrowserName + " is Initialized");
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDrivers\\chromedriver.exe");
			System.setProperty("webdriver.chrome.whitelistedIps", "");
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
