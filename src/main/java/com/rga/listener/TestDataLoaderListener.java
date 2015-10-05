package com.rga.listener;

import com.rga.dao.CustomerDao;
import com.rga.dao.UserDao;
import com.rga.model.Customer;
import com.rga.model.User;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author Green
 * @since 2015/10/05
 */
public class TestDataLoaderListener implements ServletContextListener {

    private static final String DISPATCHER_SERVLET_CONTEXT_ATTR_NAME =
            "org.springframework.web.servlet.FrameworkServlet.CONTEXT.dispatcher";

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext stx = sce.getServletContext();

        WebApplicationContext rootContext = getRootWebApplicationContext(stx);
        CustomerDao customerDao = rootContext.getBean(CustomerDao.class);

        for (int i = 0; i < 100; i++) {
            Customer c = new Customer();
            c.setEmail(String.format("john%s@gmail.com", i));
            c.setAddress(String.format("Address %s}", i));
            c.setFirstname(String.format("First Name %s", i));
            c.setLastname(String.format("Last Name %s", i));
            c.setPhone(String.format("Phone %s", i));
            customerDao.insert(c);
        }


        UserDao userDao = rootContext.getBean(UserDao.class);
        {
            User user = new User();
            user.setEmail("twkoci@gmail.com");
            user.setPassword("franky");
            userDao.insert(user);
        }

        {
            User user = new User();
            user.setEmail("franky@gmail.com");
            user.setPassword("1234");
            userDao.insert(user);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }

    private WebApplicationContext getRootWebApplicationContext(ServletContext stx){
        return WebApplicationContextUtils.getWebApplicationContext( stx );
    }

    private WebApplicationContext getDispatcherServletWebApplicationContext(ServletContext stx){
        return WebApplicationContextUtils.getWebApplicationContext(stx,
                DISPATCHER_SERVLET_CONTEXT_ATTR_NAME);
    }
}
