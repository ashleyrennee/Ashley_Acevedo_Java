package com.company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CustomerTest {
    List<Customer> customerData;
    Customer customer,customer1,customer2,customer3;
    AccountRecord record,record1,record2,record3;

    @BeforeEach
    public void setUp(){
        customer = new Customer();

        record = new AccountRecord();
        record1 = new AccountRecord();
        record2 = new AccountRecord();
        record3 = new AccountRecord();
    }

    @Test
    public void shouldAddPositives(){
        customer.setId(1);
        customer.getBalance();
        customer.setName("Customer Name");

        record.setCharge(Integer.parseInt("100"));
        record1.setCharge(Integer.parseInt("100"));
        record2.setCharge(Integer.parseInt("400"));
        record3.setCharge(Integer.parseInt("1"));

        customer.getCharges().add(record);
        customer.getCharges().add(record1);
        customer.getCharges().add(record2);
        customer.getCharges().add(record3);
        assertEquals(601,customer.getBalance());
    }

    @Test
    public void shouldAddNegatives(){
        customer.setId(1);
        customer.getBalance();
        customer.setName("Customer Name");

        record.setCharge(Integer.parseInt("-100"));
        record1.setCharge(Integer.parseInt("-100"));
        record2.setCharge(Integer.parseInt("-400"));
        record3.setCharge(Integer.parseInt("-1"));

        customer.getCharges().add(record);
        customer.getCharges().add(record1);
        customer.getCharges().add(record2);
        customer.getCharges().add(record3);
        assertEquals(-601,customer.getBalance());
    }

    @Test
    public void shouldAddPosAndNegatives(){
        customer.setId(1);
        customer.getBalance();
        customer.setName("Customer Name");

        record.setCharge(Integer.parseInt("100"));
        record1.setCharge(Integer.parseInt("-100"));
        record2.setCharge(Integer.parseInt("400"));
        record3.setCharge(Integer.parseInt("-1"));

        customer.getCharges().add(record);
        customer.getCharges().add(record1);
        customer.getCharges().add(record2);
        customer.getCharges().add(record3);
        assertEquals(399,customer.getBalance());
    }

    @Test
    public void shouldReturnValueFromListOfOne(){
        customer.setId(1);
        customer.getBalance();
        customer.setName("Customer Name");
        record.setCharge(Integer.parseInt("100"));
        customer.getCharges().add(record);
        assertEquals(100,customer.getBalance());
    }

    @Test
    public void shouldReturnString(){
        customer.setId(1);
        customer.getBalance();
        customer.setName("Customer Name");
        assertEquals("Customer{ID: 1, Name: Customer Name, Balance: 0}\n",customer.toString());
    }

    @Test
    public void shouldReturnStringWithNoValues(){
        assertEquals("Customer{ID: 0, Name: null, Balance: 0}\n",customer.toString());
    }


}