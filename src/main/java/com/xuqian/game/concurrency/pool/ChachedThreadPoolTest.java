package com.xuqian.game.concurrency.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ChachedThreadPoolTest {

	static class Task implements Runnable {

		public void run() {
			Long duration = (long) (Math.random() * 5);
			System.out.println("Running Task! Thread Name: " + Thread.currentThread().getName());
            try {
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            System.out.println("Task Completed! Thread Name: "+ Thread.currentThread().getName());
		}
		
	}
	
	public static void main(final String[] arg) {
		ExecutorService executor = Executors.newCachedThreadPool();
		
		ThreadPoolExecutor pool = (ThreadPoolExecutor) executor;
		//Stats before tasks execution
	      System.out.println("Core threads: " + pool.getCorePoolSize());
	      System.out.println("Largest executions: "
	         + pool.getLargestPoolSize());
	      System.out.println("Maximum allowed threads: "
	         + pool.getMaximumPoolSize());
	      System.out.println("Current threads in pool: "
	         + pool.getPoolSize());
	      System.out.println("Currently executing threads: "
	         + pool.getActiveCount());
	      System.out.println("Total number of threads(ever scheduled): "
	         + pool.getTaskCount());
	      
	      executor.submit(new Task());
	      executor.submit(new Task());

	      //Stats after tasks execution
	      System.out.println("Core threads: " + pool.getCorePoolSize());
	      System.out.println("Largest executions: "
	         + pool.getLargestPoolSize());
	      System.out.println("Maximum allowed threads: "
	         + pool.getMaximumPoolSize());
	      System.out.println("Current threads in pool: "
	         + pool.getPoolSize());
	      System.out.println("Currently executing threads: "
	         + pool.getActiveCount());
	      System.out.println("Total number of threads(ever scheduled): "
	         + pool.getTaskCount());

	      executor.shutdown();
		
	}
}
