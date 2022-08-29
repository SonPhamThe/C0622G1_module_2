package case_study.service.impl;

import case_study.model.customer.Customer;
import case_study.service.ICustomer;
import case_study.service.exception.CheckException;
import case_study.service.utils.readfile.ReadFileCustomers;
import case_study.service.utils.writefile.WriteFileCustomer;
import case_study.service.utils.validate.employee.*;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomer {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Customer> customers = new LinkedList<>();

    private static final String PATH_CUSTOMER = "src/case_study/data/customer.csv";

    private static final String NAME_CUSTOMER = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";

    private static final String DAY_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";

    @Override
    public void addCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        Customer customer = infoCustomer();
        customers.add(customer);
        System.out.println("Success add");
        WriteFileCustomer.writeStudentFile(PATH_CUSTOMER, customers);
    }

    @Override
    public void displayCustomer() {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        if (customers.size() == 0) {
            System.out.println("List the customer is empty");
        }
        for (Customer customer : customers) {
            System.out.println(customer.toString());
        }
    }

    @Override
    public void editCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        Customer customer = this.findCustomer();

        int positionEdit = customers.indexOf(customer);

        if (customer == null) {
            System.out.println("No have id in list Customer");
        } else {
            int chooseEdit = 0;
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
                    System.out.println("Input invalid");
                }
                switch (chooseEdit) {
                    case 1:
                        String nameCustomerEdit;
                        do {
                            System.out.println("Enter name of Customer");
                            try {
                                nameCustomerEdit = scan.nextLine();
                                if (!nameCustomerEdit.matches(NAME_CUSTOMER)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        customers.get(positionEdit).setNamePerson(nameCustomerEdit);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        String dayOfBirthEdit;
                        do {
                            System.out.println("Enter day of birth customer");
                            try {
                                dayOfBirthEdit= scan.nextLine();
                                if (Integer.parseInt(dayOfBirthEdit.substring(6)) > 2014) {
                                    throw new CheckException("Year old must be >18");
                                }
                                if (Integer.parseInt(dayOfBirthEdit.substring(6)) < 1922) {
                                    throw new CheckException("Year old mus be <100");
                                }
                                if (!dayOfBirthEdit.matches(DAY_OF_BIRTH)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Day of birth must be a number");
                            } catch (CheckException | StringIndexOutOfBoundsException e) {
                                System.out.println("Input invalid and string index of bound");
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
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        customers.get(positionEdit).setCMND(cmndEdit);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        String numberOfPhone;
                        do {
                            System.out.println("Enter number of phone customers, EX: 84-XXXXXXXXX");
                            try {
                                numberOfPhone = scan.nextLine();
                                if (!NumberOfPhone.checkNumberOf(numberOfPhone)) {
                                    throw new CheckException("Id must be in the correct format");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
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
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        customers.get(positionEdit).setEmail(emailEdit);
                        System.out.println("Success Edit");
                        break;
                    case 7:
                        String idEdit;
                        do {
                            System.out.println("Enter id of Customer want to edit");
                            try {
                                idEdit = scan.nextLine();
                                if (!idEdit.matches("\\S+")) {
                                    throw new CheckException("Input invalid");
                                }

                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        customers.get(positionEdit).setCustomerId(idEdit);
                        System.out.println("Success Edit");
                        break;
                    case 8:
                        String typeCustomerEdit = "";
                        while (true) {
                            try {
                                boolean check = false;
                                System.out.println("Enter select option to edit" +
                                        "\n 1. Diamond" +
                                        "\n 2. Plat" +
                                        "\n 3. Gold" +
                                        "\n 4. Silver" +
                                        "\n 5. Member" +
                                        "\n 6. Exit");
                                int choice = Integer.parseInt(scan.nextLine());
                                switch (choice) {
                                    case 1:
                                        typeCustomerEdit = "Diamond";
                                        check = true;
                                        break;
                                    case 2:
                                        typeCustomerEdit = "Plat";
                                        check = true;
                                        break;
                                    case 3:
                                        typeCustomerEdit = "Gold";
                                        check = true;
                                        break;
                                    case 4:
                                        typeCustomerEdit = "Silver";
                                        check = true;
                                        break;
                                    case 5:
                                        typeCustomerEdit = "Member";
                                        check = true;
                                        break;

                                    case 6:
                                        System.exit(0);
                                        break;
                                    default:
                                        System.out.println("Your selection is not suitable, selection from 1 to 6");
                                        check = true;
                                        break;

                                }
                                if (check) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input invalid");
                            }
                        }
                        customers.get(positionEdit).setCustomerType(typeCustomerEdit);
                        System.out.println("Success Edit");
                        break;
                    case 9:
                        String addressCustomerEdit;
                        do {
                            System.out.println("Enter address of Customers, ex: Đà Nẵng");
                            try {
                                addressCustomerEdit = scan.nextLine();
                                if (!Location.checkLocationObject(addressCustomerEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
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
        WriteFileCustomer.writeStudentFile(PATH_CUSTOMER, customers);
    }

    public Customer findCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        System.out.println("Enter id of Customer you want to find");
        String id = scan.nextLine();
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        WriteFileCustomer.writeStudentFile(PATH_CUSTOMER, customers);
        return null;
    }

    //    String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone,
//    String email, String customerId, String customerType, String addressCustomer
    public static Customer infoCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        String nameCustomer = "";
        do {
            System.out.println("Enter name of Customers");
            try {
                nameCustomer = scan.nextLine();
                if (!nameCustomer.matches(NAME_CUSTOMER)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        String dayOfBirth;
        do {
            System.out.println("Enter day of birth employee");
            try {
                dayOfBirth= scan.nextLine();
                if (Integer.parseInt(dayOfBirth.substring(6)) > 2014) {
                    throw new CheckException("Year old must be >18");
                }
                if (Integer.parseInt(dayOfBirth.substring(6)) < 1922) {
                    throw new CheckException("Year old mus be <100");
                }
                if (!dayOfBirth.matches(DAY_OF_BIRTH)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Day of birth must be a number");
            } catch (CheckException | StringIndexOutOfBoundsException e) {
                System.out.println("Input invalid and string index of bound");
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
                System.out.println("Input invalid");
            }
        } while (true);

        String numberOfPhone;
        do {
            System.out.println("Enter number of phone customers. EX: 84-XXXXXXXXX");
            try {
                numberOfPhone = scan.nextLine();
                if (!NumberOfPhone.checkNumberOf(numberOfPhone)) {
                    throw new CheckException("Id must be in the correct format");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
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
                System.out.println("Input invalid");
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
                if (!customerId.matches("\\S+")) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        String typeCustomer = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option to menu" +
                        "\n 1. Diamond" +
                        "\n 2. Plat" +
                        "\n 3. Gold" +
                        "\n 4. Silver" +
                        "\n 5. Member" +
                        "\n 6. Exit");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        typeCustomer = "Diamond";
                        check = true;
                        break;
                    case 2:
                        typeCustomer = "Plat";
                        check = true;
                        break;
                    case 3:
                        typeCustomer = "Gold";
                        check = true;
                        break;
                    case 4:
                        typeCustomer = "Silver";
                        check = true;
                        break;
                    case 5:
                        typeCustomer = "Member";
                        check = true;
                        break;

                    case 6:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 6");
                        check = true;
                        break;

                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }

        String addressCustomers;
        do {
            System.out.println("Enter address of Customers, ex: Đà Nẵng");
            try {
                addressCustomers = scan.nextLine();
                if (!Location.checkLocationObject(addressCustomers)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        WriteFileCustomer.writeStudentFile(PATH_CUSTOMER, customers);

        return new Customer(nameCustomer, dayOfBirth, gender, CMND, numberOfPhone, email, customerId, typeCustomer, addressCustomers);
    }

}
