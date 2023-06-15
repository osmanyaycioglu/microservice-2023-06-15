package com.microservices.training.mskitchen.rest;

import com.microservices.training.mskitchen.rest.models.Reservation;
import com.microservices.training.mskitchen.rest.models.Reservations;
import com.microservices.training.mskitchen.services.KitchenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;

@RestController
@RequestMapping("/api/v1/kitchen/reservation")
//@RequestScope
public class KitchenReservationController {

    @Autowired
    private KitchenService kitchenService;

    @Value("${server.port}")
    private Integer port;

    @PostMapping("/add")
    public String addReservation(@RequestBody Reservation reservation){
        return kitchenService.addReservation(reservation) + " port : " + port ;
    }

    @GetMapping("/get/all/reservations")
    public Reservations getReservations() {
        return kitchenService.getAllReservations();

    }

}
