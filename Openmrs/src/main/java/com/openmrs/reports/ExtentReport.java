package com.openmrs.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.openmrs.classpath.Classpath;

public class ExtentReport {

	static ExtentHtmlReporter reporter = new ExtentHtmlReporter(Classpath.extendreport + "openmrs.html");
	static ExtentReports extent = new ExtentReports();

	public static void reportLog(String testname, String Failuremsg) {
		extent.attachReporter(reporter);
		ExtentTest logger = extent.createTest(testname);
		logger.log(Status.INFO, testname);
		logger.log(Status.PASS, testname);
		/*
		 * logger.log(Status.FAIL, Failuremsg); logger.fail("failed script",
		 * MediaEntityBuilder.createScreenCaptureFromPath("./Openmrs/Snapshot").build());
		 */
		extent.flush();
	}
}
