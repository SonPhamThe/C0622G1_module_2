package ss13_algorithmsearch.exercise.search_string.model;

import java.util.Scanner;

public class SearchString {
    public static String displayString(String string) {

        string = string.replace(" ", "");

        System.out.println("String you just entered: " + string);

        String strings = "";
        if (string.charAt(0) < string.charAt(1)) {
            strings += string.charAt(0);
        }

        for (int i = 0; i < string.length() - 1; i++) {
            if (string.charAt(i + 1) > string.charAt(i)) {
                strings += string.charAt(i);
            }
        }

        return strings;
    }
}
