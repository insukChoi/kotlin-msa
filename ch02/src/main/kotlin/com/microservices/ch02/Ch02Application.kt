package com.microservices.ch02;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.ResponseBody

@SpringBootApplication
open class Ch02Application{
    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}' == 'simple'}")
    open fun exampleService() : ServiceInterface = ExampleService()

    @Bean
    @ConditionalOnExpression("#{'\${service.message.type}' == 'advance'}")
    open fun advanceService() : ServiceInterface = AdvanceService()
}

@Controller
class FirtstController() {
    @Autowired
    lateinit var service : ServiceInterface

    @RequestMapping(value="/user/{name}", method = arrayOf(RequestMethod.GET))
    @ResponseBody
    fun hello(@PathVariable name:String) = service.getHello(name)
}

fun main(args: Array<String>){
    runApplication<Ch02Application>(*args)
}


