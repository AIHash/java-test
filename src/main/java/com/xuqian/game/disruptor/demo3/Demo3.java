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
		// ʹ��disruptor������������C1,C2
		EventHandlerGroup<TradeTransaction> handlerGroup = disruptor.handleEventsWith(new TradeTransactionVasConsumer(),
				new TradeTransactionInDBHandler());
		TradeTransactionJMSNotifyHandler jmsConsumer=new TradeTransactionJMSNotifyHandler();  
        
		//������C1,C2����֮��ִ��JMS��Ϣ���Ͳ��� Ҳ���������ߵ�C3  
        handlerGroup.then(jmsConsumer); 
        disruptor.start();//����  
        
        CountDownLatch latch=new CountDownLatch(1);  
        //������׼��  
        executorService.submit(new TradeTransactionPublisher(latch, disruptor));  
        latch.await();//�ȴ�����������. 
        
        disruptor.shutdown();  
        executorService.shutdown();  
          
        System.out.println("�ܺ�ʱ:"+(System.currentTimeMillis()-beginTime)); 
	}
}
