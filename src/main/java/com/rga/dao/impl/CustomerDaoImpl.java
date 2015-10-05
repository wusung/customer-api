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

    public CustomerDaoImpl() {
        for (int i = 0; i < 100; i++) {
            Customer c = new Customer();
            c.setEmail(String.format("john%s@gmail.com", i));
            c.setAddress(String.format("Address %s}", i));
            c.setFirstname(String.format("First Name %s", i));
            c.setLastname(String.format("Last Name %s", i));
            c.setPhone(String.format("Phone %s", i));
            insert(c);
        }
    }

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
