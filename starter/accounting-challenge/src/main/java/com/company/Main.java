package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Customer> customerData2 = new ArrayList<>();
    private static List<String[]> customerData = Arrays.asList(
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "-7500", "01-10-2022"},
            new String[]{"1", "Wayne Enterprises", "18000", "12-22-2021"},
            new String[]{"3", "Ace Chemical", "-48000", "01-10-2022"},
            new String[]{"3", "Ace Chemical", "-95000", "12-15-2021"},
            new String[]{"1", "Wayne Enterprises", "175000", "01-01-2022"},
            new String[]{"1", "Wayne Enterprises", "-35000", "12-09-2021"},
            new String[]{"1", "Wayne Enterprises", "-64000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "70000", "12-29-2022"},
            new String[]{"2", "Daily Planet", "56000", "12-13-2022"},
            new String[]{"2", "Daily Planet", "-33000", "01-07-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"},
            new String[]{"2", "Daily Planet", "33000", "01-17-2022"},
            new String[]{"3", "Ace Chemical", "140000", "01-25-2022"},
            new String[]{"2", "Daily Planet", "5000", "12-12-2022"},
            new String[]{"3", "Ace Chemical", "-82000", "01-03-2022"},
            new String[]{"1", "Wayne Enterprises", "10000", "12-01-2021"}
    );


    public static List<Customer> createCustomers(List<String[]> customerData){
        String[] data;
        String id;
        String companyName;
        String charge;
        String chargeDate;
        List<String> idExists = new ArrayList<>();


        for(String[] c : customerData){
            data = c;
            id = data[0];
            companyName = data[1];
            charge = data[2];
            chargeDate = data[3];

            Customer customer = new Customer();
            AccountRecord record = new AccountRecord();

            if(idExists.contains(id) == false){
                //initialize the record object and add it to records array
                record.setCharge(Integer.parseInt(charge));
                record.setChargeDate(chargeDate);

                //initialize the customer object and add charges to the customer object
                customer.setId(Integer.parseInt(id));
                customer.setName(companyName);
                customer.getCharges().add(record);

                //append the customer object to customerData2 array
                idExists.add(id);
                customerData2.add(customer);

                System.out.println("new cust");
                System.out.println(customer);

            } else{
                for (Customer p : customerData2){
                    if(p.getName() == companyName){
                        customer = p;
                    }
                }
                charge = data[2];
                chargeDate = data[3];
                record.setCharge(Integer.parseInt(charge));
                record.setChargeDate(chargeDate);
                customer.getCharges().add(record);
                System.out.println("old cust");
                System.out.println(customer);

            }
        }

        return customerData2;
    }
    /*
    iterate through this stream ^, then take this array and set the values in the array to equal the elements
    in the Customer Class with the last two indexes representing the AccountRecord object within the customer object
    */

    public static List<Customer> positiveBalances(List<Customer> customers){
        List<Customer> posAccounts = new ArrayList<>();
        for(Customer c : customers){
            if(c.getBalance() >= 0 ){
                posAccounts.add(c);
            }
        }
        return posAccounts;
    }

    public static List<Customer> negativeBalances(List<Customer> customers){
        List<Customer> negAccounts = new ArrayList<>();
        for(Customer c : customers){
            if(c.getBalance() < 0 ){
                negAccounts.add(c);
            }
        }
        return negAccounts;
    }

    public static void main(String[] args) {
        /*Update this by iterating through the Customer data array and printing out positive balances
        under first print statement and negative under the second*/
        List<Customer> customers = createCustomers(customerData);
        List<Customer> posAccounts = positiveBalances(customers);
        List<Customer> negAccounts = negativeBalances(customers);

        System.out.println("Customers:");
        System.out.println(customers);
        System.out.println("------------------");
        System.out.println("Positive accounts:");
        System.out.println(posAccounts);
        System.out.println("------------------");
        System.out.println("Negative accounts:");
        System.out.println(negAccounts);
    }
}


