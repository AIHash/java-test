package com.xuqian.game.disruptor.demo3;

import com.lmax.disruptor.EventHandler;
import com.xuqian.game.disruptor.demo1.TradeTransaction;

public class TradeTransactionVasConsumer implements EventHandler<TradeTransaction> {

	public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("收到这个事件");
	}

}
