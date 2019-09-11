package com.openmrs.testbase;

import java.util.Scanner;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.openmrs.classpath.Classpath;

public class BrowserInvoke {
	Logger log = Logger.getLogger("utilityfiles");

	public static WebDriver driver;

	public void BrowserSelect() {

		Scanner scan = new Scanner(System.in);
		System.out.println("enter the browser");
		String browser = scan.nextLine();
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
		scan.close();
	}
}