package com.class02;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utils.CommonMethods;

public class HardAssertions extends CommonMethods {
	
	@BeforeMethod
	 public void beforeMethod() {
		setUpDriver("chrome", "https://opensource-demo.orangehrmlive.com/");
	 }
	  
	 public boolean isEqual(int a, int b) {
	 if (a == b) {
	 return true;
	 } else {
	 return false;
	 }
	 }
	  
	 @Test
	 public void testEquality1() {
	 Assert.assertEquals(true, isEqual(10, 10));
	 System.out.println("This is a pass condition");
	 }
	 
	 @Test
	 public void testEquality2() {
	 Assert.assertEquals(true, isEqual(10, 11));
	 System.out.println("This is a fail condition");
	 }
	 
	 @Test
	 public void getTitle() {
	 WebDriver driver = new FirefoxDriver();
	 driver.get("https://www.gmail.com");
	 String title = driver.getTitle();
	 Assert.assertEquals(title, "Gmail");
	 System.out.println("This is again a pass condition");
	 }
	}