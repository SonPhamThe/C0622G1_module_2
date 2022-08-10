package demo_mvc.view;

import demo_mvc.controller.StudentController;

public class StudentView {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.displayName();
    }
}
