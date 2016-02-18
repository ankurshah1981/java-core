package com.ankur.java.core.problems.certification.programmer1;

/**
 * What is the output of this class
 * A) c x y g 
 * B) c g x y  
 * C) x c y g 
 * D) x y c g 
 * E) y x c g 
 * F) y c g x 
 * 
 */
public class Sequence {
		static { System.out.print("x "); } 
		
		{ System.out.print("y "); } 
		
		Sequence() { 
			System.out.print("c "); 
		} 
		
		void go() { System.out.print("g "); } 
		
		public static void main(String[] args) { 
			new Sequence().go(); 
		} 
} 
