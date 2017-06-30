package com.xuqian.game.concurrency.notify;

public class Task1 implements Runnable {
	   Chat m;
	   String[] s1 = { "Hi", "How are you ?", "I am also doing fine!" };

	   public Task1(Chat m1) {
	      this.m = m1;
	      new Thread(this, "Question").start();
	   }

	   public void run() {
	      for (int i = 0; i < s1.length; i++) {
	         m.Question(s1[i]);
	      }
	   }
}
