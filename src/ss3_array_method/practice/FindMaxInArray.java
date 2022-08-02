package ss3_array_method.practice;

import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        int size;
        int[] array;
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Enter size in Array");
            size = scan.nextInt();
            if (size > 20)
                System.out.println("Size should not exceed 20");
        } while (size > 20);

        array = new int[size];
        int i = 0;
        while (i < array.length) {
            System.out.println("Enter element " + (i + 1) + ":");
            array[i] = scan.nextInt();
            i++;
        }

        System.out.println("Property List: ");
        for (int j : array) {
            System.out.println(j + "\t");
        }

        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (max < array[j]) {
                max = array[j];
                index = j + 1;
            }
        }
        System.out.println("The largest property value in the list is " + max + ", at position " + index);
    }
}
