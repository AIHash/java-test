package com.xuqian.game.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.xuqian.game.threadpool.thread.executor.OrderedQueuePoolExecutor;
import com.xuqian.game.threadpool.thread.factory.GameThreadPoolHelpFactory;
import com.xuqian.game.threadpool.thread.policy.RejectedPolicyType;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		int coreSize = 1;
		int maxSize = 100;
		long time = 1;
		
		TimeUnit timeUnit = TimeUnit.SECONDS;
		
		LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
		ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(5);
        BlockingQueue blockingQueue = arrayBlockingQueue;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize, time, timeUnit, blockingQueue, rejectedExecutionHandler());
        int threadSize = 100;
        for(int i = 0; i < threadSize; i++){
            try {
                threadPoolExecutor.execute(new TaskTest(i));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        System.out.println("d");
        
        OrderedQueuePoolExecutor executor = new OrderedQueuePoolExecutor("有序线程池", 2, 3);
        executor.execute(new Task1Test());
        OrderedQueuePoolExecutor executor1 = new OrderedQueuePoolExecutor("有序线程池1", 2, 3);
        executor1.execute(new Task1Test());
        OrderedQueuePoolExecutor executor2 = new OrderedQueuePoolExecutor("有序线程池2", 2, 3);
        executor2.execute(new Task1Test());
        
	}

	public static RejectedExecutionHandler rejectedExecutionHandler(){
        GameThreadPoolHelpFactory gameThreadPoolHelpFactory = new GameThreadPoolHelpFactory();
        RejectedPolicyType rejectedPolicyType = RejectedPolicyType.ABORT_POLICY;
        return gameThreadPoolHelpFactory.createPolicy(rejectedPolicyType, "test");
    }
	
}
