package com.class01;

//TC 1: Swag Lab Title and Login Verification

//
//@BeforeMethod should contain navigation to the URL and title verification
//https://www.saucedemo.com/
//
//@Test should contain steps to login and "Product" word verification
//
//@AfterMethod should logOut from the application and close the browser

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;



public class Homework extends CommonMethods {

	@BeforeMethod
	public void navigation() {
		setUpDriver("firefox", "https://www.saucedemo.com/");
		String title = driver.getTitle();
		System.out.println(title);
		String expTitle = "Swag Labs";
		if (title.equalsIgnoreCase(expTitle)) {
			System.out.println("Title is correct");
		} else {
			System.out.println("wrong title");
		}

	}

	@Test
	public void login() {
		WebElement login = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
		sendKeys(login, "standard_user");
		login.click();

		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		sendKeys(password, "secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/input[3]")).click();

		WebElement word = driver.findElement(By.xpath("//div[@class='product_label']"));
		String prod = word.getText();
		System.out.println(prod);
		String wordExp = "Products";
		if (prod.equalsIgnoreCase(wordExp)) {
			System.out.println("is correct");
		} else {
			System.out.println("NOT correct");
		}

	}

	@AfterMethod
	public void logout() {
		driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
		driver.findElement(By.xpath("//*[@id=\"logout_sidebar_link\"]")).click();
		driver.quit();

	}

}