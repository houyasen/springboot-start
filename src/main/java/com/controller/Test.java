package com.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.dao")
@ComponentScan("com")//扫描包的路径
@EnableScheduling//开启定时任务的注解
@EnableAsync//开启异步调用方法
public class Test {

    public static void main(String[] args) {
        SpringApplication.run(Test.class,args);
    }
}
