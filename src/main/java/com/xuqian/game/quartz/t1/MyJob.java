package com.xuqian.game.quartz.t1;

import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job  {

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		System.out.println("任务正在执行，执行时间: " + Calendar.getInstance().getTime());
	}

}
