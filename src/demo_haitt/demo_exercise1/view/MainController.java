package demo_haitt.demo_exercise1.view;

import demo_haitt.demo_exercise1.controller.PersonController;

import java.io.IOException;

public class MainController {
    public static void main(String[] args) throws IOException {
        PersonController person = new PersonController();
        person.menuUser();
    }
}
