package com.ankur.java.core.problems.algorithms;

/**
 * Logic: 
 * 
 * Example:
 * Imagine that you are playing a card game. 
 * You're holding the cards in your hand, and these cards are sorted. 
 * The dealer hands you exactly one new card. 
 * You have to put it into the correct place so that the cards you're holding are still sorted.
 * 
 * @author ashah
 *
 */
public class InsertionSorter {

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
