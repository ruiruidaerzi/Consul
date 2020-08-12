package com.example.demo.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix = "student") //前缀：对应consul 配置中心的 student 前缀
@Data
public class StudentConfig {
    private String name;
    private int age;
    private String sex;
}