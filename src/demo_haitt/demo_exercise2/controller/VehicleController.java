package demo_haitt.demo_exercise2.controller;

import demo_haitt.demo_exercise2.service.ICar;
import demo_haitt.demo_exercise2.service.IMotorBike;
import demo_haitt.demo_exercise2.service.ITruck;
import demo_haitt.demo_exercise2.service.IVehicle;
import demo_haitt.demo_exercise2.service.impl.CarService;
import demo_haitt.demo_exercise2.service.impl.MotorBikeService;
import demo_haitt.demo_exercise2.service.impl.TruckService;
import demo_haitt.demo_exercise2.service.impl.VehicleService;

import java.util.Scanner;

public class VehicleController {
    private static final Scanner scan = new Scanner(System.in);
    private static final ICar car = new CarService();
    private static final IMotorBike motor = new MotorBikeService();
    private static final ITruck truck = new TruckService();

    private static final IVehicle vehicle = new VehicleService();

    public void menuUser() {
        while (true) {
            System.out.print("Please choose from the options" +
                    "\n 1. Add new vehicles" +
                    "\n 2. Display vehicles" +
                    "\n 3. Delete vehicles" +
                    "\n 4. Search by licensePlates" +
                    "\n 5. Exit\n");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1.1. Add the truck");
                    System.out.println("1.2. Add the motorbike");
                    System.out.println("1.3. Add the car");
                    System.out.println("1.4. Exit");
                    int choiceOne = Integer.parseInt(scan.nextLine());
                    switch (choiceOne) {
                        case 1:
                            truck.addNewTruck();
                            break;
                        case 2:
                            motor.addNewMotorBike();
                            break;
                        case 3:
                            car.addNewCar();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 2:
                    System.out.println("2.1. Display the truck");
                    System.out.println("2.2. Display the car");
                    System.out.println("2.3. Display the motorbike");
                    System.out.println("2.4. Exit");
                    int choiceTwo = Integer.parseInt(scan.nextLine());
                    switch (choiceTwo) {
                        case 1:
                            truck.displayListTruck();
                            break;
                        case 2:
                            car.displayListCar();
                            break;
                        case 3:
                            motor.diplayListMotorBike();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 3:
                    System.out.println("3.1. Delete the truck");
                    System.out.println("3.2. Delete the car");
                    System.out.println("3.3. Delete the motorbike");
                    System.out.println("3.4. Exit");
                    int choiceThree = Integer.parseInt(scan.nextLine());
                    switch (choiceThree) {
                        case 1:
                            truck.deleteTruck();
                            break;
                        case 2:
                            car.deleteCar();
                            break;
                        case 3:
                            motor.deleteMotorBike();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 4:
                    vehicle.searchVehicle();
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
