package ss16_text_file.exercise.mvc.controller;

import ss16_text_file.exercise.mvc.service.IStudent;
import ss16_text_file.exercise.mvc.service.ITeacher;
import ss16_text_file.exercise.mvc.service.impl.StudentService;
import ss16_text_file.exercise.mvc.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class PersonController {
    private static final Scanner scan = new Scanner(System.in);
    private static final IStudent student = new StudentService();
    private static final ITeacher teacher = new TeacherService();

    public static void menuUser() throws IOException {
        while (true) {
            System.out.println("Please choose from the options");
            System.out.println("1. Information of Student");
            System.out.println("2. Information of Teacher");
            System.out.println("3. Search of information");
            System.out.println("4. Sort of list Person");
            System.out.println("5. Exit All");
            int choice = 0;
            try {
                choice = Integer.parseInt(scan.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Input must be a number");
            }
            switch (choice) {
                case 1:
                    System.out.println("1.1. Display information student");
                    System.out.println("1.2. Delete information student");
                    System.out.println("1.3. Add information student");
                    System.out.println("1.4. Again menu to choice");
                    int chooseMenuStudent = 0;
                    try {
                        chooseMenuStudent = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a number");
                    }
                    switch (chooseMenuStudent) {
                        case 1:
                            System.out.println("1.1.1.  Display information all of the student" +
                                    "\n 1.1.2. Display the students on the optional score" +
                                    "\n 1.1.3. Again menu to choice");
                            try {
                                chooseMenuStudent = Integer.parseInt(scan.nextLine());
                            } catch (NumberFormatException e) {
                                System.out.println("Input must be a number");
                            }
                            switch (chooseMenuStudent) {
                                case 1:
                                    student.displayStudent();
                                    break;
                            }
                    }
            }
        }
    }
}