package com.carAgency.model;

import java.time.LocalDate;

public class Reservation {
    int reservationId;
    int carId;
    int people;
    LocalDate startDate;
    LocalDate endDate;

    public Reservation(int reservationId, int carId, int people, LocalDate startDate, LocalDate endDate) {
        this.reservationId = reservationId;
        this.carId = carId;
        this.people = people;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getPeople() {
        return people;
    }

    public void setPeople(int people) {
        this.people = people;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "carId=" + carId +
                ", people=" + people +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
