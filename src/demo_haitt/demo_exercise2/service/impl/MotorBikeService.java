package demo_haitt.demo_exercise2.service.impl;


import demo_haitt.demo_exercise2.model.Car;
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

    @Override
    public void editTheMotor() {
        MotorBike motorEdit = this.findMotorBike();
        if (motorEdit == null) {
            System.out.println("The truck you are looking for is not available");
        } else {
            while (true) {
                int positionEdit = motors.indexOf(motorEdit);
                System.out.println("information you want to edit" +
                        "\n 1. LicensePlates of the motorbike" +
                        "\n 2. Manufacturer of the motorbike" +
                        "\n 3. Year of manufacturer of the motorbike" +
                        "\n 4. Owner of the motorbike" +
                        "\n 5. Wattage of the motorbike" +
                        "\n 6. Exit");
                int choiceEdit = Integer.parseInt(scan.nextLine());

                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter licensePlates you want to edit");
                        String licensePlates = scan.nextLine();
                        motors.get(positionEdit).setLicensePlates(licensePlates);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        System.out.println("Enter manufacturer you want to edit");
                        String manufacturer = scan.nextLine();
                        motors.get(positionEdit).setManufacturer(manufacturer);
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        System.out.println("Enter year of manufacturer you want to edit");
                        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
                        motors.get(positionEdit).setYearOfManufacturer(yearOfManufacturer);
                        System.out.println("Success Edit");
                        break;
                    case 4:
                        System.out.println("Enter owner you want to edit");
                        String owner = scan.nextLine();
                        motors.get(positionEdit).setOwner(owner);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        System.out.println("Enter wattage you want to edit");
                        double wattage = Double.parseDouble(scan.nextLine());
                        motors.get(positionEdit).setWattage(wattage);
                        System.out.println("Success Edit");
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Your selection is not suitable, selections from 1 to 6");
                }
            }
        }
    }

    public MotorBike findMotorBike() {
        System.out.println("Enter licensePlates motorbike you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < motors.size(); i++) {
            if (motors.get(i).getLicensePlates().equals(licensePlates)) {
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
