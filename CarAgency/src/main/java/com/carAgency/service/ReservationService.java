package com.carAgency.service;

import com.carAgency.dao.ReservationDao;
import com.carAgency.model.Car;
import com.carAgency.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReservationService {
    @Autowired
    ReservationDao dao;


    public List<Car> availableCarsForReservation(List<Car> cars, LocalDate startDate, LocalDate endDate) {
        List<Car> output = new ArrayList<>();

        for (Car car : cars) {
            if (this.allReservations()
                    .stream()
                    .filter(r -> r.getCarId() == car.getCarId())
                    .allMatch(r -> (startDate.isBefore(r.getStartDate()) && endDate.isBefore(r.getEndDate())) ||
                            (startDate.isAfter(r.getStartDate()) && endDate.isAfter(r.getEndDate()))))

                output.add(car);

        }
        return output;
    }

    public boolean noReservationsAvailable(List<Car> cars) {
        return cars.isEmpty();
    }
    public Reservation addReservation(List<Car> cars, int people, LocalDate startDate, LocalDate endDate) {
        Reservation reservation = new Reservation(-1,
                cars.stream().findFirst().get().getCarId(),
                people,
                startDate,
                endDate);

        reservation.setReservationId(dao.addReservation(reservation));

        return reservation;
    }

    public boolean checkForReservation(int reservationId) {
        return dao.getAllReservations().stream().filter(r -> r.getReservationId() == reservationId).count() == 1;
    }

    public void removeReservation(int reservationId) {
        Reservation reservation = dao.getAllReservations()
                .stream()
                .filter(r -> r.getReservationId() == reservationId)
                .findFirst()
                .get();

        dao.removeReservation(reservation);
    }

    public List<Reservation> allReservations() {
        return dao.getAllReservations();
    }
}
