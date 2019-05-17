package com.microservices.ch05

import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.BodyInserters.fromObject
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.ServerResponse.*
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono
import java.net.URI

@Component
class CustomerHandler(val customerService: CustomerService){
    fun get(serverReuest: ServerRequest) =
            customerService.getCustomer(serverReuest.pathVariable("id").toInt())
                    .flatMap { ok().body(fromObject(it)) }
                    .switchIfEmpty(status(HttpStatus.NOT_FOUND).build())

    fun create(serverReuest: ServerRequest) =
            customerService.createCustomer(serverReuest.bodyToMono()).flatMap {
                created(URI.create("/customer/${it.id}")).build()
            }

    fun delete(serverReuest: ServerRequest) =
            customerService.deleteCustomer(serverReuest.pathVariable("id").toInt())
                    .flatMap {
                        if(it) ok().build()
                        else status(HttpStatus.NOT_FOUND).build()
                    }
    fun search(serverRequest: ServerRequest): Mono<ServerResponse> =
            ServerResponse.ok().body(
                    customerService.searchCustomers(serverRequest.queryParam("nameFilter").orElse("")),
                    Customer::class.java
            )
}