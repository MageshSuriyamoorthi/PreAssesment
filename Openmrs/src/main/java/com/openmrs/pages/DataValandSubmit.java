package com.openmrs.pages;

import java.util.ArrayList;
import java.util.List;

import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.utils.UtilityFiles;

public class DataValandSubmit {
	public static String id,  actual, expected;

	boolean displayed;

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();

	public void validationandsubmit(int val) {
		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getname"), 6, 14);
		expected = UtilityFiles.dataresult("Sheet1", "Name", val);
		util.assertequals(actual, expected, "verified Name of the patient");

		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getgender"), 8, 12);
		expected = UtilityFiles.dataresult("Sheet1", "Gender", val);

		util.assertequals(actual, expected, "Verified Gender of the patient");

		actual = UtilityFiles.expectedresult(prop.getValue("locators.record.getdob"), 11, 26);
		expected = UtilityFiles.dataresult("Sheet1", "Birthdate", val);

		util.assertequals(actual, expected, "verified Birthdate of the patient");

		util.ClickElement(prop.getValue("locators.record.submit"));

	}

	public String PatientSearch() {
		id = UtilityFiles.getactual(prop.getValue("locators.patient.getid"));
		
		util.ClickElement(prop.getValue("locators.home.icon"));
		util.ClickElement(prop.getValue("locators.patient.search"));
		util.ClickElement(prop.getValue("locators.patient.searchbox"));
		util.entertext(prop.getValue("locators.patient.searchbox"), id);

		displayed=util.verifyTrue(UtilityFiles.isDisplayed(prop.getValue("locators.get.patientdetails")),"verified");
		
		util.ClickElement(prop.getValue("locators.home.icon"));
		return id;

	}
}
