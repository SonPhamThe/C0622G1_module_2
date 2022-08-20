package ss14_sort_algorithm.practice.illustration_bubble_sort;

import java.util.Scanner;

public class IllustrationBubbleSortController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of array");
        int size = Integer.parseInt(scan.nextLine());
        int[] array = new int[size];
        System.out.println("Enter " + size + " values: ");
        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(scan.nextLine());
        }
        System.out.println("Your input array: ");
        for (int i = 0; i < size; i++) {
            System.out.println(array[i] + "\t");
        }

        System.out.println("\n Begin sort processing....");
        bubbleSortByStep(array);
    }

    public static void bubbleSortByStep(int[] array) {
        boolean needNextPass;
        for (int k = 1; k < array.length; k++) {
            needNextPass = false;
            for (int i = 0; i < array.length - k; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    needNextPass = true;
                }
            }
            if (!needNextPass) {
                System.out.println("Array may be sorted and next pass not needed");
                break;
            }

            System.out.println("Array after the: " + k + " sort:");
            for (int j = 0; j < array.length; j++) {
                System.out.println(array[j] + "\t");
            }
            System.out.println();
        }
    }
}
