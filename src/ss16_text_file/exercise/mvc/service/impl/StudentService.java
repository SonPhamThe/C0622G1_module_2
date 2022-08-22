package ss16_text_file.exercise.mvc.service.impl;

import demo_mvc.model.Student;
import ss16_text_file.exercise.mvc.service.IStudent;
import ss16_text_file.exercise.mvc.service.util.ReadFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();
    private static fi String path = "src/ss16_text_file/exercise/mvc/data/person.txt";
    private final ReadFile readFile = new ReadFile();

    @Override
    public void displayStudent() throws IOException {
        ReadFile.readStudentFile(path);
    }
}
