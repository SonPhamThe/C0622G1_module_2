package case_study.service.impl;

import case_study.model.furama_resort.RoomFurama;
import case_study.service.exception.CheckException;
import case_study.service.exception.check_input.CheckInputToData;
import case_study.service.utils.validate.facility.check_nameservice.CheckNameServiceRoom;

import java.io.IOException;
import java.util.Scanner;

public class RoomService {
    private static final Scanner scan = new Scanner(System.in);
    public static RoomFurama getRoom() throws IOException {
        String nameService = "";
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

        System.out.println("Enter usable Area of Facility");
        double usableArea = 0;
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
            boolean check = false;
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
                    break;
            }
            if (check) {
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
