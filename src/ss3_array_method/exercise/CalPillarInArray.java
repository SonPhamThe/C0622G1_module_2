package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CalPillarInArray {
    public static void main(String[] args) {
        int line, pillar;
        int i, j;
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter line of Array");
        line = Integer.parseInt(scan.nextLine());
        System.out.println("Enter pillar of Array");
        pillar = Integer.parseInt(scan.nextLine());

        int[][] array = new int[line][pillar];

        for (i = 0; i < line; i++) {
            for (j = 0; j < pillar; j++) {
                System.out.print("Enter element in line: " + i + " and pillar: " + j);
                array[i][j] = Integer.parseInt(scan.nextLine());
            }
        }

        System.out.println("Array in add: " + Arrays.deepToString(array));

        System.out.println("Enter pillar, you want cal total this pillar");
        int inputPillar = Integer.parseInt(scan.nextLine());
        int total = 0;

        for (i = 0; i < line; i++) {
            total += array[i][inputPillar];
        }

        System.out.println("This total pillar you want cal : "+total);
    }
}
