package com.openmrs.pages;

import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.utils.UtilityFiles;

public class DataManagement {
	UtilityFiles util = new UtilityFiles();
	public ReadpropertiesFile prop = new ReadpropertiesFile();
	public void datamanagement()  {
		util.ClickElement(prop.getValue("locators.datamanagement.click"));
		util.ClickElement(prop.getValue("locators.merge.records"));
		util.ClickElement(prop.getValue("locators.search.record"));
		
		
	}
}
