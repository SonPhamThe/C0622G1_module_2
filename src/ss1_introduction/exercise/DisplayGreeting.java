package ss1_introduction.exercise;

import java.util.Scanner;

public class DisplayGreeting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter greeting: ");
        String greeting = scanner.nextLine();
        System.out.println("Hello: " + greeting);
    }
}
