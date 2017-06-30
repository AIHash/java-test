package com.xuqian.game.disruptor.demo1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.lmax.disruptor.BatchEventProcessor;
import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.SequenceBarrier;
import com.lmax.disruptor.YieldingWaitStrategy;

public class demo1 {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int BUFFER_SIZE = 1024;
		int THREAD_NUMBERS = 4;

		/**createSingleProducer����һ���������ߵ�RingBuffer�� 
		 *  ��һ��������EventFactory���������������ǡ��¼�����������ʵ����ְ����ǲ����������RingBuffer�����顣 
		 *  �ڶ���������RingBuffer�Ĵ�С����������2��ָ���� Ŀ����Ϊ�˽���ģ����תΪ&�������Ч�� 
		 *  ������������RingBuffer����������û�п��������ʱ��(�����������ߣ�����˵���¼��������� ̫����)�ĵȴ�����
		 */
		final RingBuffer<TradeTransaction> ringBuffer = RingBuffer
				.createSingleProducer(new EventFactory<TradeTransaction>() {

					public TradeTransaction newInstance() {
						// TODO Auto-generated method stub
						return new TradeTransaction();  
					}
				}, BUFFER_SIZE, new YieldingWaitStrategy());

		// �����̳߳�
		ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUMBERS);
		// ����SequenceBarrier
		SequenceBarrier sequenceBarrier = ringBuffer.newBarrier();
		// ������Ϣ������
		BatchEventProcessor<TradeTransaction> transProcessor = new BatchEventProcessor<TradeTransaction>(ringBuffer,
				sequenceBarrier, new TradeTransactionInDBHandler());

		//��һ����Ŀ������RingBuffer����������״̬ ���ֻ��һ�������ߵ��������ʡ
		ringBuffer.addGatingSequences(transProcessor.getSequence());
		//����Ϣ�������ύ���̳߳�
		executorService.submit(transProcessor);
		//�������������� ���ظ�ִ������3�д���  ��TradeTransactionInDBHandler����������������
		
		Future<?> future = executorService.submit(new Callable<Void>() {

			public Void call() throws Exception {
				long seq;
				for (int i=0;i<1000;i++){
					seq=ringBuffer.next();
					//������������ ����  ����˴�����⣬����RingBuffer�Ľṹͼ  
					ringBuffer.get(seq).setPrice(Math.random()*9999);
					//����������������ʹhandler(consumer)�ɼ� 
                    ringBuffer.publish(seq);
				}
				return null;
			}
			
		});
		
		//�ȴ������߽���
		future.get();
		//����1�룬�����Ѷ�������� 
		Thread.sleep(1000);
		//֪ͨ�¼�(����˵��Ϣ)������ ���Խ����ˣ����������Ͻ���!!!��
		transProcessor.halt();
		//��ֹ�߳�  
		executorService.shutdown();
		
	}
}
