package com.feign.controller;

import com.feign.dao.FeignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lihang")
public class FeignController {
    @Autowired
    private FeignMapper feignMapper;

    @Value("${server.port}")
    private String port;

    @GetMapping("/test")
    public String test(String name){
        return this.port;
    }
}
