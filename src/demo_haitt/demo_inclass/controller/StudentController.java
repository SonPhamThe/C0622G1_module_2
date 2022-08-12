package demo_haitt.demo_inclass.controller;

import demo_haitt.demo_inclass.service.IStudent;
import demo_haitt.demo_inclass.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    private static final Scanner scan = new Scanner(System.in);

    private final IStudent studentService = new StudentService();

    public void menuUser() {
        while (true) {
            System.out.println("Please choose from the options");
            System.out.println("1. Add information students");
            System.out.println("2. Delete information students");
            System.out.println("3. Update information students");
            System.out.println("4. Search information students");
            System.out.println("5. Display information students");
            System.out.println("6. Exits");
            int choose = Integer.parseInt(scan.nextLine());
            switch (choose) {
                case 1:
                    studentService.addStudent();
                    break;
                case 2:
                    studentService.deleteStudent();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    studentService.displayListStudent();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 6");
            }
        }
    }
}
