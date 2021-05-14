package com.promineo.week11.Dao;

import com.promineo.week11.Models.Car;

import java.util.ArrayList;

public interface ICarDao {
    ArrayList<Car> getCars();
    void createCar(Car car);
    void deleteCar(Car car);
    void updateCar(Car car);
}
