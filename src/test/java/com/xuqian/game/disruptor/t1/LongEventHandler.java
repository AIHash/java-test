package com.xuqian.game.disruptor.t1;

import com.lmax.disruptor.EventHandler;

public class LongEventHandler implements EventHandler<LongEvent> {

	public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("Event:" + event);
		
	}

}
