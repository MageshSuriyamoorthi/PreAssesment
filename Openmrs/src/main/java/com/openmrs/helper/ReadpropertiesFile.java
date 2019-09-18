package com.openmrs.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.openmrs.classpath.Classpath;

public class ReadpropertiesFile {

	private static ReadpropertiesFile propReader;
	private Properties prop = new Properties();

	public ReadpropertiesFile() {
		List<String> propsFiles = Arrays.asList(Classpath.loc_file, Classpath.url_file, Classpath.register_file,
				Classpath.search_file, Classpath.datamanage_file);

		for (String filePath : propsFiles) {
			try {
				prop.load(new FileInputStream(new File(filePath)));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static ReadpropertiesFile getInstance() {

		if (propReader == null)
			propReader = new ReadpropertiesFile();
		return propReader;

	}

	public String getValue(String elements) {
		String data = prop.getProperty(elements);
		return data;
	}

}

/*
 * public String readPropertiesFile(String elements) throws
 * FileNotFoundException { Properties prop = new Properties();
 * 
 * FileInputStream input = new FileInputStream(Classpath.loc_file); try {
 * prop.load(input);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * String data = prop.getProperty(elements); return data;
 * 
 * }
 * 
 * public String readTestDataFiles(String elements) throws FileNotFoundException
 * { Properties prop = new Properties();
 * 
 * FileInputStream input = new FileInputStream(Classpath.test1_file); try {
 * prop.load(input);
 * 
 * } catch (Exception e) { e.printStackTrace(); }
 * 
 * String data = prop.getProperty(elements); return data; }
 */
