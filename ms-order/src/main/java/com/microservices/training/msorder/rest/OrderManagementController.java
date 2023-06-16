package com.microservices.training.msorder.rest;

import com.microservices.training.msorder.rest.models.Order;
import com.microservices.training.msorder.services.OrderManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
@RequestMapping("/api/v1/order/management")
public class OrderManagementController {

    @Value("${server.port}")
    private Integer port;


    @Autowired
    private OrderManagementService orderManagementService;

    @PostMapping("/place")
    public String place(@RequestBody Order orderParam) throws UnknownHostException {
        return orderManagementService.placeOrder(orderParam) + " OrderMS : " + InetAddress.getLocalHost().getHostAddress() + ":" + port;
    }

}
