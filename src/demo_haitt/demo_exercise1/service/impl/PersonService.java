package demo_haitt.demo_exercise1.service.impl;

import demo_haitt.demo_exercise1.model.Person;
import demo_haitt.demo_exercise1.model.Student;
import demo_haitt.demo_exercise1.service.IPerson;
import demo_haitt.demo_exercise2.model.Vehicle;
import demo_haitt.demo_exercise2.service.impl.CarService;
import demo_haitt.demo_exercise2.service.impl.MotorBikeService;
import demo_haitt.demo_exercise2.service.impl.TruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService implements IPerson {
    private static final Scanner scan = new Scanner(System.in);

    @Override
    public void searchID() {
        System.out.println("Enter ID to search");
        int id = Integer.parseInt(scan.nextLine());
        List<Person> persons = new ArrayList<>();
        persons.addAll(StudentService.students);
        persons.addAll(TeacherService.teachers);

        List<Person> foundPersons = findPersonByID(persons, id);

        System.out.println(foundPersons);
    }

    @Override
    public void searchName() {
        System.out.println("Enter name to search");
        String name = scan.nextLine();
        List<Person> persons = new ArrayList<>();
        persons.addAll(StudentService.students);
        persons.addAll(TeacherService.teachers);

        List<Person> foundPersons = findPersonByName(persons, name);

        System.out.println(foundPersons);
    }

    private List<Person> findPersonByName(List<Person> persons, String name) {
        List<Person> foundPersons = new ArrayList<>();
        for (Person person : persons) {
            if (name.contains(person.getName())) {
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }

    private List<Person> findPersonByID(List<Person> persons, int id) {
        List<Person> foundPersons = new ArrayList<>();
        for (Person person : persons) {
            if (id == person.getId()) {
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }
}
