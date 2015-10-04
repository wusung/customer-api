package com.rga.dao;

import com.rga.model.Customer;

import java.util.List;

/**
 * @author Green
 * @since 2015/10/04
 */
public interface CustomerDao {
    boolean insert(Customer customer);
    int update(Customer customer);
    int delete(Customer customer);
    Customer query(Integer customerId);
    List<Customer> queryALl();
    void clear();
    int countAll();
}
