package com.company.customerdataservice.repository;

import com.company.customerdataservice.model.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerRepositoryTest {
    @Autowired
    CustomerRepository custRepo;

    @BeforeEach
    public void setUp() throws Exception{
        custRepo.deleteAll();
    }

    @Test
    public void createCustomer(){
        //Arrange
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
        //Act
        customer = custRepo.save(customer);
        //Assert
        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);
    }

    @Test
    public void getCustomersByState() {
        //Arrange
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
        //Act
        customer = custRepo.save(customer);

        Customer customer2 = new Customer();
        customer2.setFirstName("Tasha");
        customer2.setLastName("Gomez");
        customer2.setAddressOne("1234 Blue Road");
        customer2.setAddressTwo("5678 Pink Street");
        customer2.setCustomerEmail("customer@email.com");
        customer2.setCompany("Des Cosmetics");
        customer2.setCity("Hollywood");
        customer2.setState("FL");
        customer2.setCountry("US");
        customer2.setPostalCode("32456");
        //Act
        customer2 = custRepo.save(customer2);

        List<Customer> customerList = custRepo.findByState(customer.getState());
        assertEquals(2,customerList.size());
    }

    @Test
    public void updateCustomer(){
        Customer customer = new Customer();

        customer.setFirstName("Carmen");
        customer.setLastName("Rivera");
        customer.setAddressOne("1234 Green Road");
        customer.setAddressTwo("5678 Orange Street");
        customer.setCustomerEmail("custome1r@email.com");
        customer.setCompany("Carmen Cosmetics");
        customer.setCity("Hollywood");
        customer.setState("FL");
        customer.setCountry("US");
        customer.setPostalCode("32456");

        customer = custRepo.save(customer);

        customer.setFirstName("UPDATED");

        custRepo.save(customer);

        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());

        assertEquals(customer1.get(),customer);
    }


    @Test
    public void deleteCustomer(){
        Customer customer = new Customer();

        customer.setFirstName("April");
        customer.setLastName("Rosa");
        customer.setAddressOne("1234 Purple Road");
        customer.setAddressTwo("5678 Yellow Street");
        customer.setCustomerEmail("custome3r@email.com");
        customer.setCompany("Rosa Cosmetics");
        customer.setCity("Hollywood");
        customer.setState("FL");
        customer.setCountry("US");
        customer.setPostalCode("32456");

        customer = custRepo.save(customer);

        custRepo.deleteById(customer.getCustomerId());

        Optional<Customer> customer1 = custRepo.findById(customer.getCustomerId());
        assertFalse(customer1.isPresent());
    }
}