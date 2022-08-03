package ss3_array_method.exercise;

import java.util.Scanner;

public class CountCharacter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String string = "the word is the best beautiful";
        System.out.println("Enter character is checking");
        char character = scan.nextLine().charAt(0);
        int i;
        int count = 0;

        for (i = 0; i < string.length(); i++) {
            if (string.charAt(i) == character) {
                count++;
            }
        }

        System.out.println("Character appear in String: " + count);
    }
}
