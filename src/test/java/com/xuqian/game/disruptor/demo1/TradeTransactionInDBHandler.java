package com.xuqian.game.disruptor.demo1;

import java.util.UUID;

import com.lmax.disruptor.EventHandler;
import com.lmax.disruptor.WorkHandler;

public class TradeTransactionInDBHandler implements EventHandler<TradeTransaction>,WorkHandler<TradeTransaction> {

	//EventHandler
	public void onEvent(TradeTransaction event, long sequence, boolean endOfBatch) throws Exception {		
		this.onEvent(event);
	}

	//WorkHandler
	public void onEvent(TradeTransaction event) throws Exception {
		 //����������������߼�  
        event.setId(UUID.randomUUID().toString());//��������ID
        System.out.println(event.getId());
	}

}
