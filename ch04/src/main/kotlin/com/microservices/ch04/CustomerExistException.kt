package com.microservices.ch04

class CustomerExistException(override val message: String) : Exception(message)