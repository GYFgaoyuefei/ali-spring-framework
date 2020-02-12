package com.eseasky.protocol.providerServer;

import com.eseasky.protocol.providerServer.service.ProviderServiceFeign;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.eseasky.core.starters.feign.wrapper.FeignClientFactory;
import feign.form.spring.SpringFormEncoder;

@ConditionalOnBean(FeignClientFactory.class)
@Configuration
public class ProviderServiceConfig {
	@Autowired
	FeignClientFactory factory;
	
	@Autowired
	ObjectFactory<HttpMessageConverters> messageConverters;
	
	@Bean
	public ProviderServiceFeign providerServiceFeign() {
		return factory.multipartclientFeign(ProviderServiceFeign.class,new SpringFormEncoder(new SpringEncoder(messageConverters)));
	}

}
