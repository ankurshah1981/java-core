package com.ankur.java.core.problems.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {

	public static void main(String[] args) {
		System.out.println("main");
		List<Integer> ints = new ArrayList<Integer>(5);
		Integer five = 5;
		ints.add(2);
		ints.add(21);
		ints.add(2);
		ints.add(five);
		ints.add(five);
		System.out.println(ints);
		System.out.println(ints.	indexOf(2));
		System.out.println(ints.indexOf(5));
		System.out.println(ints.indexOf(five));
	}
	public static void main2(String[] args) {
		System.out.println("main 2");
	}
}
