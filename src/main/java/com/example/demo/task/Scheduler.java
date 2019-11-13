package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Scheduler {

    @Scheduled(fixedRate = 1000)
    public void test(){
        System.out.println(new Date());
    }
}
