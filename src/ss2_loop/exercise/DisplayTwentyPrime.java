package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayTwentyPrime {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number to display Prime: ");
        int number = scan.nextInt();
        int count = 1;
        int i = 2;
        int j;
        int check;

        while (count <= number) {
            j = 1;
            check = 0;
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
