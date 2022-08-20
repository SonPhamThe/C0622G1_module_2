package ss14_sort_algorithm.practice.setting_bubble_sort;

public class SettingBubbleSort {
    static int[] array = {2, 4, 5, 6, 7, 12, 10, 24, -5, -10};

    public static void bubbleSort(int[] array) {
        for (int k = 1; k < array.length; k++) {
            for (int i = 0; i < array.length - k; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        bubbleSort(array);
        for (int arrays : array) {
            System.out.println(arrays + " ");
        }
    }
}
