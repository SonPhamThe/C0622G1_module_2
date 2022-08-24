package demo_haitt.demo_exercise1.controller;

import demo_haitt.demo_exercise1.service.IPerson;
import demo_haitt.demo_exercise1.service.IStudent;
import demo_haitt.demo_exercise1.service.ITeacher;
import demo_haitt.demo_exercise1.service.impl.PersonService;
import demo_haitt.demo_exercise1.service.impl.StudentService;
import demo_haitt.demo_exercise1.service.impl.TeacherService;

import java.io.IOException;
import java.util.Scanner;

public class PersonController {
    private static final Scanner scan = new Scanner(System.in);

    private static final IPerson person = new PersonService();
    private static final IStudent student = new StudentService();
    private static final ITeacher teacher = new TeacherService();

    public void menuUser() throws IOException {
        while (true) {
            System.out.println("Please choose from the options");
            System.out.println("1. Information of Student");
            System.out.println("2. Information of Teacher");
            System.out.println("3. Search of information");
            System.out.println("4. Sort of list Person");
            System.out.println("5. Edit of list Person");
            System.out.println("6. Exit All");
            int choice = Integer.parseInt(scan.nextLine());
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
                                case 2:
                                    student.displayStudentOptional();
                                    break;
                                case 3:
                                    menuUser();
                                    break;
                                default:
                                    System.out.println("Your selection is not suitable, selections from 1 to 3");
                            }
                            break;
                        case 2:
                            student.deleteStudent();
                            break;
                        case 3:
                            student.addNewStudent();
                            break;
                        case 4:
                            menuUser();
                            break;
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 2:
                    System.out.println("2.1. Display information teacher");
                    System.out.println("2.2. Delete information teacher");
                    System.out.println("2.3. Add information teacher");
                    System.out.println("2.4. Again menu to choice");
                    int chooseMenuTeacher = 0;
                    try {
                        chooseMenuTeacher = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a number");
                    }
                    switch (chooseMenuTeacher) {
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
                            menuUser();
                            break;
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 4");
                    }
                    break;
                case 3:
                    System.out.println("Choice option" +
                            "\n 1. Search for id" +
                            "\n 2. Search for name" +
                            "\n 3. Again menu to choice");
                    int chooseSearch = 0;
                    try {
                        chooseSearch = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a number");
                    }
                    switch (chooseSearch) {
                        case 1:
                            person.searchID();
                            break;
                        case 2:
                            person.searchName();
                            break;
                        case 3:
                            menuUser();
                            break;
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 3");
                    }
                    break;
                case 4:
                    System.out.println("Select option to sort" +
                            "\n 1. Sort the student by score" +
                            "\n 2. Sort the teacher by id" +
                            "\n 3. Sort the student by name" +
                            "\n 4. Sort the teacher by name:" +
                            "\n 5. Again menu to choice");
                    int chooseSort = 0;
                    try {
                        chooseSort = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Input must be a number");
                    }
                    switch (chooseSort) {
                        case 1:
                            student.sortScore();
                            break;
                        case 2:
                            teacher.sortID();
                            break;
                        case 3:
                            student.sortName();
                            break;
                        case 4:
                            teacher.sortName();
                            break;
                        case 5:
                            menuUser();
                            break;
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 5");
                    }
                    break;
                case 5:
                    System.out.println("6.1 Edit list Student" +
                            "\n 6.2 Edit list teacher" +
                            "\n 6.3 Back to menu" +
                            "\n 6.4 Exit");
                    int chooseEdit = 0;
                    try {
                        chooseEdit = Integer.parseInt(scan.nextLine());
                    } catch (NumberFormatException e) {
                        throw new RuntimeException(e);
                    }
                    switch (chooseEdit) {
                        case 1:
                            student.editStudent();
                            break;
                        case 6:
                            System.exit(0);
                        default:
                            System.out.println("Your selection is not suitable, selections from 1 to 3");
                    }
                    break;
            }
        }
    }
}