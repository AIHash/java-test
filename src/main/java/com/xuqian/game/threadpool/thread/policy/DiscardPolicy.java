package com.xuqian.game.threadpool.thread.policy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 删除
 * @author Xuqian
 *
 */
public class DiscardPolicy extends ThreadPoolExecutor.DiscardPolicy {
    private static final Logger logger = LoggerFactory.getLogger(DiscardPolicy.class);

    private final String threadName;

    public DiscardPolicy() {
        this(null);
    }

    public DiscardPolicy(String threadName) {
        this.threadName = threadName;
    }

    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor executor) {
        if (threadName != null) {
            logger.error("hread pool [{}] is exhausted, executor={}", threadName, executor.toString());
        }

        super.rejectedExecution(runnable, executor);
    }
}