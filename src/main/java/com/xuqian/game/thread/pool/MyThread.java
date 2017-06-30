package com.xuqian.game.thread.pool;

import java.util.Date;

public class MyThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "正在执行。。。" + this.getName() +"当前时间" + new Date());
//		System.out.println("当前时间" + new Date());
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}
	
	
}
