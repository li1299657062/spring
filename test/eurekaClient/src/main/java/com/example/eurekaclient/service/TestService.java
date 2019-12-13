package com.example.eurekaclient.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestService {
    @Value("${server.port}")
    private String port;

    @GetMapping("/test1")
    public String test1(@RequestParam(value = "name")String name){
        return  " name :"+name+"my port is :"+port;
    }

}
