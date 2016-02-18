package com.ankur.java.core.problems;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ankur.java.core.problems.algorithms.AckermanFunction;

public class AckermanFunctionTest {
	
	private AckermanFunction testFunction;
	
	@BeforeClass
	public void setup() {
		testFunction = new AckermanFunction();
	}
	
	@Test
	public void testAckerman() {
		int m = 2;
		int n = 2;
		//time-in
		System.out.println("ackerman of " + m + "," + n + " is: " + testFunction.ackerman(m, n));
		//time-out
		System.out.println("testFunction.getRecursionCount() = " + testFunction.getRecursionCount());
	}
}
