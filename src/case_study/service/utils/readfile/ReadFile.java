package case_study.service.utils.readfile;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFile {
    public static List<String> readFile(String path) {
        FileReader fileReader;
        BufferedReader bufferReader;
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
}
