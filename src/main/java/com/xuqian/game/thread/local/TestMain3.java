package com.xuqian.game.thread.local;

import java.util.ArrayList;
import java.util.List;

public class TestMain3 {
	
	public static class CalcRunnable implements Runnable {
		ThreadLocal<Integer> threadLocal;
		public CalcRunnable(ThreadLocal<Integer> threadLocal){
			this.threadLocal = threadLocal;
		}
		public void run() {
			threadLocal.set(0);//设置默认值
			for(int i=1;i<=100;i++){
				threadLocal.set(threadLocal.get() + i);
				System.out.println(Thread.currentThread().getName() + " 的计算结果为: " + threadLocal.get());
				try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
			
		}
		
	}
	
	public static void main(String[] args){
		ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
		List<Thread> threads = new ArrayList<Thread>();
		for(int i = 0; i<10; i++) {
			Thread thread = new Thread(new CalcRunnable(threadLocal));
            threads.add(thread);
		}
		for (Thread thread : threads){
            thread.start();
        }
	}
}
