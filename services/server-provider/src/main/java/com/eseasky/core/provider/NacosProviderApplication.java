package com.eseasky.core.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication.class,args);
    }

    @RestController
    public class HelloController{
        @Value("${server.port}")
        private String port;
        // 注入配置文件上下文
        @Autowired
        private ConfigurableApplicationContext applicationContext;

        @GetMapping("/h/{msg}")
        public String hello(@PathVariable String msg){
            //http://127.0.0.1:8081/h/nihao
            /*
            http://ip:port/actuator/nacos-discovery。 EndPoint 的信息主要提供了两类:
            1、subscribe: 显示了当前有哪些服务订阅者
            2、NacosDiscoveryProperties: 显示了当前服务实例关于 Nacos 的基础配置
            * */
            return "hello nacos provider 调用传来的消息："+msg+"---调用的端口是"+port+
                    applicationContext.getEnvironment().getProperty("user.name");
        }
    }
}
