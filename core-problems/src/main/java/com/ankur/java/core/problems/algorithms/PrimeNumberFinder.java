package com.ankur.java.core.problems.algorithms;

import java.util.ArrayList;
import java.util.List;


/**
 * This class finds the nth prime number.
 * 
 * @author ashah
 */
public class PrimeNumberFinder {
	//a number that is divisible by itself and 1. 1 is not a prime number
	//1,2,3,5
	//List is Ordered so that the position of the element at entry remains same all the time. Elements can be repeated
	List<Integer> primeNumberOrderedList;


	public PrimeNumberFinder() {
		primeNumberOrderedList = new ArrayList<Integer>(1);
		//2 is only even prime number. initializing the list with the first two prime numbers
		addToPrimeNumberOrderedList(2);
		addToPrimeNumberOrderedList(3);
	}


	/**
	 * Gets the nth Prime number. 2 is the first one.
	 * @param n
	 * @return
	 * @throws Exception
	 */
	public Integer findNthPrimeNumber(int n) throws Exception {
		if(n <= 0) {
			//throw Exception. the index can only be a non-zero positive number
			throw new IllegalArgumentException("The index can only be a non-zero positive number. Provided value was: " + n);
		}

		if(getPrimeNumberOrderedList().size() >= n) {
			System.out.println("Cache hit... getting (" + n + ")th element from List.");
			return getFromPrimeNumberOrderedList(n-1);
		}

		int i = getPrimeNumberOrderedList().size()-1;
		int prime = getFromPrimeNumberOrderedList(i);

		populatePrimeNumbers(prime+2, n-getPrimeNumberOrderedList().size()+1);

		return getFromPrimeNumberOrderedList(n-1);

		//System.out.println(".....List.size()="+primeNumberOrderedList.size()+", requested index=" + n );
		//		if(primeNumberOrderedList.size() >= n) {
		//			return primeNumberOrderedList.get(n-1);
		//		} else {
		//			System.out.println("Should not have come here. Prime numbers were not correctly calculated. List.size()="+primeNumberOrderedList.size()+", requested index=" + n );
		//			return 1;
		//		}
	}


	public void populatePrimeNumbers(Integer start, int count) {
		for(Integer nextPrime = start; count >= 0 ; nextPrime=nextPrime+2, count--) {
			if(isPrime(nextPrime)) {
				addToPrimeNumberOrderedList(nextPrime);
			}
		}
	}


	/**
	 * Assumes the numbers provided is even number since only odd numbers can be prime
	 * @param number
	 * @return true of the number if prime number
	 */
	public boolean isPrime(Integer number) {
		//we need to check for modulo for all number from 3 to number/3 since we are only interested in odd numbers
		for(int i=3; i<=Math.round(Math.sqrt(number)); i++) {
			if(number % i == 0 ) {
				return false;
			}
		}
		return true;
	}


	List<Integer> getPrimeNumberOrderedList() {
		return primeNumberOrderedList;
	}

	Integer getFromPrimeNumberOrderedList(int index) {
		return primeNumberOrderedList.get(index);
	}		

	void addToPrimeNumberOrderedList(Integer nextPrime) {
		primeNumberOrderedList.add(nextPrime);
	}
}
