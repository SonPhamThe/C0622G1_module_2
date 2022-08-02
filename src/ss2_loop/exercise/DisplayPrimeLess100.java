package ss2_loop.exercise;

import java.util.Scanner;

public class DisplayPrimeLess100 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter MaxPrime: ");
        int maxPrime = scan.nextInt();
        int i =2;

        while(i<=maxPrime) {
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
            }
            i++;
        }
    }
}
