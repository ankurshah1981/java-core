package com.ankur.java.threads;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MyRunnableTest {
	
	MyThreadRepository testData;
	
	/**
	 * Setup a repo shared between the threads 
	 */
	@Before
	public void setup() {
		testData = new MyThreadRepository(0, new ArrayList<String>(0));
	}
	
	@Test
	public void testRunWithoutJoin() {
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		r1.setData(testData);
		r2.setData(testData);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		
		assertEquals(0, testData.getCounter());
		assertEquals(0, testData.getItemSize());
	}
	
	@Test
	public void testRunWithJoinSingleThread() throws InterruptedException {
		MyRunnable r1 = new MyRunnable();
		r1.setData(testData);
		Thread t1 = new Thread(r1);
		t1.start();
		t1.join();
		
		assertEquals(MyRunnable.LOOP_LENGTH, testData.getCounter());
		assertEquals(MyRunnable.LOOP_LENGTH, testData.getItemSize());
	}
	
	
	@Test
	public void testRunWithJoinMultiThread() throws InterruptedException {
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		r1.setData(testData);
		r2.setData(testData);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		//this asserts will fail sometimes because of thread interleaving
		assertEquals(MyRunnable.LOOP_LENGTH*2, testData.getCounter());
		assertEquals(MyRunnable.LOOP_LENGTH*2, testData.getItemSize());
	}
	
	
	/**
	 * Exposes a concurrency issue
	 * @throws InterruptedException
	 */
	@Test
	public void testRunWithJoinMultiThreadMultiTimes() throws InterruptedException {
		int intConcurrency = 0;
		int listConcurrency = 0;
		int exceptionsCount = 0;
		int loopLength = 100;
		
		for (int i = 0; i < loopLength; i++) {
			MyRunnable r1 = new MyRunnable();
			MyRunnable r2 = new MyRunnable();
			r1.setData(testData);
			r2.setData(testData);
			Thread t1 = new Thread(r1);
			Thread t2 = new Thread(r2);
			
			try {
				t1.start();
				t2.start();
				t1.join();
				t2.join();
			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				exceptionsCount++;
			} finally {
				if(MyRunnable.LOOP_LENGTH*2 == testData.getCounter()) {
					intConcurrency++;
				}
				if(MyRunnable.LOOP_LENGTH*2 == testData.getItemSize()) {
					listConcurrency++;
				}
				setup();
			}
		}
		
		System.out.println("intConcurrency="+intConcurrency);		
		System.out.println("listConcurrency="+listConcurrency);
		System.out.println("exceptionsCount="+exceptionsCount);
		
		assertNotEquals(loopLength, intConcurrency);
		assertNotEquals(loopLength, listConcurrency);
		assertTrue(exceptionsCount>0);
		//assertNotEquals(listConcurrency, intConcurrency);
	}

}