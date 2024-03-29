package com.openmrs.pages;

import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.reports.log4j;
import com.openmrs.testbase.BrowserInvoke;
import com.openmrs.utils.UtilityFiles;

public class Loginpage {
	public static String actual, id, list;
	log4j logreport = new log4j();

	BrowserInvoke browser = new BrowserInvoke();

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
//Url is loaded from .properties file
	public void openmrsdemo() {
		util.geturl(prop.getValue("locators.url"));
		logreport.info("Url loaded");
		util.maximize();
	}
//login credentials were entered and registration location is clicked and logged in
	public void logincredentials() {
		util.entertext(prop.getValue("locators.text.uname"), "admin");
		util.entertext(prop.getValue("locators.text.password"), "Admin123");
		util.ClickElement(prop.getValue("locators.button.regdesk"));
		util.ClickElement(prop.getValue("locators.button.login"));
		logreport.info("logged into the application");

	}
//OP register button is clicked
	public void patientsCredentials() {
		util.ClickElement(prop.getValue("locators.register.click"));
		logreport.info("Patient registration is clicked");
	}
}

/*
 * String name=util.driver.findElement(By.xpath(
 * "//h1//span[@class='PersonName-givenName']")).getText();
 * System.out.println(name); assertEquals("AAA", name);
 */

//	util.closeDriver();

//div[@id="dataCanvas"]//div//p[1]//text())[2]

//Most Important:

/*
 * util.verifyTrue(util.
 * isDisplayed("//div[@id='dataCanvas']//p[text()='AAA, BBB']"),
 * "Verified Name of the patient");
 * util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='Male']")
 * , "Verified gender of the patient"); util.verifyTrue(util.
 * isDisplayed("//div[@id='dataCanvas']//p[text()='12, February, 2000']"),
 * "Verified DOB of the patient"); util.verifyTrue(util.
 * isDisplayed("//div[@id='dataCanvas']//p[text()='VVV, WWW, XXX, YYY, ZZZ, 999999']"
 * ), "Verified Address of the patient"); util.verifyTrue(util.isDisplayed(
 * "//div[@id='dataCanvas']//p[text()='9999999999']"),
 * "Verified ContactNo of the patient"); util.verifyTrue(util.
 * isDisplayed("//div[@id='dataCanvas']//p[text()='BBB - Parent']"),
 * "Verified relation type of the patient");
 */

//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p"),
//		"Verified Name of the patient");
//
//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='Male']"),
//		"Verified gender of the patient");
//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='12, February, 2000']"),
//		"Verified DOB of the patient");
//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='VVV, WWW, XXX, YYY, ZZZ, 999999']"),
//		"Verified Address of the patient");
//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='9999999999']"),
//		"Verified ContactNo of the patient");
//util.verifyTrue(util.isDisplayed("//div[@id='dataCanvas']//p[text()='BBB - Parent']"),
//		"Verified relation type of the patient");
//
//util.assertequals(actual, contents, "passed");
