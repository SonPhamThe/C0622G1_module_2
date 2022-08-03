package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {
    public static void main(String[] args) {
        int[] array1 = new int[10];
        int[] array2 = new int[5];
        int[] array3 = new int[15];
        Scanner scan = new Scanner(System.in);
        int i = 0;
        int j = 0;
        int k;
        int c = array1.length + array2.length;

        System.out.println("Input Array1");
        while (i < array1.length) {
            System.out.println("Enter elements " + (i + 1) + ": ");
            array1[i] = scan.nextInt();
            i++;
        }

        System.out.println("Input Array2");
        while (j < array2.length) {
            System.out.println("Enter elements " + (j + 1) + ": ");
            array2[j] = scan.nextInt();
            j++;
        }

        for (i = 0; i < array1.length; i++) {
            array3[i] = array1[i];
        }

        for (k = array1.length; k < c; k++) {
            array3[k] = array2[k - 10];
        }

        System.out.println(Arrays.toString(array3));
    }
}
