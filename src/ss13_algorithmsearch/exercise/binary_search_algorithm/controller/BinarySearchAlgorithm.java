package ss13_algorithmsearch.exercise.binary_search_algorithm.controller;

import ss13_algorithmsearch.practice.binarysearch.model.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearchAlgorithm {
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
            System.out.println("Enter element of array[" + (i + 1) + "]");
            array[i] = Integer.parseInt(scan.nextLine());
        }

        System.out.println("Array after add element " + Arrays.toString(array));

        Arrays.sort(array);
        System.out.println("Array after sort"+ Arrays.toString(array));

        System.out.println("Input element to find in array");
        int result = Integer.parseInt(scan.nextLine());

        System.out.println("Element after find in the index: "+BinarySearchAlgorithm.binarySearch(array, 0, array.length - 1, result));
    }

    public static int binarySearch(int[] arr, int left, int right, int value) {
        if (right >= left) {
            int middle = (left + right) / 2;

            if (value == arr[middle]) {
                return middle;
            }

            if (value > arr[middle]) {
                return binarySearch(arr, middle + 1, right, value);
            }

            return binarySearch(arr, left, middle - 1, value);
        }

        return -1;
    }
}
