package case_study.controller;

import case_study.service.*;
import case_study.service.impl.*;
import case_study.service.utils.check_input_controller.InputController;

import java.io.IOException;
import java.util.Scanner;

public class FuramaController {
    private static final Scanner scan = new Scanner(System.in);
    private static final IFacility facility = new FacilityService();
    private static final IEmployee employee = new EmployeeService();
    private static final ICustomer customer = new CustomerService();
    private static final IBooking booking = new BookingService();
    private static final IContact contact = new ContactService();

    public void menuUser() throws IOException {
        while (true) {
            System.out.println("---------------Welcome to Furama resort----------");
            System.out.println("---------------Please select the services below----------");
            System.out.println("1. Employee Management" + "\n 2. Customer Management" + "\n 3. Facility Management" + "\n 4. Booking Management" + "\n 5. Promotion Management" + "\n 6. Exit");
            int choice = Integer.parseInt(InputController.inputToChoice());
            switch (choice) {
                case 1:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("1.1 Display list employees" + "\n 1.2 Add new employee" + "\n 1.3 Edit employee" + "\n 1.4 Return main menu" + "\n 1.5 Exit");
                        int chooseEmployees = Integer.parseInt(InputController.inputToChoice());
                        boolean check = false;
                        switch (chooseEmployees) {
                            case 1:
                                employee.displayEmployee();
                                check = true;
                                break;
                            case 2:
                                employee.addEmployee();
                                check = true;
                                break;
                            case 3:
                                employee.editEmployee();
                                check = true;
                                break;
                            case 4:
                                menuUser();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, selections from 1 to 5");
                                check = true;
                                break;
                        }
                        if (!check) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("2.1 Display list customers" + "\n 2.2 Add new customer" + "\n 2.3 Edit customer" + "\n 2.4 Return main menu" + "\n 2.5 Exit");
                        int chooseCustomer = Integer.parseInt(InputController.inputToChoice());
                        boolean check = false;
                        switch (chooseCustomer) {
                            case 1:
                                customer.displayCustomer();
                                check = true;
                                break;
                            case 2:
                                customer.addCustomer();
                                check = true;
                                break;
                            case 3:
                                customer.editCustomer();
                                check = true;
                                break;
                            case 4:
                                menuUser();
                                break;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, selections from 1 to 5");
                                check = true;
                                break;
                        }
                        if (!check) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("3.1 Display list facility" + "\n 3.2 Add new facility" + "\n 3.3 Display list facility maintenance" + "\n 3.4 Return main menu" + "\n 3.5 Exit");
                        int chooseFacility = Integer.parseInt(InputController.inputToChoice());
                        boolean check = false;
                        switch (chooseFacility) {
                            case 1:
                                facility.displayFacility();
                                check = true;
                                break;
                            case 2:
                                facility.addFacility();
                                check = true;
                                break;
                            case 3:
                                facility.displayFacilityMaintenance();
                                check = true;
                                break;
                            case 4:
                                return;
                            case 5:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, selections from 1 to 5");
                                break;
                        }
                        if (!check) {
                            break;
                        }
                    }
                    break;
                case 4:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("4.1 Add new booking" + "\n 4.2 Display list booking" + "\n 4.3 Create new contracts" + "\n 4.4 Display list contracts" + "\n 4.5 Edit contracts" + "\n 4.6 Return main menu");
                        int chooseBooking = Integer.parseInt(InputController.inputToChoice());
                        boolean check = false;
                        switch (chooseBooking) {
                            case 1:
                                booking.addBooking();
                                check = true;
                                break;
                            case 2:
                                booking.displayBooking();
                                check = true;
                                break;
                            case 3:
                                contact.createContact();
                                check = true;
                                break;
                            case 4:
                                check = true;
                                break;
                            case 5:
                                check = true;
                                break;
                            case 6:
                                check = true;
                                break;
                            case 7:
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Your selection is not suitable, selections from 1 to 7");
                                break;
                        }
                        if (!check) {
                            break;
                        }
                    }
                    break;
                case 5:
                    while (true) {
                        System.out.println("---------------Please select the services below----------");
                        System.out.println("5.1 Display list customer use service" + "\n 5.2 Display list customers get voucher" + "\n 5.3 Return main menu" + "\n 5.4 Exit");
                        int choosePromotion = Integer.parseInt(InputController.inputToChoice());
                        boolean check = false;
                        switch (choosePromotion) {
                            case 1:
                                check = true;
                                break;
                            case 2:
                                check = true;
                                break;
                            case 3:
                                check = true;
                                break;
                            case 4:
                                System.exit(0);
                            default:
                                System.out.println("Your selection is not suitable, selections from 1 to 7");
                                break;
                        }
                        if (!check) {
                            break;
                        }
                    }
                    break;
                case 6:
                    menuUser();
                    break;
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 6");
                    break;
            }
        }
    }
}

// sửa lại chỗ int viết 1 class