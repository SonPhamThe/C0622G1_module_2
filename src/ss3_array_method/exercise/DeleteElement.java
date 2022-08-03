package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 4, 6, 7, 8};
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter element is need in Array: ");
        int elementDel = scan.nextInt();

        int index = 0;
        int i, j;

        for (i = 0; i < array.length; i++) {
            if (array[i] == elementDel) {
                index = i;
            }
        }

        System.out.println("Element need delete in position: " + index);

        for (i = 0; i < array.length; i++) {
            if (array[i] == elementDel) {
                for (j = i; j < array.length-1; j++) {
                    array[j] = array[j + 1];
                }
                array[array.length - 1] = 0;
                i--;
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
