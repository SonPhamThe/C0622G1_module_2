package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayTwentyPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number to display Prime: ");
        int number = scan.nextInt();
        int count = 1;
        int i = 2;

        while (count <= number) {
            int j = 1;
            int check = 0;
            while (j <= i) {
                if (i % j == 0) {
                    check++;
                }
                j++;
            }
            if (check == 2) {
                System.out.print(i + "\t");
                count++;
            }
            i++;
        }

    }
}
