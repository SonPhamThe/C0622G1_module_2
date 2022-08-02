package ss2_loop.practice;

import java.util.Scanner;

public class CheckPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter my number to check ? ");
        int number = scanner.nextInt();
        int count = 0;

        if (number > 1) {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("Number is Prime");
            } else {
                System.out.println("Number isn't Prime");
            }
        } else {
            System.out.println("Number isn't Prime");
        }
    }
}

