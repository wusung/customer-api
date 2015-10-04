package com.rga.rest.service;

import com.rga.model.Customer;
import com.rga.service.CustomerService;
import com.rga.utilty.JSONUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Green
 * @since 2015/10/04
 */
@Component
@Path("/customer")
public class CustomerServlet {

    @Autowired
    CustomerService customerService;

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response find(@PathParam("id") String id) {

        String data = "";
        if (StringUtils.isNotBlank(id)) {
            Customer customer = customerService.findCustomer(Integer.valueOf(id));
            if (customer != null) {
                data = customer.toJSONString();
            }
        } else {
            List<Customer> customer = customerService.findAllCustomers();
            if (customer != null) {
                List json = new ArrayList<>();
                //data = customer.toJSONString();
            }
        }

        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/")
    public Response saveCustomer(MultivaluedMap<String, String> formParams) {
        String result = "";

        Customer customer = new Customer();
//        boolean ok = customerService.addCustomer(customer);
        boolean ok = true;
        if (ok) {

        }
        return Response.status(200).entity(result).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Integer id) {

        String data = "";
        boolean ok = customerService.removeCustomer(id);
        if (ok) {
            data = "Delete success";
        }

        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }
}
