package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Person;
import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.service.IStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scan = new Scanner(System.in);
    static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(5, "son", "12/04/1999", "male", "ab", 6));
        students.add(new Student(6, "vinh", "15/05/1999", "male", "ac", 9));
        students.add(new Student(7, "peter", "13/06/1999", "male", "ad", 8));
    }

    @Override
    public void displayStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    @Override
    public void addNewStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("Successful add");
    }

    @Override
    public void deleteStudent() {
        Student student = this.findStudent();
        if (student == null) {
            System.out.println("Not found student valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                students.remove(student);
                System.out.println("Successful is delete");
            }
        }
    }

    @Override
    public void sortScore() {
        System.out.println("Select sort by name from: " +
                "\n 1. Big to small" +
                "\n 2. Small to big" +
                "\n 3. Exit");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1:
                students.sort((a, b) -> (int) (b.getScore() - a.getScore()));
                System.out.println("Success sort");
                break;
            case 2:
                students.sort((a, b) -> (int) (a.getScore() - b.getScore()));
                System.out.println("Success sort");
                break;
            case 3:
                System.exit(0);
            default:
                System.out.println("Your selection is not suitable, selections from 1 to 3");
        }
    }

    @Override
    public void sortName() {
        System.out.println("Welcome to the programing");

        boolean needNextPass = true;
        for (int k = 0; k < students.size() - 1 && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < students.size() - 1 - k; i++) {

                if (students.get(i).getName().compareTo(students.get(i + 1).getName()) > 0) {
                    needNextPass = true;
                    Student temp = students.get(i + 1);
                    students.set(i + 1, students.get(i));
                    students.set(i, temp);
                }

            }
        }


        System.out.println("Success sort");
    }

    public Student findStudent() {
        System.out.println("Enter id student you want to find");
        int id = Integer.parseInt(scan.nextLine());
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public Student infoStudent() {
        int id;
        int count;

        do {
            count = 0;
            System.out.println("Enter id of Student");
            id = Integer.parseInt(scan.nextLine());
            for (Student student : students) {
                if (student.getId() == id) {
                    System.out.println("The id has been matched");
                    count++;
                }
            }
        } while (count != 0);

        System.out.println("Enter name of Student");
        String name = scan.nextLine();
        System.out.println("Enter day of birth of Student");
        String dayOfBirth = scan.nextLine();
        System.out.println("Enter gender of Student");
        String gender = scan.nextLine();
        System.out.println("Enter name class of Student");
        String nameClass = scan.nextLine();
        System.out.println("Enter score of Student");
        double score = Double.parseDouble(scan.nextLine());

        return new Student(id, name, dayOfBirth, gender, nameClass, score);
    }
}
