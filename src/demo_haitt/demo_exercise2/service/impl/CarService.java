package demo_haitt.demo_exercise2.service.impl;

import demo_haitt.demo_exercise2.model.Car;
import demo_haitt.demo_exercise2.model.Truck;
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

    @Override
    public void editTheCar() {
        Car carEdit = this.findCar();
        if (carEdit == null) {
            System.out.println("The truck you are looking for is not available");
        } else {
            while (true) {
                int positionEdit = cars.indexOf(carEdit);
                System.out.println("information you want to edit" +
                        "\n 1. LicensePlates of the car" +
                        "\n 2. Manufacturer of the car" +
                        "\n 3. Year of manufacturer of the car" +
                        "\n 4. Owner of the car" +
                        "\n 5. Vehicle Type of the car" +
                        "\n 6. Number seat of the car" +
                        "\n 7. Exit");
                int choiceEdit = Integer.parseInt(scan.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter licensePlates you want to edit");
                        String licensePlates = scan.nextLine();
                        cars.get(positionEdit).setLicensePlates(licensePlates);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        System.out.println("Enter manufacturer you want to edit");
                        String manufacturer = scan.nextLine();
                        cars.get(positionEdit).setManufacturer(manufacturer);
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        System.out.println("Enter year of manufacturer you want to edit");
                        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
                        cars.get(positionEdit).setYearOfManufacturer(yearOfManufacturer);
                        System.out.println("Success Edit");
                    case 4:
                        System.out.println("Enter owner you want to edit");
                        String owner = scan.nextLine();
                        cars.get(positionEdit).setOwner(owner);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        System.out.println("Enter vehicle type you want to edit");
                        String vehicleType = scan.nextLine();
                        cars.get(positionEdit).setVehicleType(vehicleType);
                        System.out.println("Success Edit");
                        break;
                    case 6:
                        System.out.println("Enter number seat you want to edit");
                        int numberSeat = Integer.parseInt(scan.nextLine());
                        cars.get(positionEdit).setNumberSeat(numberSeat);
                        System.out.println("Success Edit");
                        break;
                    case 7:
                        System.exit(0);
                    default:
                        System.out.println("Your selection is not suitable, selections from 1 to 7");
                }
            }
        }
    }

    public Car findCar() {
        System.out.println("Enter licensePlates car you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getLicensePlates().equals(licensePlates)) {
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
