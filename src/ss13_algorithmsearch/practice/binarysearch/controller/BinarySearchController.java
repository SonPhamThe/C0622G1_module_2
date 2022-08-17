package ss13_algorithmsearch.practice.binarysearch.controller;

import ss13_algorithmsearch.practice.binarysearch.model.BinarySearch;

public class BinarySearchController {
    static int[] array = {1, 3, 5, 7, 9, 13, 14, 16, 18, 23, 25};

    public static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        while (high >= low) {
            int mid = (low + high) / 2;
            if (key < array[mid]) {
                high = mid - 1;
            } else if (key == mid) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(array, 2));
        System.out.println(binarySearch(array, 11));
        System.out.println(binarySearch(array, 79));
        System.out.println(binarySearch(array, 1));
        System.out.println(binarySearch(array, 5));
        System.out.println(binarySearch(array, 80));
    }
}
