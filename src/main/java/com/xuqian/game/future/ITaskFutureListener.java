package com.xuqian.game.future;

public interface ITaskFutureListener<V extends ITaskFuture<?>> extends EventListener {
	void operationComplete(ITaskFuture<V> future) throws Exception;
}
