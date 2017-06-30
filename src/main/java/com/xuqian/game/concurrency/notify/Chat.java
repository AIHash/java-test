package com.xuqian.game.concurrency.notify;

public class Chat {
	
	boolean flag = false;
	
	public synchronized void Question(String msg) {
		if (flag) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(msg);
		flag = true;
		notify();
	}
	
	public synchronized void Answer(String msg) {
		if (!flag) {
			try {
				wait();
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(msg);
		flag = false;
		notify();
	}
	   
	public static void main(String[] args) {
		Chat m = new Chat();
		new Task1(m);
		new Task2(m);
	}
	
}
