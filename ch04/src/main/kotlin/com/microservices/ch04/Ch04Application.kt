package com.microservices.ch04

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch04Application

fun main(args: Array<String>) {
    runApplication<Ch04Application>(*args)
}
