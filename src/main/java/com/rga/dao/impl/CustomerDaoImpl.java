package com.rga.dao.impl;

import com.rga.dao.CustomerDao;
import com.rga.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Green
 * @since 2015/10/04
 */
@Service("customerDao")
public class CustomerDaoImpl implements CustomerDao {

    private ConcurrentMap<Integer, Customer> customers = new ConcurrentHashMap<>();

    @Override
    public boolean insert(Customer customer) {
        if (customer.getId() == null) {
            customer.setId(getNextSequenceNumber());
        }
        customers.put(customer.getId(), customer);
        return true;
    }

    @Override
    public int update(Customer customer) {
        if (null == customer) {
            throw new IllegalArgumentException("customer is null");
        }
        if (null == customer.getId()) {
            throw new IllegalArgumentException("customer id is null");
        }

        if (customers.containsKey(customer.getId())) {
            customers.replace(customer.getId(), customer);
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public int delete(Customer customer) {

        if (null == customer) {
            throw new IllegalArgumentException("customer is null");
        }
        if (null == customer.getId()) {
            throw new IllegalArgumentException("customer id is null");
        }

        if (customers.containsKey(customer.getId())) {
            customers.remove(customer.getId());
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public Customer query(Integer customerId) {
        if (customers.containsKey(customerId)) {
            return customers.get(customerId);
        }
        return null;
    }

    @Override
    public List<Customer> queryALl() {
        return new ArrayList(customers.values());
    }

    @Override
    public void clear() {
        customers.clear();
    }

    @Override
    public int countAll() {
        return customers.size();
    }

    public Integer getNextSequenceNumber() {
        return customers.size() + 1;
    }
}
