package demo_haitt.demo_exercise1.service.util.write_readfile;

import demo_haitt.demo_exercise1.model.Student;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteFIle {
    public static void writeFile(String path, String string) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
       try {
           BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
           bufferWriter.write(string);
           bufferWriter.close();
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
    }

    public static void writeStudentFile(String path, List<Student> students) throws IOException {
        String data = "";
        for (Student student : students) {
            data += student.toString()+"\n";
        }
        WriteFIle.writeFile(path, data);
    }
}
