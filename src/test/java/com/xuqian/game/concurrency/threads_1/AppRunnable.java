package com.xuqian.game.concurrency.threads_1;


class Task implements Runnable {

	public void run() {
		  for (int i = 0; i < 5; i++) {
	            System.out.println("Hello: " + i + " Thread: " + Thread.currentThread().getName());

	            try {
	                Thread.sleep(100);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        }
		
	}
	
}

public class AppRunnable {
	public static void main(String[] args) {
		 Thread thread1 = new Thread(new Task());
	        Thread thread2 = new Thread(new Task());
	        thread1.start();
	        thread2.start();
	}
}
