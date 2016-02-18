package com.ankur.java.core.problems.certification.programmer1;

public class MultipleClassesCompile {

	class ClassInnerDefault {
		private String a;
	}

	static class ClassInnerStaticDefault {
		private String b;
	}

	private class ClassInnerPrivate {
		private String c;
	}

	private final static class ClassInnerStaticFinal {
		private static String d;
	}
	
	public MultipleClassesCompile() {
		//none of the variables from inner classes are accessible here
		ClassInnerDefault innerDefault = new ClassInnerDefault();
		innerDefault.a="Set A";
		
		ClassInnerPrivate innerPrivate = new ClassInnerPrivate();
		innerPrivate.c="Set C";
		
		ClassInnerStaticDefault innerStatic = new ClassInnerStaticDefault();
		innerStatic.b="Set B";
		
//		ClassInnerPrivate innerPrivate = new ClassInnerPrivate();
//		innerPrivate.c="Set C";
		
	}
	
	public static void main (String[] args) {
		MultipleClassesCompile testClass = new MultipleClassesCompile();
	}

}
