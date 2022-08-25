package ss18_string_regex.exercise.numberofphone.controller;

import ss18_string_regex.exercise.numberofphone.model.NumberOfPhone;

import java.util.Scanner;

public class NumberOfPhoneController {
    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter number of phone to check");
        String phone = scan.nextLine();
        NumberOfPhone numberOfPhone = new NumberOfPhone();
        if (numberOfPhone.checkNumberOf(phone)) {
            System.out.println("Number of phone is valid");
        } else {
            System.out.println("Number of phone is invalid");
        }
    }
}
