package com.eseasky.core.consumer.feign.controller;

import com.eseasky.protocol.providerServer.service.ProviderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NacosConsumerFeignController {
    @Autowired
    private ProviderServiceFeign providerServiceFeign;
    //http://127.0.0.1:9092/c/hi
    @GetMapping("/c/hi")
    public String hell(){
       return providerServiceFeign.hello(":我是feign消费者调用的");

    }
}
