package ss12_java_collection_framework.practice.comparable_comparator.controller;

import ss12_java_collection_framework.practice.comparable_comparator.model.AgeComparator;
import ss12_java_collection_framework.practice.comparable_comparator.model.Student;

import java.util.ArrayList;
import java.util.List;

public class ComparatorController {
    public static void main(String[] args) {
        Student student = new Student("Son", 24, "USA");
        Student studentOne = new Student("Son", 24, "USA");
        Student studentTwo = new Student("Peter", 28, "Germany");

        List<Student> lists = new ArrayList<>();
        lists.add(student);
        lists.add(studentOne);
        lists.add(studentTwo);

        for (Student st : lists) {
            System.out.println(st.toString());
        }

        AgeComparator ageComparator = new AgeComparator();
        lists.sort(ageComparator);
        System.out.println("Compare age :");
        for (Student st : lists) {
            System.out.println(st.toString());
        }
    }
}

