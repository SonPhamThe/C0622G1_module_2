package ss15_debug.pratice.arrayindexofboundexception;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class ArrayIndexOfBoundException {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x;

        ArrayIndexOfBoundException arrayExample = new ArrayIndexOfBoundException();
        int[] arr = arrayExample.arrayRandom();

        while (true) {
            try {
                System.out.println("Please enter random index of elements");
                x = Integer.parseInt(scan.nextLine());
                System.out.println("element of index " + x + ": " + arr[x]);
                break;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Index a invalid must >=0 & <" + arr.length);
            } catch (NumberFormatException e) {
                System.out.println("Index must be number not string");
            }
        }
    }

    public int[] arrayRandom() {
        Random random = new Random();
        int[] array = new int[100];

        System.out.println("Element of array: ");

        for (int i = 0; i < 100; i++) {
            array[i] = random.nextInt(100);
            System.out.println(array[i] + " ");
        }

        return array;
    }
}
