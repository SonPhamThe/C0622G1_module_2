package ss16_text_file.practice.find_max.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FindMaxAndWrite {
    public List<Integer> readFile(String path) {
        List<Integer> numbers = new ArrayList<>();
        try {
            File file = new File(path);

            if (!file.exists()) {
                throw new FileNotFoundException();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line = "";
            while ((line = br.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }
            br.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return numbers;
    }

    public void writeFile(String path, int max) {
        try {
            FileWriter writer = new FileWriter(path);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write("Max is: "+max);
            bufferWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }
}
