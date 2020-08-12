package com.example.demo.threadpool;

import java.io.Console;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.SocketUtils;
@Component
public class MyThread extends Thread{
    Integer a = 0;
    @Override
    public void run(){
       System.out.println(Thread.currentThread().getName());
    }
    @Scheduled(cron = "0/3 * * * * ?")
    // @Scheduled(fixedDelay = 5000)
    public void fang() {
        // 创建一个定时任务的线程池
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(4);

        // 创建单线程的线程池
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();

        // 创建缓存线程池（重用先前的线程）
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

        // 创建一个带有固定线程的线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

    }
}