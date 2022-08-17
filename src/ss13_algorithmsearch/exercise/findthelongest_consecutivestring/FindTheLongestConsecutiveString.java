package ss13_algorithmsearch.exercise.findthelongest_consecutivestring;

import java.util.LinkedList;
import java.util.Scanner;

public class FindTheLongestConsecutiveString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string to finding");
        String randomString = scanner.nextLine();
        System.out.println("String has length max: ");
        findMaxArray(randomString);
    }

    public static void findMaxArray(String str) {
        LinkedList<Character> max = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            LinkedList<Character> list = new LinkedList<>();
            list.add(str.charAt(i));
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(j) > list.getLast()) {
                    list.add(str.charAt(j));
                } else {
                    break;
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }
        for (Character linkedList : max) {
            System.out.print(linkedList);
        }
    }
}

