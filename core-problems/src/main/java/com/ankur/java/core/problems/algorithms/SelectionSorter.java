package com.ankur.java.core.problems.algorithms;

/**
 * Uses find index of smallest in a sub-array and swapping it with the first index.
 * 
 * @author ashah
 */
public class SelectionSorter {

	private void swap(int[] array, int firstIndex, int secondIndex) {
		int temp = array[firstIndex];
		array[firstIndex] = array[secondIndex];
	    array[secondIndex] = temp;
	}

	private int indexOfMinimum(int[] array, int startIndex) {
	    int minValue = array[startIndex];
	    int minIndex = startIndex;

	    for(int i = minIndex + 1; i < array.length; i++) {
	        if(array[i] < minValue) {
	            minIndex = i;
	            minValue = array[i];
	        }
	    } 
	    return minIndex;
	}

	public int[] selectionSort(int[] array) {
	    int currentMinIndex;
	    for(int i=0; i<array.length; i++) {
	        currentMinIndex = indexOfMinimum(array, i);
	        swap(array, i, currentMinIndex);
	    }
	    return array;
	}

}
