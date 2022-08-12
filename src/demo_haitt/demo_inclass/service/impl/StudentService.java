package demo_haitt.demo_inclass.service.impl;

import demo_haitt.demo_inclass.model.Student;
import demo_haitt.demo_inclass.service.IStudent;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scan = new Scanner(System.in);

    private static final List<Student> students = new ArrayList<>();

    @Override
    public void addStudent() {
        Student student = this.infoStudent();
        students.add(student);
        System.out.println("You have successfully added");
    }

    @Override
    public void displayListStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
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

    public Student findStudent() {
        System.out.println("Please enter id. you want to find");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return students.get(i);
            }
        }
        return null;
    }

    public Student infoStudent() {
        System.out.println("Please enter id: ");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Please enter name: ");
        String name = scan.nextLine();
        System.out.println("Please enter dayOfBirth: ");
        String dayOfBirth = scan.nextLine();
        System.out.println("Please enter score: ");
        double score = Double.parseDouble(scan.nextLine());
        System.out.println("Please enter nameClass: ");
        String nameClass = scan.nextLine();

        /**
         * Student student = new Student(id, name, dayOfBirth, score, nameClass);
         * return student;
         */
        return new Student(id, name, dayOfBirth, score, nameClass);

    }
}
