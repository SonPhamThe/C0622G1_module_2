package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class FindMinElement {
    public static void main(String[] args) {
        int size;
        int i;

        Scanner scan = new Scanner(System.in);

        do {
            System.out.println("Enter size of Array");
            size = scan.nextInt();
            if (size <= 0) {
                System.out.println("Size is inappropriate");
            }
        } while (size <= 0);

        int[] array = new int[size];

        for (i = 0; i < size; i++) {
            System.out.println("Enter element: " + (i + 1));
            array[i] = scan.nextInt();
        }

        System.out.println("Array first is: " + Arrays.toString(array));

        int min = array[0];
        for (i = 1; i < size; i++) {
            if (min > array[i]) {
                min = array[i];
            }
        }

        System.out.println("Min of Array is: " + min);
    }
}
