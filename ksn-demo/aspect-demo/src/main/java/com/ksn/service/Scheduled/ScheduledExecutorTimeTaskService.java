package com.ksn.service.Scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


/**
 * 定时任务线程池实现定时任务
 *
 * @author ksn
 * @version 1.0
 * @date 2021/1/13 17:35
 */
@Service
@Slf4j
public class ScheduledExecutorTimeTaskService {

    private int a = 0;

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);

    /**
     * 延时2s开始执行
     */
    public void task1() {
        scheduledExecutorService.schedule(() -> {
            log.info("task-start");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("task-end");
        },  3, TimeUnit.SECONDS);
    }

    /**
     * 间隔多久执行方法
     * @param a1 首次执行延迟多久
     * @param a2 每次执行间隔多久
     */
    public void task2(int a1, int a2) {
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            log.info("task-start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            a++;
            System.out.println(a);
            if (a > 5) {
                scheduledExecutorService.shutdown();
            }
            log.info("task-end");
        }, a1,a2, TimeUnit.SECONDS);
    }

    /**
     * 间隔多久执行方法, 跟task2作用差不多
     * 差别就是：
     *      scheduleWithFixedDelay： 是以上一个任务执行完后才开始计算间隔时间
     *      scheduleAtFixedRate： 是当上一个任务开始执行的时候就计算间隔时间，上一个任务完成后立即执行下一个任务，没有完成则等待
     * @param a1 首次执行延迟多久
     * @param a2 每次执行间隔多久
     */
    public void task3(int a1, int a2) {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            log.info("task-start");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("task-end");
        },  a1, a2, TimeUnit.SECONDS);
    }

    public static void main(String[] args) {
        ScheduledExecutorTimeTaskService service = new ScheduledExecutorTimeTaskService();
//        service.task1();
//        service.task2(0, 3);
        service.task3(0, 3);
    }

}
