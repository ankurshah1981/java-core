package com.ankur.java.threads;


public class MyThread extends Thread {

	private static final int SLEEP_TIME = 1;
	public static final int LOOP_LENGTH = 100;
	MyThreadRepository data;

	/**
	 * This is the work load of a thread. starting a thread will eventually call run(). 
	 * Use of start() is not advisable. 
	 */
	public void run() {
		for (int i = 0; i < LOOP_LENGTH; i++) {
			System.out.println("Hello - " + i);
			try {
				data.setCounter(data.getCounter() + 1);
				data.getItems().add("Hello - " + i);
				Thread.sleep(SLEEP_TIME);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void setData(MyThreadRepository data) {
		this.data = data;
	}
	
}
