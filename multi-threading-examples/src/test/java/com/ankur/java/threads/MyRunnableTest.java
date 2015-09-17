package com.ankur.java.threads;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class MyRunnableTest {
	
	MyThreadRepository testData;
	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	/**
	 * Setup a repo shared between the threads 
	 */
	@Before
	public void setup() {
		testData = new MyThreadRepository(0, new ArrayList<String>(0));
	}
	
	
	/**
	 * without joining threads the Runnable thread will always finished later than the thread that runs the unit test.
	 */
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
		
		assertTrue(testData.getCounter()<MyRunnable.LOOP_LENGTH);
		assertTrue(testData.getItemSize()<MyRunnable.LOOP_LENGTH);
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
	
	
	/**
	 * The asserts will fail because of concurrency issue
	 * @throws InterruptedException
	 */
	//@Test
	public void testRunWithJoinMultiThread() throws InterruptedException {
		MyRunnable r1 = new MyRunnable();
		MyRunnable r2 = new MyRunnable();
		r1.setData(testData);
		r2.setData(testData);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		
		thrown.expect(Exception.class);
		
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		
		//this asserts will fail sometimes because of thread interleaving
		//assertEquals(MyRunnable.LOOP_LENGTH*2, testData.getCounter());
		//assertEquals(MyRunnable.LOOP_LENGTH*2, testData.getItemSize());
	}

}
