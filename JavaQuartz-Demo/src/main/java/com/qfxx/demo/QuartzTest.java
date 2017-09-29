package com.qfxx.demo;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
public class QuartzTest {

	public static void main(String[] args) throws SchedulerException {
		// TODO Auto-generated method stub
		 // Grab the Scheduler instance from the Factory
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        // and start it off
        scheduler.start();
        
        //work
        doJob(scheduler);

//        scheduler.shutdown();
	}

	private static void doJob(Scheduler scheduler) throws SchedulerException{
		// define the job and tie it to our MyJob class
		JobDetail jobDetail = JobBuilder.newJob(MySchedulerJob.class)
				.withIdentity("job-1", "job-group-1").build();	
		
		//define a simple schedule and repeat every 5 seconds
		SimpleScheduleBuilder simpleSchedule = SimpleScheduleBuilder.simpleSchedule().
				withIntervalInSeconds(5).repeatForever();
		
		// Trigger the job to run now
		Trigger trigger = TriggerBuilder.newTrigger()
				.withIdentity("trigger-1", "trigger-group-1")
				.startNow().withSchedule(simpleSchedule)
				.build();
		
		// Tell quartz to schedule the job using our trigger
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
