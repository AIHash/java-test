package com.xuqian.game.thread.pool;

import java.util.Date;

public class MyThread extends Thread {
	public void run() {
		System.out.println(Thread.currentThread().getName() + "����ִ�С�����" + this.getName() +"��ǰʱ��" + new Date());
//		System.out.println("��ǰʱ��" + new Date());
	}
}
