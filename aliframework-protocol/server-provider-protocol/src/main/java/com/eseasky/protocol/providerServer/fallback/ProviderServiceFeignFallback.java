package com.eseasky.protocol.providerServer.fallback;

import com.eseasky.protocol.providerServer.service.ProviderServiceFeign;
import org.springframework.stereotype.Component;

@Component
public class ProviderServiceFeignFallback implements ProviderServiceFeign {

    @Override
    public String hello(String msg) {
        return "请检查网络连接是否错误";
    }
}
