package com.microservices.ch05

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch05Application

fun main(args: Array<String>) {
    runApplication<Ch05Application>(*args)
}
