package com.xuqian.game.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestFixedThreadPool {
	
	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(6);
		
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

		Thread t6 = new MyThread();
		t1.setName("线程6");
		Thread t7 = new MyThread();
		t1.setName("线程7");
		Thread t8 = new MyThread();
		t1.setName("线程8");
		Thread t9 = new MyThread();
		t1.setName("线程9");
		Thread t10 = new MyThread();
		t1.setName("线程10");
		
		Thread t11 = new MyThread();
		t1.setName("线程11");
		Thread t12 = new MyThread();
		t1.setName("线程12");
		Thread t13 = new MyThread();
		t1.setName("线程13");
		Thread t14 = new MyThread();
		t1.setName("线程14");
		Thread t15 = new MyThread();
		t1.setName("线程15");
		
		Thread t16 = new MyThread();
		t1.setName("线程16");
		Thread t17 = new MyThread();
		t1.setName("线程17");
		Thread t18 = new MyThread();
		t1.setName("线程18");
		Thread t19 = new MyThread();
		t1.setName("线程19");
		Thread t20 = new MyThread();
		t1.setName("线程20");
		
		Thread t21 = new MyThread();t21.setName("线程21");
		t21.setDaemon(true);t21.start();
		
		Thread t22 = new MyThread();t22.setName("线程22");
		t22.setDaemon(true);t22.start();
		
		Thread t23 = new MyThread();t23.setName("线程23");
		t23.setDaemon(true);t23.start();
		
		pool.execute(t1);pool.execute(t2);
		pool.execute(t3);pool.execute(t4);
		pool.execute(t5);pool.execute(t6);
		pool.execute(t7);pool.execute(t8);
		pool.execute(t9);pool.execute(t10);
		pool.execute(t11);pool.execute(t12);
		pool.execute(t13);pool.execute(t14);
		pool.execute(t15);pool.execute(t16);
		pool.execute(t17);pool.execute(t18);
		pool.execute(t19);pool.execute(t20);

	}
}
