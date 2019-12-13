package com.feign.dao.feignFallback;

import com.feign.dao.FeignMapper;
import org.springframework.stereotype.Component;

@Component
public class FeignFallback implements FeignMapper {
    @Override
    public String getTest(String name) {
        return  "my name is  "+name+" error";
    }
}
