package com.microservices.ch09

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch09Application

fun main(args: Array<String>) {
    runApplication<Ch09Application>(*args)
}
