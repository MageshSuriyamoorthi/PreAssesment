package com.openmrs.reports;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Configure the log4j file path.
 */

public class log4j {


	public class Log4j {

		Logger logger = null;

		public Log4j() {
			getlogger();
			logger = Logger.getLogger(Log4j.class.getName());
		}

		public void getlogger() {
			PropertyConfigurator.configure("log4j_file");
		}

		public void info(String message) {
			logger.info(message);
		}

	}

}
