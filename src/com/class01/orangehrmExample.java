package com.class01;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class orangehrmExample extends CommonMethods {

	@BeforeMethod
	public void setUP() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}

	@Test
	public void login() throws InterruptedException {

		sendKeys(driver.findElement(By.cssSelector("input#txtUsername")), "Admin");
		Thread.sleep(2000);
		sendKeys(driver.findElement(By.cssSelector("input#txtPassword")), "admin123");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input#btnLogin")).click();
	}

	@AfterMethod
	public void close() {
		driver.close();
	}
}