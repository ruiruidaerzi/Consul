package com.example.demo.amqp;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "myproduct")
public class RabbitMQTest {
    
    
    @Autowired
    RabbitTemplate rabbitTemplate;  //使用RabbitTemplate,这提供了接收/发送等等方法
    /**
     * 发送消息给RabbitMQ消息队列 发送单播 点对点的消息  direct方式
     */
    @RabbitHandler
    public void rabbitMqSendTest() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
 
        //方式一  以默认序列化的方式发送，如用json的方式，写RabbitConfig文件
        rabbitTemplate.convertAndSend("myexchange.direct", "myproduct", map);
    }

     /**
     * 发送消息给RabbitMQ消息队列 广播方式  fanout方式
     */
    @RabbitHandler
    public void rabbitMqSendTest2() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageData = "test message, hello!";
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
 
        //fanout广播方式 不用填路由键 无效
        rabbitTemplate.convertAndSend("myexchange.fanout", "", map);
    }

    /**
     * 从RabbitMQ接收消息
     */
    @RabbitHandler
    public void rabbitMqGetTest() {
        //收取消息成功后，会从相对应的消息队列里删除该消息
        Object o = rabbitTemplate.receiveAndConvert("myproduct");
        System.out.println("接收的消息队列数据类型：" + o.getClass());
        System.out.println("接收的消息队列数据：" + o.toString());
    }
}