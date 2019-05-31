package com.class02;

	import org.testng.Assert;
	import org.testng.annotations.Test;

	public class HardAssertion {
  //Follow the below code which includes multiple assert calls, 
  //all of which get passed and so the test case.
	    String className = "HardAssertion";

	    @Test
	    public void test_UsingHardAssertion() {
	        Assert.assertTrue(true == true);
	        Assert.assertEquals("HardAssertion", "HardAssertion");
	        Assert.assertEquals(className, "HardAssertion");
	        System.out.println("Successfully passed!");
	    }
	}


