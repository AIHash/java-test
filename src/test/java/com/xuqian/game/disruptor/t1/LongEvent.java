package com.xuqian.game.disruptor.t1;


//定义事件
//事件(Event)就是通过 Disruptor 进行交换的数据类型。
public class LongEvent {
	private long value;
	
	public void set(long value) {
		this.value = value;
	}
}
