package case_study.service.impl;

import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import case_study.service.IEmployee;
import case_study.service.exception.CheckException;
import case_study.service.utils.readfile.ReadFileEmployee;
import case_study.service.utils.writefile.WriteFileEmployee;
import case_study.service.validate.employee.*;
import demo_haitt.demo_exercise1.service.Exception.numberformatexception.InfoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployee {
    private static final Scanner scan = new Scanner(System.in);
    private static List<Employee> employees = new ArrayList<>();

    private static final String pathEmployee = "src/case_study/data/employee.csv";

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
            int chooseEdit;
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
                    throw new RuntimeException(e);
                }
                switch (chooseEdit) {
                    case 1:
                        String nameEmployeeEdit;
                        do {
                            System.out.println("Enter name of Employee");
                            try {
                                nameEmployeeEdit = scan.nextLine();
                                if (!NamePerson.checkNameObject(nameEmployeeEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
//                        employees.get(positionEdit).setNameEmployee(nameEmployeeEdit);
                        System.out.println("Success Edit");
                        break;
                    case 2:
                        String dayOfBirthEdit;
                        do {
                            try {
                                System.out.print("Enter day of birth employees: ");
                                dayOfBirthEdit = scan.nextLine();
                                if (!DayOfBirthPerson.checkDayOfBirth(dayOfBirthEdit)) {
                                    throw new CheckException("Invalid input data");
                                }
                                if (Integer.parseInt(dayOfBirthEdit.substring(0, 1).concat(dayOfBirthEdit.substring(1, 2))) > 31) {
                                    throw new CheckException("Invalid input data");
                                }
                                if (Integer.parseInt(dayOfBirthEdit.substring(3, 4).concat(dayOfBirthEdit.substring(4, 5))) > 12) {
                                    throw new CheckException("Invalid input data");
                                }
                                if (!checkDayMonthYearEmployee(dayOfBirthEdit)) {
                                    throw new CheckException("Invalid input data");
                                }
                                if (Integer.parseInt(dayOfBirthEdit.substring(6)) > 2015) {
                                    throw new CheckException("Invalid input data");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
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
                                System.out.println(e.getMessage());
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
                                System.out.println(e.getMessage());
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
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        employees.get(positionEdit).setEmail(emailEdit);
                        System.out.println("Success Edit");
                        break;
                    case 7:
                        System.out.println("Enter id of Employee want to edit");
                        String idEdit = scan.nextLine();
                        employees.get(positionEdit).setEmployeeId(idEdit);
                        System.out.println("Success Edit");
                        break;
                    case 8:
                        String levelEdit;
                        do {
                            System.out.println("Enter level of Employees");
                            try {
                                levelEdit = scan.nextLine();
                                String str;
                                if (!Level.checkLevelObject(levelEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
                        employees.get(positionEdit).setLevel(levelEdit);
                        System.out.println("Success Edit");
                        break;
                    case 9:
                        String locationEdit;
                        do {
                            System.out.println("Enter location of Employees");
                            try {
                                locationEdit = scan.nextLine();
                                String str;
                                if (!Location.checkLocationObject(locationEdit)) {
                                    throw new CheckException("Input invalid");
                                }
                                break;
                            } catch (CheckException e) {
                                System.out.println(e.getMessage());
                            }
                        } while (true);
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
                                System.out.println(e.getMessage());
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
        employees = ReadFileEmployee.readEmployeeFile(pathEmployee);

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
                System.out.println(e.getMessage());
            }
        } while (true);

        String dayOfBirth;
        do {
            try {
                System.out.print("Enter day of birth employees: ");
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
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
                System.out.println(e.getMessage());
            }
        } while (true);

        String employeeId;
        do {
            System.out.println("Enter id of employees");
            try {
                employeeId = scan.nextLine();
                for (Employee employee : employees) {
                    if (employee.getEmployeeId().equals(employeeId)) {
                        throw new CheckException("The id has been matched");
                    }
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String level = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Enter select option to menu" +
                        "\n 1. Trung cấp" +
                        "\n 2. Cao đẳng" +
                        "\n 3. Đại học" +
                        "\n 4. sau đại học" +
                        "\n 5. Quay lại");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        level = "Trung cấp";
                        check = true;
                        break;
                    case 2:
                        level = "Cao đẳng";
                        check = true;
                        break;
                    case 3:
                        level = "Đại học";
                        check = true;
                        break;
                    case 4:
                        level = "sau đại học";
                        check = true;
                        break;
                    case 5:
                        infoEmployee();
                        break;
                    default:
                        System.out.println("Chọn đúng vào");
                        break;

                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        String location = "";
        while (true) {
            try {
                boolean check = false;
                System.out.println("Vui lòng chọn một số lựa chọn sau" +
                        "\n 1. Lễ tân" +
                        "\n 2. Phục vụ" +
                        "\n 3. Chuyên viên" +
                        "\n 4. Giám sát" +
                        "\n 5. Quản lý" +
                        "\n 6. Giám đốc" +
                        "\n 7. Quay lại");
                int choice = Integer.parseInt(scan.nextLine());
                switch (choice) {
                    case 1:
                        location = "Lễ tân";
                        check = true;
                        break;
                    case 2:
                        location = "Phục vụ";
                        check = true;
                        break;
                    case 3:
                        location = "Chuyên viên";
                        check = true;
                        break;
                    case 4:
                        location = "Giám sát";
                        check = true;
                        break;
                    case 5:
                        location = "Quản lý";
                        check = true;
                        break;
                    case 6:
                        location = "Giám đốc";
                        check = true;
                        break;
                    case 7:
                        infoEmployee();
                        break;
                    default:
                        System.out.println("Chọn đúng vào");
                        break;

                }
                if (check) {
                    break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        double wage;
        do {
            System.out.println("Enter wage of Employees");
            try {
                wage = Double.parseDouble(scan.nextLine());
                if (wage < 0) {
                    throw new CheckException("Id must be >0");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        WriteFileEmployee.writeStudentFile(pathEmployee, employees);

        return new Employee(nameEmployee, dayOfBirth, gender, CMND, numberOfPhone, email, employeeId, level, location, wage);
        //    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone,
        //    String email, String employeeId, String level, String location, double wage
    }

    public static boolean checkDayMonthYearEmployee(String string) {
        int[] day = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] arr = new int[3];
        arr[0] = Integer.parseInt(string.substring(0, 1).concat(string.substring(1, 2)));
        arr[1] = Integer.parseInt(string.substring(3, 4).concat(string.substring(4, 5)));
        arr[2] = Integer.parseInt(string.substring(6));
        if (arr[2] % 4 == 0 && !(arr[2] % 100 == 0 && arr[2] % 400 != 0)) {
            arr[0] = day[arr[1] - 1] + 1;
        }
        return (arr[0] <= day[arr[1] - 1]);
    }
}
