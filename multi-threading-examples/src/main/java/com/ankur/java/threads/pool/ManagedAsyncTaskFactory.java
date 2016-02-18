package com.ankur.java.threads.pool;

import java.util.concurrent.ThreadFactory;

public class ManagedAsyncTaskFactory implements ThreadFactory {

	/**
	 * Return a Thread instance that runs ManagedAsyncTask 
	 */
	public Thread newThread(Runnable r) {
		//ManagedAsyncTask task = (ManagedAsyncTask)r;
		Thread t = new Thread(r);
		System.out.println("ManagedAsyncTaskFactory:: Created a new Thread in the factory for the Runnable " + r.getClass() + ". Thread.name="+t.getName() + ", Thread.id="+t.getId() + ". Thread.priority="+t.getPriority());
		return t;
	}

}
