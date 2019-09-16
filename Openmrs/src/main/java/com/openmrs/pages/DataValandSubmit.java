package com.openmrs.pages;

import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.reports.log4j;
import com.openmrs.testbase.BrowserInvoke;
import com.openmrs.utils.UtilityFiles;

public class DataValandSubmit extends BrowserInvoke {
	public static String id, actual, expected;

	boolean displayed;

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	log4j logreports = new log4j();

	// Getting the details from test data excel-sheet and validating with the original 
	//data which is retrieve from automation site 

	public void validationandsubmit(int val) {
		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getname"), 6, 14);
		expected = UtilityFiles.dataresult("Sheet1", "Name", val);
		util.assertequals(actual, expected, "verified Name of the patient");

		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getgender"), 8, 12);
		expected = UtilityFiles.dataresult("Sheet1", "Gender", val);

		util.assertequals(actual, expected, "Verified Gender of the patient");

		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getdob"), 11, 28);
		expected = UtilityFiles.dataresult("Sheet1", "Birthdate", val);
		util.assertequals(actual, expected, "verified Birthdate of the patient");

		util.ClickElement(prop.getValue("locators.record.submit"));

	}
//checking the details of the patient present in the database or not by using patient Id 
	public String PatientSearch(int val) {
		id = UtilityFiles.getactual(prop.getValue("locators.patient.getid"));

		util.ClickElement(prop.getValue("locators.home.icon"));
		util.ClickElement(prop.getValue("locators.patient.search"));
		util.ClickElement(prop.getValue("locators.patient.searchbox"));
		util.entertext(prop.getValue("locators.patient.searchbox"), id);

		actual = UtilityFiles.getactual(prop.getValue("locators.text.record1"));
		expected = UtilityFiles.datares("Sheet1", "Name", val);
		util.assertequals(actual, expected, "verified");

		displayed = util.verifyTrue(UtilityFiles.isDisplayed(prop.getValue("locators.text.record1")), "verified");
		logreports.infoboo(displayed);
		util.ClickElement(prop.getValue("locators.home.icon"));
		return id;

	}
}
