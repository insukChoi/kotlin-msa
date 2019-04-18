package com.microservices.ch02

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class ExampleService : ServiceInterface {
    @Value("\${service.message.text}")
    private lateinit var text : String

    override fun getHello(name:String) = "$text $name"
}