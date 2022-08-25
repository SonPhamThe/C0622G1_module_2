package case_study.service.impl;

import case_study.model.employee.Employee;
import case_study.service.IEmployee;
import case_study.service.exception.CheckException;
import demo_haitt.demo_exercise1.service.Exception.numberformatexception.InfoException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployee {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Employee> employees = new ArrayList<>();
    static {
        employees.add(new Employee("Son","12/04/1999","male","123456789123","12345678912","aujhagag@gmail.com","1a","one","USA",1267517651));
        employees.add(new Employee("Vinh","13/05/1999","female","123456789145","12345678923","aujhagag@gmail.com","2a","two","English",126751742));
        employees.add(new Employee( "Peter","14/06/1999","male","123456789167","12345678945","aujhagag@gmail.com","3a","three","Germany",126756751));
    }
//    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String employeeId, String level, String location, double wage

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

//    String nameEmployee, String dayOfBirth, String gender, long CMND, long numberOfPhone, String email, String employeeId, String level, String location, double wage

    @Override
    public void editEmployee() {
        Employee employee = this.findEmployee();

        int positionEdit = employees.indexOf(employee);

        if (employee == null) {
            System.out.println("No have id in list employee");
        }
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
                            String str;
                            for (int i = 0; i < nameEmployeeEdit.length(); i++) {
                                str = "";
                                if ((str + nameEmployeeEdit.charAt(i)).matches("\\d+")) {
                                    throw new InfoException("Input invalid");
                                }
                            }
                            break;
                        } catch (InfoException e) {
                            System.out.println(e.getMessage());
                        }
                    } while (true);
                    employees.get(positionEdit).setNameEmployee(nameEmployeeEdit);
                    System.out.println("Success Edit");
                    break;
                case 2:
                    String dayOfBirthEdit;
                    do {
                        try {
                            System.out.print("Enter day of birth employees: ");
                            dayOfBirthEdit = scan.nextLine();
                            if (!dayOfBirthEdit.matches("\\d+\\d+\\W+\\d+\\d+\\W+\\d+\\d+\\d+\\d")) {
                                throw new InfoException("Invalid input data");
                            }
                            if (Integer.parseInt(dayOfBirthEdit.substring(0, 1).concat(dayOfBirthEdit.substring(1, 2))) > 31) {
                                throw new InfoException("Invalid input data");
                            }
                            if (Integer.parseInt(dayOfBirthEdit.substring(3, 4).concat(dayOfBirthEdit.substring(4, 5))) > 12) {
                                throw new InfoException("Invalid input data");
                            }
                            if (!checkDayMonthYearEmployee(dayOfBirthEdit)) {
                                throw new InfoException("Invalid input data");
                            }
                            if (Integer.parseInt(dayOfBirthEdit.substring(6)) > 2015) {
                                throw new InfoException("Invalid input data");
                            }
                            break;
                        } catch (InfoException e) {
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
                            if (!cmndEdit.matches("\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d")) {
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
                            if (!numberOfPhone.matches("\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d")) {
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
                            for (int i = 0; i < emailEdit.length(); i++) {
                                if (!(emailEdit.contains("@"))) {
                                    throw new CheckException("Input invalid");
                                }
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
                            for (int i = 0; i < levelEdit.length(); i++) {
                                str = "";
                                if ((str + levelEdit.charAt(i)).matches("\\d+")) {
                                    throw new CheckException("Input invalid");
                                }
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
                            for (int i = 0; i < locationEdit.length(); i++) {
                                str = "";
                                if ((str + locationEdit.charAt(i)).matches("\\d+")) {
                                    throw new CheckException("Input invalid");
                                }
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
                    System.out.println("Your selection is not suitable, selections from 1 to 11");
            }
            break;
        } while (true);
    }

    public Employee findEmployee() {
        System.out.println("Enter id of Employee you want to find");
        String id = scan.nextLine();
        for (Employee employee : employees) {
            if (employee.getEmployeeId().equals(id)) {
                return employee;
            }
        }
        return null;
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
                if (!checkDayMonthYearEmployee(dayOfBirth)) {
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

        String CMND;
        do {
            System.out.println("Enter cmnd of Employees");
            try {
                CMND = scan.nextLine();
                if (!CMND.matches("\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d")) {
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
                if (!numberOfPhone.matches("\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d+\\d")) {
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
