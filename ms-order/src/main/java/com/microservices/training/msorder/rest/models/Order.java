package com.microservices.training.msorder.rest.models;

import java.util.List;

public class Order {
    private Integer      orderId;
    private String       phoneNumber;
    private String       address;
    private List<String> orders;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(final String phoneNumberParam) {
        phoneNumber = phoneNumberParam;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String addressParam) {
        address = addressParam;
    }

    public List<String> getOrders() {
        return orders;
    }

    public void setOrders(final List<String> ordersParam) {
        orders = ordersParam;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(final Integer orderIdParam) {
        orderId = orderIdParam;
    }
}
