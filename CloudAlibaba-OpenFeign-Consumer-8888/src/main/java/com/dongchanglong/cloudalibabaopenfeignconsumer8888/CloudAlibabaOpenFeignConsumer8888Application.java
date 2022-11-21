package com.dongchanglong.cloudalibabaopenfeignconsumer8888;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
// nacos
@EnableDiscoveryClient
// feign
@EnableFeignClients
public class CloudAlibabaOpenFeignConsumer8888Application {

    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaOpenFeignConsumer8888Application.class, args);
    }

}
