package case_study.service.utils.writefile;

import case_study.model.employee.Employee;

import demo_haitt.demo_exercise1.service.util.write_readfile.WriteFIle;

import java.io.IOException;
import java.util.List;

public class WriteFileEmployee {
    public static void writeEmployeeFile(String path, List<Employee> employees) throws IOException {
        String data = "";
        for (Employee employee : employees) {
            data += employee.toString()+"\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
