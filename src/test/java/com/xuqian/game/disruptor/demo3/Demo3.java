package com.xuqian.game.disruptor.demo3;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.lmax.disruptor.BusySpinWaitStrategy;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.EventHandlerGroup;
import com.lmax.disruptor.dsl.ProducerType;
import com.xuqian.game.disruptor.demo1.TradeTransaction;
import com.xuqian.game.disruptor.demo1.TradeTransactionInDBHandler;

public class Demo3 {
	public static void main(String[] args) throws InterruptedException {
		long beginTime = System.currentTimeMillis();
		int ringBufferSize = 1024;

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		Disruptor<TradeTransaction> disruptor = new Disruptor<TradeTransaction>(new EventFactory<TradeTransaction>() {

			public TradeTransaction newInstance() {
				return new TradeTransaction();
			}
		}, ringBufferSize, executorService, ProducerType.SINGLE, new BusySpinWaitStrategy());
		// 使用disruptor创建消费者组C1,C2
		EventHandlerGroup<TradeTransaction> handlerGroup = disruptor.handleEventsWith(new TradeTransactionVasConsumer(),
				new TradeTransactionInDBHandler());
		TradeTransactionJMSNotifyHandler jmsConsumer=new TradeTransactionJMSNotifyHandler();  
        
		//声明在C1,C2完事之后执行JMS消息发送操作 也就是流程走到C3  
        handlerGroup.then(jmsConsumer); 
        disruptor.start();//启动  
        
        CountDownLatch latch=new CountDownLatch(1);  
        //生产者准备  
        executorService.submit(new TradeTransactionPublisher(latch, disruptor));  
        latch.await();//等待生产者完事. 
        
        disruptor.shutdown();  
        executorService.shutdown();  
          
        System.out.println("总耗时:"+(System.currentTimeMillis()-beginTime)); 
	}
}
