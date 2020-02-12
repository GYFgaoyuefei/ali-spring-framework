package com.eseasky.protocol.providerServer.service;

import com.eseasky.core.starters.feign.wrapper.config.Feign;
import com.eseasky.protocol.providerServer.fallback.ProviderServiceFeignFallback;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Feign(serviceName="nacos-provider")
public interface ProviderServiceFeign {
    @RequestLine("GET /h/{msg}")
    public String hello(@Param("msg") String msg);
}
