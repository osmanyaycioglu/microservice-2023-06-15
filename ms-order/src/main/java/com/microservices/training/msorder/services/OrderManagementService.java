package com.microservices.training.msorder.services;

import com.microservices.training.msorder.integrations.KitchenReservationIntegration;
import com.microservices.training.msorder.rest.models.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class OrderManagementService {

    private Map<Integer,Order> orderMap = new ConcurrentHashMap<>();
    private AtomicInteger orderIdCreator = new AtomicInteger();

    @Autowired
    private KitchenReservationIntegration kitchenReservationIntegration;

    public String placeOrder(Order orderParam) {
        int oid = orderIdCreator.incrementAndGet();
        orderMap.put(oid, orderParam);
        String sLoc = kitchenReservationIntegration.addReservation2(orderParam);
        return sLoc + " orderID: " + oid;
    }

}
