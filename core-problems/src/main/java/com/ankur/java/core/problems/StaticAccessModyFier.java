package com.ankur.java.core.problems;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Map;

public class StaticAccessModyFier {

	public static void main(String[] args) {
		//static class BlaBla {}
		MyKeys mk1 = new MyKeys(1);
		MyKeys mk2 = new MyKeys(1);
		Map<MyKeys, String> myMap = new HashMap<MyKeys, String>(4);
		myMap.put(mk1, "value1");
		myMap.put(mk2, "value2");
		System.out.println("mk1: " + mk1 + ", " + mk1.hashCode());
		System.out.println("mk2: " + mk2 + ", " + mk2.hashCode());
		System.out.println("myMap=" + myMap);
	}
	
	public void anotherMain() {
		//static class BlaBla {}
	}

}


class Align {
public static void main(String[] args) {
String[] sa = {"111.234", "222.5678"};
NumberFormat nf = NumberFormat.getInstance();
nf.setMaximumFractionDigits(3);
for(String s: sa) {
	//System.out.println(nf.parse(s));
}
}
}

class Bees {
public static void main(String[] args) {
try {
new Bees().go();
} catch (Exception e ) {
System.out.println("thrown to main" + e);
}
}
synchronized void go() throws InterruptedException {
	Thread t1 = new Thread();
	//synchronized(t1) {
		t1.start();
		System.out.print("1 ");
		t1.wait(5000); //to prevent IllegalMonitorStateException synchronize on the instance of the Thread
		System.out.print("2 ");
	//}
	}
}

class MyKeys { 
Integer key; 
MyKeys(Integer k) { key = k; } 
public boolean equals(Object o) { 
return ((MyKeys)o).key == this.key; 
} 
} 