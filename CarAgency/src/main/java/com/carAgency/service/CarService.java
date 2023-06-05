package com.carAgency.service;

import com.carAgency.dao.CarDao;
import com.carAgency.model.Car;
import com.carAgency.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    @Autowired
    CarDao dao;

    public List<Car> availableCars() {
        return dao.getAllCars();
    }

    public List<Car> availableCars(List<CarType> carTypes) {
        return dao.getAllCars()
                .stream()
                .filter(c -> carTypes.stream().map(CarType::getCarType).anyMatch(ct -> ct.equals(c.getCarType())))
                .collect(Collectors.toList());
    }

    public Car addCar(String carType) {
        Car newCar = new Car(-1, carType);
        newCar.setCarId(dao.addCar(newCar));

        return newCar;
    }
}
