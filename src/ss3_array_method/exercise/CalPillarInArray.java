package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CalPillarInArray {
    public static void main(String[] args) {
        int line, pillar;
        int i, j;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter line of Array");
        line = scan.nextInt();
        System.out.println("Enter pillar of Array");
        pillar = scan.nextInt();

        int[][] array = new int[line][pillar];

        for (i = 0; i < line; i++) {
            for (j = 0; j < pillar; j++) {
                System.out.print("Enter element in line: " + i + " and pillar: " + j);
                array[i][j] = scan.nextInt();
            }
        }

        System.out.println("Array in add: " + Arrays.deepToString(array));

        System.out.println("Enter pillar, you want cal total this pillar");
        int inputPillar = scan.nextInt();
        int total = 0;

        for (i = 0; i < line; i++) {
            total += array[i][inputPillar];
        }

        System.out.println("This total pillar you want cal : "+total);
    }
}
