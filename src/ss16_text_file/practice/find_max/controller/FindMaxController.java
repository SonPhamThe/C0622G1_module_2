package ss16_text_file.practice.find_max.controller;

import ss16_text_file.practice.find_max.model.FindMaxAndWrite;

import java.util.List;

public class FindMaxController {
    public static void main(String[] args) {
        FindMaxAndWrite readAndWrite = new FindMaxAndWrite();
        List<Integer> numbers = readAndWrite.readFile("src/ss16_text_file/practice/find_max/model/text.txt");
        int max = FindMaxAndWrite.findMax(numbers);
        readAndWrite.writeFile("src/ss16_text_file/practice/find_max/model/result.txt", max);
    }
}
