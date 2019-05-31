package com.class02;

import org.testng.annotations.Test;

public class DisablingEnableInTestng {
	
	@Test(priority=2, enabled = true)
	public static void FirstTest()
	{
	System.out.println("This is the Test Case number Two because of Priority #2");
	}
	 
	@Test(priority=1, enabled = true)
	public static void SecondTest()
	{
	System.out.println("This is the Test Case number One because of Priority #1");
	}
	 
	@Test(enabled = false)
	public static void SkippedTest()
	{
	System.out.println("This is the Skipped Test Case because this has been disabled");
	}
	 
	@Test(enabled = true)
	public static void FinalTest()
	{
	System.out.println("This is the Final Test Case, which is enabled and has no Priority");
	}

}
