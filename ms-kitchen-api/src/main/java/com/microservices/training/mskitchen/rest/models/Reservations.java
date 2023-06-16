package com.microservices.training.mskitchen.rest.models;

import java.util.List;

public class Reservations {

    private List<Reservation> reservations;

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(final List<Reservation> reservationsParam) {
        reservations = reservationsParam;
    }
}
