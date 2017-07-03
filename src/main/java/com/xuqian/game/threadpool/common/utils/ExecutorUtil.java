package com.xuqian.game.threadpool.common.utils;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExecutorUtil {
	private static final Logger logger = LoggerFactory.getLogger(ExecutorUtil.class);
	// 默认 关闭前等待其中的任务结束的时间：5分钟
	private static final int DEFAULT_AWAIT_TERMINATE_MINUTES = 5;

	/**
	 * 关闭 executorService ,在关闭前默认等待5分钟
	 * 
	 * @param executorService
	 * @return
	 */
	public static List<Runnable> shutdownAndAwaitTermination(final ExecutorService executorService) {
		return shutdownAndAwaitTermination(executorService, DEFAULT_AWAIT_TERMINATE_MINUTES, TimeUnit.MINUTES);
	}

	/**
	 * 
	 * @param executorService
	 *            将要被停止的 ExecutorService
	 * @param awaitTerminateTimeOut
	 *            等待的时间
	 * @param timeUnit
	 *            时间单位
	 * @return 返回停止后任然未被开始执行的任务
	 */
	public static List<Runnable> shutdownAndAwaitTermination(final ExecutorService executorService,
			final long awaitTerminateTimeOut, final TimeUnit timeUnit) {
		List<Runnable> list = null;
		executorService.shutdown();
		try {
			boolean terminateResult = executorService.awaitTermination(awaitTerminateTimeOut, timeUnit);
			logger.info("[#ExecutorUtil.safeShudown] [Shutdown " + executorService + " "
					+ (terminateResult ? "Success" : "Fail") + "]");
			if (!terminateResult) {
				// 再次停止
				list = executorService.shutdownNow();
				for (Runnable runnable : list) {
					logger.warn("List runnable :" + runnable);
				}
				terminateResult = executorService.awaitTermination(awaitTerminateTimeOut, timeUnit);
				logger.info("[#ExecutorUtil.shutdownAndAwaitTermination] [ShutdwonNow " + executorService + " "
						+ (terminateResult ? "Success" : "Fail") + "]");
			}
		} catch (Exception e) {
			logger.error("[#ExecutorUtil.shutdownAndAwaitTermination] [ShutDownNow " + executorService + " " + "error ]"
					+ e.toString(), e);
			list = executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}

		return list;
	}
}
