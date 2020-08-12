package com.example.demo.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolByDelay extends Thread{
    private int index;

    public ScheduledThreadPoolByDelay(){

    }

    public void run(){
        try {
             //每次任务大约耗时1秒
             Thread.sleep(1000);
             System.out.println("[Current Time is "+new Date().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // scheduleWithFixedDelay也是四个参数，分别是：待执行的任务Task，延迟时间t1，每次任务执行完毕后延迟t2秒后执行下次任务，延迟
    // public static void main(String[] args) {
    //     ExecutorService service = Executors.newScheduledThreadPool(10);

    //     service.scheduleWithFixedDelay(new ScheduledThreadPoolByDelay(), 5, 3, TimeUnit.SECONDS);
    // }
}