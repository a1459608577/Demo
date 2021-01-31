package com.ksn.service;

import org.quartz.*;
import org.quartz.spi.MutableTrigger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/19 14:09
 */
@Configuration
public class SampleScheduler {

    @Bean
    public JobDetail jobDetail() {
        JobDetail build = JobBuilder.newJob(QuartzJob.class)
                .withIdentity("job1", "group1")
                .usingJobData("j1", "job1")
                .storeDurably()
                .build();
        return build;
    }

    @Bean
    public Trigger trigger() {
        SimpleTrigger build = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever())
                .forJob(jobDetail())
                .build();
        return build;
    }


}
