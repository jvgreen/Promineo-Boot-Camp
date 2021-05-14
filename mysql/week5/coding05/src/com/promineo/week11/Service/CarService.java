package com.promineo.week11.Service;

import com.promineo.week11.Dao.CarDao;
import com.promineo.week11.Models.Car;

import java.util.ArrayList;

public class CarService  implements ICarService{
    private static CarDao carDao;

    public CarService() {
        carDao = new CarDao();
    }


    @Override
    public ArrayList<Car> getCars() {
        return carDao.getCars();
    }

    @Override
    public void createCar(Car car) {
        carDao.createCar(car);
    }

    @Override
    public void deleteCar(Car car) {
        carDao.deleteCar(car);
    }

    @Override
    public void updateCar(Car car) {
        carDao.updateCar(car);
    }


}
