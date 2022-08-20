package ss14_sort_algorithm.practice.setting_selectiong_sort;

import java.util.Arrays;

public class SelectionSort {
    static double[] array = {1, 4, 6, -9.5, 5.5, -10};

    public static void selectionSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            double arrayMin = array[i];
            int arrayMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (arrayMin > array[j]) {
                    arrayMin = array[j];
                    arrayMinIndex = j;
                }
            }
            if (arrayMinIndex != i) {
                array[arrayMinIndex] = array[i];
                array[i] = arrayMin;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void main(String[] args) {
        selectionSort(array);
        for (int i = 0; i < args.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
