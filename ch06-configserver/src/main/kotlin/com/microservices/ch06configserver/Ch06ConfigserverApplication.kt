package com.microservices.ch06configserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
class Ch06ConfigserverApplication

fun main(args: Array<String>) {
    runApplication<Ch06ConfigserverApplication>(*args)
}
