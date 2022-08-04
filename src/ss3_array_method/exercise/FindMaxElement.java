package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxElement {
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

        System.out.println("Array after enter: " + Arrays.deepToString(array));

        int max = array[0][0];

        for (i = 0; i < line; i++) {
            for (j = 0; j < pillar; j++) {
                if (max < array[i][j]) {
                    max = array[i][j];
                }
            }
        }

        System.out.println("Element is smallest in Array: " + max);
    }
}
