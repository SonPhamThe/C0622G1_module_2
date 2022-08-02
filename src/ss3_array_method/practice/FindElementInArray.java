package ss3_array_method.practice;

import java.util.Scanner;

public class FindElementInArray {
    public static void main(String[] args) {
        String[] student = {"Ronaldo", "Messi", "Tobi", "Nadal", "Adam", "Eva"};
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a name's student:");
        String inputName = scan.nextLine();

        boolean isExist = false;
        for (int i = 0; i < student.length; i++) {
            if (student[i].equals(inputName)) {
                System.out.println("Position of the student in the list " + inputName + " is: " + i);
                isExist = true;
                break;
            }
        }
        if (!isExist)
            System.out.println("Not found " + inputName + " in the list");

    }
}
