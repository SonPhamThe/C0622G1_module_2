package demo_haitt.demo_exercise2.service.impl;

import demo_haitt.demo_exercise2.model.Car;
import demo_haitt.demo_exercise2.service.ICar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICar {

    private static final Scanner scan = new Scanner(System.in);
    public static final List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car("abc4", "abc", 23, "tobi", "bmw", 54));
    }

    @Override
    public void addNewCar() {
        Car car = this.infoCar();
        cars.add(car);
        System.out.println("Success add");
    }

    @Override
    public void displayListCar() {
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    @Override
    public void deleteCar() {
        Car car = this.findCar();
        if (car == null) {
            System.out.println("Not found car valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                cars.remove(car);
                System.out.println("Successful is delete");
            }
        }
    }

    public Car findCar() {
        System.out.println("Enter licensePlates car you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlates() == licensePlates) {
                return cars.get(i);
            }
        }
        return null;
    }

    public Car infoCar() {
        System.out.println("Enter licensePlates of the car");
        String licensePlates = scan.nextLine();
        System.out.println("Enter manufacturer of the car");
        String manufacturer = scan.nextLine();
        System.out.println("Enter year of manufacturer of the car");
        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
        System.out.println("Enter owner of the car");
        String owner = scan.nextLine();
        System.out.println("Enter vehicleType of the car");
        String vehicleType = scan.nextLine();
        System.out.println("Enter number seat of the car");
        int numberSeat = Integer.parseInt(scan.nextLine());

        return new Car(licensePlates, manufacturer, yearOfManufacturer, owner, vehicleType, numberSeat);
    }
}
