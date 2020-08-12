package com.example.demo.amqp;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public class RabbitConfig {
    /**
     * 用json方式替换默认的序列化
     * @return
     */
    @Bean
    public MessageConverter messageConverter()
    {
        return  new Jackson2JsonMessageConverter();
    }
}