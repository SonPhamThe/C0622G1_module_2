package case_study.service.impl;

import case_study.model.customer.Customer;
import case_study.service.ICustomer;
import case_study.service.exception.CheckException;
import case_study.service.validate.employee.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomer {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Customer> customers = new LinkedList<>();

    private static final String DAY_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";


    @Override
    public void addCustomer() {
        Customer customer = infoCustomer();
        customers.add(customer);
        System.out.println("Success add");
    }

    @Override
    public void displayCustomer() {
        if (customers.size() == 0) {
            System.out.println("List the customer is empty");
        }
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void editCustomer() {
        Customer customer = this.findCustomer();

        int positionEdit = customers.indexOf(customer);

        if (customer == null) {
            System.out.println("No have id in list Customer");
        } else {
            int chooseEdit;
            do {
                System.out.println("--------------------------");
                System.out.println("Customer need edit" +
                        "\n 1. Name of Customer" +
                        "\n 2. Day of birth of customer" +
                        "\n 3. Gender of customer" +
                        "\n 4. CMND of customer" +
                        "\n 5. Name of phone customer" +
                        "\n 6. Email of customer" +
                        "\n 7. Id of customer" +
                        "\n 8. Type of customer" +
                        "\n 9. Address of customer" +
                        "\n 10. Return menu" +
                        "\n 11. Exit");
                try {
                    chooseEdit = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e);
                }
                switch (chooseEdit) {
                    case 1:
                        String nameCustomerEdit;
                        do {
                            System.out.println("Enter name of Customer");
                            try {
                                nameCustomerEdit = scan.nextLine();
                                if (!NamePerson.checkNameObject(nameCustomerEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setNamePerson(nameCustomerEdit);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        String dayOfBirthEdit;
                        do {
                            try {
                                System.out.print("Enter day of birth customers: ");
                                dayOfBirthEdit = scan.nextLine();
                                if (dayOfBirthEdit.matches(DAY_OF_BIRTH)) {
                                    throw new CheckException("Invalid input data");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setDayOfBirth(dayOfBirthEdit);
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        String genderEdit;
                        do {
                            System.out.println("Enter gender of Customers");
                            try {
                                genderEdit = scan.nextLine();
                                if (!genderEdit.equals("male") && !genderEdit.equals("female")) {
                                    throw new CheckException("Let enter gender is male or female, don't input exception");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println("Let enter gender is male or female, don't input exception");
                            }
                        } while (true);
                        customers.get(positionEdit).setGender(genderEdit);
                        System.out.println("Success Edit");
                        break;
                    case 4:
                        String cmndEdit;
                        do {
                            System.out.println("Enter cmnd of Customers");
                            try {
                                cmndEdit = scan.nextLine();
                                if (!CmndPerson.checkCmnd(cmndEdit)) {
                                    throw new CheckException("Id mus be in the correct format");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setCMND(cmndEdit);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        String numberOfPhone;
                        do {
                            System.out.println("Enter number of phone customers");
                            try {
                                numberOfPhone = scan.nextLine();
                                if (!NumberOfPhone.checkNumberOf(numberOfPhone)) {
                                    throw new CheckException("Id must be in the correct format");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setNumberOfPhone(numberOfPhone);
                        System.out.println("Success Edit");
                        break;
                    case 6:
                        String emailEdit;
                        do {
                            System.out.println("Enter email of customers");
                            try {
                                emailEdit = scan.nextLine();
                                if (!Mail.checkEmail(emailEdit)) {
                                    throw new CheckException("Input invalid");
                                }

                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setEmail(emailEdit);
                        System.out.println("Success Edit");
                        break;
                    case 7:
                        System.out.println("Enter id of Customers want to edit");
                        String idEdit = scan.nextLine();
                        customers.get(positionEdit).setCustomerId(idEdit);
                        System.out.println("Success Edit");
                        break;
                    case 8:
                        String typeCustomerEdit;
                        do {
                            System.out.println("Enter type of Customers");
                            try {
                                typeCustomerEdit = scan.nextLine();
                                if (!Level.checkLevelObject(typeCustomerEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setCustomerType(typeCustomerEdit);
                        System.out.println("Success Edit");
                        break;
                    case 9:
                        String addressCustomerEdit;
                        do {
                            System.out.println("Enter address pf customers");
                            try {
                                addressCustomerEdit = scan.nextLine();
                                if (!Location.checkLocationObject(addressCustomerEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        customers.get(positionEdit).setAddressCustomer(addressCustomerEdit);
                        System.out.println("Success Edit");
                        break;
                    case 10:
                        editCustomer();
                        break;
                    case 11:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selections from 1 to 11");
                }
                break;
            } while (true);
        }
    }

    public Customer findCustomer() {
        System.out.println("Enter id of Customer you want to find");
        String id = scan.nextLine();
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        return null;
    }

    //    String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone,
//    String email, String customerId, String customerType, String addressCustomer
    public static Customer infoCustomer() {
        String nameCustomer = "";
        do {
            System.out.println("Enter name of Customers");
            try {
                nameCustomer = scan.nextLine();
                if (!NamePerson.checkNameObject(nameCustomer)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String dayOfBirth;
        do {
            try {
                System.out.print("Enter day of birth customers: ");
                dayOfBirth = scan.nextLine();
                if (!dayOfBirth.matches(DAY_OF_BIRTH)) {
                    throw new CheckException("Invalid input data");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String gender;
        do {
            System.out.println("Enter gender of Customers");
            try {
                gender = scan.nextLine();
                if (!gender.equals("male") && !gender.equals("female")) {
                    throw new CheckException("Let enter gender is male or female, don't input exception");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Let enter gender is male or female, don't input exception");
            }
        } while (true);

        String CMND;
        do {
            System.out.println("Enter cmnd of Customers");
            try {
                CMND = scan.nextLine();
                if (!CmndPerson.checkCmnd(CMND)) {
                    throw new CheckException("Id mus be in the correct format");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String numberOfPhone;
        do {
            System.out.println("Enter number of phone customers");
            try {
                numberOfPhone = scan.nextLine();
                if (!NumberOfPhone.checkNumberOf(numberOfPhone)) {
                    throw new CheckException("Id must be in the correct format");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String email;
        do {
            System.out.println("Enter email of customers");
            try {
                email = scan.nextLine();
                if (!Mail.checkEmail(email)) {
                    throw new CheckException("Input invalid");
                }

                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String customerId;
        do {
            System.out.println("Enter id of customers");
            try {
                customerId = scan.nextLine();
                for (Customer customer : customers) {
                    if (customer.getCustomerId().equals(customerId)) {
                        throw new CheckException("The id has been matched");
                    }
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String typeCustomer;
        do {
            System.out.println("Enter type of Customers");
            try {
                typeCustomer = scan.nextLine();
                if (!Level.checkLevelObject(typeCustomer)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String addressCustomers;
        do {
            System.out.println("Enter address of Customers");
            try {
                addressCustomers = scan.nextLine();
                if (!Level.checkLevelObject(addressCustomers)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        return new Customer(nameCustomer, dayOfBirth, gender, CMND, numberOfPhone, email, customerId, typeCustomer, addressCustomers);
    }

}
