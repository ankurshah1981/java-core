package com.ankur.java.threads;

import java.util.List;


public class MyThreadRepository {
	/**
	 * thread local variables or anything that a thread modifies needs to be volatile
	 * each thread store a local cached version of thread local variables
	 */
	private int counter;
	private List<String> items;

	public MyThreadRepository(int counter, List<String> items) {
		this.items = items;
		this.counter = counter;
	}

	public int getCounter() {
		return counter;
	}

	public void addCounter() {
		this.counter++;
	}

	public synchronized void addCounterSync() {
		this.counter++;
	}

	public void addItem(String item) {
		this.items.add(item);
	}

	public synchronized void addItemSync(String item) {
		this.items.add(item);
	}
	
	public int getItemSize() {
		return items!=null ? items.size() : null;
	}

}