package com.ankur.java.core.problems;

import java.util.InputMismatchException;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ScannerTest {

	@Test(expectedExceptions=InputMismatchException.class)
	public void testScanner() {
		String in = "1 a 10 . 100 1000"; 
		Scanner s = new Scanner(in); 
		int accum = 0; 
		for(int x = 0; x < 4; x++) { 
			accum += s.nextInt(); 
		} 
		System.out.println(accum); 
	}
}
