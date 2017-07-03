package com.xuqian.game.threadpool.thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程名字工厂类
 * @author Xuqian
 *
 */
public class ThreadNameFactory implements ThreadFactory {
	private ThreadGroup group;
	private AtomicInteger threadNumber = new AtomicInteger(0);
	private String namePrefix;
	private boolean daemon;
	
	
	public ThreadNameFactory(String namePrefix) {
		this(namePrefix, false);
	}

	public ThreadNameFactory(String namePrefix, boolean daemon) {
		this.namePrefix = namePrefix;
		this.daemon = daemon;
	}

	public Thread newThread(Runnable task) {
		Thread thread = new Thread(group, task,namePrefix + threadNumber.getAndIncrement(),0);
		if (daemon) {
			thread.setDaemon(daemon);
		} else {
			if (thread.isDaemon()) {
				thread.setDaemon(false);
			}
			if (thread.getPriority() != Thread.NORM_PRIORITY) {
				thread.setPriority(Thread.NORM_PRIORITY);
			}
		}
		
		return thread;
	}
	
	public String getNamePrefix() {
		return namePrefix;
	}
	
}
