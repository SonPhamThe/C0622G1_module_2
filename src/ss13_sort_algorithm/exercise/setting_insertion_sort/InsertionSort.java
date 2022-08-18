package ss13_sort_algorithm.exercise.setting_insertion_sort;

public class InsertionSort {
    static int[] array = {1, 5, 2, 18, 10, 12, 25, 19};

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
    }

    public static void main(String[] args) {
        insertionSort(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i] + " ");
        }
    }
}
