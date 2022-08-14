package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.service.IStudent;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudent {
    private static final Scanner scan = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

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
        if(student==null) {
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
        System.out.println("Enter id of Student");
        int id = Integer.parseInt(scan.nextLine());
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
