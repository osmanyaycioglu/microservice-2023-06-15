package com.microservices.training.msorder.integrations;

import com.microservices.training.msorder.integrations.models.Reservation;
import com.microservices.training.msorder.rest.models.Order;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Service
public class KitchenReservationIntegration {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;


    public String addReservation(Order orderParam) {
        Reservation   reservationLoc = new Reservation();
        LocalDateTime nowLoc         = LocalDateTime.now();
        reservationLoc.setReservationDate(nowLoc);
        reservationLoc.setReservationEndDate(nowLoc.plusMinutes(30));
        reservationLoc.setReservation(String.join(" ",
                                                  orderParam.getOrders()));
        reservationLoc.setOrderId(orderParam.getOrderId());
        String sLoc = restTemplate.postForObject("http://KITCHEN/api/v1/kitchen/reservation/add",
                                                 reservationLoc,
                                                 String.class);
        return sLoc;
    }

    private AtomicInteger counter = new AtomicInteger();

    public String addReservation2(Order orderParam) {
        Reservation   reservationLoc = new Reservation();
        LocalDateTime nowLoc         = LocalDateTime.now();
        reservationLoc.setReservationDate(nowLoc);
        reservationLoc.setReservationEndDate(nowLoc.plusMinutes(30));
        reservationLoc.setReservation(String.join(" ",
                                                  orderParam.getOrders()));
        reservationLoc.setOrderId(orderParam.getOrderId());

        Application        kitchenLoc      = eurekaClient.getApplication("KITCHEN");
        List<InstanceInfo> instancesLoc    = kitchenLoc.getInstances();
        int                iLoc            = counter.incrementAndGet();
        int                index           = iLoc % instancesLoc.size();
        InstanceInfo       instanceInfoLoc = instancesLoc.get(index);
        RestTemplate       restTemplateLoc = new RestTemplate();

        String sLoc = restTemplateLoc.postForObject("http://"
                                                    + instanceInfoLoc.getIPAddr()
                                                    + ":"
                                                    + instanceInfoLoc.getPort()
                                                    + "/api/v1/kitchen/reservation/add",
                                                    reservationLoc,
                                                    String.class);
        return sLoc;
    }


}
