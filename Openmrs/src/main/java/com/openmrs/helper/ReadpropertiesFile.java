package com.openmrs.helper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.testng.annotations.Test;

import com.openmrs.classpath.Classpath;

public class ReadpropertiesFile {

	public String readPropertiesFile(String elements) throws FileNotFoundException {
		Properties prop = new Properties();

		FileInputStream input = new FileInputStream(Classpath.loc_file);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;

	}

	public String readTestDataFiles(String elements) throws FileNotFoundException {
		Properties prop = new Properties();

		FileInputStream input = new FileInputStream(Classpath.test1_file);
		try {
			prop.load(input);

		} catch (Exception e) {
			e.printStackTrace();
		}

		String data = prop.getProperty(elements);
		return data;

	}
}
