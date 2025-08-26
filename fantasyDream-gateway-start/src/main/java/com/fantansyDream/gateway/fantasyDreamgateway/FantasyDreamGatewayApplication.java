package com.fantansyDream.gateway.fantasyDreamgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.sql.DataSource;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FantasyDreamGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FantasyDreamGatewayApplication.class, args);
    }

}
