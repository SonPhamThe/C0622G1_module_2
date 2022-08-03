package ss3_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 6, 7, 9};
        int index;
        int i;

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter element need add in Array");
        int inputElement = scan.nextInt();

        do {
            System.out.println("Enter index need add in Array");
            index = scan.nextInt();
            if (index <= -1 || index >= array.length) {
                System.out.println("Don't allow add in Array");
            }
        } while (index <= -1 || index >= array.length);

        for (i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = inputElement;

        System.out.println(Arrays.toString(array));

    }
}
