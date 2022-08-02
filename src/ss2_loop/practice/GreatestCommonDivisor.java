package ss2_loop.practice;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number 1: ");
        int num1 = scan.nextInt();

        System.out.println("Enter number 2: ");
        int num2 = scan.nextInt();

        num1 = Math.abs(num1);
        num2 = Math.abs(num2);

        if (num1 == 0 || num2 == 0) {
            System.out.println("No greatest common factor");
        }

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        System.out.println("Greatest common factor: " + num1);
    }
}
