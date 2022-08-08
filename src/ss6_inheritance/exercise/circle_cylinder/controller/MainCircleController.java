package ss6_inheritance.exercise.circle_cylinder.controller;

import ss6_inheritance.exercise.circle_cylinder.model.Circle;
import ss6_inheritance.exercise.circle_cylinder.model.Cylinder;

public class MainCircleController {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(2.5, "red");
        System.out.println(circle);

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(4.0);
        System.out.println(cylinder);

        cylinder = new Cylinder(4.0, 2.5, "blue");
        System.out.println(cylinder);
    }
}
