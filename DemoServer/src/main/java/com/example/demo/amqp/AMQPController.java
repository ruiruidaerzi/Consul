package com.example.demo.amqp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(tags = "接口类", value = "AMQPController")
public class AMQPController {

    @Autowired
    RabbitListenerService rabbitListenerService;

    /**
     * 推送投保状态
     * 
     * @return
     */
    @GetMapping("/rabbitMqListenerReceive")
    @ApiOperation(value = "获取")
    public void rabbitMqListenerReceive(@RequestParam(required = false, value = "json") Object o) {
        rabbitListenerService.rabbitMqListenerReceive(o);
    }
}