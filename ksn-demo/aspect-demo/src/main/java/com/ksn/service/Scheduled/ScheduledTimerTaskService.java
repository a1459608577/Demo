package com.ksn.service.Scheduled;

import java.util.Timer;
import java.util.TimerTask;

/**
 * java原生定时器timer
 *
 * @author ksn
 * @version 1.0
 * @date 2021/4/7 10:25
 */
public class ScheduledTimerTaskService {

    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("定时任务执行-------" + Thread.currentThread().getName() + "----"  + Thread.currentThread().getId());
            }
        };

        Timer timer = new Timer();

        timer.schedule(timerTask, 1000, 2000);
    }
}
