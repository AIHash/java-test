package com.xuqian.game.thread.local;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMain1 {
	public static class CalcRunable implements Runnable {
		Map<Thread,Integer> map;
		public CalcRunable(Map<Thread,Integer> map) {
			this.map = map;
		}
		
		public void run() {
			Thread self = Thread.currentThread();
			for (int i=1; i <100;i++) {
				map.put(self, map.get(self) + 1);
				System.out.println(map);
				try {
					Thread.sleep(10);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		public static void main(String[] args) {
			Map<Thread,Integer> map = new HashMap();
			List<Thread> threads = new ArrayList<Thread>();
			for(int i =0; i <10;i++) {
				Thread thread = new Thread(new CalcRunable(map));
				map.put(thread, 0);
				threads.add(thread);
			}
			for(Thread thread:threads) {
				thread.start();
			}
			
			try{
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(map);
		}
		
	}
}
