package com.ankur.java.threads;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MyThreadTest {

	MyThread threadUnderTest;
	MyThreadRepository testData;
	
	@Before
	public void setup() {
		threadUnderTest = new MyThread();
		testData = new MyThreadRepository(0, new ArrayList<String>(0));
		threadUnderTest.setData(testData);
	}
	
	/**
	 *  since the thread execution is not joined we wont get the expected values
	 */
	@Test
	public void testRunWithoutJoin() {
		threadUnderTest.start();
		assertEquals(0, testData.getCounter());
		assertEquals(0, testData.getItemSize());
	}
	
	/**
	 *  since the thread execution is joined, current test execution will wait until the thread finishes
	 * @throws InterruptedException
	 */
	@Test
	public void testRunWithJoin() throws InterruptedException {
		threadUnderTest.start();
		threadUnderTest.join();
		assertEquals(MyThread.LOOP_LENGTH, testData.getCounter());
		assertEquals(MyThread.LOOP_LENGTH, testData.getItemSize());
	}

}
