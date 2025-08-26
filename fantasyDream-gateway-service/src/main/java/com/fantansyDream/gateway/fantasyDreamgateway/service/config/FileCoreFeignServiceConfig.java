package com.fantansyDream.gateway.fantasyDreamgateway.service.config;


import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class FileCoreFeignServiceConfig {
    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    @Bean
    public Encoder feignEncoder() {
        // 先通过SpringEncoder处理JSON编码，再用SpringFormEncoder包装支持表单
        Encoder springEncoder = new SpringEncoder(messageConverters);
        return new SpringFormEncoder(springEncoder);
    }

    @Bean
    @Primary
    @Scope("prototype") // 多例保证线程安全
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(); // 启用表单编码器
    }
}
