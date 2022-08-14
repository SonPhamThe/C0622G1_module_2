package demo_haitt.demo_exercise1.controller;

import demo_haitt.demo_exercise1.service.IStudent;
import demo_haitt.demo_exercise1.service.ITeacher;
import demo_haitt.demo_exercise1.service.impl.StudentService;
import demo_haitt.demo_exercise1.service.impl.TeacherService;

import java.util.Scanner;

public class PersonController {
    private static final Scanner scan = new Scanner(System.in);
    private static final IStudent student = new StudentService();
    private static final ITeacher teacher = new TeacherService();

    public void menuUser() {
        while (true) {
            System.out.println("Please choose from the options");
            System.out.println("1. Information of Student");
            System.out.println("2. Information of Teacher");
            System.out.println("3. Exit All");
            int choice = Integer.parseInt(scan.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("1.1. Display information student");
                    System.out.println("1.2. Delete information student");
                    System.out.println("1.3. Add information student");
                    System.out.println("1.4. Exit");
                    choice = Integer.parseInt(scan.nextLine());
                    switch (choice) {
                        case 1:
                            student.displayStudent();
                            break;
                        case 2:
                            student.deleteStudent();
                            break;
                        case 3:
                            student.addNewStudent();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 2:
                    System.out.println("2.1. Display information teacher");
                    System.out.println("2.2. Delete information teacher");
                    System.out.println("2.3. Add information teacher");
                    System.out.println("2.4. Exit");
                    choice = Integer.parseInt(scan.nextLine());
                    switch (choice) {
                        case 1:
                            teacher.displayTeacher();
                            break;
                        case 2:
                            teacher.deleteTeacher();
                            break;
                        case 3:
                            teacher.addTeacher();
                            break;
                        case 4:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 3:
                    System.exit(0);
                default:
                    System.out.println("Your selection is not suitable, selections from 1 to 3");
            }
        }
    }
}
