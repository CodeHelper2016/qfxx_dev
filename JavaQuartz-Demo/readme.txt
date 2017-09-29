##本demo使用Maven作为基础项目，添加Quartz相关关联jar，实现定时调度测试

	本demo使用Maven版本 apache-maven-3.2.5
	在实际使用过程中，使用存在的问题如下：
	1、修改pom.xml，增加 Quartz相关jar包，出现测试主类无法引用到Quartz相关API编译报错信息
		重新使用命令行执行 mvn clean install
		
	2、Maven Dependencies 完成下载后，执行出现 invalid LOC header (bad signature)报错
		删除错误提示中相关jar文件，重新使用命令行执行 mvn clean install
		
	3、使用Quartz 2.2.1 使用了slf4j-api-1.6.6.jar，出现 
		Failed to load class "org.slf4j.impl.StaticLoggerBinder" 异常，
	       修改pom.xml增加 slf4j-simple-1.6.6.jar依赖
	       或者 
	    <dependency>
	       <groupId>org.slf4j</groupId>
	       <artifactId>slf4j-log4j12</artifactId>
	       <version>1.6.6</version>
	   	</dependency>
	   	
	4、org.quartz.SchedulerException: Problem instantiating class 'com.qfxx.demo.QuartzTest$MySchedulerJob' [See nested exception: java.lang.InstantiationException: com.qfxx.demo.QuartzTest$MySchedulerJob]
		如果不添加默认无参构造函数，出现如上异常;这个实现了Job接口的子类需要独立成文件