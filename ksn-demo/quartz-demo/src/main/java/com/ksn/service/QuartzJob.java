package com.ksn.service;

import cn.hutool.core.date.DatePattern;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author ksn
 * @version 1.0
 * @date 2021/1/31 10:35
 */
public class QuartzJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        Object t1 = context.getMergedJobDataMap().get("t1");
        Object t2 = context.getMergedJobDataMap().get("t2");
        Object jobData1 = context.getMergedJobDataMap().get("jobData1");
        System.out.println("jobData1: " + jobData1 + "t2: " + t2 + "t1: " + t1 + "----------" +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern(DatePattern.NORM_DATETIME_PATTERN)));
    }
}
