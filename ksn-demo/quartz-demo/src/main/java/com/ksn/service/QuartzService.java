package com.ksn.service;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/31 10:33
 */
@Service
public class QuartzService {

    public void test() throws SchedulerException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("jobData1", "asdf")
                .storeDurably()
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .forJob("job1", "group1")
                .usingJobData("t1", "qwer")
                .startNow()
                .withSchedule(CronScheduleBuilder.cronSchedule("*/1 * * * * ?"))
                .build();

        SimpleTrigger trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("trigger2", "group1")
                .forJob("job1", "group1")
                .usingJobData("t2", "qwer2")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(3).repeatForever())
                .build();

        scheduler.scheduleJob(jobDetail, trigger);

        scheduler.scheduleJob(trigger1);
        scheduler.start();
    }
}
