package com.microservices.training.msorder.integrations;

import com.microservices.training.mskitchen.rest.models.Reservation;
import com.microservices.training.msorder.rest.models.Order;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KitchenReservationIntegration {

    @Autowired
    private IKitchenIntegration kitchenIntegration;

    @Autowired
    private IKitchenApiIntegration kitchenApiIntegration;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient eurekaClient;

    @CircuitBreaker(name = "reservation_cb", fallbackMethod = "addReservationFallback")
    @Retry(name = "reservation_retry")
    public String addReservation(Order orderParam) {
        Reservation   reservationLoc = new Reservation();
        LocalDateTime nowLoc         = LocalDateTime.now();
        reservationLoc.setReservationDate(nowLoc);
        reservationLoc.setReservationEndDate(nowLoc.plusMinutes(30));
        reservationLoc.setReservation(String.join(" ",
                                                  orderParam.getOrders()));
        reservationLoc.setOrderId(orderParam.getOrderId());
        return kitchenApiIntegration.addReservation(reservationLoc);
    }


    public String addReservationFallback(Order orderParam,
                                         Throwable throwable) {
        return "Fallbacked";
    }


    public String addReservation3(Order orderParam) {
        Reservation   reservationLoc = new Reservation();
        LocalDateTime nowLoc         = LocalDateTime.now();
        reservationLoc.setReservationDate(nowLoc);
        reservationLoc.setReservationEndDate(nowLoc.plusMinutes(30));
        reservationLoc.setReservation(String.join(" ",
                                                  orderParam.getOrders()));
        reservationLoc.setOrderId(orderParam.getOrderId());
        String sLoc = null;
        try {
            sLoc = restTemplate.postForObject("http://KITCHEN/api/v1/kitchen/reservation/add",
                                              reservationLoc,
                                              String.class);
        } catch (RestClientResponseException eParam) {
            eParam.printStackTrace();
        }
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
