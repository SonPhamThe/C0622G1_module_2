package ss13_algorithmsearch.practice.complicatedcalculation;

import java.util.Scanner;

public class CalComplicated {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter a string");
        String inputString = scan.nextLine();

        int[] array = new int[255];
        for (int i = 0; i < inputString.length(); i++) {
            int ascii = inputString.charAt(i);
            array[ascii] += 1;
        }

        int max = 0;
        char character = (char) 255;
        for (int j = 0; j < 255; j++) {
           if(array[j]>max) {
               max = array[j];
               character = (char) j;
           }

            System.out.println("The most appearing letter is '" + character + "' with a frequency of " + max + " times");
        }
    }
}
