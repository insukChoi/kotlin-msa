package com.microservices.ch02

import org.springframework.beans.factory.annotation.Value

class ExampleService : ServiceInterface {
    @Value("\${service.message.text}")
    private lateinit var text : String

    override fun getHello(name:String) = "$text $name"
}