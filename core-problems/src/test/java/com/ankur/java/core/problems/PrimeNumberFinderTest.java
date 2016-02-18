package com.ankur.java.core.problems;

import java.util.List;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ankur.java.core.problems.algorithms.PrimeNumberFinder;


public class PrimeNumberFinderTest {
	
	PrimeNumberFinder testPrimeNumberFinder = new PrimeNumberFinder();
		
	
	@Test
	public void testFinderConstruction (int nPosition, int expectedPrimeNumber) throws Exception {
		testPrimeNumberFinder = new PrimeNumberFinder();
		List<Integer> cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
		assertEquals(cachedList.size(), 2);
	}
		
	
	@Test(dataProvider="nthPrimeNumber")
	public void testPrime(int nPosition, int expectedPrimeNumber) throws Exception {
		
		int actualNthPrime = testPrimeNumberFinder.findNthPrimeNumber(nPosition);
		
		assertEquals(actualNthPrime, expectedPrimeNumber);
		List<Integer> cachedList = testPrimeNumberFinder.getPrimeNumberOrderedList();
		assertTrue(cachedList.size() >= nPosition);
	}
	
	
	@Test(dataProvider="primeNumberProvider")
	public void testForPrimes(int number) {
		boolean isPrime = testPrimeNumberFinder.isPrime(number);
		assertTrue(isPrime);
	}
	
	
	@Test(dataProvider="compositeNumberProvider")
	public void testNonPrimes(int number) {
		boolean isPrime = testPrimeNumberFinder.isPrime(number);
		assertFalse(isPrime);
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
	public Object[][] nthPrimeNumber() {
		return new Object[][] { 
			{3, 5}, {4, 7}, {5, 11}, {6, 13}, {7, 17}, {8, 19}, 
			{9, 23}, {10, 29}, {11, 31}, {12, 37}, {13, 41}, {14, 43}, 
			{15, 47}, {16, 53}, {17, 59}, {18, 61}, {19, 67}, {20, 71}, {21, 73}, {22, 79}
		};
	}
	
}
