package com.ankur.java.threads;

public class MySyncRunnable implements Runnable {

	//private static final int SLEEP_TIME = 1;
	public static final int LOOP_LENGTH = 10000;
	MyThreadRepository data;
	
	public void run() {
		for (int i = 0; i < LOOP_LENGTH; i++) {
			data.addCounter();
			data.addItem("Hello - " + i);
		}
	}

	public void setData(MyThreadRepository data) {
		this.data = data;
	}
	
}

