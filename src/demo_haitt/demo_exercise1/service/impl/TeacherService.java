package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.model.Teacher;
import demo_haitt.demo_exercise1.service.ITeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {

    private static final Scanner scan = new Scanner(System.in);

    private static List<Teacher> teachers = new ArrayList<>();

    @Override
    public void displayTeacher() {
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }

    @Override
    public void deleteTeacher() {
        Teacher teacher = this.findTeacher();
        if (teacher == null) {
            System.out.println("Not found teacher valid");
        } else {
            System.out.println("Are you sure want to delete");
            System.out.println("1. Yes, I'm sure\n2. No, I don't");
            int choice = Integer.parseInt(scan.nextLine());
            if (choice == 1) {
                teachers.remove(teacher);
                System.out.println("Successful is delete");
            }
        }

    }

    @Override
    public void addTeacher() {
        Teacher teacher = this.infoTeacher();
        teachers.add(teacher);
        System.out.println("Successful add");
    }

    public Teacher findTeacher() {
        System.out.println("Enter id student you want to find");
        int id = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return teachers.get(i);
            }
        }
        return null;
    }

    public Teacher infoTeacher() {
        System.out.println("Enter id of Teacher");
        int id = Integer.parseInt(scan.nextLine());
        System.out.println("Enter name of Teacher");
        String name = scan.nextLine();
        System.out.println("Enter day of birth of Teacher");
        String dayOfBirth = scan.nextLine();
        System.out.println("Enter gender of Teacher");
        String gender = scan.nextLine();
        System.out.println("Enter specialize of Teacher");
        String specialize = scan.nextLine();

        return new Teacher(id, name, dayOfBirth, gender, specialize);
    }
}
