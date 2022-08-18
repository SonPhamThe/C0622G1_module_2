package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.model.Teacher;
import demo_haitt.demo_exercise1.service.ITeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {

    private static final Scanner scan = new Scanner(System.in);

    static final List<Teacher> teachers = new ArrayList<>();

    static {
        teachers.add(new Teacher(6, "bongNN", "23/4/1998", "male", "tutor"));
        teachers.add(new Teacher(4, "BaiTT", "25/5/1998", "male", "tutor"));
        teachers.add(new Teacher(8, "chanhTV", "27/6/1990", "male", "tutor"));
    }

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

    @Override
    public void sortID() {
        System.out.println("Select sort by id from: " +
                "\n 1. Big to small" +
                "\n 2. Small to big" +
                "\n 3. Exit");
        int choose = Integer.parseInt(scan.nextLine());
        switch (choose) {
            case 1:
                teachers.sort((a, b) -> (int) (b.getId() - a.getId()));
                System.out.println("Success sort");
                break;
            case 2:
                teachers.sort((a, b) -> (int) (a.getId() - b.getId()));
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

        for (int k = 0; k < teachers.size() - 1 && needNextPass; k++) {
            needNextPass = false;
            for (int i = 0; i < teachers.size() - 1 - k; i++) {
                if (teachers.get(i).getName().compareTo(teachers.get(i + 1).getName()) > 0) {
                    needNextPass = true;
                    Teacher temp = teachers.get(i + 1);
                    teachers.set(i + 1, teachers.get(i));
                    teachers.set(i, temp);
                }
            }
        }

        System.out.println("Success sort");
    }

    public Teacher findTeacher() {
        System.out.println("Enter id student you want to find");
        int id = Integer.parseInt(scan.nextLine());
        for (Teacher teacher : teachers) {
            if (teacher.getId() == id) {
                return teacher;
            }
        }
        return null;
    }

    public Teacher infoTeacher() {
        int id;
        int count;
        do {
            count = 0;
            System.out.println("Enter id of Teacher");
            id = Integer.parseInt(scan.nextLine());
            for (Teacher teacher : teachers) {
                if (teacher.getId() == id) {
                    System.out.println("The id has been matched");
                    count++;
                }
            }
        } while (count != 0);

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
