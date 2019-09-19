package com.openmrs.classpath;

import java.io.File;

public class Classpath {

	public static String Users_Home = System.getProperty("user.dir");

	public static String url_file = Users_Home + File.separator + "config.properties";

	public static String log4j_file = Users_Home + File.separator + "resource" + File.separator + "log4j"
			+ File.separator + "log4j.properties";

	public static String Excel_file = Users_Home + File.separator + "resource" + File.separator + "testdata"
			+ File.separator + "testdata.xlsx";

	public static String Excel_file1 = Users_Home + File.separator + "resource" + File.separator + "testdata"
			+ File.separator + "testdata1.xlsx";

	public static String Excel_file2 = Users_Home + File.separator + "resource" + File.separator + "datavalues"
			+ File.separator + "datavalues.xlsx";

	public static String loc_file = Users_Home + File.separator + "resource" + File.separator + "locators"
			+ File.separator + "homelocators.properties";

	public static String register_file = Users_Home + File.separator + "resource" + File.separator + "locators"
			+ File.separator + "opregister.properties";

	public static String search_file = Users_Home + File.separator + "resource" + File.separator + "locators"
			+ File.separator + "searchrecord.properties";

	public static String datamanage_file = Users_Home + File.separator + "resource" + File.separator + "locators"
			+ File.separator + "datamanagement.properties";

	public static String Chrome_file = Users_Home + File.separator + "lib" + File.separator + "chromedriver.exe";

	public static String Firefox_file = Users_Home + File.separator + "lib" + File.separator + "geckodriver.exe";

	public static String IE_file = Users_Home + File.separator + "lib" + File.separator + "IEDriverServer.exe";

	public static String Edge_file = Users_Home + File.separator + "lib" + File.separator + "MicrosoftWebDriver.exe";
	
	public static String extendreport = Users_Home + File.separator + "extendedreport" + File.separator ;
	/*
	 * public static void main(String[] args) { System.out.println(log4j_file); }
	 */
}
