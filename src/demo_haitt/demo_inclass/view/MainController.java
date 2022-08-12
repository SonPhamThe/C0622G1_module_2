package demo_haitt.demo_inclass.view;

import demo_haitt.demo_inclass.controller.StudentController;

public class MainController {
    public static void main(String[] args) {
        StudentController studentController = new StudentController();
        studentController.menuUser();
    }
}
