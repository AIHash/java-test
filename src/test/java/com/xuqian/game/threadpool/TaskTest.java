package com.xuqian.game.threadpool;

public class TaskTest implements Runnable {
	private int i;

	public TaskTest(int i) {
		this.i = i;
	}

	public void run() {
		System.out.println(i);
		try {
			Thread.sleep(1 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
