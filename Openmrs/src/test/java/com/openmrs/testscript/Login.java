package com.openmrs.testscript;

import java.io.FileNotFoundException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.openmrs.pages.Loginpage;
import com.openmrs.testbase.BrowserInvoke;

public class Login {
	BrowserInvoke browser=new BrowserInvoke();
	Loginpage login = new Loginpage();
	@BeforeTest
	public void browsersetup() {
		browser.BrowserSelect();
	}
	@Test(priority = 1)
	public void setup() throws FileNotFoundException, InterruptedException {
		login.openmrsdemo();
		login.logincredentials();
		login.RegistratioEntry();
		login.OPEntry();
		login.validation();
		login.submit();
		login.validate();
		login.findPatientRecord();
		login.dataManagement();
		
		
	}
}

