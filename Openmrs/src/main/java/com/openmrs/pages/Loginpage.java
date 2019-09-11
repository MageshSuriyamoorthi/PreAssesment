package com.openmrs.pages;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import org.openqa.selenium.Keys;
import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.testbase.BrowserInvoke;
import com.openmrs.utils.UtilityFiles;

public class Loginpage {
	String name, id, data;

	BrowserInvoke browser = new BrowserInvoke();

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();

	public void openmrsdemo() throws FileNotFoundException {
		util.geturl(prop.readPropertiesFile("locators.url"));
		util.maximize();
	}

	public void logincredentials() throws FileNotFoundException {
		util.entertext(prop.readPropertiesFile("locators.text.uname"), "admin");
		util.entertext(prop.readPropertiesFile("locators.text.password"), "Admin123");
		util.ClickElement(prop.readPropertiesFile("locators.button.regdesk"));
		util.ClickElement(prop.readPropertiesFile("locators.button.login"));
	}

	public void RegistratioEntry() throws FileNotFoundException {
		util.ClickElement(prop.readPropertiesFile("locators.register.click"));
	}

	public void OPEntry() throws FileNotFoundException {
		util.entertext(prop.readPropertiesFile("locators.patient.name"), "AAA");
		util.tab(prop.readPropertiesFile("locators.patient.name"), Keys.TAB);
		util.tab(prop.readPropertiesFile("locators.patient.middlename"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.familyname"), "BBB");
		util.tab(prop.readPropertiesFile("locators.patient.familyname"), Keys.TAB);
		util.ClickElement(prop.readPropertiesFile("locators.patient.gendermale"));
		util.tab(prop.readPropertiesFile("locators.patient.gender"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.date"), "12");
		util.tab(prop.readPropertiesFile("locators.patient.date"), Keys.TAB);
		util.selectDropdown(prop.readPropertiesFile("locators.patient.month"), 2);
		util.tab(prop.readPropertiesFile("locators.patient.month"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.year"), "2000");
		util.tab(prop.readPropertiesFile("locators.patient.year"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.address"), "VVV");
		util.tab(prop.readPropertiesFile("locators.patient.address"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.address2"), "WWW");
		util.tab(prop.readPropertiesFile("locators.patient.address2"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.address3"), "XXX");
		util.tab(prop.readPropertiesFile("locators.patient.address3"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.address4"), "YYY");
		util.tab(prop.readPropertiesFile("locators.patient.address4"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.address5"), "ZZZ");
		util.tab(prop.readPropertiesFile("locators.patient.address5"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.postalcode"), "999999");
		util.tab(prop.readPropertiesFile("locators.patient.postalcode"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.phonenumber"), "9999999999");
		util.tab(prop.readPropertiesFile("locators.patient.phonenumber"), Keys.TAB);
		/*
		 * util.tab("//span[text()='Relatives']", Keys.TAB);
		 * util.tab("//span[text()='Relatives']", Keys.TAB);
		 */
		util.selectDropdown(prop.readPropertiesFile("locators.patient.relation"), 3);
		util.tab(prop.readPropertiesFile("locators.patient.relation"), Keys.TAB);
		util.entertext(prop.readPropertiesFile("locators.patient.relationname"), "BBB");
		util.tab(prop.readPropertiesFile("locators.patient.relationname"), Keys.TAB);

	}

	public void validation() throws FileNotFoundException {
		name = util.getPId("//div[@id='dataCanvas']");
		data = prop.readTestDataFiles("test.data");
		util.assertequals(name, data, "passed");

	}

	public void submit() throws FileNotFoundException {
		util.ClickElement("//input[@id='submit']");
		id = UtilityFiles.getPId("locators.patient.getid");
	}

	public void validate() throws FileNotFoundException {
		UtilityFiles.getexpected("*");
	}

	public void returnHome() throws FileNotFoundException {
		util.ClickElement("//i[@class='icon-home small']");
	}

	public void findPatientRecord() throws FileNotFoundException {
		util.ClickElement(prop.readPropertiesFile("locators.patient.search"));
		// util.ClickElement(prop.readPropertiesFile("locators.patient.searchbox"));
		util.entertext("locators.patient.searchbox", id);
		util.verifyTrue(util.isDisplayed("locators.get.patientdetails"), "Verified patient present in the table");
	}

	public void dataManagement() throws FileNotFoundException {
		util.ClickElement(prop.readPropertiesFile("locators.datamanagement.click"));
		util.ClickElement(prop.readPropertiesFile("locators.merge.records"));
		util.ClickElement(prop.readPropertiesFile("locators.merge.records"));
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