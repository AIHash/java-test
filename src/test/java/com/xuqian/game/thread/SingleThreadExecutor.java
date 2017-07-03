package com.xuqian.game.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.xuqian.game.thread.pool.MyThread;

public class SingleThreadExecutor {
	
	public static void main(String[] args) {			
		
		ExecutorService pool = Executors.newSingleThreadExecutor();

		Thread t1 = new MyThread();
		t1.setName("线程1");
		Thread t2 = new MyThread();
		t1.setName("线程2");
		Thread t3 = new MyThread();
		t1.setName("线程3");
		Thread t4 = new MyThread();
		t1.setName("线程4");
		Thread t5 = new MyThread();
		t1.setName("线程5");
		
		pool.execute(t1);pool.execute(t2);
		pool.execute(t3);pool.execute(t4);pool.execute(t5);
		
	}
	

}
