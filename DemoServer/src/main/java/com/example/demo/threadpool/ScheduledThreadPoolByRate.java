package com.example.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
// 1 任务存储在无界延迟队列中
// 2 适用场景：需要定期执行或延迟执行的任务
public class ScheduledThreadPoolByRate extends Thread{
    private int index;

    public void run() 
    {
        try 
        {
            System.out.println("[Thread"+this.index+"]" +"start..");
            Thread.sleep((int)(Math.random()*10000));
            System.out.println("[Thread"+this.index+"]" + "end");
        }catch(Exception e) 
        {
            e.printStackTrace();
        }
    }
            
    // scheduleAtFixedRate方法，一共四个参数，分别是：需要执行的任务task、延迟执行时间t1、每次执行任务的时间间隔t2、时间间隔单位。
    // 含义是：在t1时间过后，以 1次/t2 的频率来不断执行 task。
    // 上述代码中，在5秒延迟后，以 1次/1秒的频率执行 打印当前时间的任务。
    public static void main(String args[]) {
        /*
         * 执行定时任务newScheduledThreadPool
         */
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        
        //5秒后开始执行，每隔一秒执行一次
        service.scheduleAtFixedRate(new ScheduledThreadPoolByRate(), 5, 1, TimeUnit.SECONDS);
    }
}