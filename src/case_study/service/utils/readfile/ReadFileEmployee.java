package case_study.service.utils.readfile;

import case_study.model.customer.Customer;
import case_study.model.employee.Employee;
import demo_haitt.demo_exercise1.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ReadFileEmployee {
    public static List<Employee> readEmployeeFile(String path) {
        List<String> strings = ReadFile.readFile(path);
        List<Employee> employees = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            employees.add(new Employee(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8],Double.parseDouble(info[9])));
        }
        return employees;
    }
}
