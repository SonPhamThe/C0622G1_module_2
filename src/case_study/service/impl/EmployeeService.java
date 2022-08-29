package case_study.service.impl;

import case_study.model.employee.Employee;
import case_study.service.IEmployee;
import case_study.service.exception.CheckException;
import case_study.service.utils.my_date.MyCheckDate;
import case_study.service.utils.my_date.MyDate;
import case_study.service.utils.readfile.ReadFileEmployee;
import case_study.service.utils.writefile.WriteFileEmployee;
import case_study.service.utils.validate.employee.CmndPerson;
import case_study.service.utils.validate.employee.Mail;
import case_study.service.utils.validate.employee.NumberOfPhone;
import demo_haitt.demo_exercise1.service.Exception.numberformatexception.InfoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployee {
    private static final Scanner scan = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();
    private static final String pathEmployee = "src/case_study/data/employee.csv";
    private static final String NAME_PERSON = "^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$";

    private static final String DAY_OF_BIRTH = "^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
//    static {
//        employees.add(new Employee("Son", "12/04/1999", "male", "123456789123", "12345678912", "aujhagag@gmail.com", "1a", "one", "USA", 1267517651));
//        employees.add(new Employee("Vinh", "13/05/1999", "female", "123456789145", "12345678923", "aujhagag@gmail.com", "2a", "two", "English", 126751742));
//        employees.add(new Employee("Peter", "14/06/1999", "male", "123456789167", "12345678945", "aujhagag@gmail.com", "3a", "three", "Germany", 126756751));
//    }
//    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String employeeId, String level, String location, double wage

    @Override
    public void addEmployee() throws IOException {
        employees = ReadFileEmployee.readEmployeeFile(pathEmployee);
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Success add");
        WriteFileEmployee.writeStudentFile(pathEmployee, employees);
    }

    @Override
    public void displayEmployee() {
        System.out.println("-----------------List the Employee---------------");

        employees = ReadFileEmployee.readEmployeeFile(pathEmployee);

        if (employees.size() == 0) {
            System.out.println("List the employee is empty");
        }
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

//    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String employeeId, String level, String location, double wage

    @Override
    public void editEmployee() throws IOException {
        employees = ReadFileEmployee.readEmployeeFile(pathEmployee);
        Employee employee = this.findEmployee();

        int positionEdit = employees.indexOf(employee);

        if (employee == null) {
            System.out.println("No have id in list employee");
        } else {
            int chooseEdit = 0;
            do {
                System.out.println("--------------------------");
                System.out.println("Employee need edit" +
                        "\n 1. Name of Employee" +
                        "\n 2. Day of birth of employee" +
                        "\n 3. Gender of employee" +
                        "\n 4. CMND of employee" +
                        "\n 5. Name of phone employee" +
                        "\n 6. Email of employee" +
                        "\n 7. Id of employee" +
                        "\n 8. Level of employee" +
                        "\n 9. Location of employee" +
                        "\n 10. Wage of employee" +
                        "\n 11. Return menu" +
                        "\n 12. Exit");
                try {
                    chooseEdit = Integer.parseInt(scan.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Input invalid");
                }
                switch (chooseEdit) {
                    case 1:
                        String nameEmployeeEdit;
                        do {
                            System.out.println("Enter name of Employee");
                            try {
                                nameEmployeeEdit = scan.nextLine();
                                if (!nameEmployeeEdit.matches(NAME_PERSON)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        employees.get(positionEdit).setEmployeeId(nameEmployeeEdit);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        String dayOfBirthEdit;
                        do {
                            System.out.println("Enter day of birth edit to employee");
                            try {
                                dayOfBirthEdit = scan.nextLine();
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
                        employees.get(positionEdit).setDayOfBirth(dayOfBirthEdit);
                        System.out.println("Success Edit");
                        break;
                    case 3:
                        String genderEdit;
                        do {
                            System.out.println("Enter gender of Employees");
                            try {
                                genderEdit = scan.nextLine();
                                if (!genderEdit.equals("male") && !genderEdit.equals("female")) {
                                    throw new InfoException("Let enter gender is male or female, don't input exception");
                                }
                                break;
                            } catch (InfoException e) {
                                System.out.println("Let enter gender is male or female, don't input exception");
                            }
                        } while (true);
                        employees.get(positionEdit).setGender(genderEdit);
                        System.out.println("Success Edit");
                        break;
                    case 4:
                        String cmndEdit;
                        do {
                            System.out.println("Enter cmnd of Employees");
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
                        employees.get(positionEdit).setCMND(cmndEdit);
                        System.out.println("Success Edit");
                        break;
                    case 5:
                        String numberOfPhone;
                        do {
                            System.out.println("Enter number of phone employees");
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
                        employees.get(positionEdit).setNumberOfPhone(numberOfPhone);
                        System.out.println("Success Edit");
                        break;
                    case 6:
                        String emailEdit;
                        do {
                            System.out.println("Enter email of employees");
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
                        employees.get(positionEdit).setEmail(emailEdit);
                        System.out.println("Success Edit");
                        break;
                    case 7:
                        String idEdit;
                        do {
                            System.out.println("Enter id of Employee want to edit");
                            try {
                                idEdit = scan.nextLine();
                                if (!idEdit.matches("\\S*")) {
                                    throw new CheckException("Input invalid");
                                }

                                break;
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        employees.get(positionEdit).setEmployeeId(idEdit);
                        System.out.println("Success Edit");
                        break;
                    case 8:
                        String levelEdit = "";
                        while (true) {
                            try {
                                boolean check = false;
                                System.out.println("Enter select option to edit" +
                                        "\n 1. Intermediate" +
                                        "\n 2. College" +
                                        "\n 3. University" +
                                        "\n 4. After university" +
                                        "\n 5. Return");
                                int choice = Integer.parseInt(scan.nextLine());
                                switch (choice) {
                                    case 1:
                                        levelEdit = "Intermediate";
                                        check = true;
                                        break;
                                    case 2:
                                        levelEdit = "College";
                                        check = true;
                                        break;
                                    case 3:
                                        levelEdit = "University";
                                        check = true;
                                        break;
                                    case 4:
                                        levelEdit = "After university";
                                        check = true;
                                        break;
                                    case 5:
                                        infoEmployee();
                                        break;
                                    default:
                                        System.out.println("Your selection is not suitable, selection from 1 to 5");
                                        break;

                                }
                                if (check) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input invalid");
                            }
                        }
                        employees.get(positionEdit).setLevel(levelEdit);
                        System.out.println("Success Edit");
                        break;
                    case 9:
                        String locationEdit = " ";
                        while (true) {
                            try {
                                boolean check = false;
                                System.out.println("Enter select option to edit" +
                                        "\n 1. Receptionist" +
                                        "\n 2. Service" +
                                        "\n 3. Expert" +
                                        "\n 4. Monitoring" +
                                        "\n 5. Manage" +
                                        "\n 6. Manager" +
                                        "\n 7. Return");
                                int choice = Integer.parseInt(scan.nextLine());
                                switch (choice) {
                                    case 1:
                                        locationEdit = "Receptionist";
                                        check = true;
                                        break;
                                    case 2:
                                        locationEdit = "Service";
                                        check = true;
                                        break;
                                    case 3:
                                        locationEdit = "Expert";
                                        check = true;
                                        break;
                                    case 4:
                                        locationEdit = "Monitoring";
                                        check = true;
                                        break;
                                    case 5:
                                        locationEdit = "Manage";
                                        check = true;
                                        break;
                                    case 6:
                                        locationEdit = "Manager";
                                        check = true;
                                        break;
                                    case 7:
                                        infoEmployee();
                                        break;
                                    default:
                                        System.out.println("Your selection is not suitable, selection from 1 to 7");
                                        break;

                                }
                                if (check) {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Input invalid");
                            }
                        }
                        employees.get(positionEdit).setLocation(locationEdit);
                        System.out.println("Success Edit");
                        break;
                    case 10:
                        double wageEdit;
                        do {
                            System.out.println("Enter wage of Employees");
                            try {
                                wageEdit = Double.parseDouble(scan.nextLine());
                                if (wageEdit < 0) {
                                    throw new CheckException("Id must be >0");
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("Score must be a number");
                            } catch (CheckException e) {
                                System.out.println("Input invalid");
                            }
                        } while (true);
                        employees.get(positionEdit).setWage(wageEdit);
                        System.out.println("Success Edit");
                        break;
                    case 11:
                        editEmployee();
                        break;
                    case 12:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selections from 1 to 12");
                }
                break;
            } while (true);
            WriteFileEmployee.writeStudentFile(pathEmployee, employees);
        }
    }

    public Employee findEmployee() throws IOException {
        employees = ReadFileEmployee.readEmployeeFile(pathEmployee);
        System.out.println("Enter id of Employee you want to find");
        String id = scan.nextLine();
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(id)) {
                return employee;
            }
        }
        WriteFileEmployee.writeStudentFile(pathEmployee, employees);

        return null;
    }

    public Employee infoEmployee() throws IOException {
        String nameEmployee;
        do {
            System.out.println("Enter name of Employees");
            try {
                nameEmployee = scan.nextLine();
                if (!nameEmployee.matches("^\\p{Lu}\\p{Ll}+(\\s\\p{Lu}\\p{Ll}+)*$")) {
                    throw new CheckException("Input invalid");
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        System.out.println("Enter day of birth employee");
        MyDate dayOfBirth = MyCheckDate.getDateInfo(18, 100);
        dayOfBirth.getStrDate();

        String gender;
        do {
            System.out.println("Enter gender of Employees");
            try {
                gender = scan.nextLine();
                if (!gender.equals("male") && !gender.equals("female")) {
                    throw new InfoException("Let enter gender is male or female, don't input exception");
                }
                break;
            } catch (InfoException e) {
                System.out.println("Let enter gender is male or female, don't input exception");
            }
        } while (true);

        String CMND;
        do {
            System.out.println("Enter cmnd of Employees");
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
            System.out.println("Enter number of phone employees");
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
            System.out.println("Enter email of employees");
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

        String idEmployee;
        do {
            System.out.println("Enter id of Employee want to add");
            try {
                idEmployee = scan.nextLine();
                if (!idEmployee.matches("\\S*")) {
                    throw new CheckException("Input invalid");
                }
                for (Employee employee : employees) {
                    if (employee.getEmployeeId().equals(idEmployee)) {
                        throw new CheckException("The id has been matched");
                    }
                }
                break;
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        String level = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option to menu" +
                        "\n 1. Intermediate" +
                        "\n 2. College" +
                        "\n 3. University" +
                        "\n 4. After university" +
                        "\n 5. Return");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        level = "Intermediate";
                        check = true;
                        break;
                    case 2:
                        level = "College";
                        check = true;
                        break;
                    case 3:
                        level = "University";
                        check = true;
                        break;
                    case 4:
                        level = "After university";
                        check = true;
                        break;
                    case 5:
                        infoEmployee();
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 5");
                        break;

                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }

        String location = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option to menu" +
                        "\n 1. Receptionist" +
                        "\n 2. Service" +
                        "\n 3. Expert" +
                        "\n 4. Monitoring" +
                        "\n 5. Manage" +
                        "\n 6. Manager" +
                        "\n 7. Return");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        location = "Receptionist";
                        check = true;
                        break;
                    case 2:
                        location = "Service";
                        check = true;
                        break;
                    case 3:
                        location = "Expert";
                        check = true;
                        break;
                    case 4:
                        location = "Monitoring";
                        check = true;
                        break;
                    case 5:
                        location = "Manage";
                        check = true;
                        break;
                    case 6:
                        location = "Manager";
                        check = true;
                        break;
                    case 7:
                        infoEmployee();
                        break;
                    default:
                        System.out.println("Your selection is not suitable, selection from 1 to 7");
                        break;

                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Input invalid");
            }
        }

        double wage;
        do {
            try {
                System.out.println("Enter wage of employees");
                wage = Double.parseDouble(scan.nextLine());
                if (wage < 0) {
                    throw new CheckException("Id must be >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println("Input invalid");
            }
        } while (true);

        return new

                Employee(nameEmployee, dayOfBirth.getStrDate(), gender, CMND, numberOfPhone, email, idEmployee, level, location, wage);
        //    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone,
        //    String email, String employeeId, String level, String location, double wage
    }
}
