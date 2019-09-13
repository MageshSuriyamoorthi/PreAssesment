package com.openmrs.pages;

import org.openqa.selenium.Keys;

import com.openmrs.classpath.Classpath;
import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.helper.XlxsReader;
import com.openmrs.utils.UtilityFiles;

public class OPRegister {

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	public static XlxsReader reader = UtilityFiles.getXlsReader(Classpath.Excel_file1);

	public void OPEntry(int val) {

		util.enterText(prop.getValue("locators.patient.name"), "Fname", val);
		util.tab(prop.getValue("locators.patient.name"), Keys.TAB);
		util.tab(prop.getValue("locators.patient.middlename"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.familyname"), "Lname", val);
		util.tab(prop.getValue("locators.patient.familyname"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.gender"), "Gender", val);
		// util.ClickElement(prop.getValue("locators.patient.gendermale"));
		util.tab(prop.getValue("locators.patient.gender"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.date"), "Date", val);
		util.tab(prop.getValue("locators.patient.date"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.month"), "Month", val);
		util.tab(prop.getValue("locators.patient.month"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.year"), "Year", val);
		util.tab(prop.getValue("locators.patient.year"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.address"), "Address", val);
		util.tab(prop.getValue("locators.patient.address"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.address2"), "Address2", val);
		util.tab(prop.getValue("locators.patient.address2"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.address3"), "Address3", val);
		util.tab(prop.getValue("locators.patient.address3"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.address4"), "Address4", val);
		util.tab(prop.getValue("locators.patient.address4"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.address5"), "Address5", val);
		util.tab(prop.getValue("locators.patient.address5"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.postalcode"), "Pin", val);
		util.tab(prop.getValue("locators.patient.postalcode"), Keys.TAB);
		util.entertext(prop.getValue("locators.patient.phonenumber"), "9999999999");
		util.tab(prop.getValue("locators.patient.phonenumber"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.relation"), "Relation Type", val);
		util.tab(prop.getValue("locators.patient.relation"), Keys.TAB);
		util.enterText(prop.getValue("locators.patient.relationname"), "Rname", val);
		util.tab(prop.getValue("locators.patient.relationname"), Keys.TAB);

	}

}
