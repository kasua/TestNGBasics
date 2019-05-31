package com.class01;
/*
 * TC 1: Swag Lab Title and Login Verification
 * Go to /https://www.saucedemo.com/index.html
 * 
 * @BeforeMethod 
 * should contain navigation to the URL and title verification
 *
 * @Test 
 * should contain steps to login and “Product” word verification
 *
 * @AfterMethod 
 * should logOut from the application and 
 * close the browser
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class Task2TestNG extends CommonMethods {

	@BeforeMethod
	public void setUP() {
		setUpDriver("chrome", "https://www.saucedemo.com/");
		driver.manage().window().maximize();

		String expectedTitle = "Swag Labs";

		String actualTitle = driver.getTitle();
		System.out.print("Current page title is : " + actualTitle);

		if (actualTitle.equalsIgnoreCase(expectedTitle)) {
			System.out.println("Title is verified & passed");

			WebDriverWait wait = new WebDriverWait(driver, 10);

		}
	}

	@Test
	public void login() throws InterruptedException {

		sendKeys(driver.findElement(By.id("txtUsername")), "Admin");
		sendKeys(driver.findElement(By.id("txtPassword")), "admin123");
		driver.findElement(By.cssSelector("input.btn_action")).click();

		String expectedWord = "Products";

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector("div.product_label"), "Products"));

		WebElement word = driver.findElement(By.cssSelector("div.product_label"));
		if (word.getText().equalsIgnoreCase(expectedWord)) {
			System.out.println(expectedWord + "is present in the web page");
		}else {
			System.out.println(expectedWord + "is not present in the web page");
		}
	}

	@AfterMethod
	public void logout() {
        
		
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()= 'Logout']")));
		driver.findElement(By.linkText("Logout")).click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bot_colunm")));
		driver.close();

	}
}