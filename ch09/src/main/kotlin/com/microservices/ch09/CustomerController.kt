package com.microservices.ch09

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CustomerController {
    @Autowired
    lateinit var customerSevice: CustomerSevice

    @GetMapping("/customer/{id}")
    fun getCustomer(@PathVariable id: Int) = customerSevice.getCustomer(id)

    @GetMapping("/customers")
    fun getCustomers() = customerSevice.getAllCustomers()
}