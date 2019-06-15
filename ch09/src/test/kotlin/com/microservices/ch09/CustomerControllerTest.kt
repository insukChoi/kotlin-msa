package com.microservices.ch09

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.then
import org.mockito.Mockito.reset
import org.mockito.Mockito.times
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.amshove.kluent.*
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.ResultHandler
import org.springframework.test.web.servlet.ResultMatcher
import org.springframework.test.web.servlet.result.JsonPathResultMatchers

class WithKeyword {
    infix fun `json path`(expression: String) = jsonPath("\$" + expression)
}
val With = WithKeyword()

class ThatKeyword {
    infix fun `status is http`(value: Int) = status().`is`(value)
}
val That = ThatKeyword()

infix fun JsonPathResultMatchers.`that the value is`(value: Any) = this.value(value)
infix fun ResultActions.`and expect`(matcher: ResultMatcher) = this.andExpect(matcher)
infix fun ResultActions.`and then do`(handler: ResultHandler) = this.andDo(handler)
infix fun MockMvc.`do a get request to`(uri: String) = this.perform(get(uri))

@RunWith(SpringRunner::class)
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest{
    @Autowired
    lateinit var mockMvc: MockMvc

    @MockBean
    lateinit var customerSevice: CustomerSevice

    @Test
    fun mock_mvc_should_be_configured(){}

    @Test
    fun we_should_GET_a_customer_by_id(){
        When calling customerSevice.getCustomer(1) `it returns`
                Customer(1, "mock customer")
        /*given(customerSevice.getCustomer(1))
                .willReturn(Customer(1, "mock customer"))*/

        (mockMvc `do a get request to` "/customer/1"
                `and expect` (That `status is http` 200)
                `and expect` (With `json path` ".id" `that the value is` 1)
                `and expect` (With `json path` ".name" `that the value is` "mock customer")
                ) `and then do` print()
        /*mockMvc.perform(get("/customer/1"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$.id").value(1))
                .andExpect(jsonPath("\$.name").value("mock customer"))
                .andDo(print())*/

        Verify on customerSevice that customerSevice.getCustomer(1) was called
        `Verify no further interactions` on customerSevice
       /* then(customerSevice).should(times(1)).getCustomer(1)
        then(customerSevice).shouldHaveNoMoreInteractions()*/

        reset(customerSevice)
    }

    @Test
    fun we_should_GET_a_list_of_customers(){
        When calling customerSevice.getAllCustomers() `it returns`
                listOf(Customer(1, "test"), Customer(2, "mocks"))
        /*given(customerSevice.getAllCustomers())
                .willReturn(listOf(Customer(1, "test"), Customer(2, "mocks")))*/

        (mockMvc `do a get request to` "/customers"
                `and expect` (That `status is http` 200)
                `and expect` (With `json path` "[0].id" `that the value is` 1)
                `and expect` (With `json path` "[0].name" `that the value is` "test")
                `and expect` (With `json path` "[1].id" `that the value is` 2)
                `and expect` (With `json path` "[1].name" `that the value is` "mocks")
                ) `and then do` print()
        /*mockMvc.perform(get("/customers"))
                .andExpect(status().isOk)
                .andExpect(jsonPath("\$").isArray)
                .andExpect(jsonPath("\$[0].id").value(1))
                .andExpect(jsonPath("\$[0].name").value("test"))
                .andExpect(jsonPath("\$[1].id").value(2))
                .andExpect(jsonPath("\$[1].name").value("mocks"))
                .andDo(print())*/

        Verify on customerSevice that customerSevice.getAllCustomers() was called
        `Verify no further interactions` on customerSevice
       /* then(customerSevice).should(times(1)).getAllCustomers()
        then(customerSevice).shouldHaveNoMoreInteractions()*/

        reset(customerSevice)
    }
}