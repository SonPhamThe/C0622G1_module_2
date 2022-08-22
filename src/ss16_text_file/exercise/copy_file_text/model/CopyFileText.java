package ss16_text_file.exercise.copy_file_text.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyFileText {
    public static List<String> readFile(String path) {
        List<String> strings = new ArrayList<>();
        try {
            File file = new File(path);
            if (!file.exists()) {
                throw new FindNotFoundException("Not found this file path");
            }
            BufferedReader bufferReader = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = bufferReader.readLine()) != null) {
                strings.add(line);
            }
            bufferReader.close();
        } catch (FindNotFoundException | IOException e) {
            throw new RuntimeException(e);
        }
        return strings;
    }

    public static void writeFile(String path, List<String> string) {
        try {
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
            for (String strings : string) {
                bufferWriter.write(strings);
                bufferWriter.newLine();
            }
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
