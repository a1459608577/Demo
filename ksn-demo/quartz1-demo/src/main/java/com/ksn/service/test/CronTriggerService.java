//package com.ksn.service.test;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.quartz.listeners.JobListenerSupport;
//
//import java.util.TimeZone;
//
//import static org.quartz.CronScheduleBuilder.*;
//
///**
// * @author ksn
// * @version 1.0
// * @date 2021/1/18 16:42
// */
//public class CronTriggerService {
//
//    public static void main(String[] args) throws SchedulerException {
//
//        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
//        defaultScheduler.getContext().put("skey", "sKey");
//
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("job1", "group1")
//                .usingJobData("j1", "job1")
//                .usingJobData("j2", "job2")
//                .build();
//
////        建立一个触发器，每隔一分钟，每天上午8点至下午5点之间：
////        CronTrigger trigger = TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                .withSchedule(CronScheduleBuilder.cronSchedule("*/3 * 8-17 * * ?"))
////                .build();
////        每天下午16：57发生
////        CronTrigger trigger = TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                .withSchedule(dailyAtHourAndMinute(16, 57))
////                .forJob("job1", "group1")
////                .build();
////      建立一个触发器，将每周一的17:08触发：
//        CronTrigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.MONDAY, 17, 8))
//                .forJob("job1", "group1")
//                .build();
//
//        defaultScheduler.scheduleJob(jobDetail, trigger);
//        defaultScheduler.start();
//    }
//}
