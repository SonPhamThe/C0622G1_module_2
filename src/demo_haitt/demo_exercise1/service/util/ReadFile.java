package demo_haitt.demo_exercise1.service.util;

import demo_haitt.demo_exercise1.model.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) {
        FileReader fileReader;
        BufferedReader bufferReader = null;
        String line;
        List<String> strings = new ArrayList<>();
        try {
            fileReader = new FileReader(path);
            bufferReader = new BufferedReader(fileReader);
            while ((line = bufferReader.readLine()) != null) {
                strings.add(line);
            }
            bufferReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }

    public static List<Student> readStudentFile(String path) {
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