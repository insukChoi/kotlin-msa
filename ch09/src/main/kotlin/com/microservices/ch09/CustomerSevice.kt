package com.microservices.ch09

interface CustomerSevice{
    fun getCustomer(id:Int): Customer?
    fun getAllCustomers(): List<Customer>
}