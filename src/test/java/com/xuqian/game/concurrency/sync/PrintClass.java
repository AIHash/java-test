package com.xuqian.game.concurrency.sync;

public class PrintClass {
	
	public void printCount() {
		for (int i = 5; i > 0; i--) {
			System.out.println("Counter =" + i);
		}
	}
}
