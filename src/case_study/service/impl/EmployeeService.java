package case_study.service.impl;

import case_study.model.employee.Employee;
import case_study.service.IEmployee;
import case_study.service.exception.CheckException;
import demo_haitt.demo_exercise1.service.Exception.numberformatexception.InfoException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployee {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();

    @Override
    public void addEmployee() {
        Employee employee = this.infoEmployee();
        employees.add(employee);
        System.out.println("Success add");
    }

    @Override
    public void displayEmployee() {
        if (employees.size() == 0) {
            System.out.println("List the employee is empty");
        }
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    public Employee infoEmployee() {
        String nameEmployee = "";
        do {
            System.out.println("Enter name of Employees");
            try {
                nameEmployee = scan.nextLine();
                String str;
                for (int i = 0; i < nameEmployee.length(); i++) {
                    str = "";
                    if ((str + nameEmployee.charAt(i)).matches("\\d+")) {
                        throw new CheckException("Input invalid");
                    }
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
                if (!dayOfBirth.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(0, 1).concat(dayOfBirth.substring(1, 2))) > 31) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(3, 4).concat(dayOfBirth.substring(4, 5))) > 12) {
                    throw new InfoException("Invalid input data");
                }
                if (!checkDayMonthYear(dayOfBirth)) {
                    throw new InfoException("Invalid input data");
                }
                if (Integer.parseInt(dayOfBirth.substring(6)) > 2015) {
                    throw new InfoException("Invalid input data");
                }
                break;
            } catch (InfoException e) {
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

        long CMND;
        do {
            System.out.println("Enter cmnd of employees");
            try {
                CMND = Long.parseLong(scan.nextLine());
                if (CMND > 1000000000000.0) {
                    throw new CheckException("Id mus be <100000000000");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        long numberOfPhone;
        do {
            System.out.println("Enter number of phone employees");
            try {
                numberOfPhone = Long.parseLong(scan.nextLine());
                if (numberOfPhone > 100000000000.0) {
                    throw new CheckException("Id must be <10000000000");
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Score must be a number");
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String email;
        do {
            System.out.println("Enter email of employees");
            try {
                email = scan.nextLine();
                for (int i = 0; i < email.length(); i++) {
                    if (!(email.contains("@"))) {
                        throw new CheckException("Input invalid");
                    }
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

        String level;
        do {
            System.out.println("Enter level of Employees");
            try {
                level = scan.nextLine();
                String str;
                for (int i = 0; i < level.length(); i++) {
                    str = "";
                    if ((str + level.charAt(i)).matches("\\d+")) {
                        throw new CheckException("Input invalid");
                    }
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String location;
        do {
            System.out.println("Enter location of Employees");
            try {
                location = scan.nextLine();
                String str;
                for (int i = 0; i < location.length(); i++) {
                    str = "";
                    if ((str + location.charAt(i)).matches("\\d+")) {
                        throw new CheckException("Input invalid");
                    }
                }
                break;
            } catch (CheckException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

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

        return new Employee(nameEmployee, dayOfBirth, gender, CMND, numberOfPhone, email, employeeId, level, location, wage);
        //    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone,
        //    String email, String employeeId, String level, String location, double wage
    }

    public static boolean checkDayMonthYear(String string) {
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
