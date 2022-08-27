package case_study.service.utils.writefile;

import case_study.model.customer.Customer;
import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.service.util.write_readfile.WriteFIle;

import java.io.IOException;
import java.util.List;

public class WriteFileCustomer {
    public static void writeStudentFile(String path, List<Customer> customers) throws IOException {
        String data = "";
        for (Customer customer : customers) {
            data += customer.toString() + "\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
