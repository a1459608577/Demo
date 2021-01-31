package com.ksn.service.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * spring的@Scheduled注解实现定时任务
 *
 * @author ksn
 * @version 1.0
 * @date 2021/1/13 18:38
 */
@Service
@Slf4j
public class ScheduledAnnotationTimeTaskService {

    /**
     * 每隔2s执行一次，如果上次任务超过2s则上次任务结束后马上下一次任务，
     */
//    @Scheduled(initialDelay=5000, fixedRate = 4000)
    public void task1() {
        log.info("task-start1");
        sleep(1);
        log.info("task-end1");
    }

    /**
     * initialDelay: 首次任务执行延迟的时间
     * fixedRate： 它的间隔2s是以上一个任务开始执行开始计算，
     * fixedDelay： 它的间隔2s是等上一次任务执行完了等2s再执行下一个任务
     */
//    @Scheduled(initialDelay=5000, fixedDelay = 4000)
    public void task2() {
        log.info("task-start2");
        sleep(1);
        log.info("task-end2");
    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void task3() {
        log.info("task-start3");
        sleep(1);
        log.info("task-end3");
    }

    public static void sleep(int a) {
        try {
            TimeUnit.SECONDS.sleep(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
