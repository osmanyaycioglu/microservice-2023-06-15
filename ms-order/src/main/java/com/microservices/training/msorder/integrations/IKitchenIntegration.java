package com.microservices.training.msorder.integrations;

import com.microservices.training.mskitchen.rest.models.Reservation;
import com.microservices.training.mskitchen.rest.models.Reservations;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "KITCHEN",contextId = "kitchen2")
public interface IKitchenIntegration {

    @PostMapping("/api/v1/kitchen/reservation/add")
    String addReservation(@RequestBody Reservation reservation);

    @GetMapping("/api/v1/kitchen/reservation/get/all/reservations")
    Reservations getReservations();

}
