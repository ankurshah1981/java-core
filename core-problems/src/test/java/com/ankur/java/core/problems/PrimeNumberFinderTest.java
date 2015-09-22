package com.ankur.java.core.problems;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class PrimeNumberFinderTest {
	
	PrimeNumberFinder testPrimeNumberFinder = new PrimeNumberFinder();
		
	
	@Test
	public void testPrime() throws Exception {
		List<Integer> cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
		
		Integer fifth = testPrimeNumberFinder.findNthPrimeNumber(5);
		cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
		
		Integer sixth = testPrimeNumberFinder.findNthPrimeNumber(6);
		cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
		
		Integer tenth = testPrimeNumberFinder.findNthPrimeNumber(10);
		cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
	}
	
	
	@Test(dataProvider="primeNumberProvider")
	public void testForPrimes(int number) {
		boolean isPrime = testPrimeNumberFinder.isPrime(number);
		Assert.assertTrue(isPrime);
	}
	
	
	@Test(dataProvider="compositeNumberProvider")
	public void testNonPrimes(int number) {
		boolean isPrime = testPrimeNumberFinder.isPrime(number);
		Assert.assertFalse(isPrime);
	}
	
	
	@DataProvider
	public Object[][] primeNumberProvider() {
		return new Object[][] { 
			{5}, {7}, {11}, {13}, {17}, {19}, {23}, {29}, {31}, {37}, {41}, {43}, {47}, {53}, {59}, {61}, {71}, {73}, {83}
		};
	}
	
	
	@DataProvider
	public Object[][] compositeNumberProvider() {
		return new Object[][] { 
			{9}, {15}, {21}, {25}, {27}, {33}, {35}, {39}, {45}, {49}, {75}, {81}, {87}
		};
	}
	
	
	@DataProvider
	public Object[][] naturalNumberProvider() {
		int testValues = 1000;
		List<Integer> numbers = new ArrayList<Integer>(testValues);
		for(int i=5; i<=testValues; i=i+2) {
			numbers.add(i);
		}
		return new Object[][] { numbers.toArray() };
	}
}
