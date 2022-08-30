package case_study.service.impl;

import case_study.model.furama_resort.VillaFurama;
import case_study.service.exception.CheckException;
import case_study.service.utils.check_input_controller.InputController;
import case_study.service.utils.validate.facility.check_nameservice.CheckNameServiceVilla;

import java.util.Scanner;

public class VillaService {
    private static final Scanner scan = new Scanner(System.in);

    public static VillaFurama getVilla() {
        String nameService;
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

        double usableArea;
        do {
            System.out.println("Enter usable Area of Villa");
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
            System.out.println("Enter rental Cost of Villa");
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
            System.out.println("Enter max number of people of Villa");
            try {
                maxNumberOfPeople = Integer.parseInt(scan.nextLine());
                if (maxNumberOfPeople < 0 || maxNumberOfPeople > 20) {
                    throw new CheckException("Max number of people must be >0 and <20");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Max number of people must be a number");
            }
        } while (true);


        System.out.print("Enter rental Type of Villa: " +
                "\n 1. Rent by year" +
                "\n 2. Rent by month" +
                "\n 3. Rent by day" +
                "\n 4. Rent by hours\n");
        String rentalType = "";
        do {
            int choose = Integer.parseInt(InputController.inputToChoice());
            boolean check = false;
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

        double swimmingOfArea;
        do {
            System.out.println("Enter swimming of Area in the Villa");
            try {
                swimmingOfArea = Double.parseDouble(scan.nextLine());
                if (swimmingOfArea < 30) {
                    throw new CheckException("Swimming of area must be >30");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Swimming of area must be a number");
            }
        } while (true);

        int numberOfFloors;
        do {
            System.out.println("Enter number of floors of Villa");
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

        return new VillaFurama(nameService, usableArea, rentalCost, maxNumberOfPeople, rentalType, roomStandard, swimmingOfArea, numberOfFloors);
    }
}
