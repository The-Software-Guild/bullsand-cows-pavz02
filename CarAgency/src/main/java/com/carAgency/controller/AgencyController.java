package com.carAgency.controller;

import com.carAgency.model.Car;
import com.carAgency.model.CarType;
import com.carAgency.model.Reservation;
import com.carAgency.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class AgencyController {
    @Autowired
    CarTypeService carTypeService;

    @Autowired
    CarService carService;

    @Autowired
    ReservationService reservationService;

    @PostMapping("/reserve")
    public ResponseEntity<Object> reserve(@RequestBody Map<String, String> map) {
        int people = Integer.parseInt(map.get("people"));
        LocalDate startDate = LocalDate.parse(map.get("startDate"));
        LocalDate endDate = LocalDate.parse(map.get("endDate"));

        List<CarType> availableCarTypes = carTypeService.availableCarTypes(people);
        List<Car> availableCars = carService.availableCars(availableCarTypes);
        List<Car> availableForReservation = reservationService.availableCarsForReservation(availableCars, startDate, endDate);

        if (reservationService.noReservationsAvailable(availableForReservation))
            return getResponseBody("No car is available for a reservation", HttpStatus.OK);

        Reservation newReservation = reservationService
                .addReservation(availableForReservation, people, startDate, endDate);


        return getResponseBody(newReservation, HttpStatus.OK);
    }

    @PostMapping("/addCarType")
    public ResponseEntity<Object> addCarType(@RequestBody Map<String, String> map) {
        String type = map.get("name");
        double price = Double.parseDouble(map.get("price"));
        int capacity = Integer.parseInt(map.get("capacity"));

        if (carTypeService.doesCarTypeExist(type))
            return getResponseBody("The car type already exists", HttpStatus.OK);

        return getResponseBody(carTypeService.addCarType(type, price, capacity), HttpStatus.OK);
    }

    @PostMapping("/addCar")
    public ResponseEntity<Object> addCar(@RequestBody Map<String, String> map) {
        String type = map.get("carType");

        return getResponseBody(carService.addCar(type), HttpStatus.OK);
    }

    @PostMapping("/removeReservation")
    public ResponseEntity<Object> removeReservation(@RequestBody Map<String, String> map) {
        int reservationId = Integer.parseInt(map.get("reservationId"));

        if (!reservationService.checkForReservation(reservationId))
            return getResponseBody("Reservation does not exist", HttpStatus.OK);

        reservationService.removeReservation(reservationId);

        return getResponseBody("The reservation has been removed.", HttpStatus.OK);
    }

    @GetMapping("/viewReservations")
    public ResponseEntity<Object> viewReservations() {
        return getResponseBody(reservationService.allReservations(), HttpStatus.OK);
    }

    @GetMapping("/viewCarTypes")
    public ResponseEntity<Object> viewCarTypes() {
        return getResponseBody(carTypeService.availableCarTypes(), HttpStatus.OK);
    }

    @GetMapping("/viewCars")
    public ResponseEntity<Object> viewCars() {
        return getResponseBody(carService.availableCars(), HttpStatus.OK);
    }

    private ResponseEntity<Object> getResponseBody(Object object, HttpStatus status) {
        return new ResponseEntity<>(object, status);
    }
}
