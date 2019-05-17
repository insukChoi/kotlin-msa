package com.microservices.ch05

import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.find
import org.springframework.data.mongodb.core.findById
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
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

    fun findById(id: Int) = template.findById<Customer>(id)

    fun deleteById(id: Int)
            = template.remove(Query(Criteria.where("_id").isEqualTo(id)), Customer::class.java)

    fun findCustomer(nameFilter: String)
            = template.find(Query(Criteria.where("name").regex(".*$nameFilter.*", "i")), Customer::class.java)
}