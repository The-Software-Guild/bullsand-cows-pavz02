package com.carAgency.model;

public class CarType {
    String carType;
    double price;
    int capacity;

    public CarType(String name, double price, int capacity) {
        this.carType = name;
        this.price = price;
        this.capacity = capacity;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + carType + '\'' +
                ", price=" + price +
                ", capacity=" + capacity +
                '}';
    }
}
