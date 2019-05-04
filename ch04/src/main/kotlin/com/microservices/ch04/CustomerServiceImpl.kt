package com.microservices.ch04

import com.microservices.ch04.Customer.Telephone
import org.springframework.stereotype.Component
import java.util.concurrent.ConcurrentHashMap

@Component
class CustomerServiceImpl : CustomerService {
    companion object {
        val initialCustomers = arrayOf(Customer(1,"kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microservie", Telephone("+44, 7123456789")))
    }
    val customers = ConcurrentHashMap<Int, Customer>(initialCustomers.associateBy(Customer::id))

    override fun getCustomer(id: Int): Customer? {
        return customers[id]
    }

    override fun searchCustomers(nameFilter: String): List<Customer> = customers.filter {
        it.value.name.contains(nameFilter, true)
    }.map(Map.Entry<Int, Customer>::value).toList()
}