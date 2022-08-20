package ss14_sort_algorithm.exercise.illustration_insertion_sort;

import java.util.Arrays;
import java.util.Scanner;

public class Illustration_Insertion_Sort {
    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
        System.out.println("Array after insertion sort");
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;

        do {
            System.out.println("Enter size of array again");
            size = Integer.parseInt(scan.nextLine());
            if (size < 0) {
                System.out.println("Size invalid, size must be >0");
            }
        } while (size < 0);


        int[] array = new int[size];

        for (int i = 0; i < array.length; i++) {
            System.out.println("Enter element of array in index " + i);
            array[i] = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Array before insertion sort: ");
        System.out.println(Arrays.toString(array));

        insertionSort(array);

    }
}
