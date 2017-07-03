package com.xuqian.game.disruptor.demo3;

import java.util.Random;

import com.lmax.disruptor.EventTranslator;
import com.xuqian.game.disruptor.demo1.TradeTransaction;

//��������Ϣ
public class TradeTransactionEventTranslator implements EventTranslator<TradeTransaction> {
	private Random random=new Random();
	
	public void translateTo(TradeTransaction event, long sequence) {
		this.generateTradeTransaction(event); 
	}
	
	private TradeTransaction generateTradeTransaction(TradeTransaction trade){  
        trade.setPrice(random.nextDouble()*9999);  
        return trade;
    }
	
}
