package com.microservices.ch07

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class Ch07Application

@RestController
class GreetingsController{
    @GetMapping("/greetings")
    fun greetings() = "hello from a Docker"
}

fun main(args: Array<String>) {
    runApplication<Ch07Application>(*args)
}
