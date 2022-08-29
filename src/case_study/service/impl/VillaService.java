package case_study.service.impl;

import case_study.model.furama_resort.VillaFurama;
import case_study.service.exception.CheckException;
import case_study.service.exception.check_input.CheckInputToData;
import case_study.service.exception.check_number_of_floor.CheckNumberOfFloor;
import case_study.service.utils.validate.facility.check_nameservice.CheckNameServiceVilla;

import java.io.IOException;
import java.util.Scanner;

public class VillaService {
    private static final Scanner scan = new Scanner(System.in);

    public static VillaFurama getVilla() throws IOException {
        String nameService = "";
        while (true) {
            try {
                System.out.println("Enter select name service");
                nameService = scan.nextLine();
                if (!CheckNameServiceVilla.checkVilla(nameService)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        }

        System.out.println("Enter usable Area of Facility");
        double usableArea = Double.parseDouble(scan.nextLine());
        CheckInputToData.checkInputToDouble(usableArea);

        System.out.println("Enter rental Cost of Facility");
        double rentalCost = Double.parseDouble(scan.nextLine());
        CheckInputToData.checkInputToDouble(rentalCost);

        System.out.println("Enter max number of people of Facility");
        int maxNumberOfPeople = Integer.parseInt(scan.nextLine());
        CheckInputToData.checkInputToInteger(maxNumberOfPeople);

        System.out.print("Enter rental Type of Facility: " +
                "\n 1. Rent by year" +
                "\n 2. Rent by month" +
                "\n 3. Rent by day" +
                "\n 4. Rent by hours");
        System.out.println("Enter choose to menu");
        String rentalType = scan.nextLine();
        do {
            boolean check;
            System.out.println("Input rental type of villa");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                case 2:
                case 3:
                case 4:
                    CheckInputToData.checkInputToString(rentalType);
                    check = true;
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 4");
                    check = true;
                    break;
            }
            if (check) {
                break;
            }
        } while (true);

        String roomStandard = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select room standard" +
                        "\n 1. 3 star" +
                        "\n 2. 4 star" +
                        "\n 3. 5 star" +
                        "\n 4. Return menu");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        roomStandard = "3 star";
                        check = true;
                        break;
                    case 2:
                        roomStandard = "4 star";
                        check = true;
                        break;
                    case 3:
                        roomStandard = "5 star";
                        check = true;
                        break;
                    case 4:
                        getVilla();
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 4");
                        break;
                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Enter swimming of Area in the Villa");
        double swimmingOfArea = Double.parseDouble(scan.nextLine());
        CheckInputToData.checkInputToDouble(swimmingOfArea);

        System.out.println("Enter number of floors of Villa");
        int numberOfFloors = Integer.parseInt(scan.nextLine());
        CheckNumberOfFloor.checkNumberOfFloor(numberOfFloors);

        return new VillaFurama(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType, roomStandard, swimmingOfArea, numberOfFloors);
    }
}
