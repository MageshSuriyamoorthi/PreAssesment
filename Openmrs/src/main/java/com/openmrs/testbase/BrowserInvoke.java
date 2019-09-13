package com.openmrs.testbase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.openmrs.classpath.Classpath;
import com.openmrs.helper.ReadpropertiesFile;

public class BrowserInvoke {
	Logger log = Logger.getLogger("utilityfiles");
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	public static WebDriver driver;
	String browser;

	public void BrowserSelect() {
		browser = prop.getValue("browsername");

		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("Webdriver.chrome.driver", Classpath.Chrome_file);
			driver = new ChromeDriver();
			log.info("chrome has started");

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("Webdriver.gecko.driver", Classpath.Firefox_file);
			driver = new FirefoxDriver();
		}

		else if (browser.equalsIgnoreCase("internetexplorer")) {
			System.setProperty("webdriver.edge.driver", Classpath.IE_file);
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", Classpath.Edge_file);
			driver = new EdgeDriver();
		}
		// properties.loadproperty("browser").
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public void BrowserClose() {
		driver.close();
	}
}