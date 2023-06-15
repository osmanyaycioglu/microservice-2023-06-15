package com.microservices.training.mskitchen.rest.models;

import java.time.LocalDateTime;

public class Reservation {

    private String reservationId;
    private LocalDateTime reservationDate;
    private LocalDateTime reservationEndDate;
    private String reservation;
    private Integer orderId;

    public String getReservationId() {
        return reservationId;
    }

    public void setReservationId(final String reservationIdParam) {
        reservationId = reservationIdParam;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(final LocalDateTime reservationDateParam) {
        reservationDate = reservationDateParam;
    }

    public LocalDateTime getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(final LocalDateTime reservationEndDateParam) {
        reservationEndDate = reservationEndDateParam;
    }

    public String getReservation() {
        return reservation;
    }

    public void setReservation(final String reservationParam) {
        reservation = reservationParam;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(final Integer orderIdParam) {
        orderId = orderIdParam;
    }
}
