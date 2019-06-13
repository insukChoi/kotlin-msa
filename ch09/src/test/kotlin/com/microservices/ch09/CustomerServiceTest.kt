package com.microservices.ch09

import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class CustomerServiceTest {
    @Autowired
    lateinit var customerSevice: CustomerSevice

    @Test
    fun we_should_get_a_customer_with_a_valid_id() {
        val customer = customerSevice.getCustomer(1)
        Assert.assertNotNull(customer)
        Assert.assertEquals(customer?.name, "Kotlin")
    }

    @Test
    fun we_should_get_all_customers() {
        val customers = customerSevice.getAllCustomers()
        Assert.assertEquals(customers.size, 3)
    }
}