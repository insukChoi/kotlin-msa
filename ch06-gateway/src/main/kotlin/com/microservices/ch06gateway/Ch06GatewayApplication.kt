package com.microservices.ch06gateway

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

@SpringBootApplication
@EnableZuulProxy
class Ch06GatewayApplication

fun main(args: Array<String>) {
    runApplication<Ch06GatewayApplication>(*args)
}
