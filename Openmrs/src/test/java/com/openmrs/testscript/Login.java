package com.openmrs.testscript;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openmrs.pages.DataManagement;
import com.openmrs.pages.DataValandSubmit;
import com.openmrs.pages.Loginpage;
import com.openmrs.pages.OPRegister;
import com.openmrs.testbase.BrowserInvoke;

public class Login {
	BrowserInvoke browser = new BrowserInvoke();
	Loginpage login = new Loginpage();
	OPRegister register = new OPRegister();
	DataValandSubmit val = new DataValandSubmit();
	DataManagement manage = new DataManagement();

	@BeforeTest
	public void browsersetup() {

		browser.BrowserSelect();
	}

	@Test
	public void setup() {

		login.openmrsdemo();
		login.logincredentials();
		login.patientsCredentials();

		register.OPEntry(1);

		val.validationandsubmit(1);
		val.PatientSearch();

		login.patientsCredentials();
		
		register.OPEntry(2);

		val.validationandsubmit(2);
		val.PatientSearch();
		
		manage.datamanagement();
	}

	@AfterTest
	public void closeSetup() {
		// browser.BrowserClose();
	}
}
