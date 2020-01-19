package com.example.demo.dubbo.provider;


import org.apache.dubbo.config.annotation.Service;

@Service(version = "0.0.1")
public class HelloServcieImpl implements HelloService {

  @Override
  public String say(String name) {
    return name + " 你好！";
  }
}
