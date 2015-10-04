package com.rga.service;

import com.rga.model.Customer;

import java.util.List;

/**
 * @author Green
 * @since 2015/10/04
 */
public interface CustomerService {

    boolean addCustomer(Customer customer);
    boolean removeCustomer(Integer customerId);
    boolean updateCustomer(Customer newCustomer, Customer oldCustomer);
    Customer findCustomer(Integer customerId);
    List<Customer> findAllCustomers();
}
