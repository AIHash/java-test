package com.xuqian.game.thread.pool;

import java.util.Date;

public class MyThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����" + this.getName() +"��ǰʱ��" + new Date());
//		System.out.println("��ǰʱ��" + new Date());
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
