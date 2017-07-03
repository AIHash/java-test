package com.xuqian.game.threadpool.thread.worker;

public abstract class AbstractWork implements Runnable {

	private TasksQueue<AbstractWork> tasksQueue;

	public TasksQueue<AbstractWork> getTaskQueue() {
		return tasksQueue;
	}

	public void setTaskQueue(TasksQueue<AbstractWork> tasksQueue) {
		this.tasksQueue = tasksQueue;
	}
	
}
