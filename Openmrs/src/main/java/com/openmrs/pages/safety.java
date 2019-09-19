package com.openmrs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


import com.openmrs.testbase.BrowserInvoke;

public class safety extends BrowserInvoke {
	WebElement element;
	BrowserInvoke brow = new BrowserInvoke();

	public void deletedata()  {
		brow.BrowserSelect();
		driver.manage().window().maximize();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Admin123");
		driver.findElement(By.xpath("//li[@id='Registration Desk']")).click();
		driver.findElement(By.xpath("//input[@id='loginButton']")).click();
		driver.findElement(By.xpath("//i[@class='icon-search']")).click();

	
	}
	public void delete() {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("aaa");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.ENTER);
		// WebElement link_Home =
		// driver.findElement(By.xpath("(//tbody[@role='alert']//tr[@class='odd'])[1]"));
		// Actions builder = new Actions(driver);
		// Action mouseOverHome = builder.moveToElement(link_Home).build();
		// driver.findElement(By.xpath("(//tbody[@role='alert']//tr[@class='odd'])[1]")).click();
		driver.findElement(By.xpath("//li[@class='float-left']//a[@id='org.openmrs.module.coreapps.deletePatient']"))
				.click();
		driver.findElement(By.xpath("//input[@id='delete-reason']")).sendKeys("duplicate");
		driver.findElement(By.xpath("(//button[text()='Confirm'])[4]")).click();
		

	}
	public void close() {
		driver.close();
	}
}
