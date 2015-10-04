package com.rga.service.impl;

import com.rga.model.Customer;
import com.rga.service.CustomerService;
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
public class CustomerServiceImplTest extends TestCase {

    @Autowired
    private CustomerService customerService;

    @Test
    public void testAddCustomer() throws Exception {

        Customer customer = new Customer();
        customer.setId(1);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerIsNull() throws Exception {

        Customer customer = null;
        customerService.addCustomer(customer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCustomerIdIsNull() throws Exception {

        Customer customer = new Customer();
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        customerService.addCustomer(customer);
    }

    @Test
    public void testRemoveCustoemr() throws Exception {
        Customer customer = new Customer();
        customer.setId(3);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        actual = customerService.removeCustomer(3);
        assertTrue(actual);
    }

    @Test
    public void testUpdateCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(4);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        boolean actualCustomer = customerService.removeCustomer(4);
        assertTrue(actualCustomer);
    }

    @Test
    public void testFindCustomer() throws Exception {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setAddress("Taipei Taiwan");
        customer.setEmail("john@gmail.com");
        customer.setFirstname("Cannon");
        customer.setLastname("John");
        customer.setPhone("028825252");

        boolean actual = customerService.addCustomer(customer);
        assertTrue(actual);

        Customer actualCustomer = customerService.findCustomer(2);
        assertEquals(customer.getId(), actualCustomer.getId());
        assertEquals(customer.getFirstname(), actualCustomer.getFirstname());
        assertEquals(customer.getAddress(), actualCustomer.getAddress());
        assertEquals(customer.getEmail(), actualCustomer.getEmail());
        assertEquals(customer.getLastname(), actualCustomer.getLastname());
        assertEquals(customer.getPhone(), actualCustomer.getPhone());
    }
}