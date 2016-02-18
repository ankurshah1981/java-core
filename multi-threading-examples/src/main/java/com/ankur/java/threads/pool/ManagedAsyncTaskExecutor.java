package com.ankur.java.threads.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;


public class ManagedAsyncTaskExecutor {

	private ThreadFactory factory;
	
	ManagedAsyncTaskExecutor() {
		this.factory = Executors.defaultThreadFactory();
	}
	
	ManagedAsyncTaskExecutor(ThreadFactory factory) {
		this.factory = factory;
	}
	
	/**
	 * Creates a new Executor using ThreadFactory for the provided thread count
	 */
	public ExecutorService getExecutor(int numberOfThread) {
		ExecutorService executor = Executors.newFixedThreadPool(numberOfThread, factory);
		return executor;
	}

}
