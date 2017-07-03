package com.xuqian.game.threadpool.thread.executor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.xuqian.game.threadpool.thread.ThreadNameFactory;
import com.xuqian.game.threadpool.thread.worker.AbstractWork;

/**
 * 无序队列线程池
 * 
 * @author Xuqian
 *
 */
public class NonOrderedQueuePoolExecutor extends ThreadPoolExecutor {

	public NonOrderedQueuePoolExecutor(int corePoolSize) {
		super(corePoolSize, corePoolSize * 2, 30, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>());
	}

	public NonOrderedQueuePoolExecutor(String name, int corePoolSize) {
		super(corePoolSize, corePoolSize * 2, 30, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>(),
				new ThreadNameFactory(name));
	}

	public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maximumPoolSize) {
		super(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>(), new ThreadNameFactory(name));

	}

	public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maximumPoolSize,
			RejectedExecutionHandler rejectedExecutionHandler) {
		
		super(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS, 
				new LinkedBlockingQueue<Runnable>(),
				new ThreadNameFactory(name), rejectedExecutionHandler);

	}
	
	public NonOrderedQueuePoolExecutor(String name, int corePoolSize, int maximumPoolSize, 
			BlockingQueue blockingQueue, RejectedExecutionHandler rejectedExecutionHandler) {
        super(corePoolSize, maximumPoolSize, 30, TimeUnit.SECONDS,
                blockingQueue, new ThreadNameFactory(name), rejectedExecutionHandler);
    }
	
	public void executeWork(AbstractWork work) {
		execute(work);
	}
	
}
