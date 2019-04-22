package com.microservices.ch03

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import sun.jvm.hotspot.tools.jcore.NameFilter
import java.util.concurrent.ConcurrentHashMap

@RestController
class CustomerController {
    @Autowired
    lateinit var customers : ConcurrentHashMap<Int, Customer>

    @GetMapping("/customer/{id}")
    fun getCustromer(@PathVariable id: Int) = customers[id]

    @GetMapping("/customers")
    fun getCustomers(@RequestParam(required = false, defaultValue = "") nameFilter: String)
            = customers.filter { it.value.name.contains(nameFilter, true) }
                .map(Map.Entry<Int,Customer>::value).toList()
}