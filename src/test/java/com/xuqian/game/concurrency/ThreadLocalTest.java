package com.xuqian.game.concurrency;

public class ThreadLocalTest {
	
	static class Task implements Runnable {
		int counter;
		
		ThreadLocal<Integer> threadLocals = new ThreadLocal<Integer>();
		
		public void run() {
			counter++;
			if (threadLocals.get() != null) {
				threadLocals.set(threadLocals.get().intValue() + 1);
			} else {
				threadLocals.set(0);
			}
			
			System.out.println("Counter: " + counter);
		    System.out.println("threadLocalCounter: " + threadLocals.get());
			
		}

	}

	public static void main(String[] args) {
		Task task = new Task();
		
		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);
		Thread t3 = new Thread(task);
		Thread t4 = new Thread(task);
		Thread t5 = new Thread(task);
		
		t1.start();t2.start();t3.start();t4.start();t5.start();
		
		try {
			t1.join();t2.join();t3.join();t4.join();t5.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
			System.out.println("Interrupted");
		}
		
	}
}
