package com.ankur.java.core.problems.collections;

import java.util.ArrayList;
import java.util.List;

public class DifferentiateCollections {

	//arrays are immutable: cannot add or append, can store primitives types, 
	//arrays can be multi-dimensional
	//can have duplicated
	int[] intArrayPrimitive = {};
	Integer[] intArrayWrapped = {};
	Object[] objArray = {new Object(), new Object(), null};
	//we need to know the exact size when creating array
	//once arrays are defined, created its size cant be modified.
	
	
	//list are mutable can add or append, cannot store primitive types
	//arrays cannot be multi-dimensional
	//can add duplicates
	List<Object> myList = new ArrayList<Object>(4);
	{
		myList.add(null);
		myList.add(new Object());
		myList.add("1234");
		myList.add("1234");
	}
}
