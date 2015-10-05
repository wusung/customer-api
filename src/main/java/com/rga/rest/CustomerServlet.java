package com.rga.rest;

import com.rga.model.Customer;
import com.rga.service.CustomerService;
import com.rga.utilty.JSONUtils;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
        String message = "Query success";
        List<Customer> customers = customerService.findAllCustomers();
        if (customers != null) {
            data = JSONValue.toJSONString(customers);
        }

        return Response.status(200).entity(JSONUtils.makeJsonText(data, message)).build();
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response find(@PathParam("id") Integer id) {

        String data = "";
        String message = "Query success";
        Customer customer = customerService.findCustomer(id);
        if (customer != null) {
            data = customer.toJSONString();
        }

        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response add(Customer customer) {
        String data = "";
        String message = "Add fail";
        boolean ok = customerService.addCustomer(customer);
        if (ok) {
            message = "Add success";
        }
        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Integer id, Customer customer) {
        String data = "";
        String message = "Update fail";

        boolean ok = customerService.updateCustomer(id, customer);
        if (ok) {
            message = "Update success";
        }
        return Response.status(200).entity(JSONUtils.makeJsonText(data, message)).build();
    }

    @DELETE
    @Path("{id}")
    @Produces("application/json")
    public Response delete(@PathParam("id") Integer id) {

        String data = "";
        String message = "Delete fail";
        boolean ok = customerService.removeCustomer(id);
        if (ok) {
            message = "Delete success";
        }

        String result = JSONUtils.makeJsonText(data, message);
        return Response.status(200).entity(result).build();
    }
}
