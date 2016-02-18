package com.ankur.java.threads.pool;

import java.util.Calendar;

public class ManagedAsyncTask implements Runnable {

	private int id;
	
	ManagedAsyncTask(int id) {
		this.id = id;
		System.out.println("ManagedAsyncTask::" +  + Calendar.getInstance().getTimeInMillis() + " Created a task with id="+id);
	}
	
	public void run() {
		System.out.println("ManagedAsyncTask::" +  + Calendar.getInstance().getTimeInMillis() + " Start work on Task id="+id);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("ManagedAsyncTask::" +  + Calendar.getInstance().getTimeInMillis() + " Completed work on Task id=" + id);
	}

	public int getId() {
		return id;
	}
}
