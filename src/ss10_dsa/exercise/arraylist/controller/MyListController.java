package ss10_dsa.exercise.arraylist.controller;

import ss10_dsa.exercise.arraylist.model.MyList;

public class MyListController {
    public static class Student {
        private int id;
        private String name;

        public Student() {
        }

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Student student1 = new Student(1, "danh");
        Student student2 = new Student(4, "giang");
        Student student3 = new Student(5, "vinh");
        Student student4 = new Student(6, "danh");
        Student student5 = new Student(7, "uy");

        MyList<Student> studentMyList = new MyList<>();

        studentMyList.add(student1);
        studentMyList.add(student2);
        studentMyList.add(student3);
        studentMyList.add(student4);
        studentMyList.add(student5);

        for (int i = 0; i < studentMyList.size(); i++) {
            Student student = (Student) studentMyList.elements[i];
            System.out.println(student.getId());
            System.out.println(student.getName());
        }
    }
}
