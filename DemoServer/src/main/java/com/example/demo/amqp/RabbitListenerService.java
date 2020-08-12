package com.example.demo.amqp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
 
@Service
public class RabbitListenerService {
    /**
     * 添加监听器，自动获取消息队列信息
     * @param o
     */
    @RabbitListener(queues = {"myproduct","myarticle.new"})  //可监听多个queue
    public  void  rabbitMqListenerReceive(Object o){
        // 需要在启动入口添加 @EnableRabbit   开启基于注解的rabbitMQ模式
        System.out.println("接收的消息队列数据类型：" + o.getClass());
        System.out.println("接收的消息队列数据：" + o.toString());
    }
}