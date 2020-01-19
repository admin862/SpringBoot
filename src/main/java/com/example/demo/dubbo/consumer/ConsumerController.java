package com.example.demo.dubbo.consumer;

import com.example.demo.dubbo.provider.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Reference(version = "0.0.1")
    HelloService helloService;

    @RequestMapping("say_name")
    public String say(String name){
        return helloService.say(name);
    }
}
