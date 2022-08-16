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

    @Override
    public void editTheTruck() {
        Truck truckEdit = this.findTruck();
        if (truckEdit == null) {
            System.out.println("The truck you are looking for is not available");
        } else {
            while (true) {
                int positionEdit = trucks.indexOf(truckEdit);
                System.out.println("information you want to edit" +
                        "\n 1. LicensePlates of the truck" +
                        "\n 2. Manufacturer of the truck" +
                        "\n 3. Year of manufacturer of the truck" +
                        "\n 4. Owner of the truck" +
                        "\n 5. Tonnage of the truck" +
                        "\n 6. Exit");
                int choiceEdit = Integer.parseInt(scan.nextLine());
                switch (choiceEdit) {
                    case 1:
                        System.out.println("Enter licensePlates you want to edit");
                        String licensePlates = scan.nextLine();
                        trucks.get(positionEdit).setLicensePlates(licensePlates);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        System.out.println("Enter manufacturer you want to edit");
                        String manufacturer = scan.nextLine();
                        trucks.get(positionEdit).setManufacturer(manufacturer);
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        System.out.println("Enter year of manufacturer you want to edit");
                        int yearOfManufacturer = Integer.parseInt(scan.nextLine());
                        trucks.get(positionEdit).setYearOfManufacturer(yearOfManufacturer);
                        System.out.println("Success Edit");
                        break;
                    case 4:
                        System.out.println("Enter owner you want to edit");
                        String owner = scan.nextLine();
                        trucks.get(positionEdit).setOwner(owner);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        System.out.println("Enter tonnage you want to edit");
                        double tonnage = Double.parseDouble(scan.nextLine());
                        trucks.get(positionEdit).setTonnage(tonnage);
                        System.out.println("Success Edit");
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Your selection is not suitable, selections from 1 to 6");
                }
                break;
            }
        }
    }

    public Truck findTruck() {
        System.out.println("Enter licensePlates truck you want to find");
        String licensePlates = scan.nextLine();
        for (int i = 0; i < trucks.size(); i++) {
            if (trucks.get(i).getLicensePlates().equals(licensePlates)) ;
            return trucks.get(i);
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
