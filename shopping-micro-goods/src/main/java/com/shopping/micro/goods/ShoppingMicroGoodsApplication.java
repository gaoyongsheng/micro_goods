package com.shopping.micro.goods;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableCaching
@EnableSwagger2
@EnableEurekaClient
@EnableFeignClients
public class ShoppingMicroGoodsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShoppingMicroGoodsApplication.class, args);
    }

//    @Bean
//    @LoadBalanced
//    RestTemplate restTemplate() { return new RestTemplate(); }

}
