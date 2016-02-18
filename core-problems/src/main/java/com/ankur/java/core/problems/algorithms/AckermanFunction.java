package com.ankur.java.core.problems.algorithms;

import com.ankur.java.core.problems.certification.programmer1.MultipleClassesCompile;

/**
 * A recursive functions that cannot be de-recursed using other means such as for-loop.
 * 
 * @author ashah
 *
 */
public class AckermanFunction {
	
	private int recursionCount=0;

	public int ackerman(int m, int n) {
		recursionCount++;
		int ans = 0;
		if(m==0) {
			ans = n+1;
		} else if (n==0) {
			ans = ackerman(m-1, 1);
		} else {
			ans = ackerman(m-1, ackerman(m, n-1));
		}

		return ans;
	}
	
	public int getRecursionCount() {
		return this.recursionCount;
	}
}
