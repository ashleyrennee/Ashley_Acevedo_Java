package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

@WebMvcTest(CustomerController.class)
class CustomerControllerTest {
    @MockBean
    private CustomerRepository repo;
    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void shouldGetByState() throws Exception {
        mockMvc.perform(get("/customers/FL"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetCustomerById() throws Exception{
        mockMvc.perform(get("/customer/1"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void shouldDeleteCustomer() throws Exception {
        mockMvc.perform(delete("/customer/1"))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    @Test
    public void shouldCreateCustomer() throws Exception{
        Customer customer = new Customer();

        customer.setFirstName("Tasha");
        customer.setLastName("Gomez");
        customer.setAddressOne("1234 Blue Road");
        customer.setAddressTwo("5678 Pink Street");
        customer.setCustomerEmail("customer@email.com");
        customer.setCompany("Des Cosmetics");
        customer.setCity("Hollywood");
        customer.setState("FL");
        customer.setCountry("US");
        customer.setPostalCode("32456");

        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(post("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void shouldUpdateCustomer() throws Exception {
        Customer customer = new Customer();

        customer.setFirstName("Tasha");
        customer.setLastName("Gomez");
        customer.setAddressOne("1234 Blue Road");
        customer.setAddressTwo("5678 Pink Street");
        customer.setCustomerEmail("customer@email.com");
        customer.setCompany("Des Cosmetics");
        customer.setCity("Hollywood");
        customer.setState("FL");
        customer.setCountry("US");
        customer.setPostalCode("32456");

        String input = mapper.writeValueAsString(customer);

        mockMvc.perform(put("/customer")
                        .content(input)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNoContent());
    }
}