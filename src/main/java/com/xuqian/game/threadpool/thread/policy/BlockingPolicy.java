package com.xuqian.game.threadpool.thread.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 堵塞
 * @author Xuqian
 *
 */
public class BlockingPolicy implements RejectedExecutionHandler {
    private static final Logger logger = LoggerFactory.getLogger(BlockingPolicy.class);

    private String threadName;

    public BlockingPolicy() {
        this(null);
    }

    public BlockingPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        if (!executor.isShutdown()) {
            try {
                executor.getQueue().put(runnable);
            } catch (InterruptedException e) {
            }
        }
    }
}