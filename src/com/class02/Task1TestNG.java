package com.class02;

/*
 *TC 1: OrangeHRM Title Validation
     2: OrangeHRM Successful Login 
https://opensource-demo.orangehrmlive.com/
Please make sure to use the following:
 annotations:
	@BeforeMethod
	@AfterMethod
	@Test

What would you do if you do not want to execute any specific test case? //use disable methods
What would you do if you want to execute any specific test case first? //Priority
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class Task1TestNG extends CommonMethods {

	@BeforeMethod
	public static void navig() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	}

	@Test(priority = 0)
	public static void valid() {
		String title = driver.getTitle();
		String exp = "OrangeHRM";
		System.out.println(title);
		if (exp.equalsIgnoreCase(title)) {
			System.out.println("correct");
		} else {
			System.out.println("NOT correct");
		}
	}

	@Test(priority = 1)
	public static void loginWeb() {
		sendKeys(driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")), "Admin");
		sendKeys(driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")), "admin123");
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
	}

	@AfterMethod
	public static void logout() {
		driver.close();
	}
}