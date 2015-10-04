package com.rga.model;

import org.json.simple.JSONAware;
import org.json.simple.JSONValue;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Green
 * @since 2015/10/04
 */
public class Customer implements JSONAware {

    private Integer id;

    private String firstname;

    private String lastname;

    private String address;

    private String email;

    private String phone;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toJSONString() {
        Map obj = new LinkedHashMap();
        obj.put("id", id);
        obj.put("firstname", firstname);
        obj.put("lastname", lastname);
        obj.put("address", address);
        obj.put("email", email);
        obj.put("phone", phone);
        return JSONValue.toJSONString(obj);
    }
}
