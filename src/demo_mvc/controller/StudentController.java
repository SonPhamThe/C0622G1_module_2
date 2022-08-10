package demo_mvc.controller;

import demo_mvc.service.IStudentService;
import demo_mvc.service.impl.StudentService;

import java.util.Scanner;

public class StudentController {
    public void displayName() {
        Scanner scan = new Scanner(System.in);
        int choose;

        IStudentService iStudentService = new StudentService();
        while (true) {
            System.out.println("Please select function");
            System.out.println("1. Create new students ");
            System.out.println("2. Display list students ");
            System.out.println("3. Edit information students ");
            System.out.println("4. Delete students ");
            System.out.println("5. End");

            System.out.println("Please select function");
            choose = Integer.parseInt(scan.nextLine());

            switch (choose) {
                case 1:
                    break;
                case 2:
                    iStudentService.showAll();
                    break;
                case 3:
                case 4:
                case 5:
                    System.exit(0);
            }
        }
    }
}
