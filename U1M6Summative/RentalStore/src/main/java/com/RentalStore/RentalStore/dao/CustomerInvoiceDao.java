package com.RentalStore.RentalStore.dao;

import com.RentalStore.RentalStore.model.Customer;

import java.util.List;

public interface CustomerInvoiceDao {


        Customer addCustomer (Customer customer);
        Customer getCustomer (int id);

        List<Customer> getAllCustomers();

        void updateCustomer(Customer customer);

        void deleteCustomer(int id);


    }