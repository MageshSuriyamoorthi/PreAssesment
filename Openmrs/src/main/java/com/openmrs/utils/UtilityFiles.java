package com.openmrs.utils;

import static org.testng.Assert.assertEquals;


import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import com.openmrs.classpath.Classpath;
import com.openmrs.helper.ReadpropertiesFile;
import com.openmrs.helper.XlxsReader;
import com.openmrs.testbase.BrowserInvoke;

public class UtilityFiles extends BrowserInvoke {

	WebElement element;
	public static ReadpropertiesFile readprop = new ReadpropertiesFile();
	public static XlxsReader reader = UtilityFiles.getXlsReader(Classpath.Excel_file1);
	public static XlxsReader testreader = UtilityFiles.getXlsReader(Classpath.Excel_file);

	public void geturl(String string) {

		driver.get(string);
	}

	public void maximize() {
		driver.manage().window().maximize();
	}

	public void ClickElement(String xpath) {
		driver.findElement(By.xpath(xpath)).click();
	}

	public void selectDropdown(String xpath, int index) {
		element = driver.findElement(By.xpath(xpath));
		Select months = new Select(element);
		months.selectByIndex(index);
	}

	public void enterText(String Xpath, String name, int index) {
		String val = reader.getCellDataByColumnName("Sheet1", name, index);
		driver.findElement(By.xpath(Xpath)).sendKeys(val);

	}

	public void scrollintoview() {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;

		javascript.executeScript("window.scrollBy(0,1000)");
		javascript.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void closeDriver()  {

		driver.close();
	}

	public void windowhandle(String text) {
		driver.switchTo().window(text);

	}

	public void tab(String xpath, Keys tab) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(xpath)).sendKeys(tab);
	}

	public boolean verifyTrue(boolean condition, String message) {
		boolean result = true;
		try {
			Assert.assertTrue(condition);
			// logger.info("PASS : " + message);
			System.out.println("PASS : " + message);
			// Reporter.log("PASS : " + message);
			result = true;
		} catch (AssertionError assertionError) {

			result = false;
		}
		return result;

	}

	public static boolean isDisplayed(String Xpath) {
		boolean isDisplayed = false;

		isDisplayed = driver.findElement(By.xpath(Xpath)).isDisplayed();

		return isDisplayed;
	}

	public static String getactual(String Xpath) {
		String getstring = driver.findElement(By.xpath(Xpath)).getText();
		return getstring;
	}

	public static List<String> getexpected(String symbol) {
		String data = readprop.getValue("test.data");
		String[] contents = data.split(symbol);
		List<String> list = new ArrayList<String>();
		for (String arr : contents)
			list.add(arr);
		return list;
	}

	public static XlxsReader getXlsReader(String testDataFile) {
		XlxsReader xlsReader = new XlxsReader();

		try {
			xlsReader.setPath(testDataFile);
		} catch (IOException ioException) {
			return null;
		}
		return xlsReader;
	}

	public static String expectedresult(String Xpath, int beginindex, int endindex) {
		String name = driver.findElement(By.xpath(Xpath)).getText().substring(beginindex, endindex);
		return name;
	}

	public static String testresult(String sheetno, String sheetname, int index) {
		String dataname = reader.getCellDataByColumnName(sheetno, sheetname, index);
		System.out.println(dataname);
		return dataname;
	}

	public static String dataresult(String sheetno, String sheetname, int index) {
		String dataname = testreader.getCellDataByColumnName(sheetno, sheetname, index);
		System.out.println(dataname);
		return dataname;
	}

	public void assertequals(String actual, String expected, String message) {
		assertEquals(actual, expected);
		System.out.println(message);
	}

	public void entertext(String Xpath, String text) {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(Xpath)).sendKeys(text);
	}
}
/*
 * public static void main(String[] args) { String n = expectedresult(null, 6,
 * 14); System.out.println(n); }
 */