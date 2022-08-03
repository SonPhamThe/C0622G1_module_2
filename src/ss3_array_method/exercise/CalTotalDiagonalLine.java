package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CalTotalDiagonalLine {
    public static void main(String[] args) {
        int line, pillar;
        int i, j;
        int total = 0;
        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter line of Array");
            line = scan.nextInt();
            System.out.println("Enter pillar of Array");
            pillar = scan.nextInt();
            if (line != pillar)
                System.out.println("Enter again line and pillar");
        } while (line != pillar);

        int[][] array = new int[line][pillar];

        for (i = 0; i < line; i++) {
            for (j = 0; j < pillar; j++) {
                System.out.print("Enter element in line: " + i + " and pillar: " + j);
                array[i][j] = scan.nextInt();
            }
        }

        System.out.println("Array after enter: " + Arrays.deepToString(array));

        for (i = 0; i < line; i++) {
            for (j = 0; j < pillar; j++) {
                if (i == j) {
                    total += array[i][j];
                }
            }
        }

        System.out.println("Total diagonal line in this array: " + total);
    }
}
