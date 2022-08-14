package demo_haitt.demo_exercise2.service.impl;


import demo_haitt.demo_exercise2.model.MotorBike;
import demo_haitt.demo_exercise2.service.IMotorBike;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorBikeService implements IMotorBike {
    private static final Scanner scan = new Scanner(System.in);
    public static final List<MotorBike> motors = new ArrayList<>();

    static {
        motors.add(new MotorBike("abc", "abc", 32, "fdsfds", 5.4f));
    }

    @Override
    public void addNewMotorBike() {
        MotorBike motor = this.infoMotor();
        motors.add(motor);
        System.out.println("Success add");
    }

    @Override
    public void diplayListMotorBike() {
        for (MotorBike motor : motors) {
            System.out.println(motor);
        }
    }

    @Override
    public void deleteMotorBike() {
        MotorBike motor = this.findMotorBike();
        if (motor == null) {
            System.out.println("Not found motorbike valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                motors.remove(motor);
                System.out.println("Successful is delete");
            }
        }
    }

    public MotorBike findMotorBike() {
        System.out.println("Enter licensePlates motorbike you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getLicensePlates() == licensePlates) {
                return motors.get(i);
            }
        }
        return null;
    }

    public MotorBike infoMotor() {
        System.out.println("Enter licensePlates of the motorbike");
        String licensePlates = scan.nextLine();
        System.out.println("Enter manufacturer of the motorbike");
        String manufacturer = scan.nextLine();
        System.out.println("Enter year of manufacturer of the motorbike");
        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
        System.out.println("Enter owner of the truck");
        String owner = scan.nextLine();
        System.out.println("Enter tonnage of the motorbike");
        double wattage = Double.parseDouble(scan.nextLine());

        return new MotorBike(licensePlates, manufacturer, yearOfManufacturer, owner, wattage);
    }
}
