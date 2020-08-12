package com.example.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@Api(tags = "大聪明-接口类", value = "BigSmartController")
public class BigSmartController {

//    @Value("${myname}")
//    private String myName;

    @ApiOperation(value = "hello管理")
    @GetMapping("/hello")

    @Scheduled(cron = "3 * * * * ? ")
    public String hello() {
        return "I'm Big Smart!";
    }

//    @RequestMapping("/helloAct")
//    public String helloAct() {
//        return "我的名字是："+ myName;
//    }

}