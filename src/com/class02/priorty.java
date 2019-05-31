package com.class02;

import org.testng.annotations.Test;

public class priorty  {
	
	@Test (priority=0)
	public void FirstTest()
	{
	System.out.println("First test  annotation ");
	}
	 
	@Test (priority=1)
	public static void secondTest()
	{
		System.out.println("Second test  annotation ");
	}
	@Test (priority=2)
	public static void thirdTest()
	{
		System.out.println("Third test  annotation ");
	}
	@Test //(Priority=3)
	public static void fourthTest()
	{
		System.out.println("Fouth test  annotation ");
	}
	
 }
