package com.microservices.ch05

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.stereotype.Repository
import reactor.core.publisher.Mono
import reactor.core.publisher.toMono
import javax.annotation.PostConstruct

@Repository
class CustomerRepository(private val template: ReactiveMongoTemplate){

    companion object {
        val initialCusomers = listOf(Customer(1,"Kotlin"),
                Customer(2, "Spring"),
                Customer(3, "Microsevice", Customer.Telephone("+44", "7123456789")))
    }

    @PostConstruct
    fun initializeRepository()
            = initialCusomers.map(Customer::toMono).map(this::create).map(Mono<Customer>::subscribe)

    fun create(customer: Mono<Customer>) = template.save(customer)
}