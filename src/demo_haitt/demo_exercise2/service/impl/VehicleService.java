package demo_haitt.demo_exercise2.service.impl;

import demo_haitt.demo_exercise2.model.Vehicle;
import demo_haitt.demo_exercise2.service.IVehicle;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleService implements IVehicle {
    private static final Scanner scan = new Scanner(System.in);

    @Override
    public void searchVehicle() {
        System.out.println("Enter licensePlates to search");
        String licensePlates = scan.nextLine();
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.addAll(CarService.cars);
        vehicles.addAll(TruckService.trucks);
        vehicles.addAll(MotorBikeService.motors);

        List<Vehicle> foundVehicles = findVehiclesByLicensePlates(vehicles, licensePlates);
        if (licensePlates.isEmpty()) {
            System.out.println("Can't find a suitable vehicle");
        } else {
            System.out.println(foundVehicles.toString());
        }

    }
    private List<Vehicle> findVehiclesByLicensePlates(List<Vehicle> vehicles, String licensePlates) {
        List<Vehicle> foundVehicles = new ArrayList<>();
        for (Vehicle vehicle : vehicles) {
            if (licensePlates.equals(vehicle.getLicensePlates())) {
                foundVehicles.add(vehicle);
            }
        }
        return foundVehicles;
    }
}
