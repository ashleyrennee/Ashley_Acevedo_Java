package com.company;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private int id;
    private String name;
    private List<AccountRecord> charges = new ArrayList<>();

    /*public Customer(int id, String name, List<AccountRecord> charges) {
        this.id = id;
        this.name = name;
        this.charges = charges;
    }*/
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        //update
        int sum = 0;
        for(AccountRecord c: charges){
            sum = sum + c.getCharge();
        }
        return sum;
    }
    public List<AccountRecord> getCharges() {
        return charges;
    }

    @Override
    public String toString() {
        //update
        return "Customer{" + "ID: " + getId() + "," + " Name: " + getName() + "," + " Balance: " + getBalance() + "}\n";
    }
}
