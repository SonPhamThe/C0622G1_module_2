package case_study.service.utils.check_input_controller;

import java.util.Scanner;

public class InputController {
    private static final Scanner scan = new Scanner(System.in);
    public static String inputToChoice() {
        while (true) {
            System.out.println("Enter input to choice menu");
            String chooseString = scan.nextLine();
            if(chooseString.matches("\\d+")) {
                return chooseString;
            } else {
                System.out.println("Input invalid");
            }
        }
    }
}
