/**   
 * Copyright: Copyright (c) 2017 Asiainfo
 * 
 * @ClassName: MySchedulerJon.java
 * @Description:
 *
 * @version: v1.0.0
 * @author: xujl3
 * @date:  2017年9月28日 下午5:33:47
 *
 * Modification History:
 * Date         Author          Version            Description
 *---------------------------------------------------------*
 * 2017年9月28日      	xujl3       	 v1.0.0         	新建
 */
package com.qfxx.demo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**   
 * @ClassName: MySchedulerJon   
 * @Description: <p></p>
 * @author xujl3  
 * @date 2017年9月28日 下午5:33:47   
 *      
 */
public class MySchedulerJob implements Job{
	
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	//org.quartz.SchedulerException: Problem instantiating class 'com.qfxx.demo.QuartzTest$MySchedulerJob' [See nested exception: java.lang.InstantiationException: com.qfxx.demo.QuartzTest$MySchedulerJob]
	//如果不添加默认无参构造函数，出现如上异常;这个实现了Job接口的子类需要独立成文件
	public MySchedulerJob() {
	}
	// 自定义调度Job，实现实际业务处理
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		
		try {
			System.out.println("[ scheduler name ："+context.getScheduler().getSchedulerName()+"]");
			System.out.println("[ trigger info : "+context.getTrigger().toString()+"]" );
			System.out.println("["+FORMAT.format(Calendar.getInstance().getTime())+"] Hello World!  MySchedulerJob is executing.");
			System.out.println();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
} 
