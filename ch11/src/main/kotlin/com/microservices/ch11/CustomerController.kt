package com.microservices.ch11

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController{
    companion object {
        val initialCustomers = arrayOf(Customer(1, "Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservice"))
        val customes = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy { it.id })
    }

    @GetMapping("/customers")
    fun getCustomers() = customes.values.toList()

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customes[id]
}