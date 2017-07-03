package com.xuqian.game.quartz.h2;

import java.util.Properties;

import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

public class JobUtil {
	private static SchedulerFactory schedulerFactory = null;
	
	public JobUtil() {
	}
	
	
	private static synchronized SchedulerFactory getSchedulerFactory() {
		if (schedulerFactory == null){
			schedulerFactory = new StdSchedulerFactory();
			
			Properties p = new Properties();
			p.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
			p.put("org.quartz.threadPool", "10");
			
			try {
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return schedulerFactory;
	}

	
}
