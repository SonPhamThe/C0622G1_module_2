package ss13_algorithmsearch.exercise.search_string.controller;

import ss13_algorithmsearch.exercise.search_string.model.SearchString;

import java.util.Scanner;

public class SearchStringController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string to search");
        String string = scanner.nextLine();

        System.out.println(searchString(string));
    }

    public static String searchString(String str) {
        String strings = "";
        String result = "";

        for (int i = 0; i < str.length() - 1; i++) {
            strings += str.charAt(i);
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > str.charAt(i)) {
                    strings += str.charAt(j);
                    i = j;
                }
            }
            result = strings.length() > result.length() ? strings : result;
            strings = "";
        }
        return result;
    }
}


