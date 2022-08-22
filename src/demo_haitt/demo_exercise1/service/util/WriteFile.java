package demo_haitt.demo_exercise1.service.util;

import ss16_text_file.exercise.mvc.model.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFile {
    public static void writeFile(String path, String data) throws IOException {
        File file = new File(path);
        BufferedWriter bufferWriter = new BufferedWriter(new FileWriter(file));
        bufferWriter.write(data);
        bufferWriter.close();
    }

    public static void writeStudentFile(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student : students) {
            data += student.toString();
        }
        writeFile(path, data);
    }
}
