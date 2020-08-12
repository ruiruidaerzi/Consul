package com.example.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
// 1 创建一个单个Worker的线程；
// 2 线程会按照顺序依次执行；
// 3 任务存储在无界阻塞队列中
// 4 适用场景：需要按照顺序执行的任务。
public class SingleThreadPool extends Thread{
    private int index;

    public SingleThreadPool(int i){
        this.index = i;
    }

    public void run(){
        try {
            System.out.println("[Thread"+this.index+"]" +"start..");
            Thread.sleep((int)(Math.random()*1000));
            System.out.println("[Thread"+this.index+"]" + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 出现多个任务时，SingleThreadExecutor会按照顺序依次执行各个任务。
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        for(int i=0;i<10;i++){
            service.execute(new SingleThreadPool(i));
        }

        service.shutdown();
    }
}