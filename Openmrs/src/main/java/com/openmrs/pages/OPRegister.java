package com.openmrs.pages;

import com.openmrs.classpath.Classpath;
import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.helper.XlxsReader;
import com.openmrs.reports.log4j;
import com.openmrs.utils.UtilityFiles;

public class OPRegister {

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	log4j logreport=new log4j();
	public static XlxsReader reader = UtilityFiles.getXlsReader(Classpath.Excel_file1);
//Giving the details of the patient name form excel sheet
	public void OPEntry(int val) {

		util.enterText(prop.getValue("locators.patient.name"), "Fname", val);
		logreport.info("Firstname Entered");
		util.tab(prop.getValue("locators.patient.name"));
		util.tab(prop.getValue("locators.patient.middlename"));
		util.enterText(prop.getValue("locators.patient.familyname"), "Lname", val);
		logreport.info("Last name entered");
		util.tab(prop.getValue("locators.patient.familyname"));
		util.enterText(prop.getValue("locators.patient.gender"), "Gender", val);
		logreport.info("Gender clicked");
		util.tab(prop.getValue("locators.patient.gender"));
		util.enterText(prop.getValue("locators.patient.date"), "Date", val);
		util.tab(prop.getValue("locators.patient.date"));
		util.selectbyvisibility(prop.getValue("locators.patient.month"),"Month", val);
		util.tab(prop.getValue("locators.patient.month"));
		util.enterText(prop.getValue("locators.patient.year"), "Year", val);
		logreport.info("Date-of-Birth entered for the patient ");
		util.tab(prop.getValue("locators.patient.year"));
		util.enterText(prop.getValue("locators.patient.address"), "Address", val);
		util.tab(prop.getValue("locators.patient.address"));
		util.enterText(prop.getValue("locators.patient.address2"), "Address2", val);
		util.tab(prop.getValue("locators.patient.address2"));
		util.enterText(prop.getValue("locators.patient.address3"), "Address3", val);
		util.tab(prop.getValue("locators.patient.address3"));
		util.enterText(prop.getValue("locators.patient.address4"), "Address4", val);
		util.tab(prop.getValue("locators.patient.address4"));
		util.enterText(prop.getValue("locators.patient.address5"), "Address5", val);
		util.tab(prop.getValue("locators.patient.address5"));
		util.enterText(prop.getValue("locators.patient.postalcode"), "Pin", val);
		logreport.info("Entered address of the patient");
		util.tab(prop.getValue("locators.patient.postalcode"));
		util.entertext(prop.getValue("locators.patient.phonenumber"), "9999999999");
		logreport.info("Phone number entered");
		util.tab(prop.getValue("locators.patient.phonenumber"));
		util.enterText(prop.getValue("locators.patient.relation"), "Relation Type", val);
		util.tab(prop.getValue("locators.patient.relation"));
		util.enterText(prop.getValue("locators.patient.relationname"), "Rname", val);
		logreport.info("Patient relations details were given");
		util.tab(prop.getValue("locators.patient.relationname"));

	}

}
