package ss1_introduction.practice;

import java.util.Scanner;

public class CheckLeapYear {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter year to check: ");
        int year = scanner.nextInt();
        String checkLeapYear = (year % 4 == 0 && !(year % 100 == 0 && year % 400 != 0)) ? "Is Leap Year" : "Isn't Leap Year";
        System.out.println(checkLeapYear);
    }
}
