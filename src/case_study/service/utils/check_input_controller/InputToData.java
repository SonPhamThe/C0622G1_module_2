package case_study.service.utils.check_input_controller;

import java.util.Scanner;

public class InputToData {
    private static final Scanner scan = new Scanner(System.in);

    public static String inputToInteger() {
        while (true) {
            String chooseString = scan.nextLine();
            if(chooseString.matches("\\d+")) {
                return chooseString;
            } else {
                System.out.println("Input invalid");
            }
        }
    }
}
