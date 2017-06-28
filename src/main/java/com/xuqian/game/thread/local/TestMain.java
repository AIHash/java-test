package com.xuqian.game.thread.local;

import java.util.ArrayList;
import java.util.List;

public class TestMain {
	public static class CalcRunnable implements Runnable {
		List<Integer> list;
		int index;	
		public CalcRunnable(List<Integer> list, int index) {
			this.list =list;
			this.index = index;
		}
		public void run() {
			for(int i = 1; i <= 100; i++) {
				list.set(index, list.get(index) + i);
				System.out.println(list);
				try {
					Thread.sleep(10);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		List<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i <10; i++) {
			list.add(0);
			threads.add(new Thread(new CalcRunnable(list,i)));
		}
		for(Thread thread: threads) {
			thread.start();
		}
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(list);
	}
	
}
