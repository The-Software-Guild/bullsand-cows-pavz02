package com.carAgency.model;

public class Car {
    int carId;
    String carType;

    public Car(int carId, String carType) {
        this.carId = carId;
        this.carType = carType;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId=" + carId +
                ", carType='" + carType +
                '}';
    }
}
