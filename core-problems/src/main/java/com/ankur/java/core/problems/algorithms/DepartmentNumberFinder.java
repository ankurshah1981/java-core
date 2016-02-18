package com.ankur.java.core.problems.algorithms;


/**
 * Write a program to assign a department number to the three departments:
 * Police, Fire, Sanitization
 * Restrictions:
 * 1) # ranges from 1-7
 * 2) No two department can have the same #
 * 3) Sum of all the department # should be 12
 * 4) Police department should have only even #
 * 
 * @author ashah
 */
public class DepartmentNumberFinder {

	private static final int MIN_RANGE = 1;
	private static final int MAX_RANGE = 7;
	private static final int SUM_RESTRICTION = 12;
	
	
	/**
	 * The logic is intermingled with the loops. Even though this method saves some iteration the 
	 * logic is more complex and cannot be separated.
	 */
	public void printAllPermutationsOther() {
		for (int p = 2; p <= MAX_RANGE; p=p+2) {
			for (int f = MIN_RANGE; f <= MAX_RANGE; f++) {
				if(f != p) {
					
					for (int s = MIN_RANGE; s <= MAX_RANGE; s++) {
						if(s != p && s != f && (p+f+s)==SUM_RESTRICTION) {
							System.out.print("Police=" + p);
							System.out.print(", Fire=" + f);
							System.out.print(", Sanitization=" + s);
							System.out.println(", Sum=" + (p+f+s));
						}
					}
				}
			}
		}
	}
	
	
	/**
	 * Better way of coding
	 */
	public void printAllPermutations() {
		for (int p = MIN_RANGE; p <= MAX_RANGE; p++) {
			for (int f = MIN_RANGE; f <= MAX_RANGE; f++) {
				for (int s = MIN_RANGE; s <= MAX_RANGE; s++) {
					
					//generate all the permutations and then combine all the conditions inside here
					//this is less complexity, more maintainable and cleaner
					if( (p%2==0) && f != p && s != p && s != f && (p+f+s)==SUM_RESTRICTION) {
						System.out.print("Police=" + p);
						System.out.print(", Fire=" + f);
						System.out.print(", Sanitization=" + s);
						System.out.println(", Sum=" + (p+f+s));
					}
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		DepartmentNumberFinder departmentNumberFinder = new DepartmentNumberFinder();
		departmentNumberFinder.printAllPermutations();
		//departmentNumberFinder.printAllPermutationsOther();
	}

}
