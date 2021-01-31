//package com.ksn.service.quartz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.TimeUnit;
//
///**
// * @author ksn
// * @version 1.0
// * @date 2021/1/19 15:42
// */
//@Service
//public class QuartzService {
//
//    @Autowired
//    Scheduler scheduler;
//
//    public void test() throws SchedulerException {
////        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
//        JobDetail jobDetail = JobBuilder.newJob(SampleJob.class)
//                .withIdentity("j1", "g1")
//                .storeDurably()
//                .build();
//
//        SimpleTrigger trigger1 = TriggerBuilder.newTrigger()
//                .withIdentity("t1", "g1")
//                .forJob(jobDetail)
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
//                .build();
//
//        SimpleTrigger trigger2 = TriggerBuilder.newTrigger()
//                .withIdentity("t2", "g2")
//                .forJob(jobDetail)
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
//                .usingJobData("t2", "triggger2")
//                .build();
//
//        scheduler.scheduleJob(jobDetail, trigger1);
//        scheduler.scheduleJob(jobDetail, trigger2);
//        scheduler.start();
//        System.out.println(111111);
//        try {
//            TimeUnit.SECONDS.sleep(30);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        scheduler.pauseJob(jobDetail.getKey());
//    }
//
//}
