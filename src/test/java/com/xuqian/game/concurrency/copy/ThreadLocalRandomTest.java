package com.xuqian.game.concurrency.copy;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


/*
 * java.util.concurrent.ThreadLocalRandom�Ǵ�jdk 1.7��ʼ�����ʵ�ó����࣬����Ҫ����̻߳�ForkJoinTasks�����������ʱ�����á�
 *  ����������ܣ����ұ�Math.random()����ռ�ø��ٵ���Դ��
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
