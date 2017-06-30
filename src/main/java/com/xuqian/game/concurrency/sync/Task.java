package com.xuqian.game.concurrency.sync;

public class Task extends Thread {
	
	private Thread thread;
	private String threadName;
	PrintClass printClass;
	
	public Task(String threadName, PrintClass printClass) {
		this.threadName = threadName;
		this.printClass = printClass;
	}

	@Override
	public void run() {
		synchronized (printClass) {
			printClass.printCount();
		}
		System.out.println();
	}

	@Override
	public synchronized void start() {
		
	}
	
	
	
	
}
