package com.microservices.training.mskitchen.services;

import com.microservices.training.mskitchen.rest.models.Reservation;
import com.microservices.training.mskitchen.rest.models.Reservations;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class KitchenService {

    private Map<String,Reservation> reservationMap  = new ConcurrentHashMap<>();
    private List<String>            reservationList = new Vector<>();
    private int                     counter         = 0;
    private AtomicInteger           acounter        = new AtomicInteger();
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat();

    public synchronized void count(){
        counter++;
    }

    public String addReservation(Reservation reservationParam){
        String rId = UUID.randomUUID()
                               .toString();
        reservationList.add(rId);
        reservationMap.put(rId, reservationParam);
        count();
        acounter.incrementAndGet();
        return rId;
    }

    public Reservations getAllReservations() {
        Reservations reservationsLoc = new Reservations();
        reservationsLoc.setReservations(new ArrayList<>(reservationMap.values()));
        return reservationsLoc;
    }
}
