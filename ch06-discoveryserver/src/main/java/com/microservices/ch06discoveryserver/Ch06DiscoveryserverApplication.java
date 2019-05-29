package com.microservices.ch06discoveryserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Ch06DiscoveryserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(Ch06DiscoveryserverApplication.class, args);
    }

}
