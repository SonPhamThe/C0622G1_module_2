package ss11_stack_queue.exercise.countthenumberworld.controller;

import java.util.*;

public class CountTheNumberWorldController {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input String to count");
        String inputString = scan.nextLine();
        inputString = inputString.toLowerCase().replace(" ","");

        Map<Character, Integer> stringMap = new LinkedHashMap<>();


        for (int i = 0; i < inputString.length(); i++) {
            if (stringMap.containsKey(inputString.charAt(i))) {
                Integer value = stringMap.get(inputString.charAt(i));
                value++;
                stringMap.replace(inputString.charAt(i), value);
            } else {
                stringMap.put(inputString.charAt(i), 1);
            }
        }


        for (Map.Entry<Character, Integer> entry : stringMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
