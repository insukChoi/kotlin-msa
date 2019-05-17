//package com.microservices.ch05
//
//import com.microservices.ch05.Customer.Telephone
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Component
//import javax.annotation.PostConstruct
//
//@Component
//class DatabaseInitializer{
//
//    @Autowired
//    lateinit var customerRepository: CustomerRepository;
//
//    companion object {
//        val initialCusomers = listOf(Customer(1,"Kotlin"),
//                Customer(2, "Spring"),
//                Customer(3, "Microsevice", Telephone("+44", "7123456789")))
//    }
//
//    @PostConstruct
//    fun initData(){
//        customerRepository.saveAll(initialCusomers).subscribe{
//            println("Default customers created")
//        }
//    }
//}