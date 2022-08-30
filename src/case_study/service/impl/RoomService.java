package case_study.service.impl;

import case_study.model.furama_resort.RoomFurama;
import case_study.service.exception.CheckException;
import case_study.service.utils.validate.facility.check_nameservice.CheckNameServiceRoom;
import java.util.Scanner;

public class RoomService {
    private static final Scanner scan = new Scanner(System.in);
    public static RoomFurama getRoom() {
        String nameService ;
        while (true) {
            try {
                System.out.println("Enter select name service");
                nameService = scan.nextLine();
                if (!CheckNameServiceRoom.checkRoom(nameService)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        }

        double usableArea ;
        do {
            System.out.println("Enter usable Area of Room");
            try {
                usableArea = Double.parseDouble(scan.nextLine());
                if (usableArea < 30) {
                    throw new CheckException("Usable Area must be >30");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Usable Area must be a number");
            }
        } while (true);

        double rentalCost;
        do {
            System.out.println("Enter rental Cost of Room");
            try {
                rentalCost = Double.parseDouble(scan.nextLine());
                if (rentalCost < 0) {
                    throw new CheckException("Rental Cost must be >0");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Rental Cost must be a number");
            }
        } while (true);

        int maxNumberOfPeople;
        do {
            System.out.println("Enter max number of people of Room");
            try {
                maxNumberOfPeople = Integer.parseInt(scan.nextLine());
                if (maxNumberOfPeople < 0 || maxNumberOfPeople >20) {
                    throw new CheckException("Max number of people must be >0 and <20");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Max number of people must be a number");
            }
        } while (true);

        System.out.print("Enter rental Type of Room: " +
                "\n 1. Rent by year" +
                "\n 2. Rent by month" +
                "\n 3. Rent by day" +
                "\n 4. Rent by hours");
        System.out.println("Enter choose to menu");
        String rentalType = "";
        do {
            boolean check = false;
            System.out.println("Input rental type of room");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    rentalType = "Rent by year";
                    check = true;
                    break;
                case 2:
                    rentalType = "Rent by month";
                    check = true;
                    break;
                case 3:
                    rentalType = "Rent by day";
                    check = true;
                    break;
                case 4:
                    rentalType = "Rent by hours";
                    check = true;
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 4");
                    break;
            }
            if (!check) {
                break;
            }
        } while (true);

        String freeServiceIncluded = "";
        try {
            System.out.println("Enter free Service include");
            freeServiceIncluded = scan.nextLine();
            if (!freeServiceIncluded.matches("\\D+")) {
                throw new CheckException("Input invalid");
            }
        } catch (CheckException e) {
            System.out.println("Input invalid");
        }
        return new RoomFurama(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType, freeServiceIncluded);
    }
}
