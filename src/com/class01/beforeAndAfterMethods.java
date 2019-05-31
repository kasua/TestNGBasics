package com.class01;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class beforeAndAfterMethods {
	
	@BeforeMethod
	public void testMethodsOne() {
			System.out.println("beforeMethods");
	}
   @Test
   public void testMethodOne() {
	   System.out.println("testMethod");
   }
   
   @Test
   public void testMethodTwo() {
	   System.out.println("testMethodTwo");
   }
	   @AfterMethod
   public void  afterMethod() {
	   System.out.println("afterMethods");
   }
   
   }
  
