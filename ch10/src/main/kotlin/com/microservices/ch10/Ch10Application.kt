package com.microservices.ch10

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch10Application

fun main(args: Array<String>) {
    runApplication<Ch10Application>(*args)
}
