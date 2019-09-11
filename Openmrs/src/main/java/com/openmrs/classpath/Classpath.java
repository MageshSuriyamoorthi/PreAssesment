package com.openmrs.classpath;

import java.io.File;

public class Classpath {
	
	public static String Users_Home = System.getProperty("user.dir");

	public static String Excel_file=Users_Home + File.separator+ "resource" + File.separator + "Datavalues" + File.separator + "Dataval.xlsx";
	
	public static String loc_file = Users_Home +File.separator+ "resource" + File.separator + "locators" + File.separator + "homelocators.properties";
	
	public static String test1_file = Users_Home +File.separator+ "resource" + File.separator + "locators" + File.separator + "testdata.properties";
	
	public static String Chrome_file=Users_Home+File.separator+ "lib" + File.separator + "chromedriver.exe";
	
	public static String Firefox_file=Users_Home+File.separator+ "lib" + File.separator + "geckodriver.exe";
	
	public static String IE_file=Users_Home+File.separator+ "lib" + File.separator + "IEDriverServer.exe";
	
	public static String Edge_file=Users_Home+File.separator+ "lib" + File.separator + "MicrosoftWebDriver.exe";
}
