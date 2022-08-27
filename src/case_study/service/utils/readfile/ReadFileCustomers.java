package case_study.service.utils.readfile;

import case_study.model.customer.Customer;
import case_study.model.employee.Employee;

import java.util.ArrayList;
import java.util.List;

public class ReadFileCustomers {
    //    String nameEmployee, String dayOfBirth, String gender, String CMND, String numberOfPhone,
//    String email, String customerId, String customerType, String addressCustomer
    public static List<Customer> readCustomerFile(String path) {
        List<String> strings = ReadFile.readFile(path);
        List<Customer> customers = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            customers.add(new Customer(info[0], info[1], info[2], info[3], info[4], info[5], info[6], info[7], info[8]));
        }
        return customers;
    }
}
