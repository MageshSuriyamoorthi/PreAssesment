package com.openmrs.pages;

import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.reports.log4j;
import com.openmrs.utils.UtilityFiles;

public class DataManagement {
	public static String actual, expected;

	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	log4j logreports = new log4j();

//managing the record by merging them to gether
	public void datamanagement() {
		util.ClickElement(prop.getValue("locators.datamanagement.click"));
		util.ClickElement(prop.getValue("locators.merge.records"));
		util.ClickElement(prop.getValue("locators.search.record"));
		logreports.info("data merge button is clicked");
	}

	public void datamerge() {
		util.entertext(prop.getValue("locators.search.record"), "AAA");
		util.arrowdown(prop.getValue("locators.search.record"));
		util.enter(prop.getValue("locators.search.record"));

		util.backspace(prop.getValue("locators.search.record"));
		util.backspace(prop.getValue("locators.search.record"));
		util.backspace(prop.getValue("locators.search.record"));

		util.entertext(prop.getValue("locators.search.record"), "QQQ");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		util.arrowdown(prop.getValue("locators.search.record"));
		util.enter(prop.getValue("locators.search.record"));

		// util.ClickElement(prop.getValue("locators.text.record1"));
		util.ClickElement(prop.getValue("locators.continue.button"));
		logreports.info("data merge is done");
	}

//Validating the record by using patient id 
	public void mergerecords() {
		util.ClickElement(prop.getValue("locators.merge.confirm"));
		logreports.info("merge is done");

		util.ClickElement(prop.getValue("locators.merge.patientid"));
		util.ClickElement(prop.getValue("locators.merge.confirm"));
		/*
		 * boolean displayed = util.verifyTrue(UtilityFiles.isDisplayed(prop.getValue(
		 * "locators.merge.patientid")), "verified");
		 */// logreports.infoboo(displayed);

	}

	public void validate() {
		actual = UtilityFiles.getactual(prop.getValue("locators.get.id"));
		System.out.println(actual);
		String[] arr = actual.split("\\s");
		System.out.println(arr[0]);
		if (actual.equals(arr[0])) {
			logreports.info("id's were merged");
		} else {
			logreports.info("id's weren't merged");
		}
	}
}
