package com.rga.service.impl;

import com.rga.dao.CustomerDao;
import com.rga.model.Customer;
import com.rga.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Green
 * @since 2015/10/04
 */
@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {
        if (null == customer) {
            throw new IllegalArgumentException("customer is null");
        }

        if (customer.getId() == null)
            customer.setId(customerDao.getNextSequenceNumber());
        return customerDao.insert(customer);
    }

    @Override
    public boolean removeCustomer(Integer customerId) {
        if (null == customerId) {
            throw new IllegalArgumentException("customer is null");
        }

        Customer customer = new Customer();
        customer.setId(customerId);
        int rowAffected = customerDao.delete(customer);
        return rowAffected > 0;
    }

    @Override
    public boolean updateCustomer(Integer customerId, Customer customer) {
        customer.setId(customerId);
        int rowAffected = customerDao.update(customer);
        return rowAffected > 0;
    }

    @Override
    public Customer findCustomer(Integer customerId) {
        if (null == customerId) {
            throw new IllegalArgumentException("customerId is null");
        }

        return customerDao.query(customerId);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return customerDao.queryALl();
    }

    @Override
    public Integer getNextSequenceNumber() {
        return customerDao.getNextSequenceNumber();
    }
}
