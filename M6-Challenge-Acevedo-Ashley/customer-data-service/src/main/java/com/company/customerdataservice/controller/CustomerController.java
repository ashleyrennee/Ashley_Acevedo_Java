package com.company.customerdataservice.controller;

import com.company.customerdataservice.model.Customer;
import com.company.customerdataservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repo;

    //Get customer by id
    @GetMapping("/customer/{id}")
    public Customer getCustomerById(@PathVariable Integer id){
        Optional<Customer> val = repo.findById(id);
        if(val.isPresent()){
            return val.get();
        }else{
            return null;
        }
    }

    //Get customer(s) by state
    @GetMapping("/customers/{state}")
    public List<Customer> getCustomerByState(@PathVariable String state){
        return repo.findByState(state);
    }

    //Create new customer
    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public Customer createCustomer(@RequestBody Customer customer){
        return repo.save(customer);
    }

    //update existing customer
    @PutMapping("/customer")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCustomer(@RequestBody Customer customer){
        repo.save(customer);
    }

    //delete an existing customer
    @DeleteMapping("/customer/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable Integer id){
        repo.deleteById(id);
    }
}
