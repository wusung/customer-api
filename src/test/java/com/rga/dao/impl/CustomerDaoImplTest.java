package com.rga.dao.impl;

import com.rga.dao.CustomerDao;
import com.rga.dao.UserDao;
import com.rga.model.Customer;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Green
 * @since 2015/10/04
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml" })
public class CustomerDaoImplTest extends TestCase {

    @Autowired
    private CustomerDao customerDao;

    @Test
    public void testInsert() throws Exception {
        customerDao.clear();

        Customer customer = new Customer();
        customer.setId(1);
        boolean actual = customerDao.insert(customer);
        assertTrue(actual);
    }

    @Test
    public void testUpdate() throws Exception {

    }

    @Test
    public void testDelete() throws Exception {

    }

    @Test
    public void testQuery() throws Exception {

    }

    @Test
    public void testQueryALl() throws Exception {
        customerDao.clear();

        Customer customer = new Customer();
        customer.setId(1);
        customerDao.insert(customer);

        customer = new Customer();
        customer.setId(2);
        customerDao.insert(customer);

        assertEquals(2, customerDao.countAll());
    }
}