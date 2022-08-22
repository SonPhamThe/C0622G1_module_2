package demo_haitt.demo_exercise1.service.util;
import demo_haitt.demo_exercise1.model.Student;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) throws IOException {
        File file = new File(path);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferReader = new BufferedReader(fileReader);

        String line;
        List<String> strings = new ArrayList<>();
//        bufferReader.readLine(); loại bỏ tiêu đề
        while ((line = bufferReader.readLine()) != null) {
            strings.add(line);
        }
        bufferReader.close();
        return strings;
    }

    public static List<Student> readStudentFile(String path) throws IOException {
        List<String> strings = readFile(path);
        List<Student> students = new ArrayList<>();
        String[] info;
        for (String line : strings) {
            info = line.split(",");
            students.add(new Student(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Double.parseDouble(info[5])));
        }
        return students;
    }
}
