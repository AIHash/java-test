package com.xuqian.game.threadpool.thread.factory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;

import com.xuqian.game.threadpool.common.enums.BlockingQueueType;
import com.xuqian.game.threadpool.thread.policy.AbortPolicy;
import com.xuqian.game.threadpool.thread.policy.BlockingPolicy;
import com.xuqian.game.threadpool.thread.policy.CallerRunsPolicy;
import com.xuqian.game.threadpool.thread.policy.DiscardOldestPolicy;
import com.xuqian.game.threadpool.thread.policy.DiscardPolicy;
import com.xuqian.game.threadpool.thread.policy.RejectedPolicyType;

public class GameThreadPoolHelpFactory {
    public RejectedExecutionHandler createPolicy(RejectedPolicyType rejectedPolicyType) {

        switch (rejectedPolicyType) {
            case BLOCKING_POLICY:
                return new BlockingPolicy();
            case CALLER_RUNS_POLICY:
                return new CallerRunsPolicy();
            case ABORT_POLICY:
                return new AbortPolicy();
            case DISCARD_POLICY:
                return new DiscardPolicy();
            case DISCARD_OLDEST_POLICY:
                return new DiscardOldestPolicy();
        }

        return null;
    }

    public RejectedExecutionHandler createPolicy(RejectedPolicyType rejectedPolicyType, String threadName) {

        switch (rejectedPolicyType) {
            case BLOCKING_POLICY:
                return new BlockingPolicy(threadName);
            case CALLER_RUNS_POLICY:
                return new CallerRunsPolicy(threadName);
            case ABORT_POLICY:
                return new AbortPolicy(threadName);
            case DISCARD_POLICY:
                return new DiscardPolicy(threadName);
            case DISCARD_OLDEST_POLICY:
                return new DiscardOldestPolicy(threadName);
        }

        return null;
    }

    public BlockingQueue<Runnable> createBlockingQueue(BlockingQueueType blockingQueueType, int queues) {

        switch (blockingQueueType) {
            case LINKED_BLOCKING_QUEUE:
                return new LinkedBlockingQueue<Runnable>();
            case ARRAY_BLOCKING_QUEUE:
                return new ArrayBlockingQueue<Runnable>(queues);
            case SYNCHRONOUS_QUEUE:
                return new SynchronousQueue<Runnable>();
        }

        return null;
    }

}
