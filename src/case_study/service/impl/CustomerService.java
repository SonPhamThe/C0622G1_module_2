package case_study.service.impl;

import case_study.model.customer.Customer;
import case_study.service.ICustomer;
import case_study.service.exception.CheckException;
import case_study.service.utils.my_date.MyCheckDate;
import case_study.service.utils.my_date.MyDate;
import case_study.service.utils.readfile.ReadFileCustomers;
import case_study.service.utils.writefile.WriteFileCustomer;
import case_study.service.vahidate.IdCard;
import case_study.service.vahidate.Mail;
import case_study.service.vahidate.NameLocation;
import case_study.service.vahidate.NumberOfPhone;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomer {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Customer> customers = new LinkedList<>();

    private static final String PATH_CUSTOMER = "src/case_study/data/customer.csv";


    @Override
    public void addCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        Customer customer = infoCustomer();
        customers.add(customer);
        System.out.println("Success add");
        WriteFileCustomer.writeCustomerFile(PATH_CUSTOMER, customers);
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
                        "\n 2. Day of birth of Customer" +
                        "\n 3. Gender of Customer" +
                        "\n 4. ID Card of Customer" +
                        "\n 5. Name of phone Customer" +
                        "\n 6. Email of Customer" +
                        "\n 7. Id of Customer" +
                        "\n 8. Type of Customer" +
                        "\n 9. Address of Customer" +
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
                                if (!NameLocation.checkNameLocation(nameCustomerEdit)) {
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
                        System.out.println("Enter day of birth Customer");
                        MyDate dayOfBirth = MyCheckDate.getDateInfo(18, 100);
                        dayOfBirth.getStrDate();
                        customers.get(positionEdit).setDayOfBirth(dayOfBirth.getStrDate());
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        String genderEdit;
                        do {
                            System.out.println("Enter gender of Customer");
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
                        String idCardEdit;
                        do {
                            System.out.println("Enter ID Card of Customer");
                            try {
                                idCardEdit = scan.nextLine();
                                if (!IdCard.checkIdCard(idCardEdit)) {
                                    throw new CheckException("Id mus be in the correct format");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        customers.get(positionEdit).setIdCard(idCardEdit);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        String numberOfPhone;
                        do {
                            System.out.println("Enter number of phone Customer, EX: 84-XXXXXXXXX");
                            try {
                                numberOfPhone = scan.nextLine();
                                if (!NumberOfPhone.checkNumberOfPhone(numberOfPhone)) {
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
                            System.out.println("Enter email of Customer");
                            try {
                                emailEdit = scan.nextLine();
                                if (!Mail.checkMail(emailEdit)) {
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
                            System.out.println("Enter address of Customer, ex: Đà Nẵng");
                            try {
                                addressCustomerEdit = scan.nextLine();
                                if (!NameLocation.checkNameLocation(addressCustomerEdit)) {
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
        WriteFileCustomer.writeCustomerFile(PATH_CUSTOMER, customers);
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
        WriteFileCustomer.writeCustomerFile(PATH_CUSTOMER, customers);
        return null;
    }

    public Customer findCustomerId(String id) throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(id)) {
                return customer;
            }
        }
        WriteFileCustomer.writeCustomerFile(PATH_CUSTOMER, customers);
        return null;
    }

    //    String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone,
//    String email, String customerId, String customerType, String addressCustomer
    public static Customer infoCustomer() throws IOException {
        ReadFileCustomers.readCustomerFile(PATH_CUSTOMER);
        String nameCustomer = "";
        do {
            System.out.println("Enter name of Customer");
            try {
                nameCustomer = scan.nextLine();
                if (!NameLocation.checkNameLocation(nameCustomer)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        System.out.println("Enter day of birth Customer");
        MyDate dayOfBirth = MyCheckDate.getDateInfo(18, 100);
        dayOfBirth.getStrDate();

        String gender;
        do {
            System.out.println("Enter gender of Customer");
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

        String idCard;
        do {
            System.out.println("Enter ID Card of Customer");
            try {
                idCard = scan.nextLine();
                if (!IdCard.checkIdCard(idCard)) {
                    throw new CheckException("Id mus be in the correct format");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        String numberOfPhone;
        do {
            System.out.println("Enter number of phone Customer. EX: 84-XXXXXXXXX");
            try {
                numberOfPhone = scan.nextLine();
                if (!NumberOfPhone.checkNumberOfPhone(numberOfPhone)) {
                    throw new CheckException("Id must be in the correct format");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        String email;
        do {
            System.out.println("Enter email of Customer");
            try {
                email = scan.nextLine();
                if (!Mail.checkMail(email)) {
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
            System.out.println("Enter address of Customer, ex: Đà Nẵng");
            try {
                addressCustomers = scan.nextLine();
                if (!NameLocation.checkNameLocation(addressCustomers)) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        WriteFileCustomer.writeCustomerFile(PATH_CUSTOMER, customers);

        return new Customer(nameCustomer, dayOfBirth.getStrDate(), gender, idCard, numberOfPhone, email, customerId, typeCustomer, addressCustomers);
    }
}
