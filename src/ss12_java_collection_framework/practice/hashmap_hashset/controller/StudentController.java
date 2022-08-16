package ss12_java_collection_framework.practice.hashmap_hashset.controller;

import com.sun.source.tree.UsesTree;
import ss12_java_collection_framework.practice.hashmap_hashset.model.Student;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentController {
    public static void main(String[] args) {
        Student student = new Student("Son", 23, "USA");
        Student studentOne = new Student("Vinh", 23, "English");
        Student studentTwo = new Student("Peter", 23, "Germany");

        Map<Integer, Student> studentMap = new HashMap<>();
        studentMap.put(1, student);
        studentMap.put(2, studentOne);
        studentMap.put(3, studentTwo);

//        Set<Integer> integerSet = studentMap.keySet();
//
//        for (Integer item : integerSet) {
//            System.out.printf("%s,%s\n", item, studentMap.get(item));
//        }

        for (Map.Entry<Integer, Student> students : studentMap.entrySet()) {
            System.out.println(students.toString());
        }

        System.out.println("------------------------------------");

        Set<Student> students = new HashSet<>();
        students.add(student);
        students.add(studentOne);
        students.add(studentTwo);

        for (Student item : students) {
            System.out.println(item.toString()) ;
        }
    }
}
