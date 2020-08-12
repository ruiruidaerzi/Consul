package com.example.demo.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;
// 1 用于创建一个可重用、固定线程数量的线程池；
// 2 当线程池中线程都处于运行中时，新来的线程会进入等待状态，直到线程池中出现一个空闲线程；
// 3 当一个线程在任务中途退出、终止时，会有一个新的线程来替代它继续完成后面未完成的任务。
// 4 除非采用显式关闭的方法去关闭某个线程，否则线程会一直存在，不会释放资源。
// 5 任务存储在无界阻塞队列中
// 6 适用场景:长期任务
public class FixedThreadPool extends Thread{
    private int index;

    public FixedThreadPool(int i){
        this.index = i;
    }

    public void run(){
        try {
            
            System.out.println("[Thread]" + this.index + "]" + "start..");
            Thread.sleep((long) (Math.random() * 10000));
            System.out.println("[Thread"+this.index+"]" + "end");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //因为线程池中线程数量一共有4个，所以当一次有大于4个的任务需要执行时，因为线程池中无空闲线程，后续任务进入等待状态，当其他任务执行完毕后，线程空闲，则马上开始执行正在等待的任务
    public static void main(String[] args) {
        //自定义线程池
        // ThreadPoolExecutor th=new ThreadPoolExecutor(41, 100, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(50));
        ExecutorService service = Executors.newFixedThreadPool(4);
        for(int i=0;i<10;i++){
            service.execute(new FixedThreadPool(i));
        }
        service.shutdown();
    }
}