package com.microservices.ch08

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Ch08Application

fun main(args: Array<String>) {
    runApplication<Ch08Application>(*args)
}
