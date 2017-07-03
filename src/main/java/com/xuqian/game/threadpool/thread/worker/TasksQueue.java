package com.xuqian.game.threadpool.thread.worker;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;


public class TasksQueue<V> {
	//命令队列
	private final BlockingQueue<V> tasksQueue = new LinkedBlockingDeque<V>();
	private boolean processingCompleted = true;
	
	//下一执行命令
	public V poll() {
		return tasksQueue.poll();
	}
	
	//增加执行指令
	public boolean add(V value) {
		return tasksQueue.add(value);
	}
	
	//清理
	public void clear() {
		tasksQueue.clear();
	}
	
	//获取指令数量
	public int size() {
		return tasksQueue.size();
	}
	
	public boolean isProcessingCompleted() {
		return processingCompleted;
	}

	public void setProcessingCompleted(boolean processingCompleted) {
		this.processingCompleted = processingCompleted;
	}

}
