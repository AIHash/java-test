package com.xuqian.game.threadpool.thread.policy;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 抛弃老的
 * @author Xuqian
 *
 */
public class DiscardOldestPolicy extends ThreadPoolExecutor.DiscardOldestPolicy {
    private static final Logger logger = LoggerFactory.getLogger(DiscardOldestPolicy.class);

    private String threadName;

    public DiscardOldestPolicy() {
        this(null);
    }

    public DiscardOldestPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("Thread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}

