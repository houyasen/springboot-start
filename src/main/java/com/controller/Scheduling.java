package com.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduling {

    @Scheduled(fixedRate = 5000)
    public void scheling(){
        System.out.println(new Date());
    }
}
