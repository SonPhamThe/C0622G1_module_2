package ss6_inheritance.practice.geometric.controller;

import ss6_inheritance.practice.geometric.model.Circle;

public class TestCircleController {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

         circle = new Circle(2.0);
        System.out.println(circle);

        circle = new Circle(3.5, "white", false);
        System.out.println(circle);
    }
}
