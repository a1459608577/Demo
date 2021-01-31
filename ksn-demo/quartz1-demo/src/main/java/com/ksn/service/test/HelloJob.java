//package com.ksn.service.test;
//
//import lombok.extern.slf4j.Slf4j;
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.SchedulerException;
//import sun.rmi.runtime.Log;
//
//import java.time.LocalDateTime;
//
///**
// * @author ksn
// * @version 1.0
// * @date 2021/1/18 11:04
// */
//@Slf4j
//public class HelloJob implements Job {
//
//    String t1;
//    String t2;
//    String j1;
//    String j2;
//
//    public HelloJob() {}
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        log.info("j1:{}",context.getJobDetail().getJobDataMap().get("j1"));
//        log.info("j2:{}",context.getJobDetail().getJobDataMap().get("j2"));
//
//        log.info("t1:{}",context.getTrigger().getJobDataMap().get("t1"));
//        log.info("t2:{}",context.getTrigger().getJobDataMap().get("t2"));
//
//        log.info("合并后的map:{}",context.getMergedJobDataMap());
//
//        log.info("-------------------------------------------------------");
//        log.info("jobKey:{}",context.getJobDetail().getKey());
//        log.info("注入的值:t1: {},t2: {},j1: {},j2: {},",t1, t2, j1, j2);
//        log.info("-------------------------------------------------------");
//
//        Object skey = null;
//        try {
//            skey = context.getScheduler().getContext().get("skey");
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//
//        log.info("skey: {}", skey);
//        log.info(LocalDateTime.now().toString());
//    }
//
//    public void setT1(String t1) {
//        this.t1 = t1;
//    }
//
//    public void setT2(String t2) {
//        this.t2 = t2;
//    }
//
//    public void setJ1(String j1) {
//        this.j1 = j1;
//    }
//
//    public void setJ2(String j2) {
//        this.j2 = j2;
//    }
//}
