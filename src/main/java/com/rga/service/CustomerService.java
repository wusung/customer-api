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
    boolean updateCustomer(Integer customerId, Customer customer);
    Customer findCustomer(Integer customerId);
    List<Customer> findAllCustomers();
    Integer getNextSequenceNumber();
}
