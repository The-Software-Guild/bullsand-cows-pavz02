package com.carAgency.service;

import com.carAgency.dao.CarTypeDao;
import com.carAgency.model.CarType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarTypeService {
    @Autowired
    CarTypeDao dao;

    public List<CarType> availableCarTypes() {
        return dao.getAllCarTypes();
    }

    public List<CarType> availableCarTypes(int people) {
        return dao.getAllCarTypes().stream().filter(c -> people <= c.getCapacity()).collect(Collectors.toList());
    }

    public CarType addCarType(String carType, double price, int capacity) {
        CarType newCarType = new CarType(carType, price, capacity);
        dao.addCarType(newCarType);

        return newCarType;
    }

    public boolean doesCarTypeExist(String carType) {
        return dao.getAllCarTypes().stream().filter(c -> c.getCarType().equals(carType)).count() == 1;
    }
}
