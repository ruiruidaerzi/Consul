package com.example.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// 1 线程池数量上限为：Integer.MaxValue（2147483647）；
// 2 线程池默认空闲60S，超过60S会从线程池中移除；
// 3 新来任务时，先检查是否有空闲线程可使用，若无，则创建一个新线程执行任务；
// 4 任务存储在同步队列中。
// 5 适用场景：短时异步任务。
public class CacheThreadPool extends Thread{
    private int index;

    public CacheThreadPool(int i){
        this.index = i;
    }

    public void run() {
        try {
            System.out.println("[Thread"+this.index+"]" +"start..");
            Thread.sleep((int)(Math.random()*1000));
            System.out.println("[Thread"+this.index+"]" + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 创建10个工作线程用于处理任务，当线程执行完毕后，处于空闲状态，此时若出现新的任务，则会从线程池中用空闲的线程来处理新的任务。若没有空闲线程，则开启新线程处理
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        for(int i=0;i<10;i++){
            service.execute(new CacheThreadPool(i));
        }

        service.shutdown();
    }
}