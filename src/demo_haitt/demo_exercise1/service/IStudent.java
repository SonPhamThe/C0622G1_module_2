package demo_haitt.demo_exercise1.service;

import java.io.IOException;

public interface IStudent {
    void displayStudent() throws IOException;

    void addNewStudent() throws IOException;

    void deleteStudent();

    void sortScore() throws IOException;

    void sortName() throws IOException;

    void displayStudentOptional();

    void editStudent() throws IOException;
}
