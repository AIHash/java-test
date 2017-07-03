package com.xuqian.game.thread.pool;

public class SubRunnable implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		 for (int i = 0; i < 10; i ++){
	            System.out.println(Thread.currentThread().getName() + ":" + i);
	        }
	}
	  public static void main(String[] args) {
	        System.out.println("begin main");
	        Thread thread = new Thread(new SubRunnable());
	        thread.start();
	        System.out.println("end main");
	    }
}
