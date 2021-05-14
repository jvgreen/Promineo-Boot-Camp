package com.promineo.week11.Views;

import com.promineo.week11.Models.Car;
import com.promineo.week11.Service.CarService;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    CarService carService = new CarService();
    private Scanner scanner = new Scanner(System.in);
    public void start() {
        String selection = "";

        do {
            printMenu();
            selection = scanner.nextLine();
            if (selection.equals("1")) {
                displayCars();
            } else if (selection.equals("2")) {
                addCar();
            } else if (selection.equals("3")) {
                updateCar();
            } else if (selection.equals("4")) {
                deleteCar();
            } else if (!selection.equals("5")) {
                System.out.println("Please select a number 1 - 5");
            }
        } while (!selection.equals("5"));
    }

    private void deleteCar() {
        System.out.println("What is the Car ID of the car you would like to delete");
        int id = scanner.nextInt();
        carService.deleteCar(new Car(id));
    }

    private void updateCar() {
        System.out.println("What is the Car ID of the car you would like to Update");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("What is the cars new make");
        String make = scanner.nextLine();
        System.out.println("What is the cars new model");
        String model = scanner.nextLine();
        carService.updateCar(new Car(id, make, model));
    }

    private void addCar() {
        System.out.println("What is the new cars make");
        String make = scanner.nextLine();
        System.out.println("What is the new cars model");
        String model = scanner.nextLine();
        carService.createCar(new Car(make, model));
    }

    private void displayCars() {
        System.out.println("Printing all cars");
        System.out.println("------------");
        ArrayList<Car> cars = carService.getCars();
        for (Car car : cars) {
            System.out.println("Car ID: " + car.getCarId());
            System.out.println("Make: " + car.getMake());
            System.out.println("Model: " + car.getModel());
            System.out.println("------------");
        }
    }

    private void printMenu() {
        System.out.println("-----------------------");
        System.out.println("Please Select an option");
        System.out.println("1) Display cars");
        System.out.println("2) Add a car");
        System.out.println("3) Change a Car");
        System.out.println("4) Delete a Car");
        System.out.println("5) Exit");
        System.out.println("-----------------------");
    }
}
