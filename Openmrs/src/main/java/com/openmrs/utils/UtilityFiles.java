package com.openmrs.utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.openmrs.testbase.BrowserInvoke;

public class UtilityFiles extends BrowserInvoke {

	WebElement element;
	static String data;

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

	public void entertext(String xpath, String text) {

		driver.findElement(By.xpath(xpath)).sendKeys(text);
	}

	public void id(String linktext, String text) {
		driver.findElement(By.id(linktext)).sendKeys(text);

	}

	public void scrollintoview() throws InterruptedException {

		JavascriptExecutor javascript = (JavascriptExecutor) driver;

		javascript.executeScript("window.scrollBy(0,800)");
		javascript.executeScript("arguments[0].scrollIntoView();", element);
	}

	public void closeDriver() throws InterruptedException {

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

	public static void equalassert(String Xpath) {
		// String[] val;

		String name = driver.findElement(By.xpath(Xpath)).getText();
		// assertEquals(val[], name);

	}

	public static String getPId(String Xpath) {
		String getstring = driver.findElement(By.xpath(Xpath)).getText();
		return getstring;
	}

	public static String[] getexpected(String symbol) {
		String[] contents = data.split(symbol);
		return contents;
	}

	public void assertequals(String actual, String expected,String message) {
		assertEquals(actual, expected);
		System.out.println(message);
	}

}
