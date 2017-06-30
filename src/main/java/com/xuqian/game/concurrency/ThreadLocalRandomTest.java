package com.xuqian.game.concurrency;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/*
 * java.util.concurrent.ThreadLocalRandom是从jdk 1.7开始引入的实用程序类，当需要多个线程或ForkJoinTasks来生成随机数时很有用。
 *  它提高了性能，并且比Math.random()方法占用更少的资源。
 */
public class ThreadLocalRandomTest {

	public static void main(final String[] args) {
		
		System.out.println("Random Integer: " + new Random().nextInt());  
	    System.out.println("Seeded Random Integer: " + new Random(15).nextInt());  
	    System.out.println("Thread Local Random Integer: " + ThreadLocalRandom.current().nextInt());
	    
		final ThreadLocalRandom random = ThreadLocalRandom.current();
		random.setSeed(15);
		
		System.out.println( "Seeded Thread Local Random Integer: " + random.nextInt());  
		
	}
}
