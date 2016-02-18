package com.ankur.java.core.problems.algorithms;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ankur.java.core.problems.algorithms.SelectionSorter;


public class SelectionSorterTest {

	@Test(dataProvider="unsortedIntArrayProvider")
	public void testSelectionSort(int[] testUnsortedArray, int[] expectedSortedArray) {
		
		SelectionSorter testSorter = new SelectionSorter();
		
		int[] sortedArray = testSorter.selectionSort(testUnsortedArray);
		
		assertEquals(sortedArray, expectedSortedArray);
	}

	
	@DataProvider
	public Object[][] unsortedIntArrayProvider() {
		return new Object[][] { 
			{new int[] {22, 11, 99, 88, 9, 7, 42}, new int[] {7,9,11,22,42,88,99}},
			{new int[] {22, 11, 99, 88, 9, 0, 42}, new int[] {0,9,11,22,42,88,99}},
			{new int[] {22, -1, 99, 88, 9, 0, 42}, new int[] {-1,0,9,22,42,88,99}}
		};
	}

}
