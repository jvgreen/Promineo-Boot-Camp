package com.promineo.week11.Models;

public class Car {

    private String make;
    private String model;

    public Car(int carId, String make, String model) {
        this.carId = carId;
        this.make  = make;
        this.model = model;
    }

    public Car(String make, String model) {
        this.make  = make;
        this.model = model;
    }

    public Car(int carId) {
        this.carId = carId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    private int carId;

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
