package com.rga.rest.service;

import com.rga.model.Customer;
import com.rga.service.CustomerService;
import com.rga.utilty.JSONUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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
    @Produces("application/json")
    public Response findAll() {

        String data = "";
        List<Customer> customer = customerService.findAllCustomers();
        if (customer != null) {
            List json = new ArrayList<>();

            //data = customer.toJSONString();
        }

        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response find(@PathParam("id") Integer id) {

        String data = "";
        Customer customer = customerService.findCustomer(id);
        if (customer != null) {
            data = customer.toJSONString();
        }

        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Customer customer) {
        String data = "";
        boolean ok = customerService.addCustomer(customer);
        if (ok) {
            data = "Add success";
        }
        String result = JSONUtils.makeJsonText(data);
        return Response.status(200).entity(result).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Customer customer) {
        String data = "";

        boolean ok = customerService.updateCustomer(id, customer);
        if (ok) {
            data = "Update success";
        }
        return Response.status(200).entity(JSONUtils.makeJsonText(data)).build();
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
