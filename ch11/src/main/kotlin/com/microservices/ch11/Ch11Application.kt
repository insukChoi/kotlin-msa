package com.microservices.ch11

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch11Application

fun main(args: Array<String>) {
    runApplication<Ch11Application>(*args)
}
