package demo_mvc.service.impl;

import demo_mvc.model.Student;
import demo_mvc.service.IStudentService;

public class StudentService implements IStudentService {
    static Student[] students = new Student[100];
    static int size;

    static {
        students[0] = new Student(1, "Thanh Hai", 6);
        students[1] = new Student(2, "Mau Hoang", 7);
        students[2] = new Student(3, "Hoang Duy", 9);
        size = 3;
    }

    @Override
    public void showAll() {
        for (int i = 0; i < size; i++) {
            System.out.printf("Information student %d \n", i + 1);
            System.out.println(students[i].toString());
        }
    }
}
