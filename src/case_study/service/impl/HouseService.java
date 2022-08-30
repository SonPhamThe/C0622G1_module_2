package case_study.service.impl;

import case_study.model.furama_resort.HouseFurama;
import case_study.service.exception.CheckException;
import case_study.service.utils.validate.facility.check_nameservice.CheckNameServiceHouse;
import java.util.Scanner;

public class HouseService {
    private static final Scanner scan = new Scanner(System.in);

    public static HouseFurama getHouse(){
        String nameService;
        while (true) {
            try {
                System.out.println("Enter select name service");
                nameService = scan.nextLine();
                if (!CheckNameServiceHouse.checkHouse(nameService)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        }

        double usableArea;
        do {
            System.out.println("Enter usable Area of House");
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
            System.out.println("Enter rental Cost of House");
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
            System.out.println("Enter max number of people of House");
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

        System.out.print("Enter rental Type of House: " +
                "\n 1. Rent by year" +
                "\n 2. Rent by month" +
                "\n 3. Rent by day" +
                "\n 4. Rent by hours");
        System.out.println("Enter choose to menu");
        String rentalType = "";
        do {
            boolean check = false;
            System.out.println("Input rental type of house");
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

        String roomStandard = "";
        while (true) {
            try {
                System.out.println("Enter select room standard" +
                        "\n 1. 3 star" +
                        "\n 2. 4 star" +
                        "\n 3. 5 star" +
                        "\n 4. Return menu");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        roomStandard = "3 star";
                        break;
                    case 2:
                        roomStandard = "4 star";
                        break;
                    case 3:
                        roomStandard = "5 star";
                        break;
                    case 4:
                        getHouse();
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 4");
                        break;

                }
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        int numberOfFloors;
        do {
            System.out.println("Enter number of floors of House");
            try {
                numberOfFloors = Integer.parseInt(scan.nextLine());
                if (numberOfFloors < 0) {
                    throw new CheckException("Number of floors must be >0");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Number of floors must be a number");
            }
        } while (true);
        return new HouseFurama(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType, roomStandard, numberOfFloors);
    }
}
