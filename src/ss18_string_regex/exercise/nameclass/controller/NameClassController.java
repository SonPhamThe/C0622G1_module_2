package ss18_string_regex.exercise.nameclass.controller;

import ss18_string_regex.exercise.nameclass.model.NameClass;

import java.util.Scanner;

public class NameClassController {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter name class to check");
        String nameClass = scan.nextLine();
        NameClass check = new NameClass();
        if (check.checkNameClass(nameClass)) {
            System.out.println("Name class is valid");
        } else {
            System.out.println("Name class is invalid");
        }
    }
}
