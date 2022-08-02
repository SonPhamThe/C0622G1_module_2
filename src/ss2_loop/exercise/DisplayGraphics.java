package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayGraphics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Menu");
        System.out.println("1. Print the rectangle");
        System.out.println("2. Print the square triangle");
        System.out.println("3. Print isosceles triangle");
        System.out.println("0. Exit");
        System.out.println("Enter your choice: ");
        int choice = scan.nextInt();


        switch (choice) {
            case 1:
                for (int i = 1; i <= 3; i++) {
                    for (int j = 1; j <= 6; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 2:
                for (int i = 1; i <= 5; i++) {
                    for (int j = 1; j < i; j++) {
                        System.out.print(" * ");
                    }
                    System.out.println();
                }
                break;
            case 3:
                for (int i = 5; i >= 1; i--) {
                    for (int j = 1; j <= i; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                }
                break;
            case 4:
                System.exit(0);
                break;
            default:
                System.out.println("No one choice");
        }
    }
}
