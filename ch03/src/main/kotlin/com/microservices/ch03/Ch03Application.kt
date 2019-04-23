package com.microservices.ch03

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch03Application

fun main(args: Array<String>) {
    runApplication<Ch03Application>(*args)
}
