package ss16_text_file.practice.total_number.controller;

import ss16_text_file.practice.total_number.model.TotalNumber;

import java.util.Scanner;

public class TotalNumberController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter file path");
        String path = scan.nextLine();

        TotalNumber total = new TotalNumber();
        total.readFileText(path);
    }
}
