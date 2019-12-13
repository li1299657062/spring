package com.feign.dao;

import com.feign.dao.feignFallback.FeignFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = FeignFallback.class)
public interface FeignMapper {
    @RequestMapping(value = "/test/test1",method = RequestMethod.GET)
    String getTest(@RequestParam(value = "name")String name);
}
