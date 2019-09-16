package com.openmrs.reports;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.openmrs.classpath.Classpath;

/**
 * Configure the log4j file path.
 */

public class log4j {

	Logger logger = null;

	public log4j() {
		getlogger();
		logger = Logger.getLogger(log4j.class.getName());
	}

	public void getlogger() {
		PropertyConfigurator.configure(Classpath.log4j_file);
	}

	public void info(String message) {
		logger.info(message);
	}
	public void infoboo(boolean message) {
		logger.info(message);
	}

}
