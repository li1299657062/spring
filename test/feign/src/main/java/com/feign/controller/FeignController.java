package com.feign.controller;

import com.feign.dao.FeignMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feign")
public class FeignController {
    @Autowired
    private FeignMapper feignMapper;

    @GetMapping("/test")
    public String test(String name){
        return feignMapper.getTest(name);
    }
}
