package com.xuqian.game.threadpool.thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OrderedQueuePoolExecutor extends ThreadPoolExecutor {
	private static final Logger logger = LoggerFactory.getLogger(OrderedQueuePoolExecutor.class);

	
	public OrderedQueuePoolExecutor(int arg0, int arg1, long arg2, TimeUnit arg3, BlockingQueue<Runnable> arg4) {
		super(arg0, arg1, arg2, arg3, arg4);
	}

}
