package com.xuqian.game.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public interface ITaskFuture<V> extends Future<V> {
	// 是否成功
	public boolean isSuccess();

	// 获取执行结果
	public V getNow();

	// 是否可以取消
	public boolean isCancellable();

	// 等待future完成
	public ITaskFuture<V> await() throws InterruptedException, ExecutionException;

	// 等待future超时完
	public boolean await(long timeOutMills) throws InterruptedException;

	// 等待future超时完成
	public boolean await(long timeOut, TimeUnit timeUnit) throws InterruptedException;

	// 等待future完成，不相应中断
	public ITaskFuture<V> awaitUninterruptibly() throws Exception;

	public boolean awaitUninterruptibly(long timeOutMills);

	public boolean awaitUninterruptibly(long timeOut, TimeUnit timeUnit);

	public ITaskFuture<V> addListener(ITaskFutureListener listener);

	public ITaskFuture<V> removeListener(ITaskFuture<V> listener);
}
