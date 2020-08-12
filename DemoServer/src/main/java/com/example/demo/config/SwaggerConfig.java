 package com.example.demo.config;


 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 import springfox.documentation.builders.ApiInfoBuilder;
 import springfox.documentation.service.ApiInfo;
 import springfox.documentation.swagger2.annotations.EnableSwagger2;

 @Configuration
 @EnableSwagger2
 public class SwaggerConfig {

   @Bean
   public ApiInfo webApiInfo() {

     return new ApiInfoBuilder().title("网站-课程中心API文档").description("本文档描述了课程中心微服务接口定义").version("1.0").build();
   }

 }