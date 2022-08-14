package demo_haitt.demo_exercise2.service.impl;

import demo_haitt.demo_exercise2.model.Truck;
import demo_haitt.demo_exercise2.service.ITruck;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruck {
    private static final Scanner scan = new Scanner(System.in);
    public static final List<Truck> trucks = new ArrayList<>();

    static {
        trucks.add(new Truck("xyz", "afaf", 5, "gaga", 45.5));
    }

    @Override
    public void addNewTruck() {
        Truck truck = this.infoTruck();
        trucks.add(truck);
        System.out.println("Success add");
    }

    @Override
    public void displayListTruck() {
        for (Truck truck : trucks) {
            System.out.println(truck);
        }
    }

    @Override
    public void deleteTruck() {
        Truck truck = this.findTruck();
        if (truck == null) {
            System.out.println("Not found truck valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                trucks.remove(truck);
                System.out.println("Successful is delete");
            }
        }
    }

    public Truck findTruck() {
        System.out.println("Enter licensePlates truck you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlates() == licensePlates) {
                return trucks.get(i);
            }
        }
        return null;
    }

    public Truck infoTruck() {
        System.out.println("Enter licensePlates of the truck");
        String licensePlates = scan.nextLine();
        System.out.println("Enter manufacturer of the truck");
        String manufacturer = scan.nextLine();
        System.out.println("Enter year of manufacturer of the truck");
        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
        System.out.println("Enter owner of the truck");
        String owner = scan.nextLine();
        System.out.println("Enter tonnage of the truck");
        double tonnage = Double.parseDouble(scan.nextLine());

        return new Truck(licensePlates, manufacturer, yearOfManufacturer, owner, tonnage);
    }
}
