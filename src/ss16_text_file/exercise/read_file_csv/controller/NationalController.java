package ss16_text_file.exercise.read_file_csv.controller;

import ss16_text_file.exercise.read_file_csv.model.National;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NationalController {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        add();
    }

    public static void add() throws IOException {
        List<National> nationals = new ArrayList<>();

//        System.out.println("Enter id you want to add");
//        int id = Integer.parseInt(scan.nextLine());
//        System.out.println("Enter code you want to add");
//        String code = scan.nextLine();
//        System.out.println("Enter name you want to add");
//        String name = scan.nextLine();
//        nationals.add(new National(id, code, name));

        writeFile(readFile(nationals));
    }

    public static void writeFile(List<National> nationals) throws IOException {
        File file = new File("src/ss16_text_file/exercise/read_file_csv/model/source.txt");
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
        for (National national : nationals) {
            bufferWriter.write(national.toString());
            bufferWriter.newLine();
        }
        bufferWriter.close();
    }

    public static List<National> readFile(List<National> national1) throws IOException {
        File file = new File("src/ss16_text_file/exercise/read_file_csv/model/source.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(fileReader);

        List<National> nationals = new ArrayList<>();

        String line;
        while ((line = buffReader.readLine()) != null) {
            if ("".equals(line)) {
                continue;
            }
            String[] info = line.split(",");
            National national = new National();
            national.setId(Integer.parseInt(info[0]));
            national.setCode(info[1]);
            national.setName(info[2]);
            nationals.add(national);

            System.out.println(line);
        }
        buffReader.close();
        return nationals;
    }
}
