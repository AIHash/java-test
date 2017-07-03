package com.xuqian.game.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public class Task1Test implements Runnable {
	private static AtomicInteger atomicInteger = new AtomicInteger();

	public void run() {
		try {
			System.out.println(atomicInteger.getAndIncrement());
			Thread.sleep(1 * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
