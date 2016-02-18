package com.ankur.java.threads.pool;

import java.util.Calendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ManagedAsyncTaskExecutorTest {
	
	private ManagedAsyncTaskExecutor testExecutor;
	
	@BeforeClass
	public void setup() {
		testExecutor = new ManagedAsyncTaskExecutor(new ManagedAsyncTaskFactory());
	}
	
	@Test
	public void testExecutor() {
		int numberOfThread = 5;
		ExecutorService executor = testExecutor.getExecutor(numberOfThread);
		for(int i=1; i<=numberOfThread+numberOfThread; i++) {
			executor.submit(new ManagedAsyncTask(i));
		}
		//will wait for the Threads to finish and then terminate.
		executor.shutdown();
		
		System.out.println("All tasks submitted.");
		try {
			executor.awaitTermination(1, TimeUnit.MINUTES);
		} catch (InterruptedException e) {
			System.out.println("All tasks were not completed in the alloted time.");
		}
		System.out.println("All tasks submitted @ " + Calendar.getInstance().getTimeInMillis());
	}
  
}
