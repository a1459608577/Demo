//package com.ksn.service.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.quartz.impl.calendar.HolidayCalendar;
//
//import java.time.LocalDateTime;
//import java.time.ZoneId;
//import java.time.ZoneOffset;
//import java.util.Date;
//
//import static org.quartz.DateBuilder.*;
//import static org.quartz.SimpleTrigger.MISFIRE_INSTRUCTION_FIRE_NOW;
//import static org.quartz.Trigger.MISFIRE_INSTRUCTION_IGNORE_MISFIRE_POLICY;
//
///**
// * @author ksn
// * @version 1.0
// * @date 2021/1/18 10:43
// */
//@Slf4j
//public class SimpleTriggerService {
//
//    public static void main(String[] args) throws SchedulerException {
//
//        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
//        defaultScheduler.getContext().put("skey", "sKey");
//
//        // 创建排除假期的Calender
//        HolidayCalendar cal = new HolidayCalendar();
//        // 添加要排除的时间段
//        cal.addExcludedDate(new Date());
//        // 注册到Scheduler上
//        defaultScheduler.addCalendar("cal", cal, false, false);
//
////        把Calendar用到trigger中
////        SimpleTrigger trigger = TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                .usingJobData("t1", "trigger1")
////                // 将Calendar用到trigger上
////                .modifiedByCalendar("cal")
////                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
////        trigger.getJobDataMap().put("t2", "trigger2");
//
////        指定时间开始触发，不重复：
////        LocalDateTime of = LocalDateTime.of(2021, 01, 18, 15, 33, 0);
////        Date from = Date.from(of.atZone(ZoneId.systemDefault()).toInstant());
////
////        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                .startAt(from)
////                .forJob("job1", "group1")
////                .build();
//
////       指定时间触发，每隔10秒执行一次，重复10次：
////        SimpleTrigger trigger = TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                // 设置开始时间，15后开始执行
////                .startAt(futureDate(15, DateBuilder.IntervalUnit.SECOND))
////                // 五秒执行一次，重复8次
////                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).withRepeatCount(8))
////                .forJob("job1", "group1")
////                .build();
////      立即触发，每个5s执行一次，直到22:00：
////        SimpleTrigger trigger = TriggerBuilder.newTrigger()
////                .withIdentity("trigger1", "group1")
////                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
////                .endAt(dateOf(15, 58, 0))
////                .build();
////      建立一个触发器，将在下一分钟的整点触发，然后每5s重复一次：
//        SimpleTrigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1", "group1")
//                .startAt(evenMinuteDate(null))
//                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(5).repeatForever())
//                .build();
//
//        JobDetail job = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("job1", "group1")
//                .usingJobData("j1", "job1")
//                .usingJobData("j2", "job2").build();
//
//        defaultScheduler.scheduleJob(job, trigger);
//        defaultScheduler.start();
//    }
//
//}
