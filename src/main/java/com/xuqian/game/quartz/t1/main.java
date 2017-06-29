package com.xuqian.game.quartz.t1;

import java.util.Date;

import org.quartz.DateBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class main {
	
	public static void main(String[] args) throws InterruptedException {
		SchedulerFactory factory = new StdSchedulerFactory();
		//�ӹ��������õ�һ��schedulerʵ��
		try {
			Scheduler scheduler = factory.getScheduler();
			// ��������Ŀ�ʼʱ�䣬DateBuilder.evenMinuteDate������ȡ��һ����������  
	        Date runTime = DateBuilder.evenMinuteDate(new Date());
	        // ����ִ�е����񲢲���Job�ӿڵ�ʵ���������÷���ķ�ʽʵ������һ��JobDetailʵ��  
	        JobDetail job = JobBuilder.newJob(MyJob.class).withIdentity("job1", "group1").build();  
	        // ����һ����������startAt��������������Ӧ����ʼ��ʱ��  
	        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();  
	        // �������Trigger����scheduler  
	        scheduler.scheduleJob(job, trigger);
	        scheduler.start();
	        // �ȴ�65�룬��֤��һ���������ӳ��֣�����ע�⣬������߳�ֹͣ�������ǲ���ִ�е�  
	        Thread.sleep(65L * 1000L);
	        // scheduler����  
	        scheduler.shutdown(true);
	        
		} catch (SchedulerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  

	}

}
